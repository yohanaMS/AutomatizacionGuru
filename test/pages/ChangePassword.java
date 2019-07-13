package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassword {

	WebDriver Driver;
   	By TxtOldPassword = By.name("oldpassword");
    By TxtNewPassword = By.name("newpassword");
    By TxtConfirmPassword = By.name("confirmpassword");
    By BtnSubmit = By.name("sub");
    By BtnReset = By.name("res");
    
    public ChangePassword(WebDriver Driver) {
        this.Driver = Driver;
    }
    
    public void ClickChangePassword(){
    	Driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[11]/a")).click();
    }
    
    public void SetTxtOldPassword(String oldpassword){
        Driver.findElement(TxtOldPassword).sendKeys(oldpassword);
    }
    
    public void SetTxtNewPassword(String newpassword){
        Driver.findElement(TxtNewPassword).sendKeys(newpassword);
    }
    
    public void SetTxtConfirmPassword(String confirmpassword){
        Driver.findElement(TxtConfirmPassword).sendKeys(confirmpassword);
    }
    
 
    public void ClickBtnSubmit(){
        Driver.findElement(BtnSubmit).click();
    }
    
    public void ClickBtnReset(){
        Driver.findElement(BtnReset).click();
    }
    
   public void formPassword(String oldPassword, String newPassword){
	   ClickChangePassword();
	   SetTxtOldPassword(oldPassword);
	   SetTxtNewPassword(newPassword);
	   SetTxtConfirmPassword(newPassword);
	   ClickBtnSubmit();
	}
   
   public String getMensajeAlert(){
       Alert Messege = Driver.switchTo().alert();
       return Messege.getText();
   }
   
   public void aceptarAlert(){
       Driver.switchTo().alert().accept();
   }
   
   public void resetButtonPassword(String oldPassword, String newPassword){
	   SetTxtOldPassword(oldPassword);
	   SetTxtNewPassword(newPassword);
	   SetTxtConfirmPassword(newPassword);
	   ClickBtnReset();
	}
   
   
}
