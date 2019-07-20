package training;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridProgram {
	static WebDriver driver;
	
	@Test
	public void f() throws MalformedURLException {
		
		String hubUrl="http://localhost:4445/wd/hub";
		DesiredCapabilities cap= DesiredCapabilities.chrome();
		cap.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(hubUrl),cap);
		driver.get("http://www.yahoo.com");
	}
		
		
	@Test
		public void f1() throws MalformedURLException {
			
			String hubUrl="http://localhost:4445/wd/hub";
			DesiredCapabilities cap= DesiredCapabilities.firefox();
			cap.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(hubUrl),cap);
			driver.get("http://www.yahoo.com");
			
				
	}
	
	

}
