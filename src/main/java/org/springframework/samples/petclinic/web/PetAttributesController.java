package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.PetAttributes;
import org.springframework.samples.petclinic.service.PetAttributesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pet-attributes")
public class PetAttributesController {

	@Autowired
	private PetAttributesService service;

	@PostMapping
	public PetAttributes addAttributes(@RequestBody PetAttributes attributes) {
		return service.save(attributes);
	}

	@GetMapping("/{petId}")
	public PetAttributes getAttributes(@PathVariable int petId) {
		return service.getByPetId(petId);
	}
}
