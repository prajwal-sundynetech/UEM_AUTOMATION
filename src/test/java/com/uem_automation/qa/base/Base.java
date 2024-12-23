package com.uem_automation.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import com.uem_automation.qa.utils.Utilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	WebDriver driver;
	public Properties configProp;
	public Properties testdataProp;

	public Base() {

		// loading config.properties file
		configProp = new Properties();
		File configPropropFile = new File(System.getProperty("user.dir")
				+ ("//src//main//java//com//uem_automation//qa//config//config.properties"));

		try {
			FileInputStream fis = new FileInputStream(configPropropFile);
			configProp.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		// loading testdata.properties file
		testdataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")
				+ ("//src//main//java//com//uem_automation//qa//testdata//testdata.properties"));

		try {
			FileInputStream fis2 = new FileInputStream(dataPropFile);
			testdataProp.load(fis2);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	// cross-browsr browser invocation
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--ignore-certificate-errors");
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--ignore-certificate-errors");
			driver = new EdgeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--ignore-certificate-errors");
			driver = new FirefoxDriver(options);

		} else if (browserName.equalsIgnoreCase("safari")) {
			SafariOptions options = new SafariOptions();
			// options.addArguments("--ignore-certificate-errors");
			driver = new SafariDriver(options);

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));

		driver.manage().window().maximize();

		try {
			driver.get(configProp.getProperty("url"));
		} catch (TimeoutException e) {
			System.out.println(
					"Timeout Exception: The page did not load within the specified time.\nError: Server is down. "
							+ configProp.getProperty("url"));
		}

		return driver;
	}

}
