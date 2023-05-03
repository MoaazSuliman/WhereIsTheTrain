package com.moaaz.train.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "Role")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Role Type Must Not Be Null...")
    @NotEmpty(message = "Role Type Must Not Be Empty...")
    private String role;// Admin Or User.
    @NotNull(message = "Role Page Must Not Be Null...")
    @NotEmpty(message = "Role Page Must Not Be Empty...")
    private String page;
}
