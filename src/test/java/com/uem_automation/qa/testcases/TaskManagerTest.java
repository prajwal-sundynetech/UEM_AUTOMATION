package com.uem_automation.qa.testcases;

import com.uem_automation.qa.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.uem_automation.qa.base.Base;
import com.uem_automation.qa.utils.Utilities;

import java.lang.reflect.Method;

public class TaskManagerTest extends Base {

    public WebDriver driver;
    LoginPage loginPage;
    DeviceManagerPage deviceManagerPage;
    TaskManagerPage taskManagerPage;
    TemplateManagerPage templateManagerPage;
    UserSettingsPage userSettingsPage;
    SystemSettingsPage systemSettingsPage;
    AdministrationSettingsPage administrationSettingsPage;
    SecuritySettingsPage securitySettingsPage;
    SoftwareDeploymentPage softwareDeploymentPage;

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
        securitySettingsPage = new SecuritySettingsPage(driver);
        softwareDeploymentPage = new SoftwareDeploymentPage(driver);

        loginPage.enterUsername(configProp.getProperty("validEmail"));
        loginPage.enterPassword(configProp.getProperty("validPass"));
        loginPage.selectView("Task Manager"); //select the direct view //Default View - Device Manager //Task Manager
        loginPage.clickOnLoginButton();
        deviceManagerPage.changeTheLeftMenuPositionToTopDirection();
//        deviceManagerPage.clickOnTaskManagementTopMenu();
//        deviceManagerPage.waitTillFooterCompanyWebsiteURLIsDisplayed(testdataProp.getProperty("companyWebsiteUrl"));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // Data Provider Method
    @DataProvider(name = "supplyTestData")
    public Object[][] supplyTestData(Method method) {
        String methodName = method.getName();
        String sheetName = getSheetNameFromMethodName(methodName);
        Object data[][] = Utilities.getTestDataFromExcel(sheetName);
        return data;
    }

    public String getSheetNameFromMethodName(String methodName) {
        String[] parts = methodName.split("_");
        String sheet = parts[parts.length - 1];
        return sheet;
    }

    // Test Cases

    @Test(priority = 1, dataProvider = "supplyTestData")//supplyTestData_template") //supplyTestData_template")
    public void TC_TM_001_Create_Template(String templateName, String osType, String skipWriteFilter,
                                          String taskScheduleType, String allowTaskPostponement, String postponementMessage, String postponementDisplayTime, String templateStartMessage, String displayTime) {

        //        deviceManagerPage.clickOnTaskManagementTopMenu();
        taskManagerPage.navigateToTemplateMangerRhsMenu();
        templateManagerPage.createTemplate(templateName, osType, skipWriteFilter, taskScheduleType, allowTaskPostponement, postponementMessage, postponementDisplayTime, templateStartMessage,
                displayTime);
    }

    // System Settings

