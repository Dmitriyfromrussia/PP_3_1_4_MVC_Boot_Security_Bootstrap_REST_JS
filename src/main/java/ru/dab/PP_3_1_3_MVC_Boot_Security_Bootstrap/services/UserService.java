package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.services;


import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.User;

import java.util.List;

public interface UserService {
    void create(User user);

    void update(User user);

    void delete(Long id);

    User findById(Long id);

    List<User> listUsers();
}