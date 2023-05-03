package com.moaaz.train.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "Admin")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Admin extends Person {

//    @OneToOne
//    private Role role;


}
