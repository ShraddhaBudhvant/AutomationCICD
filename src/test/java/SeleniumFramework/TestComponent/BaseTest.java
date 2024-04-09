package SeleniumFramework.TestComponent;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFramework.PageObjectModel.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public  WebDriver driver;
	public LandingPage LandingPage;
	private List<HashMap<String, String>> data;
	
	public  WebDriver Initializedriver() throws IOException{
		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		//properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+"//src//main//java//SeleniumFramework//resorces//GobalData.properties");
		prop.load(fis);
		
		String browserName= System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		
		//String browserName =prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{	
			//chrome driver path
			
		ChromeOptions option = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless")) 
		{
		option.addArguments("headless");
		}
		driver= new ChromeDriver(option);
		driver.manage().window().setSize(new Dimension(1440,900));// full screen mode 
		
		}else if (browserName.equalsIgnoreCase("firefox")){
			
			// firefox driver path
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")){
			//edge driver path
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	return driver;
	
	}
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// reading Json to string
		String JsonContent= FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		// string to HashMap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});
			return data;
		}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File sources= ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//"+ testCaseName + ".png");
		FileUtils.copyFile(sources, file);
		return System.getProperty("user.dir")+ "//reports//"+ testCaseName + ".png";
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException{
		
		driver= Initializedriver();
		LandingPage= new LandingPage(driver);
		LandingPage.goTo();
		return LandingPage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	
}












