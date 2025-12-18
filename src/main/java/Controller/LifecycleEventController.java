/**@Service
public class LifecycleEventServiceImpl implements LifecycleEventService {
    @Autowired
    private LifecycleEventRepository eventRepository;

    @Override
    public void logEvent(Long assetId, Long userId, LifecycleEvent event) {
        event.setAssetId(assetId); //
        event.setUserId(userId); //
        event.setTimestamp(LocalDateTime.now());
        eventRepository.save(event);
    }

    @Override
    public List<LifecycleEvent> getEventsForAsset(Long assetId) {
        return eventRepository.findByAssetId(assetId); //
    }

    @Override
    public LifecycleEvent getEvent(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found")); //
    }
}*/