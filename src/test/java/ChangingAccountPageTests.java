import client.UserClient;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AccountManagementPage;
import pages.ChangingAccountPage;
import pages.CreatingNewAccountPage;

public class ChangingAccountPageTests extends StartTest {
    private AccountManagementPage accountManagementPage;
    String actText;
    private static ChangingAccountPage changingAccountPage;

    @BeforeEach
    @Step("Создание пользователя для тестов и открытие страницы «Изменение аккаунта»")
    public void setUpChangingAccountPage()   {
        changingAccountPage = new ChangingAccountPage(driver);
        changingAccountPage.openPageById(id);
    }

    @Test
    public void firstTest() {
        changingAccountPage.clickButtonSave();
    }



}
