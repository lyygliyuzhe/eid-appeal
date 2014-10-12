/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.iie.action.baseaction.BaseAction;
import org.iie.po.LwbData;
import org.iie.service.LwbRetrievalService;
import org.iie.util.file.FileUtil;
import org.iie.vo.SearchResult;
import org.iie.vo.Pager;

/**
 * s
 *
 * @author zmc
 */
public class LwbRetrievalAction extends BaseAction {

    private LwbRetrievalService lwbRetrievalService;
    private String fileName;                  //输入图片路径
    private HttpServletResponse response;
    private ServletOutputStream out;          //返回二进制流可以直接在jsp页面显示
    private Map<String, Object> map;          //json
    private String message;                   //返回查询结果消息
    private String pageNumber;                //第几页
    private String pageSize;                  //每页显示条数
    private String keyword;                   //关键词
    private String startTime;                 //起始时间
    private String endTime;                   //结束时间
    private String resource;                  //来源地
    private String specialKeyword;            //敏感词
    private String forwardNum;                //转发次数
    private int fileLength;

    public String list() {
        Pager pager = new Pager();
        map = new HashMap<String, Object>();

        try {
            String query = (String) this.getSession(SESSION_LWB_QUERY);
            String order = (String) this.getSession(SESSION_LWB_ORDER);

            if (query != null && !query.isEmpty()) {
                pager = lwbRetrievalService.getReqLwbdDataList(query, Integer.valueOf(pageNumber), Integer.valueOf(pageSize), order);
            } else {
                pager = lwbRetrievalService.getAllLwbData(Integer.valueOf(pageNumber), Integer.valueOf(pageSize), order);
            }

            map.put("rows", pager.getElements());
            map.put("total", pager.getTotalRows());
        } catch (Exception ex) {
            ex.printStackTrace();
            message = "查询出现错误！";
        }
        map.put("message", message);
        return SUCCESS;
    }

    public String query() {
//        String query = "";
//        StringBuilder sb = new StringBuilder();
//        List<SearchResult> resultList = null;
//
//        List<String> list = new ArrayList<String>();
//
//        if (!keyword.isEmpty()) {
//            for (String str : keyword.split("\\s+")) {
//                list.add(str);
//            }
//        }
//
//        if (!specialKeyword.isEmpty()) {
//            for (String str : specialKeyword.split("、")) {
//                list.add(str);
//            }
//        }
//
//        try {
//            int size = list.size();
//            if (size != 0) {
//
//                Searcher querySearch = new Searcher();
//                resultList = querySearch.search((String[]) list.toArray(new String[size]));
//
//                if (resultList.size() != 0) {
//
//                    for (SearchResult searchResult : resultList) {
//                        fileName = searchResult.getFileName();
//                        if (!resource.isEmpty() && !resource.contains(",")) {
//                            sb.append("( resource = '");
//                            sb.append(resource);
//                            sb.append("' and fileName = '");
//                            sb.append(fileName);
//                            if (!startTime.isEmpty() && !endTime.isEmpty()) {
//                                sb.append("' and dateTime between '");
//                                sb.append(startTime);
//                                sb.append("' and '");
//                                sb.append(endTime);
//                            }
//                            sb.append("') or ");
//                        } else if (resource.contains(",")) {
//                            String[] rs = resource.split(",");
//                            for (String r : rs) {
//                                sb.append("( resource = '");
//                                sb.append(r);
//                                sb.append("' and fileName = '");
//                                sb.append(fileName);
//                                if (!startTime.isEmpty() && !endTime.isEmpty()) {
//                                    sb.append("' and dateTime between '");
//                                    sb.append(startTime);
//                                    sb.append("' and '");
//                                    sb.append(endTime);
//                                }
//                                sb.append("') or ");
//                            }
//                        } else {
//                            sb.append("( fileName = '");
//                            sb.append(fileName);
//                            if (!startTime.isEmpty() && !endTime.isEmpty()) {
//                                sb.append("' and dateTime between '");
//                                sb.append(startTime);
//                                sb.append("' and '");
//                                sb.append(endTime);
//                            }
//                            sb.append("') or ");
//                        }
//                    }
//                    query = sb.toString().substring(0, sb.toString().length() - 3);
//                } else {
//                    message = "查询结果为空！";
//                    return SUCCESS;
//                }
//
//            } else if (!resource.isEmpty()
//                    && !resource.contains(",")) {
//                sb.append("resource = '");
//                sb.append(resource);
//                if (!startTime.isEmpty() && !endTime.isEmpty()) {
//                    sb.append("' and dateTime between '");
//                    sb.append(startTime);
//                    sb.append("' and '");
//                    sb.append(endTime);
//                    sb.append("'");
//                } else {
//                    sb.append("'");
//                }
//                query = sb.toString();
//            } else if (resource.contains(
//                    ",")) {
//                String[] rs = resource.split(",");
//                for (int i = 0; i < rs.length; i++) {
//                    resource = rs[i];
//                    sb.append("( resource = '");
//                    sb.append(resource);
//                    if (!startTime.isEmpty() && !endTime.isEmpty()) {
//                        sb.append("' and dateTime between '");
//                        sb.append(startTime);
//                        sb.append("' and '");
//                        sb.append(endTime);
//                        sb.append("')");
//                    } else {
//                        sb.append("')");
//                    }
//                    sb.append(" or ");
//                }
//                query = sb.substring(0, sb.toString().length() - 3);
//            } else {
//                if (!startTime.isEmpty() && !endTime.isEmpty()) {
//                    sb.append(" dateTime between '");
//                    sb.append(startTime);
//                    sb.append("' and '");
//                    sb.append(endTime);
//                    sb.append("'");
//                    query = sb.toString();
//                }
//            }
//
//            this.setSession(SESSION_LWB_LUCENERESULT, resultList);
//            this.setSession(SESSION_LWB_QUERY, query);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            message = "查询出现错误！";
//            return SUCCESS;
//        }
//
//        try {
//            this.setSession(SESSION_LWB_ORDER, forwardNum);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            message = "查询出现错误！";
//            return SUCCESS;
//        }

        return SUCCESS;
    }

