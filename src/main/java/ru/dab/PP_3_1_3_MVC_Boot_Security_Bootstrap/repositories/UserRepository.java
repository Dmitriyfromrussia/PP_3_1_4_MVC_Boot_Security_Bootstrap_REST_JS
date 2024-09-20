package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User getUserById(Long id);
}
