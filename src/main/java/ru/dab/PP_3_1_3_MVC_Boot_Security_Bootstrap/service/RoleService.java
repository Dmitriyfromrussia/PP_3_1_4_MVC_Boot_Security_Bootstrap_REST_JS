package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.service;


import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> findAllRoles();
}
