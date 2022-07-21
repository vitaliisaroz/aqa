package uitest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.*;
import utils.*;

import static org.assertj.core.api.Assertions.assertThat;

public class InvalidPhoneLoginFormTest extends TestRunner {

    private LoginFormPage loginFormPage = new LoginFormPage();

    @DataProvider
    public Object[][] invalidPhone() {
        return new Object[][]{
                {"+38 (005) 000-00-00", "13603084", "Некоректний телефон"}};
    }

    @Test(dataProvider = "invalidPhone")
    public void invalidPhoneNumberTest(String phoneNumber, String password, String phoneError) {

        loginFormPage.goToLoginForm();
        loginFormPage.inputInvalidPhoneNumber(phoneNumber);
        loginFormPage.inputInvalidPassword(password);
        loginFormPage.Login();

        assertThat(loginFormPage.getPhoneNumberError()).contains(phoneError);

    }
}