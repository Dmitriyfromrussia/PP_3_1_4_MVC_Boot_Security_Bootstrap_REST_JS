package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getByRoleName(String roleName);
}
