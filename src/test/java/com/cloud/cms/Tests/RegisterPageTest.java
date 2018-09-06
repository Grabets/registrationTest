package com.cloud.cms.Tests;

import com.cloud.cms.UI.HomePage;
import com.cloud.cms.UI.LoginPage;
import com.cloud.cms.UI.RegisterPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest{

    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @BeforeMethod
    public void registerPageTestSetUp(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        HomePage.init(driver);
        loginPage = homePage.loginPageClick();

        registerPage = loginPage.signUpButtonClick();
    }

    @Test (description = "Verify that registration form is available (TS1-1)")
    public void openRegisterPageTest(){
        Assert.assertEquals("http://46.164.136.78/auth/register", driver.getCurrentUrl());
    }

    @Test (description = "Verify submission of registration form if all mandatory fields are filled (TS1-2)")
    public void submitRegisterFormWithMandatoryFieldFilled(){
        registerPage.setFirstName("FirstName")
                .setLastName("LastName")
                .setEmailAddress("testadrress@cmscloud.com")
                .setPassword("11111111")
                .setConfirmPassword("11111111")
                .submitButtonClick();
        Assert.assertTrue(!driver.getCurrentUrl().contains("Error"), "Check success of registration");
    }

    @Test (description = "Verify submission of registration form if all fields are filled (TS1-3)")
    public void submitRegisterFormWithAllFieldFilled(){
        registerPage.setFirstName("FirstName")
                .setLastName("LastName")
                .setEmailAddress("testadrress@cmscloud.com")
                .setPassword("11111111")
                .setConfirmPassword("11111111")
                .setCompanyName("Cmscloud")
                .setPhoneNumber("+380611111111")
                .setCommentField("comment")
                .submitButtonClick();
        Assert.assertTrue(!driver.getCurrentUrl().contains("Error"), "Check success of registration");
    }

    @Test (description = "Verify submission of registration form if all mandatory fields aren't filled (TS1-4)")
    public void submitBlankForm(){
        Boolean isButtonDisabled = registerPage.submitButtonClick();
        Assert.assertTrue(isButtonDisabled, "Check that button is unclickable");
    }

    @Test (description = "Verify submission of registration form if one mandatory field isn't filled (TS1-5)")
    public void submitRegisterFormIfOneMandatoryFieldNotFilled(){
        registerPage.setFirstName("")
                .setLastName("LastName")
                .setEmailAddress("testadrress@cmscloud.com")
                .setPassword("11111111")
                .setConfirmPassword("11111111");
        Boolean isErrorPresent = registerPage
                    .isErrorExist(RegisterPage.FIRST_NAME_FIELD_NAME_LOCATOR);
        Boolean isButtonDisabled = registerPage.submitButtonClick();
        Assert.assertTrue(isErrorPresent.equals(isButtonDisabled), "Check that error is present and button unclickable");
    }

    @Test (description = "Verify filling of Email field with unvalid email (TS2-2)")
    public void checkFillingEmailFieldWithUnvalidValue(){
        registerPage.setEmailAddress(".")
            .checkBoxUseCmsClick();
        Boolean isErrorPresent = registerPage
                .isErrorExist(RegisterPage.EMAIL_FIELD_NAME_LOCATOR);
        Assert.assertTrue(isErrorPresent, "Unvalid Email address");
    }


}
