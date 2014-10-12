/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iie.vo;

import java.io.Serializable;

/**
 *
 * @author mc
 */
public class SearchResult implements Serializable{

    private String fileName;        //图片文件名
    private String[] fileContents;  //文本内容片段

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getFileContents() {
        return fileContents;
    }

    public void setFileContents(String[] fileContents) {
        this.fileContents = fileContents;
    }
}
