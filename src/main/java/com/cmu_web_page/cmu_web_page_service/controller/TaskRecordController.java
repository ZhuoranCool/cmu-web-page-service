package com.cmu_web_page.cmu_web_page_service.controller;

import com.cmu_web_page.cmu_web_page_service.model.TaskRecord;
import com.cmu_web_page.cmu_web_page_service.model.TaskType;
import com.cmu_web_page.cmu_web_page_service.service.TaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task-records")
@CrossOrigin(origins = "*") // Configure this properly for production
public class TaskRecordController {

    @Autowired
    private TaskRecordService taskRecordService;

    // GET all task records
    @GetMapping
    public ResponseEntity<List<TaskRecord>> getAllTaskRecords() {
        List<TaskRecord> taskRecords = taskRecordService.getAllTaskRecords();
        return ResponseEntity.ok(taskRecords);
    }

    // GET task record by ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskRecord> getTaskRecordById(@PathVariable Long id) {
        Optional<TaskRecord> taskRecord = taskRecordService.getTaskRecordById(id);
        return taskRecord.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    // GET task record by task ID
    @GetMapping("/task/{taskId}")
    public ResponseEntity<TaskRecord> getTaskRecordByTaskId(@PathVariable String taskId) {
        Optional<TaskRecord> taskRecord = taskRecordService.getTaskRecordByTaskId(taskId);
        return taskRecord.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    // GET task records by participant ID
    @GetMapping("/participant/{participantId}")
    public ResponseEntity<List<TaskRecord>> getTaskRecordsByParticipantId(@PathVariable String participantId) {
        List<TaskRecord> taskRecords = taskRecordService.getTaskRecordsByParticipantId(participantId);
        return ResponseEntity.ok(taskRecords);
    }

    // GET task records by task type
    @GetMapping("/type/{taskType}")
    public ResponseEntity<List<TaskRecord>> getTaskRecordsByTaskType(@PathVariable TaskType taskType) {
        List<TaskRecord> taskRecords = taskRecordService.getTaskRecordsByTaskType(taskType);
        return ResponseEntity.ok(taskRecords);
    }

    // GET task records by treatment group
    @GetMapping("/treatment/{treatmentGroup}")
    public ResponseEntity<List<TaskRecord>> getTaskRecordsByTreatmentGroup(@PathVariable String treatmentGroup) {
        List<TaskRecord> taskRecords = taskRecordService.getTaskRecordsByTreatmentGroup(treatmentGroup);
        return ResponseEntity.ok(taskRecords);
    }

    // POST create new task record
    @PostMapping
    public ResponseEntity<TaskRecord> createTaskRecord(@RequestBody TaskRecord taskRecord) {
        System.out.println("进入创建任务记录接口");
        System.out.println("create_taskRecord = " + taskRecord);
        try {
            Optional<TaskRecord> existingRecord = taskRecordService.getTaskRecordByTaskId(taskRecord.getTaskId());

            if(existingRecord.isPresent()){
                TaskRecord updatedTaskRecord = taskRecordService.updateTaskRecord(taskRecord.getTaskId(),taskRecord);
                return ResponseEntity.status(HttpStatus.CREATED).body(updatedTaskRecord);
            }

       
            TaskRecord createdTaskRecord = taskRecordService.createTaskRecord(taskRecord);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTaskRecord);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // PUT update task record
    @PutMapping("/{taskId}")
    public ResponseEntity<TaskRecord> updateTaskRecord(@PathVariable String taskId, @RequestBody TaskRecord taskRecordDetails) {
        System.out.println("进入修改任务记录接口");
        System.out.println("update_taskRecordDetails = " + taskRecordDetails);;
        try {
            TaskRecord updatedTaskRecord = taskRecordService.updateTaskRecord(taskId, taskRecordDetails);
            return ResponseEntity.ok(updatedTaskRecord);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // DELETE task record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskRecord(@PathVariable Long id) {
        try {
            taskRecordService.deleteTaskRecord(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE all task records
    @DeleteMapping
    public ResponseEntity<Void> deleteAllTaskRecords() {
        taskRecordService.deleteAllTaskRecords();
        return ResponseEntity.noContent().build();
    }

    // DELETE task records by participant ID
    @DeleteMapping("/participant/{participantId}")
    public ResponseEntity<Void> deleteTaskRecordsByParticipantId(@PathVariable String participantId) {
        taskRecordService.deleteTaskRecordsByParticipantId(participantId);
        return ResponseEntity.noContent().build();
    }
}

