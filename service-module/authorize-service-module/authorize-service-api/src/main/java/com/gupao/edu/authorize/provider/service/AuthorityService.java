package com.gupao.edu.authorize.provider.service;


import com.gupao.edu.authorize.metadata.AuthType;
import com.gupao.edu.authorize.vo.AuthDetailBean;
import com.gupao.edu.authorize.vo.auth.AuthorityBean;
import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.List;

/**
 * 功能说明：<br/>
 * 权限编码与资源的检索与更新，当执行新增、更新、删除操作时需要同时更新其对应的缓存信息，查询时进行缓存
 * </br>
 * 开发时间：2015年3月4日<br/>
 */
public interface AuthorityService {

    /**
     * 新增一条权限编码信息，信息中必须包含<code>obid</code>字段，该字段与权限资源中的id对应
     *
     * @param entity
     */
    void addAuthority(AuthorityBean entity);

    /**
     * 保存权限与角色的关联关系<br/>
     * 如果权限类型是{@link AuthType#MENU}，则将菜单下关联的页面权限也进行关联
     *
     * @param roleId
     * @param authId
     */
    void saveAuthorityRoleRelation(String roleId, String authId);

    /**
     * 根据主键（obid）进行数据更新
     *
     * @param entity
     */
    void modifyAuthority(AuthorityBean entity);

    /**
     * 移除一条权限配置信息,同时移除权限配置与角色之间的关联关系
     *
     * @param obid
     */
    void removeAuthority(String obid);

    /**
     * 检索全部的权限配置信息，还包括权限信息的扩展内容（对应资源的判断标准）
     *
     * @return 权限配置详细信息，返回信息将进行缓存
     */
    List<AuthDetailBean> getAuthDetailInfos();

    /**
     * 获取当前配置中的全部权限信息
     *
     * @return spring security可识别的权限信息，在系统初始运行时进行验证
     */
    Collection<ConfigAttribute> getAllConfigAttributes();

    /**
     * 获取指定类型的权限信息
     *
     * @param type 权限类型
     * @return
     */
    List<AuthDetailBean> getAuthDetailByType(AuthType type);

    /**
     * 获取权限的spring security封装对象
     *
     * @param type       权限的类型
     * @param resourceId 资源ID
     * @return spring security权限配置封装对象
     */
    ConfigAttribute findAuthAttribute(AuthType type, String resourceId);

    /**
     * 获取用户拥有的全部权限信息,查询结果将进行缓存
     *
     * @param userName 用户名
     * @return 用户拥有的权限对象
     */
    List<String> getUserAuthorities(String userName);
}
