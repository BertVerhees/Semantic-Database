package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.Objects;
import java.util.function.BiFunction;

import nl.rosa.semanticdatabase.aom2.utils.AOMUtils;
import semanticdatabase.base.conformance_checker.RMConformanceChecker;
import semanticdatabase.foundation_types.interval.MultiplicityInterval;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstract model of constraint on any kind of object node.
 */
public abstract class CObject extends ArchetypeConstraint {

    //***** CObject *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Reference model type that this node corresponds to.
     * cardinality: 1..1
     */
    private String rmTypeName;

    /**
     * Occurrences of this object node in the data, under the owning attribute.
     * Upper limit can only be greater than 1 if owning attribute has a cardinality of more than 1.
     * Only set if it overrides the parent archetype in the case of specialised archetypes, or else the occurrences inferred from the underlying reference model existence and/or cardinality of the containing attribute.
     * cardinality: 0..1
     */
    private MultiplicityInterval occurrences;

    /**
     * Semantic identifier of this node, used to dis-tinguish sibling nodes.
     * All nodes must have a node_id; for nodes under a container C_ATTRIBUTE, the id must be an id-code must be defined in the archetype terminology.
     * For valid structures, all node ids are id-codes.
     * For C_PRIMITIVE_OBJECTs, it will have the special value Primitive_node_id.
     * cardinality: 1..1
     */
    private String nodeId;

    /**
     * True if this node and by implication all sub-nodes are deprecated for use.
     * cardinality: 0..1
     */
    private Boolean isDeprecated;

    /**
     * Optional indicator of order of this node with respect to another sibling.
     * Only meaningful in a specialised archetype for a C_OBJECT within a C_ATTRIBUTE with is_multiple = True.
     * cardinality: 0..1
     */
    private SiblingOrder siblingOrder;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Reference model type that this node corresponds to.
     * cardinality: 1..1
     */
    public String getRmTypeName() {
        return rmTypeName;
    }

