package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.constraints;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLDefinitionSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives.CDateTime;

/**
 * @author Marko Pipan
 */
public class CDateTimeSerializer extends CTemporalSerializer<CDateTime> {
    public CDateTimeSerializer(ADLDefinitionSerializer serializer) {
        super(serializer);
    }
}
