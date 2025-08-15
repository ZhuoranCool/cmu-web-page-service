package com.cmu_web_page.cmu_web_page_service.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "click_events")
public class ClickEvent {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_record_id")
    @JsonIgnore
    private TaskRecord taskRecord;

    @Column(name = "task_id", nullable = false)
    private String taskId;

    @Column(name = "click_order")
    private Integer click_order;

    @Column(name = "page_title")
    private String page_title;

    @Column(name = "page_id")
    private String page_DateTime;

    @Column(name = "is_ad")
    private boolean is_ad;

    @Column(name = "position_in_serp")
    private String position_in_serp;

    @Column(name = "click_time")
    private String click_time;

    @Column(name = "dwell_time_sec")
    private Double dwell_time_sec;

    @Column(name = "from_overview")
    private Boolean from_overview;

    @Column(name = "from_ai_mode")
    private Boolean from_ai_mode;

    // Constructors
    public ClickEvent() {
    }

    public ClickEvent(Long id, TaskRecord taskRecord, Integer click_order, String page_title, String page_DateTime,
            boolean is_ad, String position_in_serp, String click_time, Double dwell_time_sec, Boolean from_overview,
            Boolean from_ai_mode) {

        this.id=id;
        this.taskRecord = taskRecord;
        this.click_order = click_order;
        this.page_title = page_title;
        this.page_DateTime = page_DateTime;
        this.is_ad = is_ad;
        this.position_in_serp = position_in_serp;
        this.click_time = click_time;
        this.dwell_time_sec = dwell_time_sec;
        this.from_overview = from_overview;
        this.from_ai_mode = from_ai_mode;
    }

    public Long getId() {
        return id;
    }

    public TaskRecord getTaskRecord() {
        return taskRecord;
    }

    public Integer getClick_order() {
        return click_order;
    }

    public String getPage_title() {
        return page_title;
    }

    public String getPage_DateTime() {
        return page_DateTime;
    }

    public boolean isIs_ad() {
        return is_ad;
    }

    public String getPosition_in_serp() {
        return position_in_serp;
    }

    public String getClick_time() {
        return click_time;
    }

    public Double getDwell_time_sec() {
        return dwell_time_sec;
    }

    public Boolean getFrom_overview() {
        return from_overview;
    }

    public Boolean getFrom_ai_mode() {
        return from_ai_mode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTaskRecord(TaskRecord taskRecord) {
        this.taskRecord = taskRecord;
    }

    public void setClick_order(Integer click_order) {
        this.click_order = click_order;
    }



    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    @Override
    public String toString() {
        return "ClickEvent{" +
                "id=" + id +
                ", taskRecord=" + taskRecord +
                ", taskId='" + taskId + '\'' +
                ", click_order=" + click_order +
                ", page_title='" + page_title + '\'' +
                ", page_DateTime='" + page_DateTime + '\'' +
                ", is_ad=" + is_ad +
                ", position_in_serp=" + position_in_serp +
                ", click_time='" + click_time + '\'' +
                ", dwell_time_sec=" + dwell_time_sec +
                ", from_overview=" + from_overview +
                ", from_ai_mode=" + from_ai_mode +
                '}';
    }

    public void setPage_DateTime(String page_DateTime) {
        this.page_DateTime = page_DateTime;
    }

    public void setIs_ad(boolean is_ad) {
        this.is_ad = is_ad;
    }

    public void setPosition_in_serp(String position_in_serp) {
        this.position_in_serp = position_in_serp;
    }

    public void setClick_time(String click_time) {
        this.click_time = click_time;
    }

    public void setDwell_time_sec(Double dwell_time_sec) {
        this.dwell_time_sec = dwell_time_sec;
    }

    public void setFrom_overview(Boolean from_overview) {
        this.from_overview = from_overview;
    }

    public void setFrom_ai_mode(Boolean from_ai_mode) {
        this.from_ai_mode = from_ai_mode;
    }


    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
