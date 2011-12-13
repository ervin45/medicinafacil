package com.sistemamedico.modelo;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sistemamedico.entidades.Doctor;
import com.sistemamedico.interfaz.IEntidad;
import com.sistemamedico.manejadores.ManejadorDoctor;

public class ModeloDoctor extends AbstractTableModel {

	private ManejadorDoctor manejadorDoctor = null;
	private String[] encabezados = null;
	private List<IEntidad> doctores = null;
	private Doctor doctor = null;

	private static ModeloDoctor instancia = null;

	public static ModeloDoctor getInstancia() {
		if (instancia == null) {
			instancia = new ModeloDoctor();
		}
		return instancia;
	}

	private ModeloDoctor() {
		encabezados = new String[] { "ID Doctor", "Nombre", "Apellido",
				"Telefono", "Celular", "Cedula", "Direccion", "Especialidad",
				"Status", "Usuario" };
		manejadorDoctor = ManejadorDoctor.getInstancia();
		doctores = manejadorDoctor.getEntidades();

	}

	public String getColumnName(int indice) {
		return encabezados[indice];
	}

	@Override
	public int getColumnCount() {

		return encabezados.length;
	}

	@Override
	public int getRowCount() {

		return doctores.size();
	}

	@Override
	public Object getValueAt(int fila, int col) {
		String retorno = "";
		doctor = (Doctor) manejadorDoctor.getEntidades().get(fila);

		switch (col) {
		case 0:
			retorno = String.valueOf(doctor.getId());

			break;
		case 1:
			retorno = doctor.getNombre();

			break;
		case 2:
			retorno = doctor.getApellido();

			break;
		case 3:
			retorno = doctor.getTelefono();

			break;
		case 4:
			retorno = doctor.getCelular();

			break;

		case 5:
			retorno = doctor.getCedula();

			break;
		case 6:
			retorno = doctor.getDireccion();

			break;
		case 7:
			retorno = doctor.getEspecialidad();

			break;
		case 8:
			retorno = doctor.getStatus();

			break;
		case 9:
			retorno = doctor.getUsuario();

			break;

		}
		return retorno;
	}

	public void agregar(Doctor entidad) {

		manejadorDoctor.agregar(entidad);
		doctores = manejadorDoctor.getEntidades();
		fireTableDataChanged();
	}

	public void modficar(Doctor entidad, int id) {
		manejadorDoctor.modificar(id, entidad);
		doctores = manejadorDoctor.getEntidades();
		fireTableDataChanged();
	}

}
