package UiTests.Pages;

import UiTests.Pages.Hotel.HotelAccProfilePage;
import UiTests.Pages.Hotel.HotelAuthenticationPage;
import UiTests.Pages.Hotel.HotelCreateAccountPage;
import UiTests.Pages.Hotel.HotelHomePage;
import UiTests.Steps.Hotel.HotelAccountPageSteps;
import UiTests.Steps.TestContext;

public class PageManager {
    private final TestContext context;
    private BasePage basePage;
    private HotelHomePage hotelHomePage;
    private HotelAuthenticationPage hotelAuthenticationPage;
    private HotelCreateAccountPage hotelCreateAccountPage;
    private HotelAccProfilePage hotelAccProfilePage;


    public PageManager(TestContext context) {
        this.context = context;
    }

    public BasePage getBasePage() {
        return (basePage == null) ? new BasePage(context) : basePage;
    }

    public HotelHomePage getHotelHomePage() {
        return (hotelHomePage == null) ? new HotelHomePage(context) : hotelHomePage;
    }

    public HotelAuthenticationPage getHotelAuthenticationPage() {
        return (hotelAuthenticationPage == null) ? new HotelAuthenticationPage(context) : hotelAuthenticationPage;
    }

    public HotelCreateAccountPage getHotelCreateAccountPage() {
        return (hotelCreateAccountPage == null) ? new HotelCreateAccountPage(context) : hotelCreateAccountPage;
    }

    public HotelAccProfilePage getHotelAccProfilePage() {
        return (hotelAccProfilePage == null) ? new HotelAccProfilePage(context) : hotelAccProfilePage;
    }

}
