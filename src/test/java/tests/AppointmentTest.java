package tests;

import abstraction.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.shubicus.ui.components.ConfirmationModalComponent;
import org.shubicus.ui.components.calendar.DataPopperComponent;
import org.shubicus.ui.navigation.NavigationComponent;
import org.shubicus.ui.appointments.CalendarPage;
import org.shubicus.ui.pages.LoginPage;
import org.tinylog.Logger;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.shubicus.utils.DatesUtils.getFutureMonthAndDay;
import static org.shubicus.utils.DatesUtils.getFutureMonthAndDayWithSuffix;

public class AppointmentTest extends BaseTest {

    //todo Login via API and removeAppointment() via API

    @Test
    @Description("User can Login and create Appointment")
    public void appointmentTest() {
        var title = "My Appointment title";
        var dateFromSuffix = getFutureMonthAndDayWithSuffix(2);
        var dateToSuffix = getFutureMonthAndDayWithSuffix(4);
        var dateFrom = getFutureMonthAndDay(2);
        var dateTo = getFutureMonthAndDay(4);
        var dateOnPopper = dateFrom + ", 12:00pm - " + dateTo + ", 1:00pm";
        Logger.debug("Expected date on Popper: " + dateOnPopper);

        given(LoginPage.class)
                .openLoginPage()
                .loginByUser(TEST_CONFIGURATION.userName(), TEST_CONFIGURATION.password())
                .getNavigationComponent()
                .expandAppointments()
                .clickOnScheduler()
                .clickOnAddNewAppointment()
                .typeAppointmentTitle(title)
                .clickOnDatepickerIcon()
                .clickDayOnDatepicker(dateFromSuffix)
                .clickDayOnDatepicker(dateToSuffix)
                .clickOnCreate();
        when(NavigationComponent.class)
                .expandAppointments()
                .clickOnCalendar()
                .searchAppointmentByTitle(title);
        then(CalendarPage.class)
                .clickOnEventInfoByTitle(title)
                .getTitleElement().shouldHave(text(title));
        and(DataPopperComponent.class)
                .getDateElement().shouldHave(text(dateOnPopper));
    }

    @AfterEach
    public void removeAppointment() {
        at(DataPopperComponent.class)
                .clickOnThreeDots()
                .clickOnDeleteAppointment()
                .clickOnYesConfirmButton();
        then(ConfirmationModalComponent.class)
                .getModalContainer()
                .shouldNotBe(visible);
    }


}
