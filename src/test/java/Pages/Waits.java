package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private WebDriver driver;

    public Waits(WebDriver driver){
        this.driver = driver;
    }

    public boolean isElementPresent(By by){
        WebDriverWait wait = new WebDriverWait(driver,2);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public WebElement WaitForVisibility(By by){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return driver.findElement(by);
    }
}
