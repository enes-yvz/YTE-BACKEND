package yte.intern.springapplication.authentication.user.controller.requests;

import yte.intern.springapplication.authentication.entity.Authority;
import yte.intern.springapplication.authentication.user.entity.Role;
import yte.intern.springapplication.authentication.user.entity.User;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

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
