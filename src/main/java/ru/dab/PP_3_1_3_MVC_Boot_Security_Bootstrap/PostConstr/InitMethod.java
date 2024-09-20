package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.PostConstr;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.Role;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.User;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.services.UserService;


import java.util.HashSet;
import java.util.Set;

@Component
public class InitMethod {


    @Autowired
    private UserService userService;

    @PostConstruct
    @Transactional
    public void init() {
        // Создание ролей
        Role userRole = new Role("USER");
        Role adminRole = new Role("ADMIN");

        // Создание user
        Set<Role> userRoleList = new HashSet<>();
        userRoleList.add(userRole);
        User regularUser = new User("user", "user", "user@mail.ru", "user", "user", userRoleList);
        userService.create(regularUser);

        // Создание admin
        Set<Role> adminRoleList = new HashSet<>();
        adminRoleList.add(adminRole);
        User adminUser = new User("admin", "admin", "admin@mail.ru", "admin", "admin", adminRoleList);
        userService.create(adminUser);
    }
}
