package homeWork10;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.homeWork10.ImdbTop250Page;

import java.util.Iterator;

import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.open;
import static enums.Urls.IMDB_TOP_250_URL;
import static org.testng.Assert.assertEquals;

public class ImdbTop250Test extends BaseTest {

    private ImdbTop250Page imdbTop250Page;

    @BeforeTest
    public void beforeTest() {
        imdbTop250Page = pageFactories.getImdbTop250Page();
        open(IMDB_TOP_250_URL.getUrl());
    }

    @Test(priority = 1)
    public void checkMovieName() {
        Iterator<String> names = imdbTop250Page.names();
        Iterator<String> years = imdbTop250Page.years();
        Iterator<String> ratings = imdbTop250Page.ratings();

        while (names.hasNext()) {
            String name = names.next();
            String year = years.next();
            String rating = ratings.next();
            imdbTop250Page.clickOnMovieName(name);
            int index = name.indexOf(" ");
            String newName = name.substring(index).trim();
            assertEquals(imdbTop250Page.getMovieName(), newName);
            assertEquals(imdbTop250Page.getYearOnMoviePage(), year);
            assertEquals(imdbTop250Page.getRatingOnMoviePage(), rating);
            back();
        }
    }
}
