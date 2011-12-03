package com.medicinaFacil.acciones;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.medicinaFacil.entidades.Doctor;

@ManagedBean
@RequestScoped
public class AgregarDoctor {

	private Doctor doctor = new Doctor();
	

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
