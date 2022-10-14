package com.inventarymanagementsystem.InventaryMangementSystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name="login")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
    private String role;

}
