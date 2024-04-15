package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    //локаторы стр HomePage
    private By headerLogo = By.className("Home_Header__iJKdX");

    private By subHeader = By.xpath("(//div[@class='Home_SubHeader__zwi_E'])[4]");

    private By firstQuestion = By.xpath("//div[@id='accordion__heading-0']/parent::div");

    private By answerQuestion = By.xpath("(//p)[1]/parent::div");

    private By orderButton1 = By.className("Button_Button__ra12g");

    private By orderButton2 = By.xpath("(//button[text()='Заказать'])[2]");

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

    //метод клика по первому вопросу
    public void clickFirstQuestion() {
        driver.findElement(firstQuestion).click();
    }

    //метод получения текста ответа на вопрос и сравнения результатов
    public void getAnswerQuestion() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(answerQuestion));
        WebElement answerText = driver.findElement(answerQuestion);
        Assert.assertEquals("Ответ неправильный", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", answerText.getText());
    }

    //метод клика 1-кнопки "Заказать"
    public void clickOrderButton1() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(orderButton1));
        driver.findElement(orderButton1).click();
    }

    //метод клика 2-кнопки "Заказать"
    public void clickOrderButton2() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(orderButton2));
        driver.findElement(orderButton2).click();
    }

    //проверка раздела «Вопросы о важном».
    public void checkQaSection() {
        waitForHeader();
        getSubHeaderText();
        clickFirstQuestion();
        getAnswerQuestion();
    }

}
