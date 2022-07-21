package uitest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.*;
import utils.*;

import static org.assertj.core.api.Assertions.assertThat;

public class InvalidPasswordLoginFormTest extends TestRunner {

    private LoginFormPage loginFormPage = new LoginFormPage();

    @DataProvider
    public Object[][] invalidPass() {
        return new Object[][]{
                {"+38 (099) 788-05-30", "12345678", "Некоректний пароль"}};
    }

    @Test(dataProvider = "invalidPass")
    public void invalidPasswordTest(String phoneNumber, String password, String passError) {

        loginFormPage.goToLoginForm();
        loginFormPage.inputInvalidPhoneNumber(phoneNumber);
        loginFormPage.inputInvalidPassword(password);
        loginFormPage.Login();

        assertThat(loginFormPage.getPasswordError()).contains(passError);

    }
}