package com.moaaz.train.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name="Train")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@NotEmpty(message = "Number of The Train Must Not Be Empty...")
	@NotNull(message = "Number of The Train Must Not Be Empty...")
	private int numberOfTrain;
	@OneToMany
	@JoinColumn(name = "train_id" , referencedColumnName = "id")
	private List<Location> location;
	@ManyToOne
	@JsonIgnore
	private Line line;

	public void addLocationForTrain(Location location){
		this.location.add(location);
	}
}
