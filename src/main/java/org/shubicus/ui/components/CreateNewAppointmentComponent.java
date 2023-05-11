package org.shubicus.ui.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import org.shubicus.ui.pages.ShopPage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CreateNewAppointmentComponent {

    private static final SelenideElement APPOINTMENT_TITLE_INPUT = $x("//input[@name='title']");
    private static final SelenideElement DATE_TIME_RANGE_INPUT = $x("//div[@class='react-datepicker__input-container']/input");
    private static final SelenideElement DATE_TIME_RANGE_ICON = $x("//div[contains(@class,'inputWrapperFullWidth')]//div[starts-with(@class,'iconContainer')]/*[name()='svg']");
    private static final SelenideElement CREATE_BUTTON = $x("//button[.='Create']");
    private static String datePart = "//div[contains(@aria-label, '%s')]";

    @Step
    public CreateNewAppointmentComponent typeAppointmentTitle(String title) {
        APPOINTMENT_TITLE_INPUT.sendKeys(title);
        return this;
    }

    @Issue("Method is time at the DataRangeInput - a input value is not time - at isTime DateRangeInput")
    @Step
    public CreateNewAppointmentComponent typeDateTimeRange(String dateTimeRange) {
        DATE_TIME_RANGE_INPUT.sendKeys(dateTimeRange);
        return this;
    }

    @Step
    public CreateNewAppointmentComponent clickDayOnDatepicker(String date) {
        $x(format(datePart, date)).click();
        return this;
    }

    @Step
    public CreateNewAppointmentComponent clickOnDatepickerIcon() {
        DATE_TIME_RANGE_ICON.scrollTo().click();
        return this;
    }

    @Step
    public ShopPage clickOnCreate() {
        CREATE_BUTTON.click();
        return new ShopPage();
    }
}
