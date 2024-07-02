package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "Username")
    Accounts userName;
    @Column(name = "CreateDateOrder")
    Date createDateOrder;
    @Column(name = "Address")
    String address;


}
