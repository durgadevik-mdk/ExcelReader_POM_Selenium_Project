package Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ListCustomerPage extends BasePage {

	WebDriver driver;

	public ListCustomerPage(WebDriver driver) {

		this.driver = driver;
	}

	String givenname;

	public void excelfullname(String fullname) {
		givenname = fullname;

	}

	public void findEntenteredNameAndDelete() throws InterruptedException {

		String Before_Xpath = "//table/tbody/tr[";

		String After_Xpath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {

			String element = driver.findElement(By.xpath(Before_Xpath + i + After_Xpath)).getText();
			if (element.contentEquals(givenname)) {
				System.out.println("name exists");
				driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[7]/a[2]")).click();
				break;
			}
			driver.switchTo().alert().accept();

		}

	}

	/*
	 * @FindBy(how = How.XPATH, using = "//table/tbody/tr[1101]/td[1]") WebElement
	 * LAST_ROW_OF_TABLE; public void deleteFromBottomOfTable() { String number =
	 * LAST_ROW_OF_TABLE.getText(); System.out.println("fhsa;ljlsjd'lsa"+number); }
	 */

}
