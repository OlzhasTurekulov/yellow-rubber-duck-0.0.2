package autotests;

import lombok.Getter;

@Getter
public enum BasePath {
    DUCK("/api/duck");

    private String value;

    BasePath(String value) {
        this.value = value;
    }

}
