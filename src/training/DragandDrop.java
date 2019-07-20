package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		WebElement draggable=driver.findElement(By.cssSelector("#draggable"));
		WebElement droppable=driver.findElement(By.cssSelector(".ui-widget-header.ui-droppable"));
		Actions action=new Actions(driver);
		action.dragAndDrop(draggable, droppable).build().perform();

	}

}
