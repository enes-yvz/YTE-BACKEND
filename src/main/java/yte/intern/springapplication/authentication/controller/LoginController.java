package yte.intern.springapplication.authentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springapplication.authentication.controller.request.LoginRequest;
import yte.intern.springapplication.authentication.service.LoginService;
import yte.intern.springapplication.user.entity.User;
import yte.intern.springapplication.user.service.CustomUserDetailsService;
import yte.intern.springapplication.common.response.LoginMessageResponse;
import yte.intern.springapplication.common.response.ResponseType;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final LoginService loginService;

    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public LoginMessageResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        User user = customUserDetailsService.findUserByUsername(loginRequest.username());
        String json = user.toString();
        if(!passwordEncoder.matches(loginRequest.password(),user.getPassword())) {
            return new LoginMessageResponse(ResponseType.ERROR, "Wrong password", "{\"valid\":\"false\"}");
        }
        else if (user.getPassword().equals("XXXXXXXXX")) {
            return new LoginMessageResponse(ResponseType.ERROR, "User can't found",json);
        }
        else {
            return loginService.login(loginRequest,json);
        }

    }
}
