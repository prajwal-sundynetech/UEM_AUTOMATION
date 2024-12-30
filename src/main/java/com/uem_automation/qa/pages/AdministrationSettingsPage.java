package com.uem_automation.qa.pages;

import com.uem_automation.qa.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import java.time.Duration;

public class AdministrationSettingsPage {

    public WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.EXPLICIT_WAIT_TIME));

    // Objects
    // Application Command
    @FindBy(xpath = "//div[@class='AjaxLoaderOuter loaderDivInitial']//button[@type='button'][normalize-space()='Please wait...']")
    private WebElement ajaxLoaderOuter;

    @FindBy(xpath = "//a[@id='kt_aside_toggle']")
    private WebElement rhsMenuToogleElement;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//li[@id='lblMenu_administration_Window']")
    private WebElement windowsAdministrationSettingsRhsMenu;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='Application Command'][normalize-space()='Application Command']")
    private WebElement windowsAdministrationSettingsApplicationCommandRhsMenu;

    @FindBy(xpath = "//label[@id='WinAPPCMDlblapplication']")
    private WebElement applicationTab;

    @FindBy(xpath = "//input[@id='WinAPPCMDtxtAppsPath']")
    private WebElement applicationPathTextbox;

    @FindBy(xpath = "//input[@id='WinAPPCMDtxtParameters']")
    private WebElement parametersTextbox;

    @FindBy(xpath = "//input[@id='WinAPPCMDchbxWarnUser']")
    private WebElement alertUserCheckbox;

    @FindBy(xpath = "//select[@id='WinAPPCMDddlMsgType']")
    private WebElement messageTypeDropdown;

    @FindBy(xpath = "//input[@id='WinAPPCMDtxtTitle']")
    private WebElement titleTextbox;

    @FindBy(xpath = "//textarea[@id='WinAPPCMDtxtMsg']")
    private WebElement messageTextbox;

    @FindBy(xpath = "//select[@id='WinAPPCMDddlDisplayTime']")
    private WebElement displayTimeDropdown;

    @FindBy(xpath = "//label[@id='WinAPPCMDlblcommand']")
    private WebElement commandTab;

    @FindBy(xpath = "//input[@id='WinAPPCMDtxtCommand']")
    private WebElement commandTextbox;

    @FindBy(xpath = "//select[@id='WinAPPCMDddlTimeOut']")
    private WebElement timeoutDropdown;

    @FindBy(xpath = "//input[@id='ChkRequiredCommandOutput']")
    private WebElement requiredCommandOutputCheckbox;

    @FindBy(xpath = "//input[@id='WinAPPCMDidRebootRequired']")
    private WebElement skipWriteFilterCheckbox;

    @FindBy(xpath = "//input[@id='WinAPPCMDbtnApplyRDP']")
    private WebElement applicationCommandButtonSave;

    @FindBy(xpath = "//label[@id='WinAPPCMDlblMsg']")
    private WebElement applicationCommandTaskUpdateStatusMessage;

    // Environment variable
    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='Environment Variable'][normalize-space()='Environment Variable']")
    private WebElement windowsAdministrationSettingsEnvironmentVariableRhsMenu;

    @FindBy(xpath = "//input[@id='XPEnvironmentVari_TxtVariableName']")
    private WebElement variableNameTextbox;

    @FindBy(xpath = "//input[@id='XPEnvironmentVari_txtValue']")
    private WebElement valueTextbox;

    @FindBy(xpath = "//input[@id='XPEnvironmentVari_btnEnvVarApplye']")
    private WebElement environmentVariableButtonSave;

    @FindBy(xpath = "//label[@id='XPEnvironmentVari_lblMsg']")
    private WebElement environmentVariableTaskUpdateStatusMessage;

    // Performance Management
    // History cleaner
    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//li[@id='lblMenu_performancemanagement_Window']")
    private WebElement windowsAdministrationSettingsPerformanceManagementRhsMenu;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='History Cleaner'][normalize-space()='History Cleaner']")
    private WebElement windowsAdministrationSettingsPerformanceManagementHistoryCleanerRhsMenu;

    @FindBy(xpath = "//label[@id='XPWebBrowser_lblMenuWbBrwsr']")
    private WebElement webBrowserTab;

    @FindBy(xpath = "//select[@id='XPWebBrowser_ddlBrowserInstalled']")
    private WebElement browserInstalledDropdown;

    @FindBy(xpath = "//input[@id='XPWebBrowser_cbxCloseBrowser']")
    private WebElement forcefullyCloseBrowserInstanceCheckbox;

    @FindBy(xpath = "//input[@id='XPWebBrowser_cbxCookies']")
    private WebElement internetBrowserCookiesCheckbox;

    @FindBy(xpath = "//input[@id='XPWebBrowser_cbxWebBrowserHistory']")
    private WebElement historyCheckbox;

    @FindBy(xpath = "//input[@id='XPWebBrowser_cbxWebBrowserTemp']")
    private WebElement temporaryInternetFilesCheckbox;

    @FindBy(xpath = "//label[@id='XPWebBrowser_lblMenuWndwsClnr']")
    private WebElement windowsCleaner;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxClearDocument']")
    private WebElement clearTheRecentDocumentHistoryCheckbox;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxStartMenu']")
    private WebElement clearTheStartMenuRunHistoryCheckbox;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxClearFindfiles']")
    private WebElement clearTheFindFilesHistoryCheckbox;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxClearRecentFile']")
    private WebElement clearTheMsPainRecentFileHistoryCheckbox;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxClearRecentMSWordpad']")
    private WebElement clearTheMsWordpadRecentFileHistoryCheckbox;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxCommonDialogOpenSave']")
    private WebElement clearTheCommonDialogueOpenSaveHistoryCheckbox;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxCommonDialogLastVisited']")
    private WebElement clearTheCommonDialogueLastVisitedFolderHistoryCheckbox;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxEmptyClipboard']")
    private WebElement pleaseEmptyTheClipboardCheckbox;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxEmptyRecycleBin']")
    private WebElement pleaseEmptyTheRecycleBinCheckbox;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxDeleteWindowsTempFiles']")
    private WebElement deleteWindowsTemporaryFilesCheckbox;

    @FindBy(xpath = "//input[@id='XPWebBrowser_btnSavebrowser']")
    private WebElement historyCleanerWebBrowserButtonSave;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_btnApplyCleaner1']")
    private WebElement historyCleanerWindowsCleanerButtonSave;

    @FindBy(xpath = "//label[@id='XPWebBrowser_lblMSg_Success']")
    private WebElement webBroserhHistoryCleanerTaskUpdateStatusMessage;

    @FindBy(xpath = "//div[@id='XPRegistoryBackUpObt_dvShowResultsplaylog']")
    private WebElement obtainRegistryTaskUpdateStatusMessage;

    @FindBy(xpath = "//div[@id='XPRegistrybackup_dvShowResultBackup']")
    private WebElement registryBackupTaskUpdateStatusMessage;

    @FindBy(xpath = "//label[@id='XPWindowsCleaner_lblMsg_winCle']")
    private WebElement windowsCleanerHistoryCleanerTaskUpdateStatusMessage;

    // Registry and Restore

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='Registry Backup Restore'][normalize-space()='Registry Backup Restore']")
    private WebElement windowsAdministrationSettingsPerformanceManagementRegistryBackupRestoreRhsMenu;

    @FindBy(xpath = "//label[@id='XPRegistrybackup_lblviewregistrybackup']")
    private WebElement obtainRegistryLabel;

    @FindBy(xpath = "//select[@id='XPRegistoryBackUpObt_ddlreg_1']")
    private WebElement registryKeyUserDropdown;

    @FindBy(xpath = "//input[@id='XPRegistoryBackUpObt_regtxt_1']")
    private WebElement keyTextbox;

    @FindBy(xpath = "//label[@id='XPRegistrybackup_lbladdregistrybackup']")
    private WebElement registryBackupLabel;

    @FindBy(xpath = "//input[@id='XPRegistrybackup_txtBackupPath']")
    private WebElement backupPathTextbox;

    @FindBy(xpath = "//input[@id='XPRegistrybackup_txtBackupname']")
    private WebElement backupNameTextbox;

    @FindBy(xpath = "//input[@id='XPRegistoryBackUpObt_Btnapplobtainreg']")
    private WebElement obtainRegistryButtonSave;

    @FindBy(xpath = "//input[@id='XPRegistrybackup_btnRegBackup_Windows']")
    private WebElement registryBackupButtonSave;

    // startup application

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='Startup Application List'][normalize-space()='Startup Application List']")
    private WebElement windowsAdministrationSettingsPerformanceManagementStartApplicationListRhsMenu;

    @FindBy(xpath = "//input[@id='XPStartUpApp_txtApplicationPath']")
    private WebElement startApplicationPathTextbox;

    @FindBy(xpath = "//input[@id='XPStartUpApp_txtApplicationName']")
    private WebElement applicationNameTextbox;

    @FindBy(xpath = "//input[@id='XPStartUpApp_cbxEnabled']/following-sibling::span")
    private WebElement enabledCheckbox;

    @FindBy(xpath = "//input[@id='XPStartUpApp_btnAddAppSave']")
    private WebElement startupApplicationButtonSave;

    @FindBy(xpath = "//input[@id='XPStartUpApp_btnClear']")
    private WebElement startupApplicationButtonClear;

    @FindBy(xpath = "//label[@id='XPStartUpApp_lblMsg']")
    private WebElement startupApplicationTaskUpdateStatusMessage;

    // task scheduler

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='Task Scheduler'][normalize-space()='Task Scheduler']")
    private WebElement windowsAdministrationSettingsPerformanceManagementTaskSchedulerRhsMenu;

    @FindBy(xpath = "//input[@aria-controls='XPTaskScheduler_tblParents']")
    private WebElement taskSchedulerSearchbox;

    @FindBy(xpath = "//input[@id='XPTaskScheduler_btnApplyTaskSch']")
    private WebElement taskSchedulerButtonApply;

    @FindBy(xpath = "//div[@id='XPTaskScheduler_dvShowResults']")
    private WebElement taskSchedulerTaskUpdateStatusMessage;

    @FindBy(xpath = "//table[@id='XPTaskScheduler_tblParents']/tbody/tr")
    private List<WebElement> rows;

    @FindBy(xpath = "//input[@id='XPTaskScheduler_btnDeleteXPTaskSch']")
    private WebElement deleteButton;

    @FindBy(xpath = "//input[@id='btnOkDeviceConformation']")
    private WebElement deviceConfirmationOkButton;

    @FindBy(xpath = "//input[@id='XPTaskScheduler_btnRefresh']")
    private WebElement refreshButton;

    // Remote agent Advance Setting

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//li[@id='lblMenu_remoteagent_Window']")
    private WebElement windowsAdministrationSettingsRemoteAgentRhsMenu;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//li[@id='lblMenu_administration_Window']//label[@title='Advanced Settings'][normalize-space()='Advanced Settings']")
    private WebElement windowsAdministrationSettingsRemoteAgentAdvancedSettingsRhsMenu;

    @FindBy(xpath = "//label[@for='WinAdvSettchk_IsNewPoll']")
    private WebElement taskRebootMorningCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettchk_isDHCPEnabled']")
    private WebElement dhcpDiscoveryCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_IsMMRequired']")
    private WebElement monitoringAndMaintainanceCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_IsBatteryIndicator']")
    private WebElement batteryIndicatorCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_SendIdleStateReport']")
    private WebElement idleStateCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_IsConfigSync']")
    private WebElement configSyncCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_LocationExits']")
    private WebElement locationCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_BootLogs']")
    private WebElement bootLogCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_USBLogs']")
    private WebElement usbMassStorageLogsCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_ScreenSaverLogs']")
    private WebElement screenSaverLogsCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_VNCAcceptancesetting']")
    private WebElement enableVncAcceptanceCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_TaskSchedulerSync']")
    private WebElement syncTaskSchedulerCheckbox;

    @FindBy(xpath = "//div[@id='WinAdvSettRA_Div1']//div[@class='d-flex mr-2 ml-1']//span")
    private WebElement applicationLogCheckbox;

    @FindBy(xpath = "//div[@id='WinAdvSettRA_Div22']//div[@class='d-flex mr-2 ml-1']//span")
    private WebElement cpuUtilizationLogCheckbox;

    @FindBy(xpath = "//div[@id='WinAdvSettRA_Div24']//div[@class='d-flex mr-2 ml-1']//span")
    private WebElement writeFilterLogsCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_SRMonitoring']")
    private WebElement signalRMonitoringCheckbox;

    @FindBy(xpath = "//label[@for='WinAdvSettcbx_HardwareLogs']")
    private WebElement hardwareLogsCheckbox;

    @FindBy(xpath = "//select[@id='WinAdvSettddl_Debug']")
    private WebElement enableAgentDebugLogsDropdown;

    @FindBy(xpath = "//select[@id='WinAdvSettddlRedownloadingAttempts']")
    private WebElement downloadAttemptsDropdown;

    @FindBy(xpath = "//select[@id='WinAdvSettddlLocationinMeters']")
    private WebElement locationRangeDropdown;

    @FindBy(xpath = "//div[@class='col-lg-8 row']//div[@class='line-height-sm ml-2']//a[@class='icon-21--Asc']")
    private WebElement decreaseMinutes;

    @FindBy(xpath = "//div[@class='col-lg-8 row']//div[@class='line-height-sm ml-2']//a[@class='icon-65--Desc']")
    private WebElement increaseMinutes;

    @FindBy(xpath = "//input[@id='WinAdvSetttxt_HeartBeatInterval']")
    private WebElement heartBeatIntervalTextbox;

    @FindBy(xpath = "//input[@id='WinAdvSettSignalRConnectioPath']")
    private WebElement signalRConnectionPathTextbox;

    @FindBy(xpath = "//input[@id='WinAdvSettbtnSave']")
    private WebElement advanceSettingButtonSave;

    @FindBy(xpath = "//div[@id='WinAdvSetttrSettings']")
    private WebElement advanceSettingTaskUpdateStatusMessage;

    // Software Deployment
    // Software And Patch Install Uninstall

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//li[@id='lblMenu_software_deployment_Win']")
    private WebElement windowsSoftwareDeploymentRhsMenu;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//li[@id='lblMenu_software_patch_Win']//label")
    private WebElement windowsSoftwareDeploymentSoftwareAndPatchInstallUninstallRhsMenu;

    @FindBy(xpath = "//input[@id='XPSoftwareUpgrade_btnNewInstall']")
    private WebElement newInstallButton;

    @FindBy(xpath = "//select[@id='XPSoftwareUpgrade_ddlSourceType']")
    private WebElement sourceTypeDropdown;

    @FindBy(xpath = "//select[@id='XPSoftwareUpgrade_ddlSource']")
    private WebElement sourceDropdown;

    @FindBy(xpath = "//input[@id='XPSoftwareUpgrade_fileUpload']")
    private WebElement fileUploadIcon;

    @FindBy(xpath = "//input[@id='XPSoftwareUpgrade_btnUpload']")
    private WebElement fileUploadButton;

    @FindBy(xpath = "//div[@id='trSummaryButton']")
    private WebElement fileUploadStatus;

    @FindBy(xpath = "//select[@id='XPSoftwareUpgrade_ddlFile']")
    private WebElement fileDropdown;

    @FindBy(xpath = "//input[@id='btnVldtCnnctnsoftwarePatechXP']")
    private WebElement validateConnectionButton;

    @FindBy(xpath = "//label[@id='lblErrorMsgForAddConnection']")
    private WebElement connectionStatus;

    @FindBy(xpath = "//input[@id='XPSoftwareUpgrade_txtParameter']")
    private WebElement parameterTextbox;

    @FindBy(xpath = "//input[@id='XPSoftwareUpgrade_isglobal']")
    private WebElement globalRepositoryCheckbox;

    @FindBy(xpath = "//input[@id='XPSoftwareUpgrade_btnInstall']")
    private WebElement softwarePatchInstallUninstallButtonSave;

    @FindBy(xpath = "//div[@id='trSummaryButton']")
    private WebElement softwarePatchInstallUninstallTaskUpdateStatusMessage;

    @FindBy(xpath = "//input[@id='XPSoftwareUpgrade_InstallidRebootRequired']")
    private WebElement softwareUpgradeSkipWriteFilterCheckbox;

