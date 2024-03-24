package page;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SliderPage extends BasePage {

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public void select50PerCentInSlider() {
        WebElement sliderHandle = driver.findElement(By.cssSelector("#slider a.ui-slider-handle"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.left = '50%'", sliderHandle);
    }

    public void assertSliderPosition() {
        WebElement sliderHandle = driver.findElement(By.cssSelector("#slider a.ui-slider-handle"));
        String leftValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].style.left", sliderHandle);
        Assert.assertEquals("A posição do slider está correta", "50%", leftValue);
    }
}
