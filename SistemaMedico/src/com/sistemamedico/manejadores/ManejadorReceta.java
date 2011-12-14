package com.sistemamedico.manejadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sistemamedico.entidades.Consulta;

import com.sistemamedico.interfaz.IEntidad;
import com.sistemamedico.interfaz.IManejador;
import com.sistemamedico.persistencia.Conexion;

public class ManejadorReceta implements IManejador {
	private ResultSet rs = null;
	private PreparedStatement stmt = null;
	private Conexion conexion = null;
	private Consulta consulta = null;
	private List<IEntidad> consultas;
	private static ManejadorReceta instancia = null;

	public static ManejadorReceta getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorReceta();
		}
		return instancia;
	}

	private ManejadorReceta() {
		conexion = Conexion.getInstancia();
	}

	@Override
	public int agregar(IEntidad entidad) {
		int fila = 0;
		String sql = "INSERT INTO `sistemamedico`.`consulta` (`id_paciente`, `id_doctor`, `fecha`, `status`, `receta_descripcion`)VALUES( ?, ?, ?, ?, ?);";
		consulta = (Consulta) entidad;

		conexion.hacerEnunciado(sql);

		try {
			stmt.setInt(1, consulta.getIdPaciente());
			stmt.setInt(2, consulta.getIdDoctor());
			stmt.setDate(3, consulta.getFecha());
			stmt.setString(4, consulta.getStatus());
			stmt.setString(5, consulta.getRecetaDescripcion());

			fila = stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		String sql = "SELECT * FROM `sistemamedico`.`consulta` WHERE id_consulta="
				+ id;
		stmt = conexion.hacerEnunciado(sql);
		rs = conexion.hacerConsulta(sql);

		try {
			while (rs.next()) {
				consulta = new Consulta();
				consulta.setFecha(rs.getDate("fecha"));
				consulta.setIdConsulta(rs.getInt("id_consulta"));
				consulta.setIdDoctor(rs.getInt("id_doctor"));
				consulta.setStatus(rs.getString("status"));
				consulta.setRecetaDescripcion(rs
						.getString("receta_descripcion"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consulta;
	}

	@Override
	public List<IEntidad> getEntidades() {
		consultas = new ArrayList<IEntidad>();
		String sql = "SELECT * FROM `sistemamedico`.`consulta`";
		stmt = conexion.hacerEnunciado(sql);
		rs = conexion.hacerConsulta(sql);

		try {
			while (rs.next()) {
				consulta = new Consulta();
				consulta.setFecha(rs.getDate("fecha"));
				consulta.setIdConsulta(rs.getInt("id_consulta"));
				consulta.setIdDoctor(rs.getInt("id_doctor"));
				consulta.setStatus(rs.getString("status"));
				consulta.setRecetaDescripcion(rs
						.getString("receta_descripcion"));
				consultas.add(consulta);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return consultas;
	}

	@Override
	public int modificar(int id, IEntidad entidad) {
		int fila = 0;
		String sql = "UPDATE `sistemamedico`.`consulta` SET `id_paciente` = ? , `id_doctor` = ? , `fecha` =? , `status` = ? ,  `receta_descripcion` = ? WHERE `id_consulta` = ? ;";
		consulta = (Consulta) entidad;

		conexion.hacerEnunciado(sql);

		try {
			stmt.setInt(1, consulta.getIdPaciente());
			stmt.setInt(2, consulta.getIdDoctor());
			stmt.setDate(3, consulta.getFecha());
			stmt.setString(4, consulta.getStatus());
			stmt.setString(5, consulta.getRecetaDescripcion());
			stmt.setInt(6, id);
			fila = stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fila;
	}

}
