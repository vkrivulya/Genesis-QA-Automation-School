package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.ElementShould;
import helpers.Timeout;
import lombok.RequiredArgsConstructor;
import pageFactories.HomeWorksPageFactories;

@RequiredArgsConstructor
public abstract class BasePage {

    protected final HomeWorksPageFactories homeWorksPageFactories;


    public boolean isElementConditionAsExpected(SelenideElement element, final Condition condition, final Timeout timeOut) {
        try {
            element.shouldBe(condition, timeOut.getDuration());
            return true;
        } catch (ElementShould | ElementNotFound elementNotFound) {
//            Allure.addAttachment("Exception", elementNotFound.toString());
            return false;
        }
    }
}
