package pages.homework13;

import com.codeborne.selenide.SelenideElement;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.Timeout.SHORT_TIMEOUT;
import static java.lang.String.format;

public class CartPage extends BasePage {

    private static final SelenideElement CART_LIST = $("[class='cart_list']");
    private static final SelenideElement CHECKOUT_BUTTON = $("[data-test='checkout']");

    private static CartPage instance;

    private CartPage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static CartPage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new CartPage(homeWorksPageFactories);
        }
        return instance;
    }

    private static SelenideElement itemNameByPriceOnCart(final String price) {
        return $x(format("//*[@class='item_pricebar' and contains(.,'%s')]/preceding-sibling::a", price));
    }

    public boolean isCartPageLoaded() {
        return isElementConditionAsExpected(CART_LIST, visible, SHORT_TIMEOUT);
    }

    public String getItemNameBePriceOnCart(String price) {
        return itemNameByPriceOnCart(price).shouldBe(visible).getText();
    }

    public CheckoutFormPage clickOnCheckoutButton() {
        CHECKOUT_BUTTON.scrollIntoView(true).shouldBe(visible, enabled).click();
        return homeWorksPageFactories.getCheckoutFormPage();
    }
}
