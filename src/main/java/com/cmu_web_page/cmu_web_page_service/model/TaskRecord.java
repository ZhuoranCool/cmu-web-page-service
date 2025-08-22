package com.cmu_web_page.cmu_web_page_service.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "task_records")

public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "participant_id", nullable = false)
    private String participantId;

    @Column(name = "sid", nullable = false)
    private String sid;

    @Column(name = "treatment_group", nullable = false)
    private String treatmentGroup;

    @Column(name = "task_id", nullable = false)
    private String taskId;

    @Column(name = "task_topic", nullable = false)
    private String taskTopic;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_type", nullable = false)
    private TaskType taskType;

    @Column(name = "task_start_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime taskStartTime;

    @Column(name = "task_end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime taskEndTime;

    @OneToMany(mappedBy = "taskRecord", cascade = CascadeType.ALL)
    private List<ClickEvent> clickSequence;

    @OneToMany(mappedBy = "taskRecord", cascade = CascadeType.ALL)
    private List<ShowMoreInteraction> showMoreInteractions;

    @OneToMany(mappedBy = "taskRecord", cascade = CascadeType.ALL)
    private List<ShowAllInteraction> showAllInteractions;

    @Column(name = "page_click_statics_1")
    private Integer pageClickStatics_1;

    @Column(name = "page_click_statics_2")
    private Integer pageClickStatics_2;

    @Column(name = "page_click_statics_3")
    private Integer pageClickStatics_3;

    @Column(name = "page_click_statics_4")
    private Integer pageClickStatics_4;

    // Constructors
    public TaskRecord() {
    }

    public TaskRecord(String participantId, String sid, String treatmentGroup,
            String taskTopic, TaskType taskType, LocalDateTime taskStartTime,
            Integer page_click_statics_1, Integer page_click_statics_2, Integer page_click_statics_3, Integer page_click_statics_4, String taskId) {
        this.participantId = participantId;
        this.sid = sid;
        this.treatmentGroup = treatmentGroup;
        this.taskTopic = taskTopic;
        this.taskId = taskId;
        this.taskType = taskType;
        this.taskStartTime = taskStartTime;
        this.pageClickStatics_1 = page_click_statics_1;
        this.pageClickStatics_2 = page_click_statics_2;
        this.pageClickStatics_3 = page_click_statics_3;
        this.pageClickStatics_4 = page_click_statics_4;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTaskId() {
        return sid + "_" + participantId + "_" + taskTopic + "_" + treatmentGroup;
    }

    public String getTreatmentGroup() {
        return treatmentGroup;
    }

    public void setTreatmentGroup(String treatmentGroup) {
        this.treatmentGroup = treatmentGroup;
    }

    public String getTaskTopic() {
        return taskTopic;
    }

    public void setTaskTopic(String taskTopic) {
        this.taskTopic = taskTopic;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    @Override
    public String toString() {
        return "TaskRecord{" +
                "id=" + id +
                ", participantId='" + participantId + '\'' +
                ", sid='" + sid + '\'' +
                ", treatmentGroup='" + treatmentGroup + '\'' +
                ", taskId='" + taskId + '\'' +
                ", taskTopic='" + taskTopic + '\'' +
                ", taskType=" + taskType +
                ", taskStartTime=" + taskStartTime +
                ", taskEndTime=" + taskEndTime +
                ", clickSequence=" + clickSequence +
                ", showMoreInteractions=" + showMoreInteractions +
                ", showAllInteractions=" + showAllInteractions +
                ", pageClickStatics_1=" + pageClickStatics_1 +
                ", pageClickStatics_2=" + pageClickStatics_2 +
                ", pageClickStatics_3=" + pageClickStatics_3 +
                ", pageClickStatics_4=" + pageClickStatics_4 +
                '}';
    }

    public LocalDateTime getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(LocalDateTime taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public LocalDateTime getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(LocalDateTime taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public List<ClickEvent> getClickSequence() {
        return clickSequence;
    }

    public void setClickSequence(List<ClickEvent> clickSequence) {
        this.clickSequence = clickSequence;
    }

    public List<ShowMoreInteraction> getShowMoreInteractions() {
        return showMoreInteractions;
    }

    public void setShowMoreInteractions(List<ShowMoreInteraction> showMoreInteractions) {
        this.showMoreInteractions = showMoreInteractions;
    }

    public List<ShowAllInteraction> getShowAllInteractions() {
        return showAllInteractions;
    }

    public void setShowAllInteractions(List <ShowAllInteraction >showAllInteractions) {
        this.showAllInteractions = showAllInteractions;
    }

    public Integer getPageClickStatics_1() {
        return pageClickStatics_1;
    }

    public Integer getPageClickStatics_2() {
        return pageClickStatics_2;
    }

    public Integer getPageClickStatics_3() {
        return pageClickStatics_3;
    }

    public Integer getPageClickStatics_4() {
        return pageClickStatics_4;
    }

    public void setPageClickStatics_1(Integer pageClickStatics_1) {
        this.pageClickStatics_1 = pageClickStatics_1;
    }

    public void setPageClickStatics_2(Integer pageClickStatics_2) {
        this.pageClickStatics_2 = pageClickStatics_2;
    }

    public void setPageClickStatics_3(Integer pageClickStatics_3) {
        this.pageClickStatics_3 = pageClickStatics_3;
    }

    public void setPageClickStatics_4(Integer pageClickStatics_4) {
        this.pageClickStatics_4 = pageClickStatics_4;
    }

    


}
