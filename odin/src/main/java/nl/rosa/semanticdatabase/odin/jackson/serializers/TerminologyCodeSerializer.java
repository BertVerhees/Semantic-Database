package nl.rosa.semanticdatabase.odin.jackson.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import java.io.IOException;

public class TerminologyCodeSerializer extends JsonSerializer<TerminologyCode> {
    @Override
    public void serialize(TerminologyCode value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeRawValue(value.toString());
    }

    @Override
    public void serializeWithType(TerminologyCode value, JsonGenerator gen, SerializerProvider serializers,
                                  TypeSerializer typeSer)
            throws IOException
    {
        gen.writeRawValue(value.toString());
    }
}
