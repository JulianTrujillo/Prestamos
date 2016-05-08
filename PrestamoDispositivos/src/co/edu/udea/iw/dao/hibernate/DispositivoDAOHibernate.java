package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.IWDaoException;

public class DispositivoDAOHibernate extends HibernateDaoSupport implements DispositivoDAO{

	@Override
	public Dispositivo insertar(Dispositivo dispositivo) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dispositivo modificar(Dispositivo dispositivo) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dispositivo> obtener() throws IWDaoException {

		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Session session = null;
		
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Dispositivo.class);
			dispositivos = criteria.list();
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return dispositivos;
	}

	@Override
	public Dispositivo borrar(Dispositivo dispositivo) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dispositivo obtenerId(Integer idDispositivo) throws IWDaoException {
		Session session = null;
		Dispositivo dispositivo = null;
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();			
			dispositivo = (Dispositivo)session.get(Dispositivo.class, idDispositivo);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return dispositivo;
	}
	

	@Override
	public Dispositivo obtenerNombre(String nombre) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
