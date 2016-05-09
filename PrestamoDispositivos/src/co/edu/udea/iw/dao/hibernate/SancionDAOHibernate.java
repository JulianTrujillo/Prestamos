package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.SancionDAO;
import co.edu.udea.iw.dto.Sancion;
import co.edu.udea.iw.exception.IWDaoException;

public class SancionDAOHibernate extends HibernateDaoSupport implements SancionDAO {

	@Override
	public Sancion insertar(Sancion sancion) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sancion modificar(Sancion sancion) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sancion> obtener() throws IWDaoException {
		List<Sancion> sanciones = new ArrayList<Sancion>();
		Session session = null;
		
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Sancion.class);
			sanciones = criteria.list();
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return sanciones;
	}

	@Override
	public Sancion borrar(Sancion sancion) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sancion obtenerId(Integer idSancion) throws IWDaoException {
		Session session = null;
		Sancion sancion = null;
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			sancion = (Sancion)session.get(Sancion.class, idSancion);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return sancion;	
	}

}