    @Test(priority = 2, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
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

    @Test(priority = 3, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_003_apply_system_settings_networkSettings_ComputerName(

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

    @Test(priority = 4, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_004_apply_system_settings_networkSettings_EthernetSetup(

            // searchAndViewTheTemplate
            String templateName,

            // Ethernet Setup
            String ethernetSetupType, String obtainDnsAutomatically, String primaryDnsInput,
            String secondaryDnsInput) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // System Settings
        // Network Settings
        // Ethernet Setup
        systemSettingsPage.applySystemSettings_networkSettings_ethernetSetup(ethernetSetupType, obtainDnsAutomatically, primaryDnsInput, secondaryDnsInput);

    }

    @Test(priority = 5, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_005_apply_system_settings_networkSettings_WirelessProperties(

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

    @Test(priority = 6, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_006_apply_system_settings_networkSettings_WirelessSetup(

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

    @Test(priority = 7, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_007_apply_system_settings_peripheralSettings_DisplaySettings(

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

    @Test(priority = 8, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_008_apply_system_settings_peripheralSettings_KeyboardSettings(

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

    @Test(priority = 9, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_009_apply_system_settings_peripheralSettings_MouseSettings(

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

    @Test(priority = 10, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_010_apply_system_settings_powerManagement_PowerOption(

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

    @Test(priority = 11, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_011_apply_system_settings_printerSettings_AddPrinter(

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

    @Test(priority = 12, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_012_apply_system_settings_timeAndLanguage_DateAndTime(

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

    @Test(priority = 13, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_013_apply_system_settings_timeAndLanguage_RegionAndLocation(

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

    @Test(priority = 14, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_014_apply_UserSettings(String templateName
//    , String osType, String skipWriteFilter, String taskScheduleType, String allowTaskPostponement, String postponementMessage,
//    String postponementDisplayTime, String templateStartMessage, String displayTime

        ) {

//        templateManagerPage.createTemplate(templateName, osType, skipWriteFilter, taskScheduleType, allowTaskPostponement, postponementMessage, postponementDisplayTime, templateStartMessage, displayTime);

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName); //testdataProp.getProperty("templateName"));

        // User Settings
        // User Interface Settings
        userSettingsPage.applyUserInterface_ScreenSaverSettings();
        userSettingsPage.applyUserInterface_TaskbarProperties();
        userSettingsPage.applyUserInterface_UserInterfaceSettings();
        userSettingsPage.applyUserInterface_WallpaperSettings();

    }

    // Administration Settings

    @Test(priority = 15, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_015_apply_administration_settings_ApplicationCommand(

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

    @Test(priority = 16, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_016_apply_administration_settings_EnvironmentVariable(

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

    @Test(priority = 17, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_017_apply_administration_settings_performance_management_HistoryCleaner(

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

    @Test(priority = 18, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_018_apply_administration_settings_performance_management_RegistryBackupRestore(

            // searchAndViewTheTemplate
            String templateName,

            // Registry Backup Restore
            String selectTab, String registryKeyUser, String key,
            String backupPath, String backupName) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Performance Management
        // Registry Backup Restore
        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_RegistryBackupRestore(selectTab, registryKeyUser, key, backupPath, backupName);

    }

    @Test(priority = 19, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_019_apply_administration_settings_performance_management_StartupApplicationList(

            // searchAndViewTheTemplate
            String templateName,

            // Start Application List
            String applicationPath, String applicationName, String enabled) {


        //        taskManagerPage.navigateToTemplateMangerRhsMenu();
        //        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Performance Management
        // Start Application List
        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_StartApplicationList(applicationPath, applicationName, enabled);

    }

    @Test(priority = 20, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_020_apply_administration_settings_performance_management_TaskScheduler(

            // searchAndViewTheTemplate
            String templateName,

            // Task Scheduler
            String taskName, String delete, String refresh) {


//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Performance Management
        // Task Scheduler
        administrationSettingsPage.applyAdministrationSettings_PerformanceManagement_taskScheduler(taskName, delete, refresh);

    }

    @Test(priority = 21, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_021_apply_administration_settings_remote_agent_AdvancedSettings(

            // searchAndViewTheTemplate
            String templateName,

            // advance settings
            String taskRebootMonitoring, String dhcpDiscovery, String monitoringAndMaintainance, String batteryIndicator,
            String idleState, String configSync, String location, String bootLog, String usbMassStorageLogs, String screenSaverLogs,
            String enableVncAcceptance, String syncTaskScheduler, String applicationLog, String cpuUtilizationLog, String writeFilterLogs,
            String signalRMonitoring, String hardwareLogs, String enableAgentDebugLogs, String downloadAttempts, String locationRange,
            String hardwareLogsInterval, String heartBeatInterval, String signalRConnectionPath) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Remote agent
        // Advanced Settings
        administrationSettingsPage.applyAdministrationSettings_RemoteAgent_AdvancedSettings(
                taskRebootMonitoring, dhcpDiscovery, monitoringAndMaintainance, batteryIndicator, idleState, configSync, location, bootLog,
                usbMassStorageLogs, screenSaverLogs, enableVncAcceptance, syncTaskScheduler, applicationLog, cpuUtilizationLog,
                writeFilterLogs, signalRMonitoring, hardwareLogs, enableAgentDebugLogs, downloadAttempts, locationRange, hardwareLogsInterval,
                heartBeatInterval, signalRConnectionPath);

    }

    @Test(priority = 22, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_022_apply_administration_settings_remote_agent_ChangeVNCPassword(

            // searchAndViewTheTemplate
            String templateName,

            // change vnc password
            String vncPassword) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Remote agent
        // change vnc password
        administrationSettingsPage.applyAdministrationSettings_RemoteAgent_ChangeVncPassword( vncPassword);

    }

    @Test(priority = 23, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_023_apply_administration_settings_remote_agent_GeneralSettings(

            // searchAndViewTheTemplate
            String templateName,

            // general settings
            String serverIpName,String portNumber,String heartBeatInterval) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Remote agent
        // general settings
        administrationSettingsPage.applyAdministrationSettings_RemoteAgent_GeneralSettings(  serverIpName, portNumber, heartBeatInterval);

    }

    @Test(priority = 24, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_024_apply_administration_settings_service_management_Services(

            // searchAndViewTheTemplate
            String templateName,

            // Services
            String name, String operation, String startupType, String skipWriteFilter) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Service Management
        // Services
        administrationSettingsPage.applyAdministrationSettings_ServiceManagement_Services( name,  operation,  startupType,  skipWriteFilter);

    }

    @Test(priority = 25, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_025_apply_administration_settings_service_management_USBDeviceManager(

            // searchAndViewTheTemplate
            String templateName,

            // Usb device manager
            String usbDeviceControllerStatus, String audioDevices, String audioVideoDevices, String humanInterfacesDevices,
            String imageDevices, String massStorageDevices, String printers, String smartcardReader,
            String videoDevices, String wirelessControllers) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Service Management
        // Usb Device Manager
        administrationSettingsPage.applyAdministrationSettings_ServiceManagement_UsbDeviceManager(
                 usbDeviceControllerStatus,  audioDevices,  audioVideoDevices,  humanInterfacesDevices,
                 imageDevices,  massStorageDevices,  printers,  smartcardReader,
                 videoDevices,  wirelessControllers
        );
    }

    @Test(priority = 26, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_026_apply_administration_settings_service_management_UserManagement(

            // searchAndViewTheTemplate
            String templateName,

            // user management
            String selectTab, String username, String password, String fullName, String description, String memberOf,
            String userCannotChangeThePassword, String passwordNeverExpires, String disableUser) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Administration
        // Service Management
        // user management
        administrationSettingsPage.applyAdministrationSettings_ServiceManagement_UserManagement(
                 selectTab,  username,  password,  fullName,  description,  memberOf,
                 userCannotChangeThePassword,  passwordNeverExpires,  disableUser
        );
    }

    @Test(priority = 27, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_027_apply_security_file_system_WriteFilterOperations(

            // searchAndViewTheTemplate
            String templateName,

            // write filter operations
            String selectTab, String writeFilterSetting, String writeFilter, String fileAndFolderPath,
            String registryPath, String setMaxCacheSizeForNextSession, String overlaySize,
            String alertUser, String messageType, String messageImportant, String title, String message,
            String displayTime) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Security
        // File System
        // Write Filter Operations
        securitySettingsPage.applySecuritySettings_FileSystem_WriteFilterOperations( selectTab, writeFilterSetting, writeFilter, fileAndFolderPath,
                registryPath, setMaxCacheSizeForNextSession, overlaySize, alertUser, messageType, messageImportant, title, message, displayTime
        );
    }

    @Test(priority = 28, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_028_apply_security_network_Firewall(

            // searchAndViewTheTemplate
            String templateName,

            // firewall
            String selectTab, String name, String portNumber, String selectProtocol,
            String programName, String programPath) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Security
        // Network
        // Firewall
        securitySettingsPage.applySecuritySettings_Network_Firewall( selectTab,  name,  portNumber,  selectProtocol,
                 programName,  programPath);
    }

    @Test(priority = 29, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_029_apply_security_network_ProxySettings(

            // searchAndViewTheTemplate
            String templateName,

            // ProxySettings
            String automaticallyDetectSettings, String useAutomaticConfigScript, String address) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Security
        // Network
        // Proxy Settings
        securitySettingsPage.applySecuritySettings_Network_ProxySettings( automaticallyDetectSettings,  useAutomaticConfigScript,  address);
    }

    @Test(priority = 30, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_030_apply_security_network_SoftwareRestriction(

            // searchAndViewTheTemplate
            String templateName,

            // SoftwareRestriction
            String selectTab, String installationAndUninstallationRestriction, String softwareRestriction,
            String softwareApplicationName, String browserName, String restrictionType) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Security
        // Network
        // Proxy Settings
        securitySettingsPage.applySecuritySettings_Network_SoftwareRestriction( selectTab,  installationAndUninstallationRestriction,  softwareRestriction,
                 softwareApplicationName,  browserName,  restrictionType);
    }

    @Test(priority = 31, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_031_apply_security_system_DataWipe(

            // searchAndViewTheTemplate
            String templateName,

            // Data Wipe
            String fileFolder) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Security
        // System
        // Data Wipe
        securitySettingsPage.applySecuritySettings_System_DataWipe( fileFolder);
    }

    @Test(priority = 32, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_032_apply_security_system_DeployCertificate(

            // searchAndViewTheTemplate
            String templateName,

            // Deploy Certificate
            String source, String connectionName, String certificateType,
            String fileName, String storeName, String password, String file) throws InterruptedException {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Security
        // System
        // Deploy Certificate
        securitySettingsPage.applySecuritySettings_System_DeployCertificate( source,  connectionName,  certificateType,
                fileName,  storeName,  password,  file);
    }

    @Test(priority = 33, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_033_apply_security_system_IntegratedPeripheral(

            // searchAndViewTheTemplate
            String templateName,

            // Integrated Peripheral
            String enableCdDvd, String bluetoothDevice) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Security
        // System
        // Integrated Peripheral
        securitySettingsPage.applySecuritySettings_System_IntegratedPeripheral( enableCdDvd,  bluetoothDevice);
    }

    @Test(priority = 34, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_034_apply_security_system_PortSettings(

            // searchAndViewTheTemplate
            String templateName,

            // Port Settings
            String enableCdDvd, String enableFirewall, String enableParallelPort, String enableSerialPort
            , String enableUsbPort, String usbMassStorage, String usbWriteProtect) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Security
        // System
        // Port Settings
        securitySettingsPage.applySecuritySettings_System_PortSettings( enableCdDvd,  enableFirewall,  enableParallelPort,  enableSerialPort
                ,  enableUsbPort,  usbMassStorage,  usbWriteProtect);
    }

    @Test(priority = 35, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_035_apply_connectionManagement_Connections_CitrixWorkspace(

            // searchAndViewTheTemplate
            String templateName,

            // Citrix Workspace App
            String connectionName, String citrixType, String storeName,
            String configurationUrl, String descriptionCitrix) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Security
        // Connection Management
        // Connections
        // Citrix Workspace App
        securitySettingsPage.applySecuritySettings_ConnectionManagement_Connections_CitrixWorkspaceApp( connectionName,  citrixType,  storeName,
                 configurationUrl,  descriptionCitrix);
    }

    @Test(priority = 36, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_036_apply_connectionManagement_Connections_CustomExecutable(

            // searchAndViewTheTemplate
            String templateName,

            // Custom Executable
            String connectionName, String path, String createShortcutOnDesktop,
            String autostartConnection, String arguments) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Security
        // Connection Management
        // Connections
        // Custom Executable
        securitySettingsPage.applySecuritySettings_ConnectionManagement_Connections_CustomExecutable( connectionName,  path,  createShortcutOnDesktop,
                autostartConnection,  arguments);
    }

    // Software Deployment
    // Software and Patch Install/Uninstall
    @Test(priority = 40, dataProvider = "supplyTestData", dependsOnMethods = {"TC_TM_001_Create_Template"})
    public void TC_TM_040_software_deployment_SoftwarePatchInstallUninstall(

            // searchAndViewTheTemplate
            String templateName,

            // Software and patch install uninstall
            String selectNewInstallOrUninstall, String sourceType, String source,
            String fileName, String parameter, String skipWriteFilter, String globalRepository) {

//        taskManagerPage.navigateToTemplateMangerRhsMenu();
//        templateManagerPage.searchAndViewTheTemplate(templateName);

        // Software Deployment
        // Software and patch install uninstall
        softwareDeploymentPage.applySoftwareDeployment_SoftwareAndPatch_InstallUninstall(
                selectNewInstallOrUninstall,  sourceType,  source, fileName,  parameter,  skipWriteFilter, globalRepository);

    }




}
