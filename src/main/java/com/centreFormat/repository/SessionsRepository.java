package com.centreFormat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.centreFormat.models.Sessions;

public interface SessionsRepository extends CrudRepository<Sessions, Integer>{
	Optional<Iterable<Sessions>> findByIdFormation(int idFormation);
}
