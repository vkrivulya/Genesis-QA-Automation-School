package pages.homework13;

import com.codeborne.selenide.SelenideElement;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;
import users.IUserInfo;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutFormPage extends BasePage {

    private static final SelenideElement FIRST_NAME_INPUT = $("[data-test='firstName']");
    private static final SelenideElement LAST_NAME_INPUT = $("[data-test='lastName']");
    private static final SelenideElement POSTAL_CODE_INPUT = $("[data-test='postalCode']");
    private static final SelenideElement CONTINUE_BUTTON = $("[data-test='continue']");

    private static CheckoutFormPage instance;

    private CheckoutFormPage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static CheckoutFormPage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new CheckoutFormPage(homeWorksPageFactories);
        }
        return instance;
    }

    public void setUserInfoForm(final IUserInfo userInfo) {
        FIRST_NAME_INPUT.shouldBe(visible).setValue(userInfo.getFirsName());
        LAST_NAME_INPUT.shouldBe(visible).setValue(userInfo.getLastName());
        POSTAL_CODE_INPUT.shouldBe(visible).setValue(userInfo.getPostalCode());
    }

    public CheckoutOverviewPage clickContinueButton() {
        CONTINUE_BUTTON.shouldBe(visible, enabled).click();
        return homeWorksPageFactories.getCheckoutOverviewPage();
    }
}
