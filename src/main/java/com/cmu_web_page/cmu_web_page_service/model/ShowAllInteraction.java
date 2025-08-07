package com.cmu_web_page.cmu_web_page_service.model;

import jakarta.persistence.Column;

public class ShowAllInteraction {
    @Column(name = "click_order")
    private Integer click_order;

    @Column(name = "if_click")
    private Boolean if_click;

    @Column(name = "click_time")
    private String click_time;

    public ShowAllInteraction() {
    }

    public ShowAllInteraction(Integer click_order, Boolean if_click, String click_time) {
        this.click_order = click_order;
        this.if_click = if_click;
        this.click_time = click_time;
    }

    public Integer getClick_order() {
        return click_order;
    }

    public void setClick_order(Integer click_order) {
        this.click_order = click_order;
    }

    public Boolean getIf_click() {
        return if_click;
    }

    @Override
    public String toString() {
        return "ShowAllInteraction{" +
                "click_order=" + click_order +
                ", if_click=" + if_click +
                ", click_time='" + click_time + '\'' +
                '}';
    }

    public void setIf_click(Boolean if_click) {
        this.if_click = if_click;
    }

    public String getClick_time() {
        return click_time;
    }

    public void setClick_time(String click_time) {
        this.click_time = click_time;
    }
}
