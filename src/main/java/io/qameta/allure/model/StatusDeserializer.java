package io.qameta.allure.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

import java8.util.function.Predicate;
import java8.util.stream.RefStreams;

/**
 * @author charlie (Dmitry Baev).
 */
public class StatusDeserializer extends StdDeserializer<Status> {
    protected StatusDeserializer() {
        super(Status.class);
    }

    @Override
    public Status deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        final String value = p.readValueAs(String.class);
        return RefStreams.of(Status.values())
                .filter(new Predicate<Status>() {
                    @Override
                    public boolean test(Status status) {
                        return status.value().equalsIgnoreCase(value);
                    }
                })
                .findAny()
                .orElse(null);
    }
}
