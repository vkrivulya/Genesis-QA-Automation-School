package pages.homeWork10.trello;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.Timeout.LONG_TIMEOUT;
import static helpers.Timeout.SHORT_TIMEOUT;

public final class TrelloBoardPage extends BasePage {

    private static final SelenideElement BOARD_NAME = $("[data-testid='board-name-display']");
    private static final SelenideElement CLOSE_ICON = $("[data-testid='CloseIcon']");
    private static final SelenideElement CARD_NAME = $("[data-testid='trello-card']");
    private static final SelenideElement CARD_DESCRIPTION_ICON = $("[data-testid='DescriptionIcon']");
    private static final SelenideElement CARD_COMMENT_ICON = $("[data-testid='CommentIcon']");
    private static final SelenideElement SUBMIT_ADD_CARD_BUTTON = $("[data-testid='list-card-composer-add-card-button']");
    private static final SelenideElement CARD_TITLE_TEXTAREA = $("[data-testid='list-card-composer-textarea']");
    private static final SelenideElement EDIT_ICON = $("[data-testid='EditIcon']");
    private static final SelenideElement QUICK_CARD_OPEN_CARD = $("[data-testid='quick-card-editor-open-card']");
    private static final SelenideElement QUICK_CARD_ARCHIVE = $("[data-testid='quick-card-editor-archive']");
    private static final ElementsCollection LIST_ADD_CARD_BUTTON = $$("[data-testid='list-add-card-button']");

    private static TrelloBoardPage instance;

    private TrelloBoardPage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static TrelloBoardPage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new TrelloBoardPage(homeWorksPageFactories);
        }
        return instance;
    }

    @Step("Board name is displayed")
    public boolean isBoardNameDisplayed() {
        return isElementConditionAsExpected(BOARD_NAME, visible, LONG_TIMEOUT);
    }

    @Step("Click on add Card button by index {0}")
    public void clickAddCardByIndexButton(final int index) {
        LIST_ADD_CARD_BUTTON.get(index).shouldBe(enabled).click();
    }

    @Step("Card title text is displayed")
    public boolean isCardTitleTextareaVisible() {
        return isElementConditionAsExpected(CARD_TITLE_TEXTAREA, visible, SHORT_TIMEOUT);
    }

    @Step("Set Card text {0}")
    public void setCardTextarea(final String text) {
        CARD_TITLE_TEXTAREA.shouldBe(visible).setValue(text);
    }

    @Step("Click on submit button")
    public void clickSubmitAddCardButton() {
        SUBMIT_ADD_CARD_BUTTON.shouldBe(enabled).click();
    }

    @Step("Get Card Name")
    public String getCardName() {
        return CARD_NAME.shouldBe(visible).getText();
    }

    @Step("Open Card")
    public TrelloCardPopupPage openCard() {
        CLOSE_ICON.shouldBe(visible).click();
        CARD_NAME.shouldBe(visible).hover();
        clickEditIconButton();
        clickOpenCardButton();
        return homeWorksPageFactories.getTrelloCardPopupPage();
    }

    @Step("Archive card")
    public void archiveCard() {
        CARD_NAME.shouldBe(visible).hover();
        clickEditIconButton();
        clickArchiveButton();
    }

    @Step("Card description is displayed")
    public boolean isCardDescriptionIconDisplayed() {
        return isElementConditionAsExpected(CARD_DESCRIPTION_ICON, visible, LONG_TIMEOUT);
    }

    @Step("Card comment is displayed")
    public boolean isCardCommentIconDisplayed() {
        return isElementConditionAsExpected(CARD_COMMENT_ICON, visible, LONG_TIMEOUT);
    }

    @Step("Click on edit icon button")
    public void clickEditIconButton() {
        EDIT_ICON.shouldBe(enabled).click();
    }

    @Step("Click on archive button")
    public void clickArchiveButton() {
        QUICK_CARD_ARCHIVE.shouldBe(enabled).click();
    }

    @Step("Click on open card button")
    public void clickOpenCardButton() {
        QUICK_CARD_OPEN_CARD.shouldBe(enabled).click();
    }
}
