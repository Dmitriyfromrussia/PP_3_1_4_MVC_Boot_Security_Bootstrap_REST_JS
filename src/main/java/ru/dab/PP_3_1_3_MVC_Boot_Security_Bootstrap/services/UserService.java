package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.services;

import org.springframework.stereotype.Service;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.User;

import java.util.List;

@Service
public interface UserService {

    void create(User user);

    void update(User user);

    void delete(Long id);

    User getById(Long id);

    User getByUsername(String username);

    List<User> findAllUsers();

    boolean isUserExist(User user);
}
