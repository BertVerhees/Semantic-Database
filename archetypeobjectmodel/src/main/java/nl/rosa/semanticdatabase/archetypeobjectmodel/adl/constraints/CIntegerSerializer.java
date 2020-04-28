package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.constraints;


import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLDefinitionSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives.CInteger;

/**
 * @author Marko Pipan
 */
public class CIntegerSerializer extends COrderedSerializer<CInteger> {
    public CIntegerSerializer(ADLDefinitionSerializer serializer) {
        super(serializer);
    }


}
