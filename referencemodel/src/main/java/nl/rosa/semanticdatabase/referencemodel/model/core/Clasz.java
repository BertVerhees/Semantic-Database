package nl.rosa.semanticdatabase.referencemodel.model.core;

import lombok.Getter;
import lombok.Setter;

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
}
