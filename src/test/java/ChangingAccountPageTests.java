import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountManagementPage;
import pages.ChangingAccountPage;

import static org.junit.jupiter.api.Assertions.*;
import static pages.CommonLocatorsUrls.*;

public class ChangingAccountPageTests extends StartTest {
    private AccountManagementPage accountManagementPage;
    String actText;
    private static ChangingAccountPage changingAccountPage;

    @BeforeEach
    @Step("Открытие страницы «Изменение аккаунта»")
    public void setUpChangingAccountPage()   {
        changingAccountPage = new ChangingAccountPage(driver);
        changingAccountPage.openPageById(id);
    }

    @Test
    @DisplayName("Страница «Изменение аккаунта» открыта?")
    public void changingAccountPageIsOpen() {
        assertTrue(changingAccountPage.pageIsOpen());
    }
    @Test
    @DisplayName("Ввести текст в поле «Имя пользователя»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-707")
    public void enterTextInUsernameFieldTest() {
        changingAccountPage.inputText(INPUT_NAME, TEXT_TO_ENTER_INPUT);
        actText = changingAccountPage.textFromInput(INPUT_NAME);
            assertEquals(TEXT_TO_ENTER_INPUT, actText, "Ошибка! Отображаемый текст не соответствует введенному");
    }
    @Test
    @DisplayName("Ввести текст в поле «Логин»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-707")
    public void enterTextInLoginFieldTest() {
        changingAccountPage.inputText(INPUT_LOGIN, TEXT_TO_ENTER_INPUT);
        actText = changingAccountPage.textFromInput(INPUT_LOGIN);
            assertEquals(EXP_TEXT, actText, "Ошибка! Отображаемый текст не соответствует ожидаемому");
    }
    @Test
    @DisplayName("Ввести текст в поле «Пароль»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-707")
    public void enterTextInPasswordFieldTest() {
        changingAccountPage.inputText(INPUT_PASSWORD, TEXT_TO_ENTER_INPUT);
        actText = changingAccountPage.textFromInput(INPUT_PASSWORD);
            assertNotEquals(TEXT_TO_ENTER_INPUT, actText, "Что-то не то");
            assertEquals(EXP_TEXT, actText, "Ошибка! Отображаемый текст не соответствует ожидаемому");
    }
    @Test
    @DisplayName("Ввод пробела в поле ввода «Имя пользователя»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1303")
    public void enterWhitespaceInUsernameFieldAndClickCreateTest() {
        changingAccountPage.inputText(INPUT_NAME, " ");
        changingAccountPage.inputText(INPUT_LOGIN, TEXT_TO_ENTER_INPUT);
        changingAccountPage.inputText(INPUT_PASSWORD, TEXT_TO_ENTER_INPUT);
        changingAccountPage.clickButtonSave();
        actText = changingAccountPage.alertIsDisplayedReturnString();
            assertEquals("The Name field is required.", actText,
                "Ошибка! Отображаемый текст не соответствует ожидаемому");
            assertTrue(changingAccountPage.alertButtonCloseIsDisplayed(),
                    "Ошибка! Кнопка отсутствует");
    }
    @Test
    @DisplayName("Ввод пробела в поле «Логин»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-710")
    public void enterWhitespaceInLoginFieldAndClickCreateTest() {
        changingAccountPage.inputText(INPUT_NAME, TEXT_TO_ENTER_INPUT);
        changingAccountPage.inputText(INPUT_LOGIN, " ");
        changingAccountPage.inputText(INPUT_PASSWORD, TEXT_TO_ENTER_INPUT);
        changingAccountPage.clickButtonSave();
        actText = changingAccountPage.alertIsDisplayedReturnString();
            assertEquals("The Login field is required.", actText,
                "Ошибка! Отображаемый текст не соответствует ожидаемому");
            assertTrue(changingAccountPage.alertButtonCloseIsDisplayed(),
                "Ошибка! Кнопка отсутствует");
    }
    @Test
    @DisplayName("Ввод двух символов в поле «Логин»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-704")
    public void enterЕwoСharactersInLoginFieldAndClickCreateTest() {
        changingAccountPage.inputText(INPUT_NAME, TEXT_TO_ENTER_INPUT);
        changingAccountPage.inputText(INPUT_LOGIN, "ab");
        changingAccountPage.inputText(INPUT_PASSWORD, TEXT_TO_ENTER_INPUT);
        changingAccountPage.clickButtonSave();
        actText = changingAccountPage.alertIsDisplayedReturnString();
            assertEquals("The field Login must be a string with a minimum length of 3 and a maximum length of 60.",
                actText,
                "Ошибка! Отображаемый текст не соответствует ожидаемому");
            assertTrue(changingAccountPage.alertButtonCloseIsDisplayed(),
                "Ошибка! Кнопка отсутствует");
    }
    @Test
    @DisplayName("Ввод пробела в поле «Пароль»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-711")
    public void enterWhitespaceInPasswordFieldAndClickCreateTest() {
        changingAccountPage.inputText(INPUT_NAME, TEXT_TO_ENTER_INPUT);
        changingAccountPage.inputText(INPUT_LOGIN, TEXT_TO_ENTER_INPUT);
        changingAccountPage.inputText(INPUT_PASSWORD, " ");
        changingAccountPage.clickButtonSave();
        actText = changingAccountPage.alertIsDisplayedReturnString();
            assertEquals("The Password field is required.", actText,
                "Ошибка! Отображаемый текст не соответствует ожидаемому");
            assertTrue(changingAccountPage.alertButtonCloseIsDisplayed(),
                    "Ошибка! Кнопка отсутствует");
    }
    @Test
    @DisplayName("Нажать на кнопку «Отмена»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-712")
    public void clickCancelButtonTest() {
        changingAccountPage.clickButtonCancel();
        accountManagementPage = new AccountManagementPage(driver);
        accountManagementPage.waitOpenPage();
            assertTrue(accountManagementPage.pageIsOpen());
    }
    @Test
    @DisplayName("Нажать на кнопку «X»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-715")
    public void clickXButtonTest() {
        changingAccountPage.inputText(INPUT_NAME, " ");
        changingAccountPage.clickButtonSave();
        changingAccountPage.clickButtonX();
            assertFalse(changingAccountPage.alertIsNotDisplayed(), "Ошибка!");
    }
    @Test
    @DisplayName("Изменение аккаунта и нажать на кнопку «Сохранить»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-708")
    public void creatingNewAccountTest() {
        changingAccountPage.enterNewUserDataAndClickSaveButton(user);
        accountManagementPage = new AccountManagementPage(driver);
        accountManagementPage.waitOpenPage();
            assertTrue(accountManagementPage.pageIsOpen());
            assertTrue(accountManagementPage.findLogin(user.getLogin()));
    }
}
