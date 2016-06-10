package de.ersthelfer.Tests;
import static org.junit.Assert.*;

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
		// ReturnCodeResponse CODE_OK
		assertEquals("Returncode: " + registerResponse.getReturnCode() + " Message: " + registerResponse.getMessage(),
				0, registerResponse.getReturnCode());
		int sessionId = registerResponse.getSessionId();

		remoteSystem.logout(sessionId);
	}

}
