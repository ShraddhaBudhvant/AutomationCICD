package SeleniumFramework.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	WebDriver driver;
	
	public CheckOutPage( WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}
	
	//driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy (css=".action__submit")
	WebElement submit;
	
	@FindBy (xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	//driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	@FindBy (xpath="(//button[@type='button'])[2]")
	WebElement selectCountry;
	
	By result= By.cssSelector(".ta-results");
	
	public void SelectCountry(String countryName){
		
		Actions a= new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		
		waitForElementToAppear(result);
		
		selectCountry.click();
		
	
	}
	
	public ConfirmationPage sumbitOrder(){
		 submit.click();
		 ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
		 
	}
	
}
