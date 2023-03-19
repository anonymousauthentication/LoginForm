package Abstract;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent extends AbstractLocator {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	public void waitforWebElementtobeVisible(WebElement element) {
		WebDriverWait wc = new WebDriverWait(driver, Duration.ofSeconds(5));
		wc.until(ExpectedConditions.visibilityOf(element));
	}
}
