package LoginTest;

import org.testng.annotations.Test;
import LoginPageObject.loginFormPageObject;
import common.BaseTest;

public class loginTest extends BaseTest{

	@Test(dependsOnGroups="Login")
	public void login() {
		loginFormPageObject loginform =  new loginFormPageObject(driver);
		loginform.getUserandPass();
	}
}

