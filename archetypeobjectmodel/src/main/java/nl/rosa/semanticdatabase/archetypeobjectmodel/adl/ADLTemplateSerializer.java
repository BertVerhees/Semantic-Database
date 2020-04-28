package nl.rosa.semanticdatabase.archetypeobjectmodel.adl;

import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.Archetype;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.Template;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.TemplateOverlay;

import java.util.function.Function;

/**
 * @author markopi
 */
class ADLTemplateSerializer extends ADLAuthoredArchetypeSerializer<Template> {

    public ADLTemplateSerializer(Template archetype, Function<String, Archetype> flatArchetypeProvider) {
        super(archetype, flatArchetypeProvider);
    }

    @Override
    protected String headTag() {
        return "template";
    }

    @Override
    protected String serialize() {
        super.serialize();
        archetype.getTemplateOverlays().forEach(this::appendTemplateOverlay);
        return builder.toString();
    }

    private void appendTemplateOverlay(TemplateOverlay templateOverlay) {
        builder.newline()
                .append("------------------------------------------------------------------------").newline()
                .append(ADLArchetypeSerializer.serialize(templateOverlay, flatArchetypeProvider));
    }
}
