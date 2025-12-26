package com.example.demo.service.impl;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LifecycleEventRepository;
import com.example.demo.service.LifecycleEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ✅ REQUIRED
public class LifecycleEventServiceImpl implements LifecycleEventService {

    private final LifecycleEventRepository lifecycleEventRepository;

    public LifecycleEventServiceImpl(LifecycleEventRepository lifecycleEventRepository) {
        this.lifecycleEventRepository = lifecycleEventRepository;
    }

    @Override
    public LifecycleEvent logEvent(Long assetId, Long userId, LifecycleEvent event) {
        return lifecycleEventRepository.save(event);
    }

    @Override
    public List<LifecycleEvent> getEventsForAsset(Long assetId) {
        return lifecycleEventRepository.findByAsset_Id(assetId);
    }

    @Override
    public LifecycleEvent getEvent(Long id) {
        return lifecycleEventRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Lifecycle event not found"));
    }
}
