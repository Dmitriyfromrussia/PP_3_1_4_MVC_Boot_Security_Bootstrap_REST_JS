package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.Role;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }
}