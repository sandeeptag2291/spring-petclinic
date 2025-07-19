package org.springframework.samples.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.PetAttributes;

public interface PetAttributesRepository extends CrudRepository<PetAttributes, Integer> {
	PetAttributes findByPetId(int petId);
}

