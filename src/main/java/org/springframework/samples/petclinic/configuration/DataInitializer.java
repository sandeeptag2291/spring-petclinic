package org.springframework.samples.petclinic.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.samples.petclinic.model.PetAttributes;
import org.springframework.samples.petclinic.owner.*;
import org.springframework.samples.petclinic.repository.PetAttributesRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.SpecialtyRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

	private final VetRepository vetRepository;
	private final SpecialtyRepository specialtyRepository;
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final VisitRepository visitRepository;
	private final PetTypeRepository petTypeRepository;
	private final PetAttributesRepository petAttributesRepository;

	public DataInitializer(
		VetRepository vetRepository,
		SpecialtyRepository specialtyRepository,
		OwnerRepository ownerRepository,
		PetRepository petRepository,
		VisitRepository visitRepository,
		PetTypeRepository petTypeRepository,
		PetAttributesRepository petAttributesRepository
	) {
		this.vetRepository = vetRepository;
		this.specialtyRepository = specialtyRepository;
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.visitRepository = visitRepository;
		this.petTypeRepository = petTypeRepository;
		this.petAttributesRepository=petAttributesRepository;
	}

	@Override
	public void run(String... args) {
		// --- Specialties ---
		Specialty radiology = new Specialty();
		radiology.setName("radiology");
		radiology = specialtyRepository.save(radiology);

		Specialty surgery = new Specialty();
		surgery.setName("surgery");
		surgery = specialtyRepository.save(surgery);

		Specialty dentistry = new Specialty();
		dentistry.setName("dentistry");
		dentistry = specialtyRepository.save(dentistry);

		Set<Specialty> specialties = new HashSet<>();
		specialties.add(surgery);
		specialties.add(dentistry);
		// --- Vets ---
		Vet vet1 = new Vet();
		vet1.setFirstName("James");
		vet1.setLastName("Carter");
		vetRepository.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Helen");
		vet2.setLastName("Leary");
		vet2.setSpecialties(specialties);
		vetRepository.save(vet2);

		Vet vet3 = new Vet();
		vet3.setFirstName("Linda");
		vet3.setLastName("Douglas");
		vet3.setSpecialties(specialties);
		vetRepository.save(vet3);

		Vet vet4 = new Vet();
		vet4.setFirstName("Rafael");
		vet4.setLastName("Ortega");
		vet4.setSpecialties(Set.of(surgery));
		vetRepository.save(vet4);

		Vet vet5 = new Vet();
		vet5.setFirstName("Henry");
		vet5.setLastName("Stevens");
		vet5.setSpecialties(Set.of(radiology));
		vetRepository.save(vet5);

		Vet vet6 = new Vet();
		vet6.setFirstName("Sharon");
		vet6.setLastName("Jenkins");
		vetRepository.save(vet6);

		// --- Pet Types ---
		PetType cat = new PetType();
		cat.setName("cat");
		cat = petTypeRepository.save(cat);

		PetType dog = new PetType();
		dog.setName("dog");
		dog = petTypeRepository.save(dog);

		// Add other pet types similarly...

		// --- Owners ---
		Owner o1 = new Owner();
		o1.setFirstName("George");
		o1.setLastName("Franklin");
		o1.setAddress("110 W. Liberty St.");
		o1.setCity("Madison");
		o1.setTelephone("6085551023");
		ownerRepository.save(o1);

		Owner o2 = new Owner();
		o2.setFirstName("Betty");
		o2.setLastName("Davis");
		o2.setAddress("638 Cardinal Ave.");
		o2.setCity("Sun Prairie");
		o2.setTelephone("6085551749");
		ownerRepository.save(o2);

		// Add other owners similarly...

		// --- Pets ---
		Pet pet1 = new Pet();
		pet1.setName("Leo");
		pet1.setBirthDate(LocalDate.of(2010, 9, 7));
		pet1.setType(cat);
//		pet1.setOwner(o1);
		petRepository.save(pet1);

		// Add other pets similarly...

		// --- Visits ---
		Visit visit1 = new Visit();
//		visit1.setPet(pet1);
		visit1.setDate(LocalDate.of(2013, 1, 1));
		visit1.setDescription("rabies shot");
		visitRepository.save(visit1);

		//Pet pet1 = petRepository.save(new Pet(null, "Leo", LocalDate.of(2010, 9, 7), cat, o1));

		PetAttributes attributes = new PetAttributes();
		attributes.setPet(pet1);
		attributes.setTemperament("Calm");
		attributes.setLength(30.0);
		attributes.setWeight(5.0);
		petAttributesRepository.save(attributes);


	}

}

