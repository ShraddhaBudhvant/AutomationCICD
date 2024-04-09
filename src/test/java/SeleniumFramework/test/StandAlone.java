package SeleniumFramework.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFramework.PageObjectModel.CartPage;
import SeleniumFramework.PageObjectModel.CheckOutPage;
import SeleniumFramework.PageObjectModel.ConfirmationPage;
import SeleniumFramework.PageObjectModel.OrdersPage;
import SeleniumFramework.PageObjectModel.ProductCatalogue;
import SeleniumFramework.TestComponent.BaseTest;

public class StandAlone extends BaseTest {
	String ProductName= "ZARA COAT 3";
	
		@Test(dataProvider="getData", groups= "Parches")
		public void submitOrder(HashMap<String, String> input) throws IOException {
			
		 
		ProductCatalogue productCatalogue =LandingPage.LoginApplication(input.get("email"),input.get("Password"));
		List<WebElement>Products =productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("ProductName"));;
		CartPage cartPage=productCatalogue.goToCartPage();
		Boolean match=cartPage.verifyProductDisplay(input.get("ProductName"));
		Assert.assertTrue(match);
		CheckOutPage checkOutPage= cartPage.goToCheckOut();
		checkOutPage.SelectCountry("India");
		ConfirmationPage confirmationPage = checkOutPage.sumbitOrder();
		String confirmMassege= confirmationPage.getConfirmationMassege();
		Assert.assertTrue(confirmMassege.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
		}
		
		@Test(dependsOnMethods= {"submitOrder"})
		public void orderHistoryTest() {
			//zara coat 3
			
			ProductCatalogue productCatalogue =LandingPage.LoginApplication("shraddhha@gmail.com", "Asdf@1234");
			OrdersPage OrdersPage= productCatalogue.goToOrdersPage();
			OrdersPage.verifyOrdersDisplay(ProductName);
		}
		
		
		
		@DataProvider
		public Object[][] getData() throws IOException {			
			
			List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\framework\\data\\ParchesOrder.json");
			return new Object[][]{{data.get(0)},{data.get(1)}};
			
		}
		
		
		
		
		
		
		
		
		
//		@DataProvider
//		public Object[][] getData() {
//			return new Object[][]{{"shraddhha@gmail.com","Asdf@1234","ZARA COAT 3"},{"tanvi@gmail.com","Asdf@1234","ADIDAS ORIGINAL"}};
//		}
//		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "shraddhha@gmail.com");
//		map.put("Password", "Asdf@1234");
//		map.put("ProductName", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "tanvi@gmail.com");
//		map1.put("Password", "Asdf@1234");
//		map1.put("ProductName", "ADIDAS ORIGINAL");
		
	}





