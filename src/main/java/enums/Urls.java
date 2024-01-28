package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Urls {

    GOOGLE_TRANSLATE_URL("https://translate.google.com"),
    TRELLO_URL("https://trello.com/");

    private final String url;
}
