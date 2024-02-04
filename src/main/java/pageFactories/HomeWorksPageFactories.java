package pageFactories;

import pages.homeWork10.GoogleTranslatePage;
import pages.homeWork10.ImdbTop250Page;
import pages.homeWork10.trello.*;
import pages.homework12.YakabooPage;
import pages.homework13.*;

public class HomeWorksPageFactories extends PageFactories {

    public GoogleTranslatePage getGoogleTranslatePage() {
        return GoogleTranslatePage.getInstance(this);
    }

    public TrelloMainBoardsPage getTrelloMainBoardsPage() {
        return TrelloMainBoardsPage.getInstance(this);
    }

    public TrelloHomePage getTrelloHomePage() {
        return TrelloHomePage.getInstance(this);
    }

    public TrelloLoginPage getTrelloLoginPage() {
        return TrelloLoginPage.getInstance(this);
    }

    public TrelloBoardPage getTrelloBoardPage() {
        return TrelloBoardPage.getInstance(this);
    }

    public TrelloCardPopupPage getTrelloCardPopupPage() {
        return TrelloCardPopupPage.getInstance(this);
    }

    public ImdbTop250Page getImdbTop250Page() {
        return ImdbTop250Page.getInstance(this);
    }

    public YakabooPage getYakabooPage() {
        return YakabooPage.getInstance(this);
    }

    public SaucedemoLoginPage getSaucedemoLoginPage() {
        return SaucedemoLoginPage.getInstance(this);
    }

    public InventoryPage getInventoryPage() {
        return InventoryPage.getInstance(this);
    }

    public CartPage getCartPage() {
        return CartPage.getInstance(this);
    }

    public CheckoutFormPage getCheckoutFormPage() {
        return CheckoutFormPage.getInstance(this);
    }

    public CheckoutOverviewPage getCheckoutOverviewPage() {
        return CheckoutOverviewPage.getInstance(this);
    }

    public CheckoutCompletePage getCheckoutCompletePage() {
        return CheckoutCompletePage.getInstance(this);
    }
}
