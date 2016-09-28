package Utilities;


import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class GenericKeywords
  extends Common
{
  public static WebDriver driver;
  public static ExtentReports extent;
  public static ExtentTest parent;
  public static ExtentTest child;
  public static String identifier;
  public static String locator;
  public static String locatorDescription;
  public static String outputDirectory;
  public static String currentExcelBook;
  public static String mainWindow;
  public static String currentBrowser = "";
  public static Logger logger;
  public static int currentTestCaseNumber;
  public static int currentExcelSheet;
  public static int currentStep;
  public static int failureNo;
  public static int screenshotNo; public static int rowCount; public static int colCount; public static Common.identifierType idType; public static WebElement webElement; public static boolean testFailure = false;
  public static boolean loadFailure = false;
  public static int temp = 1;
  public static String testStatus = "";
  public static int testCaseDataRow; public static int textLoadWaitTime; public static int elementLoadWaitTime; public static int implicitlyWaitTime; public static int pageLoadWaitTime = 0;
  public static int testCaseRow;
  public static final String XSLT_FILE_CoverPage = ".\\xsltfiles\\CoverPage.xslt";
  public static final String XSLT_FILE_SummaryPage = ".\\xsltfiles\\SummaryReport.xslt";
  public static final String XSLT_FILE_PdfPage = ".\\data\\PdfReport.xslt";
  public static final ArrayList<String> testCaseNames = new ArrayList();
  public static ArrayList<String> testCaseDataSets = new ArrayList();
  public static boolean windowreadyStateStatus = true;
  public static int testSuccessCount = 0;
  public static int testFailureCount = 0;
  public static int testSkippedCount = 0;
  public static String timeStamp = "";
  public static boolean testCaseExecutionStatus = false;
  public static boolean webElementIsPresent = false;
  


  public GenericKeywords() {}
  


  public static enum platFormName
  {
    IOS, 
    ANDROID;
  }
  
  public static void openApp() {
    String deviceName = getConfigProperty("DeviceName").toString().trim();
    String platForm = getConfigProperty("PlatFormName").toString().trim();
    String platFormVersion = getConfigProperty("PlatformVersion").toString().trim();
    String appName = getConfigProperty("AppName").toString().trim();
    

    String ip = getConfigProperty("IpAddress").toString().trim();
    String portNumber = getConfigProperty("PortNumber").toString().trim();
    platFormName b = platFormName.valueOf(platForm.toUpperCase());
    

    writeToLogFile("INFO", "Opening " + appName + " Application...");
    try
    {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("newCommandTimeout", getConfigProperty("AppiumTimeOut").toString().trim());
      switch (b)
      {
      case IOS: 
        break;
      
      case ANDROID: 
        capabilities.setCapability("platformName", platForm);
        capabilities.setCapability("platformVersion", platFormVersion);
        capabilities.setCapability("deviceName", deviceName);
        //driver = new AppiumDriver(new URL("http://" + ip + ":" + portNumber + "/wd/hub"), capabilities);
      }
      
      


      elementLoadWaitTime = Integer.parseInt(getConfigProperty("ElementLoadWaitTime").toString().trim());
      textLoadWaitTime = Integer.parseInt(getConfigProperty("TextLoadWaitTime").toString().trim());
      pageLoadWaitTime = Integer.parseInt(getConfigProperty("PageLoadWaitTime").toString().trim());
      implicitlyWaitTime = Integer.parseInt(getConfigProperty("ImplicitlyWaitTime").toString().trim());
      driver.manage().timeouts().implicitlyWait(Integer.parseInt(getConfigProperty("ImplicitlyWaitTime")), TimeUnit.SECONDS);
      
      writeToLogFile("INFO", "Time out set");
      writeToLogFile("INFO", "Application: Open Successful: " + appName);
      testReporter("Green", "Open Application: ''" + appName + "''");

    }
    catch (TimeoutException e)
    {
      testStepFailed("Page fail to load within in " + getConfigProperty("pageLoadWaitTime") + " seconds");
    }
    catch (Exception e)
    {
      writeToLogFile("ERROR", "Browser: Open Failure/Navigation cancelled, please check the application window.");
      writeToLogFile("Error", e.toString());
      testReporter("Red", e.toString());
      testStepFailed("Open App : AppName");
    }
  }  



  






































































}
