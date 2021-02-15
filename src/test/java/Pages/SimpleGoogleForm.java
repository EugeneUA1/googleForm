package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class SimpleGoogleForm extends Page<SimpleGoogleForm>{


    public SimpleGoogleForm(WebDriver driver){
        super(driver);
    }

    Waits wait = new Waits(driver);

    @Override
    public String url() {
        return "https://docs.google.com/forms/d/e/1FAIpQLSdqT5F9_qhPDmJ4lfIH7buVkUvjf4LS9ODdqD7PYfVbfFTnpA/viewform";
    }

    @Override
    public SimpleGoogleForm openPage() {
        driver.get(url());
        return this;
    }


    private final By email = By.xpath("//input[@type='email']");
    private final By age = By.xpath("//input[@type='date']");
    private final By name = By.xpath("(//input[@type='text'])[1]");
    private final By checkBox = By.xpath("//span[contains(@class, 'CheckboxLabel')]");
    private final By sendButton = By.xpath("//span[contains(@class, 'ButtonPaperbuttonContent')]");
    private final By response = By.xpath("//div[contains(@class, 'ResponseLinksContainer')]");
    private final By error = By.xpath("//div[contains(@class, 'ValidationError')]/div");



    public SimpleGoogleForm setEmail(String text)
    {
        wait.WaitForVisibility(email).sendKeys(text);
        return this;
    }

    public SimpleGoogleForm setAge(String text)
    {
        wait.WaitForVisibility(age).sendKeys(text);
        return this;
    }

    public SimpleGoogleForm setName(String text)
    {
        wait.WaitForVisibility(name).sendKeys(text);
        return this;
    }

    public SimpleGoogleForm selectMood(String mood)
    {
        List<WebElement> allLabels =  driver.findElements(checkBox);
        for(WebElement label : allLabels){
            if(label.getText().equals(mood)){
                label.click();
                break;
            }
        }
        return this;
    }

    public SimpleGoogleForm clickOnButtonSend()
    {
        wait.WaitForVisibility(sendButton).click();
        return this;
    }

    public boolean isFormSent()
    {
        return wait.isElementPresent(response);
    }


    public boolean isErrorPresent()
    {
        return wait.isElementPresent(error);
    }




}
