package com.moaaz.train.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "request")
@Getter
@Setter
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "You Should Tell Us The Begin Of The Line ")
    @NotNull(message = "You Should Tell Us The Begin Of The Line ")
    private String fromStation;
    @NotEmpty(message = "You Should Tell Us The End Of The Line ")
    @NotNull(message = "You Should Tell Us The End Of The Line ")
    private String toStation;
    private String message;
    private LocalDateTime time;
    @ManyToOne
    @JsonIgnore
    private User user;

}
