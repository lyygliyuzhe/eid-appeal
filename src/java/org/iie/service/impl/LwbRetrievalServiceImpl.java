/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.iie.dao.basedao.BaseDao;
import org.iie.po.LwbData;
import org.iie.service.LwbRetrievalService;
import org.iie.vo.Pager;

/**
 *
 * @author zmc
 */
public class LwbRetrievalServiceImpl implements LwbRetrievalService {

    private BaseDao baseDao;

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }


    @Override
    public Pager getAllLwbData(int pageNumber, int pageSize, String order) {
        String hql = "";
        if (null != order && !order.isEmpty()) {
            hql = "from LwbData  order by clickNum " + order;
        } else {
            hql = "from LwbData  order by dateTime desc";
        }

        Pager page = baseDao.getPager(hql, pageNumber, pageSize);

        return page;
    }

    @Override
    public Pager getReqLwbdDataList(String query, int pageNumber, int pageSize, String order) {
        String hql = "";
        if (null != order && !order.isEmpty()) {
            hql = "from LwbData where " + query + " order by clickNum " + order;
        } else {
            hql = "from LwbData where " + query + " order by dateTime desc";
        }
        Pager pager = baseDao.getPager(hql, pageNumber, pageSize);
        return pager;
    }

    @Override
    public List<LwbData> getReqLwbDataList(String query) {
        List<LwbData> list = new ArrayList<LwbData>();
        String hql = "from LwbData where " + query;
        list = baseDao.find(hql);
        return list;
    }
}
