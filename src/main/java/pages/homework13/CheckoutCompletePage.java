package pages.homework13;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage extends BasePage {

    private static final SelenideElement COMPLETE_HEADER = $("*[class='complete-header']");
    private static CheckoutCompletePage instance;

    private CheckoutCompletePage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static CheckoutCompletePage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new CheckoutCompletePage(homeWorksPageFactories);
        }
        return instance;
    }

    @Step("Get complete Header Text")
    public String getCompleteHeaderText() {
        return COMPLETE_HEADER.shouldBe(visible).getText();
    }
}
