package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Meta-type corresponding a class definition in an object model.
 * Inheritance is specified by the ancestors attribute, which contains a list of nl.rosa.semanticdatabase.bmm.model.types rather than classes.
 * Inheritance is thus understood in BMM as a stated relationship between classes.
 * The equivalent relationship between nl.rosa.semanticdatabase.bmm.model.types is conformance.
 *
 * NOTE: unlike UML, the name is just the root name, even if the class is generic. Use type_name() to obtain the qualified type name.
 */

@Getter
@Setter
public class RMClass extends RMClassifier {
    /**
     * Name of this class. Note that unlike UML, names of classes are just the root name, even if the class is generic.
     */
    private String name;
    /**
     * List of immediate inheritance parents.
     */
    private Map<String, RMClass> ancestors;
    /**
     * Package this class belongs to.
     */
    private RMPackage _RM_package;
    /**
     * The Schema containing this class
     */
    private RMModel RMModel;
    /**
     * List of attributes defined in this class.
     */
    private Map<String, RMProperty> properties;
    /**
     * Reference to original source schema defining this class. Useful for UI tools to determine which original schema
     * file to open for a given class for manual editing.
     */
    private String sourceSchemaId;
    /**
     * List of immediate inheritance descendants.
     */
    private List<String> immediateDescendants;
    /**
     * True if this class is abstract in its model.
     */
    private boolean isAbstract;
    /**
     * True if this class is designated a primitive type within the overall type system of the schema.
     */
    private boolean isPrimitiveType;
    /**
     * True if this definition overrides a class of the same name in an included schema.
     */
    private Boolean isOverride;

    private RMClass flattenedRMClassCache;

    public RMClass() {
        properties = new LinkedHashMap<>();
        ancestors = new LinkedHashMap<>();
        immediateDescendants = new ArrayList<>();
    }

    public RMClass(String name) {
        this();
        this.name = name;
    }

    /**
     * Method adds ancestor to class. Ancestor must have a name.
     *
     * @param ancestor
     */
    public void addAncestor(RMClass ancestor) {
        ancestors.put(ancestor.name, ancestor);
    }
    /**
     * Method adds immediate descendant for this class.
     *
     * @param immediateDecendant
     */
    public void addImmediateDescendant(String immediateDecendant) {
        this.immediateDescendants.add(immediateDecendant);
    }

    /**
     * Returns list of all inheritance parent class names, recursively.
     *
     * @return
     */
    public List<String> findAllAncestors() {
        List<String> allAncestors = new ArrayList<String>();
        Map<String, RMClass> ancestors = getAncestors();
        allAncestors.addAll(ancestors.keySet());
        for(RMClass ancestor:ancestors.values()) {
            allAncestors.addAll(ancestor.findAllAncestors());
        }
        return allAncestors;
    }

    /**
     * Compute all descendants by following immediate_descendants.
     *
     * @return
     */
    public List<String> findAllDescendants() {
        List<String> allDescendants = new ArrayList<String>();
        List<String> descendants = getImmediateDescendants();
        allDescendants.addAll(descendants);
        for(String descendant:descendants) {
            RMClass classDefinition = RMModel.getClassDefinition(descendant);
            if(classDefinition != null) {
                allDescendants.addAll(classDefinition.findAllDescendants());
            }
        }
        return allDescendants;
    }