    public void detail() throws Exception {

        response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();

        //防止firefox解析xml错误提示
        sb.append("<?xml-stylesheet href=\"#\" type=\"text/css\" ?>");

        sb.append("<div>");
        String[] txtResult = null;
        List<SearchResult> resultList = (List<SearchResult>) this.getSession(SESSION_LWB_LUCENERESULT);
        if (resultList == null) {
            String txtFileName = fileName.replace("jpg", "txt");
            File file = new File(TXT_PATH + txtFileName);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), "utf-8");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    sb.append(lineTxt.trim());
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } else {
            for (SearchResult sr : resultList) {
                if (sr.getFileName().equals(fileName)) {
                    txtResult = sr.getFileContents();
                    break;
                }
            }

            for (String txt : txtResult) {
                sb.append(txt);
            }
        }
        sb.append("</div>");
//        System.out.println("拼接的xml字符串：" + sb.toString());
        out.print(sb.toString());
    }

    public InputStream getInputStream() throws Exception {
        String query = (String) super.getSession(SESSION_LWB_QUERY);

        StringBuilder sb = new StringBuilder();

        if (query != null && !query.isEmpty()) {
            List<LwbData> list = lwbRetrievalService.getReqLwbDataList(query);
            if (list.size() != 0) {
                for (LwbData lwbData : list) {
                    sb.append(FileUtil.readFile(TXT_PATH + lwbData.getFileName().replace(".jpg", ".txt")));
                    sb.append("\n\r");
                }
            } else {
                sb.append("查询结果为空！");
            }
        } else {
            sb.append("没有设置查询条件！");
        }

        String content = sb.toString();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fileName = sdf.format(new Date()) + ".txt";

        this.setFileLength(content.getBytes().length);
        InputStream inputStream = new ByteArrayInputStream(content.getBytes());

        return inputStream;
    }

    public LwbRetrievalService getLwbRetrievalService() {
        return lwbRetrievalService;
    }

    public void setLwbRetrievalService(LwbRetrievalService lwbRetrievalService) {
        this.lwbRetrievalService = lwbRetrievalService;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public ServletOutputStream getOut() {
        return out;
    }

    public void setOut(ServletOutputStream out) {
        this.out = out;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(String forwardNum) {
        this.forwardNum = forwardNum;
    }

    public String getSpecialKeyword() {
        return specialKeyword;
    }

    public void setSpecialKeyword(String specialKeyword) {
        this.specialKeyword = specialKeyword;
    }

    public int getFileLength() {
        return fileLength;
    }

    public void setFileLength(int fileLength) {
        this.fileLength = fileLength;
    }
}
