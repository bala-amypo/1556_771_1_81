// File: src/main/java/com/example/demo/repository/DisposalRecordRepository.java
package com.example.demo.repository;

import com.example.demo.entity.DisposalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DisposalRecordRepository extends JpaRepository<DisposalRecord, Long> {
}