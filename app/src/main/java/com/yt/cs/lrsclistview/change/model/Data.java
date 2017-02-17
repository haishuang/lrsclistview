package com.yt.cs.lrsclistview.change.model;

import java.util.List;

/**
 * Created by Huang hai-sen on 2017/2/16.
 */

public class Data {

    private String leftTitle;
    private List<String> list;

    public Data(List<String> list, String leftTitle) {
        this.list = list;
        this.leftTitle = leftTitle;
    }
    
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getLeftTitle() {
        return leftTitle;
    }

    public void setLeftTitle(String leftTitle) {
        this.leftTitle = leftTitle;
    }
}
