package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithFields {
	
	ChromeDriver driver = new ChromeDriver();
	
	@SuppressWarnings("deprecation")
	public void workWithFields() {
		// TODO Auto-generated method stub
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50000,TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("Parameshsf@gmail.com");
		
		WebElement append = driver.findElement(By.xpath("//input[@value='Append ']"));
		String text = append.getAttribute("value");
		append.clear();
		append.sendKeys("ABCD"+"-"+text);
		System.out.println(append.getAttribute("value"));
		
		String value = driver.findElement(By.name("username")).getAttribute("Value");
		System.out.println("Print the text "+value);
		
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		
		boolean enabled = driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		if (enabled) {
			System.out.println("The text box is enabled "+enabled);
					
		}
		else {
			System.out.println("The text box is disabled "+enabled);
		}
			
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WorkWithFields wF = new WorkWithFields();
		
		wF.workWithFields();

	}

}
