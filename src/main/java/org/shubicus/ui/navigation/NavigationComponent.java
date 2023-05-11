package org.shubicus.ui.navigation;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.shubicus.ui.appointments.CalendarPage;
import org.shubicus.ui.appointments.SchedulerPage;
import org.tinylog.Logger;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Selenide.$x;
import static org.shubicus.utils.Constants.CLASS;

public class NavigationComponent {

    private static final SelenideElement APPOINTMENTS = $x("//div[starts-with(@class,'linkWrapper')][.//div[.='Appointments']]");
    private static final SelenideElement SCHEDULER = $x("//a[starts-with(@class,'nestedLink')][.//div[.='Scheduler']]");
    private static final SelenideElement CALENDAR = $x("//a[starts-with(@class,'nestedLink')][.//div[.='Calendar']]");


    @Step
    public NavigationComponent clickOnAppointments() {
        Logger.info("Click on Appointments");
        APPOINTMENTS.click();
        return this;
    }

    @Step
    public NavigationComponent expandAppointments() {
        Logger.info("Expand Appointments submenu");
        if (!APPOINTMENTS.getAttribute(CLASS).contains("linkWrapperOpened")) {
            APPOINTMENTS.click();
        }
        APPOINTMENTS.shouldHave(attributeMatching(CLASS, ".*linkWrapperOpened.*"));
        return this;
    }

    @Step
    public SchedulerPage clickOnScheduler() {
        Logger.info("Open Scheduler");
        SCHEDULER.click();
        return new SchedulerPage();
    }

    @Step
    public CalendarPage clickOnCalendar() {
        Logger.info("Open Scheduler");
        CALENDAR.click();
        return new CalendarPage();
    }

}