package com.pecode.mushynska.pages;

import com.pecode.mushynska.pages.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    private WebElement usernameInputField;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    private WebElement passwordInputField;

    @FindBy(how = How.XPATH, using = "//input[@class='btn btn-success']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//input[@name='username']/following-sibling::span[@class='help-block']")
    private WebElement usernameFieldErrorMessage;

    @FindBy(how = How.XPATH, using = "//input[@name='password']/following-sibling::span[@class='help-block']")
    private WebElement passwordFieldErrorMessage;

    @FindBy(how = How.XPATH, using = "//center/h1")
    private WebElement centerName;

    @FindBy(how = How.XPATH, using = "//img[@id='logomini']")
    private WebElement logo;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @Step("Login with credentials")
    public void login(String userName, String password) {
        usernameInputField.sendKeys(userName);
        passwordInputField.sendKeys(password);
        loginButton.click();
    }

    public String getUserNameErrorText() {
        return usernameFieldErrorMessage.getText();
    }

    public String getPasswordErrorText() {
        return passwordFieldErrorMessage.getText();
    }

    public boolean isUsernameInputFieldDisplayed() {
        try {
            return usernameInputField.isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    public boolean isPasswordInputFieldDisplayed() {
        try {
            return passwordInputField.isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    public boolean isLoginButtonDisplayed() {
        try {
            return loginButton.isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    public boolean isCenterNameDisplayed() {
        try {
            return centerName.isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    public boolean isLogoDisplayed() {
        try {
            return logo.isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    public boolean isUserNameErrorPresent() {
        return usernameFieldErrorMessage.getText().length() > 0;
    }
}
