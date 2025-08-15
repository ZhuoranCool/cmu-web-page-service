package com.cmu_web_page.cmu_web_page_service.service;

import com.cmu_web_page.cmu_web_page_service.model.TaskRecord;
import com.cmu_web_page.cmu_web_page_service.model.TaskType;
import com.cmu_web_page.cmu_web_page_service.repository.TaskRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskRecordService {

    @Autowired
    private TaskRecordRepository taskRecordRepository;

    public List<TaskRecord> getAllTaskRecords() {
        return taskRecordRepository.findAll();
    }

    public Optional<TaskRecord> getTaskRecordById(Long id) {
        return taskRecordRepository.findById(id);
    }

    public Optional<TaskRecord> getTaskRecordByTaskId(String taskId) {
        return taskRecordRepository.findByTaskId(taskId);
    }

    public List<TaskRecord> getTaskRecordsByParticipantId(String participantId) {
        return taskRecordRepository.findByParticipantId(participantId);
    }

    public List<TaskRecord> getTaskRecordsByTaskType(TaskType taskType) {
        return taskRecordRepository.findByTaskType(taskType);
    }

    public List<TaskRecord> getTaskRecordsByTreatmentGroup(String treatmentGroup) {
        return taskRecordRepository.findByTreatmentGroup(treatmentGroup);
    }

    public TaskRecord createTaskRecord(TaskRecord taskRecord) {
            return taskRecordRepository.save(fillEntity(taskRecord));
    }

    public TaskRecord updateTaskRecord(String taskId, TaskRecord taskRecordDetails) {
//        return taskRecordRepository.findById(id)
//                .map(taskRecord -> {
//                    taskRecord.setParticipantId(taskRecordDetails.getParticipantId());
//                    taskRecord.setSid(taskRecordDetails.getSid());
//                    taskRecord.setTreatmentGroup(taskRecordDetails.getTreatmentGroup());
//                    taskRecord.setTaskTopic(taskRecordDetails.getTaskTopic());
//                    taskRecord.setTaskType(taskRecordDetails.getTaskType());
//                    taskRecord.setTaskStartTime(taskRecordDetails.getTaskStartTime());
//                    taskRecord.setTaskEndTime(taskRecordDetails.getTaskEndTime());
//                    taskRecord.setShowMoreInteractions(taskRecordDetails.getShowMoreInteractions());
//                    return taskRecordRepository.save(taskRecord);
//                })
//                .orElseThrow(() -> new RuntimeException("TaskRecord not found with id " + id));
        return taskRecordRepository.save(fillEntity(taskRecordDetails));
    }

    public void deleteTaskRecord(Long id) {
        taskRecordRepository.deleteById(id);
    }

    public void deleteAllTaskRecords() {
        taskRecordRepository.deleteAll();
    }

    public void deleteTaskRecordsByParticipantId(String participantId) {
        taskRecordRepository.deleteByParticipantId(participantId);
    }

    private TaskRecord fillEntity(TaskRecord taskRecord) {
        taskRecord.getClickSequence().forEach(clickEvent -> clickEvent.setTaskRecord(taskRecord));
        return taskRecord;
    }
}
