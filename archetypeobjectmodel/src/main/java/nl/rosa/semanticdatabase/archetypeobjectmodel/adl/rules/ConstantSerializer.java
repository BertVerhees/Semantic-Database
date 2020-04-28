package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.rules;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLRulesSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.Constant;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.ExpressionType;

/**
 * Created by pieter.bos on 15/06/16.
 */
public class ConstantSerializer extends RuleElementSerializer<Constant> {
    public ConstantSerializer(ADLRulesSerializer adlRulesSerializer) {
        super(adlRulesSerializer);
    }

    @Override
    public void serialize(Constant ruleElement) {
        if(ruleElement.getType() == ExpressionType.STRING) {
            builder.append("\"");
            builder.append(ruleElement.getValue());
            builder.append("\"");
        } else {
            builder.append(ruleElement.getValue());
        }
    }
}
