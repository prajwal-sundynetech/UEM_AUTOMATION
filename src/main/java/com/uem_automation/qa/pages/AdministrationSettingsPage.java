package com.uem_automation.qa.pages;

import com.uem_automation.qa.utils.Utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
    private WebElement windowsAdministrationSettingsRhsMenu ;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='Application Command'][normalize-space()='Application Command']")
    private WebElement windowsAdministrationSettingsApplicationCommandRhsMenu ;

    @FindBy(xpath = "//label[@id='WinAPPCMDlblapplication']")
    private WebElement applicationTab ;

    @FindBy(xpath = "//input[@id='WinAPPCMDtxtAppsPath']")
    private WebElement applicationPathTextbox ;

    @FindBy(xpath = "//input[@id='WinAPPCMDtxtParameters']")
    private WebElement parametersTextbox ;

    @FindBy(xpath = "//input[@id='WinAPPCMDchbxWarnUser']")
    private WebElement alertUserCheckbox ;

    @FindBy(xpath = "//select[@id='WinAPPCMDddlMsgType']")
    private WebElement messageTypeDropdown ;

    @FindBy(xpath = "//input[@id='WinAPPCMDtxtTitle']")
    private WebElement titleTextbox ;

    @FindBy(xpath = "//textarea[@id='WinAPPCMDtxtMsg']")
    private WebElement messageTextbox ;

    @FindBy(xpath = "//select[@id='WinAPPCMDddlDisplayTime']")
    private WebElement displayTimeDropdown ;

    @FindBy(xpath = "//label[@id='WinAPPCMDlblcommand']")
    private WebElement commandTab ;

    @FindBy(xpath = "//input[@id='WinAPPCMDtxtCommand']")
    private WebElement commandTextbox ;

    @FindBy(xpath = "//select[@id='WinAPPCMDddlTimeOut']")
    private WebElement timeoutDropdown ;

    @FindBy(xpath = "//input[@id='ChkRequiredCommandOutput']")
    private WebElement requiredCommandOutputCheckbox ;

    @FindBy(xpath = "//input[@id='WinAPPCMDidRebootRequired']")
    private WebElement skipWriteFilterCheckbox ;

    @FindBy(xpath = "//input[@id='WinAPPCMDbtnApplyRDP']")
    private WebElement applicationCommandButtonSave ;

    @FindBy(xpath = "//label[@id='WinAPPCMDlblMsg']")
    private WebElement applicationCommandTaskUpdateStatusMessage ;

    // Environment variable
    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='Environment Variable'][normalize-space()='Environment Variable']")
    private WebElement windowsAdministrationSettingsEnvironmentVariableRhsMenu ;

    @FindBy(xpath = "//input[@id='XPEnvironmentVari_TxtVariableName']")
    private WebElement variableNameTextbox ;

    @FindBy(xpath = "//input[@id='XPEnvironmentVari_txtValue']")
    private WebElement valueTextbox ;

    @FindBy(xpath = "//input[@id='XPEnvironmentVari_btnEnvVarApplye']")
    private WebElement environmentVariableButtonSave ;

    @FindBy(xpath = "//label[@id='XPEnvironmentVari_lblMsg']")
    private WebElement environmentVariableTaskUpdateStatusMessage ;

    // Performance Management
    // History cleaner
    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//li[@id='lblMenu_performancemanagement_Window']")
    private WebElement windowsAdministrationSettingsPerformanceManagementRhsMenu ;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='History Cleaner'][normalize-space()='History Cleaner']")
    private WebElement windowsAdministrationSettingsPerformanceManagementHistoryCleanerRhsMenu ;

    @FindBy(xpath = "//label[@id='XPWebBrowser_lblMenuWbBrwsr']")
    private WebElement webBrowserTab ;

    @FindBy(xpath = "//select[@id='XPWebBrowser_ddlBrowserInstalled']")
    private WebElement browserInstalledDropdown ;

    @FindBy(xpath = "//input[@id='XPWebBrowser_cbxCookies']")
    private WebElement internetBrowserCookiesCheckbox ;

    @FindBy(xpath = "//input[@id='XPWebBrowser_cbxWebBrowserHistory']")
    private WebElement historyCheckbox ;

    @FindBy(xpath = "//input[@id='XPWebBrowser_cbxWebBrowserTemp']")
    private WebElement temporaryInternetFilesCheckbox ;

    @FindBy(xpath = "//label[@id='XPWebBrowser_lblMenuWndwsClnr']")
    private WebElement windowsCleaner ;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxClearDocument']")
    private WebElement clearTheRecentDocumentHistoryCheckbox ;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxStartMenu']")
    private WebElement clearTheStartMenuRunHistoryCheckbox ;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxClearFindfiles']")
    private WebElement clearTheFindFilesHistoryCheckbox ;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxClearRecentFile']")
    private WebElement clearTheMsPainRecentFileHistoryCheckbox ;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxClearRecentMSWordpad']")
    private WebElement clearTheMsWordpadRecentFileHistoryCheckbox ;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxCommonDialogOpenSave']")
    private WebElement clearTheCommonDialogueOpenSaveHistoryCheckbox ;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxCommonDialogLastVisited']")
    private WebElement clearTheCommonDialogueLastVisitedFolderHistoryCheckbox ;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxEmptyClipboard']")
    private WebElement pleaseEmptyTheClipboardCheckbox ;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxEmptyRecycleBin']")
    private WebElement pleaseEmptyTheRecycleBinCheckbox ;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_cbxDeleteWindowsTempFiles']")
    private WebElement deleteWindowsTemporaryFilesCheckbox ;

    @FindBy(xpath = "//input[@id='XPWebBrowser_btnSavebrowser']")
    private WebElement historyCleanerWebBrowserButtonSave ;

    @FindBy(xpath = "//input[@id='XPWindowsCleaner_btnApplyCleaner1']")
    private WebElement historyCleanerWindowsCleanerButtonSave ;

    @FindBy(xpath = "//label[@id='XPWebBrowser_lblMSg_Success']")
    private WebElement webBroserhHistoryCleanerTaskUpdateStatusMessage ;

    @FindBy(xpath = "//label[@id='XPWindowsCleaner_lblMsg_winCle']")
    private WebElement windowsCleanerHistoryCleanerTaskUpdateStatusMessage ;

