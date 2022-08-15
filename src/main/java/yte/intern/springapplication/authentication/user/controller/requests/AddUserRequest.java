package yte.intern.springapplication.authentication.user.controller.requests;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import yte.intern.springapplication.authentication.entity.Authority;
import yte.intern.springapplication.authentication.user.entity.Role;
import yte.intern.springapplication.authentication.user.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Random;

public record AddUserRequest(

        @NotBlank
        @Size(max = 25)
        String name,
        @NotBlank
        @Size(max = 25)
        String surname,
        @Email
        String email,
        @NotBlank
        @Size(max = 25)
        String username,
        @NotBlank
        String role
) {

        public User toDomainEntity(String password) {

                return new User(username, password, name, surname, email, Role.valueOf(role), List.of(new Authority(role)));
        }

}
