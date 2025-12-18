@Service
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Asset createAsset(Asset asset) {
        return assetRepository.save(asset); //
    }

    @Override
    public Asset getAsset(Long id) {
        
        return assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found with id: " + id));
    }

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll(); //
    }

    @Override
    @Transactional
    public void updateStatus(Long assetId, String status) {
        Asset asset = getAsset(assetId); //
        asset.setStatus(status); //
        assetRepository.save(asset);
    }
}