package PageMethods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Double;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Common;
import Utilities.GenericKeywords;

//import com.itextpdf.text.List;

/**
 * Represents default page of the application
 * 
 */
public class HavertysPage extends Page {
	
		
	@FindBy(xpath="//input[@name='searchTerm']")
	public WebElement txtSearchBox;
	
	@FindBy(xpath="//form[@id='searchBox']/a[2]")
	public WebElement lnkSearch;
					
	@FindBy(xpath="//div[@id='addToCart']")
	public WebElement btnAddCart;
	
	@FindBy(xpath="//*[@class='ui-dialog-content ui-widget-content']/input[1]")
	public WebElement txtZipCode;
		
	@FindBy(xpath="//span[text()='OK']")
	public WebElement popupOk;
	
	@FindBy(xpath="//*[@id='cartDropdown']/div[2]/a")
	public WebElement popupGoToCart;
	
	@FindBy(xpath="//ul[@id='totalSummary']/li[2]/descendant::span[2]")
	public WebElement spanprotectplan_ShopCart;
	
	@FindBy(xpath="//*[@id='cartButtons']/li[2]/a/div")
	public WebElement btnAddprotectplan_ShopCart;
	
	@FindBy(xpath="//*[@id='checkout-btn']")
	public WebElement btnCheckOut;
			
	@FindBy(xpath="//ul[@class='registering-bullets']/following-sibling::a")
	public WebElement lnkNewUser;
	
	@FindBy(xpath="//div[@class='yes-or-no']/div[2]")
	public WebElement popUpNoPurchase;
	
	
	@FindBy(xpath="//input[@name='firstName']")
	public WebElement txtFirstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	public WebElement txtLastName;
	
	@FindBy(xpath="//input[@name='logonPasswordVerify']")
	public WebElement txtVerifyPwd;
	
	@FindBy(xpath="//input[@name='sozip']")
	public WebElement txtEnterZip;
	
	@FindBy(xpath="//input[@name='phoneIn']")
	public WebElement txtPhone;
	
	@FindBy(xpath="//input[@name='challengeQuestion']")
	public WebElement txtSecurityQuest;
	
	@FindBy(xpath="//input[@name='challengeAnswer']")
	public WebElement txtSecurityAns;
	
	@FindBy(xpath="//form[@id='Register']/a/div")
	public WebElement btnRegSubmit;
	
	@FindBy(xpath="//div[@id='thankYouForRegistering']/a/div")
	public WebElement btnContinue;
			
	@FindBy(xpath="//*[@class='container']/ul/li[1]/a")
	public WebElement lnkSignInOut;
	
	@FindBy(xpath=".//*[contains(text(),'Welcome')]/parent::ul/child::li[3]/a")
	public WebElement lnkSignOut;
	
	@FindBy(xpath="//a[@id='wishListQuickLink']")
	public WebElement lnkWishList;
	
	@FindBy(xpath="//*[@id='quick-product-links']")
	public WebElement frmProductInfo;
	
	@FindBy(xpath="//div[@class='item']")
	public WebElement frmWishListItem;
	
	@FindBy(xpath="//ul[@id='quick-product-links']/li[3]")
	public WebElement lnkAddWishList;
	
	@FindBy(xpath="//div[@class='description-wrapper']/div[3]/div[2]/a")
	public WebElement lnkRemoveWishList;
		
	@FindBy(xpath="//p[@id='successMessageAreaText']")
	public WebElement lnkRemovePopUp;
							
	@FindBy(xpath="//ul[@class='registering-bullets']/following-sibling::a[2]")
	public WebElement lnkGuestUser;
			
	@FindBy(xpath="//a[@class='blue-btn addProtectionPlan']")
	public WebElement btnAddGoldPlan;
	
	@FindBy(xpath="//span[@class='protectedIndicator']")
	public WebElement spanProtectedIndicator;
	
	@FindBy(xpath="//form[@name='Logon']")
	public WebElement frmLogon;
	
	@FindBy(xpath="//input[@name='emailIn']")  
	public WebElement txtEmailId;
	
