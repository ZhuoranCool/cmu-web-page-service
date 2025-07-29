package com.cmu_web_page.cmu_web_page_service.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

@Entity
@Table(name = "click_events")
public class ClickEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_record_id")
    @JsonIgnore
    private TaskRecord taskRecord;
    
    @Column(name = "element_id")
    private String elementId;
    
    @Column(name = "element_type")
    private String elementType;
    
    @Column(name = "click_timestamp")
    private LocalDateTime clickTimestamp;
    
    @Column(name = "x_coordinate")
    private Integer xCoordinate;
    
    @Column(name = "y_coordinate")
    private Integer yCoordinate;
    
    // Constructors
    public ClickEvent() {}
    
    public ClickEvent(String elementId, String elementType, LocalDateTime clickTimestamp, 
                     Integer xCoordinate, Integer yCoordinate) {
        this.elementId = elementId;
        this.elementType = elementType;
        this.clickTimestamp = clickTimestamp;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public TaskRecord getTaskRecord() { return taskRecord; }
    public void setTaskRecord(TaskRecord taskRecord) { this.taskRecord = taskRecord; }
    
    public String getElementId() { return elementId; }
    public void setElementId(String elementId) { this.elementId = elementId; }
    
    public String getElementType() { return elementType; }
    public void setElementType(String elementType) { this.elementType = elementType; }
    
    public LocalDateTime getClickTimestamp() { return clickTimestamp; }
    public void setClickTimestamp(LocalDateTime clickTimestamp) { this.clickTimestamp = clickTimestamp; }
    
    public Integer getXCoordinate() { return xCoordinate; }
    public void setXCoordinate(Integer xCoordinate) { this.xCoordinate = xCoordinate; }
    
    public Integer getYCoordinate() { return yCoordinate; }
    public void setYCoordinate(Integer yCoordinate) { this.yCoordinate = yCoordinate; }
}
