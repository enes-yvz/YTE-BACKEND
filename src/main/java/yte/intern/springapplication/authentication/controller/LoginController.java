package yte.intern.springapplication.authentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springapplication.authentication.controller.request.LoginRequest;
import yte.intern.springapplication.authentication.service.LoginService;
import yte.intern.springapplication.authentication.user.entity.User;
import yte.intern.springapplication.authentication.user.service.CustomUserDetailsService;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.ResponseType;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public MessageResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        User user = customUserDetailsService.findUserByUsername(loginRequest.username());
        if (user.getPassword().equals("XXXXXXXXX")) {
            return new MessageResponse(ResponseType.ERROR, "User can't found");
        }
        else {
            return loginService.login(loginRequest);
        }

    }
}
