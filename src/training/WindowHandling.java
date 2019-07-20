package training;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("file:///D:\\SeleniumAppiumTraining\\Day 4\\sample.html");
		String cbrowser=driver.getWindowHandle();
		String newbrowser="";
		System.out.println("Current Browser Title:" +driver.getTitle());
		driver.findElement(By.linkText("Yahoo")).click();
		Set<String> allbrowsers = driver.getWindowHandles();
		
		//Iterate over Set
		for(String s:allbrowsers)
		{
			if(!s.equals(cbrowser)) 
			{
				newbrowser=s;	
				break;
			}
		}
		driver.switchTo().window(newbrowser);
		System.out.println("New Browser Title:" +driver.getTitle());
	}

}
