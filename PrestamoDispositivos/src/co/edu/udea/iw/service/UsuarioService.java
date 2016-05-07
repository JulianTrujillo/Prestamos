package co.edu.udea.iw.service;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.validations.Validaciones;

@Transactional
public class UsuarioService {
	
	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public Boolean validar(String login, String contrasena) throws IWDaoException, IWServiceException{
		
		Cifrar cifrar = new Cifrar();
		
		if(Validaciones.isTextoVacio(login)){
			throw new IWServiceException("El login del usuario no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		if(Validaciones.isTextoVacio(contrasena)){
			throw new IWServiceException("La contraseña del usuario no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		Usuario usuario = usuarioDAO.obtenerLogin(login);
		if(usuario == null){
			throw new IWServiceException("Usuario o contraseña no válidos");
		}
				
		if(!cifrar.encrypt(contrasena).equals(usuario.getContrasena())){
			throw new IWServiceException("Usuario o contraseña no válidos");
		}
		
		return Boolean.TRUE;

	}

}
