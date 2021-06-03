package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page.AddCustomerPage;
import Page.DashboardPage;
import Page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerPageTest {

	WebDriver driver;

	@Test
	public void validUserLoginTest() throws InterruptedException {
		BrowserFactory.readtheconfigfile();

		driver = BrowserFactory.init();

		ExcelReader excelreader = new ExcelReader("TestData/Test_Data_File.xlsx");
		String userName = excelreader.getCellData("LoginData", "UserName", 2);
		String password = excelreader.getCellData("LoginData", "Password", 2);
		String fullName = excelreader.getCellData("TestData", "FullName", 2);
		String comapany = excelreader.getCellData("TestData", "Company", 2);
		String email = excelreader.getCellData("TestData", "Email", 2);
		String phonenumber = excelreader.getCellData("TestData", "PhoneNumber", 2);
		String address = excelreader.getCellData("TestData", "Address", 2);
		String city = excelreader.getCellData("TestData", "City", 2);
		String state = excelreader.getCellData("TestData", "State", 2);
		String zipcode = excelreader.getCellData("TestData", "ZipCode", 2);
		String country = excelreader.getCellData("TestData", "Country", 2);
		String currency = excelreader.getCellData("TestData", "Currency", 2);
		/*
		 * String group = excelreader.getCellData("TestData", "Group", 2);
		 * 
		 * String password_AddCustomerPage = excelreader.getCellData("TestData",
		 * "Password", 2); Thread.sleep(8000); String cpassword =
		 * excelreader.getCellData("TestData", "CPassword", 2);
		 * 
		 */

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassWord(password);
		loginPage.clickSignIn();

		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.verifyDashboardTitle();
		dashboardpage.clickCustomertab();
		dashboardpage.clickAddCustomertab();

		AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerpage.verifyAddCustomerPage();
		addcustomerpage.addFullName(fullName);
		addcustomerpage.selectCompany(comapany);
		addcustomerpage.addemail(email);
		addcustomerpage.addPhoneNumber(phonenumber);
		addcustomerpage.addAddress(address);
		addcustomerpage.addCity(city);
		addcustomerpage.addState(state);
		addcustomerpage.addZip(zipcode);
		addcustomerpage.addCountry(country);
		addcustomerpage.addCurrency(currency);
		/*
		 *  addcustomerpage.addGroup(group);
		 * 
		 * addcustomerpage.addPassword(password_AddCustomerPage);
		 * addcustomerpage.addConfirnPassword(cpassword);
		 */
		addcustomerpage.clickSaveButton();
		addcustomerpage.verifySummaryPage();

		BrowserFactory.tearDown();
	}

}
