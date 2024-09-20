package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.User;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.services.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String goToUserPage(Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        String username = currentUser.getUsername();
        User user = userService.getByUsername(username);
        model.addAttribute("user", user);
        return "/user";
    }
}

