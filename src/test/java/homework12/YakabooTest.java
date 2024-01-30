package homework12;

import base.BaseTest;
import dataprovider.BooksDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.homework12.YakabooPage;

import static com.codeborne.selenide.Selenide.open;
import static enums.Urls.YAKABOO_URL;

public class YakabooTest extends BaseTest {

    private YakabooPage yakabooPage;

    @BeforeMethod
    public void beforeTest() {
        yakabooPage = pageFactories.getYakabooPage();
        open(YAKABOO_URL.getUrl());
    }

    @Test(dataProviderClass = BooksDataProvider.class, dataProvider = "books")
    public void checkBookPrice(String book) {
        yakabooPage.searchBook(book);
        yakabooPage.printBookPrice(book);
    }
}
