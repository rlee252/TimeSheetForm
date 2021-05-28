package timesheetFiller;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.env.Environment;


public class Main {


	public static void main(String[] args) throws AWTException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Ray\\Desktop\\Week-6 demos\\timesheetFiller\\src\\main\\resources\\chromedriver.exe" );
	WebDriver driver = new ChromeDriver();
    WebDriverWait  wdw = new WebDriverWait(driver, 2);
	
	driver.get("https://rev2.force.com/revature/s/login/");
	//driver.manage().window().maximize();
	String email = System.getenv("revatureEmail");
	String password = System.getenv("revaturePassword");
	wdw.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[placeholder='Username']")));
	
	WebElement emailInput = driver.findElement(By.cssSelector("[placeholder='Username']"));
	WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder='Password']"));	
	WebElement login = driver.findElement(By.xpath("//*[text()='Log in']"));
	
	
	emailInput.sendKeys(email);
	passwordInput.sendKeys(password);
	
	login.click();
	
	wdw.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Open Current Timesheet']")));
	WebElement timesheetButton = driver.findElement(By.cssSelector("[title='Open Current Timesheet']"));	
	timesheetButton.click();
	wdw.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Next Week']")));

	Robot robot = new Robot();
	// Simulate key Events
	for (int i = 0; i <6; i++) {
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	for(int i = 0; i <5; i++) {
		robot.keyPress(KeyEvent.VK_8);
		robot.keyRelease(KeyEvent.VK_8);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	
	for (int i = 0; i <7; i++) {
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	//driver.close();
	
	}

}
