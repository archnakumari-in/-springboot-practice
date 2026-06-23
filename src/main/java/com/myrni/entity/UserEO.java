package com.myrni.entity;

import com.myrni.Enum.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String mobileNo;

    @Column(nullable = false)
    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;
}