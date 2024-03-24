package page;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "singleframe")
    private WebElement iframeElement;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputSingleIframe;

    public void typeInSingleFrame(String msg) {
        driver.switchTo().frame(iframeElement);
        dsl.type(inputSingleIframe, msg);
    }

    public void assertTextFieldNotEmpty() {
        String value = inputSingleIframe.getAttribute("value");
        Assert.assertFalse("O iframe esta preenchido", value.isEmpty());
    }
}
