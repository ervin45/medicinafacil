package com.sistemamedico.entidades;

import com.sistemamedico.interfaz.IEntidad;

public class RecordPaciente implements IEntidad {

	private int id;
	private String tipoSange;
	private String alergia;
	private String cirugia;
	private String nombreReferido;
	private String telefonoReferido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoSange() {
		return tipoSange;
	}

	public void setTipoSange(String tipoSange) {
		this.tipoSange = tipoSange;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getCirugia() {
		return cirugia;
	}

	public void setCirugia(String cirugia) {
		this.cirugia = cirugia;
	}

	public String getNombreReferido() {
		return nombreReferido;
	}

	public void setNombreReferido(String nombreReferido) {
		this.nombreReferido = nombreReferido;
	}

	public String getTelefonoReferido() {
		return telefonoReferido;
	}

	public void setTelefonoReferido(String telefonoReferido) {
		this.telefonoReferido = telefonoReferido;
	}

}
