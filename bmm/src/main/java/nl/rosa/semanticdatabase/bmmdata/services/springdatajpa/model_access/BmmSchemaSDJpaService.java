package nl.rosa.semanticdatabase.bmmdata.services.springdatajpa.model_access;

import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Default created on 5-7-2020
 */

public class BmmSchemaSDJpaService {
    // Functions;
    /**
     * 0..1
     * primitive_types: List<P_BMM_CLASS>
     * Primitive type definitions. Persisted attribute.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schema")
    private Set<BmmClass> primitiveTypes;
    public Set<BmmClass> getPrimitiveTypes() {
        return Collections.unmodifiableSet(primitiveTypes);
    }

    public BmmSchemaSDJpaService setPrimitiveTypes(Set<BmmClass> primitiveTypes) {
        this.primitiveTypes = primitiveTypes;
        return this;
    }

    public BmmSchemaSDJpaService addPrimitiveType(BmmClass primitiveType) {
        if(this.primitiveTypes==null){
            primitiveTypes = new HashSet<>();
        }
        this.primitiveTypes.add(primitiveType);
        return this;
    }

    public BmmSchemaSDJpaService addPrimitiveTypes(Set<BmmClass> primitiveTypes) {
        if(this.primitiveTypes==null){
            primitiveTypes = new HashSet<>();
        }
        this.primitiveTypes.addAll(primitiveTypes);
        return this;
    }

    public BmmSchemaSDJpaService removePrimitiveType(BmmClass primitiveType) {
        if(this.primitiveTypes!=null) {
            this.primitiveTypes.remove(primitiveType);
        }
        return this;
    }

    public BmmSchemaSDJpaService removePrimitiveTypes(Set<BmmClass> primitiveTypes) {
        if(this.primitiveTypes!=null) {
            this.primitiveTypes.removeAll(primitiveTypes);
        }
        return this;
    }

}
