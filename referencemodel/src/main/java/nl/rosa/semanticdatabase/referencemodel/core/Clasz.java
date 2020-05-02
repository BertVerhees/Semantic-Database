package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.Definitions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Default created on 29-4-2020
 */

@Getter
@Setter
public class Clasz extends Classifier{
    /**
     * Name of this class. Note that unlike UML, names of classes are just the root name, even if the class is generic.
     */
    private String name;
    /**
     * List of immediate inheritance parents.
     */
    private Map<String, Clasz> ancestors;
    /**
     * Package this class belongs to.
     */
    private Package _package;
    /**
     * The Schema containing this class
     */
    private Model model;
    /**
     * List of attributes defined in this class.
     */
    private Map<String, Property> properties;
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

    private Clasz flattenedClaszCache;

    public Clasz() {
        properties = new LinkedHashMap<>();
        ancestors = new LinkedHashMap<>();
        immediateDescendants = new ArrayList<>();
    }

    public Clasz(String name) {
        this();
        this.name = name;
    }

    /**
     * Method adds ancestor to class. Ancestor must have a name.
     *
     * @param ancestor
     */
    public void addAncestor(Clasz ancestor) {
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
        Map<String, Clasz> ancestors = getAncestors();
        allAncestors.addAll(ancestors.keySet());
        for(Clasz ancestor:ancestors.values()) {
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
            Clasz classDefinition = model.getClassDefinition(descendant);
            if(classDefinition != null) {
                allDescendants.addAll(classDefinition.findAllDescendants());
            }
        }
        return allDescendants;
    }

    /**
     * List of names of immediate supplier classes, including concrete generic parameters, concrete descendants of
     * abstract statically defined types, and inherited suppliers. (Where generics are unconstrained, no class name is
     * added, since logically it would be 'ANY' and this can always be assumed anyway). This list includes primitive types.
     *
     * @return
     */
    public List<String> findSuppliers() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Same as `suppliers' minus primitive types, as defined in input schema.
     *
     * @return
     */
    public List<String> findSuppliersNonPrimitive() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * List of names of all classes in full supplier closure, including concrete generic parameters; (where generics
     * are unconstrained, no class name is added, since logically it would be 'ANY' and this can always be assumed
     * anyway). This list includes primitive types.
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
        if (_package != null) {
            return _package.getPath();
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
    public List<Map<String, Property<Type>>> getFlatProperties() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Clasz getBaseClass() {
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

    private Clasz flattenedClassCache;

    public Clasz flattenClass() {
        if(this.flattenedClassCache != null) {
            return flattenedClassCache;
        }
        Map<String, Clasz> ancestorMap = this.getAncestors();
        if (ancestorMap.size() == 0) {
            flattenedClassCache = duplicate();
        } else {
            final Clasz target = this.duplicate();
            //add all properties from all ancestors the new flattened class
            ancestorMap.forEach( (ancestorName, ancestor) -> { populateTarget(ancestor, target); });
            flattenedClassCache = target;
        }
        return flattenedClassCache;
    }

    public String effectivePropertyType(String propertyName) {
        Property property = flattenClass().getProperties().get(propertyName);
        if(property != null) {
            return property.getType().getTypeName();
        } else {
            return Definitions.UNKNOWN_TYPE_NAME;
        }
    }

    protected void populateTarget(Clasz source, Clasz target) {
        Map<String, Property> propertyMap = source.getProperties();
        propertyMap.values().forEach(property -> handleFlattenedProperty(property, target));
        source.getAncestors().values().forEach(ancestor -> populateTarget(ancestor, target));
    }

    protected void handleFlattenedProperty(Property property, Clasz target) {
        if (target.hasPropertyWithName(property.getName())) {
            //this is fine, it has been validated to be conformant and just overrides the old property
        } else {
            target.addProperty(property);
        }
    }

    /**
     * Creates a shallow clone of the class.
     *
     * @return
     */
    public Clasz duplicate() {
        Clasz target = null;
        if(this instanceof GenericClass) {
            target = new GenericClass();
        } else {
            target = new Clasz();
        }
        target.setName(this.getName());
        target.getProperties().putAll(this.getProperties());
        target.setAbstract(this.isAbstract);
        target.setSourceSchemaId(this.getSourceSchemaId());
        target.getAncestors().putAll(this.getAncestors());
        target.setImmediateDescendants(this.getImmediateDescendants());
        target.setOverride(this.isOverride);
        target.setPrimitiveType(this.isPrimitiveType);
        target.set_package(this.get_package());
        target.setModel(this.getModel());
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
     * @param property
     */
    public void addProperty(Property property) {
        properties.put(property.getName(), property);
    }

}
