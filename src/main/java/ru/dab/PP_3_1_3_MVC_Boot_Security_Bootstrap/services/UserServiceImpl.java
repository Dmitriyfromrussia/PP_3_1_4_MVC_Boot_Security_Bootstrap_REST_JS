package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.services;

import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.models.User;
import ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void create(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        User user1 = userRepository.getUserById(user.getId());
        if(user1 != null) {
            if(!user1.getPassword().equals(user.getPassword())) {
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            }
            userRepository.save(user);
        } else {
            throw new EntityExistsException(String.format("User with id=%s not found", user.getId()));
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isUserExist(User user) {
        return userRepository.findByUsername(user.getUsername()) != null; //сли юзер есть - true
    }
}
