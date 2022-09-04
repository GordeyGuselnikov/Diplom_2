package constant;

public interface Constant {

    String BASE_URI = "https://stellarburgers.nomoreparties.site";
    boolean EXPECTED_RESULT_TRUE = true;
    boolean EXPECTED_RESULT_FALSE = false;
    String EMPTY_ACCESS_TOKEN = "";
    String[] EMPTY_INGREDIENTS = {};
    String[] INGREDIENTS = {"61c0c5a71d1f82001bdaaa6d", "61c0c5a71d1f82001bdaaa6c", "61c0c5a71d1f82001bdaaa72"};
    String[] INVALID_INGREDIENTS_HASH = {"000", "111", "222"};
    String ALREADY_EXISTS = "User already exists";
    String REQUIRED_FIELDS = "Email, password and name are required fields";
    String DEFAULT_EMAIL = "test-data@yandex.ru";
    String EMPTY_PASSWORD = "";
    String DEFAULT_PASSWORD = "password";
    String INCORRECT_FIELDS = "email or password are incorrect";
}