//    @FindBy(xpath = "xxxxxx")
//    private WebElement xxxxx ;


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
                                                               String requiredCommandOutput, String timeout, String skipWriteFilter)
    {

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

        if(selectTab.equalsIgnoreCase("Application")) {

            applicationTab.click();

            applicationPathTextbox.sendKeys(applicationPath); //"C:\\Windows\\System32\\calc.exe"); // test data
            parametersTextbox.sendKeys(prameters); //"testdata parameters"); // test data

//            String alertUser = "Y"; //Y //N // test data
            if(alertUser.equalsIgnoreCase("Y")) {
//                alertUserCheckbox.click();
                 js.executeScript("arguments[0].click();",alertUserCheckbox);

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

        }
        else if(selectTab.equalsIgnoreCase("Command")) {

            commandTab.click();

            commandTextbox.sendKeys(command); //"www.test.com"); //www.test.com //C:\System32\drivers\etc\hosts //This command allows you to execute any command available into the remote system.

//            String requiredCommandOutput = "N"; //Y //N // test data
            if(requiredCommandOutput.equalsIgnoreCase("Y")) {
//                requiredCommandOutputCheckbox.click();
                js.executeScript("arguments[0].click();",requiredCommandOutputCheckbox);
            }
            else {

//                String timeout = "5 Minutes"; //Never //5 Seconds //30 Seconds //1 Minute to //5 Minutes
                select = new Select(timeoutDropdown);
                select.selectByVisibleText(timeout);
            }


        }

//        String skipWriteFilter = "Y"; //Y //N //test data
        if(skipWriteFilter.equalsIgnoreCase("Y")) {
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

    public void applyAdministrationSettings_PerformanceManagement_HistoryCleaner(String selectTab, String browserInstalled, String internetBrowserCookies, String history, String temporaryInternetFiles,
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
        if(selectTab.equalsIgnoreCase("Web Browser")) {

            webBrowserTab.click();

//            String browserInstalled = "Google Chrome"; //Internet Explorer //Google Chrome
            select = new Select(browserInstalledDropdown);
            select.selectByVisibleText(browserInstalled);

//            String internetBrowserCookies = "Y"; //Y //N //testdata
//            String history = "Y"; //Y //N //testdata
//            String temporaryInternetFiles = "Y"; //Y //N //testdata

            if(internetBrowserCookies.equalsIgnoreCase("Y")) {
//                internetBrowserCookiesCheckbox.click();
                js.executeScript("arguments[0].click();",internetBrowserCookiesCheckbox);
            }

            if(history.equalsIgnoreCase("Y")) {
//                historyCheckbox.click();
                js.executeScript("arguments[0].click();",historyCheckbox);
            }

            if(temporaryInternetFiles.equalsIgnoreCase("Y")) {
//                temporaryInternetFilesCheckbox.click();
                js.executeScript("arguments[0].click();",temporaryInternetFilesCheckbox);
            }

            historyCleanerWebBrowserButtonSave.click();
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

            if (!((webBroserhHistoryCleanerTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
                Assert.fail(webBroserhHistoryCleanerTaskUpdateStatusMessage.getText());
            }

        }
        else if(selectTab.equalsIgnoreCase("Windows Cleaner")) {

            windowsCleaner.click();

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

            if(clearTheRecentDocumentHistory.equalsIgnoreCase("Y")) {
//                clearTheRecentDocumentHistoryCheckbox.click();
                js.executeScript("arguments[0].click();",clearTheRecentDocumentHistoryCheckbox);
            }

            if(clearTheStartMenuRunHistory.equalsIgnoreCase("Y")) {
//                clearTheStartMenuRunHistoryCheckbox.click();
                js.executeScript("arguments[0].click();",clearTheStartMenuRunHistoryCheckbox);
            }

            if(clearTheFindFilesHistory.equalsIgnoreCase("Y")) {
//                clearTheFindFilesHistoryCheckbox.click();
                js.executeScript("arguments[0].click();",clearTheFindFilesHistoryCheckbox);
            }

            if(clearTheMsPainRecentFileHistory.equalsIgnoreCase("Y")) {
//                clearTheMsPainRecentFileHistoryCheckbox.click();
                js.executeScript("arguments[0].click();",clearTheMsPainRecentFileHistoryCheckbox);
            }

            if(clearTheMsWordpadRecentFileHistory.equalsIgnoreCase("Y")) {
//                clearTheMsWordpadRecentFileHistoryCheckbox.click();
                js.executeScript("arguments[0].click();",clearTheMsWordpadRecentFileHistoryCheckbox);
            }

            if(clearTheCommonDialogueOpenSaveHistory.equalsIgnoreCase("Y")) {
//                clearTheMsWordpadRecentFileHistoryCheckbox.click();
                js.executeScript("arguments[0].click();",clearTheCommonDialogueOpenSaveHistoryCheckbox);
            }

            if(clearTheCommonDialogueLastVisitedFolderHistory.equalsIgnoreCase("Y")) {
//                clearTheMsWordpadRecentFileHistoryCheckbox.click();
                js.executeScript("arguments[0].click();",clearTheCommonDialogueLastVisitedFolderHistoryCheckbox);
            }

            if(pleaseEmptyTheClipboard.equalsIgnoreCase("Y")) {
//                pleaseEmptyTheClipboardCheckbox.click();
                js.executeScript("arguments[0].click();",pleaseEmptyTheClipboardCheckbox);
            }

            if(pleaseEmptyTheRecycleBin.equalsIgnoreCase("Y")) {
//                pleaseEmptyTheRecycleBinCheckbox.click();
                js.executeScript("arguments[0].click();",pleaseEmptyTheRecycleBinCheckbox);
            }

            if(deleteWindowsTemporaryFiles.equalsIgnoreCase("Y")) {
//                deleteWindowsTemporaryFilesCheckbox.click();
                js.executeScript("arguments[0].click();",deleteWindowsTemporaryFilesCheckbox);
            }

            historyCleanerWindowsCleanerButtonSave.click();
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

            if (!((windowsCleanerHistoryCleanerTaskUpdateStatusMessage.getText()).equals("Request for settings update has been processed"))) {
                Assert.fail(webBroserhHistoryCleanerTaskUpdateStatusMessage.getText());
            }

        }

    }
}
