package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.rules;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLRulesSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.VariableReference;

/**
 * Created by pieter.bos on 15/06/16.
 */
public class VariableReferenceSerializer extends RuleElementSerializer<VariableReference> {

    public VariableReferenceSerializer(ADLRulesSerializer serializer) {
        super(serializer);
    }

    @Override
    public void serialize(VariableReference ruleElement) {
        builder.append("$");
        builder.append(ruleElement.getDeclaration().getName());
    }
}
