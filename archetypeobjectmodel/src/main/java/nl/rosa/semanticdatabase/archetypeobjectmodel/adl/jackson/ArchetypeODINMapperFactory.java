package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.ResourceDescription;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology.ArchetypeTerm;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology.ArchetypeTerminology;

public class ArchetypeODINMapperFactory {

    public ODINMapper createMapper() {
        ODINMapper result = new ODINMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(ArchetypeTerm.class, new ArchetypeTermOdinSerializer());
        module.setMixInAnnotation(ArchetypeTerminology.class, ArchetypeTerminologyMixin.class);
        module.setMixInAnnotation(ResourceDescription.class, ResourceDescriptionMixin.class);
        result.disableDefaultTyping();//no typing info for archetype ODIN needed
        result.registerModule(module);
        return result;
    }
}
