package org.jeecqrs.example.quickstart.port.adapter.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import org.jeeventstore.serialization.gson.EventSerializerGsonTypeConverter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Sample for a custom type converter for Gson serialization.
 */
public class LocalDateTypeConverter implements EventSerializerGsonTypeConverter<LocalDate> {

    private final static DateTimeFormatter timeFormat = DateTimeFormat.forPattern("yyyy-MM-dd");

    @Override
    public Class<LocalDate> convertedType() {
        return LocalDate.class;
    }

    @Override
    public JsonElement serialize(LocalDate t, Type type, JsonSerializationContext jsc) {
        return new JsonPrimitive(t.toString(timeFormat));
    }

    @Override
    public LocalDate deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) 
            throws JsonParseException {
	JsonPrimitive obj = je.getAsJsonPrimitive();
        return LocalDate.parse(obj.getAsString(), timeFormat);
    }
    
}
