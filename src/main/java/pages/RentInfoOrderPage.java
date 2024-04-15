package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentInfoOrderPage {
    private WebDriver driver;

    private By date = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By rentalPeriod = By.xpath("//div[@class='Dropdown-placeholder']");
    private By twoDays = By.xpath("(//div[@role='option'])[2]");
    private By blackScooter = By.xpath("//label[@for='black']");
    private By orderButton = By.xpath("(//button[text()='Заказать'])[2]");
    private By yesButton = By.xpath("//button[text()='Да']");
    private By orderDoneText = By.xpath("//div[text()='Заказ оформлен']");
    private By seeOrderButton = By.xpath("//button[text()='Посмотреть статус']");
    private By orderStatus = By.xpath("//div[text()='Самокат на складе']");

    public RentInfoOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Установка даты
    public void setDate(String datee) {
        WebElement inputDate = driver.findElement(date);
        if (inputDate.isDisplayed()) {
            inputDate.sendKeys(datee);
        } else {
            System.out.println("Поле Дата не доступна");
        }
        driver.findElement(date).sendKeys(Keys.ENTER);
    }

    //Выбор срока аренды
    public void setRentalPeriod() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(twoDays).click();
    }

    //выбор черного скутера чекбоксом
    public void setBlackScooter() {
        WebElement checBox = driver.findElement(blackScooter);
        if (checBox.isEnabled() && !checBox.isSelected()) {
            checBox.click();
        } else {
            System.out.println("Чекбокс выбора цвета не доступен");
        }
    }

    //нажать на "Заказать"
    public void clickOrderButton() {
        WebElement elementOrderButton = driver.findElement(orderButton);
        if (elementOrderButton.isEnabled() && elementOrderButton.getText().equals("Заказать")) {
            elementOrderButton.click();
        } else {
            System.out.println("Кнопка Заказать недоступна");
        }
    }

    //нажать на "Да"
    public void clickYesButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(yesButton)).click();
    }

    //получение текста заказ оформлен
    public void getOrderDoneText() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(orderDoneText));
    }

    //Клик по кнопке "Посомотреть заказ"
    public void clickSeeOrderButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(seeOrderButton)).click();
    }

    //Проверка статуса
    public void checkOrderStatus() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(orderStatus));
    }

    public void makeOrder(String date) {
        setDate(date);
        setRentalPeriod();
        setBlackScooter();
        clickOrderButton();
        clickYesButton();
        getOrderDoneText();
        clickSeeOrderButton();
        checkOrderStatus();
    }
}
