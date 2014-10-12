/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.iie.dao.basedao.BaseDao;
import org.iie.po.LwbSpread;
import org.iie.service.LwbSpreadService;

/**
 *
 * @author mc
 */
public class LwbSpreadServiceImpl implements LwbSpreadService {

    private BaseDao baseDao;

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void save(LwbSpread lwbSpread) {
        baseDao.save(lwbSpread);
    }

    @Override
    public void delete(int id) {
        LwbSpread ls = (LwbSpread) baseDao.find("from LwbSpread where id =" + id).get(0);
        baseDao.delete(ls);
    }

    @Override
    public List<LwbSpread> getAll() {
        List<LwbSpread> list = new ArrayList<LwbSpread>();
        String hql = "from LwbSpread";
        list = baseDao.find(hql);
        return list;
    }
}
