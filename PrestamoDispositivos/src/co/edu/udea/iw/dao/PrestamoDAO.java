package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.IWDaoException;

public interface PrestamoDAO {
	
	public Prestamo insertar (Prestamo prestamo) throws IWDaoException;
	public Prestamo modificar(Prestamo prestamo) throws IWDaoException;
	public List<Prestamo> obtener() throws IWDaoException;
	public Prestamo borrar (Prestamo prestamo) throws IWDaoException;
	public Prestamo obtenerId (Integer idPrestamo) throws IWDaoException;

}
