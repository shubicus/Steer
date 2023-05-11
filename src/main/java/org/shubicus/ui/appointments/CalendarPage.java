package org.shubicus.ui.appointments;

import io.qameta.allure.Step;
import org.shubicus.ui.components.calendar.DataPopperComponent;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CalendarPage implements Appointments {

    private static String eventInfo = "//div[starts-with(@class,'eventInfo')][.='%s']";

    @Step
    public DataPopperComponent clickOnEventInfoByTitle(String title) {
        $x(format(eventInfo, title)).click();
        return new DataPopperComponent();
    }

}