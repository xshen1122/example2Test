package acr.browser.lightning.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class test03 extends ActivityInstrumentationTestCase2 {
  	private Solo solo;
  	
  	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "acr.browser.lightning.MainActivity";

    private static Class<?> launcherActivityClass;
    static{
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }
  	
  	@SuppressWarnings("unchecked")
    public test03() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Wait for activity: 'acr.browser.lightning.MainActivity'
		solo.waitForActivity("MainActivity", 2000);
        //Click on Reader Mode
		solo.clickInList(9, 0);
        //Wait for activity: 'acr.browser.lightning.ReadingActivity'
		assertTrue("ReadingActivity is not found!", solo.waitForActivity("ReadingActivity"));
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ImageButton.class, 0));
        //Click on New Incognito Tab
		solo.clickInList(2, 0);
        //Wait for activity: 'acr.browser.lightning.IncognitoActivity'
		assertTrue("IncognitoActivity is not found!", solo.waitForActivity("IncognitoActivity"));
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ImageView.class, 0));
        //Click on Bookmarks
		solo.clickInList(5, 0);
        //Press menu back key
		solo.goBack();
        //Press menu back key
		solo.goBack();
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ImageView.class, 0));
        //Click on New Tab
		solo.clickInList(1, 0);
        //Click on Empty Text View
		solo.clickOnView(solo.getView("search"));
        //Enter the text: 'sina.cn'
		solo.clearEditText((android.widget.EditText) solo.getView("search"));
		solo.enterText((android.widget.EditText) solo.getView("search"), "sina.cn");
        //Press next button
		solo.pressSoftKeyboardNextButton();
        //Enter the text: 'sina.cn/'
		solo.clearEditText((android.widget.EditText) solo.getView("search"));
		solo.enterText((android.widget.EditText) solo.getView("search"), "sina.cn/");
        //Click on 教育
		solo.clickOnWebElement(By.textContent("教育"));
        //Enter the text: 'edu.sina.cn'
		solo.clearEditText((android.widget.EditText) solo.getView("search"));
		solo.enterText((android.widget.EditText) solo.getView("search"), "edu.sina.cn");
        //Click on j_navShowBtn
		solo.clickOnWebElement(By.id("j_navShowBtn"));
        //Click on 牛班高考均分660被骂:别吹了
		solo.clickOnWebElement(By.textContent("牛班高考均分660被骂:别吹了"));
        //Enter the text: 'edu.sina.cn'
		solo.clearEditText((android.widget.EditText) solo.getView("search"));
		solo.enterText((android.widget.EditText) solo.getView("search"), "edu.sina.cn");
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ImageView.class, 0));
        //Click on Add Bookmark
		solo.clickInList(8, 0);
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ImageView.class, 0));
        //Click on Bookmarks
		solo.clickInList(7, 0);
	}
}
