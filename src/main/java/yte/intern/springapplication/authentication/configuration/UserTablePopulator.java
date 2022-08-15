package yte.intern.springapplication.authentication.configuration;

/*

@Component
@RequiredArgsConstructor
public class UserTablePopulator {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void populateDatabase() {

        if (!userRepository.existsByUsername("user")) {
            User user = new User("user", passwordEncoder.encode("user"), List.of(new Authority("USER")));
            userRepository.save(user);
        }
        if (!userRepository.existsByUsername("admin")) {
            User user = new User("admin", passwordEncoder.encode("admin"), List.of(new Authority("ADMIN")));
            userRepository.save(user);
        }
    }

}
*/
