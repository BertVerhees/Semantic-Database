package nl.rosa.semanticdatabase.referencemodel.model.common;

/**
Archetypes act as the configuration basis for the particular structures of instances defined by the reference model.
To enable archetypes to be used to create valid data, key classes in the reference model act as root points for archetyping;
accordingly, these classes have the archetype_details attribute set.
An instance of the class ARCHETYPED contains the relevant archetype identification information,
allowing generating archetypes to be matched up with data instances.
 */
public class Archetyped {
    // Globally unique archetype identifier.
    private String archetypeId;
}
