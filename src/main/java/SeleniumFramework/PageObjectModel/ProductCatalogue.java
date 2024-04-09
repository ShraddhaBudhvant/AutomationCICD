package SeleniumFramework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver){
		//Initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> Products=driver.findElements(By.cssSelector(".mb-3"));
		//PageFactory
		
		@FindBy(css=".mb-3")
		List<WebElement> Products;
		
		@FindBy(css=".ng-animating")
		WebElement Spinner;
		
		
		
		By productWait= By.cssSelector(".mb-3");
		By addToCart= By.cssSelector(".card-body button:last-of-type");
		By toastMassege=By.id("toast-container");
		
		public List<WebElement> getProductList(){
			
			waitForElementToAppear(productWait);
			return Products;
			
		}
	
		public WebElement getProductByName(String ProductName){
			
			WebElement prod= Products.stream().filter(product->
			product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
			return prod;
		}
		
		public void addProductToCart(String ProductName){
			
			WebElement prod= getProductByName(ProductName);
			prod.findElement(addToCart).click();
			waitForElementToAppear(toastMassege);
			waitForElementToDisappear(Spinner);
			

		}
	
}
