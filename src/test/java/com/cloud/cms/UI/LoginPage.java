package com.cloud.cms.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    //TODO: it is appropriate?
    public static final String SIGN_UP_LOCATOR = "//a[contains(text(),'Sign Up')]";

    @FindBy(how = How.XPATH, using = SIGN_UP_LOCATOR)
    private WebElement signUpButton;

    public RegisterPage signUpButtonClick(){
        signUpButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(RegisterPage.BACK_TO_LOGIN_PAGE_ID_LOCATOR)));
        return PageFactory.initElements(driver, RegisterPage.class);
    }

}
