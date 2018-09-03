package com.cloud.cms.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    private static final String SIGN_IN_LOCATOR = "//a[text()='Sign In']";

    @FindBy (how = How.XPATH, using = SIGN_IN_LOCATOR)
    private WebElement signInButton;

//    protected static WebDriver driver;
//    protected static WebDriverWait wait;

    public static void init(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, 5);
    }

    public LoginPage loginPageClick(){
        String signUpLocator = LoginPage.SIGN_UP_LOCATOR;
        signInButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(signUpLocator)));
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        return loginPage;
    }
}
