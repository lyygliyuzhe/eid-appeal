package org.iie.vo;

import java.util.List;

public class Pager {

    private int totalRows;//总数
    private List elements;//当前页对象集合

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List getElements() {
        return elements;
    }

    public void setElements(List elements) {
        this.elements = elements;
    }
}
