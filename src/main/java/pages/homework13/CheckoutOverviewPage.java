package pages.homework13;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;

import java.text.DecimalFormat;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage extends BasePage {

    public static final SelenideElement ITEM_TOTAL_PRICE = $("[class='summary_subtotal_label']");
    public static final SelenideElement TAX = $("[class='summary_tax_label']");
    public static final SelenideElement FINISH_BUTTON = $("[data-test='finish']");

    private static CheckoutOverviewPage instance;

    private CheckoutOverviewPage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static CheckoutOverviewPage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new CheckoutOverviewPage(homeWorksPageFactories);
        }
        return instance;
    }

    @Step("Get item total price")
    public String getItemTotalPrice() {
        int index = ITEM_TOTAL_PRICE.shouldBe(visible).getText().indexOf("$");
        return ITEM_TOTAL_PRICE.getText().substring(index + 1).trim();
    }

    @Step("Get tax price")
    public String getTaxPrice() {
        int index = TAX.shouldBe(visible).getText().indexOf("$");
        return TAX.getText().substring(index + 1).trim();
    }

    @Step("Print Tax percentage")
    public void printTaxPercentage(final double itemTotal, final double tax) {
        double taxPercentage = (tax / itemTotal) * 100;
        DecimalFormat df = new DecimalFormat("0.00");
        String formattedTaxPercentage = df.format(taxPercentage);
        System.out.println("Tax Percentage: " + formattedTaxPercentage + "%");
    }

    @Step("Click on Finish button")
    public CheckoutCompletePage clickFinishButton() {
        FINISH_BUTTON.scrollIntoView(true).shouldBe(visible, enabled).click();
        return homeWorksPageFactories.getCheckoutCompletePage();
    }
}
