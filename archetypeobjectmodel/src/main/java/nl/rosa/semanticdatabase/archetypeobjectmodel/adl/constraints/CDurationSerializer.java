package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.constraints;


import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLDefinitionSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives.CDuration;

/**
 * @author Marko Pipan
 */
public class CDurationSerializer extends CTemporalSerializer<CDuration> {
    public CDurationSerializer(ADLDefinitionSerializer serializer) {
        super(serializer);
    }
}
