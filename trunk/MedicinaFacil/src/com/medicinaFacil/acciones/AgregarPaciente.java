package com.medicinaFacil.acciones;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.medicinaFacil.entidades.Paciente;

@ManagedBean
@RequestScoped
public class AgregarPaciente {

	private Paciente paciente = new Paciente();

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
}
