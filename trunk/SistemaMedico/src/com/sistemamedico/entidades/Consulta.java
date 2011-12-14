package com.sistemamedico.entidades;

import java.sql.Date;

import com.sistemamedico.interfaz.IEntidad;

public class Consulta implements IEntidad {

	private int idConsulta;
	private int idPaciente;
	private int idDoctor;
	private Date fecha;
	private String status;
	private String recetaDescripcion;

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecetaDescripcion() {
		return recetaDescripcion;
	}

	public void setRecetaDescripcion(String recetaDescripcion) {
		this.recetaDescripcion = recetaDescripcion;
	}

}
