package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByName(String name);
}
