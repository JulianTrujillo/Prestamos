package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.PrestamoDAO;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.IWDaoException;

public class PrestamoDAOHibernate extends HibernateDaoSupport implements PrestamoDAO{

	@Override
	public Prestamo insertar(Prestamo prestamo) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(prestamo);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		return prestamo;
	}

	@Override
	public Prestamo modificar(Prestamo prestamo) throws IWDaoException {
		
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(prestamo);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return prestamo;
	}

	@Override
	public List<Prestamo> obtener() throws IWDaoException {
		
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		Session session = null;
		
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Prestamo.class);
			prestamos = criteria.list();
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return prestamos;
	}

	@Override
	public Prestamo borrar(Prestamo prestamo) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prestamo obtenerId(Integer idPrestamo) throws IWDaoException {
		
		Prestamo prestamo = null;
		Session session = null;
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			prestamo = (Prestamo)session.get(Prestamo.class, idPrestamo);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return prestamo;
	}

}
