package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DisposalRecord;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DisposalRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DisposalRecordServiceImpl implements DisposalRecordService {

    private final DisposalRecordRepository disposalRepo;
    private final AssetRepository assetRepo;
    private final UserRepository userRepo;

    public DisposalRecordServiceImpl(DisposalRecordRepository disposalRepo,
                                     AssetRepository assetRepo,
                                     UserRepository userRepo) {
        this.disposalRepo = disposalRepo;
        this.assetRepo = assetRepo;
        this.userRepo = userRepo;
    }

    @Override
    public DisposalRecord createDisposal(Long assetId, DisposalRecord disposal) {

        Asset asset = assetRepo.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        User approver = userRepo.findById(disposal.getApprovedBy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!"ADMIN".equalsIgnoreCase(approver.getRole()))
            throw new ValidationException("Approver must be ADMIN");

        if (disposal.getDisposalDate().isAfter(LocalDate.now()))
            throw new ValidationException("Disposal date cannot be in the future");

        disposal.setAsset(asset);
        disposal.setApprovedBy(approver);

        DisposalRecord saved = disposalRepo.save(disposal);

        asset.setStatus("DISPOSED");
        assetRepo.save(asset);

        return saved;
    }

    @Override
    public DisposalRecord getDisposal(Long id) {
        return disposalRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal record not found"));
    }

    @Override
    public List<DisposalRecord> getAllDisposals() {
        return disposalRepo.findAll();
    }
}
