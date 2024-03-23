package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected final DSL dsl;
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        dsl = new DSL();
        this.driver = driver;
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

}
