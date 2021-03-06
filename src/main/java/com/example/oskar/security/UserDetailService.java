package com.example.oskar.security;

import com.example.oskar.entity.UserEntity;
import com.example.oskar.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class UserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepositoryBean(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    Logger logger = LoggerFactory.getLogger(UserDetailService.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUserModel = userRepository.findByUsername(username);
        if (optionalUserModel.isEmpty()) throw new UsernameNotFoundException("Could not find " + username + " as registered");
        UserEntity userEntity = optionalUserModel.get();
        //TODO remove logger
        logger.info("UserDetailsServ " + userEntity.getUsername() + "\n" + userEntity.getPassword());
        return new org.springframework.security.core.userdetails.User(
                username,
                userEntity.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
