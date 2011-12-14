package com.sistemamedico.manejadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sistemamedico.entidades.Paciente;
import com.sistemamedico.entidades.RecordPaciente;
import com.sistemamedico.interfaz.IEntidad;
import com.sistemamedico.interfaz.IManejador;
import com.sistemamedico.persistencia.Conexion;

public class ManejadorPaciente implements IManejador {

	private ResultSet rs = null;
	private PreparedStatement stmt = null;
	private Conexion conexion = null;
	private Paciente paciente = null;
	private List<IEntidad> pacientes;
	private static ManejadorPaciente instancia = null;

	public static ManejadorPaciente getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorPaciente();
		}
		return instancia;
	}

	private ManejadorPaciente() {
		conexion = Conexion.getInstancia();
	}

	@Override
	public int agregar(IEntidad entidad) {
		int fila = 0;
		paciente = (Paciente) entidad;
		String sql = "INSERT INTO sistemamedico.persona (nombre, apellido, telefono, celular, cedula, direccion,  STATUS, role, id_record )VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		stmt = conexion.hacerEnunciado(sql);
		try {
			stmt.setString(1, paciente.getNombre());
			stmt.setString(2, paciente.getApellido());
			stmt.setString(3, paciente.getTelefono());
			stmt.setString(4, paciente.getCelular());
			stmt.setString(5, paciente.getCedula());
			stmt.setString(6, paciente.getDireccion());

			stmt.setString(7, paciente.getStatus());
			stmt.setString(8, paciente.getRole());
			stmt.setInt(9, paciente.getIdRecord());

			fila = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fila;
	}

	@Override
	public int eliminar(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IEntidad getEntidad(int id) {
		String sql = "SELECT * FROM persona WHERE role='paciente' and id= "
				+ id;
		stmt = conexion.hacerEnunciado(sql);
		rs = conexion.hacerConsulta(sql);
		try {
			while (rs.next()) {
				paciente = new Paciente();
				paciente.setId(rs.getInt("id"));
				paciente.setNombre(rs.getString("nombre"));
				paciente.setApellido(rs.getString("apellido"));
				paciente.setTelefono(rs.getString("telefono"));
				paciente.setCelular(rs.getString("celular"));
				paciente.setCedula(rs.getString("cedula"));
				paciente.setDireccion(rs.getString("direccion"));
				paciente.setStatus(rs.getString("status"));
				paciente.setRole(rs.getString("role"));
				paciente.setIdRecord(rs.getInt("id_record"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paciente;
	}

	@Override
	public List<IEntidad> getEntidades() {
		pacientes = new ArrayList<IEntidad>();
		String sql = "SELECT * FROM persona WHERE role='paciente'";
		stmt = conexion.hacerEnunciado(sql);
		rs = conexion.hacerConsulta(sql);

		try {
			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setId(rs.getInt("id"));
				paciente.setNombre(rs.getString("nombre"));
				paciente.setApellido(rs.getString("apellido"));
				paciente.setTelefono(rs.getString("telefono"));
				paciente.setCelular(rs.getString("celular"));
				paciente.setCedula(rs.getString("cedula"));
				paciente.setDireccion(rs.getString("direccion"));

				paciente.setStatus(rs.getString("status"));
				paciente.setRole(rs.getString("role"));
				paciente.setIdRecord(rs.getInt("id_record"));

				pacientes.add(paciente);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pacientes;
	}

	@Override
	public int modificar(int id, IEntidad entidad) {

		int fila = 0;
		String sql = "UPDATE sistemamedico.persona SET nombre = ? , apellido = ? , telefono = ? , celular = ? , cedula = ? , direccion = ? ,  STATUS = ? ,  role = ?  WHERE id = ?;";
		stmt = conexion.hacerEnunciado(sql);
		paciente = (Paciente) entidad;
		try {
			stmt.setString(1, paciente.getNombre());
			stmt.setString(2, paciente.getApellido());
			stmt.setString(3, paciente.getTelefono());
			stmt.setString(4, paciente.getCelular());
			stmt.setString(5, paciente.getCedula());
			stmt.setString(6, paciente.getDireccion());

			stmt.setString(7, paciente.getStatus());
			stmt.setString(8, paciente.getRole());

			stmt.setInt(9, id);
			fila = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fila;
	}

	public int cambiarStatus(int id) {
		int fila = 0;
		paciente = (Paciente) this.getEntidad(id);

		String status = paciente.getStatus();
		status = status.equalsIgnoreCase("Activo") ? "Inactivo" : "Activo";
		String sql = "UPDATE sistemamedico.persona SET STATUS = ?  WHERE id = ? ";
		stmt = conexion.hacerEnunciado(sql);
		try {
			stmt.setString(1, status);
			stmt.setInt(2, id);
			fila = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fila;

	}
	

//	public static void main(String[] args) {
//		ManejadorRecordPaciente manejadorRecordPaciente = ManejadorRecordPaciente
//				.getInstancia();
//		RecordPaciente recordPaciente = new RecordPaciente();
//		recordPaciente.setTipoSange("www+");
//		recordPaciente.setAlergia("ALERGICO A LA dROGA");
//		recordPaciente.setCirugia("Cirugian intestina anal");
//		recordPaciente.setNombreReferido("Mariano");
//		recordPaciente.setTelefonoReferido("809-485-5856");
//		manejadorRecordPaciente.modificar(2,recordPaciente);
//
//		int id = manejadorRecordPaciente.getUltimoRecordPaciente();
//		System.out.println(id);
//		System.out.println(id);
//		System.out.println(id);
//
//	}

}
