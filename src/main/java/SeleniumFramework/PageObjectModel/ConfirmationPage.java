package SeleniumFramework.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	WebDriver driver;
	
	public ConfirmationPage( WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMassege;
	
	By cfrmText = By.cssSelector(".hero-primary");
	
	public String getConfirmationMassege(){
		waitForElementToAppear(cfrmText);
		
		return confirmationMassege.getText();
		
	}
	
}
