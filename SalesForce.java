package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	// Initializing chrome driver as static object to access by all methods
	// available in the class
	ChromeDriver driver = new ChromeDriver();

	// Launch SalesForce
	@SuppressWarnings("deprecation")
	public void launchSalesForce() {
		// TODO Auto-generated method stub
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		driver.manage().window().maximize();
		// Implicit wait method
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// Create Account for signUp
	@SuppressWarnings("deprecation")
	public void signUp() throws InterruptedException {
		// TODO Auto-generated method stub

		// Input Data
		WebElement firstName = driver.findElement(By.xpath("//input[@name='UserFirstName']"));
		firstName.sendKeys("Parameswaran");
		WebElement lastName = driver.findElement(By.xpath("//input[@name='UserLastName']"));
		lastName.sendKeys("Sudarsanam");

		WebElement workEmail = driver.findElement(By.xpath("//input[@name='UserEmail']"));
		// WebElement workEmail = driver.findElement(By.name("UserEmail"));
		workEmail.sendKeys("parameshsf@gmail.com");

		// DropDown
		Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='UserTitle']")));
		jobTitle.selectByVisibleText("Sales Manager");

		WebElement company = driver.findElement(By.xpath("//input[@name='CompanyName']"));
		company.sendKeys("Cognizant");

		// DropDown
		Select emp = new Select(driver.findElement(By.xpath("//select[@name='CompanyEmployees']")));
		emp.selectByVisibleText("101 - 500 employees");

		WebElement userPhone = driver.findElement(By.xpath("//input[@name='UserPhone']"));
		userPhone.sendKeys("9952022192");
		
		WebElement agreeCheckBox = driver
				.findElement(By.xpath("//input[@id='SubscriptionAgreement']/following-sibling::div"));
		agreeCheckBox.click();
		System.out.println("The agree check box is "+agreeCheckBox.isSelected());
		
		if (agreeCheckBox.isSelected() == true) {
			System.out.println("CheckBox Selected");

		} else {
			System.out.println("Checkbox Not Selected");
		}

		// DropDown
		Select country = new Select(driver.findElement(By.xpath("//select[@name='CompanyCountry']")));
		country.selectByVisibleText("American Samoa");
		Thread.sleep(5000);
		
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Initiating Chrome WebDriver
		WebDriverManager.chromedriver().setup();
		SalesForce sf = new SalesForce();

		sf.launchSalesForce();
		sf.signUp();

	}

}
