package UiTests.Pages;

import UiTests.Pages.Hotel.*;
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
    private HotelResultsPage hotelResultsPage;
    private HotelQuickOrderPage hotelQuickOrderPage;
    private HotelOrderConfirmationPage hotelOrderConfirmationPage;

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

    public HotelResultsPage getHotelResultsPage() {
        return (hotelResultsPage == null) ? new HotelResultsPage(context) : hotelResultsPage;
    }

    public HotelQuickOrderPage getHotelQuickOrderPage() {
        return (hotelQuickOrderPage == null) ? new HotelQuickOrderPage(context) : hotelQuickOrderPage;
    }

    public HotelOrderConfirmationPage getHotelOrderConfirmationPage() {
        return (hotelOrderConfirmationPage == null) ? new HotelOrderConfirmationPage(context) : hotelOrderConfirmationPage;
    }

}
