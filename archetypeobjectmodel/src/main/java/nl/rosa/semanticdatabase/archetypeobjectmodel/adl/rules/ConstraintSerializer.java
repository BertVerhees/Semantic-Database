package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.rules;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLRulesSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.Constraint;

/**
 * Created by pieter.bos on 15/06/16.
 */
public class ConstraintSerializer extends RuleElementSerializer<Constraint> {

    public ConstraintSerializer(ADLRulesSerializer serializer) {
        super(serializer);
    }

    @Override
    public void serialize(Constraint ruleElement) {
        builder.append("{");
        serializer.getDefinitionSerializer().appendCObject(ruleElement.getItem());
        builder.append("}");
    }
}
