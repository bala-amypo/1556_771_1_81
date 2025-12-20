// File: src/main/java/com/example/demo/repository/LifecycleEventRepository.java
package com.example.demo.repository;

import com.example.demo.entity.LifecycleEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LifecycleEventRepository extends JpaRepository<LifecycleEvent, Long> {
    List<LifecycleEvent> findByAssetId(Long assetId);
}