package page;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataPickerPage extends BasePage {

    public DataPickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "datepicker1")
    private WebElement datePickerDisabled;
    @FindBy(id = "datepicker2")
    private WebElement datePickerEnabled;
    @FindBy(xpath = "//a[@title='Close the datepicker']")
    private WebElement closeDataPicker;


    public void typeDataPickerEnabled() {
        dsl.type(datePickerEnabled, "11/10/1999");
        dsl.toClick(closeDataPicker);
    }

    public void selectBirthDate(String desiredDate) {
        dsl.toClick(datePickerDisabled);

        // Quebrar a data em dia, mês e ano
        String[] dateParts = desiredDate.split("/");
        int desiredDay = Integer.parseInt(dateParts[0]);
        int desiredMonth = Integer.parseInt(dateParts[1]);
        int desiredYear = Integer.parseInt(dateParts[2]);

        while (true) {
            WebElement monthYearElement = driver.findElement(By.className("ui-datepicker-title"));
            String monthYearText = monthYearElement.getText();
            String[] monthYearParts = monthYearText.split(" ");
            String currentMonth = monthYearParts[0];
            int currentYear = Integer.parseInt(monthYearParts[1]);

            if (currentMonth.equalsIgnoreCase(getMonthName(desiredMonth)) && currentYear == desiredYear) {
                break;
            }

            WebElement prevButton = driver.findElement(By.className("ui-datepicker-prev"));
            prevButton.click();
        }

        WebElement dayElement = driver.findElement(By.xpath("//a[text()='" + desiredDay + "']"));
        dayElement.click();
    }

    private static String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }
}
