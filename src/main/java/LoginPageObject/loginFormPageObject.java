package LoginPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstract.AbstractComponent;

public class loginFormPageObject extends AbstractComponent {

	WebDriver driver;

	public loginFormPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "inputUsername")
	WebElement userNameField;

	@FindBy(css = "input[type*=\"password\"]")
	WebElement userpassField;

	@FindBy(css = "button[type*=submit]")
	WebElement signinButton;

	@FindBy(css = "p[class=error]")
	WebElement errorMessage;

	@FindBy(xpath = "//a[text()='Forgot your password?']")
	WebElement forgotpass;

	@FindBy(css = "input[placeholder=Name]")
	WebElement forgotName;

	@FindBy(css = "input[placeholder=Email]")
	WebElement forgotEmail;

	@FindBy(css = "input[placeholder*=Phone]")
	WebElement forgotPhone;

	@FindBy(xpath = "//button[text()='Reset Login']")
	WebElement forResetButton;

	@FindBy(xpath = "//button[text()=\"Go to Login\"]")
	WebElement forLoginButton;

	@FindBy(css = "p[class=\"infoMsg\"]")
	WebElement passContain;

	@FindBy(xpath = "//p[text()=\"You are successfully logged in.\"]")
	WebElement successLoginMessage;

	By successMessage = By.xpath("//p[text()=\"You are successfully logged in.\"]");

	public void login(String username2, String pass) {
		userNameField.sendKeys(username2);
		userpassField.sendKeys(pass);
		signinButton.click();
	}
	public void loginCheck(String username2, String pass) {
		login(username2,pass);
		boolean successMessagePresence = driver.findElements(successMessage).size() > 0;
		if (successMessagePresence) {
			System.out.println("Normal Login Successful");
			System.out.println(successLoginMessage.getText());
		} else {
			forgotPassLogin(username2, pass);
			System.out.println("Used Forgot PassWord Login");
		}
	}

	public void forgotPassLogin(String username2, String pass) {
		String correctPass;
		waitforWebElementtobeVisible(errorMessage);
		if (errorMessage.isDisplayed()) {
			forgotpass.click();
			correctPass = getCorrectPass(username2, pass, "12345789");
			forLoginButton.click();
			login(username2, correctPass);
		}
	}

	public String getCorrectPass(String username, String Email, String phone) {
		forgotName.sendKeys(username);
		forgotEmail.sendKeys(Email);
		forgotPhone.sendKeys(phone);
		forResetButton.click();
		String correctPass = passContain.getText().split("'")[1].split("'")[0].trim();
		return correctPass;
	}
}
