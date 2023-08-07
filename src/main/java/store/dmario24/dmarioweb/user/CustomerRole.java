package store.dmario24.dmarioweb.user;

import lombok.Getter;


@Getter
public enum CustomerRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    CustomerRole(String value) {
        this.value = value;
    }

    private String value;
}
