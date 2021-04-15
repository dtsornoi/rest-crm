package com.employee.crm.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
            targetEntity = User.class,
            mappedBy = "role",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<User> users;
}
