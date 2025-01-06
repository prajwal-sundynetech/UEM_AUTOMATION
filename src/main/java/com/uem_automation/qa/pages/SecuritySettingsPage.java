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

public class SecuritySettingsPage {

    public WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.EXPLICIT_WAIT_TIME));

    // Objects
    // Application Command
    @FindBy(xpath = "//div[@class='AjaxLoaderOuter loaderDivInitial']//button[@type='button'][normalize-space()='Please wait...']")
    private WebElement ajaxLoaderOuter;

    @FindBy(xpath = "//a[@id='kt_aside_toggle']")
    private WebElement rhsMenuToogleElement;

    // Write Filter Application
    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//li[@id='lblMenu_security_window']")
    private WebElement windowsSecuritySettingsRhsMenu ;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//li[@id='lblMenu_filesystem_Window']")
    private WebElement windowsSecuritySettingsFileSystemRhsMenu ;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='Write Filter Operations'][normalize-space()='Write Filter Operations']")
    private WebElement windowsSecuritySettingsFileSystemWriteFilterOperationsRhsMenu ;

    @FindBy(xpath = "//label[@id='WinWriteFilterlblMenuWrtFlterSett']")
    private WebElement writeFilterSettingLabel ;

    @FindBy(xpath = "//label[@id='WinWriteFilterlblMenuFBWFCnfgrtn']")
    private WebElement writeFilterExclusionListLabel ;

    @FindBy(xpath = "//select[@id='WinWriteFilterddlWriteFilterSelection']")
    private WebElement writeFilterDropdown ;

    @FindBy(xpath = "//input[@id='WinWriteFiltertxtCombobox']")
    private WebElement fileAndFolderPathTextbox ;

    @FindBy(xpath = "//input[@id='WinWriteFilterbtnadd']")
    private WebElement addButton1 ;

    @FindBy(xpath = "//input[@id='WinWriteFiltertxtCombobox1']")
    private WebElement registryPathTextbox ;

    @FindBy(xpath = "//input[@id='WinWriteFilterbtnaddRegistry']")
    private WebElement addButton2 ;

    @FindBy(xpath = "//label[@id='WinWriteFilterlblMenuFBWFCacheSize']")
    private WebElement fbwfCacheSize ;

    @FindBy(xpath = "//input[@id='WinWriteFiltertxtcatchsize']")
    private WebElement setMaxCacheSizeForNextSessionTextbox ;

    @FindBy(xpath = "//label[@id='WinWriteFilterlblMenuOverlaySettings']")
    private WebElement overlaySettingsLabel ;

    @FindBy(xpath = "//input[@id='WinOverlay_txtOverlaySize']")
    private WebElement overlaySizeTextbox ;

    @FindBy(xpath = "//input[@id='WinWriteFilterchkWarnUser']/following-sibling::span")
    private WebElement alertUserCheckbox ;

    @FindBy(xpath = "//select[@id='WinWriteFilterddlMessageType']")
    private WebElement messageTypeDropdown ;

    @FindBy(xpath = "//select[@id='WinWriteFilterddlMessageImp']")
    private WebElement messageImportantDropdown ;

    @FindBy(xpath = "//input[@id='WinWriteFiltertxttitle']")
    private WebElement titleTextbox ;

    @FindBy(xpath = "//input[@id='WinWriteFiltertxtMsg']")
    private WebElement messageTextbox ;

    @FindBy(xpath = "//select[@id='WinWriteFilterddlDisplayTime']")
    private WebElement displayTimeDropdown ;

    @FindBy(xpath = "//input[@id='WinWriteFilterbtnFWFSaveNew']")
    private WebElement exclusionAndFbwfSizeButtonSave ;

    @FindBy(xpath = "//input[@id='WinOverlaySettingbtnFWFSave']")
    private WebElement overlaySettingsButtonSave ;

    @FindBy(xpath = "//div[@id='WinWriteFilterRowWriteFilterApply']//div[@class='pull-left']")
    private WebElement writeFilterOperationsTaskUpdateStatusMessage ;

    // Firewall
    @FindBy(xpath = "//label[@id='XPFirewall_lblMenuAddPort']")
    private WebElement addPortLabel ;

    @FindBy(xpath = "//input[@id='XPFirewall_txtName']")
    private WebElement nameTextbox ;

    @FindBy(xpath = "//input[@id='XPFirewall_txtFirewallPortNo']")
    private WebElement portNumberTextbox ;

    @FindBy(xpath = "//input[@id='XPFirewall_rbtnTCP']")
    private WebElement tcpRadioButton ;

    @FindBy(xpath = "//input[@id='XPFirewall_rbtnUDP']")
    private WebElement udpRadioButton ;

    @FindBy(xpath = "//input[@id='XPFirewall_btnSavePortXP']")
    private WebElement addPortSaveButton ;

    @FindBy(xpath = "//div[@id='XPFirewall_pnlPort']//div[@class='pull-left']")
    private WebElement addPortStatusMessage ;

    @FindBy(xpath = "//label[@id='XPFirewall_lblMenuAddProgram']")
    private WebElement addProgramLabel ;

    @FindBy(xpath = "//input[@id='XPFirewall_txtProgramName']")
    private WebElement programNameTextbox ;

    @FindBy(xpath = "//input[@id='XPFirewall_txtProgramPath']")
    private WebElement programPathTextbox ;

    @FindBy(xpath = "//input[@id='XPFirewall_btnSaveProgram']")
    private WebElement addProgramSaveButton ;

    @FindBy(xpath = "//div[@id='XPFirewall_pnlAddProgram']//div[@class='pull-left']")
    private WebElement addProgramStatusMessage ;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//li[@id='lblMenu_network_Window']")
    private WebElement windowsSecuritySettingsNetworkRhsMenu ;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='Firewall'][normalize-space()='Firewall']")
    private WebElement windowsSecuritySettingsNetworkFirewallRhsMenu ;

