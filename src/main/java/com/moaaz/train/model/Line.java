package com.moaaz.train.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "Line")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name Must Not Be Empty")
    @NotNull(message = "Name Must Not Be Null")
    private String name;
//    @NotEmpty(message = "Stations List Must Not Be Empty")
//    @NotNull(message = "Stations List Must Not Be Null")
    @OneToMany

    @JoinColumn(referencedColumnName = "id", name = "line_id")
    private List<Station> stations;

    @OneToMany
    @JoinColumn(referencedColumnName = "id", name = "line_id")
    private List<Train> trains;

    @ManyToMany(mappedBy = "lines")
    private List<User> users;


}
