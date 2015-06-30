package acr.browser.lightning.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class test01 extends ActivityInstrumentationTestCase2 {
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
    public test01() throws ClassNotFoundException {
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
        //Click on LinearLayout
		solo.clickOnView(solo.getView("arrow_button"));
        //Click on New Tab
		solo.clickOnView(solo.getView("new_tab_button"));
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
        //Click on LinearLayout
		solo.clickOnView(solo.getView("arrow_button"));
        //Click on ImageView
		solo.clickOnView(solo.getView("deleteButton", 1));
	}
}
