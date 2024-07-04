package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
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
    public void openPageById(int id) {
        driver.get(CHANGING_ACCOUNT_PAGE_URL + id);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.urlToBe(CHANGING_ACCOUNT_PAGE_URL + id));
    }
    public boolean pageIsOpen() {
        return driver.findElement(H1_CHANGING_ACCOUNT).isDisplayed();
    }
    @Step("Ввод текста в поле ввода")
    public void inputText(By input, String variableText) {
        driver.findElement(input).clear();
        driver.findElement(input).sendKeys(variableText);
    }
    @Step("Чтение текста из поля ввода")
    public String textFromInput(By input) {
        return driver.findElement(input).getAttribute("value");
    }
    @Step("Параметры аутентификации видны или нет?")
    public boolean authenticationParametersIsDisplayed() {
        return driver.findElement(AUTHENTICATION_PARAMETERS).isDisplayed();
    }
    @Step("Заполнение данных пользователя")
    public void inputAllText(User user) {
        inputText(INPUT_NAME, user.getName());
        inputText(INPUT_LOGIN, user.getLogin());
        inputText(INPUT_PASSWORD, user.getPassword());
    }
    @Step("Нажать на кнопку «Сохранить»")
    public void clickButtonSave() {
        driver.findElement(BUTTON_SAVE).click();
    }
    @Step("Заполнение полей ввода на странице «Изменение аккаунта» и нажатие кнопки «Сохранить»")
    public void enterNewUserDataAndClickSaveButton(User user) {
        inputAllText(user);
        clickButtonSave();
    }
    @Step("Нажать на кнопку «Отмена»")
    public void clickButtonCancel() {
        driver.findElement(BUTTON_CANCEL).click();
    }
    @Step("Появилась ошибка с текстом «The ... field is required.»")
    public String alertIsDisplayedReturnString() {
        return driver.findElement(ALERT).getText();
    }
    @Step("Появилась кнопка закрыть «Х»")
    public boolean alertButtonCloseIsDisplayed() {
        return driver.findElement(BUTTON_X).isDisplayed();
    }
    @Step("Нажать на кнопку «X»")
    public void clickButtonX() {
        driver.findElement(BUTTON_X).click();
    }
    public boolean alertIsNotDisplayed() {
        return assertElementPresent(ALERT);
    }
    private boolean assertElementPresent(By alert) {
        return false;
    }
}
