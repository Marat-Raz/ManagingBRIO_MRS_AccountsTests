import client.UserClient;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountManagementPage;
import pages.DeletingAccountPage;
import usermodel.User;
import usermodel.UserGenerator;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeletingAccountPageTests extends StartTest {
    private AccountManagementPage accountManagementPage;
    private DeletingAccountPage deletingAccountPage;
    @BeforeEach
    @Step("Открытие страницы «Удаление аккаунта»")
    public void setUpChangingAccountPage()   {
        deletingAccountPage = new DeletingAccountPage(driver);
        deletingAccountPage.openPageById(id);
    }
    @Test
    @DisplayName("Страница «Удаление аккаунта» открыта?")
    public void deleteAccountPageIsOpen() {
        User newUser = UserGenerator.getNewUser();
        userClient = new UserClient();
        response = userClient.createUser(newUser);
        int idNew = response.extract().path("id");
        assertTrue(deletingAccountPage.pageIsOpen(idNew));
        userClient.deleteUser(idNew);
    }
    @Test
    @DisplayName("Нажать на кнопку «Отмена»")
    public void clickCancelButtonTest() {
        User newUser = UserGenerator.getNewUser();
        userClient = new UserClient();
        response = userClient.createUser(newUser);
        int idNew = response.extract().path("id");
        deletingAccountPage.pageIsOpen(idNew);
        deletingAccountPage.clickButtonCancel();
        accountManagementPage = new AccountManagementPage(driver);
        assertTrue(accountManagementPage.pageIsOpen());
        userClient.deleteUser(idNew);
    }
    @Test
    @DisplayName("Нажать на кнопку «Удалить»")
    public void clickDeleteButtonTest() {
        deletingAccountPage.clickButtonDelete();
        accountManagementPage = new AccountManagementPage(driver);
        assertTrue(accountManagementPage.pageIsOpen());
        ValidatableResponse getResponse = userClient.getUserById(id);
        int statusCode = getResponse.extract().statusCode();
        String title = getResponse.extract().path("title");
        assertEquals(SC_NOT_FOUND, statusCode);
        assertEquals("Could not find requested user", title, "Что то пошло не так");
    }

}
