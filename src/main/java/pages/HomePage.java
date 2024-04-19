package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.apache.hc.core5.util.Timeout.ofSeconds;

public class HomePage {

    private WebDriver driver;

    //локаторы стр HomePage
    private By headerLogo = By.className("Home_Header__iJKdX");

    private By subHeader = By.xpath("(//div[@class='Home_SubHeader__zwi_E'])[4]");

    private By orderButton1 = By.xpath("(//button[text()='Заказать'])[1]");

    private By orderButton2 = By.xpath("(//button[text()='Заказать'])[2]");
    private By cookieButton = By.id("rcc-confirm-button");

    private final String qusetionLocator = "accordion__heading-%s";
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";

    // конструктор класса
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания заголовка
    public void waitForHeader() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(headerLogo));
    }

    //метод получения субхедр
    public void getSubHeaderText() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(subHeader));
    }

    //метод клика 1-кнопки "Заказать"
    public void clickOrderButton1() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(orderButton1));
        driver.findElement(orderButton1).click();
    }

    //метод клика 2-кнопки "Заказать"
    public void clickOrderButton2() {
        WebElement element = driver.findElement(orderButton2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(orderButton2));
        driver.findElement(orderButton2).click();
    }

    public void closeCookiesWindow() {
        driver.findElement(cookieButton).click();
    }

    public void expandQuestion(int index) {
        WebElement element = driver.findElement(By.id(String.format(qusetionLocator, index)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean answerIsDisplayed(String expectedAnswer) {
        WebElement element = driver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return element.isDisplayed();
    }
}