//    @FindBy(xpath = "xxxxxx")
//    private WebElement xxxxxx ;


    // Constructor
    public AdministrationSettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Initialize clasess


    // Actions
    public void applyAdministrationSettings_ApplicationCommand(String selectTab, String applicationPath, String prameters,
                                                               String alertUser, String messageType, String title,
                                                               String message, String displayTime, String command,
                                                               String requiredCommandOutput, String timeout, String skipWriteFilter) {

        if (rhsMenuToogleElement.getAttribute("class").contains("active")) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
            rhsMenuToogleElement.click();
        }

        if (!(windowsAdministrationSettingsRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsRhsMenu));
            windowsAdministrationSettingsRhsMenu.click();
        }

        windowsAdministrationSettingsApplicationCommandRhsMenu.click();

        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

        Select select;
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        String selectTab = "Command"; //Application //Command

        if (selectTab.equalsIgnoreCase("Application")) {

            applicationTab.click();

            applicationPathTextbox.sendKeys(applicationPath); //"C:\\Windows\\System32\\calc.exe"); // test data
            parametersTextbox.sendKeys(prameters); //"testdata parameters"); // test data

//            String alertUser = "Y"; //Y //N // test data
            if (alertUser.equalsIgnoreCase("Y")) {
//                alertUserCheckbox.click();
                js.executeScript("arguments[0].click();", alertUserCheckbox);

//                String messageType = "Message box"; //Message box //Information message box
                select = new Select(messageTypeDropdown);
                select.selectByVisibleText(messageType);

                titleTextbox.clear();
                titleTextbox.sendKeys(title); //"Message from Administrator");
                messageTextbox.clear();
                messageTextbox.sendKeys(message); //"A maintenance task is going to be performed on your desktop. Your device may Lock to complete the task, so you need to save any open work to avoid data loss and then press ok");

//                String displayTime = "2 Minute"; //1 Minute  to //10 Minute
                select = new Select(displayTimeDropdown);
                select.selectByVisibleText(displayTime);

            }

        } else if (selectTab.equalsIgnoreCase("Command")) {

            commandTab.click();

            commandTextbox.sendKeys(command); //"www.test.com"); //www.test.com //C:\System32\drivers\etc\hosts //This command allows you to execute any command available into the remote system.

//            String requiredCommandOutput = "N"; //Y //N // test data
            if (requiredCommandOutput.equalsIgnoreCase("Y")) {
//                requiredCommandOutputCheckbox.click();
                js.executeScript("arguments[0].click();", requiredCommandOutputCheckbox);
            } else {

//                String timeout = "5 Minutes"; //Never //5 Seconds //30 Seconds //1 Minute to //5 Minutes
                select = new Select(timeoutDropdown);
                select.selectByVisibleText(timeout);
            }


        }

