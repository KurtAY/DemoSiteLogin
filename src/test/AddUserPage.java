package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage {

	@FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p"
			+ " > small > a:nth-child(6)")
	private WebElement clickAddUser;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center "
			+ "> table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	private WebElement iniUsernameInput;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center "
			+ "> table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	private WebElement iniPasswordInput;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center "
			+ "> table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	private WebElement iniSaveButton;
	
	
	public void clickAdd() {
		clickAddUser.click();
	}
	
	public void addEnterUsername(String username) {
		iniUsernameInput.sendKeys(username);
	}
	
	public void addEnterPassword(String password) {
		iniPasswordInput.sendKeys(password);
	}
	
	public void addClickSave() {
		iniSaveButton.click();
	}
}
