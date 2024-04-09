package SeleniumFramework.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import SeleniumFramework.PageObjectModel.CartPage;
import SeleniumFramework.PageObjectModel.ProductCatalogue;
import SeleniumFramework.TestComponent.BaseTest;


@Test
public class ErrorValidationTest extends BaseTest {
	
		@Test(groups= {"ErrorHandling"}, retryAnalyzer= SeleniumFramework.TestComponent.Retry.class)
		public void loginErrorValidation() throws IOException {
			
		
		LandingPage.LoginApplication("shraddhha@gmail.com", "1Asdf@1234");
		AssertJUnit.assertEquals("Incorrect email or password.", LandingPage.getErrorMassage());
		
		
		

		}
		
		@Test
		public void ProducterrorValidation() throws IOException {
			
		String ProductName= "ZARA COAT 3"; 
		ProductCatalogue productCatalogue =LandingPage.LoginApplication("shraddhha@gmail.com", "Asdf@1234");
		List<WebElement>Products =productCatalogue.getProductList();
		productCatalogue.addProductToCart(ProductName);
		CartPage cartPage=productCatalogue.goToCartPage();
		Boolean match=cartPage.verifyProductDisplay("ZARA COAT 3");
		Assert.assertTrue(match);
		
		
		
		}
		
		
	}





