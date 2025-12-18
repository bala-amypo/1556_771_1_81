@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email is already in use.");
        }
        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new RuntimeException("Password must be at least 8 characters.");
        }
        if (user.getDepartment() == null || user.getDepartment().isEmpty()) {
            throw new RuntimeException("Department is required.");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")); //
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(); //
    }
}