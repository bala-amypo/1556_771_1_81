package com.example.demo.service.impl;

import com.example.demo.entity.TransferRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.service.TransferRecordService;

import java.util.List;

public class TransferRecordServiceImpl implements TransferRecordService {

    private final TransferRecordRepository transferRecordRepository;

    public TransferRecordServiceImpl(TransferRecordRepository transferRecordRepository) {
        this.transferRecordRepository = transferRecordRepository;
    }

    @Override
    public TransferRecord createTransfer(Long assetId, TransferRecord record) {
        return transferRecordRepository.save(record);
    }

    @Override
    public List<TransferRecord> getTransfersForAsset(Long assetId) {
        return transferRecordRepository.findByAsset_Id(assetId);
    }

    @Override
    public TransferRecord getTransfer(Long id) {
        return transferRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transfer record not found"));
    }
}
