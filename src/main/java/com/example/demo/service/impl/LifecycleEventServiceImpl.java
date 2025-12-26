package com.example.demo.service.impl;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.repository.LifecycleEventRepository;
import com.example.demo.service.LifecycleEventService;

import java.util.List;

public class LifecycleEventServiceImpl implements LifecycleEventService {

    private final LifecycleEventRepository lifecycleEventRepository;

    public LifecycleEventServiceImpl(LifecycleEventRepository lifecycleEventRepository) {
        this.lifecycleEventRepository = lifecycleEventRepository;
    }

    @Override
    public LifecycleEvent logEvent(LifecycleEvent event) {
        return lifecycleEventRepository.save(event);
    }

    @Override
    public List<LifecycleEvent> getEventsByAsset(Long assetId) {
        return lifecycleEventRepository.findByAsset_Id(assetId);
    }
}
