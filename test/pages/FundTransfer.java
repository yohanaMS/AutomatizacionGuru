/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author ymsuare
 */
public class FundTransfer {
    WebDriver Driver;
    
    By TxtPayers = By.name("payersaccount");
    By TxtPayees = By.name("payeeaccount");
    By TxtAmount = By.name("ammount");
    By TxtDescription = By.name("desc");
    By BtnSubmit = By.name("AccSubmit");
    By BtnReset = By.name("res");
    By MsgPayers =By.id("message10");

    public FundTransfer(WebDriver Driver) {
        this.Driver = Driver;
    }
        
     public void ClickBtnSubmit(){
       Driver.findElement(BtnSubmit).click();
    }
     
     public void ClickBtnReset(){
       Driver.findElement(BtnReset).click();
    }

    public void setTxtPayers(String payers) {
        Driver.findElement(TxtPayers).sendKeys(payers);
    }

    public void setTxtPayees(String payees) {
        Driver.findElement(TxtPayees).sendKeys(payees);
    }

    public void setTxtAmount(String amount) {
        Driver.findElement(TxtAmount).sendKeys(amount); 
    }
    
    public void setTxtDescription(String description) {
       Driver.findElement(TxtDescription).sendKeys(description);
    }
     
    public void llenarFundTransfer(String payers, String payees, String amount, String description){
        setTxtPayers(payers);
        setTxtPayees(payees);
        setTxtAmount(amount);
        setTxtDescription(description);
        ClickBtnSubmit();
    }
     
    public String getMensajeAlert(){
        Alert Messege = Driver.switchTo().alert();
        return Messege.getText();
    }
    
    public String getMensajePayers(){
        return Driver.findElement(MsgPayers).getText();
     }
    
     
}
