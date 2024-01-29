package pages.homeWork10.trello;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.Timeout.LONG_TIMEOUT;

public final class TrelloMainBoardsPage extends BasePage {

    private static final SelenideElement HEADER = $("[data-testid='header-container']");
    private static final ElementsCollection BOARD_CARD = $$("[class='board-tile-details-name']");

    private static TrelloMainBoardsPage instance;

    private TrelloMainBoardsPage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static TrelloMainBoardsPage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new TrelloMainBoardsPage(homeWorksPageFactories);
        }
        return instance;
    }

    public boolean isHeaderTrelloBoardVisible() {
        return isElementConditionAsExpected(HEADER, visible, LONG_TIMEOUT);
    }

    public TrelloBoardPage selectBoardByTitle(final String title) {
        BOARD_CARD.findBy(attribute("title", title)).click();
        return homeWorksPageFactories.getTrelloBoardPage();
    }
}
