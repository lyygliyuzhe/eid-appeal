/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.iie.action.baseaction.BaseAction;
import org.iie.service.LwbStatisticsService;
import org.iie.vo.KeyWordCollectInfoDto;

/**
 *
 * @author zmc
 */
public class LwbStatisticsAction extends BaseAction {

    private LwbStatisticsService lwbStatisticsService;
    private String forward;
    private String cloud;

    // xml 没有返回值  
    public void statKeyword() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("GBK");
        response.setContentType("text/xml;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        String xml = "";
        StringBuffer xmlBuffer = new StringBuffer();
        xmlBuffer.append("<chart caption='2013' xAxisName='month' yAxisName='hot degrees' showValues='0'>");
        xmlBuffer.append("<categories>");
        xmlBuffer.append("<category label='01' />");
        xmlBuffer.append("<category label='02' />");
        xmlBuffer.append("<category label='03' />");
        xmlBuffer.append("<category label='04' />");
        xmlBuffer.append("<category label='05' />");
        xmlBuffer.append("<category label='06' />");
        xmlBuffer.append("<category label='07' />");
        xmlBuffer.append("<category label='08' />");
        xmlBuffer.append("<category label='09' />");
        xmlBuffer.append("<category label='10' />");
        xmlBuffer.append("<category label='11' />");
        xmlBuffer.append("<category label='12' />");
        xmlBuffer.append("</categories>");
        xmlBuffer.append("<dataset seriesName='爆炸'>");
        xmlBuffer.append("<set value='11276' />");
        xmlBuffer.append("<set value='12264' />");
        xmlBuffer.append("<set value='12956' />");
        xmlBuffer.append("<set value='13165' />");
        xmlBuffer.append("<set value='13254' />");
        xmlBuffer.append("<set value='13554' />");
        xmlBuffer.append("<set value='12934' />");
        xmlBuffer.append("<set value='13456' />");
        xmlBuffer.append("<set value='13915' />");
        xmlBuffer.append("<set value='14154' />");
        xmlBuffer.append("<set value='16765' />");
        xmlBuffer.append("<set value='11454' />");
        xmlBuffer.append("</dataset>");
        xmlBuffer.append("<dataset seriesName='新疆'>");
        xmlBuffer.append("<set value='9254' />");
        xmlBuffer.append("<set value='16234' />");
        xmlBuffer.append("<set value='9956' />");
        xmlBuffer.append("<set value='11565' />");
        xmlBuffer.append("<set value='11454' />");
        xmlBuffer.append("<set value='12654' />");
        xmlBuffer.append("<set value='11234' />");
        xmlBuffer.append("<set value='12456' />");
        xmlBuffer.append("<set value='11565' />");
        xmlBuffer.append("<set value='12454' />");
        xmlBuffer.append("<set value='11565' />");
        xmlBuffer.append("<set value='14454' />");
        xmlBuffer.append("</dataset>");
//        xmlBuffer.append("<trendlines>");
//        xmlBuffer.append("<line startValue='26000' color='91C728' displayValue='Target' showOnTop='1'/>");
//        xmlBuffer.append("</trendlines>");
        xmlBuffer.append("</chart>");

        xml = xmlBuffer.toString();
        out.write(xml);
        //不用关,Struts2会帮你关  
    }

    public String statForward() {
        StringBuffer stringBuffer = new StringBuffer();
        int[] a = new int[10];

        a[0] = lwbStatisticsService.getForwardData("from LwbData where clickNum between 0 and 999");
        a[1] = lwbStatisticsService.getForwardData("from LwbData where clickNum between 1000 and 1999");
        a[2] = lwbStatisticsService.getForwardData("from LwbData where clickNum between 2000 and 2999");
        a[3] = lwbStatisticsService.getForwardData("from LwbData where clickNum between 3000 and 3999");
        a[4] = lwbStatisticsService.getForwardData("from LwbData where clickNum between 4000 and 4999");
        a[5] = lwbStatisticsService.getForwardData("from LwbData where clickNum between 5000 and 5999");
        a[6] = lwbStatisticsService.getForwardData("from LwbData where clickNum between 6000 and 6999");
        a[7] = lwbStatisticsService.getForwardData("from LwbData where clickNum between 7000 and 7999");
        a[8] = lwbStatisticsService.getForwardData("from LwbData where clickNum between 8000 and 8999");
        a[9] = lwbStatisticsService.getForwardData("from LwbData where clickNum between 9000 and 10000");

        stringBuffer.append("{\"chart\":{\"caption\":\"转发次数统计\",\"pieRadius\": \"180\",\"pieyscale\": \"30\",\"pieslicedepth\": \"8\"},");
        stringBuffer.append("\"data\":[{\"value\":\"")
                .append(String.valueOf(a[0]))
                .append("\",\"label\": \"0-999\",\"color\": \"1160B8\"},")
                .append("{\"value\": \"").append(String.valueOf(a[1]))
                .append("\",\"label\": \"1000-1999\",\"color\": \"F2AC0C\"},")
                .append("{\"value\": \"")
                .append(String.valueOf(a[2]))
                .append("\",\"label\": \"2000-2999\",\"color\": \"BF0000\"},")
                .append("{\"value\": \"")
                .append(String.valueOf(a[3]))
                .append("\",\"label\": \"3000-3999\",\"color\": \"00247C\"},")
                .append("{\"value\": \"")
                .append(String.valueOf(a[4]))
                .append("\",\"label\": \"4000-4999\",\"color\": \"008900\"},")
                .append("{\"value\": \"")
                .append(String.valueOf(a[5]))
                .append("\",\"label\": \"5000-5999\",\"color\": \"E95D0F\"},")
                .append("{\"value\": \"")
                .append(String.valueOf(a[6]))
                .append("\",\"label\": \"6000-6999\",\"color\": \"FFB6C1\"},")
                .append("{\"value\": \"")
                .append(String.valueOf(a[7]))
                .append("\",\"label\": \"7000-7999\",\"color\": \"DC143C\"},")
                .append("{\"value\": \"")
                .append(String.valueOf(a[8]))
                .append("\",\"label\": \"8000-8999\",\"color\": \"DA70D6\"},")
                .append("{\"value\": \"")
                .append(String.valueOf(a[9]))
                .append("\",\"label\": \"9000-10000\",\"color\": \"6A5ACD\"}]}");

        forward = stringBuffer.toString();
        return SUCCESS;
    }

    public String statCloud() {
        List<KeyWordCollectInfoDto> KeyWordCollectInfoList = new ArrayList<KeyWordCollectInfoDto>();

        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("习近平"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("胡锦涛"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("新疆"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("疆独"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("强奸"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("游行"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("分裂"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("爆炸"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("台独"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("示威"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("上访"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("性侵"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("猥亵"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("策反"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("暴力"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("反动"));
        KeyWordCollectInfoList.add(lwbStatisticsService.getKeyWordCollectInfo("杀人"));
        JSONArray jsonArray = JSONArray.fromObject(KeyWordCollectInfoList);
        cloud = jsonArray.toString();

        return SUCCESS;
    }

    public LwbStatisticsService getLwbStatisticsService() {
        return lwbStatisticsService;
    }

    public void setLwbStatisticsService(LwbStatisticsService lwbStatisticsService) {
        this.lwbStatisticsService = lwbStatisticsService;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }
}
