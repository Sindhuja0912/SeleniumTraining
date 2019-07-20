package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_top']")));
		
		//frame identification if the name is not given
		//driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_left']")));
		
		//frame identification directly if name is available
		driver.switchTo().frame("frame-middle");
		
		String sData=driver.findElement(By.id("content")).getText();
		System.out.println(sData);
		
		//to switch to default content
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_top']")));
		
		driver.switchTo().frame("frame-right");
		
	}

}
