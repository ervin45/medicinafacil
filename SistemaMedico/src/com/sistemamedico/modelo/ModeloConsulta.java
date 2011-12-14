package com.sistemamedico.modelo;

import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sistemamedico.entidades.Consulta;
import com.sistemamedico.entidades.Doctor;
import com.sistemamedico.interfaz.IEntidad;
import com.sistemamedico.manejadores.ManejadorDoctor;
import com.sistemamedico.manejadores.ManejadorReceta;

public class ModeloConsulta extends AbstractTableModel {

	private ManejadorReceta manejadorConsulta = null;
	private String[] encabezados = null;
	private List<IEntidad> consultas = null;
	private Consulta consulta = null;

	private static ModeloConsulta instancia = null;

	public static ModeloConsulta getInstancia() {
		if (instancia == null) {
			instancia = new ModeloConsulta();
		}
		return instancia;
	}

	private ModeloConsulta() {
		encabezados = new String[] { "ID Consulta", "ID Paciente", "ID Doctor",
				"Fecha", "Status", "Receta Desc." };
		manejadorConsulta = ManejadorReceta.getInstancia();
		consultas = manejadorConsulta.getEntidades();

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

		return consultas.size();
	}

	@Override
	public Object getValueAt(int fila, int col) {
		String retorno = "";
		consulta = (Consulta) manejadorConsulta.getEntidades().get(fila);

		switch (col) {
		case 0:
			retorno = String.valueOf(consulta.getIdConsulta());

			break;
		case 1:
			retorno = String.valueOf(consulta.getIdPaciente());

			break;
		case 2:
			retorno = String.valueOf(consulta.getIdDoctor());

			break;
		case 3:
			retorno = String.valueOf(consulta.getFecha());

			break;
		case 4:
			retorno = consulta.getStatus();

			break;

		case 5:
			retorno = consulta.getRecetaDescripcion();

			break;

		}

		return retorno;
	}

	public void agregar(Consulta entidad) {

		manejadorConsulta.agregar(entidad);
		consultas = manejadorConsulta.getEntidades();
		fireTableDataChanged();
	}

	public void modficar(Consulta entidad, int id) {
		manejadorConsulta.modificar(id, entidad);
		consultas = manejadorConsulta.getEntidades();
		fireTableDataChanged();
	}

	public void actualizarTabla() {
		consultas = manejadorConsulta.getEntidades();
		fireTableDataChanged();
	}
}
