package com.cykj.service.base.dao.impl;

import com.cykj.service.base.Constants;
import com.cykj.service.base.dao.BaseDao;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/6/6 16:33.
 */
@Repository("baseDao")
@SuppressWarnings("unchecked")
public class BaseDaoImpl <T extends Serializable> implements BaseDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 获得当前事物的session
     *
     * @return org.hibernate.Session
     */
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 保存一个对象 如果返回null保存失败
     *
     * @param t
     *            对象
     * @return T 对象
     */

    public T save(T t) throws Exception {
        if (t != null) {
            getCurrentSession().save(t);
        }
        return t;
    }

    /**
     * 保存一个对象集合List<T> 如果返回List<T>小于参数list，保存失败
     *
     * @param list
     *            对象集合
     * @return List<T>对象集合
     */
    public List<T> save(List<T> list) throws Exception {
        for (int index = 0; list != null && index < list.size(); index++) {
            T t = list.get(index);
            if (t != null) {
                save(t);
            }
        }
        return list;
    }

    /**
     * 保存或更新一个对象 如果返回null，修改或保存失败
     *
     * @param t
     *            对象
     * @return T对象
     */
    public T saveOrUpdate(T t) throws Exception {
        if (t != null) {
            getCurrentSession().merge(t);
        }
        return t;
    }

    /**
     * 更新一个对象 如果返回null，修改失败
     *
     * @param t
     *            对象
     * @return T 对象
     */
    public T update(T t) throws Exception {
        if (t != null) {
            getCurrentSession().update(t);
            getCurrentSession().flush();
        }
        return t;
    }

    /**
     * 更新对象 如果返回0，修改失败
     *
     * @param c
     *            对象
     * @param valueParams
     *            对象集合
     * @param whereParams
     *            对象集合
     * @return Integer 修改行数
     */
    public Integer update(Class<T> c, Map<String, Object> valueParams,
                          Map<String, Object> whereParams) throws Exception {
        StringBuffer hql = new StringBuffer("UPDATE " + c.getSimpleName()
                + " SET ");
        if (valueParams != null && !valueParams.isEmpty()) {
            for (String key : valueParams.keySet()) {
                hql.append(key + "=:" + key + ",");
            }
            hql = new StringBuffer(hql.substring(0, hql.length() - 1));
        }
        hql.append(" where 1=1 ");
        if (whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                hql.append(" and " + key + "=:" + key + "1");
                valueParams.put(key + "1", whereParams.get(key));
            }
        }
        Query q = getCurrentSession().createQuery(hql.toString());
        if (valueParams != null && !valueParams.isEmpty()) {
            for (String key : valueParams.keySet()) {
                q.setParameter(key, valueParams.get(key));
            }
        }
        return q.executeUpdate();
    }

    /**
     * 删除一个对象 如果返回null删除失败
     *
     * @param t
     *            对象
     * @return T 对象
     */
    public T delete(T t) throws Exception {
        if (t != null) {
            getCurrentSession().delete(t);
        }
        return t;
    }

    /**
     * 删除一个对象集合List<T> 如果返回List<T>小于参数list，删除失败
     *
     * @param list
     *            <T> 对象集合
     * @return List<Object>集合
     */
    public List<T> delete(List<T> list) throws Exception {
        for (int index = 0; list != null && index < list.size(); index++) {
            T t = list.get(index);
            if (t != null) {
                delete(t);
            }
        }
        return list;
    }

    /**
     * 删除对象 如果返回null，删除失败
     *
     * @param c
     *            类名.class
     * @param whereParams 条件参数集合
     * @return Integer 删除行数
     */
    public Integer delete(Class<T> c, Map<String, Object> whereParams)
            throws Exception {
        StringBuffer hql = new StringBuffer("delete from " + c.getSimpleName()
                + " where 1=1 ");
        if (whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                hql.append(" and " + key + "=:" + key + "1");
            }
        }
        Query q = getCurrentSession().createQuery(hql.toString());
        if (whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                q.setParameter(key, whereParams.get(key));
            }
        }
        return q.executeUpdate();
    }

    /**
     * 删除对象 如果返回0，删除失败
     *
     * @param sql
     *            SQL语句
     * @return Integer 删除行数
     */
    public Integer deleteBySql(String sql) throws Exception {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        return q.executeUpdate();
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
        return (T) getCurrentSession().get(c, id);
    }

    /**
     * 分页查询对象列表
     *
     * @param c
     *            查询对象
     * @param whereParams
     *            参数（必须为统计对象的属性），可以为null
     * @param orderBy
     *            排序语句参数，可以为null
     * @param pages
     *            分页参数，可以为null ,pages[0]起始页数，pages[1]显示行数
     * @return 结果集List<Map>
     */
    public Map<String,Object> find(Class<T> c, Map<String, Object> whereParams,
                                   String orderBy, int... pages) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        StringBuffer hqlcount = new StringBuffer("select count(*) FROM " + c.getSimpleName()
                + " WHERE 1 = 1");
        if (whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                hqlcount.append(" and " + key + "=:" + key);
            }
        }
        Query qc = getCurrentSession().createQuery(hqlcount.toString());
        if (whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                qc.setParameter(key, whereParams.get(key));
            }
        }
        map.put(Constants.TOTALS, qc.uniqueResult());

        StringBuffer hql = new StringBuffer("FROM " + c.getSimpleName()
                + " WHERE 1 = 1");
        if (whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                hql.append(" and " + key + "=:" + key);
            }
        }
        if (StringUtils.isNotEmpty(orderBy)) {
            hql.append(" ORDER BY " + orderBy);
        }
        Query q = getCurrentSession().createQuery(hql.toString());
        if (whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                q.setParameter(key, whereParams.get(key));
            }
        }
        if (pages != null && pages.length > 1) {
            map.put(Constants.ROWS,  q.setFirstResult((pages[0] - 1) * pages[1])
                    .setMaxResults(pages[1])
                    .list());
        }
        return map;
    }


    /**
     * 分页查询对象列表
     *
     * @param c
     *            查询对象
     * @param whereSql 查询条件
     *
     * @param whereParams
     *            参数（必须为统计对象的属性），可以为null
     * @param orderBy
     *            排序语句参数，可以为null
     * @param page
     *            分页参数，可以为null ,pages[0]起始页数，pages[1]显示行数
     * @return 结果集 Map
     */
    public Map<String,Object> find(Class<T> c, String whereSql, Map<String, Object> whereParams,
                                   String orderBy, int page , int rows) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        StringBuffer hqlcount = new StringBuffer("select count(*) FROM " + c.getSimpleName() + " WHERE 1 = 1 ");
        if (StringUtils.isNotBlank(whereSql)&&whereParams != null && !whereParams.isEmpty()) {
            hqlcount.append(whereSql);
        }
        Query qc = getCurrentSession().createQuery(hqlcount.toString());
        if (StringUtils.isNotBlank(whereSql)&&whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                Object obj = whereParams.get(key);
                //这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if(obj instanceof Collection<?>){
                    qc.setParameterList(key, (Collection<?>)obj);
                }else if(obj instanceof Object[]){
                    qc.setParameterList(key, (Object[])obj);
                }else{
                    qc.setParameter(key, obj);
                }
            }
        }
        map.put(Constants.TOTALS, qc.uniqueResult());

        StringBuffer hql = new StringBuffer("FROM " + c.getSimpleName() + " WHERE 1 = 1");
        if (StringUtils.isNotBlank(whereSql)&&whereParams != null && !whereParams.isEmpty()) {
            hql.append(whereSql);
        }
        if (StringUtils.isNotEmpty(orderBy)) {
            hql.append(" ORDER BY " + orderBy);
        }
        Query q = getCurrentSession().createQuery(hql.toString());
        if (StringUtils.isNotBlank(whereSql)&&whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                Object obj = whereParams.get(key);
                //这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if(obj instanceof Collection<?>){
                    q.setParameterList(key, (Collection<?>)obj);
                }else if(obj instanceof Object[]){
                    q.setParameterList(key, (Object[])obj);
                }else{
                    q.setParameter(key, obj);
                }
            }
        }
        if (page > 0 && rows > 1) {
            q.setFirstResult((page - 1) * rows).setMaxResults(rows);
        }
        map.put(Constants.ROWS,q.list());
        return map;
    }

    /**
     * 获得结果集
     *
     * @param sql
     *            SQL语句
     * @param pages
     *            分页参数，可以为null ,pages[0]起始页数，pages[1]显示行数
     * @return 结果集List<Map>
     */
    public List<?> findBySql(String sql, int... pages) throws Exception {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        if (pages != null && pages.length > 1) {
            return q.setFirstResult((pages[0] - 1) * pages[1])
                    .setMaxResults(pages[1])
                    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                    .list();
        }
        return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    /**
     * 统计数目
     *
     * @param c
     *            统计对象
     * @param whereParams
     *            参数（必须为统计对象的属性），可以为null
     * @return Long
     */
    public BigInteger count(Class<T> c, Map<String, Object> whereParams)
            throws Exception {
        String hql = "SELECT count(*) FROM " + c.getSimpleName() + " WHERE 1=1";
        Query q = getCurrentSession().createQuery(hql);
        if (whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                hql += " and " + key + "=:" + key;
            }
        }
        if (whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                q.setParameter(key, whereParams.get(key));
            }
        }
        return (BigInteger) q.uniqueResult();

    }

    /**
     * 统计数目
     *
     * @param sql
     *            SQL语句
     * @return long
     */
    public BigInteger countBySql(String sql) throws Exception {
        SQLQuery q = getCurrentSession().createSQLQuery(sql);
        return (BigInteger) q.uniqueResult();
    }

    public List find(String hql, Map<String, Object> whereParams, String orderBy, int page, int rows) {
        if (StringUtils.isNotEmpty(orderBy)) {
            hql += " ORDER BY " + orderBy;
        }
        Query q = getCurrentSession().createQuery(hql);
        if (whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                Object obj = whereParams.get(key);
                //这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if(obj instanceof Collection<?>){
                    q.setParameterList(key, (Collection<?>)obj);
                }else if(obj instanceof Object[]){
                    q.setParameterList(key, (Object[])obj);
                }else{
                    q.setParameter(key, obj);
                }
            }
        }
        if (page > 0 && rows > 1) {
            q.setFirstResult((page - 1) * rows).setMaxResults(rows);
        }
        return q.list();
    }

    public Long count(String hql, Map<String, Object> whereParams) {
        Query q = getCurrentSession().createQuery(hql);
        if (whereParams != null && !whereParams.isEmpty()) {
            for (String key : whereParams.keySet()) {
                Object obj = whereParams.get(key);
                //这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if(obj instanceof Collection<?>){
                    q.setParameterList(key, (Collection<?>)obj);
                }else if(obj instanceof Object[]){
                    q.setParameterList(key, (Object[])obj);
                }else{
                    q.setParameter(key, obj);
                }
            }
        }
        return (Long)q.uniqueResult();
    }}