	@FindBy(xpath="//input[@name='logonPassword']")  
	public WebElement txtlogonPwd;
	
	@FindBy(xpath="//form[@name='Logon']/a")
	public WebElement btnLogonSubmit;
	
	@FindBy(xpath="//div[@class='protectionCoverage']/a")
	public WebElement addProt;
	
	@FindBy(xpath="//ul[@id='checkoutButtons']/li[1]/a/div")
	public WebElement editCart;
	
	@FindBy(xpath="//div[@class='itemProtected']")
	public WebElement spanProt;
	
	@FindBy(xpath="//ul[@id='totalSummary']/descendant::span[2]")
	public WebElement spanProdSubTot;
	
	@FindBy(xpath="//ul[@id='totalSummary']/descendant::span[4]")
	public WebElement shopCartGoldPlan1;
	
	@FindBy(xpath="//span[@id='protectionPriceTotal']")
	public WebElement spanGoldPlan;
	
	@FindBy(xpath="//ul[@id='cartHeaders']")
	public WebElement presShopCart;
	
	@FindBy(xpath="//div[@class='itemProtected']/span[1]")
	public WebElement lnkRemoveProtPlan;
	
	@FindBy(xpath="//span[@class='protectionLearnMore']/a")
	public WebElement lnkLearnMore;
	
	@FindBy(xpath="//li[@id='nextBtn']/div")
	public WebElement btnNext;
	
	@FindBy(xpath="//span[contains(text(),'Protect your furniture.')]")
	public WebElement protectionPlanPage;
	
	@FindBy(xpath="//span[contains(text(),'Select your delivery address and contact information')]")
	public WebElement deliveryInfoPage;
	
	@FindBy(xpath="//ul[@id='checkoutProgress']")
	public WebElement checkOutProgress;
	
	@FindBy(xpath="//a[text()='Amalfi Sofa']")
	public WebElement lnkAmalfiSofa;
	
	@FindBy(xpath="//a[text()='Wrangler Sofa']")
	public WebElement lnkWranglerSofa;
	
	@FindBy(xpath="//*[@id='cartEntries']/li/div[2]/a[2]")
	public WebElement delCartEntry;
	
	@FindBy(xpath="//*[@id='widget_minishopcart']")
	public WebElement cartCount;
	
	@FindBy(xpath="//a[@id='MiniShopCartCloseButton_1']/following-sibling::div[2]/a")
	public WebElement goCart;
	
	@FindBy(xpath="//img[@class='havertys-logo']")
	public WebElement imgHavertysHome;
	
	protected static String HOME_PAGE_TITLE = "Havertys";

