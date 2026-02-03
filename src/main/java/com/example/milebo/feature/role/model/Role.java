package com.example.milebo.feature.role.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Roles")
@Data
public class Role {

    @Id
    private Integer id;

    @Column(unique = true, length = 20)
    private String name;
}
