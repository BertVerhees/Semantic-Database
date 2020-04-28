package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.constraints;


import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLDefinitionSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ADLRulesSerializer;
import nl.rosa.semanticdatabase.archetypeobjectmodel.adl.ArchetypeSerializeUtils;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.ArchetypeSlot;
import nl.rosa.semanticdatabase.archetypeobjectmodel.rules.Assertion;

/**
 * Created by bna on 27.01.2015.
 * <p>
 * allow_archetype CLUSTER[at1030] occurrences matches {0..1} matches {	-- Exertion
 * include
 * archetype_id/value matches {/openEHR-EHR-CLUSTER\.level_of_exertion(-[a-zA-Z0-9_]+)*\.v1/}
 * }
 */
public class ArchetypeSlotSerializer extends ConstraintSerializer<ArchetypeSlot> {

    public ArchetypeSlotSerializer(ADLDefinitionSerializer serializer) {
        super(serializer);
    }

    @Override
    public void serialize(ArchetypeSlot cobj) {
        builder.indent().newline();
        appendSiblingOrder(cobj);
        builder.append("allow_archetype")
                .append(" ")
                .append(cobj.getRmTypeName()).append("[").append(cobj.getNodeId()).append("]");
        if (cobj.getOccurrences() != null) {
            builder.append(" occurrences matches {");
            ArchetypeSerializeUtils.buildOccurrences(builder, cobj.getOccurrences());
            builder.append("}");
        }
        if (cobj.isClosed()) {
            builder.append(" closed");
        } else {
            appendMatches(cobj);
        }
        builder.unindent();
    }

    private void appendMatches(ArchetypeSlot cobj) {
        int mark = builder.mark();
        builder.append(" matches { ");
        builder.lineComment(serializer.getTermText(cobj));
        boolean hasContent = false;

        ADLRulesSerializer serializer = new ADLRulesSerializer(builder, super.serializer);
        if (cobj.getIncludes() != null && cobj.getIncludes().size() > 0) {
            hasContent = true;
            builder.indent().newline()
                    .append("include")
                    .indent();

            for (Assertion a : cobj.getIncludes()) {
                builder.newline();
                serializer.serializeRuleElement(a.getExpression());
            }
            builder.unindent().unindent();
        }
        if (cobj.getExcludes() != null && cobj.getExcludes().size() > 0) {
            hasContent = true;
            builder.indent().newline()
                    .append("exclude")
                    .indent();
            for (Assertion a : cobj.getExcludes()) {
                builder.newline();
                serializer.serializeRuleElement(a.getExpression());
            }
            builder.unindent().unindent();
        }

        if (hasContent) {
            builder.clearMark();
            builder.newline().append("}");
        } else {
            builder.revert(mark);
        }
    }
}
