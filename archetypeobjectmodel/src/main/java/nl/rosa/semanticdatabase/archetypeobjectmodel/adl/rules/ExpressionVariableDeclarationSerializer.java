package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.rules;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLRulesSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.ExpressionVariable;

/**
 * Created by pieter.bos on 15/06/16.
 */
public class ExpressionVariableDeclarationSerializer extends RuleElementSerializer<ExpressionVariable> {

    public ExpressionVariableDeclarationSerializer(ADLRulesSerializer serializer) {
        super(serializer);
    }

    @Override
    public void serialize(ExpressionVariable variableDeclaration) {

        builder.append("$");
        builder.append(variableDeclaration.getName());
        builder.append(":");
        builder.append(variableDeclaration.getType().toString());
        builder.append(" ::= ");
        serializer.serializeRuleElement(variableDeclaration.getExpression());
        builder.newline();

    }
}
