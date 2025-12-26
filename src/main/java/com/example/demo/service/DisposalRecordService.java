package com.example.demo.service;

import com.example.demo.entity.DisposalRecord;
import java.util.List;

public interface DisposalRecordService {

    DisposalRecord createDisposal(Long assetId, DisposalRecord record);

    List<DisposalRecord> getAllDisposals();

    DisposalRecord getDisposal(Long id);
}
