package PageMethods;


import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Common;
import Utilities.GenericKeywords;






/**
 * Base class for all the pages.
 *
 */
public abstract class Page {
	protected WebDriver browser;	
	protected final int defaultElementLoadWaitTime = 20;
	protected abstract boolean isValidPage();

	protected abstract void waitForPageLoad();

	/**
	 * Constructor for Page class 
	 * @param browser
	 * @param report
	 */
	protected Page(WebDriver browser) {
		this.browser=browser;		
		PageFactory.initElements(browser, this);
		waitForPageLoad();
		verifyApplicationInCorrectPage();
	}

	/**
	 * Verify Application in Correct Page. 
	 * @param Nil 
	 * @return Nil
	 */	
	private void verifyApplicationInCorrectPage() {
		if (!isValidPage()) {
			String stepName="Navigation to Page";
			String message="The application is not in the expected page , current page: " + 
					browser.getTitle() +" Page.";
			//report.reportFailEvent(stepName, message);			
		}
	}


	/**
	 * Check if the element is present in the page
	 * @param element WebElement need to check
	 * @return True if present
	 */
	protected boolean isElementPresent(WebElement element){
		try{
			return element.isDisplayed();
		}catch(NoSuchElementException ex){
			return false;
		}catch(Exception ex2){
			return false;
		}
	}


	/**
	 * Check if the element is present in the page
	 * @param xpath of WebElement need to check
	 * @return True if present
	 */
	public boolean isElementPresent(By by){
		try{
			return browser.findElement(by).isDisplayed();
		}catch(NoSuchElementException ex){
			return false;
		}catch(Exception ex2){
			return false;
		}
	}


	/***
	 * Method to click on a link(WebElement button)
	 * @param : we WebElement to be clicked
	 * @param : elem Name of the WebElement
	 ***/
	public void clickOn(WebElement we,String elem) {		
		try{
 			waitForElement(we);
			if (isElementPresent(we)){
				we.click();
				Common.testStepPassed("Clicked on WebElement-"+ elem );	
			}else{
				Common.testStepFailed(elem+" Element is not displayed");
			}				
		}
		catch (Exception ex) {
			Common.testStepFailed("Uanble to click on Element-"+ elem);
		} 
	}


	/**
	 * Method to jsclick on a link(WebElement link)
	 * @param : we WebElement to be Clicked 
	 * @param : elem Name of the webElement
	 */
	protected void jsClick(WebElement we,String elem) {		
		try{			
			((JavascriptExecutor) browser).executeScript("arguments[0].click();",we);
			Common.testStepPassed("Clicked on -"+ elem +"- Element");			
		}catch (RuntimeException ex) {
			Common.testStepFailed("Uanble to click on -"+ elem +"- Element");
		} 
	}


	/***
	 * Method to enter text in a textbox
	 * @param : Webelement 
	 * @param : Name of the Webelement
	 * @param : text to be entered
	 * @return : true if entered
	 ***/
	public boolean enterText(WebElement we,String elemName,String text){
		boolean blnFlag;
		blnFlag = false;
		try{
			waitForElement(we);
			if(isElementPresent(we)){
				we.clear();
				we.sendKeys(text);	
				Common.testStepPassed("Entered value - "+text+" in the text field- "+ elemName);
				blnFlag = true;
			}else{
				Common.testStepFailed(elemName+" element is not present");
			}
		}
		catch (Exception ex) {			
			Common.testStepFailed("Unable to enter text in the text field->"+ elemName);
		} 
		return blnFlag;
	}


	/***
	 * Method to clear text in a textbox
	 * @param : Element Name
	 * @return :
	 ***/
	public void clearText(WebElement we){
		try{
			waitForElement(we);
			if(isElementPresent(we)){
				we.clear();				
			}
		}catch(Exception ex){
			Common.testStepFailed("Unable to clear text in the text field");
		}
	}


