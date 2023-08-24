package genericUtils;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pomRepository.HomePage;
import pomRepository.LoginPage;

public class BaseClass {
	
	//declaring WebDriver
	public WebDriver driver;
	//Creating an object of UtilData Class
	public UtilData util = new UtilData();
	
	
	@BeforeSuite
	public void bsConfig() {
		System.out.println("Data base connection established");
	}
	
	@BeforeTest
	public void btConfig() {
		System.out.println("Parallel execution achieved");
	}
	
	
	@BeforeClass
	public void bcConfig() throws EncryptedDocumentException, IOException {
		//fetching url from excel sheet
		String url = util.fetchStringDataFromExcel("Sheet1", 1, 0);
		
		//Launching the browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Browser is launched");
		
		//Navigate to the URL
		driver.get(url);
		System.out.println("The URL has been navigated");
	}
	
	@BeforeMethod
	public void bmConfig() throws EncryptedDocumentException, IOException {
		
		//fetching username and password from excel sheet
		String username = util.fetchStringDataFromExcel("Sheet1", 1, 1);
		String password = util.fetchStringDataFromExcel("Sheet1", 1, 2);

		//Login to the Application
		LoginPage login=new LoginPage(driver);
		login.loginActionWithoutRemberingMe(username, password);
		System.out.println("Logged in to the Application");
	}
	
	@AfterMethod
	public void amConfig() {
		//Logout from the application
		HomePage home = new HomePage(driver);
		home.logoutAction();
		System.out.println("Logged out from the Application");

	}
	
	@AfterClass
	public void acConfig() {
		//closing the browser
		driver.quit();
		System.out.println("Close the browser");
	}
	
	@AfterTest
	public void atConfig() {
		
		System.out.println("Parallel execution stopped");
	}
	
	@AfterSuite
	public void asConfig() {
		System.out.println("Data base connection is closed");
	}
	
	
}
