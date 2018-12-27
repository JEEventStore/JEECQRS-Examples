package org.jeecqrs.example.openejb.port.adapter.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import org.jeeventstore.serialization.gson.EventSerializerGsonTypeConverter;
import org.joda.time.DateTime;

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