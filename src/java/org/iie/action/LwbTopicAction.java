/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.iie.action.baseaction.BaseAction;
import org.iie.po.LwbTopic;
import org.iie.service.LwbTopicService;
import org.iie.vo.Pager;

/**
 *
 * @author zmc
 */
public class LwbTopicAction extends BaseAction {
    
    private LwbTopicService lwbTopicService;
    private Map<String, Object> map;
    private String errorMsg;
    private String lwbLink;
    private String id;
    private String lwbTopic;
    
    public String list() {
        map = new HashMap<String, Object>();
        
        List<LwbTopic> ls = lwbTopicService.getAll();
        map.put("total", ls.size());
        map.put("rows", ls);
        
        return SUCCESS;
    }
    
//    public String add() {
//        System.out.println(lwbTopic);
//        
//        LwbTopic ls = new LwbTopic();
//        ls.setTopic("测试");
//        ls.setCreateTime(new Date());
//        ls.setTopicNum(100);
//        
//        try {
//            lwbTopicService.save(ls);
//        } catch (Exception e) {
//            e.printStackTrace();
//            errorMsg = "保存出现错误！";
//        }
//        
//        return SUCCESS;
//    }
    
    public String delete() {
        try {
            lwbTopicService.delete(Integer.valueOf(id));
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
    
    public LwbTopicService getLwbTopicService() {
        return lwbTopicService;
    }
    
    public void setLwbTopicService(LwbTopicService lwbTopicService) {
        this.lwbTopicService = lwbTopicService;
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

    public String getLwbTopic() {
        return lwbTopic;
    }

    public void setLwbTopic(String lwbTopic) {
        this.lwbTopic = lwbTopic;
    }
}
