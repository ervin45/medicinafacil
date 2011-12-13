package com.sistemamedico.interfaz;

import java.sql.SQLException;
import java.util.List;

public interface IManejador {

	public IEntidad getEntidad(int id);

	public List<IEntidad> getEntidades();

	public int agregar(IEntidad entidad);

	public int modificar(int id, IEntidad entidad);

	public int eliminar(int id) throws SQLException;

}
