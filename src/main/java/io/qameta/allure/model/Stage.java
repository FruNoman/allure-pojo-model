package io.qameta.allure.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Test stages.
 */
public enum Stage {

    scheduled("scheduled"),
    running("running"),
    finished("finished"),
    pending("pending"),
    interrupted("interrupted");

    private final String value;

    Stage(final String v) {
        value = v;
    }

    @JsonValue
    public String value() {
        return value;
    }

    public static Stage fromValue(final String v) {
        for (Stage c : Stage.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
