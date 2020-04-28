package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.constraints;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLDefinitionSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives.CTemporal;

/**
 * @author markopi
 */
abstract public class CTemporalSerializer<T extends CTemporal<?>> extends COrderedSerializer<T> {
    public CTemporalSerializer(ADLDefinitionSerializer serializer) {
        super(serializer);
    }

    @Override
    protected void serializeBefore(T cobj) {
        super.serializeBefore(cobj);
        serializePatternedConstraint(cobj);
    }

    private void serializePatternedConstraint(T cobj) {
        if (cobj.getPatternedConstraint()!=null) {
            builder.append(cobj.getPatternedConstraint());
            if (!cobj.getConstraint().isEmpty()) {
                builder.append("/");
            }
        }
    }

    @Override
    protected boolean shouldIncludeAssumedValue(T cobj) {
        boolean result =  super.shouldIncludeAssumedValue(cobj);
        if (!result) return false;

        return (cobj.getPatternedConstraint()!=null ||
                (cobj.getConstraint()!=null && !cobj.getConstraint().isEmpty()));
    }

}
