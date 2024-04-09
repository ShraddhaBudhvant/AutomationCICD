package SeleniumFramework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	
	@FindBy (css=".totalRow button")
	WebElement checkOutEle;
	
	@FindBy(css=".cartSection h3")
	 private List<WebElement> ProductsTitle;
	
	
	
	public CartPage( WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}

	
	
	public boolean verifyProductDisplay(String ProductName){
		
		boolean match = ProductsTitle.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	 
	public CheckOutPage goToCheckOut(){
		
		checkOutEle.click();
		CheckOutPage checkOutPage =new CheckOutPage(driver);
		return checkOutPage;
	}
}
