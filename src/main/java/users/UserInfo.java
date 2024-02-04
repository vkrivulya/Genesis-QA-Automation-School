package users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserInfo implements IUserInfo{

    DAMN_CON("Damn","Son","08290");

    private final String firsName;
    private final String lastName;
    private final String postalCode;
}
