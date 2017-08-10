package test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Tester {
	
	private WebDriver webDriver;
	private AddUserPage addUserPage;
	private LoginPage loginPage;
	String web = "http://thedemosite.co.uk";
	String username = "jimbob";
	String password = "jimbob";
	private ExtentReports report;
    private ExtentTest test;
    private String reportFilePath = "test.html";
	/*Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);gh*/
			
	
	@Before
	public void before() {
		report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("Login Report");
        extentHtmlReporter.config().setDocumentTitle("Statistics");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("Login Test");
		
		webDriver = new ChromeDriver();
		addUserPage = PageFactory.initElements(webDriver, AddUserPage.class);
		loginPage = PageFactory.initElements(webDriver, LoginPage.class);
	}
	
	@BeforeClass
    public static void init(){

    }
	
	@Test 
	public void test() {
		webDriver.manage().window().maximize(); //maximises page so all options can be seen
		webDriver.navigate().to(web); //opens the web site 
		
		waitingTime();
		
		addUserPage.clickAdd();
		
		waitingTime();
		
		addUserPage.addEnterUsername(username);
		
		waitingTime();
		
		addUserPage.addEnterPassword(password);
		
		waitingTime();
		
		addUserPage.addClickSave();
		
		waitingTime();
		
		loginPage.clickLoginButt();
		
		waitingTime();
		
		loginPage.enterUsername(username);
		
		waitingTime();
		
		loginPage.enterPassword(password);
		
		waitingTime();
		
		loginPage.clickSave();
		
		waitingTime();
		
		test.log(Status.INFO,"Info level");
        test.fail("Failed");
	}
	
	@After
	public void after() {
		report.flush();
		webDriver.quit();
	}

	public void waitingTime() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
