package com.loan.hero.auth.user.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true,  nullable = false)
    private String email;

    private String password;

    @JsonUnwrapped
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private String userImage;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private final LocalDateTime registeredAt = LocalDateTime.now();

    private boolean enabled;

}
