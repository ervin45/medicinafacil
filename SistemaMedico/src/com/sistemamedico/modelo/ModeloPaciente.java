package com.sistemamedico.modelo;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sistemamedico.entidades.Doctor;
import com.sistemamedico.entidades.Paciente;
import com.sistemamedico.interfaz.IEntidad;

import com.sistemamedico.manejadores.ManejadorPaciente;

public class ModeloPaciente extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManejadorPaciente manejadorPaciente = null;
	private String[] encabezados = null;
	private List<IEntidad> pacientes = null;
	private Paciente paciente = null;

	private static ModeloPaciente instancia = null;

	public static ModeloPaciente getInstancia() {
		if (instancia == null) {
			instancia = new ModeloPaciente();
		}
		return instancia;
	}

	private ModeloPaciente() {
		encabezados = new String[] { "ID Paciente", "Nombre", "Apellido",
				"Telefono", "Celular", "Cedula", "Direccion", "Status" };
		manejadorPaciente = ManejadorPaciente.getInstancia();
		pacientes = manejadorPaciente.getEntidades();

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

		return pacientes.size();
	}

	@Override
	public Object getValueAt(int fila, int col) {
		String retorno = "";
		paciente = (Paciente) manejadorPaciente.getEntidades().get(fila);

		switch (col) {
		case 0:
			retorno = String.valueOf(paciente.getId());

			break;
		case 1:
			retorno = paciente.getNombre();

			break;
		case 2:
			retorno = paciente.getApellido();

			break;
		case 3:
			retorno = paciente.getTelefono();

			break;
		case 4:
			retorno = paciente.getCelular();

			break;

		case 5:
			retorno = paciente.getCedula();

			break;
		case 6:
			retorno = paciente.getDireccion();
			break;

		case 7:
			retorno = paciente.getStatus();

			break;

		}
		return retorno;
	}

	public void agregar(Paciente entidad) {

		manejadorPaciente.agregar(entidad);
		pacientes = manejadorPaciente.getEntidades();
		fireTableDataChanged();
	}

	public void modficar(Paciente entidad, int id) {
		manejadorPaciente.modificar(id, entidad);
		pacientes = manejadorPaciente.getEntidades();
		fireTableDataChanged();
	}

	public void actualizarTabla() {
		pacientes = manejadorPaciente.getEntidades();
		fireTableDataChanged();
	}

}
