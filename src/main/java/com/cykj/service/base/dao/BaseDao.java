package com.cykj.service.base.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/6/6 16:32.
 */
public interface BaseDao<T extends Serializable> {


    /**
     * 保存一个对象 如果返回null保存失败
     *
     * @param t 对象
     * @return T 对象
     */
    public T save(T t) throws Exception;

    /**
     * 保存一个对象集合List<T> 如果返回List<T>小于参数list，保存失败
     *
     * @param list 对象集合
     * @return List<T>对象集合
     */
    public List<T> save(List<T> list) throws Exception;

    /**
     * 保存或更新一个对象 如果返回null，修改或保存失败
     *
     * @param t 对象
     * @return T对象
     */
    public T saveOrUpdate(T t) throws Exception;

    /**
     * 更新一个对象 如果返回null，修改失败
     *
     * @param t 对象
     * @return T 对象
     */
    public T update(T t) throws Exception;

    /**
     * 更新对象 如果返回0，修改失败
     *
     * @param c           对象
     * @param valueParams 对象集合
     * @param whereParams 对象集合
     * @return Integer 修改行数
     */
    public Integer update(Class<T> c, Map<String, Object> valueParams,
                          Map<String, Object> whereParams) throws Exception;

    /**
     * 删除一个对象 如果返回null删除失败
     *
     * @param t 对象
     * @return T 对象
     */
    public T delete(T t) throws Exception;

    /**
     * 删除一个对象集合List<T> 如果返回List<T>小于参数list，删除失败
     *
     * @param list <T> 对象集合
     * @return List<Object>集合
     */
    public List<T> delete(List<T> list) throws Exception;

    /**
     * 删除对象 如果返回null，删除失败
     *
     * @param c                 类名.class
     * @param whereParams 条件参数集合
     * @return Integer 删除行数
     */
    public Integer delete(Class<T> c, Map<String, Object> whereParams)
            throws Exception;

    /**
     * 删除对象 如果返回0，删除失败
     *
     * @param sql SQL语句
     * @return Integer 删除行数
     */
    public Integer deleteBySql(String sql) throws Exception;

    /**
     * 通过主键获得对象
     *
     * @param c  类名.class
     * @param id 主键
     * @return T 对象
     */
    public T getById(Class<T> c, Serializable id) throws Exception;

    /**
     * 分页查询对象列表
     *
     * @param c           查询对象
     * @param whereParams 参数（必须为统计对象的属性），可以为null
     * @param pages       分页参数，可以为null ,pages[0]起始页数，pages[1]显示行数
     * @param orderBy     排序语句参数，可以为null
     * @return 结果集List<Map>
     */
    public Map<String, Object> find(Class<T> c, Map<String, Object> whereParams,
                                    String orderBy, int... pages) throws Exception;

    /**
     * 分页查询对象列表
     *
     * @param c           查询对象
     * @param whereParams 参数（必须为统计对象的属性），可以为null
     * @param page       分页参数，可以为null ,pages[0]起始页数，pages[1]显示行数
     * @param orderBy     排序语句参数，可以为null
     * @return 结果集List<Map>
     */
    public Map<String, Object> find(Class<T> c, String whereSql, Map<String, Object> whereParams,
                                    String orderBy, int page, int rows) throws Exception;

    /**
     * 获得结果集
     *
     * @param sql   SQL语句
     * @param pages 分页参数，可以为null ,pages[0]起始页数，pages[1]显示行数
     * @return 结果集List<Map>
     */
    public List<?> findBySql(String sql, int... pages) throws Exception;

    /**
     * 统计数目
     *
     * @param c           统计对象
     * @param whereParams 参数（必须为统计对象的属性），可以为null
     * @return BigInteger
     */
    public BigInteger count(Class<T> c, Map<String, Object> whereParams)
            throws Exception;

    /**
     * 统计数目
     *
     * @param sql SQL语句
     * @return BigInteger
     */
    public BigInteger countBySql(String sql) throws Exception;

    public List find(String hql, Map<String, Object> whereParams,
                     String orderBy, int page, int rows);

    public Long count(String hql, Map<String, Object> whereParams);
}
