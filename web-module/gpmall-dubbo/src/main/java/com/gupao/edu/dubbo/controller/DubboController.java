package com.gupao.edu.dubbo.controller;

import com.alibaba.fastjson.JSON;
import com.gupao.edu.dubbo.request.HttpRequest;
import com.gupao.edu.dubbo.request.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/12/4
 */
public class DubboController implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(DubboController.class);

    private final Map<String, Class<?>> cacheMap = new HashMap();


    protected ApplicationContext applicationContext;


    @ResponseBody
    @RequestMapping(value = {"/{service}/{method}"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    public String api(HttpRequest httpRequest, HttpServletRequest request, @RequestParam Map<String, String> map, @PathVariable String service, @PathVariable String method) {

        logger.debug("ip:{}-httpRequest:{}", getIP(request), JSON.toJSONString(httpRequest));

        String invoke = invoke(httpRequest, service, method, map);
        logger.debug("callback :" + invoke);
        return invoke;
    }


    private String invoke(HttpRequest httpRequest, String service, String method, Map<String, String> map) {
        httpRequest.setService(service);
        httpRequest.setMethod(method);

        HttpResponse response = new HttpResponse();

        logger.debug("input param:" + JSON.toJSONString(httpRequest));

       /* if (!CollectionUtils.isEmpty(httpProviderConf.getUsePackage())) {
            boolean isPac = false;
            for (String pac : httpProviderConf.getUsePackage()) {
                if (service.startsWith(pac)) {
                    isPac = true;
                    break;
                }
            }
            if (!isPac) {
                logger.error("service is not correct,service=" + service);
                response.setCode("2");
                response.setSuccess(false);
                response.setDescription("service is not correct,service=" + service);
            }
        }*/
        try {
            Class<?> serviceCla = (Class) cacheMap.get(service);
            if (serviceCla == null) {
                serviceCla = Class.forName(service);
                logger.debug("serviceCla:" + JSON.toJSONString(serviceCla));


                cacheMap.put(service, serviceCla);
            }
            Method[] methods = serviceCla.getMethods();
            Method targetMethod = null;
            for (Method m : methods) {
                if (m.getName().equals(method)) {
                    targetMethod = m;
                    break;
                }
            }

            if (method == null) {
                logger.error("method is not correct,method=" + method);
                response.setCode("2");
                response.setSuccess(false);
                response.setDescription("method is not correct,method=" + method);
            }

            Object bean = applicationContext.getBean(serviceCla);
            Object result = null;
            Class<?>[] parameterTypes = targetMethod.getParameterTypes();
            if (parameterTypes.length == 0) {
                result = targetMethod.invoke(bean, new Object[0]);
            } /*else if (parameterTypes.length == 1) {
        Object json = JSON.parseObject(httpRequest.getParam(), parameterTypes[0]);
        result = targetMethod.invoke(bean, new Object[] { json });
      } */ else {

                result = targetMethod.invoke(bean, map);
                logger.info("Can  have map parameter");
                response.setSuccess(true);
                response.setCode("1");
                response.setDescription("Can only have one parameter");
            }
            return JSON.toJSONString(result);
        } catch (ClassNotFoundException e) {
            logger.error("class not found", e);
            response.setSuccess(false);
            response.setCode("2");
            response.setDescription("class not found");
        } catch (InvocationTargetException e) {
            logger.error("InvocationTargetException", e);
            response.setSuccess(false);
            response.setCode("2");
            response.setDescription("InvocationTargetException");
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccessException", e);
            response.setSuccess(false);
            response.setCode("2");
            response.setDescription("IllegalAccessException");
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return JSON.toJSONString(response);
    }


    private String getIP(HttpServletRequest request) {
        if (request == null)
            return null;
        String s = request.getHeader("X-Forwarded-For");
        if ((s == null) || (s.length() == 0) || ("unknown".equalsIgnoreCase(s))) {
            s = request.getHeader("Proxy-Client-IP");
        }
        if ((s == null) || (s.length() == 0) || ("unknown".equalsIgnoreCase(s))) {
            s = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((s == null) || (s.length() == 0) || ("unknown".equalsIgnoreCase(s))) {
            s = request.getHeader("HTTP_CLIENT_IP");
        }
        if ((s == null) || (s.length() == 0) || ("unknown".equalsIgnoreCase(s))) {
            s = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if ((s == null) || (s.length() == 0) || ("unknown".equalsIgnoreCase(s))) {
            s = request.getRemoteAddr();
        }
        if (("127.0.0.1".equals(s)) || ("0:0:0:0:0:0:0:1".equals(s)))
            try {
                s = InetAddress.getLocalHost().getHostAddress();
            } catch (Exception unknownhostexception) {
                return "";
            }
        return s;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
