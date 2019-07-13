package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Customer {

	
	WebDriver Driver;
    By TxtName = By.name("name");
    By TxtGender = By.name("rad1");
    By TxtDate = By.name("dob");
    By TxtAddress = By.name("addr");
    By TxtCity = By.name("city");
    By TxtState = By.name("state");
    By TxtPIN = By.name("pinno");
    By TxtMobile = By.name("telephoneno");
    By TxtEmail	 = By.name("emailid");
    By TxtPassword = By.name("password");
    By BtnButton = By.name("sub");
	By idCustomer = By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]");
	 
    public Customer(WebDriver Driver) {
        this.Driver = Driver;
    }
      
    public void setTxtName(String txtName) {
    	Driver.findElement(TxtName).sendKeys(txtName);
	}

	public void setTxtGender(String txtGender) {
		Driver.findElement(TxtGender).sendKeys(txtGender);
	}

	public void setTxtDate(String txtDate) {
		Driver.findElement(TxtDate).sendKeys(txtDate);
	}
	
	public void setTxtAddress(String txtAddress) {
		Driver.findElement(TxtAddress).sendKeys(txtAddress);
	}

	public void setTxtCity(String txtCity) {
		Driver.findElement(TxtCity).sendKeys(txtCity);
	}

	public void setTxtState(String txtState) {
		Driver.findElement(TxtState).sendKeys(txtState);
	}


	public void setTxtPIN(String txtPIN) {
		Driver.findElement(TxtPIN).sendKeys(txtPIN);
	}

	public void setTxtMobile(String txtMobile) {
		Driver.findElement(TxtMobile).sendKeys(txtMobile);
	}

	public void setTxtEmail(String txtEmail) {
		Driver.findElement(TxtEmail).sendKeys(txtEmail);
	}

	public void setTxtPassword(String txtPassword) {
		Driver.findElement(TxtPassword).sendKeys(txtPassword);
	}

	public void ClickBtnSubmit() {
		 Driver.findElement(BtnButton).click();
	}
	
	public void ClickOpcNewCustomer() {
		Driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")).click();
	}

	public String getIdCustomer() {
		WebElement element = ( new WebDriverWait( Driver, 6 ))
				.until( ExpectedConditions.elementToBeClickable( idCustomer ) );
		return element.getText();
	}
	
	public boolean boolIdCustomer() {
		if(Driver.findElement(idCustomer).getText().contains("")) {
			return true;
		}
		return false;
	}

	public void formNewCustomer(String[] customer) throws InterruptedException{
		setTxtName(customer[0]);
		setTxtGender(customer[1]);
		setTxtDate(customer[2]);
		setTxtAddress(customer[3]);
		setTxtCity(customer[4]);
		setTxtState(customer[5]);
		setTxtPIN(customer[6]);
		setTxtMobile(customer[7]);
		setTxtEmail(customer[8]);
		setTxtPassword(customer[9]);
		ClickBtnSubmit();
 	}
    
}
