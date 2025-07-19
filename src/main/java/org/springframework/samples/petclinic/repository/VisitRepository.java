package org.springframework.samples.petclinic.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.owner.Visit;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
}
