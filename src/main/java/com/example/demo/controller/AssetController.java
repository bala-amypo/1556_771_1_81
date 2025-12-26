package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping
    public Asset create(@RequestBody Asset asset) {
        return assetService.createAsset(asset);
    }

    @GetMapping("/{id}")
    public Asset get(@PathVariable Long id) {
        return assetService.getAsset(id);
    }

    @GetMapping
    public List<Asset> all() {
        return assetService.getAllAssets();
    }

    @PutMapping("/{id}/status")
    public Asset updateStatus(@PathVariable Long id,
                              @RequestParam String status) {
        return assetService.updateStatus(id, status);
    }
}