	/***
	 * Method to switch to child window
	 * @param : pageTitle Title of the Child window
	 * @return : true if navigation is success
	 ***/
	public boolean navigateToNewWindow(String pageTitle) {
		boolean loopstatus = false;
		int timeout = GenericKeywords.pageLoadWaitTime;
		for (int i = 1; i <= timeout; i++)
		{
			loopstatus = false;
			if (i == timeout)
			{
				Common.testStepFailed("Unable to Navigate to the page -"+pageTitle);
			}

			Set<String> AllHandle = browser.getWindowHandles();
			for (String han : AllHandle)
			{
				browser.switchTo().window(han);
				String getTitle = browser.getTitle();
				if (getTitle.trim().equalsIgnoreCase(pageTitle))
				{
					loopstatus = true;
					break;
				}
			}
			if (loopstatus) {
				Common.testStepPassed("Navigated to the page -"+pageTitle+"- successfully");
				break;
			}	      
			sleep(1000);
		}				
		return loopstatus;
	}


	/***
	 * Method to switch to parent window
	 * @param : parentWindow Window handle of the parent window
	 ***/
	public void navigatoToParentWindow(String parentWindow) {
		browser.switchTo().window(parentWindow);
	}


	/***
	 * Javascript to hover over WebElement
	 * @param elem Webelement to hover over
	 */
	public void jsmoveToElement(WebElement elem){

		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		JavascriptExecutor js = (JavascriptExecutor) browser;
		js.executeScript(mouseOverScript, elem);

	}

	/***
	 * Method to close a webpage
	 * @return      : Null 
	 ***/
	public void closeCurrentPage(){
		String str=browser.getTitle();
		try {
			browser.close();
			Set<String> windows=browser.getWindowHandles();
			for(String window:windows){
				browser.switchTo().window(window);
			}
			sleep(5000);
			Common.testStepPassed("Closed the current page with title->"+str);
		} catch (Exception e) {
			Common.testStepFailed("Unable to Close the current page with title->"+str);
		}
	}


	//*****************************************************************************************************************//
	//Alert pop ups
	//*****************************************************************************************************************//
	/***
	 * Method to accept and close alert and return the text within the alert
	 * @param : 
	 * @return :
	 ***/
	public String closeAlertAndReturnText(){
		String alertMessage=null;
		try{		
			WebDriverWait wait = new WebDriverWait(browser, GenericKeywords.elementLoadWaitTime);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = browser.switchTo().alert();
			alertMessage=alert.getText();
			Common.testStepPassed("alertMessage displayed is->"+alertMessage);
			alert.accept();
			Common.testStepPassed("Alert is closed successfully");
		}catch(Exception Ex){
			Common.testStepFailed("Unable to Close Alert, Error Message is->"+Ex.getMessage());
		}
		return alertMessage;
	}


	/***
	 * Method to Cancel the alert
	 * @param : 
	 * @return :
	 ***/
	public void alertCancel(){
		try{
			WebDriverWait wait = new WebDriverWait(browser, GenericKeywords.elementLoadWaitTime);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = browser.switchTo().alert();
			alert.dismiss();
			Common.testStepPassed("Clicked on Alert Cancel successfully");
		}catch(Exception ex){
			Common.testStepFailed("Unable to Cancel Alert, Error Message is->"+ex.getMessage());
		}
	}


	/***
	 * Method to verify if alert is Present
	 * @param : 
	 * @return :
	 ***/
	public boolean isAlertWindowPresent()
	{
		try
		{
			browser.switchTo().alert();
			return true;
		}
		catch (Exception E) {}
		return false;
	}


	//*****************************************************************************************************************//
	//waits
	//*****************************************************************************************************************//

