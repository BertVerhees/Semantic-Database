package nl.rosa.semanticdatabase.aom2.the_rm_overlay_package;
/**
 * 6.
 * The RM Overlay Package
 * 6.1.
 * Overview
 * Classes in the aom2.rm_overlay package are used to support definition of settings relating to unconstrained RM attributes of constrained object nodes (including the top-level object) within the archetype.
 * The UML model is shown below.
 * <p>
 * <p>
 * <p>
 * Figure 23.
 * am.aom2.rm_overlay package
 * 6.2.
 * Semantics
 * <p>
 * 6.2.1.
 * RM Attribute Visibility
 * Currently, the only RM overlay settings are for RM attribute visibility, which relates to RM attributes within the context of an archetype.
 * This is described in more detail in the ADL2 specification.
 * The visibility settings consist of a list of per-RM attribute settings, in the form of instances of the class RM_ATTRIBUTE_VISIBILITY, each keyed by the RM path to the node(s) to which they apply.
 * The path is formed of an object node path within the archetype follwed by a path to an RM attribute, which may be on an already-constrained path, or may be a path not already included in the archetype structure.
 * The former part is one of: the root path, /; an object path within the archetyped structure e.g.
 * /items[id20].
 * The latter part is a path containing no object identifiers (id-codes), of one or mode RM attribute names from the Reference Model.
 * The terminal attribute name will almost always be a single-valued attribute, since the visibility of container attributes will almost always be defined in terms of specifically constrained child objects, i.e.
 * part of the archetyped structure.
 * Two types of RM visibility can be specified.
 * First, in terms of attribute visibility within modelling tools, using the values show and hide.
 * A non-archetyped RM attribute is by default not visible within an archetype modelling tool visualisation, since it is not part of the archetyped structure.
 * Without visibility settings, the only means of displaying such an attrbute is to display all non-archetyped RM attributes in some generic fashion.
 * Setting the visibility on a particular RM attribute path to show indicates to the tool that this RM attribute should be displayed, along with the archetyped structure - preferably in a visually distinct way.
 * This enables modellers to see specific model attributes that are built into the RM, and do not need to be modelled as archetype objects.
 * The hide setting is to allow two possibilities: to reverse the show setting for an attribute’s visibility in a specialisation parent in the current archetype; and to hide an already-archetyped RM attribute in a specialisation child archetype.
 * The visibility setting for an RM attribute with respect to the specialisation lineage (aka inheritance hierarchy) is just the most recent setting, i.e.
 * the setting from the deepest child.
 * A second visibility setting is an optional alias, which is specified in the form of an ad-code (similar to an id-code) whose definition is found in the terminology section of the archetype, in the usual fashion.
 * An alias can be associated with any RM path in the archetype, including non-archetyped RM attributes reachable from the root RM type of the archetype.
 * Definition of an alias enables an RM attribute node to be multi-lingually renamed from its default RM name.
 * 6.2.1.1.
 * Validity If the alias attribute is set, the visibility must also be set.
 * Normally this should be set to show, ahtough the value is not currently mandated, in order to allow possible extension of visibility settings beyond just show and hide.
 * 6.3.
 * Class Descriptions
 * <p>
 * 6.3.1.
 * RM_OVERLAY Class
 * <p>
 * 6.3.2.
 * RM_ATTRIBUTE_VISIBILITY Class
 * <p>
 * 6.3.3.
 * VISIBILITY_TYPE Enumeration
 */
