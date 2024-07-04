package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static pages.CommonLocatorsUrls.*;

public class DeletingAccountPage {
    private final WebDriver driver;

    public DeletingAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean pageIsOpen(int id) {
        openPageById(id);
        return driver.findElement(H1_DELETING_ACCOUNT).isDisplayed();
    }
    @Step("Открываем страницу «Удаление аккаунта»")
    public void openPageById(int id) {
        driver.get(DELETING_ACCOUNT_PAGE_URL + id);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.
                urlToBe(DELETING_ACCOUNT_PAGE_URL + id));
    }
    @Step("Нажать на кнопку «Отмена»")
    public void clickButtonCancel() {
        driver.findElement(BUTTON_CANCEL).click();
    }
    @Step("Нажать на кнопку «Удалить»")
    public void clickButtonDelete() {
        driver.findElement(BUTTON_DELETE).click();
    }
}
