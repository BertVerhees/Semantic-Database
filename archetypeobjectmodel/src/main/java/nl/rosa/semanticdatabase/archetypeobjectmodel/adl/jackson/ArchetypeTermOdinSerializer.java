package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology.ArchetypeTerm;

import java.io.IOException;

/**
 * ArchetypeTerm implements Map, so gets serialized with the Mapserializer instead of object. Do this manually
 */
public class ArchetypeTermOdinSerializer extends JsonSerializer<ArchetypeTerm> {
        @Override
        public void serialize(ArchetypeTerm value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeFieldName("text");
            gen.writeString(value.getText());
            if(value.getDescription() != null) {
                gen.writeFieldName("description");
                gen.writeString(value.getDescription());
            }
            gen.writeEndObject();
    }

}
