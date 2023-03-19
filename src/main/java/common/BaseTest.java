package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	public static WebDriver driver;
	public Properties prop;
	public FileInputStream files;
	public String weburl;

	public void invokeBrowser() throws IOException {
		getGlobalData();
		weburl = prop.getProperty("loginpageurl");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	public void getUrl() {
		driver.get(weburl);
	}

	public void launchWeb() throws IOException {
		invokeBrowser();
		getUrl();
	}

	public void getGlobalData() throws IOException {
		prop = new Properties();
		String path = System.getProperty("user.dir") + "/src/main/java/resources/global.properties";
		System.out.println(path);
		files = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/global.properties");
		prop.load(files);
	}

}
