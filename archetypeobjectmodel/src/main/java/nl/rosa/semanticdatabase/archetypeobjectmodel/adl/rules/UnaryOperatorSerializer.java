package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.rules;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLRulesSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.UnaryOperator;

/**
 * Created by pieter.bos on 15/06/16.
 */
public class UnaryOperatorSerializer extends RuleElementSerializer<UnaryOperator> {

    public UnaryOperatorSerializer(ADLRulesSerializer serializer) {
        super(serializer);
    }

    @Override
    public void serialize(UnaryOperator ruleElement) {
        builder.append(ruleElement.getOperator().getDefaultCode());
        builder.append(" ");
        serializer.serializeRuleElement(ruleElement.getOperand());
    }
}
