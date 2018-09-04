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

    @Test
    public void openRegisterPageTest(){
        Assert.assertEquals("http://46.164.136.78/auth/register", driver.getCurrentUrl());
    }

    @Test
    public void setFirstNameTest(){
        String firstName = "Bogdan";
        registerPage.setFirstName(firstName);
        Assert.assertEquals(firstName,registerPage.getFirstNameFromInputField());
    }

    //TODO:how correct make assert
    @Test
    public void submitRegisterFormWithMandatoryFieldFilled(){
        registerPage.setFirstName("FirstName")
                .setLastName("LastName")
                .setEmailAddress("testadrress@cmscloud.com")
                .setPassword("11111111")
                .setConfirmPassword("11111111")
                .submitButtonClick();
        Assert.assertTrue(driver.getCurrentUrl().contains("Error"));
    }
}
