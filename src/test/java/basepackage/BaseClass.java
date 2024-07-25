package basepackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public void browserInitialization(String url) {
		String driverPath = "/home/nijeshmannuel/chromedriver-linux64/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverPath);
		System.out.println(driverPath);
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get(url);
		System.out.println("Opening url: "+url);
		driver.manage().window().maximize();
	
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



}
}
