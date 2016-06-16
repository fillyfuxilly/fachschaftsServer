package de.erstihelfer.erstihelfer;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.erstihelfer.dto.UserLoginResponse;
import de.erstihelfer.erstihelfer.*;


/**
 * 
 * @author Amayda Dominguez
 *
 */
@RunWith(Arquillian.class)
public class RegisterNewUserTest {

	
	@EJB
	ErstiHelferOnlineIntegration bean;
	
	
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test.war")
               .addPackages(true,"de/erstihelfer")
               .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")               
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
	}



		/*
		@Test
		*//**
		 * Prueft, ob ein neuer User erfolgreich registriert werden kann.
		 *//*
		public void testRegistration() throws Exception {
		    UserLoginResponse loginResponse = bean.registerNewUser("Pepe", 4);
		    assertEquals(loginResponse.getReturnCode(), 0);
		 	int sessionId = loginResponse.getSessionId();
			bean.logout(sessionId);
		}
	*/
	
	}
	
	
	


