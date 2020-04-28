package nl.rosa.semanticdatabase.archetypeobjectmodel.aom;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.utils.AOMUtils;
import nl.rosa.semanticdatabase.base.Cardinality;
import nl.rosa.semanticdatabase.query.APathQuery;
import nl.rosa.semanticdatabase.referencemodel.model.internal.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.referencemodel.model.internal.paths.PathSegment;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CAttribute extends ArchetypeConstraint {

    private String rmAttributeName;
    private MultiplicityInterval existence;
    private String differentialPath;
    private boolean multiple;

    private Cardinality cardinality;

    private List<CObject> children = new ArrayList<>();

    public CAttribute() {

    }
    public CAttribute(String rmAttributeName) {
        this.rmAttributeName = rmAttributeName;
    }

    public CObject getChild(String nodeId) {
        //first don't look through CComplexObject proxies, then if no result, do lookup through the proxies
        CObject result = getChild(nodeId, false);
        if(result == null) {
            result = getChild(nodeId, true);
        }
        return result;
    }

    /**
     * Get the child cobject with the given nodeid. If it does not exist but a specialized version
     * does exist, returns that one.
     * If multiple specialized children exist, returns the first it can find. TODO: this should probably be better defined :)
     * @param nodeId
     * @return
     */
    public CObject getPossiblySpecializedChild(String nodeId) {
        //if there's an exact node id match, return that first
        CObject result = getChild(nodeId, false);
        if(result != null) {
            return result;
        }
        for(CObject child:children) {
            if(nodeId.equals(child.getNodeId()) || AOMUtils.codesConformant(child.getNodeId(), nodeId)) {
                return child;
            } else if(child instanceof CArchetypeRoot) {
                //TODO: Should we look for specialized archetype roots as well? :)
                if (((CArchetypeRoot) child).getArchetypeRef().equals(nodeId)) {
                    return child;
                }
            }
        }
        return null;
    }

    private CObject getChild(String nodeId, boolean lookThroughProxies) {
        for(CObject child:children) {
            if(nodeId.equals(child.getNodeId())) {
                return child;
            } else if(child instanceof CArchetypeRoot) {
                if (((CArchetypeRoot) child).getArchetypeRef().equals(nodeId)) {
                    return child;
                }
            } else if(lookThroughProxies && child instanceof CComplexObjectProxy) {
                String targetPath = ((CComplexObjectProxy) child).getTargetPath();
                APathQuery aPathQuery = new APathQuery(targetPath);
                PathSegment lastPathSegment = aPathQuery.getPathSegments().get(aPathQuery.getPathSegments().size() - 1);
                if(lastPathSegment.hasIdCode() && lastPathSegment.getNodeId().equals(nodeId)) {
                    return child;
                }
            }
        }
        return null;
    }

    @Override
    public CObject getParent() {
        return (CObject) super.getParent();
    }

    public CObject getChildByMeaning(String meaning) {
        meaning = meaning.toLowerCase();
        for(CObject child:children) {
            String childMeaning = child.getMeaning();
            if(childMeaning != null) {
                childMeaning = childMeaning.toLowerCase();
                if(meaning.equals(childMeaning)){
                    return child;
                }
            }

        }
        return null;
    }

    public List<CObject> getChildren() {
        return children;
    }

    public void setChildren(List<CObject> children) {
        if(children == null) {
            this.children = new ArrayList<>();
        } else {
            this.children = children;

            for(CObject child:children) {
                child.setParent(this);
            }
        }
    }

    /**
     * Add a child at the last position of the children list
     * @param child
     */
    public void addChild(CObject child) {
        children.add(child);
        child.setParent(this);
    }

    /**
     * Add a child at the given sibling order. Useful in the flattener
     *
     * @param child
     * @param order
     */
    public void addChild(CObject child, SiblingOrder order) {
        if(order != null && order.getSiblingNodeId() != null) {
            //TODO: this can be a specialized sibling node id as well!
            CObject sibling = getChild(order.getSiblingNodeId());
            int siblingIndex = getChildren().indexOf(sibling);
            if(siblingIndex > -1) {
                if (!order.isBefore()) {
                    siblingIndex++;
                }
                children.add(siblingIndex, child);
            } else{
                children.add(child);
            }
        } else {
            children.add(child);
        }
        child.setParent(this);
    }


    public void replaceChild(String nodeId, CObject constraint) {

        int index = getIndexOfChildWithNodeId(nodeId);
        if(index > -1) {
            children.set(index, constraint);
            constraint.setParent(this);
        } else {
            addChild(constraint);
        }

    }

    /**
     * Removes the child with a node id exactly the same as the given node id. In case multiple children match, removes
     * only the first child
     * @param nodeId
     */
    public void removeChild(String nodeId) {
        int index = getIndexOfChildWithNodeId(nodeId);
        if(index > -1) {
            children.remove(index);
        }
    }

    public void removeChild(CObject child) {
        int index = getIndexOfMatchingCObjectChild(child);
        if(index > -1) {
            children.remove(index);
        }
    }



    /**
     * Replace the child at node nodeId with all the objects from the parameter newChildren.
     * If keepOriginal is true, it will not replace the original, but keep it in place
     * and add the new elements directly after it
     * Useful operation for flattening
     */
    public void replaceChildren(String nodeId, List<CObject> newChildren, boolean keepOriginal) {
        int index = getIndexOfChildWithNodeId(nodeId);
        if(index > -1) {
            List<CObject> childrenBefore = children.subList(0, index+1);
            if(!keepOriginal) {
                childrenBefore.remove(index);
            }
            childrenBefore.addAll(newChildren);
            for(CObject constraint:newChildren) {
                constraint.setParent(this);
            }
        } else {
            for(CObject constraint:newChildren) {
                addChild(constraint);
            }
        }

    }

    public int getIndexOfMatchingCObjectChild(CObject child) {
        if(child instanceof CPrimitiveObject) {
            return getIndexOfChildWithMatchingRmTypeName(child.getRmTypeName());
        } else {
            return getIndexOfChildWithNodeId(child.getNodeId());
        }
    }

    public int getIndexOfChildWithMatchingRmTypeName(String rmTypeName) {
        for(int i = 0; i < children.size(); i++) {
            CObject child = children.get(i);
            if(rmTypeName.equals(child.getRmTypeName())) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexOfChildWithNodeId(String nodeId) {
        for(int i = 0; i < children.size(); i++) {
            CObject child = children.get(i);
            if(nodeId.equals(child.getNodeId())) {
                return i;
            }
        }
        return -1;
    }

    public List<PathSegment> getPathSegments() {
        CObject parent = getParent();
        if(parent == null) {
            return new ArrayList<>();
        }
        List<PathSegment> segments = parent.getPathSegments();
        if(differentialPath == null) {
            segments.add(new PathSegment(getRmAttributeName()));
        } else {
            segments.addAll(new APathQuery(differentialPath).getPathSegments());
        }
        return segments;
    }

    public String getLogicalPath() {
        String path = "/" + rmAttributeName;
        if(getParent() != null) {
            path = getParent().getLogicalPath() + path;
        }
        if(path.startsWith("//")) {
            return path.substring(1);
        }
        return path;
    }

//    public CAttribute clone() {
//        return (CAttribute) super.clone();
//    }


    /* Operations defined by UML */
    public boolean isSingle() {
        return !multiple;
    }

    public boolean isMandatory() {
        if(existence != null) {
            return existence.isMandatory();
        }
        return false;
    }

    public boolean anyAllowed() {
        return children.isEmpty() && !isProhibited();
    }


    public boolean isProhibited() {
        if(existence != null) {
            return existence.isProhibited();
        }
        return false;
    }

    public boolean isLeaf() {
        return children != null && children.size() > 0;
    }

    /**
     * True if constraints represented by this node contain no further redefinitions
     * with respect to the node other, with the exception of node_id redefnition in
     * C_OBJECT nodes. Typically used to test if an inherited node locally contains
     * any constraints.
     *
     * @param other
     * @return
     */
    //@Override
    public Boolean cCongruentTo(CAttribute other) {
        //True if this node on its own (ignoring any subparts) expresses no additional constraints than `other'.
        if(other == null) {
            return false;
        }

        return existence == null && ((isSingle() && other.isSingle()) || (isMultiple() && other.isMultiple() && cardinality == null));
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts,
     * are narrower or the same as other. Typically used during validation of
     * specialised archetype nodes.
     *
     * @param other
     * @return
     */
   // @Override
    public Boolean cConformsTo(CAttribute other) {
        //True if this node on its own (ignoring any subparts) expresses the same or narrower constraints as `other'.
        // Returns False if any of the following is incompatible:
        //	 * cardinality
        //   * existence
        if(other == null) {
            return false;
        }

        return existenceConformsTo(other) && ((isSingle() && other.isSingle()) || (isMultiple() && cardinalityConformsTo(other)));
    }

    public Boolean existenceConformsTo(CAttribute other) {
        //True if the existence of this node conforms to other.existence
        if(other == null) {
            return false;
        }
        if(existence != null && other.existence != null) {
            return other.existence.contains(existence);
        } else {
            return true;
        }
    }

    public Boolean cardinalityConformsTo(CAttribute other) {
        //True if the cardinality of this node conforms to other.cardinality, if it exists
        if(other == null) {
            return false;
        }
        if(cardinality != null && other.cardinality != null) {
            return other.cardinality.contains(cardinality);
        } else {
            return true;
        }
    }

    public boolean isSecondOrderConstrained() {
        return getSocParent() != null || (getParent() != null && getParent().getSocParent() != null);
    }


    /**
     * Get the sum of all occurrences of all direct children of this c_attribute
     * calculates sum of all occurrences lower bounds; where no occurrences are stated, 0 is assumed
     * @return
     */
    public int getAggregateOccurrencesLowerSum() {
        int sum = 0;
        for(CObject cObject:getChildren()) {
            if(cObject.getOccurrences() != null) {
                sum+= cObject.getOccurrences().getLower();
            }
        }
        return sum;
    }

    /**
     *  calculate minimum number of child objects that must occur in data; count 1 for every mandatory
     *  object, and 1 for all optional objects
     * @return
     */
    public int getMinimumChildCount() {
        int result = 0;
        boolean foundOptional = false;
        for(CObject cObject:getChildren()) {
            if(cObject.isRequired()) {
                result++;
            } else if(cObject.isAllowed()) {
                foundOptional = true;
            }
        }
        if(foundOptional) {
            result++;
        }
        return result;
    }


    /**
     * Return all children that have the exact same type name as input.
     * @param rmTypeName
     * @return
     */
    public List<CObject> getChildrenByRmTypeName(String rmTypeName) {
        List<CObject> result = new ArrayList<>();

        for(int i = 0; i < children.size(); i++) {
            CObject child = children.get(i);
            if(rmTypeName.equals(child.getRmTypeName())) {
                result.add(child);
            }
        }

        return result;
    }
}
