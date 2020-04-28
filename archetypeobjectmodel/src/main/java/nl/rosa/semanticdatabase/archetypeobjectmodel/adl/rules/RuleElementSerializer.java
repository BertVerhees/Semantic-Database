package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.rules;

import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLRulesSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLStringBuilder;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.RuleElement;

/**
 * Created by pieter.bos on 15/06/16.
 */
public abstract class RuleElementSerializer<T extends RuleElement> {
    protected final ADLRulesSerializer serializer;
    protected final ADLStringBuilder builder;

    public RuleElementSerializer(ADLRulesSerializer serializer) {
        this.serializer = serializer;
        this.builder = serializer.getBuilder();
    }

    abstract public void serialize(T ruleElement);

    public String getSimpleCommentText(T ruleElement) {
        return null;
    }

    public boolean isEmpty(T ruleElement) {
        return false;
    }

}
