package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    //Optional<User> findByUsername (String username);
}

