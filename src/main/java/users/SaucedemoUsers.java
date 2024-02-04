package users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SaucedemoUsers implements ISaucedemoUsers{

    STANDARD_USER("standard_user", "secret_sauce");

    private final String username;
    private final String password;
}
