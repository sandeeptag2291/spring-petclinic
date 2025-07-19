package org.springframework.samples.petclinic.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.samples.petclinic.owner.Pet;

@Entity
@Table(name = "pet_attributes")
@Data
public class PetAttributes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	private String temperament;

	private Double length;

	private Double weight;

	// Getters and Setters
}
