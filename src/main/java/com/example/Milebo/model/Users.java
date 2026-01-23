package com.example.Milebo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {

    @Id
    private String id;

    private String name;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;
}
