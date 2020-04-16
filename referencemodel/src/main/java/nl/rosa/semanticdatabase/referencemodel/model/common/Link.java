package nl.rosa.semanticdatabase.referencemodel.model.common;

import nl.rosa.semanticdatabase.referencemodel.model.support.datavalues.DvText;
import nl.rosa.semanticdatabase.referencemodel.model.support.datavalues.DvURI;

/**
The LINK type defines a logical relationship between two items, such as two ENTRYs or an ENTRY and a COMPOSITION.
Links can be used across compositions, and across EHRs. Links can potentially be used between interior (i.e. non archetype root)
nodes, although this probably should be prevented in archetypes.
Multiple LINKs can be attached to the root object of any archetyped structure to give the effect of a 1→N link.

1:1 and 1:N relationships between archetyped content elements (e.g. ENTRYs) can be expressed by using one, or more than one,
respectively, LINKs. Chains of links can be used to see problem threads or other logical groupings of items.

Links should be between archetyped structures only, i.e. between objects representing complete domain concepts because
relationships between sub-elements of whole concepts are not necessarily meaningful, and may be downright confusing.
Sensible links only exist between whole ENTRYs, SECTIONs, COMPOSITIONs and so on.
 */
public class Link {
    /**
     * Used to describe the relationship, usually in clinical terms, such as in response to
     * (the relationship between test results and an order), follow-up to and so on. Such relationships can
     * represent any clinically meaningful connection between pieces of information. Values for meaning include those
     * described in Annex C, ENV 13606 pt 2 under the categories of generic , documenting and reporting , organisational ,
     * clinical , circumstancial , and view management .
     */
    private DvText meaning;
    /**
     * The type attribute is used to indicate a clinical or domain-level meaning for the kind of link, for example problem or issue .
     * If type values are designed appropriately, they can be used by the requestor of EHR extracts to categorise links
     * which must be followed and which can be broken when the extract is created.
     */
    private DvText type;
    /**
     * The logical to object in the link relation, as per the linguistic sense of the meaning attribute.
     */
    private DvURI target;
}
