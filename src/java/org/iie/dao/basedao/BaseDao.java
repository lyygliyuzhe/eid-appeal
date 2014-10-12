package org.iie.dao.basedao;

import java.util.List;

import org.hibernate.Session;
import org.iie.vo.Pager;

/**
 * 其他DAO继承此类获取常用的数据库操作方法，基本上你能用到的方法这里都有了，不需要自己建立DAO了。
 *
 * @author zmc
 */
public interface BaseDao {

    /**
     * 根据给定的持久化对象,添加记录
     *
     * @param object
     */
    public void save(Object object);

    /**
     * 根据给定的持久化对象,删除记录
     *
     * @param object
     */
    public void delete(Object object);

    /**
     * 根据给定的持久化对象,更新记录
     *
     * @param object
     */
    public void update(Object object);

    /**
     * 执行HQL查询,返回查询的结果
     *
     * @param where
     * @return
     */
    public List find(String hql);

    /**
     * 执行HQL查询,占位符绑定参数
     *
     * @param hql
     * @param values
     * @return
     */
    public List find(String hql, Object[] values);

    /**
     * 通过主键ID返回一个数据对象
     *
     * @param object
     */
    public void saveOrUpdate(Object object);

    /**
     * 根据给定的对象,保存或更新对象
     *
     * @param cla
     * @param id
     * @return
     */
    public Object findById(Class cla, Integer id);

    /**
     * 获得Hibernate中的一个session
     *
     * @return
     */
    public Session openSession();
    //获得Hibernate中的session,并通过HQL更新数据

    /**
     *
     * @param hql 查询语句
     * @param page 当前页
     * @param rows 每页显示条数
     * @return Pager(存放总条数和查询结果)
     */
    public Pager getPager(String hql, int page, int rows);

    /**
     *
     * @param hql
     */
    public void update(String hql);
}
