package com.cloud.cms.UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends AbstractPage {

    public static final String BACK_TO_LOGIN_PAGE_ID_LOCATOR = "backToSingIn";
    private static final String FIRST_NAME_INPUT_FIELD_LOCATOR = "FirstName";

    @FindBy(how = How.NAME, using = FIRST_NAME_INPUT_FIELD_LOCATOR)
    private WebElement firstNameInputField;

    public void setFirstName(String firstName){
        firstNameInputField.sendKeys(firstName);
    }

    public String getFirstNameFromInputField(){
        return firstNameInputField.getAttribute("value");
    }



}
