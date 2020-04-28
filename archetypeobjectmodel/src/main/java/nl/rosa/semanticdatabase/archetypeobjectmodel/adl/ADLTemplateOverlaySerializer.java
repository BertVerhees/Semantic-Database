package nl.rosa.semanticdatabase.archetypeobjectmodel.adl;

import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.Archetype;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.TemplateOverlay;

import java.util.function.Function;

/**
 * @author markopi
 */
class ADLTemplateOverlaySerializer extends ADLArchetypeSerializer<TemplateOverlay> {


    public ADLTemplateOverlaySerializer(TemplateOverlay archetype, Function<String, Archetype> flatArchetypeProvider) {
        super(archetype, flatArchetypeProvider);
    }

    @Override
    protected String headTag() {
        return "template_overlay";
    }

    @Override
    protected void appendHeaderAttributes() {
    }

    @Override
    protected void appendLanguage() {
    }

    @Override
    protected void appendDescription() {
    }

    @Override
    protected void appendRules() {

    }
}
