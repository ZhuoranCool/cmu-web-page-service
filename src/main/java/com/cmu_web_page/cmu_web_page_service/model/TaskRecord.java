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

    @Embedded
    private ShowMoreInteraction showMoreInteractions;

    // Constructors
    public TaskRecord() {}

    public TaskRecord(String participantId, String sid, String treatmentGroup,
                     String taskTopic, TaskType taskType, LocalDateTime taskStartTime,
                     ShowMoreInteraction showMoreInteractions,String taskId) {
        this.participantId = participantId;
        this.sid = sid;
        this.treatmentGroup = treatmentGroup;
        this.taskTopic = taskTopic;
        this.taskId= taskId;
        this.taskType = taskType;
        this.taskStartTime = taskStartTime;
        this.showMoreInteractions = showMoreInteractions;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getParticipantId() { return participantId; }
    public void setParticipantId(String participantId) { this.participantId = participantId; }

    public String getSid() { return sid; }
    public void setSid(String sid) { this.sid = sid; }

    public String getTaskId() {return sid+"_"+participantId+"_"+taskTopic+"_"+ treatmentGroup;}

    public String getTreatmentGroup() { return treatmentGroup; }
    public void setTreatmentGroup(String treatmentGroup) { this.treatmentGroup = treatmentGroup; }

    public String getTaskTopic() { return taskTopic; }
    public void setTaskTopic(String taskTopic) { this.taskTopic = taskTopic; }

    public TaskType getTaskType() { return taskType; }
    public void setTaskType(TaskType taskType) { this.taskType = taskType; }

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
                '}';
    }

    public LocalDateTime getTaskStartTime() { return taskStartTime; }
    public void setTaskStartTime(LocalDateTime taskStartTime) { this.taskStartTime = taskStartTime; }

    public LocalDateTime getTaskEndTime() { return taskEndTime; }
    public void setTaskEndTime(LocalDateTime taskEndTime) { this.taskEndTime = taskEndTime; }

    public List<ClickEvent> getClickSequence() { return clickSequence; }
    public void setClickSequence(List<ClickEvent> clickSequence) { this.clickSequence = clickSequence; }

    public ShowMoreInteraction getShowMoreInteractions() { return showMoreInteractions; }
    public void setShowMoreInteractions(ShowMoreInteraction showMoreInteractions) { this.showMoreInteractions = showMoreInteractions; }
}
