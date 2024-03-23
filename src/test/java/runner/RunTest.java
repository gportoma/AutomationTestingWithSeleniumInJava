package runner;

import core.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.DataPickerPage;
import page.FramePage;
import page.RegisterPage;
import page.SliderPage;

public class RunTest {
    RegisterPage registerPage;
    FramePage framePage;
    DataPickerPage dataPickerPage;
    SliderPage sliderPage;


    @Before
    public void setDriver() {
        DriverFactory.setDriver();
        registerPage = new RegisterPage(DriverFactory.getDriver());
        framePage = new FramePage(DriverFactory.getDriver());
        dataPickerPage = new DataPickerPage(DriverFactory.getDriver());
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
        registerPage.typeDateBirth("1999", "10", "11");
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
    public void selectDatePickerDisabled() throws InterruptedException {
        registerPage.openBrowser();
        registerPage.navigateToDataPicker();
        dataPickerPage.selectBirthDate("11/10/1999");
        Thread.sleep(2000);
    }

    @Test
    public void selectDatePickerEnabled() throws InterruptedException {
        registerPage.openBrowser();
        registerPage.navigateToDataPicker();
        dataPickerPage.typeDataPickerEnabled();
        Thread.sleep(2000);
    }

    @Test
    public void select50PerCentInSlider() throws InterruptedException {
        registerPage.openBrowser();
        registerPage.navigateToSlider();
        sliderPage.select50PerCentInSlider();
        Thread.sleep(2000);
    }

    @After
    public void closeDriver() {
        DriverFactory.closeDriver();
    }
}
