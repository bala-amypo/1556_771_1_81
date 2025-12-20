package com.example.demo.repository;

import com.example.demo.entity.Asset;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AssetRepository {

    private final List<Asset> assetList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Asset> findAll() {
        return assetList;
    }

    public Optional<Asset> findById(Long id) {
        return assetList.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public Asset save(Asset asset) {
        if (asset.getId() == null) {
            asset.setId(idCounter.getAndIncrement());
        } else {
            assetList.removeIf(a -> a.getId().equals(asset.getId()));
        }
        assetList.add(asset);
        return asset;
    }

    public void deleteById(Long id) {
        assetList.removeIf(a -> a.getId().equals(id));
    }
}
