package com.gupao.edu.mq.convert;

import com.gupao.edu.serviceext.common.utils.GPJsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/12/18
 */
@Component("fastJsonMessageConverter")
public class FastJsonMessageConverter extends AbstractMessageConverter {

    private static Logger logger = LoggerFactory.getLogger(FastJsonMessageConverter.class);

    public static final String DEFAULT_CHARSET = "UTF-8";

    private volatile String defaultCharset = DEFAULT_CHARSET;

    public FastJsonMessageConverter() {
        super();
    }

    public void setDefaultCharset(String defaultCharset) {
        this.defaultCharset = (defaultCharset != null) ? defaultCharset
                : DEFAULT_CHARSET;
    }

    public Object fromMessage(Message message)
            throws MessageConversionException {
        return null;
    }

    public <T> T fromMessage(Message message, T t) {
        String json = "";
        try {
            json = new String(message.getBody(), defaultCharset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return (T) GPJsonUtils.json2Object(json, t.getClass());
    }


    protected Message createMessage(Object objectToConvert,
                                    MessageProperties messageProperties)
            throws MessageConversionException {
        byte[] bytes = null;
        try {
            String jsonString = GPJsonUtils.toJson(objectToConvert);
            bytes = jsonString.getBytes(this.defaultCharset);
        } catch (UnsupportedEncodingException e) {
            throw new MessageConversionException(
                    "Failed to convert Message content", e);
        }
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setContentEncoding(this.defaultCharset);
        if (bytes != null) {
            messageProperties.setContentLength(bytes.length);
        }
        return new Message(bytes, messageProperties);

    }
}
