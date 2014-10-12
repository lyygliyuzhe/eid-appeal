/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.iie.action.baseaction.BaseAction;
import org.iie.po.LwbSpecial;
import org.iie.service.LwbSpecialService;
import org.iie.vo.EasyUIForm;
import org.iie.vo.Pager;

/**
 *
 * @author zmc
 */
public class LwbSpecialAction extends BaseAction {

    private LwbSpecialService lwbSpecialService;
    private Map<String, Object> map;
    private String errorMsg;
    private String id;
    private String name;
    private String keyword;
    private char status;
    private String rows;//每页显示的记录数  
    private String page;//当前第几页  
    private List<EasyUIForm> jsonList;

    public String list() {
        Pager pager = new Pager();
        map = new HashMap<String, Object>();

        pager = lwbSpecialService.getAll(Integer.valueOf(page), Integer.valueOf(rows));
        map.put("total", pager.getTotalRows());
        map.put("rows", pager.getElements());
        return SUCCESS;
    }

    public String save() {

        LwbSpecial ls = new LwbSpecial();
        ls.setName(name);
        ls.setKeyword(keyword);
        ls.setStatus(status);
        ls.setCreateTime(new Date());

        try {
            lwbSpecialService.save(ls);
        } catch (Exception e) {
            e.printStackTrace();
            errorMsg = "保存出现错误！";
        }

        return SUCCESS;
    }

    public String update() {

        LwbSpecial ls = new LwbSpecial();
        ls.setId(Integer.valueOf(id));
        ls.setName(name);
        ls.setKeyword(keyword);
        ls.setStatus(status);
        ls.setCreateTime(new Date());

        try {
            lwbSpecialService.save(ls);
        } catch (Exception e) {
            e.printStackTrace();
            errorMsg = "更新出现错误！";
        }

        return SUCCESS;
    }

    public String delete() {

        try {
            lwbSpecialService.delete(Integer.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
            errorMsg = "删除出现错误！";
        }

        return SUCCESS;
    }

    public String event() {
        jsonList = new ArrayList<EasyUIForm>();
        List<LwbSpecial> list = lwbSpecialService.event();
        for (int i = 0; i < list.size(); i++) {
            EasyUIForm easyuiform = new EasyUIForm();
            easyuiform.setValue(list.get(i).getKeyword());
            easyuiform.setText(list.get(i).getName());
            jsonList.add(easyuiform);
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

    public LwbSpecialService getLwbSpecialService() {
        return lwbSpecialService;
    }

    public void setLwbSpecialService(LwbSpecialService lwbSpecialService) {
        this.lwbSpecialService = lwbSpecialService;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<EasyUIForm> getJsonList() {
        return jsonList;
    }

    public void setJsonList(List<EasyUIForm> jsonList) {
        this.jsonList = jsonList;
    }
}
