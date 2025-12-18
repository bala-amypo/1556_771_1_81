/**@Service
public class DisposalRecordServiceImpl implements DisposalRecordService {

    @Autowired
    private DisposalRecordRepository disposalRepository;

    @Autowired
    private AssetService assetService;

    
    @Override
    @Transactional
    public DisposalRecord createDisposal(Long assetId, DisposalRecord disposal) {
       
        disposal.setAssetId(assetId);
        
        
        DisposalRecord savedDisposal = disposalRepository.save(disposal);

        
        assetService.updateStatus(assetId, "DISPOSED");

        return savedDisposal;
    }

   
    @Override
    public DisposalRecord getDisposal(Long id) {
        return disposalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal record not found with id: " + id));
    }

   
    @Override
    public List<DisposalRecord> getAllDisposals() {
        return disposalRepository.findAll();
    }
}*/