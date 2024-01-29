package pages.homeWork10;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pageFactories.HomeWorksPageFactories;
import pages.BasePage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class ImdbTop250Page extends BasePage {

    private static final SelenideElement NAME_ON_MOVIE_PAGE = $("[data-testid='hero__pageTitle']");
    private static final SelenideElement YEAR_ON_MOVIE_PAGE = $x("//div[contains (@class, 'jqlHBQ')]//li");
    private static final SelenideElement RATING_ON_MOVIE_PAGE = $x("//div[@data-testid = 'hero-rating-bar__aggregate-rating__score']/span[1]");

    private static final ElementsCollection MOVIE_NAME_ON_LIST = $$x("//*[@class='ipc-title__text']/ancestor::a");
    private static final ElementsCollection MOVIE_YEAR_ON_LIST = $$x("//div[contains (@class, 'hcJWUf')]//span[1]");
    private static final ElementsCollection RATING_ON_LIST = $$x("//div[@data-testid='ratingGroup--container']/span[1]");

    private static ImdbTop250Page instance;

    private ImdbTop250Page(HomeWorksPageFactories homeWorksPageFactories) {
        super(homeWorksPageFactories);
    }

    public synchronized static ImdbTop250Page getInstance(HomeWorksPageFactories homeWorksPageFactories) {
        if (instance == null) {
            instance = new ImdbTop250Page(homeWorksPageFactories);
        }
        return instance;
    }

    private SelenideElement movieByName(final String name) {
        return $x(format("//*[contains (@class, 'ipc-title__text') and contains (.,'%s')]/ancestor::a", name));
    }

    //        @DataProvider(name = "persons")
    public Iterator<String> names() {
        List<String> nameOfTheMovie = getNameOfTheMovie();
        return nameOfTheMovie.stream().limit(100).collect(Collectors.toList()).iterator();
    }

    public Iterator<String> years() {
        List<String> yearOfTheMovie = getYearOfTheMovie();
        return yearOfTheMovie.stream().limit(100).collect(Collectors.toList()).iterator();
    }

    public Iterator<String> ratings() {
        List<String> ratingOfTheMovie = getRatingOfTheMovie();
        return ratingOfTheMovie.stream().limit(100).collect(Collectors.toList()).iterator();
    }

    public List<String> getNameOfTheMovie() {
        List<String> names = new ArrayList<>();
        for (SelenideElement element : MOVIE_NAME_ON_LIST) {
            names.add(element.getText());
        }
        return names;
    }

    public List<String> getYearOfTheMovie() {
        List<String> years = new ArrayList<>();
        for (SelenideElement element : MOVIE_YEAR_ON_LIST) {
            years.add(element.getText());
        }
        return years;
    }

    public List<String> getRatingOfTheMovie() {
        List<String> years = new ArrayList<>();
        for (SelenideElement element : RATING_ON_LIST) {
            years.add(element.getOwnText());
        }
        return years;
    }

    public void clickOnMovieName(String text) {
        movieByName(text).scrollIntoView(true).shouldBe(visible).click();
    }

    public String getMovieName() {
        return NAME_ON_MOVIE_PAGE.shouldBe(visible).getText();
    }

    public String getYearOnMoviePage() {
        return YEAR_ON_MOVIE_PAGE.shouldBe(visible).getText();
    }

    public String getRatingOnMoviePage() {
        return RATING_ON_MOVIE_PAGE.shouldBe(visible).getText();
    }
}
