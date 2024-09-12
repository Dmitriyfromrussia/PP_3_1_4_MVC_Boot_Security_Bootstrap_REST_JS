package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.PostConstr;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.Role;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.User;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.service.UserService;


import java.util.HashSet;
import java.util.Set;

@Component
public class InitMethod {


    private final UserService userService;

    @Autowired
    public InitMethod(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    @Transactional
    public void init() {



        Role userRole = new Role("ROLE_USER");
        Set<Role> usersRoleList = new HashSet<>();
        usersRoleList.add(userRole);
        User defaultUser = new User("user", 37, "user@mail.ru", "user", usersRoleList);
        userService.create(defaultUser);


        Role adminRole = new Role("ROLE_ADMIN");
        Set <Role> adminRoleList = new HashSet<>();
        adminRoleList.add(adminRole);
        User defaultAdmin = new User("admin", 38, "admin@mail.ru", "admin", adminRoleList);
        userService.create(defaultAdmin);
    }
}
