package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.PetAttributes;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.repository.PetAttributesRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetAttributesService {

	@Autowired
	private PetAttributesRepository repository;

	@Autowired
	private PetRepository petRepository;

	public PetAttributes save(PetAttributes attributes) {
//		if (attributes.getPet() != null && attributes.getPet().getId() != null) {
//			Pet pet = petRepository.findById(attributes.getPet().getId().longValue())
//				.orElseThrow(() -> new RuntimeException("Pet not found"));
//			attributes.setPet(pet); // Fully attach the Pet entity
//		}
		return repository.save(attributes);
	}

	public PetAttributes getByPetId(int petId) {
		return repository.findByPetId(petId);
	}
}
