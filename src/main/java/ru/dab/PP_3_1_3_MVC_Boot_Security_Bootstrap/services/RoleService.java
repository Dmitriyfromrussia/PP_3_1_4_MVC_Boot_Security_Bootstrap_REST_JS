package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.services;

import org.springframework.stereotype.Service;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.Role;

import java.util.Set;

@Service
public interface RoleService {
    Set<Role> findAllRoles();

}