    public void setRmTypeName(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:rmTypeName failed, it has cardinality NonNull, but is null");
        }
        this.rmTypeName = rmTypeName;
    }

    /**
     * Occurrences of this object node in the data, under the owning attribute.
     * Upper limit can only be greater than 1 if owning attribute has a cardinality of more than 1.
     * Only set if it overrides the parent archetype in the case of specialised archetypes, or else the occurrences inferred from the underlying reference model existence and/or cardinality of the containing attribute.
     * cardinality: 0..1
     */
    public MultiplicityInterval getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(MultiplicityInterval value) {
        this.occurrences = occurrences;
    }

    /**
     * Semantic identifier of this node, used to dis-tinguish sibling nodes.
     * All nodes must have a node_id; for nodes under a container C_ATTRIBUTE, the id must be an id-code must be defined in the archetype terminology.
     * For valid structures, all node ids are id-codes.
     * For C_PRIMITIVE_OBJECTs, it will have the special value Primitive_node_id.
     * cardinality: 1..1
     */
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:nodeId failed, it has cardinality NonNull, but is null");
        }
        this.nodeId = nodeId;
    }

    /**
     * True if this node and by implication all sub-nodes are deprecated for use.
     * cardinality: 0..1
     */
    public Boolean getIsDeprecated() {
        return isDeprecated;
    }

    public void setIsDeprecated(Boolean value) {
        this.isDeprecated = isDeprecated;
    }

    /**
     * Optional indicator of order of this node with respect to another sibling.
     * Only meaningful in a specialised archetype for a C_OBJECT within a C_ATTRIBUTE with is_multiple = True.
     * cardinality: 0..1
     */
    public SiblingOrder getSiblingOrder() {
        return siblingOrder;
    }

    public void setSiblingOrder(SiblingOrder value) {
        this.siblingOrder = siblingOrder;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Level of specialisation of this archetype node, based on its node_id.
     * The value 0 corresponds to non-specialised, 1 to first-level specialisation and so on.
     * The level is the same as the number of ‘.’ characters in the node_id code.
     * If node_id is not set, the return value is -1, signifying that the specialisation level should be determined from the nearest parent C_OBJECT node having a node_id.
     * cardinality: 1..1
     */
    public Integer specialisationDepth() {
        Integer result = AOMUtils.getSpecializationDepthFromCode(nodeId);
        ;
        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Compute effective occurrences, where no local occurrences constraint set.
     * If the owning C_ATTRIBUTE.cardinality is set, use its upper value, else use RM multiplicity of the owning attribute.
     * If local occurrences not set, always assume 0 as the lower bound.
     * cardinality: 1..1
     */
    public MultiplicityInterval effectiveOccurrences() {
        MultiplicityInterval result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }


    /**
     * True if constraints represented by this node contain no further redefinitions with respect to the node other, with the exception of node_id redefnition in C_OBJECT nodes.
     * Typically used to test if an inherited node locally contains any constraints.
     * cardinality: 1..1 (effected)
     *
     * @return
     */
    public java.lang.Boolean cCongruentTo(CObject other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if this node occurrences conforms to other.occurrences; `other' is assumed to be in a flat archetype.
     * Parameters other C_OBJECT from a flat parent archetype.
     * cardinality: 1..1
     */
    public boolean occurrencesConformsTo(CObject other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        if (occurrences != null && other.occurrences != null) {
            return other.occurrences.contains(occurrences);
        } else {
            return true;
        }
    }



    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
     * Typically used during validation of special-ised archetype nodes.
     * cardinality: 1..1 (effected)
     * <p>
     * Post: Result = existence_conforms_to (other) and is_single and other.is_single) or else (is_multiple and cardinality_conforms_to (other)
     */
    public Boolean cConformsTo(CObject other, BiFunction<String, String, Boolean> rmTypesConformant) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return nodeIdConformsTo(other) &&
                occurrencesConformsTo(other)
                && typeNameConformsTo(other, rmTypesConformant);

    }

    public boolean typeNameConformsTo(CObject other, BiFunction<String, String, Boolean> rmTypesConformant) {
        if (other.getRmTypeName() == null || getRmTypeName() == null) {
            return true;//these are not nullable, but we're not throwing exceptions here
        }
        if (other.getRmTypeName().equalsIgnoreCase(getRmTypeName())) {
            return true;
        }
        return rmTypesConformant.apply(getRmTypeName(), other.getRmTypeName());
    }

    public boolean nodeIdConformsTo(CObject other) {
        return AOMUtils.codesConformant(this.getNodeId(), other.getNodeId());
    }


    /**
     * True if this C_ATTRIBUTE has an existence constraint of 0..0, i.e.
     * prohibition.
     * cardinality: 1..1 (effected)
     * <p>
     * Post: Result = existence /= Void and then existence.is_prohibited
     */
    @Override
    public Boolean isProhibited() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** CObject *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CObject that = (CObject) object;
        return
                Objects.equals(rmTypeName, that.rmTypeName) &&
                        Objects.equals(occurrences, that.occurrences) &&
                        Objects.equals(nodeId, that.nodeId) &&
                        Objects.equals(isDeprecated, that.isDeprecated) &&
                        Objects.equals(siblingOrder, that.siblingOrder);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                rmTypeName,
                occurrences,
                nodeId,
                isDeprecated,
                siblingOrder
        );
    }

    @Override
    public java.lang.String toString() {
        return
                "CObject {" +
                        "rmTypeName='" + rmTypeName + '\'' +
                        "occurrences='" + occurrences + '\'' +
                        "nodeId='" + nodeId + '\'' +
                        "isDeprecated='" + isDeprecated + '\'' +
                        "siblingOrder='" + siblingOrder + '\'' +
                        '}';
    }

}

/**
 * ***** BEGIN LICENSE BLOCK *****
 * <p>
 * ISC License
 * <p>
 * Copyright (c) 2020, Bert Verhees
 * <p>
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * <p>
 * ***** END LICENSE BLOCK *****
 */
