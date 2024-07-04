package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import usermodel.User;

import java.time.Duration;

import static pages.CommonLocatorsUrls.*;

public class ChangingAccountPage {
    private final WebDriver driver;

    public ChangingAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открываем главную страницу")
    public void waitOpenPage() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.urlToBe(CHANGING_ACCOUNT_PAGE_URL));
    }
    public boolean pageIsOpen() {
        return driver.findElement(H1_CHANGING_ACCOUNT).isDisplayed();
    }
    @Step("Ввод текста в поле ввода")
    public void inputText(By input, String variableText) {
        driver.findElement(input).clear();
        driver.findElement(input).sendKeys(variableText);
        driver.findElement(input).sendKeys(Keys.TAB);
    }
    @Step("Чтение текста из поля ввода")
    public String textFromInput(By input) {
        return driver.findElement(input).getAttribute("value");
    }
    @Step("Параметры аутентификации видны или нет?")
    public boolean authenticationParametersIsDisplayed() {
        return driver.findElement(AUTHENTICATION_PARAMETERS).isDisplayed();
    }
    @Step("Поле ввода «user» под «Параметры аутентификации» видно?")
    public boolean inputGoogleUserIsDisplayed() {
        return driver.findElement(INPUT_GOOGLE_USER).isDisplayed();
    }
    @Step("Поле ввода «token» под «Параметры аутентификации» видно?")
    public boolean inputYandexTokenIsDisplayed() {
        return driver.findElement(INPUT_YANDEX_TOKEN).isDisplayed();
    }
    @Step("Поля ввода «Username» и «Password» под «Параметры аутентификации» видно?")
    public boolean inputBrioUsernameAndPasswordIsDisplayed() {
        return driver.findElement(INPUT_BRIO_USERNAME).isDisplayed()&driver.findElement(INPUT_BRIO_USERNAME).isDisplayed();
    }
    @Step("Заполнение данных пользователя")
    public void InputAllText(User user) {
        inputText(INPUT_NAME, user.getName());
        inputText(INPUT_LOGIN, user.getLogin());
        inputText(INPUT_PASSWORD, user.getPassword());
    }
    @Step("Нажать на кнопку «Сохранить»")
    public void clickButtonSave() {
        driver.findElement(BUTTON_SAVE).click();
    }
    @Step("Заполнение полей ввода на странице «Изменение аккаунта» и нажатие кнопки «Сохранить»")
    public void enterRegistrationDataAndClickCreateButton(User user) {
        InputAllText(user);
        clickButtonSave();
    }
    @Step("Нажать на кнопку «Отмена»")
    public void clickButtonCancel() {
        driver.findElement(BUTTON_CANCEL).click();
    }
}
