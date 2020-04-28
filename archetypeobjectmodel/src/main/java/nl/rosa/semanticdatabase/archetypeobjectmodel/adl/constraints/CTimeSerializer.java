package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.constraints;


import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLDefinitionSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives.CTime;

/**
 * @author Marko Pipan
 */
public class CTimeSerializer extends CTemporalSerializer<CTime> {
    public CTimeSerializer(ADLDefinitionSerializer serializer) {
        super(serializer);
    }
}
