package com.moaaz.train.model;

import jakarta.persistence.*;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

}
