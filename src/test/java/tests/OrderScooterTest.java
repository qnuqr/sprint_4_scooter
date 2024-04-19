package tests;

import driver_manager.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.CustomerInfoOrderPage;
import pages.HomePage;
import pages.RentInfoOrderPage;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderScooterTest {

    private WebDriver driver;
    private String name;
    private String surname;
    private String address;
    private String subway;
    private String phone;
    private String date;
    public OrderScooterTest(String name, String surname, String address, String phone, String date, String subway) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phone = phone;
        this.date = date;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Гарри", "Поттер", "Лондон 15", "Черкиз", "20.04.2024 \n", "87774561223"},
                {"Джон", "Уик", "Минск 17", "Аэро", "19.04.2024 \n", "87774561220"}
        });
    }

    @Before
    public void startUp() {
        DriverManager driverManager = new DriverManager();
        driver = driverManager.getDriver("chrome");
        driverManager.navigateToUrl(driver);
    }


    @Test
    public void checkOrderScooterThroughButoon2() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOrderButton2();
        CustomerInfoOrderPage customerInfoOrderPage = new CustomerInfoOrderPage(driver);
        customerInfoOrderPage.setCustomerInfo(name, surname, address, subway, phone);
        RentInfoOrderPage rentInfoOrderPage = new RentInfoOrderPage(driver);
        rentInfoOrderPage.makeOrder(date);
    }

    @Test
    public void checkOrderScooterThroughButoon1() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOrderButton1();
        CustomerInfoOrderPage customerInfoOrderPage = new CustomerInfoOrderPage(driver);
        customerInfoOrderPage.setCustomerInfo(name, surname, address, subway, phone);
        RentInfoOrderPage rentInfoOrderPage = new RentInfoOrderPage(driver);
        rentInfoOrderPage.makeOrder(date);
    }

    @After
    public void quit() {
        driver.quit();
    }

}
