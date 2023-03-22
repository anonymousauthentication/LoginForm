package LoginTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import LoginPageObject.loginFormPageObject;
import common.BaseTest;

public class loginTest extends BaseTest {
	String wrongpass;
	String username;
	String correctPass;

	@Test(dependsOnGroups = "Login", priority = 1, testName = "LoginCheck", enabled = true)
	public void login() throws IOException {
		getGlobalData();
		wrongpass = prop.getProperty("wrongPass");
		username = prop.getProperty("username");
		loginFormPageObject loginform = new loginFormPageObject(driver);
		String msg = loginform.loginCheck(username, wrongpass);
		System.out.println(msg);
		Assert.assertEquals("You are successfully logged in.", msg);
	}

	@Test(dependsOnGroups = "Login", testName = "VerifyUserName", priority = 2, enabled = false)
	public void verifyUserName() throws IOException {
		getGlobalData();
		username = prop.getProperty("username");
		correctPass = prop.getProperty("correctPass");
		System.out.println(username);
		System.out.println(correctPass);
		loginFormPageObject loginform = new loginFormPageObject(driver);
		String loginUserName = loginform.verifyUserName(username, correctPass);
		Assert.assertEquals(username, loginUserName);
	}
}
