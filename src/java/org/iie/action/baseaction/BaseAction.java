package org.iie.action.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class BaseAction extends ActionSupport {

    public  final int PAGE_RECORD_NUM = 10;
    public  final String SESSION_LWB_QUERY = "session_lwb_query";
    public  final String SESSION_LWB_ORDER = "session_lwb_order";
    public  final String SESSION_LWB_LUCENERESULT = "session_lwb_luceneResult";
    public  final String TXT_PATH = "E:/LwbData/txt/";                  
    public  final String IMG_PATH = "";                 

    public void setRequest(String srcReq, Object dstReq) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute(srcReq, dstReq);
    }

    public void setResponse(String res) throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.getWriter().write(res);
    }

    public void setSession(String srcSes, Object dstSes) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute(srcSes, dstSes);
    }

    public Object getSession(String ses) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        return request.getSession().getAttribute(ses);
    }

    public HttpSession getSession() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        return request.getSession();
    }
}
