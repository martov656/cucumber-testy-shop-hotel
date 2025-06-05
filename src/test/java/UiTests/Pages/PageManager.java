package UiTests.Pages;

import UiTests.Pages.Hotel.HotelHomePage;
import UiTests.Steps.TestContext;

public class PageManager {
    private final TestContext context;
    private BasePage basePage;
    private HotelHomePage hotelHomePage;

    public PageManager(TestContext context) {
        this.context = context;
    }

    public BasePage getBasePage() {
        return (basePage == null) ? new BasePage(context) : basePage;
    }

    public HotelHomePage getHotelHomePage() {
        return (hotelHomePage == null) ? new HotelHomePage(context) : hotelHomePage;
    }

}