//    @FindBy(xpath = "xxxxxx")
//    private WebElement xxxxxx ;
//


    // Constructor
    public SecuritySettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions

    public void applySecuritySettings_FileSystem_WriteFilterOperations(String selectTab, String writeFilterSetting, String writeFilter, String fileAndFolderPath,
                                                                       String registryPath, String setMaxCacheSizeForNextSession, String overlaySize,
                                                                       String alertUser, String messageType, String messageImportant, String title, String message,
                                                                       String displayTime) {

        if (rhsMenuToogleElement.getAttribute("class").contains("active")) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
            rhsMenuToogleElement.click();
        }

        if (!(windowsSecuritySettingsRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsSecuritySettingsRhsMenu));
            windowsSecuritySettingsRhsMenu.click();
        }

        if (!(windowsSecuritySettingsFileSystemRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsSecuritySettingsFileSystemRhsMenu));
            windowsSecuritySettingsFileSystemRhsMenu.click();
        }

        windowsSecuritySettingsFileSystemWriteFilterOperationsRhsMenu.click();
        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

        Select select;
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        String selectTab = "Write Filter Setting"; // testdata

        if (selectTab.equalsIgnoreCase("Write Filter Setting")) {
            writeFilterSettingLabel.click();

//            String writeFilterSetting = "Enable UWF"; // testdata
//            select = new Select(writeFilterSettingDropdown);
//            select.selectByValue(writeFilterSetting);
            Assert.fail("Security Settings - File System - Write Filter Setting Code is Disabled, Save button is disabled");

        } else if (selectTab.equalsIgnoreCase("Write Filter Exclusion List")) {
            writeFilterExclusionListLabel.click();

//            String writeFilter = "Enable FBWF"; // testdata
            select = new Select(writeFilterDropdown);
            select.selectByVisibleText(writeFilter);

            if (writeFilter.equalsIgnoreCase("Enable FBWF")) {

//                String fileAndFolderPath = "testpath"; //testdata
                fileAndFolderPathTextbox.sendKeys(fileAndFolderPath);
                addButton1.click();
            } else if (writeFilter.equalsIgnoreCase("Enable UWF")) {

//                String fileAndFolderPath = "testpath"; //testdata
                fileAndFolderPathTextbox.sendKeys(fileAndFolderPath);
                addButton1.click();

//                String registryPath = "testpath"; //testdata
                registryPathTextbox.sendKeys(registryPath);
                addButton2.click();
            }

        } else if (selectTab.equalsIgnoreCase("FBWF Cache Size")) {
            fbwfCacheSize.click();

//            String setMaxCacheSizeForNextSession = "1024"; //testdata // in mb's
            setMaxCacheSizeForNextSessionTextbox.sendKeys(setMaxCacheSizeForNextSession); //Cache size 32 MB to 1024 MB

        } else if (selectTab.equalsIgnoreCase("Overlay Settings")) {
            overlaySettingsLabel.click();

//            String overlaySize = "1050"; //testdata in mb
            overlaySizeTextbox.clear();
            overlaySizeTextbox.sendKeys(overlaySize);
        }

        if (!selectTab.equalsIgnoreCase("Overlay Settings")) {

//            String alertUser = "Y"; // testdata
            if (alertUser.equalsIgnoreCase("Y")) {
                alertUserCheckbox.click(); ////input[@id='WinWriteFilterchkWarnUser']

//                String messageType = "Information"; //testdata
                select = new Select(messageTypeDropdown);
                select.selectByVisibleText(messageType);

//                String messageImportant = "Information"; //testdata
                select = new Select(messageImportantDropdown);
                select.selectByVisibleText(messageImportant);

//                String title = "Message from Administrator"; //testdata
                titleTextbox.clear();
                titleTextbox.sendKeys(title);

//                String message = "A maintenance task is going to be performed on your desktop. Your device may Shutdown to complete the task," +
//                        " so you need to save any open work to avoid data loss and then press ok"; //testdata
                messageTextbox.clear();
                messageTextbox.sendKeys(message);

//                String displayTime = "2 Minute"; // testdata 1 to 10 min
                select = new Select(displayTimeDropdown);
                select.selectByVisibleText(displayTime);

            }
        }

        if (selectTab.equalsIgnoreCase("Write Filter Exclusion List") || selectTab.equalsIgnoreCase("FBWF Cache Size")) {
            exclusionAndFbwfSizeButtonSave.click(); //input[@id='WinWriteFilterbtnFWFSaveNew']
        } else if (selectTab.equalsIgnoreCase("Overlay Settings")) {
            overlaySettingsButtonSave.click(); //input[@id='WinOverlaySettingbtnFWFSave']
        }

        // Wait for the loader to disappear
        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

        // Get the status message text once
        String statusMessage = writeFilterOperationsTaskUpdateStatusMessage.getText();

        if (!statusMessage.equals("Request for settings update has been processed") &&
                !statusMessage.equals("Write Filter Overlay Saved Successfully")) {
            Assert.fail(statusMessage);
        }

    }


    public void applySecuritySettings_Network_Firewall(String selectTab, String name, String portNumber, String selectProtocol,
                                                       String programName, String programPath) {

        if (rhsMenuToogleElement.getAttribute("class").contains("active")) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
            rhsMenuToogleElement.click();
        }

        if (!(windowsSecuritySettingsRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsSecuritySettingsRhsMenu));
            windowsSecuritySettingsRhsMenu.click();
        }

        if (!(windowsSecuritySettingsNetworkRhsMenu.getAttribute("class").contains("menu-item-open"))) {
            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.elementToBeClickable(windowsSecuritySettingsNetworkRhsMenu));
            windowsSecuritySettingsNetworkRhsMenu.click();
        }

        windowsSecuritySettingsNetworkFirewallRhsMenu.click();
        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));

        JavascriptExecutor js = (JavascriptExecutor) driver;

