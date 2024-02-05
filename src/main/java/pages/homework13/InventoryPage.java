package pages.homework13;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.Timeout.SHORT_TIMEOUT;
import static java.lang.String.format;

public class InventoryPage extends BasePage {

    private static final SelenideElement APP_LOGO = $("[class='app_logo']");
    private static final SelenideElement CART_BUTTON = $("#shopping_cart_container");

    private static InventoryPage instance;

    private InventoryPage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static InventoryPage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new InventoryPage(homeWorksPageFactories);
        }
        return instance;
    }

    private SelenideElement itemByPriceButton(final String price) {
        return $x(format("//div[@class='inventory_item_price' and contains(.,'%s')]/./following-sibling::button", price));
    }

    private static SelenideElement itemNameByPrice(final String price) {
        return $x(format("//*[@class='pricebar' and contains(.,'%s')]/preceding-sibling::div/a", price));
    }

    @Step("Inventory page is loaded")
    public boolean isInventoryPageLoaded() {
        return isElementConditionAsExpected(APP_LOGO, visible, SHORT_TIMEOUT);
    }

    @Step("Click on Add item to Cart button")
    public void clickAddToCartByPriceButton(final String price) {
        itemByPriceButton(price).scrollIntoView(true).shouldBe(visible, enabled).click();
    }

    @Step("Click on Cart button")
    public CartPage clickCartButton() {
        CART_BUTTON.shouldBe(visible, enabled).click();
        return homeWorksPageFactories.getCartPage();
    }

    @Step("Get item name on inventory page")
    public String getItemNameOnInventoryPage(final String price) {
        return itemNameByPrice(price).scrollIntoView(true).shouldBe(visible).getText();
    }
}
