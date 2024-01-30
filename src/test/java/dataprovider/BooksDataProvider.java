package dataprovider;

import org.testng.annotations.DataProvider;

public class BooksDataProvider {

    @DataProvider(name = "books")
    public Object[][] books() {
        return new Object[][]{
                {"Книга Head First Java. Легкий для сприйняття довідник"},
                {"Книга Head First. Патерни проєктування"},
                {"Книга О. Генрі. Вибрані твори / Selected Stories."}
        };
    }
}
