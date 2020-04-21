package nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped;

import nl.rosa.semanticdatabase.referencemodel.model.internal.support.identification.ArchetypeId;
import nl.rosa.semanticdatabase.referencemodel.model.internal.support.identification.TemplateId;

import javax.annotation.Nullable;

/**
Archetypes act as the configuration basis for the particular structures of instances defined by the reference model.
To enable archetypes to be used to create valid data, key classes in the reference model act as root points for archetyping;
accordingly, these classes have the archetype_details attribute set.
An instance of the class ARCHETYPED contains the relevant archetype identification information,
allowing generating archetypes to be matched up with data instances.
 */
public class Archetyped {
    @Nullable
    private TemplateId templateId;
    private String rmVersion;
    // Globally unique archetype identifier.
    private ArchetypeId archetypeId;
}
