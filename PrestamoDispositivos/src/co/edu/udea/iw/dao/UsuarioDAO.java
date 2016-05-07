package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

public interface UsuarioDAO {
	
	public Usuario insertar (Usuario usuario) throws IWDaoException;
	public Usuario modificar (Usuario usuario) throws IWDaoException;
	public List<Usuario> obtener() throws IWDaoException;
	public Usuario borrar (Usuario usuario) throws IWDaoException;
	public Usuario obtenerLogin (String login) throws IWDaoException;

}
