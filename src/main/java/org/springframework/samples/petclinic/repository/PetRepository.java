package org.springframework.samples.petclinic.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}

