package com.student.studentmanagement.service;

import com.student.studentmanagement.model.User;
import com.student.studentmanagement.model.UserRole;
import com.student.studentmanagement.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // no credential repository — password stored on User entity

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Transactional
    public User createAdminIfNotExists(String username, String rawPassword) {
        return repository.findByUsername(username)
                .map(existing -> {
                    // migrate older user without password by adding encoded password
                    if (existing.getPassword() == null || existing.getPassword().isBlank()) {
                        existing.setPassword(passwordEncoder.encode(rawPassword));
                        return repository.save(existing);
                    }
                    return existing;
                })
                .orElseGet(() -> {
                        User admin = new User();
                        admin.setUsername(username);
                        admin.setPassword(passwordEncoder.encode(rawPassword));
                    admin.setRole(UserRole.ADMIN);
                    return repository.save(admin);
                });
    }

    @Transactional
    public User createUser(String username, String rawPassword, UserRole role) {
        if (repository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists: " + username);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(role);
        return repository.save(user);
    }
}

