/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.action;

import java.util.HashMap;
import java.util.Map;
import org.iie.action.baseaction.BaseAction;
import org.iie.po.LwbCategory;
import org.iie.service.LwbSortService;
import org.iie.vo.Pager;

/**
 *
 * @author zmc
 */
public class LwbSortAction extends BaseAction {

    private LwbSortService lwbSortService;
    private String sort;
    private String page;
    private String rows;
    private Map<String, Object> map;
    private String id;
    private String category;

    public String list() {
        map = new HashMap<String, Object>();
        Pager pager = lwbSortService.getAll(page, rows, sort);
        map.put("total", pager.getTotalRows());
        map.put("rows", pager.getElements());
        return SUCCESS;
    }

    public String update() {
        lwbSortService.update(id,category);
        return SUCCESS;
    }

    public String getPage() {
        return page;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public LwbSortService getLwbSortService() {
        return lwbSortService;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setLwbSortService(LwbSortService lwbSortService) {
        this.lwbSortService = lwbSortService;
    }
}
