package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.rules;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLRulesSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.ForAllStatement;

/**
 * Created by pieter.bos on 15/06/16.
 */
public class ForAllStatementSerializer extends RuleElementSerializer<ForAllStatement> {

    public ForAllStatementSerializer(ADLRulesSerializer serializer) {
        super(serializer);
    }

    @Override
    public void serialize(ForAllStatement ruleElement) {
        builder.append("for_all");
        builder.append(" ");
        builder.append("$");
        builder.append(ruleElement.getVariableName());
        builder.append(" ");
        builder.append("in");
        builder.append(" ");
        serializer.serializeRuleElement(ruleElement.getPathExpression());
        builder.newIndentedLine();
        builder.append(" ");
        serializer.serializeRuleElement(ruleElement.getAssertion());
        builder.unindent();
    }
}
