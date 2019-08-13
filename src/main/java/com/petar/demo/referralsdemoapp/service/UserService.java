package com.petar.demo.referralsdemoapp.service;

import com.petar.demo.referralsdemoapp.model.User;

import java.util.Optional;


public interface UserService extends BaseEntityService<User> {
//    Category saveCategory (String name);
//    List<Category> findAllCategories();
       Optional<User> findByUsername (String user_name);
}