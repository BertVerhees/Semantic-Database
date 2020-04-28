package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.constraints;


import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLDefinitionSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives.CDate;

/**
 * @author Marko Pipan
 */
public class CDateSerializer extends CTemporalSerializer<CDate> {
    public CDateSerializer(ADLDefinitionSerializer serializer) {
        super(serializer);
    }

}
