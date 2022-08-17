package yte.intern.springapplication.authentication.user.controller.responses;


import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.springapplication.authentication.user.controller.requests.AddUserRequest;
import yte.intern.springapplication.authentication.user.service.CustomUserDetailsService;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.UserMessageResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping
    public UserMessageResponse addUser(@Valid @RequestBody AddUserRequest addUserRequest) {
        Random random = new Random();
        int value = random.nextInt(5) + 7;
        String password = RandomStringUtils.random(value,"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789._");
        return customUserDetailsService.addUser(addUserRequest.toDomainEntity(passwordEncoder.encode(password)),password);
    }

    @GetMapping
    public List<UserQueryModel> getAllUsers() {
        return customUserDetailsService.getAllUsers()
                .stream()
                .map(user -> new UserQueryModel(user))
                .toList();
    }

    @GetMapping("/{username}")
    public UserQueryModel getByUsername(@NotNull @PathVariable String username) {
        return new UserQueryModel(customUserDetailsService.findUserByUsername(username));
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteUserById(@PathVariable @NotNull Long id) {
        return customUserDetailsService.deleteUserById(id);
    }
}
