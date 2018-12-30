package org.jeecqrs.example.thorntail.port.adapter.serialization;

import com.google.gson.*;
import org.jeeventstore.serialization.gson.EventSerializerGsonTypeConverter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.lang.reflect.Type;

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
        String date = obj.getAsString();
        String[] components = date.split("-", 3);
        if (components.length < 3)
            throw new JsonParseException("Invalid date string: " + date);
        Integer year = Integer.valueOf(components[0], 10);
        Integer month = Integer.valueOf(components[1], 10);
        Integer day= Integer.valueOf(components[2], 10);
        return new LocalDate(year, month, day);
    }
    
}
