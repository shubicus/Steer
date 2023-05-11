package org.shubicus.ui.components.calendar;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.shubicus.ui.components.ConfirmationModalComponent;

import static com.codeborne.selenide.Selenide.$x;

public class DataPopperComponent {

    private static final String POPPER = "//div[starts-with(@class,'popper')]";
    private static final SelenideElement TITLE = $x(POPPER + "//div[starts-with(@class,'title')]");
    private static final SelenideElement DATE = $x(POPPER + "//div[starts-with(@class,'tertiary')]");
    private static final SelenideElement THREE_DOTS = $x(POPPER + "//div[starts-with(@class, 'icon')]");
    private static final SelenideElement DELETE_APPOINTMENT = $x("//div[starts-with(@class,'popper')]//li[starts-with(@class, 'ActionListItem')][.//span[.='Delete Appointment']]");

    public SelenideElement getTitleElement() {
        return TITLE;
    }

    public SelenideElement getDateElement() {
        return DATE;
    }

    @Step
    public DataPopperComponent clickOnThreeDots() {
        THREE_DOTS.click();
        return this;
    }

    @Step
    public ConfirmationModalComponent clickOnDeleteAppointment() {
        DELETE_APPOINTMENT.click();
        return new ConfirmationModalComponent();
    }
}
