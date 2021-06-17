package com.centreFormat.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.centreFormat.models.Stagiaires;

public interface StagiairesRepository extends CrudRepository<Stagiaires, Integer>{
	Optional<Stagiaires> findByEmail(String email);
}
