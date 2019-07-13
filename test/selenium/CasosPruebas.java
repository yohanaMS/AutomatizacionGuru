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

import pages.Account;
import pages.Customer;
import pages.ChangePassword;
import pages.FundTransfer;
import pages.Login;

/**
 *
 * @author ymsuare
 */
public class CasosPruebas {
    
    Random R = new Random();

    String User = "mngr206619";
    String Password = "Uno1234!";
	String newPassword = "Dos1234!";
	
    String IdAccount;
    String TypeAccount = "Savings";
    String InitDeposit = "10000";
    
    String Amount = "5000";
    String Description = "Deposit test";
    
    String Balance;

    String[] Customer = {
        "Sebastiancito", //[0] Name
        "m", //[1] Gender
        "03/06/1996",//[2] Date Birth
        "cll 98 Nro 87 21", //[3] Address
        "Medellin", //[4] City
        "Antioquia", //[5] State
        "123456", //[6] PIN
        "3018541495", //[7] Mobile number
        "sebastianx" + R.nextInt(10000) + "@gmail.com", //[8] Email
        "Uno1234!", //[9] Password
        "" //[10] Id Customer
    };

    private WebDriver Driver;
    private String BaseURL = "http://demo.guru99.com/V4/index.php";

    Login LoginTest;
    FundTransfer FTransferTest;
    ChangePassword cPassword;
    Customer customer;
    Account account;
   
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
    
    @Test
    public void CambioPassword() throws InterruptedException {
    	cPassword = new ChangePassword(Driver);
    	cPassword.ClickChangePassword();
    	cPassword.formPassword(Password, newPassword);
    	Thread.sleep(2000);
        assertEquals("Password is Changed", cPassword.getMensajeAlert());
        cPassword.aceptarAlert();
        LoginTest.LlenarLogin(User, newPassword);
        assertEquals("Manger Id : " + User, LoginTest.getUsuarioIngresado() );
        cPassword.ClickChangePassword();
    	cPassword.formPassword(newPassword, Password);
    }
    
    @Test
    public void FundTransfer() throws InterruptedException {
    	String Amount = "3000";
    	customer = new Customer(Driver);
    	customer.ClickOpcNewCustomer();
    	customer.formNewCustomer(Customer);
    	String customer1 = customer.getIdCustomer();
        assertTrue(customer.boolIdCustomer());
        account = new Account(Driver);
        account.ClickOpcNewAccount();
        account.formAccount(customer1, TypeAccount, InitDeposit);
        String account1 = account.getIdAccount();
        assertTrue(account.boolIdAccount());
        account.ClickOpcNewAccount();
        account.formAccount(customer1, TypeAccount, InitDeposit);
        String account2 = account.getIdAccount();
        assertTrue(account.boolIdAccount());
        FTransferTest = new FundTransfer(Driver);
        FTransferTest.ClickBtnFundTransfer();
        FTransferTest.llenarFundTransfer(account1, account2, Amount, "Caso prueba 2");
        account.ClickOpcEditAccount();
        account.setTxtAccountNo(account1);
        String balance1 = Integer.toString(Integer.parseInt(InitDeposit) - Integer.parseInt(Amount));
        assertEquals(balance1, account.getTxtBalance() );
        account.ClickOpcEditAccount();
        account.setTxtAccountNo(account2);
        String balance2 = Integer.toString(Integer.parseInt(InitDeposit) + Integer.parseInt(Amount));
        assertEquals(balance2, account.getTxtBalance());
        
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
