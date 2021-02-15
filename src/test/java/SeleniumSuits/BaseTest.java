package SeleniumSuits;

import DriverFactories.ChromeDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp()
    {
        driver = new ChromeDriverFactory().CreateChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
