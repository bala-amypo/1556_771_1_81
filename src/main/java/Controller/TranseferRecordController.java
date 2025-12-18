/**@Service
public class TransferRecordServiceImpl implements TransferRecordService {
    @Autowired
    private TransferRecordRepository transferRepository;

    @Override
    public TransferRecord createTransfer(Long assetId, TransferRecord record) {
        if (record.getTransferDate() != null && record.getTransferDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Transfer date cannot be in the future.");
        }
        record.setAssetId(assetId); //
        return transferRepository.save(record);
    }

    @Override
    public List<TransferRecord> getTransfersForAsset(Long assetId) {
        return transferRepository.findByAssetId(assetId); //
    }

    @Override
    public TransferRecord getTransfer(Long id) {
        return transferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transfer record not found")); //
    }
}*/