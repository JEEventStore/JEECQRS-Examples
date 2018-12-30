package org.jeecqrs.example.thorntail.port.adapter.serialization;

import com.google.gson.*;
import org.jeeventstore.serialization.gson.EventSerializerGsonTypeConverter;
import org.joda.time.DateTime;

import java.lang.reflect.Type;

/**
 * Sample for a custom type converter for Gson serialization.
 */
public class DateTimeTypeConverter implements EventSerializerGsonTypeConverter<DateTime> {

    @Override
    public Class<DateTime> convertedType() {
        return DateTime.class;
    }

    @Override
    public JsonElement serialize(
            DateTime src,
            Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }

    @Override
    public DateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return new DateTime(json.getAsString());
    }
    
}
