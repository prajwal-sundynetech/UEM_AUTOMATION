package com.uem_automation.qa.testcases;

import com.uem_automation.qa.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.uem_automation.qa.base.Base;
import com.uem_automation.qa.utils.Utilities;

public class TaskManagerTest extends Base {

    public WebDriver driver;
    LoginPage loginPage;
    DeviceManagerPage deviceManagerPage;
    TaskManagerPage taskManagerPage;
    TemplateManagerPage templateManagerPage;
    UserSettingsPage userSettingsPage;
    SystemSettingsPage systemSettingsPage;
    AdministrationSettingsPage administrationSettingsPage;

    // Constructor
    public TaskManagerTest() {
        super();
    }

    @BeforeClass
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationURL(configProp.getProperty("browserName"));

        loginPage = new LoginPage(driver);
        deviceManagerPage = new DeviceManagerPage(driver);
        taskManagerPage = new TaskManagerPage(driver);
        templateManagerPage = new TemplateManagerPage(driver);

        systemSettingsPage = new SystemSettingsPage(driver);
        userSettingsPage = new UserSettingsPage(driver);
        administrationSettingsPage = new AdministrationSettingsPage(driver);

        loginPage.enterUsername(configProp.getProperty("validEmail"));
        loginPage.enterPassword(configProp.getProperty("validPass"));
//        loginPage.selectView("Task Manager"); //select the direct view //Default View - Device Manager //Task Manager
        loginPage.clickOnLoginButton();
        deviceManagerPage.changeTheLeftMenuPositionToTopDirection();
        deviceManagerPage.clickOnTaskManagementTopMenu();
//        deviceManagerPage.waitTillFooterCompanyWebsiteURLIsDisplayed(testdataProp.getProperty("companyWebsiteUrl"));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    // Data Provider Methods

