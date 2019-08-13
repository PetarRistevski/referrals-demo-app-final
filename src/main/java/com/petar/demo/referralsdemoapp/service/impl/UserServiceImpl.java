package com.petar.demo.referralsdemoapp.service.impl;


import com.petar.demo.referralsdemoapp.model.User;
import com.petar.demo.referralsdemoapp.repository.UserRepository;
import com.petar.demo.referralsdemoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(repository.getOne(id));
    }

    @Override
    public Collection<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String user_name) {
        return Optional.of(repository.findByUsername(user_name));
    }
}