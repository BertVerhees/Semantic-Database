package nl.rosa.semanticdatabase.referencemodel.v2.persistence.odin;

import com.fasterxml.jackson.core.JsonProcessingException;
import nl.rosa.semanticdatabase.odin.jackson.ODINMapper;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.jackson.ReferenceModelJacksonUtil;

/**
 * Serializes a PBmmSchema as ODIN
 */
public class OdinSerializer {
    private static ODINMapper mapper;

    public String serialize(PSchema schema) throws JsonProcessingException {
        return getMapper().writeValueAsString(schema);
    }

    private ODINMapper getMapper() {
        if(mapper == null) {
            mapper = new ODINMapper();
            ReferenceModelJacksonUtil.configureObjectMapper(mapper);
        }
        return mapper;
    }
}
