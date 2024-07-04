import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountManagementPage;
import pages.CreatingNewAccountPage;

import static org.junit.jupiter.api.Assertions.*;
import static pages.CommonLocatorsUrls.*;

public class CreatingNewAccountPageTest extends StartTest {
    private AccountManagementPage accountManagementPage;
    private CreatingNewAccountPage creatingNewAccountPage;
    String actText;

    @BeforeEach
    @Step("Открытие страницы «Управление аккаунтами BRIO MRS»")
    public void setUpCreatingNewAccountPage() {
        accountManagementPage = new AccountManagementPage(driver);
        accountManagementPage.waitOpenPage();
        accountManagementPage.clickAddUser();
        creatingNewAccountPage = new CreatingNewAccountPage(driver);
    }

    @Test
    @DisplayName("Выбрать тип аккаунта «Локальный»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-697")
    public void selectAccountTypeLocalTest() {
        actText = creatingNewAccountPage.selectTextIsSelected("Локальный");
            assertEquals("Локальный", actText, "Ошибка! Выбранный текст не соответствует ожидаемому");
    }
    @Test
    @DisplayName("Выбрать тип аккаунта «Google Drive»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-697")
    public void selectAccountTypeGoogleTest() throws InterruptedException {
        actText = creatingNewAccountPage.selectTextIsSelected("Google Drive");
        Thread.sleep(300);
            assertEquals("Google Drive", actText, "Ошибка! Выбранный текст не соответствует ожидаемому");
            assertTrue(creatingNewAccountPage.authenticationParametersIsDisplayed(),
                    "Ошибка! «Параметры аутентификации» не видно");
            assertTrue(creatingNewAccountPage.inputGoogleUserIsDisplayed(), "Ошибка! Поле ввода «user» не видно");
    }
    @Test
    @DisplayName("Выбрать тип аккаунта «Yandex Disk»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-697")
    public void selectAccountTypeYandexTest() throws InterruptedException {
        actText = creatingNewAccountPage.selectTextIsSelected("Yandex Disk");
        Thread.sleep(300);
            assertEquals("Yandex Disk", actText, "Ошибка! Выбранный текст не соответствует ожидаемому");
            assertTrue(creatingNewAccountPage.authenticationParametersIsDisplayed(),
                    "Ошибка! «Параметры аутентификации» не видно");
            assertTrue(creatingNewAccountPage.inputYandexTokenIsDisplayed(), "Ошибка! Поле ввода «token» не видно");
    }
    @Test
    @DisplayName("Выбрать тип аккаунта «Brio-Cloud»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-697")
    public void selectAccountTypeBrioCloudTest() {
        actText = creatingNewAccountPage.selectTextIsSelected("Brio-Cloud");
            assertEquals("Brio-Cloud", actText, "Ошибка! Выбранный текст не соответствует ожидаемому");
            //Thread.sleep(1000);
            assertTrue(creatingNewAccountPage.authenticationParametersIsDisplayed(),
                    "Ошибка! «Параметры аутентификации» не видно");
            assertTrue(creatingNewAccountPage.inputBrioUsernameAndPasswordIsDisplayed(),
                    "Ошибка! Поле ввода «Username» и «Password» не видно");
    }
    @Test
    @DisplayName("Ввести текст в поле «Имя пользователя»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-699")
    public void enterTextInUsernameFieldTest() {
        creatingNewAccountPage.inputText(INPUT_NAME, TEXT_TO_ENTER_INPUT);
        actText = creatingNewAccountPage.textFromInput(INPUT_NAME);
            assertEquals(TEXT_TO_ENTER_INPUT, actText, "Ошибка! Отображаемый текст не соответствует введенному");
    }
    @Test
    @DisplayName("Ввести текст в поле «Логин»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-699")
    public void enterTextInLoginFieldTest() {
        creatingNewAccountPage.inputText(INPUT_LOGIN, TEXT_TO_ENTER_INPUT);
        actText = creatingNewAccountPage.textFromInput(INPUT_LOGIN);
            assertEquals(EXP_TEXT, actText, "Ошибка! Отображаемый текст не соответствует ожидаемому");
    }
    @Test
    @DisplayName("Ввести текст в поле «Пароль»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-699")
    public void enterTextInPasswordFieldTest() {
        creatingNewAccountPage.inputText(INPUT_PASSWORD, TEXT_TO_ENTER_INPUT);
        actText = creatingNewAccountPage.textFromInput(INPUT_PASSWORD);
            assertNotEquals(TEXT_TO_ENTER_INPUT, actText, "Что-то не то");
            assertEquals(EXP_TEXT, actText, "Ошибка! Отображаемый текст не соответствует ожидаемому");
    }
    @Test
    @DisplayName("Параметры аутентификации Google Drive")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-700")
    public void enterTextWithAccountGoogleDrive()  {
        creatingNewAccountPage.selectText("Google Drive");
        creatingNewAccountPage.inputText(INPUT_GOOGLE_USER, TEXT_TO_ENTER_INPUT);
        actText = creatingNewAccountPage.textFromInput(INPUT_GOOGLE_USER);
            assertEquals(TEXT_TO_ENTER_INPUT, actText, "Ошибка! Отображаемый текст не соответствует ожидаемому");
    }
    @Test
    @DisplayName("Параметры аутентификации Brio-Cloud")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-701")
    public void enterTextWithAccountBrioCloud() {
        creatingNewAccountPage.selectText("Brio-Cloud");
        creatingNewAccountPage.inputText(INPUT_BRIO_USERNAME, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.inputText(INPUT_BRIO_PASSWORD, TEXT_TO_ENTER_INPUT);
        String actTextUsername = creatingNewAccountPage.textFromInput(INPUT_BRIO_USERNAME);
        String actTextPassword = creatingNewAccountPage.textFromInput(INPUT_BRIO_PASSWORD);
            assertEquals(TEXT_TO_ENTER_INPUT, actTextUsername, "Ошибка! Отображаемый текст не соответствует ожидаемому");
            assertEquals(TEXT_TO_ENTER_INPUT, actTextPassword, "Ошибка! Отображаемый текст не соответствует ожидаемому");
    }
    @Test
    @DisplayName("Параметры аутентификации Yandex Disk")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-702")
    public void enterTextWithAccountYandexDisk() {
        creatingNewAccountPage.selectText("Yandex Disk");
        creatingNewAccountPage.inputText(INPUT_YANDEX_TOKEN, TEXT_TO_ENTER_INPUT);
        actText = creatingNewAccountPage.textFromInput(INPUT_YANDEX_TOKEN);
            assertEquals(TEXT_TO_ENTER_INPUT, actText, "Ошибка! Отображаемый текст не соответствует ожидаемому");
    }
    @Test
     @DisplayName("Ввод пробела в поле ввода «Имя пользователя»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-705")
    public void enterWhitespaceInUsernameFieldAndClickCreateTest() {
        creatingNewAccountPage.selectText("Локальный");
        creatingNewAccountPage.inputText(INPUT_NAME, " ");
        creatingNewAccountPage.inputText(INPUT_LOGIN, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.inputText(INPUT_PASSWORD, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.clickButtonCreate();
        actText = creatingNewAccountPage.alertIsDisplayedReturnString();
            assertEquals("The Name field is required.", actText,
                    "Ошибка! Отображаемый текст не соответствует ожидаемому");
            assertTrue(creatingNewAccountPage.alertButtonCloseIsDisplayed(), "Ошибка! Кнопка отсутствует");
    }
    @Test
    @DisplayName("Ввод пробела в поле «Логин»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-704")
    public void enterWhitespaceInLoginFieldAndClickCreateTest() {
        creatingNewAccountPage.selectText("Локальный");
        creatingNewAccountPage.inputText(INPUT_NAME, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.inputText(INPUT_LOGIN, " ");
        creatingNewAccountPage.inputText(INPUT_PASSWORD, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.clickButtonCreate();
        actText = creatingNewAccountPage.alertIsDisplayedReturnString();
            assertEquals("The Login field is required.", actText,
                    "Ошибка! Отображаемый текст не соответствует ожидаемому");
            assertTrue(creatingNewAccountPage.alertButtonCloseIsDisplayed(), "Ошибка! Кнопка отсутствует");
    }
    @Test
    @DisplayName("Ввод пробела в поле «Пароль»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-703")
    public void enterWhitespaceInPasswordFieldAndClickCreateTest() {
        creatingNewAccountPage.selectText("Локальный");
        creatingNewAccountPage.inputText(INPUT_NAME, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.inputText(INPUT_LOGIN, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.inputText(INPUT_PASSWORD, " ");
        creatingNewAccountPage.clickButtonCreate();
        actText = creatingNewAccountPage.alertIsDisplayedReturnString();
            assertEquals("The Password field is required.", actText,
                    "Ошибка! Отображаемый текст не соответствует ожидаемому");
            assertTrue(creatingNewAccountPage.alertButtonCloseIsDisplayed(), "Ошибка! Кнопка отсутствует");
    }
    @Test
    @DisplayName("Создание нового аккаунта")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-714")
    public void creatingNewAccountTest() {
        creatingNewAccountPage.enterRegistrationDataAndClickCreateButton(user);
        accountManagementPage = new AccountManagementPage(driver);
        accountManagementPage.waitOpenPage();
            assertTrue(accountManagementPage.pageIsOpen());
            assertTrue(accountManagementPage.findLogin(user.getLogin()));

        ValidatableResponse getResponse = userClient.getUserByLogin(user.getLogin());
        int id = getResponse.extract().path("id.id");
        userClient.deleteUser(id);
    }
    @Test
    @DisplayName("Нажать на кнопку «Отмена»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-706")
    public void clickCancelButtonTest() {
        creatingNewAccountPage.clickButtonCancel();
        accountManagementPage = new AccountManagementPage(driver);
        accountManagementPage.waitOpenPage();
            assertTrue(accountManagementPage.pageIsOpen());
    }
    @Test
    @DisplayName("Нажать на кнопку «X»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-715")
    public void clickXButtonTest() {
        creatingNewAccountPage.inputText(INPUT_NAME, " ");
        creatingNewAccountPage.clickButtonCreate();
        creatingNewAccountPage.clickButtonX();
            assertFalse(creatingNewAccountPage.alertIsNotDisplayed(), "Ошибка!");
    }

}
