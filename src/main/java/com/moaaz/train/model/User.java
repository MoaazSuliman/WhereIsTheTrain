package com.moaaz.train.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends Person {

    @ManyToMany
    @JoinTable(name = "user_line", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "line_id")})
    @JsonIgnore
    private List<Line> lines;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private Location location;


    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Request> requests;

    @OneToOne
    private Role role;

    public void addLine(Line line) {
        this.lines.add(line);
    }

    public void addRequest(Request request) {
        this.requests.add(request);
    }


}
