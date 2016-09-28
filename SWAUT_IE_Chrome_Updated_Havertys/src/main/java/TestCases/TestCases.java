package TestCases;

import java.io.File;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageMethods.HavertysApplication;
import PageMethods.HavertysPage;
import Utilities.Common;
import Utilities.GenericKeywords;

@Listeners({ Utilities.TestListener.class })
public class TestCases extends Common {
		
	public static int count = 1;
	private static String pageTitle="";
	private HavertysApplication havertysApplication;
	private HavertysPage havertysPage;	
	
	@BeforeClass
	public void start(){	
		try{
			java.io.File curdir = new java.io.File(".");
			GenericKeywords.extent.loadConfig(new File(curdir.getCanonicalPath()+"\\config\\extent-config.xml"));
			GenericKeywords.extent.addSystemInfo("Browser", Common.getConfigProperty("Browser"));
		}catch(Exception ex){
			//do nothing
		}
	}

	@Test
	public void testStart(String strName,String testCaseDescription) {		
		GenericKeywords.testFailure = false;
		GenericKeywords.currentStep = 0;
		reportStart(strName,testCaseDescription);		
		havertysApplication = new HavertysApplication();
		havertysPage = havertysApplication.openRelevantApplication();				
	}

	@Test
	public void testEnd() {
		try {
			havertysApplication.close();			
		} catch (Exception e) {
			System.out.println("Expception : " + e.getMessage());
		}finally{
			GenericKeywords.extent.endTest(GenericKeywords.parent);
			GenericKeywords.extent.flush();
		}		
	}

			
	/***
     * @ScriptName : TC_001
     * @Testcase   : Protection Plan Without Login
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	
	@Test(alwaysRun = true)
	public void TC_001() {
		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Protection Plan Without Login");		
		
		for (String testDataSet : GenericKeywords.testCaseDataSets) {			
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);			
			testStepInfoStart(testDataSet);
			pageTitle="SIGN IN";
			havertysPage.navigToSofas();
			havertysPage.CheckOut();
			havertysPage.verifyPageTitle(pageTitle);
			havertysPage.havertysHome();
			testStepInfoEnd(testDataSet);			
			}
		testEnd();

	}
	
	/***
     * @ScriptName : TC_002
     * @Testcase   : Protection Plan as Guest User
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	@Test(alwaysRun = true)
	public void TC_002() {
		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Protection Plan as Guest User");				
		
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			pageTitle="SIGN IN";
			havertysPage.navigToSofas();
			havertysPage.CheckOut();
			havertysPage.verifyPageTitle(pageTitle);
			havertysPage.GuestUser();
			havertysPage.verifyProtectionPlanPage();
			havertysPage.havertysHome();								
			testStepInfoEnd(testDataSet);	
			}
		testEnd();

	}
	
	/***
     * @ScriptName : TC_003
     * @Testcase   : Protection Plan as Existing User
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	@Test(alwaysRun = true)
	public void TC_003() {

		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Protection Plan as Existing User");
				
		
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			pageTitle="SIGN IN";
			havertysPage.navigToSofas();
			havertysPage.validateShopCart_woutLogin();
			havertysPage.CheckOut();
			havertysPage.verifyPageTitle(pageTitle);
			havertysPage.validLoginEntry();
			havertysPage.verifyProtectionPlanPage();
			havertysPage.signOut();	
			testStepInfoEnd(testDataSet);	
			}
		testEnd();

	}
	
	/***
     * @ScriptName : TC_004
     * @Testcase   : Protection Plan as New User
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	@Test(alwaysRun = true)
	public void TC_004() {

		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Protection Plan as New User");
			
		
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			pageTitle="SIGN IN";
			havertysPage.navigToSofas();
			havertysPage.validateShopCart_woutLogin();
			havertysPage.CheckOut();
			havertysPage.verifyPageTitle(pageTitle);
			havertysPage.navigateToregPage();
			havertysPage.verifyNewUserNavig();
			havertysPage.verifyProtectionPlanPage();
			havertysPage.signOut();							
			testStepInfoEnd(testDataSet);	
			}
		testEnd();

	}
	
	/***
     * @ScriptName : TC_005
     * @Testcase   : Add Gold Plan From Existing User
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	@Test(alwaysRun = true)
	public void TC_005() {

		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Add Gold Plan to Existing User");
						
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			
			pageTitle="MyHavertys";
			havertysPage.signIn();
			if(havertysPage.verifyPageTitle(pageTitle))
			{
				//havertysPage.deleteCartEntry();
				havertysPage.delCartEntries();
				havertysPage.navigToSofas();
				havertysPage.addProtPlan1();
				havertysPage.showCart();
				havertysPage.CheckOut();
				havertysPage.verifyProtectedGoldPlan();
			}
			havertysPage.signOut();	
		testStepInfoEnd(testDataSet);
		}
	 testEnd();

	}
	
	/***
     * @ScriptName : TC_006
     * @Testcase   : Removal of Gold Plan bye Existing User
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	@Test(alwaysRun = true)
	public void TC_006() {

		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Remove Gold Plan from Existing User");
				
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			pageTitle="MyHavertys";
			havertysPage.signIn();
			if(havertysPage.verifyPageTitle(pageTitle))
			{
				havertysPage.delCartEntries();
				havertysPage.navigToSofas();
				havertysPage.addProtPlan1();
				havertysPage.removeGoldPlan();
				havertysPage.showCart();
				havertysPage.CheckOut();
				havertysPage.verifyProtectedGoldPlan();
			}
			havertysPage.signOut();	
		testStepInfoEnd(testDataSet);
		}
	 testEnd();

	}
	
	

	/***
     * @ScriptName : TC_007
     * @Testcase   : Learn More about Gold Plan
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	
	@Test(alwaysRun = true)
	public void TC_007()
	{
		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Learn More about Gold Plan");
				
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			pageTitle="MyHavertys";
			havertysPage.signIn();
			if(havertysPage.verifyPageTitle(pageTitle))
			{
				havertysPage.navigToSofas();
				havertysPage.addProtPlan1();
				havertysPage.learnMoreGoldPlan();
			}
			havertysPage.signOut();	
			havertysPage.havertysHome();
		testStepInfoEnd(testDataSet);
		}
	 testEnd();
	}
	
	/***
     * @ScriptName : TC_008
     * @Testcase   : Next--> Delivery Info Page
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	@Test(alwaysRun = true)
	public void TC_008()
	{
		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Next Button in Protection Plan Page");
				
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			havertysPage.signIn();
			pageTitle="MyHavertys";
			if(havertysPage.verifyPageTitle(pageTitle))
			{
				havertysPage.navigToSofas();
				havertysPage.addProtPlan1();
				havertysPage.nextPage();
				havertysPage.verifyDeliveryInfoPage();
			}
			havertysPage.signOut();			
		testStepInfoEnd(testDataSet);
		}
	 testEnd();
	}
	
	/***
     * @ScriptName : TC_009
     * @Testcase   : Determination of Wish List Page without Login
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	@Test(alwaysRun = true)
	public void TC_009() {

		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Determination of Wish List Page without Login");
				
		
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			pageTitle="SIGN IN";
			havertysPage.clickWishList();
			havertysPage.verifyPageTitle(pageTitle);
			havertysPage.havertysHome();
			testStepInfoEnd(testDataSet);
			}
		testEnd();

	}
	
	/***
     * @ScriptName : TC_010
     * @Testcase   : Determination of Wish List Page with Valid Login
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	@Test(alwaysRun = true)
	public void TC_010() {

		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Determination of Wish List Page with Valid Login");
				
		
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			pageTitle="MyHavertys";
			havertysPage.signIn();
			if(havertysPage.verifyPageTitle(pageTitle))
			{
				havertysPage.clickWishList();
				pageTitle="Wish list";
				havertysPage.verifyPageTitle(pageTitle);
			}
			havertysPage.signOut();	
			testStepInfoEnd(testDataSet);
			}
		testEnd();

	}
	
	/***
     * @ScriptName : TC_011
     * @Testcase   : Verifying Add to WishList without Login (Wrangler sofa)
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	@Test(alwaysRun = true)
	public void TC_011() {

		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Verifying Add to WishList without Login (Wrangler sofa)");
				
		
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			pageTitle="SIGN IN";
			havertysPage.navigToBSofas();
			havertysPage.verifyPageTitle(pageTitle);
			havertysPage.havertysHome();
			testStepInfoEnd(testDataSet);
			}
		testEnd();

	}

	/***
     * @ScriptName : TC_012
     * @Testcase   : Verifying Add to WishList with Valid Login (Wrangler sofa)
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	@Test(alwaysRun = true)
	public void TC_012() {

		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Verifying Add to WishList with Valid Login (Wrangler sofa)");
				
		
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			pageTitle="SIGN IN";
			havertysPage.navigToBSofas();
			havertysPage.verifyPageTitle(pageTitle);
								
			pageTitle="Wish list";
			havertysPage.validLoginEntry();
			havertysPage.verifyPageTitle(pageTitle);
			havertysPage.signOut();			
			testStepInfoEnd(testDataSet);
			}
		testEnd();

	}
	
	/***
     * @ScriptName : TC_013
     * @Testcase   : Remove item from Wish List
     * @author     : sunTechUser
     * @Functional Reviewer: manualTestUser
     ***/
	@Test(alwaysRun = true)
	public void TC_013() {

		String strName = new Exception().getStackTrace()[0].getMethodName();
		testStart(strName,"Remove item from Wish List");
				
		
		for (String testDataSet : GenericKeywords.testCaseDataSets) {
			GenericKeywords.testCaseDataRow = returnRowNumber(testDataSet);
			testStepInfoStart(testDataSet);
			pageTitle="MyHavertys";
			havertysPage.signIn();
			if(havertysPage.verifyPageTitle(pageTitle))
			{
				havertysPage.clickWishList();
				havertysPage.removeWishList();
			}
			havertysPage.signOut();	
			testStepInfoEnd(testDataSet);
			}
		testEnd();

	}
	
}
