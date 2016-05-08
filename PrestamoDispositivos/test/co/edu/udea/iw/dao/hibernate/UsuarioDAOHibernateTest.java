package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class UsuarioDAOHibernateTest {

	@Autowired
	UsuarioDAO usuarioDao;

	@Test
	public void testObtener() {
		
		List<Usuario> usuarios = null;
		
		try{
			usuarios = usuarioDao.obtener();
			
			for(Usuario usuario : usuarios){
				System.out.println("Login: " + usuario.getLogin());
			}
			
			assertTrue(true);
		}catch(IWDaoException e){
			fail(e.getMessage());
		}
	}

}
