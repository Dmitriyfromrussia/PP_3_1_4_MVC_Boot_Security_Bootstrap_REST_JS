package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.Role;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.User;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.services.RoleService;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.services.UserService;

import java.util.Set;

@Controller
public class RegistrationControllers {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();
        Set<Role> allRoles = roleService.findAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("allRoles", allRoles);
        return "admin/registration";
    }

    @PostMapping("/registration")
    public String registrationUser(@ModelAttribute("user") User user,
                                   @ModelAttribute("adminRole") String adminRole,
                                   @ModelAttribute("userRole") String userRole,
                                   Model model) {
        if (userService.isUserExist(user)) {
            model.addAttribute("error",
                    String.format("Пользователь с логином %s уже занят", user.getUsername()));
            return "admin/error-registration";
        } else {
            userService.create(user);
            return "redirect:/admin/all-users";
        }
    }
}
