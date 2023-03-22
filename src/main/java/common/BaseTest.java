package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	public static WebDriver driver;
	public Properties prop;
	public FileInputStream files;
	public String weburl;

	public void invokeBrowser() throws IOException {
		getGlobalData();
		String browserName = prop.getProperty("browser");
		weburl = prop.getProperty("loginpageurl");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		if(browserName.contains("chrome")) {
		driver = new ChromeDriver(options);
		}
		else if  (browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
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
