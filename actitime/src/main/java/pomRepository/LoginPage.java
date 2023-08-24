package pomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	//1. Constructor: Initialization
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);	
		this.driver = driver;
	}
	
	//2. FindBy: Identification and declaration of elements
	@FindBy(id = "username") 
	private WebElement usernameTextField;
	
	@FindBy(name = "pwd")  
	public WebElement passwordTextField;
	
	@FindBy(xpath = "//div[text()='Login ']")
	public WebElement loginButton;
	
	@FindBy(id = "keepLoggedInCheckBox")
	public WebElement rememberMeCheckBox;
	
	//3. Business Logics/generic methods
	public void loginActionWithoutRemberingMe(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	
	public void loginActionWithRemberingMe(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		rememberMeCheckBox.click();
		loginButton.click();
	}
	

}
