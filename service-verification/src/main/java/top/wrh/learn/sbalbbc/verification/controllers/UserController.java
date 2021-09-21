package top.wrh.learn.sbalbbc.verification.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("")
    public Object currentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }
}
