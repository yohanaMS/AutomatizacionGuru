/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ymsuare
 */
public class Login {
    WebDriver Driver;
    
    By TxtUser = By.name("uid");
    By TxtPassword = By.name("password");
    By BtnLogin = By.name("btnLogin");
    
    public Login(WebDriver Driver){
        this.Driver = Driver;
    }
    
    public void SetTxtUser(String User){
        Driver.findElement(TxtUser).sendKeys(User);
    }
    
    public void SetTxtPassword(String Password){
        Driver.findElement(TxtPassword).sendKeys(Password);
    }
    
    public void ClickBtnLogin(){
        Driver.findElement(BtnLogin).click();
    }
    
    public void LlenarLogin(String User, String Password){
        SetTxtUser(User);
        SetTxtPassword(Password);
        ClickBtnLogin();
    }
    
    public String getUsuarioIngresado(){
        WebElement messege = Driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
        return messege.getText();
    }
}
