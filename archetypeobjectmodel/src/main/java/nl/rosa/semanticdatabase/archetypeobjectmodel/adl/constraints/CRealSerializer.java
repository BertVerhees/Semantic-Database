package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.constraints;


import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLDefinitionSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives.CReal;

/**
 * @author Marko Pipan
 */
public class CRealSerializer extends COrderedSerializer<CReal> {
    public CRealSerializer(ADLDefinitionSerializer serializer) {
        super(serializer);
    }
}
