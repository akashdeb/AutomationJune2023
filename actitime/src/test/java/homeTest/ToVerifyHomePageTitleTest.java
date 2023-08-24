package homeTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.BaseClass;




public class ToVerifyHomePageTitleTest extends BaseClass {

	@Test
	public void toVerifyHomePageTitleTest() throws EncryptedDocumentException, IOException {
		//fetching Home page title from excel sheet

		String homePageTitle = util.fetchStringDataFromExcel("Sheet1", 1, 3);
		
		//Waiting for the title
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(homePageTitle));
		
		//fetching the actual title
		String actualHomePageTitle = driver.getTitle();
		
		//Verifying the home page title
		Assert.assertTrue(actualHomePageTitle.contains(homePageTitle));	
		
	}

}
