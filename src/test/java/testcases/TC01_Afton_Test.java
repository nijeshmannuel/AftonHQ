package testcases;

import org.testng.annotations.Test;
import basepackage.BaseClass;
import pages.Page01_afton_login;
import pages.Page02_Account_Home_Page;

import java.sql.Driver;
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
    Page02_Account_Home_Page b;

    @Test(priority = 0)
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
    
    
    @Test(priority = 1)
    public void Account_Home_Page_SideMenu() {
    	SoftAssert softAssert = new SoftAssert();
    	
    	//Validate LIveStream Page Validation
    	a.SwitchToLoginPage(); 
    	a.username_1(id);
        a.password_1(pass);
        a.clickSignInButton();
        b.LiveStreamEvents_1();
        String LiveStreamUrlValidation = a.validatepage();
        softAssert.assertEquals(LiveStreamUrlValidation, "https://stagingqa-demo.aftontickets.com/client/broadcast", "LIve Stream URL is Different");
        
        
        driver. navigate().back();
        
        //Validate Entire SideMenu | Click & Validate Page
        
        //SideMenu - BoxOffice
        b.BoxOfficeSideMenu_Cick();
        String BoxOfficeSideMenu_Click11 = a.validatepage();
        softAssert.assertEquals(BoxOfficeSideMenu_Click11, "https://stagingqa-demo.aftontickets.com/client/boxoffice", "Box Office URL is Different");
        driver. navigate().back();
        
        //SideMenu - Marketing Tools
        b.MarketingToolsSideMenu_Cick();
        String MarketingToolsSideMenu_Cick11 = a.validatepage();
        softAssert.assertEquals(MarketingToolsSideMenu_Cick11, "https://stagingqa-demo.aftontickets.com/client/app/reward-program", "Marketing Tools URL is Different");
        driver. navigate().back();
        
        //SideMenu - Reports
        b.ReportSideMenu_Cick();
        String ReportSideMenu_Cick11 = a.validatepage();
        softAssert.assertEquals(ReportSideMenu_Cick11, "https://stagingqa-demo.aftontickets.com/client/reports", "Reports URL is Different");
        driver. navigate().back();
        
        //SideMenu - Custom Reports
        b.CustomReportsSideMenu_Cick();
        String CustomReportsSideMenu_Cick11 = a.validatepage();
        softAssert.assertEquals(CustomReportsSideMenu_Cick11, "https://stagingqa-demo.aftontickets.com/client/v2/reports/pre-built", "Custom Report URL is Different");
        driver. navigate().back();
        
        
        //SideMenu - Purchase
        b.PurchasesSideMenu_click();
        String PurchasesSideMenu_click11 = a.validatepage();
        softAssert.assertEquals(PurchasesSideMenu_click11, "https://stagingqa-demo.aftontickets.com/client/purchases/index", "Purchase URL is Different");
        driver. navigate().back();
        
        //SideMenu - contact Customers
        b.ContactCustomersSideMenu_click();
        String ContactCustomersSideMenu_click11 = a.validatepage();
        softAssert.assertEquals(ContactCustomersSideMenu_click11, "https://stagingqa-demo.aftontickets.com/client/tools/audience", "Contact Customers URL is Different");
        driver. navigate().back();
        
        //sideMenu - contact Us
        b.ContactUsSideMenu_click();
        String ContactUsSideMenu_click11 = a.validatepage();
        softAssert.assertEquals(ContactUsSideMenu_click11, "https://stagingqa-demo.aftontickets.com/client/tools/support", "Contact Us URL is Different");
        driver. navigate().back();
        
     // Sign out
        a.sign_out_buttoninfo_1();
        a.logout_button_1();
        a.logout_button_popup_1();
        
        driver.close();
        
        softAssert.assertAll();
    }
    
    @Test(priority = 2)
    public void Account_Home_Page_SideMenu_collapse_Expand() throws InterruptedException {
    	SoftAssert softAssert = new SoftAssert();
    	
    	//Sign into afton Account
    	a.username_1(id);
        a.password_1(pass);
        a.clickSignInButton();
    	
        
        //Validate Expand & Collapse
    	b.CollapseExpandClick();
    	
    	 Thread.sleep(2000);
    	
    	b.CollapseExpandClick();
    	b.CollapseExpandClick();
    	
    	
        
       
        
        
        
        softAssert.assertAll();
    }

    @BeforeTest
    public void beforeTest() {
        browserInitialization("https://stagingqa-demo.aftontickets.com/client/v2/auth/login");
        a = new Page01_afton_login(driver, wait);
        b = new Page02_Account_Home_Page(driver, wait);
       
       
    }

    @AfterTest
    public void afterTest() {
        // driver.close();
    }
}
