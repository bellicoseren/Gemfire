package com.bellicose.gemfire.repository;

import org.springframework.data.repository.CrudRepository;

import com.bellicose.gemfire.model.Automovil;

public interface Repository extends CrudRepository<Automovil, Long> {
	Automovil findByAutomovil(String nombre);
}