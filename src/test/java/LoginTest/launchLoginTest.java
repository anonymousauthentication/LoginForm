package LoginTest;

import java.io.IOException;

import org.testng.annotations.Test;

import common.BaseTest;

public class launchLoginTest extends BaseTest {
	@Test(groups="Login")
	public void lauchWeb() throws IOException {
		launchWeb();
		
	}
}
