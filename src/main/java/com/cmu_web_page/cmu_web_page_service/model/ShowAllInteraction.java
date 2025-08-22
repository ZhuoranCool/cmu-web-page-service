package com.cmu_web_page.cmu_web_page_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ShowAllInteractions")
public class ShowAllInteraction {

    @Id
    @Column(name="id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "task_record_id")
    @JsonIgnore
    private TaskRecord taskRecord;

    @Column(name = "task_id", nullable = false)
    private String taskId;

    @Column(name = "click_order")
    private Integer click_order;

    @Column(name = "component_name")
    private String component_name;

    @Column(name = "click_time")
    private String click_time;

    public ShowAllInteraction() {
    }

    public ShowAllInteraction(String id, TaskRecord taskRecord, String taskId, Integer click_order, String component_name, String click_time) {
        this.id=id;
        this.taskId=taskId;
        this.taskRecord = taskRecord;
        this.click_order = click_order;
        this.component_name=component_name;
        this.click_time = click_time;
    }

    public Integer getClick_order() {
        return click_order;
    }

    public void setClick_order(Integer click_order) {
        this.click_order = click_order;
    }

    @Override
    public String toString() {
        return "ShowAllInteraction [id=" + id + ", taskRecord=" + taskRecord + ", taskId=" + taskId + ", click_order="
                + click_order + ", component_name=" + component_name + ", click_time=" + click_time + "]";
    }


    public String getClick_time() {
        return click_time;
    }

    public void setClick_time(String click_time) {
        this.click_time = click_time;
    }

    public TaskRecord getTaskRecord() {
        return taskRecord;
    }

    public void setTaskRecord(TaskRecord taskRecord) {
        this.taskRecord = taskRecord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getComponent_name() {
        return component_name;
    }

    public void setComponent_name(String component_name) {
        this.component_name = component_name;
    }

    
}
