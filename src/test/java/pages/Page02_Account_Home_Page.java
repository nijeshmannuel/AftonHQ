package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page02_Account_Home_Page {

	private WebDriver driver;
    private WebDriverWait wait;

    private By LiveStreamEvents = By.xpath("//a[@class='nav-link']//span[1]");
    private By EventsSideMenu = By.xpath("//em[normalize-space()='Events']");
    private By BoxOfficeSideMenu = By.xpath("//em[normalize-space()='Box Office']");
    private By MarketingToolsSideMenu = By.xpath("//em[normalize-space()='Marketing Tools']");
    private By ReportsSideMenu = By.xpath("//em[normalize-space()='Reports']");
    private By CustomReportsSideMenu = By.xpath("//em[normalize-space()='Custom Reports']");
    private By PurchasesSideMenu = By.xpath("//em[normalize-space()='Purchases']");
    private By ContactCustomersSideMenu = By.xpath("//em[normalize-space()='Contact Customers']");
    private By ContactUsSideMenu = By.xpath("//em[normalize-space()='Contact Us']");
    
    private By CollapseExpandClick1 = By.xpath("//div[@role='presentation']");
    private By CollapseExpandValidation = By.xpath("(//div[@id='root']//div)[1]");
    
    
    //Collapse Side Menu
    private By BoxOfficeSideMenuCollapse = By.xpath("//a[@href='https://stagingqa-demo.aftontickets.com/client/boxoffice']//div[@class='sidebar__list-svg']//*[name()='svg']");
    private By MarketingToolsSideMenuCollapse = By.xpath("//a[@href='https://stagingqa-demo.aftontickets.com/client/app/reward-program']//div[@class='sidebar__list-svg']//*[name()='svg']");
    private By ReportsSideMenuCollapse = By.xpath("//a[@href='https://stagingqa-demo.aftontickets.com/client/reports']//div[@class='sidebar__list-svg']//*[name()='svg']");
    
    public Page02_Account_Home_Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void LiveStreamEvents_1() {
    	
            WebElement LiveStreamEvents_1CLick = driver.findElement(LiveStreamEvents);
            LiveStreamEvents_1CLick.click();
    	
    }
    
    public void LiveStreamEventsUrlValidation() {
    	
        WebElement LiveStreamEventsUrlValidation_1 = driver.findElement(LiveStreamEvents);
        LiveStreamEventsUrlValidation_1.click();
	
   }
    
    public void EventsSideMenu_Click() {
    	
        WebElement EventsSideMenu_Click1 = driver.findElement(EventsSideMenu);
        EventsSideMenu_Click1.click();
	
   }
    
   public void BoxOfficeSideMenu_Cick() {
    	
        WebElement BoxOfficeSideMenu_Click1 = driver.findElement(BoxOfficeSideMenu);
        BoxOfficeSideMenu_Click1.click();
	
   }
		
   public void MarketingToolsSideMenu_Cick() {
   	
       WebElement MarketingToolsSideMenu__Click1 = driver.findElement(MarketingToolsSideMenu);
       MarketingToolsSideMenu__Click1.click();
	
  }
   
   public void ReportSideMenu_Cick() {
	   	
       WebElement ReportSideMenu__Click1 = driver.findElement(ReportsSideMenu);
       ReportSideMenu__Click1.click();
	
   
	}
   
   public void CustomReportsSideMenu_Cick() {
	   	
       WebElement CustomReportsSideMenu_Cick11 = driver.findElement(CustomReportsSideMenu);
       CustomReportsSideMenu_Cick11.click();
	}
   
   public void PurchasesSideMenu_click() {
	   	
       WebElement PurchasesSideMenu_click11 = driver.findElement(PurchasesSideMenu);
       PurchasesSideMenu_click11.click();
	}
   
   public void ContactCustomersSideMenu_click() {
	   	
       WebElement ContactCustomersSideMenu_click11 = driver.findElement(ContactCustomersSideMenu);
       ContactCustomersSideMenu_click11.click();
	}
   
   
   public void ContactUsSideMenu_click() {
	   
       WebElement ContactUsSideMenu_click11 = driver.findElement(ContactUsSideMenu);
       ContactUsSideMenu_click11.click();
	}
   
   
  public void CollapseExpandClick() {
	   
       WebElement CollapseExpand_Click11 = driver.findElement(CollapseExpandClick1);
       CollapseExpand_Click11.click();
	}
   
  public void ExpandCollapseValidate_1() {
		
	  WebElement sidemenu = driver.findElement(CollapseExpandValidation);
	  //System.out.println(sidemenu.getAttribute("class"));

	 if (sidemenu.getAttribute("class").equals("global-container nav-collapsed")) {
	  	    
	  		System.out.println("SideMenu is Collapsed");
	  		
	  	}else {

	  		System.out.println("SideMenu is Expanded");
	  	}
	  } 
  
  public void BoxOfficeSideMenuCollapse_Cick() {
  	
      
      JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement element = driver.findElement(BoxOfficeSideMenuCollapse);
      js.executeScript("arguments[0].scrollIntoView(true);", element);
      WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(BoxOfficeSideMenuCollapse));
      modalElement.click();
	
 }
  
  public void MarketingToolsSideMenuCollapse_Cick() {
	   	
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement element = driver.findElement(MarketingToolsSideMenuCollapse);
      js.executeScript("arguments[0].scrollIntoView(true);", element);
      WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MarketingToolsSideMenuCollapse));
      modalElement.click();
 }
  
  public void ReportSideMenuCollapse_Cick() {
	   	
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement element = driver.findElement(ReportsSideMenuCollapse);
      js.executeScript("arguments[0].scrollIntoView(true);", element);
      WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportsSideMenuCollapse));
      modalElement.click();
  
	}
  
	  
  }	  
  



