package com.cloud.cms.UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends AbstractPage {

    public static final String BACK_TO_LOGIN_PAGE_ID_LOCATOR = "backToSingIn";

    @FindBy(how = How.NAME, using = "FirstName")
    private WebElement firstNameInputField;

    @FindBy(how = How.NAME, using = "LastName")
    private WebElement lastNameInputField;

    @FindBy(how = How.NAME, using = "Company")
    private WebElement companyInputField;

    @FindBy(how = How.NAME, using = "UseCMS")
    private WebElement checkBoxUseCms;

    @FindBy(how = How.NAME, using = "PhoneNumber")
    private WebElement phoneInputField;

    @FindBy(how = How.NAME, using = "Comment")
    private WebElement commentInputField;

    @FindBy(how = How.NAME, using = "Email")
    private WebElement eMailInputField;

    @FindBy(how = How.NAME, using = "Password")
    private WebElement passwordInputField;

    @FindBy(how = How.NAME, using = "ConfirmPassword")
    private WebElement confirmPasswordInputField;

    @FindBy(how = How.ID, using = BACK_TO_LOGIN_PAGE_ID_LOCATOR)
    private WebElement backToLoginPageButton;

    @FindBy(how = How.ID, using = "reg")
    private WebElement submitButton;

    public RegisterPage setFirstName(String firstName){
        firstNameInputField.sendKeys(firstName);
        return this;
    }

    public RegisterPage setLastName(String lastName){
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
        eMailInputField.sendKeys(address);
        return this;
    }

    public RegisterPage setPassword(String password){
        passwordInputField.sendKeys(password);
        return this;
    }

    public RegisterPage setConfirmPassword(String confirmPassword){
        confirmPasswordInputField.sendKeys(confirmPassword);
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

    public RegisterPage submitButtonClick(){
        submitButton.click();
        return this;
    }

    public String getFirstNameFromInputField(){
        return firstNameInputField.getAttribute("value");
    }






}
