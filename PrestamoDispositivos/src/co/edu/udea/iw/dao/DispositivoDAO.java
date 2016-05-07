package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.IWDaoException;

public interface DispositivoDAO {
	
	public Dispositivo insertar (Dispositivo dispositivo) throws IWDaoException;
	public Dispositivo modificar (Dispositivo dispositivo) throws IWDaoException;
	public List<Dispositivo> obtener() throws IWDaoException;
	public Dispositivo borrar (Dispositivo dispositivo) throws IWDaoException;
	public Dispositivo obtenerId (Integer idDispositivo) throws IWDaoException;
	public Dispositivo obtenerNombre (String nombre) throws IWDaoException;

}
