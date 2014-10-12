/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service.impl;

import org.iie.dao.basedao.BaseDao;
import org.iie.service.LwbSortService;
import org.iie.vo.Pager;

/**
 *
 * @author mc
 */
public class LwbSortServiceImpl implements LwbSortService {

    private BaseDao baseDao;

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public Pager getAll(String page, String rows, String sort) {
        Pager pager = new Pager();
        String hql = "from LwbCategory where category = '" + sort + "'";
        pager = baseDao.getPager(hql, Integer.parseInt(page), Integer.parseInt(rows));
        return pager;
    }

    @Override
    public void update(String id, String category) {
        String hql = "update LwbCategory l set l.category='" + category + "' where l.id='" + id + "'";
        baseDao.update(hql);
    }
}
