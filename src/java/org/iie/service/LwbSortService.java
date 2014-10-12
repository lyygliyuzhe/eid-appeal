/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.service;

import org.iie.po.LwbCategory;
import org.iie.vo.Pager;

/**
 *
 * @author zmc
 */
public interface LwbSortService {

    public Pager getAll(String page, String rows, String sort);

    public void update(String id, String category);

}
