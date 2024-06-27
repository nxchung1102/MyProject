package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Accounts")
public class Accounts {
    @Id
    @Column(name = "Email")
    String email;
    @Column(name = "Password")
    String passWord;
    @Column(name = "Fullname")
    String fullName;
    @Column(name = "Photo")
    String photo;
    @ManyToMany
    Set<Roles> roles;

}
