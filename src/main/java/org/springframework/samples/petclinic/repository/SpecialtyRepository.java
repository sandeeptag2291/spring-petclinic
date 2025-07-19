package org.springframework.samples.petclinic.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
