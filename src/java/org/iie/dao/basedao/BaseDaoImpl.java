package org.iie.dao.basedao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.iie.vo.Pager;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {

    // 获得Hibernate中的一个session
    public Session openSession() {
        return SessionFactoryUtils.getSession(getSessionFactory(), true);
    }

    // 根据给定的对象,保存或更新对象
    public void saveOrUpdate(Object object) {
        getHibernateTemplate().saveOrUpdate(object);
    }

    // 根据给定的持久化对象,更新记录
    public void update(Object object) {
        getHibernateTemplate().update(object);
    }

    public void update(String hql) {
        openSession().createQuery(hql).executeUpdate();
    }

    // 根据给定的持久化对象,删除记录
    public void delete(Object object) {
        getHibernateTemplate().delete(object);
    }

    // 根据给定的持久化对象,添加记录
    public void save(Object object) {
        getHibernateTemplate().merge(object);
    }

    // 执行HQL查询,返回查询的结果
    public List find(String hql) {
        return getHibernateTemplate().find(hql);
    }

    //执行单个参数HQL条件查询
    public List find(String hql, Object value) {
        return getHibernateTemplate().find(hql, value);
    }

    //执行多个参数HQL条件查询
    public List find(String hql, Object[] values) {
        return getHibernateTemplate().find(hql, values);
    }

    // 通过主键ID返回一个数据对象
    public Object findById(Class cla, Integer id) {
        return getHibernateTemplate().get(cla, id);
    }

    //通过执行sql返回查询结果
    public List findObject(final String sql) {
        return getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session s) throws HibernateException,
                    SQLException {
                Query query = s.createSQLQuery(sql);
                List list = query.list();
                return list;
            }
        });
    }

    /**
     *
     * @param hql 查询语句
     * @param page 当前页
     * @param rows 每页显示条数
     * @return Pager(存放总条数和查询结果)
     */
    public Pager getPager(String hql, int page, int rows) {
        Pager pager = new Pager();
        List items = new ArrayList();

        Session session = this.openSession();
        Query query = session.createQuery(hql);

        pager.setTotalRows(query.list().size());

        query.setFirstResult((page - 1) * rows);
        query.setMaxResults(rows);
        items = query.list();
        pager.setElements(items);
        session.close();
        return pager;
    }
}
