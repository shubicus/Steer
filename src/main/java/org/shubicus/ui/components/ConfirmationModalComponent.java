package org.shubicus.ui.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.shubicus.ui.appointments.CalendarPage;

import static com.codeborne.selenide.Selenide.$x;

public class ConfirmationModalComponent {

    private static final SelenideElement MODAL_CONTAINER = $x("//div[contains(@class, 'modalContent')]");
    private static final SelenideElement YES = MODAL_CONTAINER.$x(".//button[.='Yes, Delete']");

    @Step
    public CalendarPage clickOnYesConfirmButton() {
        YES.click();
        return new CalendarPage();
    }

    public SelenideElement getModalContainer() {
        return MODAL_CONTAINER;
    }

}
