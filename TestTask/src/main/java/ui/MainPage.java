package ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginFormPage {

    private final SelenideElement gmailButton = $x("//a[@class='gb_d' and contains(text(), (\"Gmail\"))]");
    private final SelenideElement signInButton = $x("//a[@data-action='sign in']");
    private final SelenideElement emailInput = $x("//input[@type='email']");
    private final SelenideElement nextButtonForEmail = $x("//div[@id='identifierNext']");
    private final SelenideElement nextButtonForPassword = $x("//div[@id='passwordNext']");
    private final SelenideElement passwordInput = $x("//input[@type='password']");
    private final SelenideElement searchFieldInput = $x("//div[@class='gb_tf gb_nf']");
    private final SelenideElement accountLogoButton = $x("//img[@class='gb_Ba gbii']");

    @Step("Click on login button")
    public void goToLoginForm() {
        gmailButton.click();
        signInButton.click();
    }

    @Step("Entering a valid email")
    public void inputValidEmail(String email) {
        emailInput.sendKeys(email);
        nextButtonForEmail.click();
    }

    @Step("Entering a valid password")
    public void inputValidPassword(String password) {
        passwordInput.sendKeys(password);
        nextButtonForPassword.click();
    }

    @Step("Getting text from a search field")
    public String getTextFromSearchField() {
        return searchFieldInput
                .getText()
                .trim();
    }

    @Step("Exiting from Google account")
    public void exitFromAccount() {
        accountLogoButton.click();
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