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

public class SoftwareDeploymentPage {

    public WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.EXPLICIT_WAIT_TIME));

    // Objects
    // Application Command
    @FindBy(xpath = "//div[@class='AjaxLoaderOuter loaderDivInitial']//button[@type='button'][normalize-space()='Please wait...']")
    private WebElement ajaxLoaderOuter;

    @FindBy(xpath = "//a[@id='kt_aside_toggle']")
    private WebElement rhsMenuToogleElement;

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
    public SoftwareDeploymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
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

//                validateConnectionButton.click();
                js.executeScript("arguments[0].click();", validateConnectionButton);
                wait.until(ExpectedConditions.visibilityOf(connectionStatus));
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
