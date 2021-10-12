package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookExercise {

	// Initializing chrome driver as static object to access by all methods
	// available in the class
	ChromeDriver driver = new ChromeDriver();

	// Launch Facebook
	@SuppressWarnings("deprecation")
	public void launchFacebook() {
		// TODO Auto-generated method stub
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		// Implicit wait method
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// Create Account for signUp
	public void signUp() throws InterruptedException {
		// TODO Auto-generated method stub
		// CreateAccount Button Click
		// driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		// Input Data
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Parameswaran");
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.sendKeys("Sudarsanam");
		// using sibling xpath for email and confirm email
		WebElement email = driver.findElement(By.xpath("(//div[@class='placeholder']/following-sibling::input)[3]"));
		// WebElement email = driver.findElement(By.name("reg_email__"));
		email.sendKeys("parameshsf@gmail.com");
		
		Thread.sleep(3000);
		
		WebElement confirmEmail = driver
				.findElement(By.xpath("(//div[@class='placeholder']/following-sibling::input)[4]"));
		confirmEmail.sendKeys("parameshsf@gmail.com");
		WebElement pwd = driver.findElement(By.xpath("(//div[@class='placeholder']/following-sibling::input)[5]"));
		pwd.sendKeys("1234%A");
		Select dayDD = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		dayDD.selectByVisibleText("23");
		Select monthDD = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		monthDD.selectByVisibleText("Jan");
		Select yearDD = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		yearDD.selectByVisibleText("1982");
		// Using Parent to Child xPath for female radio button
		WebElement female = driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']/label[1]"));
		female.click();
		
		Thread.sleep(3000);
		
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Initiating Chrome WebDriver
		WebDriverManager.chromedriver().setup();
		FacebookExercise fb = new FacebookExercise();

		fb.launchFacebook();
		fb.signUp();

	}

}
