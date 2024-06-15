package com.example.backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Accounts")
public class Accounts {
    @Id
    @Column(name = "Username")
    String userName;
    @Column(name = "Password")
    String passWord;
    @Column(name = "Fullname")
    String fullName;
    @Column(name = "Email")
    String email;
    @Column(name = "Photo")
    String photo;


}
