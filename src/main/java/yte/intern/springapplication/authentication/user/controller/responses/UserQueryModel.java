package yte.intern.springapplication.authentication.user.controller.responses;

import yte.intern.springapplication.authentication.user.entity.Role;
import yte.intern.springapplication.authentication.user.entity.User;

public record UserQueryModel(
        String username,
        String password,
        String name,
        String surname,
        String email,
        Role role
) {

    public UserQueryModel(User user) {
        this(
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getRole()
        );
    }
}