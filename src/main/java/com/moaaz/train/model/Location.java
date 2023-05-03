package com.moaaz.train.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String detail;
    private String time;

    @Column(name = "userThatSetThisPositionForTrain")
    private int user_id;

}
