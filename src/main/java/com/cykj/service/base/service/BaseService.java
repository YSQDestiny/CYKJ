package com.cykj.service.base.service;

import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/6/6 16:46.
 */
public interface BaseService <T extends Serializable> {

    /**
     * 返回HttpServletRequest
     *
     * @return Request
     * @author 杨仕其
     */
    public HttpServletRequest getRequest();

    /**
     * 返回上下文环境
     *
     * @return 上下文环境
     * @author 杨仕其
     */
    public WebApplicationContext getWebApplicationContext();

    /**
     * 返回域名
     *
     * @return 域名
     * @author 杨仕其
     */
    public String getBasePath();

    /**
     * 返回给定虚拟路径的真实路径
     *
     * @return 真实路径
     * @author 杨仕其
     */
    public String getRealPath();

    /**
     * 保存一个对象 如果返回null保存失败
     *
     * @param t
     *            对象
     * @return T 对象
     * @author 杨仕其
     */
    public T save(T t) throws Exception;

    /**
     * 保存或更新一个对象 如果返回null，修改或保存失败
     *
     * @param t
     *            对象
     * @return T对象
     * @author 杨仕其
     */
    public T saveOrUpdate(T t) throws Exception;

    /**
     * 更新一个对象 如果返回null，修改失败
     *
     * @param t
     *            对象
     * @return T 对象
     * @author 杨仕其
     */
    public T update(T t) throws Exception;

    /**
     * 删除一个对象 如果返回null删除失败
     *
     * @param t
     *            对象
     * @return T 对象
     * @author 杨仕其
     */
    public T delete(T t) throws Exception;

    /**
     * 通过主键获得对象
     *
     * @param c
     *            类名.class
     * @param id
     *            主键
     * @return T 对象
     * @author 杨仕其
     */
    public T getById(Class<T> c, Serializable id) throws Exception;

    /**
     * 分页查询对象列表
     *
     * @param c
     *            查询对象
     * @param pages
     *            分页参数，可以为null ,pages[0]起始页数，pages[1]显示行数
     * @return 结果集List<Map>
     * @author 杨仕其
     */
    public Map<String, Object> find(Class<T> c,
                                    Map<String, Object> whereParams, String orderBy, int... pages)
            throws Exception;

    /**
     * 分页查询对象列表
     *
     * @param c
     *            查询对象
     * @param whereParams
     *            参数（必须为统计对象的属性），可以为null
     * @param page
     *            分页参数，可以为null ,pages[0]起始页数，pages[1]显示行数
     * @param orderBy
     *            排序语句参数，可以为null
     * @return 结果集List<Map>
     */
    public Map<String, Object> find(Class<T> c, String whereSql,
                                    Map<String, Object> whereParams, String orderBy, int page, int rows)
            throws Exception;

    public List find(String hql, Map<String, Object> whereParams,
                     String orderBy, int page, int rows) throws Exception;


    public Long count(String hql, Map<String, Object> whereParams) throws Exception;

    /**
     * 统计数目
     *
     * @param c
     *            统计对象
     * @return BigInteger
     * @author 杨仕其
     */
    public BigInteger count(Class<T> c) throws Exception;


}
