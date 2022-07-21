package uitest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.*;
import utils.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidDataLoginFormTest extends TestRunner {

    private LoginFormPage loginFormPage = new LoginFormPage();

    @DataProvider
    public Object[][] requiredData() {
        return new Object[][]{
                {"+38 (099) 788-05-30", "13603084", "Віталій"}};
    }

    @Test(dataProvider = "requiredData")
    public void validDataTest(String phoneNumber, String password, String userName) {

        loginFormPage.goToLoginForm();
        loginFormPage.inputValidPhoneNumber(phoneNumber);
        loginFormPage.inputValidPassword(password);
        loginFormPage.Login();

        assertThat(loginFormPage.getUserName())
                .as("Invalid user name")
                .isEqualTo(userName);

    }
}