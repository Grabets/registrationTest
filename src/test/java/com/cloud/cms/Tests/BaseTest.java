package com.cloud.cms.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private static final String HOME_URL = "http://46.164.136.78";
    protected WebDriver driver;


    @BeforeTest
    public void webDriverSetup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void navigateToHomeScreen() {
        driver.manage().deleteAllCookies();
        driver.get(HOME_URL);
    }

    @AfterTest
    public void closeDriver(){
        getDriver().close();
    }

    public WebDriver getDriver() {
        return driver;
    }


}
