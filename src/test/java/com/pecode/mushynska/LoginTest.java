package com.pecode.mushynska;

import com.pecode.mushynska.pages.LoginPage;
import com.pecode.mushynska.utils.TestRunner;
import io.qameta.allure.Description;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.pecode.mushynska.utils.PropertyUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends TestRunner {

    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver);
    }

    @Description("Verify that all the elements are present on the page")
    @Test
    public void verifyThatAllTheElementsArePresentOnThePage() {
        SoftAssertions softAssert = new SoftAssertions();

        softAssert.assertThat(loginPage.isUsernameInputFieldDisplayed())
                .as("The username field should be present on the page")
                .isTrue();

        softAssert.assertThat(loginPage.isPasswordInputFieldDisplayed())
                .as("The password field should be present on the page")
                .isTrue();

        softAssert.assertThat(loginPage.isLoginButtonDisplayed())
                .as("The login button should be present on the page")
                .isTrue();

        softAssert.assertThat(loginPage.isCenterNameDisplayed())
                .as("The center name should be present on the page")
                .isTrue();

        softAssert.assertThat(loginPage.isLogoDisplayed())
                .as("The logo should be present on the page")
                .isTrue();
        softAssert.assertAll();
    }

    @Description("Verify that error messages appear when we try to login with empty password and username fields")
    @Test
    public void verifyErrorMessagesWithEmptyPasswordAndUsernameFields() {
        loginPage.login("", "");

        assertThat(loginPage.getUserNameErrorText())
                .as("If the username field is empty, the error message should be equal to expected")
                .isEqualTo("Please enter username.");

        assertThat(loginPage.getPasswordErrorText())
                .as("If the password field is empty, the error message should be equal to expected")
                .isEqualTo("Please enter your password.");
    }

    @Description("Verify that an error message appears when a user tries to login with invalid credentials")
    @Test
    public void verifyErrorMessageWithNonValidCredentials() {
        loginPage.login(getInvalidUsername(), getInvalidPassword());

        assertThat(loginPage.getUserNameErrorText())
                .as("The error message should be equal to expected if a user tries to log in with invalid credentials")
                .isEqualTo("No account found with that username.");
    }

    @Description("Verify that error message is displayed if password field is empty and username field is filled")
    @Test
    public void verifyErrorMessageIfPasswordFieldIsEmpty() {
        loginPage.login(getUsername(), "");

        assertThat(loginPage.getPasswordErrorText())
                .as("The error message should be equal to expected if the password field is empty")
                .isEqualTo("Please enter your password.");
    }

    @Description("Verify the error message if the username field is empty and the password field is filled")
    @Test
    public void verifyErrorMessageIfUserNameFieldIsEmpty() {
        loginPage.login("", getPassword());

        assertThat(loginPage.getUserNameErrorText())
                .as("The error message should be equal to expected if the username field is empty")
                .isEqualTo("Please enter username.");
    }

    // According to point 6 of the task, this test will fail
    @Description("Verify that login is successful")
    @Test
    public void verifyThatLoginIsSuccessful() {
        loginPage.login(getUsername(), getPassword());
        assertThat(loginPage.isUserNameErrorPresent())
                .as("Error message shouldn't be displayed if the login is successful")
                .isFalse();
    }
}
