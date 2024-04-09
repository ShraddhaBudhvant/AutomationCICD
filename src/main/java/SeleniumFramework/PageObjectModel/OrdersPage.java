package SeleniumFramework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class OrdersPage extends AbstractComponents {
	WebDriver driver;
	
	@FindBy (css=".totalRow button")
	WebElement checkOutEle;
	
	@FindBy(css="tr td:nth-child(3)")
	 private List<WebElement> ordersList;
	
	
	
	public OrdersPage( WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}

	
	
	public boolean verifyOrdersDisplay(String ProductName){
		
		boolean match = ordersList.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	 

}
