package com.example.demo.service;

import com.example.demo.entity.LifecycleEvent;
import java.util.List;

public interface LifecycleEventService {
    LifecycleEvent logEvent(LifecycleEvent event);
    List<LifecycleEvent> getEventsByAsset(Long assetId);
}
