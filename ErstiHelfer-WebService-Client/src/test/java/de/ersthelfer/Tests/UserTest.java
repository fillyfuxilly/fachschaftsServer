package de.ersthelfer.Tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.erstihelfer.erstihelfer.*;

public class UserTest {

	private static ErstiHelferOnlineIntegration remoteSystem;

	@Before
	public void setUp() throws Exception {
		ErstiHelferOnlineIntegrationService service = new ErstiHelferOnlineIntegrationService();
		remoteSystem = service.getErstiHelferOnlineIntegrationPort();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_LoginRegister() {
		String username = "Malte";
		String password = "12345";
		int groupNr = 1;
		UserLoginResponse registerResponse = remoteSystem.registerNewUser(username, groupNr);
		// ReturnCodeResponse CODE_OK:0
		if (registerResponse.getReturnCode() == 30) {
			//Username existiert bereits => login
			UserLoginResponse loginResponse = remoteSystem.login1(username, groupNr);
			assertEquals("Returncode: " + loginResponse.getReturnCode() + " Message: " + loginResponse.getMessage(), 0,
					loginResponse.getReturnCode());
		} else {
			assertEquals(
					"Returncode: " + registerResponse.getReturnCode() + " Message: " + registerResponse.getMessage(), 0,
					registerResponse.getReturnCode());
			int sessionId = registerResponse.getSessionId();

			remoteSystem.logout(sessionId);
		}
	}

	@Test
	public void test_CreateGetAppointment() throws DatatypeConfigurationException {
		String title = "Ring zerstören";
		String location = "Mordor";
		String description = "Schmeiß den Ring ins Feuer!";
		GregorianCalendar startTime = new GregorianCalendar(2016, 9, 1, 15, 0);
		XMLGregorianCalendar XMLcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(startTime);
		remoteSystem.createAppointment(title, location, XMLcal, description);

	}

}