	/**
	 * Method to wait for element to load in the page
	 * @param WebElement
	 * @return true or false
	 */
	protected Boolean waitForElement(By by) {
		try {			
			new WebDriverWait(browser,GenericKeywords.elementLoadWaitTime).
			until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	/**
	 * Method to wait for element to load in the page
	 * @param WebElement
	 * @return true or false
	 */

	protected Boolean waitForElement(WebElement we) {
		try {
			new WebDriverWait(browser, GenericKeywords.elementLoadWaitTime).until(ExpectedConditions
					.visibilityOf(we));
			return true;
		} catch (RuntimeException ex) {
			return false;
		}    	
	}

	/**
	 * Method to wait for Alert present in the page
	 * @param 
	 * @return true or false
	 */
	protected Boolean waitForAlert(){
		try{
			new WebDriverWait(browser, GenericKeywords.elementLoadWaitTime).until(ExpectedConditions.alertIsPresent());
			return true;
		}catch(Exception Ex){
			return false;
		}
	}


	/***
	 * Method to get current time in minutes
	 * @param : Element Name
	 * @return :
	 * Modified By :
	 ***/
	public int getTimeInMin(String time) {
		//String time=new SimpleDateFormat("HH:mm").format(new Date());
		String[] splitTime=time.split(":");
		int hr=Integer.parseInt(splitTime[0]);
		int mn=Integer.parseInt(splitTime[1].substring(0,2));
		if(hr>12){
			hr=hr-12;
		}
		int timStamp=(hr*60)+mn;
		return timStamp;
	}


	/***
	 * Method to check for an alert for 5 seconds
	 * @param       : Element Name
	 * @return      : 
	 * Modified By  :  
	 ***/
	public boolean isAlertPresent(){
		try{
			WebDriverWait wait = new WebDriverWait(browser, GenericKeywords.elementLoadWaitTime);
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		}catch(Exception e){			
			return false;
		}
	}


	/***
	 * Method to wait for the any of 2 elements to be displayed
	 * @param       : we1,we2
	 * @return      : 
	 * @author      : Prakash Shetty
	 * Modified By  :  
	 ***/
	public boolean waitForAnyElement(WebElement we1,WebElement we2){
		try{			
			for(int i=0;i<GenericKeywords.elementLoadWaitTime;i++){
				if(isElementPresent(we1)||isElementPresent(we2)){
					break;
				}else{
					sleep(1000);
				}
			}
			return true;
		}catch(Exception Ex){
			return false;
		}
	}


	/**
	 * method to make a thread sleep for customized time in milliseconds
	 * @param milliseconds
	 */
	protected void sleep(int milliseconds){
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	/***
	 * Method to wait for the any of 2 elements to be displayed
	 * @param       : By,By
	 * @return      : 
	 * @author      : Prakash Shetty
	 * Modified By  :  
	 ***/
	public boolean waitForAnyElement(By we1,By we2){
		try{
			for(int i=0;i<GenericKeywords.elementLoadWaitTime;i++){
				if(isElementPresent(we1)||isElementPresent(we2)){
					break;
				}else{
					sleep(1000);
				}
			}
			return true;
		}catch(Exception Ex){
			return false;
		}
	}


	/***
	 * Method to hover over an element
	 * @param       : weMainMenuElement,weSubMenuElement
	 * @return      : 
	 * Modified By  :  
	 ***/
	public void clickOnSubMenu(WebElement weMain,WebElement weSub ){
		String strElem=null;
		try{
			Actions action = new Actions(browser);
			action.moveToElement(weMain).click().perform();
			Common.testStepPassed("Hover over the Main menu item successfully");
		}catch(Exception Ex){
			Common.testStepFailed("Unable to hover Over main menu Item");
		}
		try{
			waitForElement(weSub);
			strElem = weSub.getText();
			weSub.click();
			Common.testStepPassed("Clicked on the Sub menu item successfully");
		}catch(Exception ex){
			Common.testStepFailed("Unable to Click on the sub menu item");
		}		
	}


	/***
	 * Method to drag and drop from source element to destination element
	 * @param       : weSource,weDestination
	 * @return      : 
	 * Modified By  :  
	 ***/
	public void dragAndDrop(WebElement weSource, WebElement weDestination)
	{		
		try
		{	     
			new Actions(browser).dragAndDrop(weSource, weDestination).perform();
			Common.writeToLogFile("Info", "Drag and drop successful");
			Common.testReporter("Green", "Drag Source element and drop on Destination Element");
		}
		catch (Exception e)
		{
			Common.writeToLogFile("Error", "Error during drag and drop");
			Common.testStepFailed("Error : Drag Source element and drop on Destination Element");
		}
	}

	/***
	 * Method to Select value from dropdown by visible text
	 * @param       : we,strElemName,strVisibleText
	 * @return      : 
	 * Modified By  :  
	 ***/
	public void selectByVisisbleText(WebElement we,String strElemName,String strVisibleText){
		try{
			Select sel = new Select( we);
			sel.selectByVisibleText(strVisibleText);

			Common.testStepPassed("selected value -"+strVisibleText +" from dropdown->"+strElemName);
		}catch(Exception Ex){
			Common.testStepFailed("Unable to select value from the dropdown "+Ex.getMessage());
		}
	}


	/***
	 * Method to Select value from dropdown by index
	 * @param       : we,strElemName,index
	 * @return      : 
	 * Modified By  :  
	 ***/

	public void selectByIndex(WebElement we,String strElemName,int index){
		try{
			Select sel = new Select( we);
			sel.selectByIndex(index);
			Common.testStepPassed("Selected "+index +"option from dropdown->"+strElemName);
		}catch(Exception Ex){
			Common.testStepFailed("Unable to select value from the dropdown "+Ex.getMessage());
		}
	}


	/***
	 * Method to Select value from dropdown by index
	 * @param       : we,strElemName,strValue
	 * @return      : 
	 * Modified By  :  
	 ***/
	public void selectByValue(WebElement we,String strElemName,String strValue){
		try{
			Select sel = new Select( we);
			sel.selectByValue(strValue);
			Common.testStepPassed("Selected "+strValue +"option from dropdown->"+strElemName);
		}catch(Exception Ex){
			Common.testStepFailed("Unable to select value from the dropdown "+Ex.getMessage());
		}
	}


	/***
	 * Method to get the Selected value from dropdown
	 * @param       : weDropdown
	 * @return      : selectText
	 * Modified By  :  
	 ***/
	public String getTextSelectedOption(WebElement weDropDown){
		waitForElement(weDropDown);
		String selectText="";
		try {
			Select select = new Select(weDropDown);
			selectText = select.getFirstSelectedOption().getText().toString();	          

		}catch(Exception ex){
			Common.testStepFailed("Unable to get the selected value from dropdown->"+ex.getMessage());
		}
		return selectText;
	}



	/***
	 * Method to verify if the WebElement has the expected text
	 * @param       : we,expectedText
	 * @return      : 
	 * Modified By  :  
	 ***/
	public void verifyElementText(WebElement we, String expectedText)
	{
		waitForElement(we);
		if (isElementPresent(we)){
			for (int i = 1; i <= GenericKeywords.elementLoadWaitTime; i++){
				try {
					if (we.getText().trim().equalsIgnoreCase(expectedText.trim())){	            
						Common.testStepPassed("Element contains the Expected Text->" + expectedText);

					}else{
						Common.testStepFailed("Element does not contain the expected text" + expectedText);
					}	          
				}catch (Exception e){
					sleep(1000);
				}	        
				if (i == GenericKeywords.elementLoadWaitTime){
					Common.testStepFailed("Element not found within " + GenericKeywords.elementLoadWaitTime + " timeouts");
				}
			}
		}
	}


	/***
	 * Method to get the ElementLoadWaitTime
	 * @param       : 
	 * @return      : ElementLoadWaitTime
	 * Modified By  :  
	 ***/
	public int getElementLoadWaitTime(){
		try{
			String waitTime = Common.getConfigProperty("ElementLoadWaitTime");
			int i = Integer.parseInt(waitTime);			
			if(i<1){
				return defaultElementLoadWaitTime;
			}else{
				return i;					
			}
		}catch(Exception ex){
			return defaultElementLoadWaitTime;
		}

	}


	/***
	 * Method to wait till the page contains expected text
	 * @param       : txt
	 * @return      : 
	 * Modified By  :  
	 ***/
	public void waitForText(String txt)
	{
		waitForText(txt, GenericKeywords.textLoadWaitTime);
	}


	/***
	 * Method to wait till the page contains expected text
	 * @param       : txt,timeout
	 * @return      : 
	 * Modified By  :  
	 ***/
	public void waitForText(String txt, int timeout){
		for (int second = 0; second < timeout; second++){
			if (second == timeout - 1) {
				Common.testStepFailed("The text '" + txt + "' is not found within " + GenericKeywords.textLoadWaitTime + " seconds timeout");
				break;
			}
			try{
				if (browser.getPageSource().contains(txt)) {
					Common.writeToLogFile("INFO", "Text: '" + txt + "' is present");
				}
			}
			catch (Exception localException){
				try {
					Thread.sleep(1000L);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


	/***
	 * Method to close the browser with title provided
	 * @param       : windowTitle
	 * @return      : 
	 * Modified By  :  
	 ***/
	public void closeChildBrowser(String windowTitle)
	{
		try {
			for (String winHandle : browser.getWindowHandles()){
				browser.switchTo().window(winHandle);
				if (browser.getTitle().equalsIgnoreCase(windowTitle)){
					browser.close();	          
					Common.testStepPassed("Closed the browser with page title->"+windowTitle);
					break;
				}
			}
		}catch (Exception e){	      
			Common.testStepFailed("Unable to Close Browser");
		}
	}


	/***
	 * Method to switch to default content
	 * @param       : 
	 * @return      : 
	 * Modified By  : 
	 ***/
	public void UnSelectFrame()
	{
		try {
			Common.writeToLogFile("Info", "Switching to default content frame ");
			browser.switchTo().defaultContent();
		}
		catch (Exception e)
		{
			Common.testStepFailed("Error in swiching to default content frame");
		}
	}


	/***
	 * Method to select the checkbox
	 * @param       : cbElement
	 * @return      : 
	 * Modified By  : 
	 ***/
	public void selectCheckBox(WebElement cbElement)
	{
		waitForElement(cbElement);
		if (isElementPresent(cbElement)) {
			try
			{
				if (!cbElement.isSelected())
				{
					cbElement.click();
				}
				Common.testStepPassed("Checked on the checkbox");
			}
			catch (Exception e)
			{
				Common.testStepFailed("Unable to check the checkbox->"+e.getMessage());
			}
		}
	}


	/***
	 * Method to UnSelect the checkbox
	 * @param       : cbElement
	 * @return      : 
	 * Modified By  : 
	 ***/
	public void unSelectCheckBox(WebElement cbElement)
	{
		waitForElement(cbElement);
		if (isElementPresent(cbElement)) {
			try
			{
				if (cbElement.isSelected())
				{
					cbElement.click();
				}
				Common.testStepPassed("Unchecked the checkbox");
			}
			catch (Exception e)
			{
				Common.testStepFailed("Unable to check the checkbox->"+e.getMessage());
			}
		}
	}


	/***
	 * Method to verify the checkbox if checked
	 * @param       : cbElement
	 * @return      : 
	 * Modified By  : 
	 ***/
	public boolean verifyCheckBoxIsChecked(WebElement cbElement)
	{
		waitForElement(cbElement);
		if (isElementPresent(cbElement)) {
			try{
				if (cbElement.isSelected()){
					return true;
				}else{
					return false;
				}

			}catch (Exception e){
				Common.testStepFailed("Unable to verify the checkbox->"+e.getMessage());
				return false;
			}
		}else{
			Common.testStepFailed("Unable to verify the checkbox");
			return false;
		}
	}

}
