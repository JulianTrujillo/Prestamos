package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class DispositivoDAOHibernateTest {

	@Autowired
	DispositivoDAO dispositivoDao;

	@Test
	public void testObtener() {
		
		List<Dispositivo> dispositivos = null;
		
		try{
			dispositivos = dispositivoDao.obtener();
			
			for(Dispositivo dispositivo : dispositivos){
				System.out.println("Nombre: " + dispositivo.getNombre());
			}
			
			assertTrue(true);
		}catch(IWDaoException e){
			fail(e.getMessage());
		}
	}

}
