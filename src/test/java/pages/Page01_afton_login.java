package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page01_afton_login {

    private WebDriver driver;
    private WebDriverWait wait;

    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By signin_button = By.xpath("//button[normalize-space()='Sign in']");
    private By Homepage_Title = By.xpath("(//h1[text()='Account Dashboard'])[1]");
    private By Sign_out_buttoninfo = By.xpath("//div[@class='client-details']");
    private By logout_button = By.xpath("//button[text()='Logout']");
    private By logout_button_popup = By.xpath("//button[@class='btn btn-primary']");
    private By validusern_and_invalidpass = By.xpath("//div[@class='error-msg']");
    private By requiredValidationMessage = By.xpath("//small[normalize-space()='Password is required!']");
    private By usernamevalidationMessage = By.xpath("//small[normalize-space()='Username is required!']");
    private By SpaceFieldValidationMessage = By.xpath("//div[text()='The password field is required.']");
    private By usernameSpaceFieldValidationMessage = By.xpath("//small[text()='Username must be a valid email!']");
    private By ShowHiddenPassword = By.xpath("(//button[@class=\"btn btn-link\"])[1]");
    private By ShowHiddenPassword_inputfield = By.xpath("//input[@placeholder='Password']");
    private By HelpDeskLoginPageClick = By.xpath("//a[normalize-space()='Help Center']");
    private By AttendeeLoginPage = By.xpath("//a[text()='Click Here']");
    
    
    public Page01_afton_login(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void username_1(String usern) {
        WebElement usernameField = driver.findElement(username);
        usernameField.clear(); // Clear the field before entering the value
        usernameField.sendKeys(usern);
    }

    public void password_1(String pass) {
        WebElement passwordField = driver.findElement(password);
        passwordField.clear(); // Clear the field before entering the value
        passwordField.sendKeys(pass);
    }

    public void clickSignInButton() {
        driver.findElement(signin_button).click();
    }

    public String Homepage_Title_1() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(Homepage_Title));
        return title.getText();
    }

    public void sign_out_buttoninfo_1() {
        driver.findElement(Sign_out_buttoninfo).click();
    }

    public void logout_button_1() {
        driver.findElement(logout_button).click();
    }

    public void logout_button_popup_1() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(logout_button_popup);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logout_button_popup));
        modalElement.click();
    }


    public String IdPassValidationMessage() {
        WebElement loginValidationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(validusern_and_invalidpass));
        return loginValidationMessage.getText();
    }
    
    public void username_clear() {
        WebElement usernameField = driver.findElement(username);
        usernameField.clear();
    }
    
    public void password_clear() {
        WebElement passwordField = driver.findElement(password);
        passwordField.sendKeys(Keys.CONTROL + "a");
        passwordField.sendKeys(Keys.DELETE);
    }
    
    public String PasswordRequiredValidation() {
    	
        WebElement requiredValidationMessage_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(requiredValidationMessage));
        return requiredValidationMessage_1.getText();
    	
    }
    
    public String UsernameRequiredValidation() {
    	
        WebElement requiredValidationMessage_12 = wait.until(ExpectedConditions.visibilityOfElementLocated(usernamevalidationMessage));
        return requiredValidationMessage_12.getText();
    	
    }
    
    public void Pass_spacekey() {
    	
    	WebElement passwordField = driver.findElement(password);
        
        for (int i=0; i < 6; i ++) {
        	passwordField.sendKeys(Keys.SPACE);
        	}
    }
    
    public String Password_SpaceFieldValidationMessage_1() {
    	
    	WebElement requiredValidationMessage_13 = wait.until(ExpectedConditions.visibilityOfElementLocated(SpaceFieldValidationMessage));
        return requiredValidationMessage_13.getText();
    	
    }
    
public void Username_spacekey() {
    	
    	WebElement UsernameField = driver.findElement(username);
        
        for (int i=0; i < 6; i ++) {
        	UsernameField.sendKeys(Keys.SPACE);
        	}
    }
    
public String username_SpaceFieldValidationMessage_1() {
	
	WebElement requiredValidationMessage_14 = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameSpaceFieldValidationMessage));
    return requiredValidationMessage_14.getText();
	
}

public void ShowHiddenPassword_click() {
	
	WebElement password1 = driver.findElement(ShowHiddenPassword);
	password1.click();
	
}
	
public void ShowHiddenPassword() {
	
WebElement password2 = driver.findElement(ShowHiddenPassword_inputfield);
System.out.println(password2.getAttribute("type"));

if (password2.getAttribute("type").equals("password")){
	    
		System.out.println("Password is Hidden Funtionality is working Fine");
		
	}else {
		

		System.out.println("Password is Shown Funtionality is working Fine");
	}
} 
	
	
public void HelpDeskLoginPage_click() {
	
	WebElement HelpDesk = driver.findElement(HelpDeskLoginPageClick);
	HelpDesk.click();
	
}

public void HelpDeskLoginPageSwitch() {
	
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
   
    
}
	
public String validatepage() {
	
	String URL = driver.getCurrentUrl();
	return URL;
	
	
}

public void SwitchToLoginPage() {
	
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs.get(0));
   
    
}


public void AttendeeLoginPage_click() {
	
	WebElement password1 = driver.findElement(AttendeeLoginPage);
	password1.click();
	
}


public void SwitchToAttendee() {
	
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs.get(2));
   
    
}




}
   
    
    

