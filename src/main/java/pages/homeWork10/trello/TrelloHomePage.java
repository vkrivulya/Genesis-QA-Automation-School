package pages.homeWork10.trello;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public final class TrelloHomePage extends BasePage {

    private static final SelenideElement LOGIN_BUTTON = $("[data-uuid*='login']");

    private static TrelloHomePage instance;

    private TrelloHomePage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static TrelloHomePage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new TrelloHomePage(homeWorksPageFactories);
        }
        return instance;
    }

    @Step("Click on Login button")
    public TrelloLoginPage clickLoginButton() {
        LOGIN_BUTTON.shouldBe(enabled).click();
        return homeWorksPageFactories.getTrelloLoginPage();
    }
}
