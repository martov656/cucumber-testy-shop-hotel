package UiTests.Pages;

import UiTests.Pages.Hotel.*;
import UiTests.Steps.Hotel.HotelAccountPageSteps;
import UiTests.Steps.TestContext;

public class PageManager {
    private final TestContext context;
    private BasePage basePage;
    private HotelHomePage hotelHomePage;
    private HotelAuthenticationPage hotelAuthenticationPage;
    private HotelCreateAccountPage hotelCreateAccountPage;
    private HotelAccProfilePage hotelAccProfilePage;
    private HotelNewAddressesPage hotelNewAddressesPage;
    private HotelAddressesPage hotelAddressesPage;


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

    public HotelNewAddressesPage getHotelNewAddressesPage() {
        return (hotelNewAddressesPage == null) ? new HotelNewAddressesPage(context) : hotelNewAddressesPage;
    }

    public HotelAddressesPage getHotelAddressesPage() {
        return (hotelAddressesPage == null) ? new HotelAddressesPage(context) : hotelAddressesPage;
    }
}
