package Config;

public class GlobalConsts {


    //UTIL_PATHS
    public static final String SCREENSHOT_PATH = System.getProperty("user.dir")+"/ScreenShots/";
    public static final String PROPERTIES_PATH = "src/main/java/Config/GlobalData.properties";
    public static final String EXTEND_REPORT_PATH = "Reports/report.html";


    //DATA_PATHS
    //BASIC
    public static final String SIMPLE_FORM_DEMO_DATA_PATH = "src/test/java/TestData/BasicTestsData/SimpleFormDemoData.xlsx";
    public static final String BOOSTRAP_ALERTS_DATA_PATH = "src/test/java/TestData/BasicTestsData/BoostrapAlertsData.xlsx";
    public static final String BOOSTRAP_MODALS_DATA_PATH = "src/test/java/TestData/BasicTestsData/BoostrapModalsData.xlsx";
    public static final String CHECKBOX_DEMO_DATA_PATH = "src/test/java/TestData/BasicTestsData/CheckboxDemoData.xlsx";
    public static final String JAVASCRIPT_ALERTS_DATA_PATH = "src/test/java/TestData/BasicTestsData/JavaScriptAlertsData.xlsx";
    public static final String RADIO_BUTTONS_DATA_PATH = "src/test/java/TestData/BasicTestsData/RadioButtonsData.xlsx";
    public static final String SELECT_DROPDOWN_LIST_DEMO_DATA_PATH = "src/test/java/TestData/BasicTestsData/SelectDropdownListDemoData.xlsx";
    public static final String WINDOWS_POPUP_DEMO_DATA_PATH = "src/test/java/TestData/BasicTestsData/WindowsPopupDemoData.xlsx";


    //EXERCISES_LEVELS
    public static final String BASIC= "basic_example";
    public static final String INTERMEDIATE = "intermediate_example";
    public static final String ADVANCED = "advanced_example";


    //EXERCISES
    public static final String SIMPLE_FORM = "Simple Form Demo";
    public static final String BOOSTRAP_ALERTS = "Bootstrap Alerts";
    public static final String BOOSTRAP_MODALS = "Bootstrap Modals";
    public static final String CHECK_BOX = "Check Box Demo";
    public static final String JAVASCRIPT_ALERTS = "Javascript Alerts";
    public static final String RADIO_BUTTON = "Radio Buttons Demo";
    public static final String SELECT_DROPDOWN_LIST = "Select Dropdown List";
    public static final String WINDOWS_POPUP = "Window Popup Modal";


    //WAITS
    public static final int PAGE_LOUD_TIME = 30;
    public static final int EXPLICITE_TIME = 8;


    //I_RETRY_ANALYZER
    public static final int I_RETRY_ANALYZER_COUNT=1;


    //BROWSER_CONFIG
    public static final String START_MAXIMIZED = "--start-maximized";
    public static final String DISABLE_INFOBARS = "--disable-infobars";
    public static final String DISABLE_NOTIFICATIONS = "--disable-notifications";
    public static final String REMOTE_ALLOW_ORIGINS = "--remote-allow-origins=*";
    public static final String HEADLESS = "-headless";
    public static final String DISABLE_EXTENSIONS = "--disable-extensions";

}
