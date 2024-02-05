package pages.homework13;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;
import users.ISaucedemoUsers;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static helpers.Timeout.SHORT_TIMEOUT;

public class SaucedemoLoginPage extends BasePage {

    private static final SelenideElement LOGIN_LOGO = $("[class='login_logo']");
    private static final SelenideElement USERNAME_INPUT = $("[data-test='username']");
    private static final SelenideElement PASSWORD_INPUT = $("[data-test='password']");
    private static final SelenideElement LOGIN_BUTTON = $("[data-test='login-button']");

    private static SaucedemoLoginPage instance;

    private SaucedemoLoginPage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static SaucedemoLoginPage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new SaucedemoLoginPage(homeWorksPageFactories);
        }
        return instance;
    }

    @Step("Login page is loaded")
    public boolean isLoginPageLoaded() {
        return isElementConditionAsExpected(LOGIN_LOGO, visible, SHORT_TIMEOUT);
    }

    @Step("Set User credential")
    public void setCredential(final ISaucedemoUsers users) {
        USERNAME_INPUT.shouldBe(visible).setValue(users.getUsername());
        PASSWORD_INPUT.shouldBe(visible).setValue(users.getPassword());
    }

    @Step("Click on Login button")
    public InventoryPage clickLoginButton() {
        LOGIN_BUTTON.shouldBe(visible, enabled).click();
        return homeWorksPageFactories.getInventoryPage();
    }
}
