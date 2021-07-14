package com;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {

        this.repo = repo;

    }

    @Transactional
    public Optional<User> findUserByEmail(String email) {
        return repo.findByUserEmail(email);
    }


    public User save(User user) throws Exception {

        Optional<User> userByEmail = repo.findByUserEmail(user.getEmail());
        if (userByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            return repo.save(user);
        }
    }

    public String validation(User user) {

        Optional<User> userByRole = repo.findUserByRole(user.getRole());

        if (userByRole.equals("Supervisor")) {
            return "Supervisor";
        } else
            return "Inspector";
    }

}



