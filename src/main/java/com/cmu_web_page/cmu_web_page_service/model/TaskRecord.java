package com.cmu_web_page.cmu_web_page_service.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "task_records")
public class TaskRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "participant_id", nullable = false)
    private String participantId;
    
    @Column(name = "task_id", nullable = false)
    private String taskId;
    
    @Column(name = "treatment_group", nullable = false)
    private String treatmentGroup;
    
    @Column(name = "task_topic", nullable = false)
    private String taskTopic;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "task_type", nullable = false)
    private TaskType taskType;
    
    @Column(name = "task_start_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime taskStartTime;
    
    @Column(name = "task_end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime taskEndTime;
    
    @OneToMany(mappedBy = "taskRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClickEvent> clickSequence;
    
    @Column(name = "show_more_interactions", nullable = false)
    private Boolean showMoreInteractions;
    
    // Constructors
    public TaskRecord() {}
    
    public TaskRecord(String participantId, String taskId, String treatmentGroup, 
                     String taskTopic, TaskType taskType, LocalDateTime taskStartTime,
                     Boolean showMoreInteractions) {
        this.participantId = participantId;
        this.taskId = taskId;
        this.treatmentGroup = treatmentGroup;
        this.taskTopic = taskTopic;
        this.taskType = taskType;
        this.taskStartTime = taskStartTime;
        this.showMoreInteractions = showMoreInteractions;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getParticipantId() { return participantId; }
    public void setParticipantId(String participantId) { this.participantId = participantId; }
    
    public String getTaskId() { return taskId; }
    public void setTaskId(String taskId) { this.taskId = taskId; }
    
    public String getTreatmentGroup() { return treatmentGroup; }
    public void setTreatmentGroup(String treatmentGroup) { this.treatmentGroup = treatmentGroup; }
    
    public String getTaskTopic() { return taskTopic; }
    public void setTaskTopic(String taskTopic) { this.taskTopic = taskTopic; }
    
    public TaskType getTaskType() { return taskType; }
    public void setTaskType(TaskType taskType) { this.taskType = taskType; }
    
    public LocalDateTime getTaskStartTime() { return taskStartTime; }
    public void setTaskStartTime(LocalDateTime taskStartTime) { this.taskStartTime = taskStartTime; }
    
    public LocalDateTime getTaskEndTime() { return taskEndTime; }
    public void setTaskEndTime(LocalDateTime taskEndTime) { this.taskEndTime = taskEndTime; }
    
    public List<ClickEvent> getClickSequence() { return clickSequence; }
    public void setClickSequence(List<ClickEvent> clickSequence) { this.clickSequence = clickSequence; }
    
    public Boolean getShowMoreInteractions() { return showMoreInteractions; }
    public void setShowMoreInteractions(Boolean showMoreInteractions) { this.showMoreInteractions = showMoreInteractions; }
}
