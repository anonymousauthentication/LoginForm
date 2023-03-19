package LoginPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginFormPageObject {

	WebDriver driver;

	public loginFormPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "inputUsername")
	WebElement userName;

	public void getUserandPass() {
		userName.sendKeys("aaa");
	}
}
