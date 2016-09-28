package PageMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents default page of the application
 * 
 */
public class HavertysHomePage extends Page {


	@FindBy(xpath=".//*[@id='main-menu-wrapper']")
	public WebElement SignIn;
	
		
	protected static String HOME_PAGE_TITLE = "Havertys | Furniture, Custom Décor, Free Design Services";

	public  HavertysHomePage(WebDriver browser) {
		super(browser);		
	}

	@Override
	protected boolean isValidPage() {
		if (browser.getTitle().trim().contains(HOME_PAGE_TITLE)) {
			return true;
		}
		return false;
	}

	@Override
	protected void waitForPageLoad() {
		try{
			new WebDriverWait(browser,60).
			until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='main-menu-wrapper']")));				
		}catch(Exception e){
			System.out.println(e.getMessage());			
		}


	}	
	
	public HavertysPage navigateToSignIn(){
		
		sleep(1000);
		return new HavertysPage(browser);		
	}

	

}



