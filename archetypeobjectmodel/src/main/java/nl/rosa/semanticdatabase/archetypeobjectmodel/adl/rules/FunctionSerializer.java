package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.rules;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLRulesSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.Expression;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.Function;

/**
 * Created by pieter.bos on 15/05/2017.
 */
public class FunctionSerializer extends RuleElementSerializer<Function>  {

    public FunctionSerializer(ADLRulesSerializer serializer) {
        super(serializer);
    }

    @Override
    public void serialize(Function ruleElement) {
        builder.append(ruleElement.getFunctionName());
        boolean first = true;

        builder.append("(");
        for(Expression expression:ruleElement.getArguments()) {
            if(!first) {
                builder.append(", ");
            }

            serializer.serializeRuleElement(expression);

            first = false;
        }

        builder.append(")");
    }
}
