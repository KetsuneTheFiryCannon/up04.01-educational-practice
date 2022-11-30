package com.ruscript.tutorialproject.service;

import com.ruscript.tutorialproject.model.Role;
import com.ruscript.tutorialproject.model.User;
import com.ruscript.tutorialproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(UUID uuid){ return userRepository.findById(uuid).orElse(null); }

    public User findByUserloginContainsIgnoreCase (String s) { return  userRepository.findByUserlogin(s); }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(UUID uuid){
        userRepository.deleteById(uuid);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserlogin(username);
        return new UserDetailsPrincipal(user);
    }
}
