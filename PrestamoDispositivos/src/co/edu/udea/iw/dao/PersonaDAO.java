package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.exception.IWDaoException;

public interface PersonaDAO {
	
	public Persona insertar (Persona persona) throws IWDaoException;
	public Persona modificar (Persona persona) throws IWDaoException;
	public List<Persona> obtener() throws IWDaoException;
	public Persona borrar (Persona persona) throws IWDaoException;
	public Persona obtenerCedula (String cedula) throws IWDaoException;

}
