/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.iie.dao.basedao.BaseDao;
import org.iie.po.LwbSpecial;
import org.iie.service.LwbSpecialService;
import org.iie.vo.Pager;

/**
 *
 * @author mc
 */
public class LwbSpecialServiceImpl implements LwbSpecialService {

    private BaseDao baseDao;

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public Pager getAll(int page, int rows) {
        Pager pager = new Pager();
        String hql = "from LwbSpecial";
        pager = baseDao.getPager(hql, page, rows);
        return pager;
    }


    @Override
    public void save(LwbSpecial lwbSpecial) {
        baseDao.save(lwbSpecial);
    }

    @Override
    public void update(LwbSpecial lwbSpecial) {
        baseDao.update(lwbSpecial);
    }

    @Override
    public void delete(int id) {
        LwbSpecial ls = (LwbSpecial) baseDao.find("from LwbSpecial where id =" + id).get(0);
        baseDao.delete(ls);
    }

    @Override
    public List<LwbSpecial> event() {
        List<LwbSpecial> list = new ArrayList<LwbSpecial>();
        String hql = "from LwbSpecial where status = '0'";
        list = baseDao.find(hql);
        return list;
    }
}
