package de.erstihelfer.client;

import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import de.erstihelfer.erstihelfer.ErstiHelferOnlineIntegration;
import de.erstihelfer.erstihelfer.ErstiHelferOnlineIntegrationService;
import de.erstihelfer.erstihelfer.*;

/**
 * 
 * @author Malte Evers
 */
public class ErstiHelferClient {

	private static ErstiHelferOnlineIntegration remoteSystem;

	/**
	 * In dieser Main-Methode werden Requests an den Server abgeschickt.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ErstiHelferOnlineIntegrationService service = new ErstiHelferOnlineIntegrationService();
			remoteSystem = service.getErstiHelferOnlineIntegrationPort();

			System.out.println("Client hat folgendes Server-Objekt erhalten:");
			System.out.println("remoteSystem.toString(): \n" + remoteSystem.toString());
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		// test_LoginRegister();
		test_CreateAndGetAppointments();
		
	}

	/**
	 * Test-Szenario: Es wird registriert und eingeloggt
	 */
	private static void test_LoginRegister() {
		String username = "Malte";
		String password = "12345";
		int groupNr = 1;
		System.out.println("============================================================");
		UserLoginResponse registerResponse = remoteSystem.registerNewUser(username, groupNr);
		// ReturnCodeResponse CODE_OK
		if (registerResponse.getReturnCode() == 0) {
			int sessionId = registerResponse.getSessionId();
			System.out.println("Registrierung von " + username + " in der Gruppe " + groupNr + " erfolgreich.");

			remoteSystem.logout(sessionId);
		} else {
			System.out.println(registerResponse.getMessage());
		}
	}

	private static void test_CreateAndGetAppointments() {
		GregorianCalendar startTime = new GregorianCalendar(2016, 9, 1, 12, 0);
		XMLGregorianCalendar xmlCal;
		try {
			xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(startTime);
			remoteSystem.createAppointment("Schlacht um Helms Klamm", "Helms Klamm", xmlCal,
					"Orks gegen Menschen. Seid pünktlich!(ErstiHelftClient.main)", 1);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	}

}
