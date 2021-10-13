package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	ChromeDriver driver = new ChromeDriver();// Initiating ChromeDriver as Public so that, it can accessed by all
												// methods

	public void login() throws InterruptedException {

		driver.get("http://leaftaps.com/opentaps/control/main");
		// to maximize the window opened
		driver.manage().window().maximize();

		Thread.sleep(5000);
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("Demosalesmanager");

		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("crmsfa");

		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		login.click();

		// WebElement linkCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		// linkCRMSFA.click();

	}

	public void clickCRMSFA() {
		// TODO Auto-generated method stub
		WebElement linkCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		linkCRMSFA.click();
	}

	public void createLead() throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement leadsTab = driver.findElement(By.linkText("Leads"));
		leadsTab.click();

		driver.findElement(By.linkText("Create Lead")).click();

		WebElement compName = driver.findElement(By.id("createLeadForm_companyName"));
		compName.sendKeys("Cognizant");

		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.sendKeys("Parameswaran");

		WebElement lastName = driver.findElement(By.id("createLeadForm_lastName"));
		lastName.sendKeys("Sudarsanam");

		// Dropdown Selection
		Select source = new Select(driver.findElement(By.name("dataSourceId")));
		source.selectByVisibleText("Direct Mail");
		// Dropdown
		/*
		 * Select marketingCampaign = new
		 * Select(driver.findElement(By.name("marketingCampaignId")));
		 * marketingCampaign.selectByIndex(1);
		 */

		WebElement mktCamp = driver.findElement(By.name("marketingCampaignId"));
		mktCamp.sendKeys("Affiliate Sites");// Alternate way to select a dropdown value

		WebElement firstNameLocal = driver.findElement(By.name("firstNameLocal"));
		firstNameLocal.sendKeys("Parameswaran");

		WebElement lastNameLocal = driver.findElement(By.name("lastNameLocal"));
		lastNameLocal.sendKeys("Sudarsanam");

		WebElement salutation = driver.findElement(By.name("personalTitle"));
		salutation.sendKeys("Testing");

		WebElement birthDate = driver.findElement(By.name("birthDate"));
		birthDate.sendKeys("01/23/82");

		WebElement title = driver.findElement(By.name("generalProfTitle"));
		title.sendKeys("Create Lead by Paramesh");

		WebElement department = driver.findElement(By.name("departmentName"));
		department.sendKeys("QEA");

		WebElement annualRevenue = driver.findElement(By.name("annualRevenue"));
		annualRevenue.sendKeys("1000000");

		// Dropdown
		Select preferredCurrency = new Select(driver.findElement(By.name("currencyUomId")));
		preferredCurrency.selectByVisibleText("INR - Indian Rupee");
		// Dropdown
		Select industry = new Select(driver.findElement(By.name("industryEnumId")));
		// industry.selectByValue("IND_INSURANCE");
		industry.selectByIndex(6);// to select the value HealthCare from the dropdown using index

		WebElement numberOfEmp = driver.findElement(By.name("numberEmployees"));
		numberOfEmp.sendKeys("150");

		// DropDown
		Select owner = new Select(driver.findElement(By.name("ownershipEnumId")));
		owner.selectByValue("OWN_PARTNERSHIP");
		List<WebElement> ownerDDValues = owner.getOptions();// to get the count of dropdown values
		System.out.println("Owner Drop Down Count Size :" + ownerDDValues.size());

		WebElement sicCode = driver.findElement(By.name("sicCode"));
		sicCode.sendKeys("X0001");

		WebElement tickerSymbol = driver.findElement(By.name("tickerSymbol"));
		tickerSymbol.sendKeys("Automation");

		WebElement description = driver.findElement(By.name("description"));
		description.sendKeys("Selenium Automation");

		WebElement impNote = driver.findElement(By.name("importantNote"));
		impNote.sendKeys("Selenium Automation is interesting");

		WebElement countryCode = driver.findElement(By.xpath("(//input[@name='primaryPhoneCountryCode'])[4]"));
		countryCode.clear();
		countryCode.sendKeys("91");

		WebElement areaCode = driver.findElement(By.xpath("(//input[@name='primaryPhoneAreaCode'])[4]"));
		areaCode.sendKeys("044");

		WebElement phNumber = driver.findElement(By.xpath("(//input[@name='primaryPhoneNumber'])[4]"));
		phNumber.sendKeys("9952022192");

		WebElement extension = driver.findElement(By.name("primaryPhoneExtension"));
		extension.sendKeys("1234");

		WebElement personToAsk = driver.findElement(By.name("primaryPhoneAskForName"));
		personToAsk.sendKeys("Parameswaran");

		WebElement email = driver.findElement(By.name("primaryEmail"));
		email.sendKeys("parameshsf@gmail.com");

		WebElement webURL = driver.findElement(By.name("primaryWebUrl"));
		webURL.sendKeys("http://leaftaps.com/opentaps/control/main");

		WebElement generalToName = driver.findElement(By.name("generalToName"));
		generalToName.sendKeys("Parameswaran S");

		WebElement generalAttentionName = driver.findElement(By.name("generalAttnName"));
		generalAttentionName.sendKeys("Paramesh");

		WebElement address1 = driver.findElement(By.name("generalAddress1"));
		address1.sendKeys("Gemini Magnolia Apartment");

		WebElement address2 = driver.findElement(By.name("generalAddress2"));
		address2.sendKeys("Polachery");

		WebElement city = driver.findElement(By.name("generalCity"));
		city.sendKeys("Chennai");

		// DropDown
		Select country = new Select(driver.findElement(By.name("generalCountryGeoId")));
		country.selectByVisibleText("India");
		Thread.sleep(5000);
		Select state = new Select(driver.findElement(By.name("generalStateProvinceGeoId")));
		state.selectByVisibleText("TAMILNADU");

		WebElement pinCode = driver.findElement(By.name("generalPostalCode"));
		pinCode.sendKeys("600127");

		WebElement pinCodeExt = driver.findElement(By.name("generalPostalCodeExt"));
		pinCodeExt.sendKeys("0000");

		String printFirstName = firstName.getText();
		//System.out.println("Before Create Lead submitted, The entered First Name is :" + printFirstName);

		WebElement createLeadButton = driver.findElement(By.className("smallSubmit"));
		createLeadButton.click();

		Thread.sleep(5000);
	}

	public void findLead() throws InterruptedException {
		// TODO Auto-generated method stub
		// Click Leads tab
		WebElement leadsTab = driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		leadsTab.click();

		// find leads
		WebElement findLeadsLink = driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]"));
		findLeadsLink.click();

		// Click Phone Tab
		WebElement phoneTab = driver.findElement(By.xpath("//span[contains(text(),'Phone')]"));
		phoneTab.click();

		WebElement countryCode = driver.findElement(By.xpath("//input[@name='phoneCountryCode']"));
		countryCode.clear();
		countryCode.sendKeys("91");

		WebElement areaCode = driver.findElement(By.xpath("//input[@name='phoneAreaCode']"));
		areaCode.sendKeys("044");

		WebElement phNumber = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
		phNumber.sendKeys("9952022192");

		WebElement findLeadButton = driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]"));
		findLeadButton.click();
		
		Thread.sleep(10000);
		
		WebElement firstLeadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		String leadID = firstLeadID.getText();
		System.out.println("Lead ID :"+leadID);
		
		firstLeadID.click();
		
		String fNameBefore = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		
		//Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		/*String title = driver.getTitle();
		System.out.println("The Title is : "+title);
		if (title.equalsIgnoreCase("Duplicate Lead")) {
			System.out.println("The title is "+title);
			
		}*/
		String duplicateTitle = driver.findElement(By.xpath("//div[text()='Duplicate Lead']")).getText();
		if (duplicateTitle.contentEquals("Duplicate Lead")) {
			System.out.println("The Title is "+duplicateTitle);
			
		}
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String fNameAfter = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		
		if (fNameBefore.equalsIgnoreCase(fNameAfter)) {
			System.out.println("First Name has the same value before and after duplicate lead");
			
		}
		
				
		

		//driver.close();
		
	}

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();// it will download the driver and setup the path
		
		DuplicateLead clp = new DuplicateLead();
		// Launch application and login
		clp.login(); // Login to leafTap application
		clp.clickCRMSFA();// click CRM/SFA link after successful login
		clp.createLead();//Create Lead page creation
		clp.findLead();// To find the lead id using phone number page

	}

}
