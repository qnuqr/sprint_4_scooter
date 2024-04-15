package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.CustomerInfoOrderPage;
import pages.HomePage;
import pages.RentInfoOrderPage;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestOrderScooter {

    private WebDriver driver;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String date;
    public TestOrderScooter(String name, String surname, String address, String phone, String date) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Гарри", "Поттер", "Лондон 15", "87774561223", "20.04.2024 \n"},
                {"Джон", "Уик", "Минск 17", "87774561220", "19.04.2024 \n"}
        });
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }


    @Test
    public void checkOrderScooterThroughButoon2() {
        //FirefoxOptions options = new FirefoxOptions();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--kiosk");
        //driver = new FirefoxDriver(options);
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage homePage = new HomePage(driver);
        // Прокрутка страницы до раздела Вопросы
        WebElement element = driver.findElement(By.xpath("(//div[@class='Home_SubHeader__zwi_E'])[4]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        homePage.checkQaSection();
        homePage.clickOrderButton2();
        CustomerInfoOrderPage customerInfoOrderPage = new CustomerInfoOrderPage(driver);
        customerInfoOrderPage.setCustomerInfo(name, surname, address, phone);
        RentInfoOrderPage rentInfoOrderPage = new RentInfoOrderPage(driver);
        rentInfoOrderPage.makeOrder(date);
    }

    @Test
    public void checkOrderScooterThroughButoon1() {
        //FirefoxOptions options = new FirefoxOptions();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--kiosk");
        //driver = new FirefoxDriver(options);
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage homePage = new HomePage(driver);
        // Прокрутка страницы до раздела Вопросы
        WebElement element = driver.findElement(By.xpath("(//div[@class='Home_SubHeader__zwi_E'])[4]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        homePage.checkQaSection();
        homePage.clickOrderButton1();
        CustomerInfoOrderPage customerInfoOrderPage = new CustomerInfoOrderPage(driver);
        customerInfoOrderPage.setCustomerInfo(name, surname, address, phone);
        RentInfoOrderPage rentInfoOrderPage = new RentInfoOrderPage(driver);
        rentInfoOrderPage.makeOrder(date);
    }

    @After
    public void quit() {
        driver.quit();
    }

}
