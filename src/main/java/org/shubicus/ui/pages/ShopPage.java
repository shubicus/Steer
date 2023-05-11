package org.shubicus.ui.pages;

import org.shubicus.ui.navigation.NavigationComponent;
import org.shubicus.ui.appointments.SchedulerPage;

public class ShopPage {

    public NavigationComponent getNavigationComponent() {
        return new NavigationComponent();
    }

    public SchedulerPage getSchedulerComponent() {
        return new SchedulerPage();
    }
}