//        String selectTab = "Add Port"; //testdata

        if(selectTab.equalsIgnoreCase("Add Port")) {

            addPortLabel.click();

//            String name = "testname"; // testdata
            nameTextbox.sendKeys(name);

//            String portNumber = "testportnumber"; // testdata
            portNumberTextbox.sendKeys(portNumber);

//            String selectProtocol = "UDP"; //testdata

            if(selectProtocol.equalsIgnoreCase("TCP")) {
                js.executeScript("arguments[0].click();", tcpRadioButton);
            } else if (selectProtocol.equalsIgnoreCase("UDP")) {
                js.executeScript("arguments[0].click();", udpRadioButton);
            }
            addPortSaveButton.click();

            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.visibilityOf(addPortStatusMessage));
            if (!((addPortStatusMessage.getText()).equals("Request for settings update has been processed"))) {
                Assert.fail(addPortStatusMessage.getText());
            }

        } else if (selectTab.equalsIgnoreCase("Add Program")) {

            addProgramLabel.click();

//            String programName = "testName"; //testdata
            programNameTextbox.sendKeys(programName);

//            String programPath = "C:\\Program Files\\Internet Explorer\\iexplore.exe"; //testdata
            programPathTextbox.sendKeys(programPath);

            addProgramSaveButton.click();

            wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
            wait.until(ExpectedConditions.visibilityOf(addProgramStatusMessage));
            if (!((addProgramStatusMessage.getText()).equals("Request for settings update has been processed"))) {
                Assert.fail(addProgramStatusMessage.getText());
            }
        }
    }
}
