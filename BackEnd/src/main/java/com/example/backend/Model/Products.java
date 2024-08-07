package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "Name")
    String name;
    //    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    String image;
    @Column(name = "Price")
    Double price;
    @Column(name = "CreateDateProduct")
    Date createDateProduct;
    @Column(name = "Available")
    Boolean available;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    Categories categoryId;

}
