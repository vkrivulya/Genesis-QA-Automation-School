package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Urls {

    GOOGLE_TRANSLATE_URL("https://translate.google.com"),
    TRELLO_URL("https://trello.com/"),
    IMDB_TOP_250_URL("https://www.imdb.com/chart/top/");

    private final String url;
}
