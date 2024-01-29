package users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TrelloUsers implements IUsers {

    TRELLO_USER("vkrivulya@gmail.com", "Siseneg123");

    private final String email;
    private final String password;
}
