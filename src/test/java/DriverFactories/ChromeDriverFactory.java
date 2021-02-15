package DriverFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ChromeDriverFactory {

    public WebDriver CreateChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu");
        String pathToChromeDriver = System.getProperty("os.name").contains("Mac") ? "/mac/chromedriver" : "/win/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", new File("src/test/resources").getAbsolutePath()+ pathToChromeDriver);
        WebDriver driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
