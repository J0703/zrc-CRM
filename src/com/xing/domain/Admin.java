package com.xing.domain;

/**
 * Created by dllo on 17/10/24.
 * @author 123
 */
public class Admin {
    private String aid;
    private int level;
    private String text;

    public Admin() {
    }

    public Admin(int level, String text) {
        this.level = level;
        this.text = text;
    }

    public Admin(int level) {
        this.level = level;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
