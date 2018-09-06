package com.cloud.cms.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends AbstractPage {

    public static final String BACK_TO_LOGIN_PAGE_ID_LOCATOR = "backToSingIn";
    public static final String FIRST_NAME_FIELD_NAME_LOCATOR = "FirstName";
    public static final String LAST_NAME_FIELD_NAME_LOCATOR = "LastName";
    public static final String COMPANY_FIELD_NAME_LOCATOR = "Company";
    public static final String USE_CMS_FIELD_NAME_LOCATOR = "UseCMS";
    public static final String PHONE_NUMBER_FIELD_NAME_LOCATOR = "PhoneNumber";
    public static final String COMMENT_FIELD_NAME_LOCATOR = "Comment";
    public static final String EMAIL_FIELD_NAME_LOCATOR = "Email";
    public static final String PASSWORD_FIELD_NAME_LOCATOR = "Password";
    public static final String CONFIRM_PASSWORD_FIELD_NAME_LOCATOR = "ConfirmPassword";
    public static final String SUBMIT_BUTTON_ID_LOCATOR = "reg";


    @FindBy(how = How.NAME, using = FIRST_NAME_FIELD_NAME_LOCATOR)
    private WebElement firstNameInputField;

    @FindBy(how = How.NAME, using = LAST_NAME_FIELD_NAME_LOCATOR)
    private WebElement lastNameInputField;

    @FindBy(how = How.NAME, using = COMPANY_FIELD_NAME_LOCATOR)
    private WebElement companyInputField;

    @FindBy(how = How.NAME, using = USE_CMS_FIELD_NAME_LOCATOR)
    private WebElement checkBoxUseCms;

    @FindBy(how = How.NAME, using = PHONE_NUMBER_FIELD_NAME_LOCATOR)
    private WebElement phoneInputField;

    @FindBy(how = How.NAME, using = COMMENT_FIELD_NAME_LOCATOR)
    private WebElement commentInputField;

    @FindBy(how = How.NAME, using = EMAIL_FIELD_NAME_LOCATOR)
    private WebElement eMailInputField;

    @FindBy(how = How.NAME, using = PASSWORD_FIELD_NAME_LOCATOR)
    private WebElement passwordInputField;

    @FindBy(how = How.NAME, using = CONFIRM_PASSWORD_FIELD_NAME_LOCATOR)
    private WebElement confirmPasswordInputField;

    @FindBy(how = How.ID, using = BACK_TO_LOGIN_PAGE_ID_LOCATOR)
    private WebElement backToLoginPageButton;

    @FindBy(how = How.ID, using = SUBMIT_BUTTON_ID_LOCATOR)
    private WebElement submitButton;

    public RegisterPage setFirstName(String firstName){
        firstNameInputField.click();
        firstNameInputField.sendKeys(firstName);
        return this;
    }

    public RegisterPage setLastName(String lastName){
        lastNameInputField.click();
        lastNameInputField.sendKeys(lastName);
        return this;
    }

    public RegisterPage setCompanyName(String companyName){
        commentInputField.sendKeys(companyName);
        return this;
    }

    public RegisterPage setPhoneNumber(String phoneNumber){
        phoneInputField.sendKeys(phoneNumber);
        return this;
    }

    public RegisterPage setEmailAddress(String address){
        eMailInputField.click();
        eMailInputField.sendKeys(address);
        return this;
    }

    public RegisterPage setPassword(String password){
        passwordInputField.click();
        passwordInputField.sendKeys(password);
        return this;
    }

    public RegisterPage setConfirmPassword(String confirmPassword){
        confirmPasswordInputField.click();
        confirmPasswordInputField.sendKeys(confirmPassword);
        return this;
    }

    public RegisterPage setCommentField (String commentField){
        commentInputField.sendKeys(commentField);
        return this;
    }

    public RegisterPage checkBoxUseCmsClick(){
        checkBoxUseCms.click();
        return this;
    }

    public RegisterPage backToLoginPageButtonClick(){
        backToLoginPageButton.click();
        return this;
    }

    public Boolean submitButtonClick(){
        if (submitButton.getAttribute("class").contains("disabled"))
            return true;
        submitButton.click();
        return false;
    }

    public boolean isErrorExist(String nameLocatorOfWebElement){
        String errorLocator = "//input[@name='"+nameLocatorOfWebElement+"']/following-sibling::*//li";
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(errorLocator)));
            return true;
        }
        catch (NullPointerException e){
             return false;
        }
    }






}
