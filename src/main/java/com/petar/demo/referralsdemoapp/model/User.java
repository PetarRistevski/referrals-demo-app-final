package com.petar.demo.referralsdemoapp.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "code_to_register")
    private String code_to_register;

    @Column(name = "auto_generated_code")
    private String auto_generated_code;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode_to_register() {
        return code_to_register;
    }

    public void setCode_to_register(String code_to_register) {
        this.code_to_register = code_to_register;
    }

    public String getAuto_generated_code() {
        return auto_generated_code;
    }

    public void setAuto_generated_code(String auto_generated_code) {
        this.auto_generated_code = auto_generated_code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
