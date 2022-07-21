package ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginFormPage {

    private final SelenideElement loginButton = $x("//button[@class='auth-popup-button']");
    private final SelenideElement phoneNumberInput = $x("//input[@id='modal-login-phone-field']");
    private final SelenideElement passwordInput = $x("//input[@id='modal-login-password-field']");
    private final SelenideElement submitButton = $x("//button[@class='br-login-submit']");
    private final SelenideElement profileButton = $x("//button[@class='user-panel-button active']");
    private final SelenideElement loginError = $x("//div[@style='display: block;']");

    @Step("Click on login button")
    public void goToLoginForm() {
        loginButton.click();
    }

    @Step("Entering a valid phone number")
    public void inputValidPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
    }

    @Step("Entering a valid password")
    public void inputValidPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Entering a valid phone number")
    public void inputInvalidPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
    }

    @Step("Entering a valid password")
    public void inputInvalidPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Click on submit button")
    public void Login() {
        submitButton.click();
    }

    @Step("Getting a user name after login")
    public String getUserName() {
        return profileButton
                .getText()
                .trim();
    }

    @Step("Getting an error about invalid password")
    public String getPasswordError() {
        return loginError
                .getText()
                .trim();
    }

    @Step("Getting an error about invalid phone number")
    public String getPhoneNumberError() {
        return loginError
                .getText();
    }
}