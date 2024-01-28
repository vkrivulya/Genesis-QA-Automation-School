package pages.homeWork10.trello;

import com.codeborne.selenide.SelenideElement;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;
import users.IUsers;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static helpers.Timeout.LONG_TIMEOUT;

public final class TrelloLoginPage extends BasePage {

    private static final SelenideElement EMAIL_INPUT = $("#username");
    private static final SelenideElement PASSWORD_INPUT = $("#password");
    private static final SelenideElement LOGIN_SUBMIT_BUTTON = $("#login-submit");
    private static final SelenideElement HEADER_SUFFIX = $("[data-testid='header-suffix']");

    private static TrelloLoginPage instance;

    private TrelloLoginPage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static TrelloLoginPage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new TrelloLoginPage(homeWorksPageFactories);
        }
        return instance;
    }

    public boolean isHeaderSuffixVisible() {
        return isElementConditionAsExpected(HEADER_SUFFIX, visible, LONG_TIMEOUT);
    }

    public void setEmail(final IUsers user) {
        EMAIL_INPUT.shouldBe(enabled).setValue(user.getEmail());
    }

    public TrelloMainBoardsPage clickLoginSubmitButton() {
        LOGIN_SUBMIT_BUTTON.shouldBe(enabled).click();
        return homeWorksPageFactories.getTrelloMainBoardsPage();
    }

    public void setPassword(final IUsers user) {
        PASSWORD_INPUT.shouldBe(enabled).setValue(user.getPassword());
    }
}
