package yte.intern.springapplication.authentication.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yte.intern.springapplication.authentication.entity.Authority;
import yte.intern.springapplication.authentication.user.entity.Role;
import yte.intern.springapplication.authentication.user.entity.User;
import yte.intern.springapplication.authentication.user.repository.UserRepository;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.ResponseType;
import yte.intern.springapplication.common.response.UserMessageResponse;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User %s is not found".formatted(username)));
    }

    public User findUserByUsername(String username) {

        User user;

        try {

            user = userRepository.findOneUserByUsername(username);

            if (user == null) {

                user = new User("X","XXXXXXXXXX","X","X","X",Role.STUDENT, List.of(new Authority("STUDENT")));

            }

            return user;

        } catch (Exception exception) {

            user = new User("X","XXXXXXXXXX","X","X","X",Role.STUDENT, List.of(new Authority("STUDENT")));

            return user;

        }
    }

    public UserMessageResponse addUser(User user,String password) {

        System.out.println(userRepository.findByUsername(user.getUsername()));

        if (userRepository.findByUsername(user.getUsername()).isPresent() || userRepository.findByEmail(user.getEmail()).isPresent()){

            return new UserMessageResponse(ResponseType.ERROR, "User already exist", password);

        }

        else {

            userRepository.save(user);

            return new UserMessageResponse(ResponseType.SUCCESS, "User has been added successfully",password);

        }

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public MessageResponse deleteUserById(Long id) {
        userRepository.deleteById(id);

        return new MessageResponse(ResponseType.SUCCESS, "User has been deleted successfully");
    }
}