package io.qameta.allure.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

import java8.util.function.Predicate;
import java8.util.stream.RefStreams;
import java8.util.stream.Stream;

/**
 * @author charlie (Dmitry Baev).
 */
public class StageDeserializer extends StdDeserializer<Stage> {
    protected StageDeserializer() {
        super(Stage.class);
    }

    @Override
    public Stage deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        final String value = p.readValueAs(String.class);
        return RefStreams.of(Stage.values())
                .filter(new Predicate<Stage>() {
                    @Override
                    public boolean test(Stage stage) {
                        return stage.value().equalsIgnoreCase(value);
                    }
                })
                .findAny()
                .orElse(null);
    }
}
