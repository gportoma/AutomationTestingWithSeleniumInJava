package runner;

import core.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.DatePickerPage;
import page.FramePage;
import page.RegisterPage;
import page.SliderPage;

public class RunTest {
    RegisterPage registerPage;
    FramePage framePage;
    DatePickerPage datePickerPage;
    SliderPage sliderPage;

    @Before
    public void setDriver() {
        DriverFactory.setDriver();
        registerPage = new RegisterPage(DriverFactory.getDriver());
        framePage = new FramePage(DriverFactory.getDriver());
        datePickerPage = new DatePickerPage(DriverFactory.getDriver());
        sliderPage = new SliderPage(DriverFactory.getDriver());
    }

    @Test
    public void fillForm() {
        registerPage.openBrowser();
        registerPage.typeCompleteName("Guilherme", "Malta");
        registerPage.typeAddress("Rua Joaquim Guarani, 419, SP");
        registerPage.typeEmailAddress("guilherme-porto7@hotmail.com");
        registerPage.typePhone("1135869216");
        registerPage.clickGenerMale();
        registerPage.clickHobbies();
        registerPage.selectSkills("Java");
        registerPage.selectCountry("Australia");
        registerPage.typeDateBirth("1999", "October", "11");
        registerPage.typePassword("qweasd123");
        registerPage.clickSubmitButton();
        registerPage.assertCountryValidationMessage();
    }

    @Test
    public void typeInSingleIFrame() {
        registerPage.openBrowser();
        registerPage.navigateToFrames();
        framePage.typeInSingleFrame("Type in Single Frame");
        framePage.assertTextFieldNotEmpty();
    }

    @Test
    public void selectDatePickerDisabled() {
        registerPage.openBrowser();
        registerPage.navigateToDataPicker();
        datePickerPage.selectBirthDate("10/11/1999");
        datePickerPage.assertDatePickerValue(false, "11/10/1999");
    }

    @Test
    public void selectDatePickerEnabled() {
        registerPage.openBrowser();
        registerPage.navigateToDataPicker();
        datePickerPage.typeDatePickerEnabled("10/11/1999");
        datePickerPage.assertDatePickerValue(true, "10/11/1999");
    }

    @Test
    public void select50PerCentInSlider() {
        registerPage.openBrowser();
        registerPage.navigateToSlider();
        sliderPage.select50PerCentInSlider();
        sliderPage.assertSliderPosition();
    }

    @After
    public void closeDriver() {
        DriverFactory.closeDriver();
    }
}
