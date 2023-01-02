package com.social.social.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "user")
@Data
@Entity
public class User {
    @Id
    Long id;

    String userName;
    String password;

}