//        String skipWriteFilter = "Y"; //Y //N //test data
        if (skipWriteFilter.equalsIgnoreCase("Y")) {
//          skipWriteFilterCheckbox.click();
            js.executeScript("arguments[0].click();", skipWriteFilterCheckbox);
        }

        applicationCommandButtonSave.click();
        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

        if (!((applicationCommandTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
            Assert.fail(applicationCommandTaskUpdateStatusMessage.getText());
        }

    }


    public void applyAdministrationSettings_EnvironementVariable(String variableName, String value) {

        if (rhsMenuToogleElement.getAttribute("class").contains("active")) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
            rhsMenuToogleElement.click();
        }

        if (!(windowsAdministrationSettingsRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsRhsMenu));
            windowsAdministrationSettingsRhsMenu.click();
        }

        windowsAdministrationSettingsEnvironmentVariableRhsMenu.click();

        variableNameTextbox.sendKeys(variableName); // test data
        valueTextbox.sendKeys(value); // test data

        environmentVariableButtonSave.click();
        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

        if (!((environmentVariableTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
            Assert.fail(environmentVariableTaskUpdateStatusMessage.getText());
        }
    }

    public void applyAdministrationSettings_PerformanceManagement_HistoryCleaner(String selectTab, String browserInstalled, String internetBrowserCookies, String forcefullyCloseBrowserInstance, String history, String temporaryInternetFiles,
                                                                                 String clearTheRecentDocumentHistory, String clearTheStartMenuRunHistory, String clearTheFindFilesHistory, String clearTheMsPainRecentFileHistory, String clearTheMsWordpadRecentFileHistory,
                                                                                 String clearTheCommonDialogueOpenSaveHistory, String clearTheCommonDialogueLastVisitedFolderHistory,
                                                                                 String pleaseEmptyTheClipboard, String pleaseEmptyTheRecycleBin, String deleteWindowsTemporaryFiles) {


        if (rhsMenuToogleElement.getAttribute("class").contains("active")) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
            rhsMenuToogleElement.click();
        }

        if (!(windowsAdministrationSettingsRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsRhsMenu));
            windowsAdministrationSettingsRhsMenu.click();
        }

        if (!(windowsAdministrationSettingsPerformanceManagementRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsPerformanceManagementRhsMenu));
            windowsAdministrationSettingsPerformanceManagementRhsMenu.click();
        }

        windowsAdministrationSettingsPerformanceManagementHistoryCleanerRhsMenu.click();

        Select select;
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        String selectTab = "Web Browser"; //Web Browser //Windows Cleaner
        if (selectTab.equalsIgnoreCase("Web Browser")) {

            webBrowserTab.click();

//            String browserInstalled = "Google Chrome"; //Internet Explorer //Google Chrome
            select = new Select(browserInstalledDropdown);
            select.selectByVisibleText(browserInstalled);

//            String forcefullyCloseBrowserInstance = "Y"; //Y //N //testdata
//            String internetBrowserCookies = "Y"; //Y //N //testdata
//            String history = "Y"; //Y //N //testdata
//            String temporaryInternetFiles = "Y"; //Y //N //testdata

            // only applicable for google chrome - forcefullyCloseBrowserInstance
            if (forcefullyCloseBrowserInstance.equalsIgnoreCase("Y")) {
//                internetBrowserCookiesCheckbox.click();
                js.executeScript("arguments[0].click();", forcefullyCloseBrowserInstanceCheckbox);
            }

            if (internetBrowserCookies.equalsIgnoreCase("Y")) {
//                internetBrowserCookiesCheckbox.click();
                js.executeScript("arguments[0].click();", internetBrowserCookiesCheckbox);
            }

            if (history.equalsIgnoreCase("Y")) {
//                historyCheckbox.click();
                js.executeScript("arguments[0].click();", historyCheckbox);
            }

            if (temporaryInternetFiles.equalsIgnoreCase("Y")) {
//                temporaryInternetFilesCheckbox.click();
                js.executeScript("arguments[0].click();", temporaryInternetFilesCheckbox);
            }

            historyCleanerWebBrowserButtonSave.click();
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

            if (!((webBroserhHistoryCleanerTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
                Assert.fail(webBroserhHistoryCleanerTaskUpdateStatusMessage.getText());
            }

        } else if (selectTab.equalsIgnoreCase("Windows Cleaner")) {

            windowsCleaner.click();
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

//            // TRACES IN THE WINDOWS REGISTRY
//            String clearTheRecentDocumentHistory = "Y"; //Y //N // test data
//            String clearTheStartMenuRunHistory = "Y"; //Y //N // test data
//            String clearTheFindFilesHistory = "Y"; //Y //N // test data
//            String clearTheMsPainRecentFileHistory = "Y"; //Y //N // test data
//            String clearTheMsWordpadRecentFileHistory = "Y"; //Y //N // test data
//            String clearTheCommonDialogueOpenSaveHistory = "Y"; //Y //N // test data
//            String clearTheCommonDialogueLastVisitedFolderHistory = "Y"; //Y //N // test data
//
//            // TRACES ON LOCAL HARD DISK DRIVE
//            String pleaseEmptyTheClipboard = "Y"; //Y //N // test data
//            String pleaseEmptyTheRecycleBin = "Y"; //Y //N // test data
//            String deleteWindowsTemporaryFiles = "Y"; //Y //N // test data

            if (clearTheRecentDocumentHistory.equalsIgnoreCase("Y")) {
//                clearTheRecentDocumentHistoryCheckbox.click();
                js.executeScript("arguments[0].click();", clearTheRecentDocumentHistoryCheckbox);
            }

            if (clearTheStartMenuRunHistory.equalsIgnoreCase("Y")) {
//                clearTheStartMenuRunHistoryCheckbox.click();
                js.executeScript("arguments[0].click();", clearTheStartMenuRunHistoryCheckbox);
            }

            if (clearTheFindFilesHistory.equalsIgnoreCase("Y")) {
//                clearTheFindFilesHistoryCheckbox.click();
                js.executeScript("arguments[0].click();", clearTheFindFilesHistoryCheckbox);
            }

            if (clearTheMsPainRecentFileHistory.equalsIgnoreCase("Y")) {
//                clearTheMsPainRecentFileHistoryCheckbox.click();
                js.executeScript("arguments[0].click();", clearTheMsPainRecentFileHistoryCheckbox);
            }

            if (clearTheMsWordpadRecentFileHistory.equalsIgnoreCase("Y")) {
//                clearTheMsWordpadRecentFileHistoryCheckbox.click();
                js.executeScript("arguments[0].click();", clearTheMsWordpadRecentFileHistoryCheckbox);
            }

            if (clearTheCommonDialogueOpenSaveHistory.equalsIgnoreCase("Y")) {
//                clearTheMsWordpadRecentFileHistoryCheckbox.click();
                js.executeScript("arguments[0].click();", clearTheCommonDialogueOpenSaveHistoryCheckbox);
            }

            if (clearTheCommonDialogueLastVisitedFolderHistory.equalsIgnoreCase("Y")) {
//                clearTheMsWordpadRecentFileHistoryCheckbox.click();
                js.executeScript("arguments[0].click();", clearTheCommonDialogueLastVisitedFolderHistoryCheckbox);
            }

            if (pleaseEmptyTheClipboard.equalsIgnoreCase("Y")) {
//                pleaseEmptyTheClipboardCheckbox.click();
                js.executeScript("arguments[0].click();", pleaseEmptyTheClipboardCheckbox);
            }

            if (pleaseEmptyTheRecycleBin.equalsIgnoreCase("Y")) {
//                pleaseEmptyTheRecycleBinCheckbox.click();
                js.executeScript("arguments[0].click();", pleaseEmptyTheRecycleBinCheckbox);
            }

            if (deleteWindowsTemporaryFiles.equalsIgnoreCase("Y")) {
//                deleteWindowsTemporaryFilesCheckbox.click();
                js.executeScript("arguments[0].click();", deleteWindowsTemporaryFilesCheckbox);
            }

            historyCleanerWindowsCleanerButtonSave.click();
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

            if (!((windowsCleanerHistoryCleanerTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
                Assert.fail(webBroserhHistoryCleanerTaskUpdateStatusMessage.getText());
            }

        }

    }

    public void applyAdministrationSettings_PerformanceManagement_RegistryBackupRestore(String selectTab, String registryKeyUser, String key,
                                                                                        String backupPath, String backupName) {

        if (rhsMenuToogleElement.getAttribute("class").contains("active")) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
            rhsMenuToogleElement.click();
        }

        if (!(windowsAdministrationSettingsRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsRhsMenu));
            windowsAdministrationSettingsRhsMenu.click();
        }

        if (!(windowsAdministrationSettingsPerformanceManagementRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsPerformanceManagementRhsMenu));
            windowsAdministrationSettingsPerformanceManagementRhsMenu.click();
        }

        windowsAdministrationSettingsPerformanceManagementRegistryBackupRestoreRhsMenu.click();

        Select select;
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        String selectTab = "Obtain Registry"; // Obtain Registry //Registry Backup //HKEY_CURRENT_CONFIG
        if (selectTab.equalsIgnoreCase("Obtain Registry")) {
            obtainRegistryLabel.click();

//            String registryKeyUser = "HKEY_USERS"; //HKEY_CLASSES_ROOT //
            select = new Select(registryKeyUserDropdown);
            select.selectByVisibleText(registryKeyUser);

//            String key = "xxxxx";
            keyTextbox.sendKeys(key);

            obtainRegistryButtonSave.click();

            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            if (!((obtainRegistryTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
                Assert.fail(obtainRegistryTaskUpdateStatusMessage.getText());
            }
        } else if (selectTab.equalsIgnoreCase("Registry Backup")) {
            registryBackupLabel.click();

            backupPathTextbox.sendKeys(backupPath);
            backupNameTextbox.sendKeys(backupName);

            registryBackupButtonSave.click();

            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            if (!((registryBackupTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
                Assert.fail(registryBackupTaskUpdateStatusMessage.getText());
            }
        }
    }

    public void applyAdministrationSettings_PerformanceManagement_StartApplicationList(String applicationPath, String applicationName, String enabled) {

        if (rhsMenuToogleElement.getAttribute("class").contains("active")) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
            rhsMenuToogleElement.click();
        }

        if (!(windowsAdministrationSettingsRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsRhsMenu));
            windowsAdministrationSettingsRhsMenu.click();
        }

        if (!(windowsAdministrationSettingsPerformanceManagementRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsPerformanceManagementRhsMenu));
            windowsAdministrationSettingsPerformanceManagementRhsMenu.click();
        }

        windowsAdministrationSettingsPerformanceManagementStartApplicationListRhsMenu.click();

        startupApplicationButtonClear.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        startApplicationPathTextbox.sendKeys(applicationPath); // "C:\Example\file.exe";
        applicationNameTextbox.sendKeys(applicationName);

        if (enabled.equalsIgnoreCase("Y")) {
            js.executeScript("arguments[0].click();", enabledCheckbox);
        }

        startupApplicationButtonSave.click();

        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
        if (!((startupApplicationTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
            Assert.fail(registryBackupTaskUpdateStatusMessage.getText());
        }

    }

    public void applyAdministrationSettings_PerformanceManagement_taskScheduler(String taskName, String delete, String refresh) {

        if (rhsMenuToogleElement.getAttribute("class").contains("active")) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
            rhsMenuToogleElement.click();
        }

        if (!(windowsAdministrationSettingsRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsRhsMenu));
            windowsAdministrationSettingsRhsMenu.click();
        }

        if (!(windowsAdministrationSettingsPerformanceManagementRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsPerformanceManagementRhsMenu));
            windowsAdministrationSettingsPerformanceManagementRhsMenu.click();
        }

        windowsAdministrationSettingsPerformanceManagementTaskSchedulerRhsMenu.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

//        String taskName = "MicrosoftEdgeUpdateTaskMachineCore";
        taskSchedulerSearchbox.sendKeys(taskName);
        try {
//            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='XPTaskScheduler_tblParents']/tbody/tr"));

            for (WebElement row : rows) {
                // locate the status cell
                WebElement statusCell = row.findElement(By.xpath("./td[6]"));

                String status = statusCell.getText().trim();

                if (status.equalsIgnoreCase("READY")) {
                    WebElement checkbox = row.findElement(By.xpath("./td[1]/input[@type='checkbox']"));
                    if (!(checkbox.isSelected())) {
                        js.executeScript("arguments[0].click();", checkbox);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // click on delete or refresh

        if (delete.equalsIgnoreCase("Y")) {
            deleteButton.click();
            deviceConfirmationOkButton.click();
        } else if (refresh.equalsIgnoreCase("Y")) {
            refreshButton.click();
        }

        taskSchedulerButtonApply.click();

        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
        if (!((taskSchedulerTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
            Assert.fail(taskSchedulerTaskUpdateStatusMessage.getText());
        }

    }

    public void applyAdministrationSettings_RemoteAgent_AdvancedSettings(
            String taskRebootMonitoring,
            String dhcpDiscovery,
            String monitoringAndMaintainance,
            String batteryIndicator,
            String idleState,
            String configSync,
            String location,
            String bootLog,
            String usbMassStorageLogs,
            String screenSaverLogs,
            String enableVncAcceptance,
            String syncTaskScheduler,
            String applicationLog,
            String cpuUtilizationLog,
            String writeFilterLogs,
            String signalRMonitoring,
            String hardwareLogs,
            String enableAgentDebugLogs,
            String downloadAttempts,
            String locationRange,
            String hardwareLogsInterval,
            String heartBeatInterval,
            String signalRConnectionPath

    ) {


        if (rhsMenuToogleElement.getAttribute("class").contains("active")) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
            rhsMenuToogleElement.click();
        }

        if (!(windowsAdministrationSettingsRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsRhsMenu));
            windowsAdministrationSettingsRhsMenu.click();
        }

        if (!(windowsAdministrationSettingsRemoteAgentRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsAdministrationSettingsRemoteAgentRhsMenu));
            windowsAdministrationSettingsRemoteAgentRhsMenu.click();
        }

        windowsAdministrationSettingsRemoteAgentAdvancedSettingsRhsMenu.click();
        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

//        String taskRebootMonitoring = "Y";
//        String dhcpDiscovery = "Y";
//        String monitoringAndMaintainance = "Y";
//        String batteryIndicator = "Y";
//        String idleState = "Y";
//        String configSync = "Y";
//        String location = "Y";
//        String bootLog = "Y";
//        String usbMassStorageLogs = "Y";
//        String screenSaverLogs = "Y";
//        String enableVncAcceptance = "Y";
//        String syncTaskScheduler = "Y";
//        String applicationLog = "Y";
//        String cpuUtilizationLog = "Y";
//        String writeFilterLogs = "Y";
//        String signalRMonitoring = "Y";
//        String hardwareLogs = "Y";
//        String enableAgentDebugLogs = "User Level"; //User Level //Developer Level
//        String downloadAttempts = "5"; // 1 - 10
//        String locationRange = "200"; // 100 - 5000 meters
//        int hardwareLogsInterval = 6; // 3 - onwards
//        int heartBeatInterval = 45; // clear and sendkeys
//        String signalRConnectionPath = "/communication/signalr/hubs"; // test data // /communication/signalr/hubs

        Select select;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (taskRebootMonitoring.equalsIgnoreCase("N")) {
            taskRebootMorningCheckbox.click();
        }
        if (dhcpDiscovery.equalsIgnoreCase("N")) {
            dhcpDiscoveryCheckbox.click();
        }
        if (monitoringAndMaintainance.equalsIgnoreCase("N")) {
            monitoringAndMaintainanceCheckbox.click();
        }
        if (batteryIndicator.equalsIgnoreCase("N")) {
            batteryIndicatorCheckbox.click();
        }
        if (idleState.equalsIgnoreCase("N")) {
            idleStateCheckbox.click();
        }
        if (configSync.equalsIgnoreCase("N")) {
            configSyncCheckbox.click();
        }
        if (location.equalsIgnoreCase("N")) {
            locationCheckbox.click();
        }
        if (bootLog.equalsIgnoreCase("N")) {
            bootLogCheckbox.click();
        }
        if (usbMassStorageLogs.equalsIgnoreCase("N")) {
            usbMassStorageLogsCheckbox.click();
        }
        if (screenSaverLogs.equalsIgnoreCase("N")) {
            screenSaverLogsCheckbox.click();
        }
        if (enableVncAcceptance.equalsIgnoreCase("N")) {
            enableVncAcceptanceCheckbox.click();
        }
        if (syncTaskScheduler.equalsIgnoreCase("N")) {
            syncTaskSchedulerCheckbox.click();
        }
        if (applicationLog.equalsIgnoreCase("N")) {
            applicationLogCheckbox.click();
        }
        if (cpuUtilizationLog.equalsIgnoreCase("N")) {
            cpuUtilizationLogCheckbox.click();
        }
        if (writeFilterLogs.equalsIgnoreCase("N")) {
            writeFilterLogsCheckbox.click();
        }
        if (signalRMonitoring.equalsIgnoreCase("N")) {
            signalRMonitoringCheckbox.click();
        }
        if (hardwareLogs.equalsIgnoreCase("N")) {
            hardwareLogsCheckbox.click();
        }

        js.executeScript("arguments[0].scrollIntoView(true);", enableAgentDebugLogsDropdown);

        select = new Select(enableAgentDebugLogsDropdown);
        select.selectByVisibleText(enableAgentDebugLogs);

        select = new Select(downloadAttemptsDropdown);
        select.selectByVisibleText(downloadAttempts);

        select = new Select(locationRangeDropdown);
        select.selectByVisibleText(locationRange);

        // hardware log interval
        int hardwareLogsIntervalInt = Integer.parseInt(hardwareLogsInterval);
        int count = hardwareLogsIntervalInt - 3; // by default it's 3

        if (count < 0) {
            for (int i = 0; i < -count; i++) {
                decreaseMinutes.click();
            }
        } else if (count > 0) {
            for (int i = 0; i < count; i++) {
                increaseMinutes.click();
            }
        } else {
            System.out.println("Count is 0");
        }

        // heartbeat interval
        heartBeatIntervalTextbox.clear();
        heartBeatIntervalTextbox.sendKeys(heartBeatInterval);

        // Signal R Connection path
        signalRConnectionPathTextbox.clear();
        signalRConnectionPathTextbox.sendKeys(signalRConnectionPath);

        advanceSettingButtonSave.click();

        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
        if (!((advanceSettingTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
            Assert.fail(advanceSettingTaskUpdateStatusMessage.getText());
        }

    }

    public void applySoftwareDeployment_SoftwareAndPatch_InstallUninstall(String selectNewInstallOrUninstall, String sourceType, String source,
                                                                          String fileName, String parameter, String skipWriteFilter, String globalRepository) {


        if (rhsMenuToogleElement.getAttribute("class").contains("active")) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
            rhsMenuToogleElement.click();
        }

        if (!(windowsSoftwareDeploymentRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsSoftwareDeploymentRhsMenu));
            windowsSoftwareDeploymentRhsMenu.click();
        }

        windowsSoftwareDeploymentSoftwareAndPatchInstallUninstallRhsMenu.click();
        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

        Select select;
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        String selectNewInstallOrUninstall = "NEW INSTALL"; // test data // UNINSTALL

        if (selectNewInstallOrUninstall.equalsIgnoreCase("NEW INSTALL")) {

            newInstallButton.click();
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

            js.executeScript("arguments[0].scrollIntoView(true);", softwarePatchInstallUninstallButtonSave);

//            String sourceType = "Repository"; //Repository //New Upload //$Group$
            wait.until(ExpectedConditions.visibilityOf(sourceTypeDropdown));
            select = new Select(sourceTypeDropdown);
            select.selectByVisibleText(sourceType);
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

            wait.until(ExpectedConditions.visibilityOf(sourceTypeDropdown));
            wait.until(ExpectedConditions.elementToBeClickable(sourceTypeDropdown));
//            String source = "HTTPS"; //FDM_HTTP //FTPS //CIFS //HTTPS //$GROUP$


            if (sourceType.equalsIgnoreCase("New Upload")) {

                select = new Select(sourceDropdown);
                select.selectByVisibleText(source);
                wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

                // upload file
                fileUploadIcon.sendKeys(System.getProperty("user.dir") + ("\\src\\main\\java\\com\\uem_automation\\qa\\testdata\\") + fileName);
                fileUploadButton.click();
                wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
                Assert.assertTrue((fileUploadStatus.getText()).equalsIgnoreCase(fileName + " is uploaded"));

            } else if (sourceType.equalsIgnoreCase("$Group$")) {
                select = new Select(fileDropdown);
                select.selectByVisibleText(fileName);
                wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

                validateConnectionButton.click();
                Assert.assertTrue((connectionStatus.getText()).equalsIgnoreCase("Connection validated successfully."));

            } else {

                select = new Select(sourceDropdown);
                select.selectByVisibleText(source);
                wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

//                String fileName = "ChromeSetup.exe"; // test data

                select = new Select(fileDropdown);
                select.selectByVisibleText(fileName);
                wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

                validateConnectionButton.click();
                Assert.assertTrue((connectionStatus.getText()).equalsIgnoreCase("Connection validated successfully."));

            }

//            String parameter = "/quiet"; // test data
            parameterTextbox.clear();
            parameterTextbox.sendKeys(parameter);

//            String skipWriteFilter = "Y"; //Y //N
            if (skipWriteFilter.equalsIgnoreCase("Y")) {
                js.executeScript("arguments[0].click();", softwareUpgradeSkipWriteFilterCheckbox);//input[@id='XPSoftwareUpgrade_InstallidRebootRequired']
            }
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

//            String globalRepository = "Y"; //Y //N
            if (globalRepository.equalsIgnoreCase("Y")) {
                js.executeScript("arguments[0].click();", globalRepositoryCheckbox);
            }
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

            softwarePatchInstallUninstallButtonSave.click();

            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            if (!((softwarePatchInstallUninstallTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
                Assert.fail(softwarePatchInstallUninstallTaskUpdateStatusMessage.getText());
            }

        } else if (selectNewInstallOrUninstall.equalsIgnoreCase("UNINSTALL")) {
            Assert.fail("Uninstall code development is in progress....");
        }

    }
}