	public HavertysPage(WebDriver browser) {
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
			new WebDriverWait(browser,30).
			until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='main-menu-wrapper']")));				
		}catch(Exception e){
			System.out.println(e.getMessage());
			//report.reportFailEvent("Check Illinois Life Insurance Home Page","Home Page is not displayed");
		}
	}

	/***
	 * Method to Navigate to Havertys Sign in Page
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	
	public void signIn()
	{
		try
		{
			clickOn(lnkSignInOut,"Sign In");
			sleep(3000);
			validLoginEntry();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/***
	 * Method to Sign out from Havertys Home Page
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void havertysHome()
	{
		try
		{
			jsClick(imgHavertysHome, "Home Page");
		}
		catch(Exception e)
		{
			Common.testStepFailed("Home Page Link Not found");
		}
	}
	
	/***
	 * Method to log out
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void signOut()
	{
		try
		{
			sleep(3000);
			clickOn(lnkSignOut,"Sign Out");
			sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/***
	 * Method to Enter Valid Credentials
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void validLoginEntry()
	{
		try
		{
			waitForElement(frmLogon);
			if(isElementPresent(frmLogon))
			{
				String stremailId=Common.retrieve("EmailId");
				String strpassword=Common.retrieve("Password");
				enterText(txtEmailId,"Email Id",stremailId);
				Common.testStepPassed("Entered Email Id as: "+stremailId);
				enterText(txtlogonPwd,"Password",strpassword);
				Common.testStepPassed("Entered Password as: "+strpassword);
				
				if(btnLogonSubmit.isDisplayed())
				{
					clickOn(btnLogonSubmit,"Login Submit");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/***
	 * Method to Remove item from WishList
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void removeWishList()
	{
		String product=Common.retrieve("Product");
		try
		{
			sleep(4000);
			Common.testStepInfo("Item to be removed is: "+product);

			WebElement remove=browser.findElement(By.xpath(".//a[contains(text(),'"+product+"')]/parent::div/following-sibling::div[2]/div[2]/a"));
			if(isElementPresent(frmWishListItem))
			{
				clickOn(remove,"Remove Item");//lnkRemoveWishList
				sleep(2000);
				if(isElementPresent(lnkRemovePopUp))
				{	
					Common.testStepPassed("Popup Message displayed--> \"Item has been removed from your wishlist\"");
					Common.takeScreenshot("Removed Item");
		
				}
				else
				{
					Common.testStepFailed("Item was not removed--> Popup Message disn't display!!");
				}
			}
			else
			{
				Common.testStepInfo("No items found!!");
			}
		}
		catch(Exception e)
		{
			Common.testStepInfo(product +"not found!!");	
		}
		
	}
	
	/***
	 * Method to Navigate to WishList
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void clickWishList()
	{
		try
		{
			waitForElement(lnkWishList);
			clickOn(lnkWishList,"Wish List Link");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/***
	 * Method to Verify title of the page
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public boolean verifyPageTitle(String page)
	{
		try
		{
			sleep(4000);
			if(browser.getTitle().contains(page))
			{ 
				Common.takeScreenshot(page +"Page");
				Common.testStepPassed("Successfully Navigated to "+page +"Page!!");
				return true;
			}
			else
			{
				Common.testStepFailed("Unexpected Navigation!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	/***
	 * Method to fill new user details
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void navigateToregPage()
	{
		try
		{
			waitForElement(lnkNewUser);
			clickOn(lnkNewUser,"Create an account");
			
			sleep(1000);
			
			clickOn(popUpNoPurchase,"Pop Up No Purchase");
			
			sleep(2000);
			
			if(browser.getTitle().contains("Register"))
			{
				String strFname=Common.retrieve("FirstName");
				String strLname=Common.retrieve("LastName");
				String strEmail=Common.retrieve("EmailId");
				String strPwd=Common.retrieve("Password");
				String strZipCode=Common.retrieve("ZipCode");
				String strPhone=Common.retrieve("Phone");
				String strSecQuest=Common.retrieve("SecurityQuest");
				String strSecAns=Common.retrieve("SecurityAns");
				
				enterText(txtFirstName,"First Name",strFname);
				Common.testStepPassed("Entered First Name as: "+strFname);
				enterText(txtLastName,"Last Name",strLname);
				Common.testStepPassed("Entered Last Name as: "+strLname);
				enterText(txtEmailId,"Email Id",strEmail);
				Common.testStepPassed("Entered Email as: "+strEmail);
				enterText(txtlogonPwd,"Password",strPwd);
				Common.testStepPassed("Entered Password as: "+strPwd);
				enterText(txtVerifyPwd,"Verify Password",strPwd);
				Common.testStepPassed("Entered Verify Password as: "+strPwd);
				enterText(txtEnterZip,"Zipcode",strZipCode);
				Common.testStepPassed("Entered Zipcode as: "+strZipCode);
				enterText(txtPhone,"Phone",strPhone);
				Common.testStepPassed("Entered Phone as: "+strPhone);
				enterText(txtSecurityQuest,"Security Question?","Favourite Color?");
				Common.testStepPassed("Entered Security Quest as as: "+strSecQuest);
				enterText(txtSecurityAns,"Security Answer","Blue");
				Common.testStepPassed("Entered Security Ans as: "+strSecAns);
				
				if(btnRegSubmit.isEnabled() && btnRegSubmit.isEnabled())
				{
					jsClick(btnRegSubmit,"Register Submit Button");
				}
				if(isElementPresent(btnContinue))
				{
					Common.testStepPassed("A new user has been created and Navigated to Thank you Page!!");
				}
				else
				{
					Common.testStepFailed("Registration of New User Failed");
				}
							
			}
			else
			{
				Common.testStepFailed("Registration Page Not found!!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/***
	 * Method to determine New User has been registered
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void verifyNewUserNavig()
	{
		try
		{
			clickOn(btnContinue,"Continue Button");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/***
	 * Method to Checkout as Guest User
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	
	public void GuestUser()
	{
		try
		{
			clickOn(lnkGuestUser,"Checkout as Guest User");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/***
	 * Method to verify browser navigated to ProtectionPlanPage 
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void verifyProtectionPlanPage()
	{
		try
		{
			waitForElement(checkOutProgress);
			if(isElementPresent(protectionPlanPage))
			{
				
					Common.testStepPassed("Navigated To Protection Plan Page!!");
					Common.takeScreenshot("Protection Plan Page");
					
				
			}
			else
			{
					Common.testStepFailed("Unexpected Navigation ---> Expected Navigation To Protection Plan Page");
					Common.takeScreenshot("Unexpected Navigation ---> Expected Navigation To Protection Plan Page");
					
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
	
	/***
	 * Method to verify browser navigated to DeliveryInfoPage 
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/	
	public void verifyDeliveryInfoPage()
	{
		try
		{
			waitForElement(checkOutProgress);
			if(isElementPresent(deliveryInfoPage))
			{
				
					Common.testStepPassed("Navigated To Delivery Page!!");
			}
			else
			{
				Common.testStepFailed("Unexpected Navigation!!! Expected Navigation To Delivery Page!!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/***
	 * Method to switch browser from one frame to another 
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void signInFrame()
	{
		try
		{
			WebElement web=browser.findElement(By.cssSelector("iframe#header-iframe"));
			browser.switchTo().frame(web);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	/***
	 * Method to navigate Shopping Cart using Amalfi Sofa 
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void navigToSofas()
	{
		String product;
		try
		{
			product=Common.retrieve("Product");
			waitForElement(txtSearchBox);
			
			enterText(txtSearchBox,"Search Box",product);
			Common.testStepPassed("Entered in Search Box as: Amalfi Sofa");
			clickOn(lnkSearch,"Searching Element");
			sleep(5000);
			WebElement we=browser.findElement(By.xpath("//a[text()='"+product+"']"));
			
			if(isElementPresent(we)) //lnkImgAmalfi
			{
				clickOn(we,product);
				Common.takeScreenshot(product +" Found");
				clickOn(btnAddCart,"Add To Cart Button");
				
					if(isElementPresent(txtZipCode))
					{
						String strzipCode=Common.retrieve("ZipCode");
						enterText(txtZipCode,"Zipcode",strzipCode);
						Common.testStepPassed("Entered in ZipCode as: "+strzipCode);
						sleep(2000);							
						jsClick(popupOk,"Popup Ok");
								
						
					}
				
				Common.testStepPassed("Successfully Added to Cart");
				Common.takeScreenshot("PopUp message -\"Successfully Added to Cart \" displayed");
				
				clickOn(popupGoToCart,"Go To Cart Button");
				
			}
			else
			{
				
				Common.testStepFailed(product+ " not Found");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			

	}
	
	/***
	 * Method to navigate WishList using Wrangler Sofa 
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void navigateToSofa()
	{
		String product=Common.retrieve("Product");
		try
		{
			sleep(3000);
			WebElement srch=browser.findElement(By.xpath(".//a[contains(text(),'"+product+"')]"));
			enterText(txtSearchBox,"Search Box",product);
			clickOn(lnkSearch,"Searching Element");
			sleep(3000);
			clickOn(srch,product);
			sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/***
	 * Method to add items into WishList
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void addToWishList()
	{
		try
		{
			if(isElementPresent(frmProductInfo))
			{
				sleep(2000);
				clickOn(lnkAddWishList,"Add to Wish List");
				Common.testStepPassed("Added to Wish list");
			}
			else
			{
				Common.testStepFailed("Add to WishList Link Not Found");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/***
	 * Method to navigate shopcart using  Wrangler Sofa 
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void navigToBSofas()
	{
		String product=Common.retrieve("Product");
		try
		{
			waitForElement(txtSearchBox);
			enterText(txtSearchBox,"Search Box",product);
			clickOn(lnkSearch,"Searching Element");
			sleep(2000);		
			
			WebElement we=browser.findElement(By.xpath("//a[text()='"+product+"']"));
			if(isElementPresent(we))
			{
				clickOn(we,product);
								
				Common.testStepPassed("Navigated to Product Page!!");
				Common.takeScreenshot(product +" Found!!");
				sleep(4000);
				if(isElementPresent(frmProductInfo))
				{
					clickOn(lnkAddWishList,"Add to Wish List");
					sleep(2000);
					Common.testStepPassed("Added to Wish list");
				}
				else
				{
					Common.testStepFailed("Add to WishList Link Not Found");
				}
								
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/***
	 * Method to validate shopcart without Protection Plan 
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void validateShopCart_woutLogin() 
	{
		try
		{
			String protPlanCost="";
			waitForElement(presShopCart);
			if(isElementPresent(presShopCart))
			{
				protPlanCost=spanprotectplan_ShopCart.getText();
				protPlanCost=protPlanCost.replace("$","");
				protPlanCost=protPlanCost.replace(",","");
				protPlanCost=protPlanCost.replace(".00","");
				
				double act=Double.parseDouble(protPlanCost);
				if(act==0)
				{
					Common.testStepPassed("Expected Protection Plan Amount in Shopping Cart is 0 -->" +"and Actual is -->"+act);
				}
				else
				{
					Common.testStepFailed("Expected Protection Plan Amount in Shopping Cart is 0 -->" +"and Actual is -->"+act);
				}
			}
			else
			{
				Common.testStepFailed("Product not displayed in Shopping Cart");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
			
	/***
	 * Method to navigate to Checkout Page
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void CheckOut()
	{
		try
		{
			sleep(4000);
			scroll();
			clickOn(btnCheckOut,"Checkout Button");
			sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/***
	 * Method to store Gold Plan Price values
	 * @param : 
	 * @return : double array
	 * @author : suntechUser(userId) Modified By :
	 ***/
	
	public double[] GoldPlanTable()
	{
		double a[]={0.00,500.00,59.99,
					500.01,750.00,99.99,
					750.01,1000.00,149.99,
					1000.01,1500.00,199.99,
					1500.01,2000.00,249.99,
					2000.01,3000.00,299.99,
					3000.01,5000.00,399.99,
					5000.01,7500.00,449.99};
		
		return a;
		
	}
	
	/***
	 * Method to check Production total value is within Gold Plan range
	 * @param : 
	 * @return : double
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public double checkRange(double num)
	{
		double b[]=GoldPlanTable();
		
		int i,j=0;
		
		for(i=0;i<(b.length-3);i++)
		{
			double min=b[i];
			double max=b[i+1];
			double goldPrice=b[i+2];
			if(min<num && max>num)
			{
				Common.testStepInfo(num +"is within the range of "+min +" and "+max);
				return goldPrice;
			}
		}
		
		return 0.0;
	}
	
	/***
	 * Method to add Gold Plan
	 * @param : 
	 * @return : double
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void addProtPlan1()
	{
		String product=Common.retrieve("Product");
		try
		{
				waitForElement(presShopCart);
				if(isElementPresent(presShopCart))
				{
															
					clickOn(btnAddprotectplan_ShopCart,"Add Protection Plan");
					waitForElement(protectionPlanPage);
					if(isElementPresent(protectionPlanPage))
					{
							sleep(2000);
							try
							{
								WebElement add=browser.findElement(By.xpath(".//span[contains(text(),'"+product+"')]/parent::span/parent::div/following-sibling::div/a"));
								jsClick(addProt, "Add Gold Plan");
							}
							catch(Exception e)
							{
								WebElement add=browser.findElement(By.xpath(".//span[contains(text(),'"+product+"')]/parent::span/parent::div/following-sibling::div/div"));
								Common.testStepInfo("Item is already protectected");
							}
							
						}
						sleep(2000);
					}
		
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
	}
	
	/***
	 * Method to remove Gold Plan
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	
	public void removeGoldPlan()
	{
		try
		{
			waitForElement(lnkRemoveProtPlan);
			if(isElementPresent(lnkRemoveProtPlan))
			{
				clickOn(lnkRemoveProtPlan, "Remove Protection Plan");
				if(isElementPresent(addProt))
				{
					Common.testStepInfo("Add Gold plan is visible..");
				}
				else
				{
					Common.testStepInfo("");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/***
	 * Method to validate Learn More link
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	
	public void learnMoreGoldPlan()
	{
		try
		{
			waitForElement(lnkLearnMore);
			if(isElementPresent(lnkLearnMore))
			{
				clickOn(lnkLearnMore, "Learn More");
				
				if(navigateToNewWindow("Havertys - Protection Plans"))
				{
					Common.testStepPassed("New tab opens with Gold plan Details");
				}
				else
				{
					Common.testStepFailed("Failed to open new tab with Gold Plan details");
				}			
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/***
	 * Method to validate Edit Shopping Cart button
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void showCart()
	{
		try
		{  
			sleep(2000);
			clickOn(editCart,"Edit Shopping Cart");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/***
	 * Method to validate Next Button in Protection Plan Page
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void nextPage()
	{
		try
		{
			waitForElement(btnNext);
			clickOn(btnNext,"Next button");
			sleep(2000);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/***
	 * Method to validate Gold Plan price for Protected Item
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void verifyProtectedGoldPlan()
	{
		try
		{			
			if(isElementPresent(spanProt))
			{
				Common.testStepPassed("Item is protected!!");
				String prodTotal=spanProdSubTot.getText();
				String actualGoldPlan=spanGoldPlan.getText();
				
				double dblProdTotal=strDouble(prodTotal);
				double dblActualGoldPlan=strDouble(actualGoldPlan);
				
				double dblExpectedGoldPlan=checkRange(dblProdTotal);
				
				if(dblExpectedGoldPlan==dblActualGoldPlan)	
				{
					Common.testStepPassed("Production Sub Total: "+dblProdTotal +"Actual Gold Plan Price: "+dblActualGoldPlan+"--> Expected Gold Plan Price: "+dblExpectedGoldPlan);
				}
				else
				{
					Common.testStepFailed("Production Sub Total: "+dblProdTotal +"Actual Gold Plan Price: "+dblActualGoldPlan+"--> Expected Gold Plan Price: "+dblExpectedGoldPlan);
				}
						
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/***
	 * Method to convert String to double
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public double strDouble(String str)
	{
		str=str.substring(1);
		str=str.replaceAll(",", "");
		double d=Double.parseDouble(str);
		return d;
		
	}
	
	
	/***
	 * Method to delete items from Cart Entries
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void delCartEntries()
	{
		clickOn(cartCount,"Cart");
		waitForElement(goCart);
		if(isElementPresent(goCart))
		{
			jsClick(goCart, "Go to Cart");
		}
		
		sleep(2000);
		try
		{
		if(isElementPresent(presShopCart))
		{
			sleep(3000);
			List<WebElement> links = browser.findElements(By.xpath(".//*[@id='cartEntries']/li/div[2]/a[2]"));
	
			Iterator<WebElement> iter = links.iterator();
			
				while(iter.hasNext()) {
					
						WebElement we = browser.findElement(By.xpath(".//*[@id='cartEntries']/li[1]/div[2]/a[2]"));
						we.click();
						sleep(3000);
				}
			}
		}
			catch(Exception e)
			{
				Common.testStepInfo("Items are deleted!!");
			}
		
	}
	
	/***
	 * Method to scroll particular location
	 * @param : 
	 * @return : void
	 * @author : suntechUser(userId) Modified By :
	 ***/
	public void scroll()
	{
		 Locatable hoverItem = (Locatable) browser.findElement(By.xpath("//div[text()='Checkout']"));
		  int y = hoverItem.getCoordinates().onPage().getY();
		    ((JavascriptExecutor)browser).executeScript("window.scroll(0,"+y+");");
	}
}







