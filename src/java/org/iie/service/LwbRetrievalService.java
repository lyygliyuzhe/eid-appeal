/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service;

import java.util.List;
import org.iie.po.LwbData;
import org.iie.vo.Pager;

/**
 *
 * @author fenglei
 */
public interface LwbRetrievalService {

    public abstract Pager getAllLwbData(int pageNumber, int pageSize, String order);

    public abstract Pager getReqLwbdDataList(String query, int pageNumber, int pageSize, String order);

    public abstract List<LwbData> getReqLwbDataList(String query);
}
