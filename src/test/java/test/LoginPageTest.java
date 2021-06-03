package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page.DashboardPage;
import Page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginPageTest {
	
	WebDriver driver;
	
	/* @class instructor did this excelreader outside the method to show we create object without any method
	 * ExcelReader excelreader = new ExcelReader("TestData/Test_Data_File.xlsx");
	 * String userName = excelreader.getCellData("LoginData", "UserName", 2); String
	 * password = excelreader.getCellData("LoginData", "Password", 2);
	 */
	
	@Test
	public void validUserLogin() {
		
		BrowserFactory.readtheconfigfile();		
		driver = BrowserFactory.init();
		
		ExcelReader excelreader = new ExcelReader("TestData/Test_Data_File.xlsx");
		String userName = excelreader.getCellData("LoginData", "UserName", 2);		
		String password = excelreader.getCellData("LoginData", "Password", 2);		
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassWord(password);
		loginPage.clickSignIn();
		
		DashboardPage dashBoardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashBoardPage.verifyDashboardTitle();
		
		
		
		
		
		
		
	}

}
