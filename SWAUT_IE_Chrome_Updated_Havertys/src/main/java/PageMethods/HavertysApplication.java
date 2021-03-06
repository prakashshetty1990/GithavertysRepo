package PageMethods;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import Utilities.Common;
import Utilities.GenericKeywords;



public class HavertysApplication {

	private WebDriver browser;
	private String url;	
	private String env;
	private Page page;

	public HavertysApplication() {	
		String strbrowser = Common.getConfigProperty("Browser");
		browser=getDriver(strbrowser);
		this.browser = browser;
		this.url = Common.getConfigProperty("url");
		GenericKeywords.driver = browser;
		
	}

	public HavertysPage openRelevantApplication() {		
		HavertysHomePage havertysHomePage = openHavertysApplication();
		HavertysPage havertysPage = havertysHomePage.navigateToSignIn();
		return havertysPage;
	}


	public HavertysHomePage openHavertysApplication() {
		try {
			browser.get(url);
			browser.manage().window().maximize();
			//GenericKeywords.testStepPassed("Opened Application Successfully");			
		} catch (Exception e) {			
			GenericKeywords.testStepFailed("Unable to Open Application");
		}
		return new HavertysHomePage(browser);

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
	
	private void deleteAllCookies() {
		try{
			browser.manage().deleteAllCookies();
		}
		catch(SessionNotFoundException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	
	/**
	 * Get the browser object specified in the property
	 * @param browserName
	 * @return
	 */
	protected WebDriver getDriver(String browserName) {
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("firefox")) {
			
			ProfilesIni profilesIni = new ProfilesIni();

			FirefoxProfile profile = profilesIni.getProfile("default");

			profile.setEnableNativeEvents(true);

			driver = new FirefoxDriver(profile);

		}
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", 
					getRelativePath()+"/ext/BrowserSpecificDrivers/chromedriver.exe");
									
					driver=new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("iexplore") || browserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver",
					getRelativePath()+"/ext/BrowserSpecificDrivers/IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);

			capabilities.setCapability("ACCEPT_SSL_CERTS", true);
			try{
			driver=new InternetExplorerDriver(capabilities);
			}catch(Exception ex){
			System.out.println(ex.getMessage());	
			}
		
		}
		if(browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.ie.driver",
					getRelativePath()+"/ext/BrowserSpecificDrivers/IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);

			capabilities.setCapability("ACCEPT_SSL_CERTS", true);
			driver=new FirefoxDriver(capabilities);
		
		}
		if(browserName.equalsIgnoreCase("safari")){			
			driver=new SafariDriver();
		}

		return driver;
	}
	
	
	/**
	 * Get relative path of the framework
	 * @return
	 */
	public static String getRelativePath() {
		String relativePath = new File(System.getProperty("user.dir"))
				.getAbsolutePath();
		if (relativePath.endsWith("bin")) {
			relativePath = new File(System.getProperty("user.dir")).getParent();
		}
		return relativePath;
	}

	public void close() throws Exception {
		try{
			deleteAllCookies();
			browser.quit();
			if(GenericKeywords.testFailure){
				Assert.fail("Testcasefailed");
			}
		}catch(Exception Ex){
			System.out.println("Unable to Close Application");
		}		
	}

		private static final String TASKLIST = "tasklist";
		private static final String KILL = "taskkill /IM ";

		public static boolean isProcessRunging(String serviceName) throws Exception {

			Process p = Runtime.getRuntime().exec(TASKLIST);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {

				//System.out.println(line);
				if (line.contains(serviceName)) {
					return true;
				}
			}

			return false;

		}

		public static void killProcess(String serviceName) throws Exception {

			Runtime.getRuntime().exec(KILL + serviceName);

		}
}
