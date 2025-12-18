@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Asset createAsset(Asset asset) {
        
        return assetRepository.save(asset);
    }

    @Override
    public Asset getAsset(Long id) {
        
        return assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found with id: " + id));
    }

    @Override
    public List<Asset> getAllAssets() {
        
        return assetRepository.findAll();
    }

    @Override
    @Transactional
    public Asset updateStatus(Long assetId, String status) {
        
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot update status: Asset not found"));
        
        
        asset.setStatus(status);
        return assetRepository.save(asset);
    }
}