    @DataProvider
    public Object[][] supplyTestData_template() {
        Object[][] data = Utilities.getTestDataFromExcel("Template");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_802xSecurity() {
        Object[][] data = Utilities.getTestDataFromExcel("802.1x Security");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_computerName() {
        Object[][] data = Utilities.getTestDataFromExcel("Computer Name");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_ethernetSetup() {
        Object[][] data = Utilities.getTestDataFromExcel("Ethernet Setup");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_wirelessProperties() {
        Object[][] data = Utilities.getTestDataFromExcel("Wireless Properties");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_wirelessSetup() {
        Object[][] data = Utilities.getTestDataFromExcel("Wireless Setup");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_displaySettings() {
        Object[][] data = Utilities.getTestDataFromExcel("Display Settings");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_keyboardSettings() {
        Object[][] data = Utilities.getTestDataFromExcel("Keyboard Settings");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_mouseSettings() {
        Object[][] data = Utilities.getTestDataFromExcel("Mouse Settings");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_powerOption() {
        Object[][] data = Utilities.getTestDataFromExcel("Power Option");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_addPrinter() {
        Object[][] data = Utilities.getTestDataFromExcel("Add Printer");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_dateAndTime() {
        Object[][] data = Utilities.getTestDataFromExcel("Date & Time");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_regionAndLocation() {
        Object[][] data = Utilities.getTestDataFromExcel("Region & Location");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_applicationCommand() {
        Object[][] data = Utilities.getTestDataFromExcel("Application Command");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_environmentVariable() {
        Object[][] data = Utilities.getTestDataFromExcel("Environment Variable");
        return data;
    }

    @DataProvider
    public Object[][] supplyTestData_historyCleaner() {
        Object[][] data = Utilities.getTestDataFromExcel("History Cleaner");
        return data;
    }

    // Test Cases

    @Test(priority = 1, dataProvider = "supplyTestData_template") //supplyTestData_template")
    public void TC_TM_001_Create_template(String templateName, String osType, String skipWriteFilter,
                                          String taskScheduleType, String allowTaskPostponement, String postponementMessage, String postponementDisplayTime, String templateStartMessage, String displayTime) {

        //        deviceManagerPage.clickOnTaskManagementTopMenu();
        taskManagerPage.navigateToTemplateMangerRhsMenu();
        templateManagerPage.createTemplate(templateName, osType, skipWriteFilter, taskScheduleType, allowTaskPostponement, postponementMessage, postponementDisplayTime, templateStartMessage,
                displayTime);
    }

    // System Settings

    @Test(priority = 2, dataProvider = "supplyTestData_802xSecurity", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_002_apply_system_settings_networkSettings_802xSecurity(

            // searchAndViewTheTemplate
            String templateName,

            // 802x security settings
            String networkTypeString, String ssidInput, String securityTypeString,
            String encryptionTypeString, String domainNameInput, String domainUsernameInput,
            String domainPasswordInput, String advanceSettOr802xSettingsString, String specifyAuthenticationString,
            String authenticationModeString) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Network Settings
        // 802xSecurity Settings
        systemSettingsPage.applySystemSettings_networkSettings_802xSecurity(networkTypeString, ssidInput, securityTypeString,
                encryptionTypeString, domainNameInput, domainUsernameInput,
                domainPasswordInput, advanceSettOr802xSettingsString, specifyAuthenticationString, authenticationModeString);

    }

    @Test(priority = 3, dataProvider = "supplyTestData_computerName", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_003_apply_system_settings_networkSettings_computer_name(

            // searchAndViewTheTemplate
            String templateName,

            // Computer name
            String selectTab, String prefixTestdata, String postfixTestdata,
            String type, String noOfChar, String compNameUsername,
            String compNamePassword, String radioType, String testDomainname,
            String testOrganizationlUnit, String testdomainusername, String testdomainpassword,
            String testworkgroupname, String testworkgroupusername,
            String testworkgrouppassword) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Network Settings
        // Computer Name Settings
        systemSettingsPage.applySystemSettings_networkSettings_computerName(selectTab, prefixTestdata, postfixTestdata, type, noOfChar, compNameUsername,
                compNamePassword, radioType, testDomainname, testOrganizationlUnit, testdomainusername, testdomainpassword, testworkgroupname,
                testworkgroupusername, testworkgrouppassword);

    }

    @Test(priority = 4, dataProvider = "supplyTestData_ethernetSetup", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_004_apply_system_settings_networkSettings_ethernet_setup(

            // searchAndViewTheTemplate
            String templateName,

            // Ethernet Setup
            String ethernetSetupType, String obtainDnsAutomatically, String primaryDnsInput,
            String secondaryDnsInput) throws InterruptedException {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Network Settings
        // Ethernet Setup
        systemSettingsPage.applySystemSettings_networkSettings_ethernetSetup(ethernetSetupType, obtainDnsAutomatically, primaryDnsInput, secondaryDnsInput);

    }

    @Test(priority = 5, dataProvider = "supplyTestData_wirelessProperties", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_005_apply_system_settings_networkSettings_wireless_properties(

            // searchAndViewTheTemplate
            String templateName,

            // Wireless Properties
            String networkSsid, String networkType, String encryptionType, String networkKeysInput,
            String connectIfNetworkInRange, String connectIfNetworkIsNotBrodcasting) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Network Settings
        // Wireless Properties
        systemSettingsPage.applySystemSettings_networkSettings_wirelessProperties(networkSsid, networkType, encryptionType, networkKeysInput,
                connectIfNetworkInRange, connectIfNetworkIsNotBrodcasting);

    }

    @Test(priority = 6, dataProvider = "supplyTestData_wirelessSetup", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_006_apply_system_settings_networkSettings_wireless_setup(

            // searchAndViewTheTemplate
            String templateName,

            // Wireless Setup
            String wirelessSetupType) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Network Settings
        // Wireless Setup
        systemSettingsPage.applySystemSettings_networkSettings_wirelessSetup(wirelessSetupType);

    }

    @Test(priority = 7, dataProvider = "supplyTestData_displaySettings", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_007_apply_system_settings_peripheralSettings_display_settings(

            // searchAndViewTheTemplate
            String templateName,

            // Display Settings
            String displayResolution, String displayColorDepth, String dualDisplay, String rotation) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Peripheral Settings
        // Display Settings
        systemSettingsPage.applySystemSettings_peripheralSettings_displaySettings(displayResolution, displayColorDepth, dualDisplay, rotation);

    }

    @Test(priority = 8, dataProvider = "supplyTestData_keyboardSettings", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_008_apply_system_settings_peripheralSettings_keyboard_settings(

            // searchAndViewTheTemplate
            String templateName,

            // Keyboard Settings
            String keyboardLocales, String replaceAllExistingKeyboard) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Peripheral Settings
        // Keyboard Settings
        systemSettingsPage.applySystemSettings_peripheralSettings_keyboardSettings(keyboardLocales, replaceAllExistingKeyboard);

    }

    @Test(priority = 9, dataProvider = "supplyTestData_mouseSettings", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_009_apply_system_settings_peripheralSettings_mouse_settings(

            // searchAndViewTheTemplate
            String templateName,

            // Mouse Settings
            String leftHandConfiguration) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Peripheral Settings
        // Mouse Settings
        systemSettingsPage.applySystemSettings_peripheralSettings_mouseSettings(leftHandConfiguration);

    }

    @Test(priority = 10, dataProvider = "supplyTestData_powerOption", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_010_apply_system_settings_powerManagement_power_option(

            // searchAndViewTheTemplate
            String templateName,

            // Power Option
            String powerPlan, String turnOffDisplayTime, String putCompToSleepTime) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Power Management
        // Power Option
        systemSettingsPage.applySystemSettings_powerManagement_powerOption(powerPlan, turnOffDisplayTime, putCompToSleepTime);

    }

    @Test(priority = 11, dataProvider = "supplyTestData_addPrinter", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_011_apply_system_settings_printerSettings_add_printer(

            // searchAndViewTheTemplate
            String templateName,

            // Add Printer
            String portType, String printerName, String Manufacturer, String printerDriverList,
            String port, String ipAddress, String portText, String printerUsername, String printerPassword,
            String isShared) throws InterruptedException {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Printer Settings
        // Add Printer
        systemSettingsPage.applySystemSettings_printerSettings_addPrinter(portType, printerName, Manufacturer, printerDriverList,
                port, ipAddress, portText, printerUsername, printerPassword,
                isShared);

    }

    @Test(priority = 12, dataProvider = "supplyTestData_dateAndTime", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_012_apply_system_settings_timeAndLanguage_dateAndTime(

            // searchAndViewTheTemplate
            String templateName,

            // date and time
            String selectTab, String monthInput, String yearInput, String dayInput,
            String timeInput, String timeZoneInput, String timeServerInput) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Time and language
        // Date and time
        systemSettingsPage.applySystemSettings_timeAndLanguage_dateAndTime(selectTab, monthInput, yearInput, dayInput,
                timeInput, timeZoneInput, timeServerInput);

    }

    @Test(priority = 13, dataProvider = "supplyTestData_regionAndLocation", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_013_apply_system_settings_timeAndLanguage_region_and_location(

            // searchAndViewTheTemplate
            String templateName,

            // region and location
            String selectTab, String location, String format, String dateSeparator,
            String shortDateFormat, String longDateFormat, String timeFormat) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Time and language
        // Region and location
        systemSettingsPage.applySystemSettings_timeAndLanguage_regionAndLocation(selectTab, location, format, dateSeparator,
                shortDateFormat, longDateFormat, timeFormat);

    }

//     User Settings

    @Test(priority = 14, dataProvider = "supplyTestData_template", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_014_apply_user_settings(String templateName, String osType, String skipWriteFilter,
                                              String taskScheduleType, String allowTaskPostponement, String postponementMessage,
                                              String postponementDisplayTime, String templateStartMessage, String displayTime) {

//        deviceManagerPage.clickOnTaskManagementTopMenu();
//        taskManagerPage.navigateToTemplateMangerRhsMenu();

//        templateManagerPage.createTemplate(templateName, osType, skipWriteFilter, taskScheduleType, allowTaskPostponement, postponementMessage, postponementDisplayTime, templateStartMessage, displayTime);
//        templateManagerPage.searchAndViewTheTemplate(templateName); //testdataProp.getProperty("templateName"));

        // User Settings
        // User Interface Settings
        userSettingsPage.applyUserInterface_ScreenSaverSettings();
        userSettingsPage.applyUserInterface_TaskbarProperties();
        userSettingsPage.applyUserInterface_UserInterfaceSettings();
        userSettingsPage.applyUserInterface_WallpaperSettings();

    }

    // Administration Settings

    @Test(priority = 15, dataProvider = "supplyTestData_applicationCommand", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_015_apply_administration_settings_application_command(

            // searchAndViewTheTemplate
            String templateName,

            // application command
            String selectTab, String applicationPath, String prameters,
            String alertUser, String messageType, String title,
            String message, String displayTime, String command,
            String requiredCommandOutput, String timeout, String skipWriteFilter) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Application Command
        administrationSettingsPage.applyAdministrationSettings_ApplicationCommand(selectTab, applicationPath, prameters,
                alertUser, messageType, title, message, displayTime, command, requiredCommandOutput, timeout, skipWriteFilter);

    }

    @Test(priority = 16, dataProvider = "supplyTestData_environmentVariable", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_016_apply_administration_settings_environment_variable(

            // searchAndViewTheTemplate
            String templateName,

            // environment variable
            String variableName, String value) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Environment Variable
        administrationSettingsPage.applyAdministrationSettings_EnvironementVariable(variableName, value);

    }

    @Test(priority = 17, dataProvider = "supplyTestData_historyCleaner", dependsOnMethods = {"TC_TM_001_Create_template"})
    public void TC_TM_017_apply_administration_settings_performance_management_history_cleaner(

            // searchAndViewTheTemplate
            String templateName,

            // History Cleaner
            String selectTab, String browserInstalled, String forcefullyCloseBrowserInstance, String internetBrowserCookies, String history, String temporaryInternetFiles,
            String clearTheRecentDocumentHistory, String clearTheStartMenuRunHistory, String clearTheFindFilesHistory, String clearTheMsPainRecentFileHistory, String clearTheMsWordpadRecentFileHistory,
            String clearTheCommonDialogueOpenSaveHistory, String clearTheCommonDialogueLastVisitedFolderHistory,
            String pleaseEmptyTheClipboard, String pleaseEmptyTheRecycleBin, String deleteWindowsTemporaryFiles) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Performance Management
        // History Cleaner
        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_HistoryCleaner(selectTab, browserInstalled, forcefullyCloseBrowserInstance, internetBrowserCookies, history, temporaryInternetFiles,
                clearTheRecentDocumentHistory, clearTheStartMenuRunHistory, clearTheFindFilesHistory, clearTheMsPainRecentFileHistory, clearTheMsWordpadRecentFileHistory,
                clearTheCommonDialogueOpenSaveHistory, clearTheCommonDialogueLastVisitedFolderHistory,
                pleaseEmptyTheClipboard, pleaseEmptyTheRecycleBin, deleteWindowsTemporaryFiles);

    }


    // Administration Settings

//    @Test(priority = 4, dataProvider = "supplyTestData_template")
//    public void TC_TM_014_Create_template_and_apply_administration_settings(String templateName, String osType, String skipWriteFilter,
//                                                                            String taskScheduleType, String allowTaskPostponement, String postponementMessage, String postponementDisplayTime, String templateStartMessage, String displayTime) {
//
//        deviceManagerPage.clickOnTaskManagementTopMenu();
//
//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//
////        templateManagerPage.createTemplate(templateName, osType, skipWriteFilter, taskScheduleType, allowTaskPostponement, postponementMessage, postponementDisplayTime, templateStartMessage,
////                displayTime);
//
//        templateManagerPage.searchAndViewTheTemplate(testdataProp.getProperty("templateName"));
//
//        // Administration Settings
//        // Application command
//        administrationSettingsPage.applyAdministrationSettings_ApplicationCommand();
//        administrationSettingsPage.applyAdministrationSettings_EnvironementVariable();
//        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_HistoryCleaner();
//
////        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_RegistryBackupRestore();
////        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_StartupApplicationList();
////        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_TaskScheduler();
////        administrationSettingsPage.applyAdministrationSettings_RemoteAgent_AdvancedSettings();
////        administrationSettingsPage.applyAdministrationSettings_RemoteAgent_ChangeVncPassword();
////        administrationSettingsPage.applyAdministrationSettings_RemoteAgent_GeneralSettings();
////        administrationSettingsPage.applyAdministrationSettings_ServiceManagement_Services();
////        administrationSettingsPage.applyAdministrationSettings_ServiceManagement_UsbDeviceManager();
////        administrationSettingsPage.applyAdministrationSettings_ServiceManagement_UserManagement();
//
//    }


//    @Test(priority = 2, dataProvider = "supplyTestData")
//    public void TC_TM_002_apply_system_settings() {
//
//        deviceManagerPage.clickOnTaskManagementTopMenu();
//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        // System Settings
//        // Network Settings
//        systemSettingsPage.applySystemSettings_networkSettings_802xSecurity();
//        systemSettingsPage.applySystemSettings_networkSettings_computerName();
//        systemSettingsPage.applySystemSettings_networkSettings_ethernetSetup();
//        systemSettingsPage.applySystemSettings_networkSettings_wirelessProperties();
//        systemSettingsPage.applySystemSettings_networkSettings_wirelessSetup();
//
//        // Peripheral Settings
//        systemSettingsPage.applySystemSettings_peripheralSettings_displaySettings();
//        systemSettingsPage.applySystemSettings_peripheralSettings_keyboardSettings();
//        systemSettingsPage.applySystemSettings_peripheralSettings_mouseSettings();
//
//        // Power Management
//        systemSettingsPage.applySystemSettings_powerManagement_powerOption();
//
//        // Printer Settings
//        systemSettingsPage.applySystemSettings_printerSettings_addPrinter();
//
//        // Time and Language
//        systemSettingsPage.applySystemSettings_timeAndLanguage_dateAndTime();
//        systemSettingsPage.applySystemSettings_timeAndLanguage_regionAndLocation();

//    }

//    @Test(priority = 2, dataProvider = "supplyTestData")
//    public void TC_TM_002_Create_template_and_apply_user_settings(String templateName, String osType, String skipWriteFilter,
//                                                                  String taskScheduleType, String allowTaskPostponement, String postponementMessage, String postponementDisplayTime, String templateStartMessage, String displayTime) {
//
//        deviceManagerPage.clickOnTaskManagementTopMenu();
//
//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//
//        templateManagerPage.createTemplate(templateName, osType, skipWriteFilter, taskScheduleType, allowTaskPostponement, postponementMessage, postponementDisplayTime, templateStartMessage,
//                displayTime);
//
////        templateManagerPage.searchAndViewTheTemplate(testdataProp.getProperty("templateName"));
//
//        // User Settings
//        // User Interface Settings
//        userSettingsPage.applyUserInterface_ScreenSaverSettings();
//        userSettingsPage.applyUserInterface_TaskbarProperties();
//        userSettingsPage.applyUserInterface_UserInterfaceSettings();
//        userSettingsPage.applyUserInterface_WallpaperSettings();
//
//    }
//
//    @Test(priority = 3, dataProvider = "supplyTestData")
//    public void TC_TM_003_Create_template_and_apply_administration_settings(String templateName, String osType, String skipWriteFilter,
//                                                                            String taskScheduleType, String allowTaskPostponement, String postponementMessage, String postponementDisplayTime, String templateStartMessage, String displayTime) {
//
//        deviceManagerPage.clickOnTaskManagementTopMenu();
//
//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//
////        templateManagerPage.createTemplate(templateName, osType, skipWriteFilter, taskScheduleType, allowTaskPostponement, postponementMessage, postponementDisplayTime, templateStartMessage,
////                displayTime);
//
//        templateManagerPage.searchAndViewTheTemplate(testdataProp.getProperty("templateName"));
//
//        // Administration Settings
//        // Application command
//        administrationSettingsPage.applyAdministrationSettings_ApplicationCommand();
//        administrationSettingsPage.applyAdministrationSettings_EnvironementVariable();
//        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_HistoryCleaner();
//
////        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_RegistryBackupRestore();
////        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_StartupApplicationList();
////        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_TaskScheduler();
////        administrationSettingsPage.applyAdministrationSettings_RemoteAgent_AdvancedSettings();
////        administrationSettingsPage.applyAdministrationSettings_RemoteAgent_ChangeVncPassword();
////        administrationSettingsPage.applyAdministrationSettings_RemoteAgent_GeneralSettings();
////        administrationSettingsPage.applyAdministrationSettings_ServiceManagement_Services();
////        administrationSettingsPage.applyAdministrationSettings_ServiceManagement_UsbDeviceManager();
////        administrationSettingsPage.applyAdministrationSettings_ServiceManagement_UserManagement();
//
//    }


}
