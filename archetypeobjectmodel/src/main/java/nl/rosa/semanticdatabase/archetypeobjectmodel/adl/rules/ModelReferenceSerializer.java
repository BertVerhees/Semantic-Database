package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.rules;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLRulesSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.ModelReference;

/**
 * Created by pieter.bos on 15/06/16.
 */
public class ModelReferenceSerializer extends RuleElementSerializer<ModelReference> {


    public ModelReferenceSerializer(ADLRulesSerializer serializer) {
        super(serializer);
    }

    @Override
    public void serialize(ModelReference reference) {
        if(reference.getVariableReferencePrefix() != null) {
            builder.append("$");
            builder.append(reference.getVariableReferencePrefix());
        }
        builder.append(reference.getPath());
    }

}
