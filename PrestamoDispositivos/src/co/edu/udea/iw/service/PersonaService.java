package co.edu.udea.iw.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.PersonaDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.validations.Validaciones;

@Transactional
public class PersonaService {
	
	private PersonaDAO personaDAO;
	private UsuarioDAO usuarioDAO;
	
	public void guardaPersona(String cedula, String nombres, String apellidos, 
			String correo, String telefono,String usuario, String usuarioCrea) throws IWDaoException, IWServiceException{
		
		Persona persona = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La cédula de la persona no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new IWServiceException("Los nombres de la persona no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			throw new IWServiceException("Los apellidos de la persona no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correo)){
			throw new IWServiceException("El correo electrónico de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(telefono)){
			throw new IWServiceException("El teléfono de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuario)){
			throw new IWServiceException("El usuario de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioCrea)){
			throw new IWServiceException("El usuario que crea a la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		if(!Validaciones.isEmail(correo)){
			throw new IWServiceException("El correo electrónico de la persona debe ser válido");
		}
		
		if(personaDAO.obtenerCedula(cedula) != null){
			throw new IWServiceException("Ya existe una persona con cedula " + cedula +  " en el sistema");
		}
		
		Usuario usuarioP = usuarioDAO.obtenerLogin(usuario);
		if(usuarioP == null){
			throw new IWServiceException("El usuario de la persona debe ser un usuario del sistema");
		}
		
		Usuario usuarioC = usuarioDAO.obtenerLogin(usuarioCrea);
		if(usuarioC == null){
			throw new IWServiceException("El usuario que crea a la persona debe ser un usuario del sistema");
		}
		
		persona = new Persona();
		
		persona.setCedula(cedula);
		persona.setNombres(nombres);
		persona.setApellidos(apellidos);
		persona.setCorreo(correo);
		persona.setTelefono(telefono);
		persona.setUsuario(usuarioP);
		persona.setUsuarioCrea(usuarioC);
		persona.setFechaCreacion(new Date());
		persona.setEliminado(Boolean.FALSE);
		
		personaDAO.insertar(persona);
		
	}
	
	public void actualizarPersona(String cedula, String nombres, String apellidos, 
			String correo, String telefono, String usuario, String usuarioModifica) throws IWDaoException, IWServiceException{
		
		Persona persona = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La cédula de la persona no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new IWServiceException("Los nombres de la persona no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			throw new IWServiceException("Los apellidos de la persona no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correo)){
			throw new IWServiceException("El correo electrónico de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(telefono)){
			throw new IWServiceException("El teléfono de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuario)){
			throw new IWServiceException("El usuario de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioModifica)){
			throw new IWServiceException("El usuario que modifica a la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		if(!Validaciones.isEmail(correo)){
			throw new IWServiceException("El correo electrónico de la persona debe ser válido");
		}
		
		Usuario usuarioP = usuarioDAO.obtenerLogin(usuario);
		if(usuarioP == null){
			throw new IWServiceException("El usuario de la persona debe ser un usuario del sistema");
		}
		Usuario usuarioM = usuarioDAO.obtenerLogin(usuarioModifica);
		if(usuarioM == null){
			throw new IWServiceException("El usuario que modifica a la Persona debe ser un usuario del sistema");
		}
		
		persona = personaDAO.obtenerCedula(cedula);
		
		if(persona == null){
			throw new IWServiceException("La persona a modificar no existe en el sistema");
		}
		
		
		persona.setNombres(nombres);
		persona.setApellidos(apellidos);
		persona.setCorreo(correo);
		persona.setTelefono(telefono);
		persona.setUsuario(usuarioP);
		persona.setUsuarioModifica(usuarioM);
		persona.setFechaModificacion(new Date());
		
		personaDAO.modificar(persona);
		
	}
	
	public void eliminarPersona(String cedula, String usuarioElimina) throws IWDaoException, IWServiceException{
		
		Persona persona = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La cédula del persona no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioElimina)){
			throw new IWServiceException("El usuario que elimina a la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		Usuario usuarioE = usuarioDAO.obtenerLogin(usuarioElimina);
		if(usuarioE == null){
			throw new IWServiceException("El usuario que elimina a la Persona debe ser un usuario del sistema");
		}
		
		persona = personaDAO.obtenerCedula(cedula);
		
		if(persona == null){
			throw new IWServiceException("La persona a eliminar no existe en el sistema");
		}
		
		persona.setEliminado(Boolean.TRUE);
		persona.setUsuarioElimina(usuarioE);
		persona.setFechaEliminacion(new Date());
		
		personaDAO.modificar(persona);
		
	}
	
	
	public List<Persona> obtener() throws IWDaoException{
		return personaDAO.obtener();
	}
	
	public Persona obtenerCedula(String cedula) throws IWDaoException, IWServiceException{
		if(cedula == null && "".equals(cedula)){
			throw new IWServiceException("La cédula de la persona a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return personaDAO.obtenerCedula(cedula);
	}


	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}


	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}


	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}


	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
