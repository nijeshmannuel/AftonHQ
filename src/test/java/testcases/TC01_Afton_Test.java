package testcases;

import org.testng.annotations.Test;

import basepackage.BaseClass;
import pages.Page01_afton_login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC01_Afton_Test extends BaseClass {
	
	String id = "nijesh.m+hq@quintet.dev";
	String pass = "#Flock@6454";
	
	String Invalid_pass1 = "qwerty@123";
	String Invalid_id = "quintet@gmail.com";
	
	Page01_afton_login a;
	
  @Test( priority = 1)
  public void afton_login_id_pass() {
	  
	  a.username_1(id);
	  a.password_1(pass);
	  a.clickSignInButton();
	  //a.Homepage_Title_1();
	  
	  String actualTitle = a.Homepage_Title_1();
	  
    Assert.assertEquals(actualTitle, "Account Dashboard", "Title Assertion Failed");
    
     a.sign_out_buttoninfo_1();
     a.logout_button_1();
     a.logout_button_popup_1();
	 a.valid_username_invalid_password_1(id , Invalid_pass1); 
	 a.clickSignInButton();
	 String validation_message_assert = a.validusern_and_invalidpass_1();
	  
	    Assert.assertEquals(validation_message_assert, "Invalid Username or Password or No HQ access.", "Validation Message Not Visible");
	    
	   // a.invalid_username_valid_password_1(Invalid_id , pass);
  }
 

  @BeforeTest
  public void beforeTest() {
	  browserInitialization("https://stagingqa-demo.aftontickets.com/client/v2/auth/login");
	  a = new Page01_afton_login (driver,wait);
  }

  @AfterTest
  public void afterTest() {
  }

}
