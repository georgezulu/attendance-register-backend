package za.co.rain.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import za.co.rain.spring.model.Individual;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Long> {}



