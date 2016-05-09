package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.IWDaoException;

public class SolicitudDAOHibernate extends HibernateDaoSupport implements SolicitudDAO{

	@Override
	public Solicitud insertar(Solicitud solicitud) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(solicitud);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		return solicitud;
	}

	@Override
	public Solicitud modificar(Solicitud solicitud) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(solicitud);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return solicitud;
	}

	@Override
	public List<Solicitud> obtener() throws IWDaoException {
		List<Solicitud> solicitudes = new ArrayList<Solicitud>();
		Session session = null;
		
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Solicitud.class);
			solicitudes = criteria.list();
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return solicitudes;
	}

	@Override
	public Solicitud borrar(Solicitud Solicitud) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solicitud obtenerId(Integer idSolicitud) throws IWDaoException {
		Solicitud solicitud = null;
		Session session = null;
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			solicitud = (Solicitud)session.get(Solicitud.class, idSolicitud);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return solicitud;
	}

}
