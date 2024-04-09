package SeleniumFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		//Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

	//WebElement userEmail= driver.findElement(By.id("userEmail"));
		//PageFactory
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		@FindBy(id="login")
		WebElement sumit;
		
		@FindBy(css="[class*='toast-bottom-right']")
		WebElement ErrorMsg;
		
		public ProductCatalogue LoginApplication(String email, String Password){
			userEmail.sendKeys(email);
			passwordEle.sendKeys(Password);
			sumit.click();
			ProductCatalogue productCatalogue =new ProductCatalogue(driver);
			return productCatalogue;
		}
		
		public String getErrorMassage() {
			waitForWebElementToAppear(ErrorMsg);
			
			return ErrorMsg.getText();
			
		}
		
		public void goTo(){
			
			driver.get("https://rahulshettyacademy.com/client");
		}
		
	
}
