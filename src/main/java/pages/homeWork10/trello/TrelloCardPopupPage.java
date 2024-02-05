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

public final class TrelloCardPopupPage extends BasePage {

    private static final SelenideElement CARD_POPUP_HEADER = $("[class*='js-card-detail-header']");
    private static final SelenideElement DESCRIPTION_INPUT = $("[class='editable']");
    private static final SelenideElement SAVE_DESCRIPTION_BUTTON = $("[class*='js-save-edit']");
    private static final SelenideElement CARD_POPUP_DESCRIPTION = $("[class*='markeddown']");
    private static final SelenideElement CLOSE_POPUP_BUTTON = $("[class*='js-close-window']");
    private static final SelenideElement CURRENT_COMMENT = $("[class*='current-comment']");
    private static final SelenideElement COMMENT_INPUT = $("[class*='js-new-comment-react-root']");
    private static final SelenideElement SAVE_COMMENT_BUTTON = $("[data-testid='card-back-comment-save-button']");
    private static final ElementsCollection EDITOR_TEXTAREA = $$("#ak-editor-textarea");

    private static TrelloCardPopupPage instance;

    private TrelloCardPopupPage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static TrelloCardPopupPage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new TrelloCardPopupPage(homeWorksPageFactories);
        }
        return instance;
    }

    @Step("Card popup header is displayed")
    public boolean isCardPopupHeaderVisible() {
        return isElementConditionAsExpected(CARD_POPUP_HEADER, visible, LONG_TIMEOUT);
    }

    @Step("Set card description text")
    public void setCardDescriptionTextarea(final int index, final String description) {
        DESCRIPTION_INPUT.shouldBe(visible).click();
        EDITOR_TEXTAREA.get(index).setValue(description);
    }

    @Step("Click on save description button")
    public void clickSaveDescriptionButton() {
        SAVE_DESCRIPTION_BUTTON.shouldBe(enabled).click();
    }

    @Step("Get card popup description")
    public String getCardPopupDescription() {
        return CARD_POPUP_DESCRIPTION.shouldBe(visible).getText();
    }

    @Step("Click close popup button")
    public void clickClosePopupButton() {
        CLOSE_POPUP_BUTTON.shouldBe(visible).click();
    }

    @Step("Set comment")
    public void setComment(final int index, final String comment) {
        COMMENT_INPUT.shouldBe(visible).click();
        EDITOR_TEXTAREA.get(index).setValue(comment);
    }

    @Step("Click on save comment button")
    public void clickSaveCommentButton() {
        SAVE_COMMENT_BUTTON.shouldBe(enabled).click();
    }

    @Step("Get current comment")
    public String getCurrentComment() {
        return CURRENT_COMMENT.shouldBe(visible).getText();
    }
}
