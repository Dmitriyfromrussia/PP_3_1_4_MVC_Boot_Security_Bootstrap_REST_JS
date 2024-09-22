package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.PostConstr;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.Role;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.User;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.repositories.RoleRepository;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.repositories.UserRepository;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.services.UserService;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitMethod {


    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    @Transactional
    public void init() {
        // Создание ролей
        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");
        roleRepository.save(userRole);
        roleRepository.save(adminRole);

        // Создание user
        User regularUser = new User();
        regularUser.setUsername("user");
        regularUser.setFirstName("user_firstname");
        regularUser.setLastName("user_lastname");
        regularUser.setPassword(bCryptPasswordEncoder.encode("user"));
        regularUser.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(regularUser);

        // Создание admin
        User adminUser = new User();
        adminUser.setFirstName("admin_firstname");
        adminUser.setLastName("admin_lastname");
        adminUser.setUsername("admin");
        adminUser.setPassword(bCryptPasswordEncoder.encode("admin"));
        adminUser.setRoles(new HashSet<>(Arrays.asList(adminRole)));
        userRepository.save(adminUser);
    }
}
