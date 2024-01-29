package pageFactories;

import pages.homeWork10.GoogleTranslatePage;
import pages.homeWork10.ImdbTop250Page;
import pages.homeWork10.trello.*;

public class HomeWorksPageFactories extends PageFactories{

    public GoogleTranslatePage getGoogleTranslatePage() {
        return GoogleTranslatePage.getInstance(this);
    }

    public TrelloMainBoardsPage getTrelloMainBoardsPage(){
        return TrelloMainBoardsPage.getInstance(this);
    }

    public TrelloHomePage getTrelloHomePage(){
        return TrelloHomePage.getInstance(this);
    }

    public TrelloLoginPage getTrelloLoginPage(){
        return TrelloLoginPage.getInstance(this);
    }

    public TrelloBoardPage getTrelloBoardPage(){
        return TrelloBoardPage.getInstance(this);
    }

    public TrelloCardPopupPage getTrelloCardPopupPage(){
        return TrelloCardPopupPage.getInstance(this);
    }

    public ImdbTop250Page getImdbTop250Page(){
       return ImdbTop250Page.getInstance(this);
    }
}
