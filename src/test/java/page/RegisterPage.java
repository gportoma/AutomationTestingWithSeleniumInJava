package page;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;
    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    private WebElement address;
    @FindBy(xpath = "//input[@ng-model='EmailAdress']")
    private WebElement emailAddress;
    @FindBy(xpath = "//input[@type='tel']")
    private WebElement phone;
    @FindBy(xpath = "//input[@type='radio'][@value='Male']")
    private WebElement generMale;
    @FindBy(xpath = "//div[@class='col-md-4 col-xs-4 col-sm-4']//input[@id='checkbox1']")
    private WebElement hobbies;
    @FindBy(xpath = "//select[@id='Skills']")
    private WebElement skills;
    @FindBy(id = "countries")
    private WebElement countries;
    @FindBy(id = "country")
    private WebElement selectCountry;
    @FindBy(id = "yearbox")
    private WebElement yearBirth;
    @FindBy(xpath = "//select[@placeholder='Month']")
    private WebElement monthBirth;
    @FindBy(id = "daybox")
    private WebElement dayBirth;
    @FindBy(id = "firstpassword")
    private WebElement firstPassword;
    @FindBy(id = "secondpassword")
    private WebElement confirmPassword;
    @FindBy(id = "submitbtn")
    private WebElement submitButton;
    @FindBy(xpath = "//a[text()='SwitchTo']")
    private WebElement dropdownSwitchTo;
    @FindBy(xpath = "//a[@href='Frames.html']")
    private WebElement framesLink;
    @FindBy(xpath = "//a[text()='Widgets']")
    private WebElement dropdownWidgets;
    @FindBy(xpath = "//a[@href='Datepicker.html']")
    private WebElement datePickerLink;
    @FindBy(xpath = "//a[@href='Slider.html']")
    private WebElement sliderLink;

    public void openBrowser() {
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    public void typeCompleteName(String firstNameValue, String lastNameValue) {
        dsl.type(firstName, firstNameValue);
        dsl.type(lastName, lastNameValue);
    }

    public void typeAddress(String addressValue) {
        dsl.type(address, addressValue);
    }

    public void typeEmailAddress(String emailValue) {
        dsl.type(emailAddress, emailValue);
    }

    public void typePhone(String phoneValue) {
        dsl.type(phone, phoneValue);
    }

    public void clickGenerMale() {
        dsl.toClick(generMale);
    }

    public void clickHobbies() {
        dsl.toClick(hobbies);
    }

    public void selectSkills(String skillValue) {
        dsl.selectValueInComboBox(skills, skillValue);
    }

    public void selectCountry(String countryValue) {
        dsl.selectValueInComboBox(selectCountry, countryValue);
    }

    public void typeDateBirth(String yearValue, String monthValue, String dayValue) {
        dsl.type(yearBirth, yearValue);
        dsl.type(monthBirth, monthValue);
        dsl.type(dayBirth, dayValue);
    }

    public void typePassword(String passwordValue) {
        dsl.type(firstPassword, passwordValue);
        dsl.type(confirmPassword, passwordValue);
    }

    public void clickSubmitButton() {
        dsl.toClick(submitButton);
    }

    public void assertCountryValidationMessage() {
        String validationMessage = (String) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].validationMessage;", countries);
        String expectedMessage = "Selecione um item da lista.";
        Assert.assertEquals("Apresenta a mensagem 'Selecione um item da lista.'", expectedMessage, validationMessage);
    }

    public void navigateToFrames() {
        dsl.toClick(dropdownSwitchTo);
        dsl.toClick(framesLink);
    }

    public void navigateToDataPicker() {
        dsl.toClick(dropdownWidgets);
        dsl.toClick(datePickerLink);
    }

    public void navigateToSlider() {
        dsl.toClick(dropdownWidgets);
        dsl.toClick(sliderLink);
    }
}
