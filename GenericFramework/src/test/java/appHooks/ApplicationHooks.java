package appHooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.util.ConfigReader;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader confiReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() throws IOException {
		confiReader=new ConfigReader();
		prop=confiReader.init_prop();
		
	}
	@Before(order=1)
	public void launchBrowser() {
		String browser=prop.getProperty("browserName");
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browser);
		
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario sc) {
		if(sc.isFailed()) {
		String screenshotName=sc.getName().replaceAll(" ", "_");
		byte[] source=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(source, "image/png", screenshotName);
		}
	}

}
