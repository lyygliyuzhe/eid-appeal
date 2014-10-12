/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.iie.action.baseaction.BaseAction;
import org.iie.po.LwbSpread;
import org.iie.service.LwbSpreadService;
import org.iie.vo.Pager;

/**
 *
 * @author zmc
 */
public class LwbSpreadAction extends BaseAction {

    private LwbSpreadService lwbSpreadService;
    
    private Map<String, Object> map;
    private String errorMsg;
    private String lwbLink;
    private String id;

    public String list() {
        Pager pager = new Pager();
        map = new HashMap<String, Object>();

        List<LwbSpread> ls = lwbSpreadService.getAll();
        map.put("total", ls.size());
        map.put("rows", ls);
        return SUCCESS;
    }

    public String add() {
        LwbSpread ls = new LwbSpread();
        ls.setName("测试");
        ls.setContent("测试测试测试测试测试");
        ls.setTime(new Date());
        ls.setForward("2304");
        ls.setStatus("<a href='#' onclick='trend()'>趋势分析</a>");

        try {
            lwbSpreadService.save(ls);
        } catch (Exception e) {
            e.printStackTrace();
            errorMsg = "保存出现错误！";
        }

        return SUCCESS;
    }

    public String delete() {
        try {
            lwbSpreadService.delete(Integer.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
            errorMsg = "删除出现错误！";
        }

        return SUCCESS;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public LwbSpreadService getLwbSpreadService() {
        return lwbSpreadService;
    }

    public void setLwbSpreadService(LwbSpreadService lwbSpreadService) {
        this.lwbSpreadService = lwbSpreadService;
    }

    public String getLwbLink() {
        return lwbLink;
    }

    public void setLwbLink(String lwbLink) {
        this.lwbLink = lwbLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
