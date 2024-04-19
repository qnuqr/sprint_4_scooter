package driver_manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    protected String scooterUrl = "https://qa-scooter.praktikum-services.ru/";
    public WebDriver getDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                return setChromeDriver();
            case "firefox":
                return setFireFoxDriver();
            default:
                throw new IllegalArgumentException("Не поддерживаемый браузер " + browserName);
        }
    }

    public WebDriver setChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--no-sandbox");
        return new ChromeDriver(options);
    }


    public WebDriver setFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--kiosk");
        return new FirefoxDriver(options);
    }

    public void navigateToUrl(WebDriver driver) {
        driver.get(scooterUrl);
    }

}
