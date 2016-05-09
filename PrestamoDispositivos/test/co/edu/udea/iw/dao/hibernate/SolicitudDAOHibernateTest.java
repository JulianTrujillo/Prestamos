package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class SolicitudDAOHibernateTest {

	@Autowired
	SolicitudDAO solicitudDao;

	@Test
	public void testObtener() {
		
		List<Solicitud> solicitudes = null;
		
		try{
			solicitudes = solicitudDao.obtener();
			
			for(Solicitud solicitud : solicitudes){
				System.out.println("Usuario: " + solicitud.getUsuarioAprueba().getLogin());
			}
			
			assertTrue(true);
		}catch(IWDaoException e){
			fail(e.getMessage());
		}
	}

}
