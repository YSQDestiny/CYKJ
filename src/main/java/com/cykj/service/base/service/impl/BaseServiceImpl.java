package com.cykj.service.base.service.impl;

import com.cykj.service.base.dao.BaseDao;
import com.cykj.service.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/6/6 16:47.
 */
@Service("baseService")
public class BaseServiceImpl<T extends Serializable> implements BaseService<T> {

    @Autowired
    @Qualifier("baseDao")
    private BaseDao<T> baseDao;

    /**
     * 返回HttpServletRequest
     *
     * @return Request
     */
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
    }

    /**
     * 返回上下文环境
     *
     * @return 上下文环境
     */
    public WebApplicationContext getWebApplicationContext() {
        WebApplicationContext webApplicationContext = ContextLoader
                .getCurrentWebApplicationContext();
        return webApplicationContext;
    }

    /**
     * 返回域名
     *
     * @return 域名
     */
    public String getBasePath() {
        String basePath = getRequest().getScheme() + "://"
                + getRequest().getServerName() + "/";
        return basePath;
    }

    /**
     * 返回给定虚拟路径的真实路径
     *
     * @return 真实路径
     */
    public String getRealPath() {
        String realPath = getRequest().getSession().getServletContext()
                .getRealPath("/");
        realPath = realPath.replace("\\", "/");
        return realPath;
    }

    /**
     * 保存一个对象 如果返回null保存失败
     *
     * @param t
     *            对象
     * @return T 对象
     */
    public T save(T t) throws Exception {
        return (T) baseDao.save(t);
    }

    /**
     * 保存或更新一个对象 如果返回null，修改或保存失败
     *
     * @param t
     *            对象
     * @return T对象
     */
    public T saveOrUpdate(T t) throws Exception {
        return (T) baseDao.saveOrUpdate(t);
    }

    /**
     * 更新一个对象 如果返回null，修改失败
     *
     * @param t
     *            对象
     * @return T 对象
     */
    public T update(T t) throws Exception {
        return (T) baseDao.update(t);
    }

    /**
     * 删除一个对象 如果返回null删除失败
     *
     * @param t
     *            对象
     * @return T 对象
     */
    public T delete(T t) throws Exception {
        return (T) baseDao.delete(t);
    }

    /**
     * 通过主键获得对象
     *
     * @param c
     *            类名.class
     * @param id
     *            主键
     * @return T 对象
     */
    public T getById(Class<T> c, Serializable id) throws Exception {
        return (T) baseDao.getById(c, id);
    }

    /**
     * 分页查询对象列表
     *
     * @param c
     *            查询对象
     * @param pages
     *            分页参数，可以为null ,pages[0]起始页数，pages[1]显示行数
     * @return 结果集List<Map>
     */
    public Map<String,Object> find(Class<T> c, Map<String, Object> whereParams,
                                   String orderBy, int... pages) throws Exception {
        return baseDao.find(c, whereParams, orderBy, pages);
    }

    /**
     * 统计数目
     *
     * @param c
     *            统计对象
     * @return BigInteger
     */
    public BigInteger count(Class<T> c) throws Exception {
        return baseDao.count(c, null);
    }

    public Map<String, Object> find(Class<T> c, String whereSql,
                                    Map<String, Object> whereParams, String orderBy, int page, int rows)
            throws Exception {
        return baseDao.find(c, whereSql, whereParams, orderBy, page, rows);
    }

    public List find(String hql, Map<String, Object> whereParams,
                     String orderBy, int page, int rows) throws Exception {
        return baseDao.find(hql,whereParams,orderBy,page,rows);
    }

    public Long count(String hql, Map<String, Object> whereParams)
            throws Exception {
        return baseDao.count(hql, whereParams);
    }

}
