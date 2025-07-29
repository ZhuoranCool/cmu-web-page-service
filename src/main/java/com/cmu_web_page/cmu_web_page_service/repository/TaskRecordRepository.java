package com.cmu_web_page.cmu_web_page_service.repository;

import com.cmu_web_page.cmu_web_page_service.model.TaskRecord;
import com.cmu_web_page.cmu_web_page_service.model.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRecordRepository extends JpaRepository<TaskRecord, Long> {
    
    List<TaskRecord> findByParticipantId(String participantId);
    
    List<TaskRecord> findByTaskType(TaskType taskType);
    
    List<TaskRecord> findByTreatmentGroup(String treatmentGroup);
    
    Optional<TaskRecord> findByTaskId(String taskId);
    
    @Query("SELECT tr FROM TaskRecord tr WHERE tr.participantId = :participantId AND tr.taskType = :taskType")
    List<TaskRecord> findByParticipantIdAndTaskType(@Param("participantId") String participantId, 
                                                   @Param("taskType") TaskType taskType);
    
    void deleteByParticipantId(String participantId);
}
