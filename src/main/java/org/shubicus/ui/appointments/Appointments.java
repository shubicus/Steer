package org.shubicus.ui.appointments;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public interface Appointments {

    SelenideElement TOOLBAR = $x("//input[starts-with(@placeholder, 'Search for')]");

    @Step
    default Class<?> searchAppointmentByTitle(String searchText) {
        TOOLBAR.sendKeys(searchText);
        return this.getClass();
    }
}
