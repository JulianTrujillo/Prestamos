package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.IWDaoException;

public interface SolicitudDAO {
	
	public Solicitud insertar (Solicitud solicitud) throws IWDaoException;
	public Solicitud modificar(Solicitud solicitud) throws IWDaoException;
	public List<Solicitud> obtener() throws IWDaoException;
	public Solicitud borrar (Solicitud Solicitud) throws IWDaoException;
	public Solicitud obtenerId (Integer idSolicitud) throws IWDaoException;

}
