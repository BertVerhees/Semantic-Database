package nl.rosa.semanticdatabase.referencemodel.model.common;

import java.util.UUID;

public class Locatable {
    // Runtime name of this fragment, used to build runtime paths. This is the term provided via an application or batch process to name this construct:
    // its retention in the application faithfully preserves the original label by which this entry was known to end users.
    private String name;
    // Design-time archetype identifier of this node taken from its generating archetype; used to build archetype paths.
    // Always in the form of an at-code, e.g. at0005. This value enables a 'standardised' name for this node to be generated,
    // by referring to the generating archetype local terminology.
    // At an archetype root point, the value of this attribute is always the stringified form of the archetype_id found in the archetype_details object.
    private String archetypeNodeId;
    // Optional globally unique object identifier for root points of archetyped structures.
    private UUID uid;
}
