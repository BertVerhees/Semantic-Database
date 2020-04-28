package nl.rosa.semanticdatabase.archetypeobjectmodel.adl;

import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.Archetype;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.OperationalTemplate;

import java.util.function.Function;

/**
 * @author markopi
 */
class ADLOperationalTemplateSerializer extends ADLAuthoredArchetypeSerializer<OperationalTemplate> {

    public ADLOperationalTemplateSerializer(OperationalTemplate archetype, Function<String, Archetype> flatArchetypeProvider) {
        super(archetype, flatArchetypeProvider);
    }

    @Override
    protected String serialize() {
        super.serialize();
        builder.newline().append("component_terminologies").newIndentedLine()
                .append("component_terminologies = < ") //todo: this should perhaps be in the ODIN serializer?
                .indent()
                .odin(archetype.getComponentTerminologies())
                .unindent()
                .append("> ")
                .unindent();
        return builder.toString();
    }

    @Override
    protected String headTag() {
        return "operational_template";
    }
}
