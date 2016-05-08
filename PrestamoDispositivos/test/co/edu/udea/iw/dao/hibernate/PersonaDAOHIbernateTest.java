package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.PersonaDAO;
import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class PersonaDAOHIbernateTest {

	@Autowired
	PersonaDAO personaDao;

	@Test
	public void testObtener() {
		
		List<Persona> personas = null;
		
		try{
			personas = personaDao.obtener();
			
			for(Persona persona : personas){
				System.out.println("Nombre: " + persona.getNombres());
			}
			
			assertTrue(true);
		}catch(IWDaoException e){
			fail(e.getMessage());
		}
	}

}
