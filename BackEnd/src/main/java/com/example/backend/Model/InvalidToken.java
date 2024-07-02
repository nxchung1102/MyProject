package com.example.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Builder
@Setter
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
@Table(name = "InvalidToken")
public class InvalidToken {
    @Id
    String id;
    Date expirationTime;
}
