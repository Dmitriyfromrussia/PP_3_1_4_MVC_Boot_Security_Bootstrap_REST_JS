package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.repositories.UserRepository;

@Controller
public class LoginController {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String mainPage() {
        return "/login";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }
}
