package SeleniumFramework.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFramework.PageObjectModel.CartPage;
import SeleniumFramework.PageObjectModel.OrdersPage;

public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersHeader;
	
	public void waitForElementToAppear (By findBy){
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	public void waitForWebElementToAppear (WebElement ele){
			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		}
	
	
	public CartPage goToCartPage(){
		cartHeader.click();
		CartPage cartPage =new CartPage(driver);
		return cartPage;
	}
	public OrdersPage goToOrdersPage(){
		ordersHeader.click();
		OrdersPage ordersPage =new OrdersPage(driver);
		return ordersPage;
	}
	
	public void waitForElementToDisappear(WebElement ele){
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
