package com.sistemamedico.manejadores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sistemamedico.entidades.RecordPaciente;
import com.sistemamedico.interfaz.IEntidad;
import com.sistemamedico.interfaz.IManejador;
import com.sistemamedico.persistencia.Conexion;

public class ManejadorRecordPaciente implements IManejador {

	private ResultSet rs = null;
	private PreparedStatement stmt = null;
	private Conexion conexion = null;
	private RecordPaciente recordPaciente = null;
	private List<IEntidad> recordPacientes;
	private static ManejadorRecordPaciente instancia = null;

	public static ManejadorRecordPaciente getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorRecordPaciente();
		}
		return instancia;
	}

	private ManejadorRecordPaciente() {
		conexion = Conexion.getInstancia();
	}

	@Override
	public int agregar(IEntidad entidad) {
		int fila = 0;
		recordPaciente = (RecordPaciente) entidad;
		String sql = "INSERT INTO `sistemamedico`.`record_paciente` (`tipo_sangre`, `alergia`, `nombre_referido`, `telefono_referido`, `cirugia`) VALUES( ?, ?, ?, ?, ?);";
		stmt = conexion.hacerEnunciado(sql);

		try {
			stmt.setString(1, recordPaciente.getTipoSange());
			stmt.setString(2, recordPaciente.getAlergia());
			stmt.setString(3, recordPaciente.getNombreReferido());
			stmt.setString(4, recordPaciente.getTelefonoReferido());
			stmt.setString(5, recordPaciente.getCirugia());

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
		String sql = "SELECT * FROM `sistemamedico`.`record_paciente` WHERE id_record= "
				+ id;
		stmt = conexion.hacerEnunciado(sql);
		rs = conexion.hacerConsulta(sql);

		try {
			while (rs.next()) {
				recordPaciente = new RecordPaciente();
				recordPaciente.setId(rs.getInt("id_record"));
				recordPaciente.setTipoSange(rs.getString("tipo_sangre"));
				recordPaciente.setAlergia(rs.getString("alergia"));
				recordPaciente.setCirugia(rs.getString("cirugia"));
				recordPaciente.setNombreReferido(rs
						.getString("nombre_referido"));
				recordPaciente.setTelefonoReferido(rs
						.getString("telefono_referido"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recordPaciente;
	}

	@Override
	public List<IEntidad> getEntidades() {

		return null;
	}

	@Override
	public int modificar(int id, IEntidad entidad) {
		int fila = 0;
		String sql = "UPDATE `sistemamedico`.`record_paciente` SET `tipo_sangre` = ? , `alergia` = ? , `nombre_referido` = ? , `telefono_referido` = ? ,  `cirugia` = ? WHERE `id_record` = ? ;";
		stmt = conexion.hacerEnunciado(sql);
		recordPaciente = (RecordPaciente) entidad;
		try {
			stmt.setString(1, recordPaciente.getTipoSange());
			stmt.setString(2, recordPaciente.getAlergia());
			stmt.setString(3, recordPaciente.getNombreReferido());
			stmt.setString(4, recordPaciente.getTelefonoReferido());
			stmt.setString(5, recordPaciente.getCirugia());
			stmt.setInt(6, id);
			fila = stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return fila;
	}

	public int getUltimoRecordPaciente() {
		int indice = 0;
		String sql = "SELECT * FROM record_paciente  ORDER BY id_record DESC LIMIT 1";
		stmt = conexion.hacerEnunciado(sql);
		rs = conexion.hacerConsulta(sql);
		try {
			while (rs.next()) {
				indice = rs.getInt("id_record");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return indice;
	}

}
