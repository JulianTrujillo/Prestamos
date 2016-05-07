package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Sancion;
import co.edu.udea.iw.exception.IWDaoException;

public interface SancionDAO {
	
	public Sancion insertar (Sancion sancion) throws IWDaoException;
	public Sancion modificar(Sancion sancion) throws IWDaoException;
	public List<Sancion> obtener() throws IWDaoException;
	public Sancion borrar (Sancion sancion) throws IWDaoException;
	public Sancion obtenerId (Integer idSancion) throws IWDaoException;

}
