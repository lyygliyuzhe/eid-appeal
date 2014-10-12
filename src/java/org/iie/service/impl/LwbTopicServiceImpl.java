/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.iie.dao.basedao.BaseDao;
import org.iie.po.LwbTopic;
import org.iie.service.LwbTopicService;

/**
 *
 * @author mc
 */
public class LwbTopicServiceImpl implements LwbTopicService {

    private BaseDao baseDao;

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void save(LwbTopic lwbTopic) {
        baseDao.save(lwbTopic);
    }

    @Override
    public void delete(int id) {
        LwbTopic ls = (LwbTopic) baseDao.find("from LwbTopic where id =" + id).get(0);
        baseDao.delete(ls);
    }

    @Override
    public List<LwbTopic> getAll() {
        List<LwbTopic> list = new ArrayList<LwbTopic>();
        String hql = "from LwbTopic";
        list = baseDao.find(hql);
        return list;
    }
}
