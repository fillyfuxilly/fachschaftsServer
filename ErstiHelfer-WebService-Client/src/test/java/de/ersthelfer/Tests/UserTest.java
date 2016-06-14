package de.ersthelfer.Tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.erstihelfer.erstihelfer.*;

/**
 * 
 * @author Malte Evers
 * 
 **/
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
			// Username existiert bereits => login
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
		int groupNr = 1;
		GregorianCalendar startTime = new GregorianCalendar(2016, 9, 1, 15, 0);
		XMLGregorianCalendar xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(startTime);
		remoteSystem.createAppointment(title, location, xmlCal, description, groupNr);

		// Hole Termine
		int count = 5;
		List<Appointment> apps = remoteSystem.getAppointments(xmlCal, count, groupNr);
		//result größer als 0 und kleiner als count
		assertTrue("Es dürfen nicht mehr Termine als count zurückgegeben werden.", 0 < apps.size() && apps.size()<=count);
		//überprüft ob der kreierte Termin gefunden wurde
		boolean foundApp = false;
		for (Appointment appointment : apps) {
			if(appointment.getTitel().equals(title) && appointment.getLocation().equals(location)) foundApp = true;
		}
		assertTrue("Der hinzugefügte Termin wurde nicht gefunden.", foundApp);
	}

}
