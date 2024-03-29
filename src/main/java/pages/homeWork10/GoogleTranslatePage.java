package pages.homeWork10;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static helpers.Timeout.LONG_TIMEOUT;

public final class GoogleTranslatePage extends BasePage {

    private static final SelenideElement TEXT_FOR_TRANSLATE_INPUT = $("[class='er8xn']");
    private static final SelenideElement TEXT_AFTER_TRANSLATE_INPUT = $("[jsname='W297wb']");
    private static final SelenideElement DROPDOWN_BUTTON_LANG_TO_TRANSLATE_FROM = $("[jsname='RCbdJd']");
    private static final SelenideElement DROPDOWN_BUTTON_LANG_TO_TRANSLATE_TO = $("[jsname='zumM6d']");
    private static final ElementsCollection LANGUAGE_TO_TRANSLATE_TO_CODE_LIST = $$x("//*[@id='ucj-9']/following-sibling::*[contains (@class, 'qSb8Pe') and contains (@jsname,'sgblj')]");
    private static final ElementsCollection LANGUAGE_TO_TRANSLATE_FROM_CODE_LIST = $$x("//*[@id='ucj-6']/following-sibling::*[contains (@class, 'qSb8Pe') and contains (@jsname,'sgblj')]");


    private static GoogleTranslatePage instance;

    private GoogleTranslatePage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static GoogleTranslatePage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new GoogleTranslatePage(homeWorksPageFactories);
        }
        return instance;
    }

    public void setTextForTranslate(final String text) {
        TEXT_FOR_TRANSLATE_INPUT.shouldBe(visible).val(text);
    }

    public void clickDropdownButtonLangToTranslateFrom() {
        DROPDOWN_BUTTON_LANG_TO_TRANSLATE_FROM.shouldBe(enabled).click();
    }

    public void clickDropdownButtonLangToTranslateTo() {
        DROPDOWN_BUTTON_LANG_TO_TRANSLATE_TO.shouldBe(enabled).click();
    }

    public void selectByCodeLanguageToTranslateFrom(final String langCode) {
        LANGUAGE_TO_TRANSLATE_FROM_CODE_LIST.findBy(attributeMatching("data-language-code", langCode)).scrollIntoView(true).click();
    }

    public void clickByCodeLanguageToTranslateTo(final String langCode) {
        LANGUAGE_TO_TRANSLATE_TO_CODE_LIST.findBy(attributeMatching("data-language-code", langCode)).scrollIntoView(true).click();
    }

    public boolean isTextAfterTranslateVisible(final String text) {
        return isElementConditionAsExpected(TEXT_AFTER_TRANSLATE_INPUT, text(text), LONG_TIMEOUT);
    }

    public void setTextForTranslateByLangCode(final String text, final String langCode) {
        setTextForTranslate(text);
        clickDropdownButtonLangToTranslateFrom();
        selectByCodeLanguageToTranslateFrom(langCode);
        clickDropdownButtonLangToTranslateFrom();
    }

    public void selectByCodeLanguageToTranslateTo(final String langCode) {
        clickDropdownButtonLangToTranslateTo();
        clickByCodeLanguageToTranslateTo(langCode);
        clickDropdownButtonLangToTranslateTo();
    }
}
