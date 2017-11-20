package reusable;

import org.openqa.selenium.WebDriver;

import ObjectRepository.PhpMyTravelsLogin;

public class Login {

	public void login_page(WebDriver driver, String username, String password) {
		try {
		
		new PhpMyTravelsLogin(driver).btnMyAccount.click();
		
			Thread.sleep(2000);
		
		new PhpMyTravelsLogin(driver).linklogin.click();
	
		new PhpMyTravelsLogin(driver).inputuser.sendKeys(username);
		new PhpMyTravelsLogin(driver).inputpassword.sendKeys(password);
		Thread.sleep(2000);

		new PhpMyTravelsLogin(driver).btnlogin.click();
		Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