    /**
     * List of names of immediate supplier classes, including concrete generic parameters, concrete descendants of
     * abstract statically defined nl.rosa.semanticdatabase.bmm.model.types, and inherited suppliers. (Where generics are unconstrained, no class name is
     * added, since logically it would be 'ANY' and this can always be assumed anyway). This list includes primitive nl.rosa.semanticdatabase.bmm.model.types.
     *
     * @return
     */
    public List<String> findSuppliers() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Same as `suppliers' minus primitive nl.rosa.semanticdatabase.bmm.model.types, as defined in input schema.
     *
     * @return
     */
    public List<String> findSuppliersNonPrimitive() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * List of names of all classes in full supplier closure, including concrete generic parameters; (where generics
     * are unconstrained, no class name is added, since logically it would be 'ANY' and this can always be assumed
     * anyway). This list includes primitive nl.rosa.semanticdatabase.bmm.model.types.
     *
     * @return
     */
    public List<String> findSupplierClosure() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Fully qualified package name, of form: 'package.package'.
     *
     * @return
     */
    public String getPackagePath() {
        if (_RM_package != null) {
            return _RM_package.getPath();
        } else {
            return null;
        }
    }
    /**
     * Fully qualified class name, of form: 'package.package.CLASS' with package path in lower-case and class in
     * original case.
     *
     * @return
     */
    public String getClassPath() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    /**
     * List of all properties due to current and ancestor classes, keyed by property name.
     *
     * @return
     */
    public List<Map<String, RMProperty<RMType>>> getFlatProperties() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public RMClass getBaseClass() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String getTypeName() {
        return name;
    }
    /**
     * Method creates a child class that is the flattened version of the hierarchical structure.
     *
     */

    private RMClass flattenedClassCache;

    public RMClass flattenClass() {
        if(this.flattenedClassCache != null) {
            return flattenedClassCache;
        }
        Map<String, RMClass> ancestorMap = this.getAncestors();
        if (ancestorMap.size() == 0) {
            flattenedClassCache = duplicate();
        } else {
            final RMClass target = this.duplicate();
            //add all properties from all ancestors the new flattened class
            ancestorMap.forEach( (ancestorName, ancestor) -> { populateTarget(ancestor, target); });
            flattenedClassCache = target;
        }
        return flattenedClassCache;
    }

    public String effectivePropertyType(String propertyName) {
        RMProperty RMProperty = flattenClass().getProperties().get(propertyName);
        if(RMProperty != null) {
            return RMProperty.getType().getTypeName();
        } else {
            return RMDefinitions.UNKNOWN_TYPE_NAME;
        }
    }

    protected void populateTarget(RMClass source, RMClass target) {
        Map<String, RMProperty> propertyMap = source.getProperties();
        propertyMap.values().forEach(property -> handleFlattenedProperty(property, target));
        source.getAncestors().values().forEach(ancestor -> populateTarget(ancestor, target));
    }

    protected void handleFlattenedProperty(RMProperty RMProperty, RMClass target) {
        if (target.hasPropertyWithName(RMProperty.getName())) {
            //this is fine, it has been validated to be conformant and just overrides the old property
        } else {
            target.addProperty(RMProperty);
        }
    }

    /**
     * Creates a shallow clone of the class.
     *
     * @return
     */
    public RMClass duplicate() {
        RMClass target = null;
        if(this instanceof RMGenericClass) {
            target = new RMGenericClass();
        } else {
            target = new RMClass();
        }
        target.setName(this.getName());
        target.getProperties().putAll(this.getProperties());
        target.setAbstract(this.isAbstract);
        target.setSourceSchemaId(this.getSourceSchemaId());
        target.getAncestors().putAll(this.getAncestors());
        target.setImmediateDescendants(this.getImmediateDescendants());
        target.setOverride(this.isOverride);
        target.setPrimitiveType(this.isPrimitiveType);
        target.set_RM_package(this.get_RM_package());
        target.setRMModel(this.getRMModel());
        return target;
    }

    public Boolean hasPropertyWithName(String propertyName) {
        return properties.get(propertyName) != null;
    }

    /**
     * Returns True if this definition overrides a class of the same name in an included schema.
     *
     * @return
     */
    public boolean isOverride() {
        return isOverride;
    }

    /**
     * Set to True if this definition overrides a class of the same name in an included schema.
     *
     * @param override
     */
    public void setOverride(boolean override) {
        isOverride = override;
    }

    /**
     * returns true if this class is abstract in its model.
     *
     * @return
     */
    public boolean isAbstract() {
        return isAbstract;
    }

    /**
     * Sets true if this class is abstract in its model.
     *
     * @param anAbstract
     */
    public void setAbstract(boolean anAbstract) {
        isAbstract = anAbstract;
    }

    /**
     * Returns True if this class is designated a primitive type within the overall type system of the schema.
     *
     * @return
     */
    public boolean isPrimitiveType() {
        return isPrimitiveType;
    }

    /**
     * Set to True if this class is designated a primitive type within the overall type system of the schema.
     *
     * @param primitiveType
     */
    public void setPrimitiveType(boolean primitiveType) {
        isPrimitiveType = primitiveType;
    }

    /**
     * Method adds property to class.
     *
     * @param RMProperty
     */
    public void addProperty(RMProperty RMProperty) {
        properties.put(RMProperty.getName(), RMProperty);
    }

}
