package Pages;

import org.openqa.selenium.WebDriver;

public abstract class Page<T> {

    public WebDriver driver;
    protected abstract String url();
    protected abstract T openPage();

    public Page(WebDriver driver){
        this.driver = driver;

    }


}
