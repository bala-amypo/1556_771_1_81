package com.example.demo.service;

import com.example.demo.entity.Asset;

public interface AssetService {

    Asset saveAsset(Asset asset);

    Asset updateStatus(Long assetId, String status); // 👈 REQUIRED
}
