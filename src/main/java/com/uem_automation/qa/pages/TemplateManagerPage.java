package com.uem_automation.qa.pages;

import com.uem_automation.qa.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TemplateManagerPage {

    public WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Utilities.EXPLICIT_WAIT_TIME));

    // Objects
    @FindBy(xpath = "//div[@class='AjaxLoaderOuter loaderDivInitial']//button[@type='button'][normalize-space()='Please wait...']")
    private WebElement ajaxLoaderOuter;

    // Create Template
    @FindBy(xpath = "//a[@id='kt_aside_toggle']")
    private WebElement rhsMenuToogleElement;

    @FindBy(xpath = "//ul[@class='menu-nav mt-n1 page-sidebar-menu']//label[@title='Template Manager'][normalize-space()='Template Manager']")
    private WebElement templateManagerRhsMenuElement;

    @FindBy(xpath = "//a[@id='templatedivopen']")
    private WebElement allTemplatesDropdownElement;

    @FindBy(xpath = "//a[@id='btnaddtemplates']")
    private WebElement addTemplateIconElement;

    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTemplateName']")
    private WebElement templateNameElement;

    @FindBy(xpath = "//select[@id='ddlostype']")
    private WebElement osTypeElement;

    @FindBy(xpath = "//select[@id='ddlTemplateType']")
    private WebElement taskScheduleTypeElement;

    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnCreateTemplate']")
    private WebElement saveButtonElement;

    @FindBy(xpath = "//a[@href='https://www.sundynetech.com/']")
    private WebElement companyWebsiteUrlFooter;

    @FindBy(xpath = "//div[@id='divTemplateManSkipWriteFilterProcess']//label[@class='checkbox']")
    private WebElement skipWriteFilterCheckboxElement;

    @FindBy(xpath = "//select[@id='ddlTemplateType']")
    private WebElement taskScheduleTypeDropdownElement;

    @FindBy(xpath = "//select[@id='ddlTMPostponedInterval']")
    private WebElement allowTaskPostponementDropdownElement;

    @FindBy(xpath = "//textarea[@id='ContentPlaceHolder1_txtAddMessage_CreTem']")
    private WebElement templateStartMessageInputElement;

    @FindBy(xpath = "//select[@id='ddlTMPostponedDisplayTime']")
    private WebElement displayTimeDropdownElement;

    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnCreateTemplate']")
    private WebElement saveButtonElement1;

    @FindBy(xpath = "//label[@id='lblNewTemplate_msg']")
    private WebElement newTemplateLabelMessage;

    @FindBy(xpath = "//textarea[@id='textareaTMPostponedMessage']")
    private WebElement postponementMessageTextareaElement;

    @FindBy(xpath = "//select[@id='ddlTMPostponementDisplayTime']")
    private WebElement postponementDisplayTimeDropdownElement;

    @FindBy(xpath = "//input[@id='btnWarningHeaderNoDeviceAgentOK']")
    private WebElement warningAlertOkButtonElement;

    // Search and view the template
    @FindBy(xpath = "//input[@id='myInput']")
    private WebElement searchTemplateNameTextboxElement;

    // Constructor
    public TemplateManagerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void createTemplate(String templateName, String osType, String skipWriteFilter, String taskScheduleType,
                               String allowTaskPostponement, String postponementMessage, String postponementDisplayTime,
                               String templateStartMessage, String displayTime) {

          // Navigate to template manager rhs menu
//        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
//        wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
//        rhsMenuToogleElement.click();
//
//        templateManagerRhsMenuElement.click();


        // Create template
        allTemplatesDropdownElement.click();

        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
        wait.until(ExpectedConditions.elementToBeClickable(addTemplateIconElement));
        addTemplateIconElement.click();

        templateNameElement.sendKeys(templateName);

        Select select = new Select(osTypeElement);
        select.selectByVisibleText(osType);

        if (osType.equalsIgnoreCase("Windows")) {

            if (skipWriteFilter.equalsIgnoreCase("Y")) {
                skipWriteFilterCheckboxElement.click();
            }

            select = new Select(taskScheduleTypeDropdownElement);
            select.selectByVisibleText(taskScheduleType);

            if (taskScheduleType.equalsIgnoreCase("Sequential/Dependency")) {

                if ((Integer.parseInt(allowTaskPostponement)) > 0) {

                    select = new Select(allowTaskPostponementDropdownElement);
                    select.selectByValue(allowTaskPostponement);

                    postponementMessageTextareaElement.sendKeys(postponementMessage);

                    select = new Select(postponementDisplayTimeDropdownElement);
                    select.selectByVisibleText(postponementDisplayTime);
                }

                templateStartMessageInputElement.sendKeys(templateStartMessage);

                select = new Select(displayTimeDropdownElement);
                select.selectByVisibleText(displayTime);

            } else if (taskScheduleType.equalsIgnoreCase("Asynchronous")) {

                select = new Select(taskScheduleTypeDropdownElement);
                select.selectByVisibleText(taskScheduleType);

                if ((Integer.parseInt(allowTaskPostponement)) > 0) {

                    select = new Select(allowTaskPostponementDropdownElement);
                    select.selectByValue(allowTaskPostponement);

                    postponementMessageTextareaElement.sendKeys(postponementMessage);

                    select = new Select(postponementDisplayTimeDropdownElement);
                    select.selectByVisibleText(postponementDisplayTime);
                }

            }

        } else if (osType.equalsIgnoreCase("Linux")) {

            if (taskScheduleType.equalsIgnoreCase("Sequential/Dependency")) {

                select = new Select(taskScheduleTypeDropdownElement);
                select.selectByVisibleText(taskScheduleType);

                templateStartMessageInputElement.sendKeys(templateStartMessage);

                select = new Select(displayTimeDropdownElement);
                select.selectByVisibleText(displayTime);

            }

        } else if (osType.equalsIgnoreCase("Android")) {

            select = new Select(taskScheduleTypeDropdownElement);
            select.selectByVisibleText(taskScheduleType);

        } else if (osType.equalsIgnoreCase("IOS")) {

            select = new Select(taskScheduleTypeDropdownElement);
            select.selectByVisibleText(taskScheduleType);

        }

        saveButtonElement1.click();

        // template name already exist handling code
        if(newTemplateLabelMessage.isDisplayed()) {
            Assert.fail(newTemplateLabelMessage.getText());
        }

    }


    public void searchAndViewTheTemplate(String templateNameProperty) {

//        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
//        wait.until(ExpectedConditions.elementToBeClickable(rhsMenuToogleElement));
//        rhsMenuToogleElement.click();
//
//        templateManagerRhsMenuElement.click();

        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
        wait.until(ExpectedConditions.elementToBeClickable(allTemplatesDropdownElement));
        allTemplatesDropdownElement.click();

        wait.until(ExpectedConditions.invisibilityOf(ajaxLoaderOuter));
        wait.until(ExpectedConditions.elementToBeClickable(searchTemplateNameTextboxElement));
        searchTemplateNameTextboxElement.sendKeys(templateNameProperty);

        driver.findElement(By.xpath("//h4[normalize-space()='" + templateNameProperty + "']")).click();

    }


}
