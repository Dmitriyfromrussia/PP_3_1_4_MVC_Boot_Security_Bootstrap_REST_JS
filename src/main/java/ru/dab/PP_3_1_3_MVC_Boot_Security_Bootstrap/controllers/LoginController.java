package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/hello")
    public String hellopage() {
        return "/hellopage";
    }


}
