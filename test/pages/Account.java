package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Account {

	WebDriver Driver;
	
    By TxtIdCustomer = By.name("cusid");
    By TxtAccountType = By.name("selaccount");
    By TxtInitialDeposit = By.name("inideposit");
    By TxtIdAccount = By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]");
    By BtnSubmit  = By.name("button2");
    By TxtAccountNo = By.name("accountno");
    By TxtBalance = By.name("txtinitdep");
    By BtnAccSubmit  = By.name("AccSubmit");
    
    
    public Account(WebDriver Driver) {
        this.Driver = Driver;
    }

	public void setTxtIdCustomer(String txtIdCustomer) {
		Driver.findElement(TxtIdCustomer).sendKeys(txtIdCustomer);
	}

	public void setTxtAccountType(String txtAccountType) {
		Driver.findElement(TxtAccountType).sendKeys(txtAccountType);
	}

	public void setTxtInitialDeposit(String txtInitialDeposit) {
		Driver.findElement(TxtInitialDeposit).sendKeys(txtInitialDeposit);
	}
	
	public void setTxtAccountNo(String txtAccountNo) {
		Driver.findElement(TxtAccountNo).sendKeys(txtAccountNo);
		Driver.findElement(BtnAccSubmit).click();
	}
	
	public String getTxtBalance() {
		return Driver.findElement(TxtBalance).getAttribute("value");
	}

	public void clickBtnSubmit() {
		Driver.findElement(BtnSubmit).click();
	}
	
	public String getIdAccount() {
		WebElement element = ( new WebDriverWait( Driver, 6 ))
				.until( ExpectedConditions.elementToBeClickable( TxtIdAccount ) );
		return element.getText();
	}
	
	public boolean boolIdAccount() {
		if(Driver.findElement(TxtIdAccount).getText().contains("")) {
			return true;
		}
		return false;
	}
	
	public void ClickOpcNewAccount() {
		Driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[5]/a[1]")).click();
	}
	
	public void ClickOpcEditAccount() {
		Driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[6]/a[1]")).click();
	}

	public void formAccount(String idCustomer, String type, String deposit ) throws InterruptedException {
		setTxtIdCustomer(idCustomer);
		setTxtAccountType(type);
		setTxtInitialDeposit(deposit);
		clickBtnSubmit();
	}
    
}
