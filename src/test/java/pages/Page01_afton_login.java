package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    
    public Page01_afton_login(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    
    public void username_1(String usern) {
        driver.findElement(username).sendKeys(usern);
    }

    
    public void password_1(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickSignInButton() {
        driver.findElement(signin_button).click();
    }
    
    public String Homepage_Title_1() {
    	
    
            // Explicit wait to ensure the element is visible
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
       // Correct the XPath reference within the script
       WebElement element = driver.findElement(logout_button_popup);
       js.executeScript("arguments[0].scrollIntoView(true);", element);
       WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logout_button_popup));
       modalElement.click();
   }
   
   public void valid_username_invalid_password_1(String valid_usern ,String invalid_pass) {
	   
	   WebElement username001 =   driver.findElement(username);
	   username001.sendKeys(valid_usern);
	   WebElement password001 = driver.findElement(password);
	   password001.sendKeys(invalid_pass);
	   
	   
	   
   }
   
   public String validusern_and_invalidpass_1() {
	   
	   WebElement login_validation_message = wait.until(ExpectedConditions.visibilityOfElementLocated(validusern_and_invalidpass));
	    return login_validation_message.getText();
	   
   }
   
 /*public void invalid_username_valid_password_1(String invalid_usern ,String valid_pass) {
	   
	   driver.findElement(username).sendKeys(invalid_usern);
	   driver.findElement(password).sendKeys(valid_pass);
	   
   }*/
   
   }
    
    
    


