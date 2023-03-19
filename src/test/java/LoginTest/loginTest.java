package LoginTest;

import java.io.IOException;
import org.testng.annotations.Test;
import LoginPageObject.loginFormPageObject;
import common.BaseTest;

public class loginTest extends BaseTest{

	@Test(dependsOnGroups="Login")
	public void login() throws IOException {
		getGlobalData();
		String pass = prop.getProperty("wrongPass");
		String username = prop.getProperty("username");
		loginFormPageObject loginform =  new loginFormPageObject(driver);
		loginform.loginCheck(username,pass);
	}
}

