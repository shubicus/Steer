package org.shubicus.ui.appointments;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.shubicus.ui.components.CreateNewAppointmentComponent;

import static com.codeborne.selenide.Selenide.$x;

public class SchedulerPage implements Appointments {

    private static final SelenideElement NEW_APPOINTMENT = $x("//button[.='New Appointment']");

    @Step
    public CreateNewAppointmentComponent clickOnAddNewAppointment() {
        NEW_APPOINTMENT.click();
        return new CreateNewAppointmentComponent();
    }

}