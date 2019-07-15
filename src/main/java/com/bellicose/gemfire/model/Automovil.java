package com.bellicose.gemfire.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

@Region("automovil")
public class Automovil {

	@Id
	private String automovil;
	
	@PersistenceConstructor
	public Automovil(String automovil) {
		this.automovil=automovil;
	}
	
	public String getAutomovil() {
		return automovil;
	}
	public void setAutomovil(String automovil) {
		this.automovil = automovil;
	}
	
	@Override
	public String toString() {
		return automovil;
	}
}
