package com.example.demo.service;

import com.example.demo.entity.Asset;

import java.util.List;

public interface AssetService {
    List<Asset> getAllAssets();
    Asset createAsset(Asset asset);
    Asset getAssetById(Long id);
    void deleteAsset(Long id);
}
