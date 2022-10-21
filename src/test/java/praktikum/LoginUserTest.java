package praktikum;

import client.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.LoginUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.*;
import static constant.Constant.*;

public class LoginUserTest {
    private String password = RandomStringUtils.randomNumeric(4);

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    @DisplayName("Логин под существующим пользователем")
    public void successfulLogin() {
        LoginUser login = Login.createObjectLogin(DEFAULT_EMAIL, DEFAULT_PASSWORD);
        Response response = User.sendPostRequestAuthLogin(login);
        Checks.checkExpectedResult(response, SC_OK, EXPECTED_RESULT_TRUE);
    }

    @Test
    @DisplayName("Логин с неверным паролем")
    public void loginWithWrongEmail() {
        LoginUser loginCourier = Login.createObjectLogin(DEFAULT_EMAIL, password);
        Response response = User.sendPostRequestAuthLogin(loginCourier);
        Checks.checkErrorMessage(response, SC_UNAUTHORIZED, EXPECTED_RESULT_FALSE, INCORRECT_FIELDS);
    }
}
