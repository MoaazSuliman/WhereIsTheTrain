package com.moaaz.train.model;

import java.time.LocalTime;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.apache.catalina.LifecycleState;

@Entity
@Table(name = "Station")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
//    @NotEmpty(message = "Number Of Station In Line Must Not Be Empty")
    private int numberInLine;
    private String name;
    @OneToOne
    private Location location;
    @ElementCollection // 1
    @CollectionTable(name = "trains_time_for_stations", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "train_time") // 3
    private List<String> trainTime;
   @ManyToOne
   @JsonIgnore
    private Line line;



}
