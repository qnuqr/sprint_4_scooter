package pages;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(Parameterized.class)
public class CustomerInfoOrderPage {
    private WebDriver driver;

    //локаторы стр Заказа скутера
    private By orderHeader = By.className("Order_Header__BZXOb");
    private By name = By.xpath("//input[@placeholder=\"* Имя\"]");
    private By surName = By.xpath("//input[@placeholder=\"* Фамилия\"]");
    private By adress = By.xpath("//input[@placeholder=\"* Адрес: куда привезти заказ\"]");
    private By metroStationList = By.xpath("//input[@class='select-search__input']");
    private By cherkizStation = By.xpath("//div[@class='select-search__select']");
    private By phoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By cookieButton = By.xpath("//button[@class='App_CookieButton__3cvqF']");
    private By continueButton = By.xpath("//button[text()='Далее']");



    // конструктор класса
    public CustomerInfoOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод ввода Имени
    public void setName(String nname) {
        WebElement inputName = driver.findElement(name);
        if (inputName.isDisplayed()) {
            inputName.sendKeys(nname);
        } else {
            System.out.println("Поле Имя не доступна");
        }

    }

    //метод ввода Фамилии
    public void setSurName(String surname) {
        WebElement inputSurname = driver.findElement(surName);
        if (inputSurname.isDisplayed()) {
            inputSurname.sendKeys(surname);
        } else {
            System.out.println("Поле Фамилия не доступна");
        }
    }

    //метод ввода Адреса
    public void setAdress(String address) {
        WebElement inputAddress = driver.findElement(adress);
        if (inputAddress.isDisplayed()) {
            inputAddress.sendKeys(address);
        } else {
            System.out.println("Поле Адрес не доступна");
        }
    }

    //метод выбора станции метро
    public void setMetroStation() {
        driver.findElement(metroStationList).sendKeys("Черкиз");
        driver.findElement(cherkizStation).click();
    }

    //метод ввода тел номера
    public void setPhoneNumber(String phone) {
        WebElement inputNumber = driver.findElement(phoneNumber);
        if (inputNumber.isDisplayed()) {
            inputNumber.sendKeys(phone);
        } else {
            System.out.println("Поле Телефон не доступна");
        }
    }

    //клик кнопки куки
    public void clickAcceptCookieButton() {driver.findElement(cookieButton).click();}

    //метод ожидание кликабельности и клика кнопки "Далее"
    public void clickContinueButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }

    //метод заполнения данных арендатора и переход к след стр
    public void setCustomerInfo(String name, String surname, String address, String phone) {
        setName(name);
        setSurName(surname);
        setAdress(address);
        setMetroStation();
        setPhoneNumber(phone);
        clickAcceptCookieButton();
        clickContinueButton();
    }
}
