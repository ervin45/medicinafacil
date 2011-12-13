package com.sistemamedico.manejadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import com.sistemamedico.entidades.Doctor;
import com.sistemamedico.interfaz.IEntidad;
import com.sistemamedico.interfaz.IManejador;
import com.sistemamedico.persistencia.Conexion;

public class ManejadorDoctor implements IManejador {
	private ResultSet rs = null;
	private PreparedStatement stmt = null;
	private Conexion conexion = null;
	private Doctor doctor = null;
	private List<IEntidad> doctores;
	private static ManejadorDoctor instancia = null;

	public static ManejadorDoctor getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorDoctor();
		}
		return instancia;
	}

	private ManejadorDoctor() {
		conexion = Conexion.getInstancia();
	}

	@Override
	public int agregar(IEntidad entidad) {
		int fila = 0;
		doctor = (Doctor) entidad;
		String sql = "INSERT INTO sistemamedico.persona (nombre, apellido, telefono, celular, cedula, direccion, especialidad, STATUS, role, usuario, clave)VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		stmt = conexion.hacerEnunciado(sql);
		try {
			stmt.setString(1, doctor.getNombre());
			stmt.setString(2, doctor.getApellido());
			stmt.setString(3, doctor.getTelefono());
			stmt.setString(4, doctor.getCelular());
			stmt.setString(5, doctor.getCedula());
			stmt.setString(6, doctor.getDireccion());
			stmt.setString(7, doctor.getEspecialidad());
			stmt.setString(8, doctor.getStatus());
			stmt.setString(9, doctor.getRole());
			stmt.setString(10, doctor.getUsuario());
			stmt.setString(11, doctor.getClave());
			fila = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fila;
	}

	@Override
	public int eliminar(int id) throws SQLException {

		return 0;
	}

	@Override
	public IEntidad getEntidad(int id) {
		String sql = "SELECT * FROM persona WHERE role='doctor' and id= " + id;
		stmt = conexion.hacerEnunciado(sql);
		rs = conexion.hacerConsulta(sql);
		try {
			while (rs.next()) {
				doctor = new Doctor();
				doctor.setId(rs.getInt("id"));
				doctor.setNombre(rs.getString("nombre"));
				doctor.setApellido(rs.getString("apellido"));
				doctor.setTelefono(rs.getString("telefono"));
				doctor.setCelular(rs.getString("celular"));
				doctor.setCedula(rs.getString("cedula"));
				doctor.setDireccion(rs.getString("direccion"));
				doctor.setEspecialidad(rs.getString("especialidad"));
				doctor.setStatus(rs.getString("status"));
				doctor.setRole(rs.getString("role"));
				doctor.setUsuario(rs.getString("usuario"));
				doctor.setClave(rs.getString("clave"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctor;

	}

	@Override
	public List<IEntidad> getEntidades() {
		doctores = new ArrayList<IEntidad>();
		String sql = "SELECT * FROM persona WHERE role='doctor'";
		stmt = conexion.hacerEnunciado(sql);
		rs = conexion.hacerConsulta(sql);

		try {
			while (rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setId(rs.getInt("id"));
				doctor.setNombre(rs.getString("nombre"));
				doctor.setApellido(rs.getString("apellido"));
				doctor.setTelefono(rs.getString("telefono"));
				doctor.setCelular(rs.getString("celular"));
				doctor.setCedula(rs.getString("cedula"));
				doctor.setDireccion(rs.getString("direccion"));
				doctor.setEspecialidad(rs.getString("especialidad"));
				doctor.setStatus(rs.getString("status"));
				doctor.setRole(rs.getString("role"));
				doctor.setUsuario(rs.getString("usuario"));
				doctor.setClave(rs.getString("clave"));
				doctores.add(doctor);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doctores;
	}

	@Override
	public int modificar(int id, IEntidad entidad) {
		int fila = 0;
		String sql = "UPDATE sistemamedico.persona SET nombre = ? , apellido = ? , telefono = ? , celular = ? , cedula = ? , direccion = ? , especialidad = ? , STATUS = ? ,  role = ?  , usuario = ? , clave = ? WHERE id = ?;";
		stmt = conexion.hacerEnunciado(sql);
		doctor = (Doctor) entidad;
		try {
			stmt.setString(1, doctor.getNombre());
			stmt.setString(2, doctor.getApellido());
			stmt.setString(3, doctor.getTelefono());
			stmt.setString(4, doctor.getCelular());
			stmt.setString(5, doctor.getCedula());
			stmt.setString(6, doctor.getDireccion());
			stmt.setString(7, doctor.getEspecialidad());
			stmt.setString(8, doctor.getStatus());
			stmt.setString(9, doctor.getRole());
			stmt.setString(10, doctor.getUsuario());
			stmt.setString(11, doctor.getClave());
			stmt.setInt(12, id);
			fila = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fila;
	}

	public int cambiarStatus(int id) {
		int fila = 0;
		doctor = (Doctor) this.getEntidad(id);

		String status = doctor.getStatus();
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

	public static void main(String[] args) {
		ManejadorDoctor manejadorDoctor = ManejadorDoctor.getInstancia();

		Doctor doctor = new Doctor();
		 doctor.setNombre("Snailin");
		 doctor.setApellido("Perez");
		 doctor.setTelefono("809-596-4237");
		 doctor.setCelular("809-596-4237");
		 doctor.setCedula("402-2021292-8");
		 doctor.setDireccion("Villa Faro");
		 doctor.setEspecialidad("Dentista");
		 doctor.setStatus("Activo");
		 doctor.setRole("Doctor");
		 doctor.setUsuario("sinoa");
		 doctor.setClave("1234");
		
		 manejadorDoctor.agregar( doctor);
		
		System.out.println("Agregado");
		manejadorDoctor.cambiarStatus(1);
	}
}
