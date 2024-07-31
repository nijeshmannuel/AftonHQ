package testcases;

import org.testng.annotations.Test;
import basepackage.BaseClass;
import pages.Page01_afton_login;

import java.util.concurrent.TimeUnit;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TC01_Afton_Test extends BaseClass {

    String id = "nijesh.m+hq@quintet.dev";
    String pass = "#Flock@6454";
    String Invalid_pass1 = "qwerty@123";
    String Invalid_id = "quintet@gmail.com";

    Page01_afton_login a;

    @Test(priority = 1)
    public void afton_login_id_pass() {

    	  SoftAssert softAssert = new SoftAssert();
    	
        // Valid Username and Password
        a.username_1(id);
        a.password_1(pass);
        a.clickSignInButton();

        String actualTitle = a.Homepage_Title_1();
        softAssert.assertEquals(actualTitle, "Account Dashboard", "Title Assertion Failed");

        // Sign out
        a.sign_out_buttoninfo_1();
        a.logout_button_1();
        a.logout_button_popup_1();
        
        //Valid Username and Invalid Password
        
        a.username_1(id);
        a.password_1(Invalid_pass1);
        a.clickSignInButton();
        String validationMessageAssert = a.IdPassValidationMessage();
        softAssert.assertEquals(validationMessageAssert, "Invalid Username or Password or No HQ access.", "Validation Message Not Visible");

        
        //Invalid Username and Valid Password
        a.username_1(Invalid_id);
        a.password_1(pass);
        a.clickSignInButton();
        String validationMessageAssert1 = a.IdPassValidationMessage();
        softAssert.assertEquals(validationMessageAssert1, "Invalid Username or Password or No HQ access.", "Validation Message Not Visible");
        a.username_clear();
        a.password_clear();
        
        //Valid Username with No Password
        a.username_1(id);
        a.password_clear();
        a.clickSignInButton();
       String requiredValidationMessage_12 = a.PasswordRequiredValidation();
       softAssert.assertEquals(requiredValidationMessage_12, "Password is required!", "Validation Message Not Visible");
        
        driver.navigate().refresh();
        
       //No Username with Valid Passwordc
        a.password_1(pass);
        a.clickSignInButton();
        String requiredValidationMessage_13 = a.UsernameRequiredValidation();
        softAssert.assertEquals(requiredValidationMessage_13, "Username is required!", "Validation Message Not Visible");
        
        driver.navigate().refresh();
        
        //No Username and No Password
        a.clickSignInButton();
       String requiredValidationMessage_14 = a.PasswordRequiredValidation();
       softAssert.assertEquals(requiredValidationMessage_14, "Password is required!", "Validation Message Not Visible");
       String requiredValidationMessage_15 = a.UsernameRequiredValidation();
       softAssert.assertEquals(requiredValidationMessage_15, "Username is required!", "Validation Message Not Visible");
       
       driver.navigate().refresh();
       
       //Valid Username and Blank Spaces Password
       a.username_1(id);
       a.Pass_spacekey();
       a.clickSignInButton();
       String requiredValidationMessage_16 = a.Password_SpaceFieldValidationMessage_1();
       softAssert.assertEquals(requiredValidationMessage_16, "The password field is required.", "Space Field Validation Message Not Visible");
       
       driver.navigate().refresh();
       
       //Blank Spaces Username and Valid Password
       a.Username_spacekey();
       a.password_1(pass);
       a.clickSignInButton();
       a.username_SpaceFieldValidationMessage_1();
       
       driver.navigate().refresh();
       
       
       //show and hidden password Functionality
       a.username_1(id);
       a.password_1(pass);
       a.ShowHiddenPassword_click();
       a.ShowHiddenPassword();
       a.ShowHiddenPassword_click();
       a.ShowHiddenPassword();
      
       
       //Click and validate Help Center Page
       a.HelpDeskLoginPage_click();
       a.HelpDeskLoginPageSwitch();
       String requiredValidationpage_1 = a.validatepage();
       softAssert.assertEquals(requiredValidationpage_1, "https://help.aftontickets.com/", "Help Center URL is Different");
      
       //Click and validate Customer Page
       a.SwitchToLoginPage();
       a.AttendeeLoginPage_click();
       a.SwitchToAttendee();
       String AttendeeLoginPage = a.validatepage();
       softAssert.assertEquals(AttendeeLoginPage, "https://stagingqa-demov3.aftontickets.com/login", "Attendee URL is Different");
       
       
       softAssert.assertAll();
    }

    @BeforeTest
    public void beforeTest() {
        browserInitialization("https://stagingqa-demo.aftontickets.com/client/v2/auth/login");
        a = new Page01_afton_login(driver, wait);
    }

    @AfterTest
    public void afterTest() {
        // driver.close();
    }
}
