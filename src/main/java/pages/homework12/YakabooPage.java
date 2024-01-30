package pages.homework12;

import com.codeborne.selenide.SelenideElement;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.Timeout.LONG_TIMEOUT;

public class YakabooPage extends BasePage {

    private static final SelenideElement HEADER = $("#site-header");
    private static final SelenideElement BOOK_ON_SEARCH_LIST = $("[class='ui-search-product__info']");
    private static final SelenideElement SEARCH_PRODUCT_ARROW = $("[class='ui-search-product__arrow']");
    private static final SelenideElement PIPER_BOOK_PRICE = $("[class='ui-price-display price simple selected']");
    private static final SelenideElement EBOOK_PRICE = $("[class='ui-price-display price simple']");
    private static final SelenideElement BOOK_LANGUAGE = $("[class='ui-btn-select option-button selected']");
    private static final SelenideElement STATUS_NOT_AVAILABLE = $x("//div[@class='preview__footer']//div[@class='base-product__status']//div[@class='ui-shipment-status not-available']");
    private static final SelenideElement STATUS_AVAILABLE = $x("//div[@class='product-sidebar']//div[@class='base-product__status']//div[@class='ui-shipment-status available']");
    private static final SelenideElement DIALOG_CLOSE_ICON = $("[class='cl-dialog-close-icon']");
    private static final SelenideElement SEARCH_INPUT = $x(" //div[@class='ui-search-form-input']//input");

    private static YakabooPage instance;

    private YakabooPage(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static YakabooPage getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new YakabooPage(homeWorksPageFactories);
        }
        return instance;
    }

    public boolean isHeaderVisible() {
        return isElementConditionAsExpected(HEADER, visible, LONG_TIMEOUT);
    }

    public void searchBook(String bookName) {
        clickCloseDialogIconIfExist();
        SEARCH_INPUT.shouldBe(visible).setValue(bookName);
        isBookOnSearchListVisible();
        clickSearchProductArrow();
        isBookVariantsVisible();
    }

    public boolean isBookOnSearchListVisible() {
        return isElementConditionAsExpected(BOOK_ON_SEARCH_LIST, visible, LONG_TIMEOUT);
    }

    public void clickCloseDialogIconIfExist() {
        if (DIALOG_CLOSE_ICON.exists()) {
            DIALOG_CLOSE_ICON.shouldBe(visible).click();
        }
    }

    public void clickSearchProductArrow() {
        clickCloseDialogIconIfExist();
        SEARCH_PRODUCT_ARROW.shouldBe(enabled).click();
    }

    public boolean isStatusNotAvailableExist() {
        return STATUS_NOT_AVAILABLE.exists();
    }

    public boolean isStatusAvailableExist() {
        return STATUS_AVAILABLE.exists();
    }

    public boolean isEBookExist() {
        return EBOOK_PRICE.exists();
    }

    public boolean isBookVariantsVisible() {
        return isElementConditionAsExpected(BOOK_LANGUAGE, visible, LONG_TIMEOUT);
    }

    public String getPiperBookPrice() {
        return PIPER_BOOK_PRICE.shouldBe(visible).getText();
    }

    public String getEBookPrice() {
        return EBOOK_PRICE.shouldBe(visible).getText();
    }

    public void printBookPrice(String book) {
        if (isStatusAvailableExist()) {
            String piperBookPrice = getPiperBookPrice();
            System.out.println(book + ": a paper version is available. Price: " + piperBookPrice);
        } else if (isStatusNotAvailableExist()) {
            if (isEBookExist()) {
                String ebookPrice = getEBookPrice();
                System.out.println(book + ": an EBook version is available. Price: " + ebookPrice);
            } else {
                clickCloseDialogIconIfExist();
                System.out.println(book + ": book is not available");
            }
        }
    }
}
