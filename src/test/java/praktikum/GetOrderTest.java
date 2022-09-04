package praktikum;

import client.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.LoginResponse;
import model.LoginUser;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.*;
import static constant.Constant.*;

public class GetOrderTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    @DisplayName("Получение заказов авторизованным пользователем")
    public void getOrdersAuthorizedUser() {
        LoginUser loginObject = Login.createObjectLogin(DEFAULT_EMAIL, DEFAULT_PASSWORD);
        Response responseLoginCourier = User.sendPostRequestAuthLogin(loginObject);
        LoginResponse loginResponse = Login.deserialization(responseLoginCourier);
        String accessToken = loginResponse.getAccessToken();

        Response responseGetOrder = Order.sendGetRequestOrders(accessToken);
        Checks.checkExpectedResult(responseGetOrder, SC_OK, EXPECTED_RESULT_TRUE);
    }

    @Test
    @DisplayName("Получение заказов неавторизованным пользователем")
    public void tryGetOrdersUnauthorizedUser() {
        Response responseGetOrder = Order.sendGetRequestOrders(EMPTY_ACCESS_TOKEN);
        Checks.checkExpectedResult(responseGetOrder, SC_UNAUTHORIZED, EXPECTED_RESULT_FALSE);
    }
}
