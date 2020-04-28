package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.rules;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLRulesSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.Assertion;

/**
 * Created by pieter.bos on 15/06/16.
 */
public class AssertionSerializer extends RuleElementSerializer<Assertion> {

    public AssertionSerializer(ADLRulesSerializer serializer) {
        super(serializer);
    }

    @Override
    public void serialize(Assertion ruleElement) {
        if(ruleElement.getTag() != null) {
            builder.append(ruleElement.getTag());
            builder.append(": ");
        }

        serializer.serializeRuleElement(ruleElement.getExpression());
        builder.newline();

    }
}
