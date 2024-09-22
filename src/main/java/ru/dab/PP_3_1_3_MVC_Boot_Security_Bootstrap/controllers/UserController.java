package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.User;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/auth")
    public ResponseEntity<User> getApiAuthUser(@AuthenticationPrincipal User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}