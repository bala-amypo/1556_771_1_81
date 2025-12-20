// File: src/main/java/com/example/demo/controller/AssetController.java
package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
    
    private final AssetService assetService;
    
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }
    
    @PostMapping
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        Asset createdAsset = assetService.createAsset(asset);
        return ResponseEntity.ok(createdAsset);
    }
    
    @GetMapping
    public ResponseEntity<List<Asset>> getAllAssets() {
        List<Asset> assets = assetService.getAllAssets();
        return ResponseEntity.ok(assets);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAsset(@PathVariable Long id) {
        Asset asset = assetService.getAsset(id);
        return ResponseEntity.ok(asset);
    }
    
    @PutMapping("/status/{id}")
    public ResponseEntity<Asset> updateStatus(@PathVariable Long id, 
                                             @RequestParam String status) {
        Asset asset = assetService.updateStatus(id, status);
        return ResponseEntity.ok(asset);
    }
}