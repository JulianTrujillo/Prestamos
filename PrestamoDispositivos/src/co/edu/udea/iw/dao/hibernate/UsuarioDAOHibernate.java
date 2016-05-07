package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

public class UsuarioDAOHibernate extends HibernateDaoSupport implements UsuarioDAO {

	@Override
	public Usuario insertar(Usuario usuario) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario modificar(Usuario usuario) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> obtener() throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario borrar(Usuario usuario) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerLogin(String login) throws IWDaoException {
		
		Session session = null;
		Usuario usuario = null;
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			usuario = (Usuario)session.get(Usuario.class, login);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return usuario;
	}

}
