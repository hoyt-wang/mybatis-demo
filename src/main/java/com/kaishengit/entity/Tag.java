package com.kaishengit.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/24.
 */
public class Tag implements Serializable{
    private int id;
    private String tagName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
