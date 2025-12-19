package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.AssetService;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public Asset saveAsset(Asset asset) {
        asset.setStatus("ACTIVE");
        return assetRepository.save(asset);
    }

    // ✅ THIS METHOD FIXES YOUR ERROR
    @Override
    public Asset updateStatus(Long assetId, String status) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        asset.setStatus(status);
        return assetRepository.save(asset);
    }
}
