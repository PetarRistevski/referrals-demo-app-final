package com.petar.demo.referralsdemoapp.repository;

import com.petar.demo.referralsdemoapp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String user_name);

}