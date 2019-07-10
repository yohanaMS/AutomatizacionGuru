/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FundTransfer;
import pages.Login;

/**
 *
 * @author ymsuare
 */
public class CasosPruebas {
    
    Random R = new Random();

    String User = "mngr206619";
    String Password = "EjabYsY";

    String IdAccount;
    String TypeAccount = "Savings";
    String InitDeposit = "10000";
    
    String Amount = "5000";
    String Description = "Deposit test";
    
    String Balance;

    String[] Customer = {
        "Sebastian", //[0] Name
        "m", //[1] Gender
        "03/06/1996",//[2] Date Birth
        "cll 98 Nro 87 21", //[3] Address
        "Medellin", //[4] City
        "Antioquia", //[5] State
        "123456", //[6] PIN
        "3018541495", //[7] Mobile number
        "sebastianx" + R.nextInt(10000) + "@gmail.com", //[8] Email
        "123456789", //[9] Password
        "" //[10] Id Customer
    };

    private WebDriver Driver;
    private String BaseURL = "http://demo.guru99.com/V4/index.php";

    Login LoginTest;
    FundTransfer FTransferTest;
    
   
    
    public CasosPruebas() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
    }
        
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Driver = new ChromeDriver();
        Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Driver.get(BaseURL);

        LoginTest = new Login(Driver);
        LoginTest.LlenarLogin(User, Password);
    }
    
    @Test
    public void VerificarUsuario() {
        assertEquals("Manger Id : " + User,LoginTest.getUsuarioIngresado() );
    }
    
    @Test
    public void ObligatoriedadPayees() {
        FTransferTest = new FundTransfer(Driver);
        FTransferTest.ClickBtnFundTransfer();
        FTransferTest.llenarFundTransfer("", "123456", "300000", "Caso prueba 1");
        assertEquals("Please fill all fields", FTransferTest.getMensajeAlert());
        FTransferTest.aceptarAlert();
        assertEquals("Payees Account Number must not be blank" ,FTransferTest.getMensajePayees() );
    }
    
    @After
    public void tearDown() {
     Driver.quit();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
