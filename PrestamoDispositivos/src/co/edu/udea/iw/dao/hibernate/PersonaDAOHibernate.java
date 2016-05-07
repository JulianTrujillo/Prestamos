package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.PersonaDAO;
import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.exception.IWDaoException;

public class PersonaDAOHibernate extends HibernateDaoSupport implements PersonaDAO {

	@Override
	public Persona insertar(Persona persona) throws IWDaoException {
		
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(persona);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		return persona;
	}

	@Override
	public Persona modificar(Persona persona) throws IWDaoException {
		
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(persona);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return persona;
	}

	@Override
	public List<Persona> obtener() throws IWDaoException {
		
		List<Persona> personas = new ArrayList<Persona>();
		Session session = null;
		
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Persona.class);
			personas = criteria.list();
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return personas;
	}

	@Override
	public Persona borrar(Persona persona) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona obtenerCedula(String cedula) throws IWDaoException {
		
		Persona persona = null;
		Session session = null;
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			persona = (Persona)session.get(Persona.class, cedula);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return persona;
	}

}
