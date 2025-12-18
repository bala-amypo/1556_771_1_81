/**@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AssetService assetService;

    @Override
    @Transactional
    public Assignment assignAsset(Long userId, Long assetId) {
        
        User user = userService.getUser(userId);

        
        Asset asset = assetService.getAsset(assetId);

        
        Assignment assignment = new Assignment();
        assignment.setUser(user);
        assignment.setAsset(asset);
        assignment.setAssignmentDate(LocalDate.now());
        assignment.setActive(true);


        assetService.updateStatus(assetId, "ASSIGNED");

        return assignmentRepository.save(assignment);
    }

    @Override
    public List<Assignment> getAssignmentsByUser(Long userId) {
        
        userService.getUser(userId); 
        return assignmentRepository.findByUserIdAndActiveTrue(userId);
    }

    @Override
    @Transactional
    public void revokeAsset(Long assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));

        assignment.setActive(false);
        
        
        assetService.updateStatus(assignment.getAsset().getId(), "AVAILABLE");
        
        assignmentRepository.save(assignment);
    }
}*/