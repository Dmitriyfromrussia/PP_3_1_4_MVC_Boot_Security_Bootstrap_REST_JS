package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/admin")
    public String goToAdminPage(){
        return "/admin";
    }

    @GetMapping("/user")
    public String goToUserPage() {
        return "/user";
    }
}
