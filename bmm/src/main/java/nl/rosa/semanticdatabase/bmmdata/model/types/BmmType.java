package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

import java.util.List;


/**
 * Class BmmType
 * Abstract idea of specifying a type in some context. This is not the same as
 * 'defining' a class. A type specification is essentially a reference of some
 * kind, that defines the type of an attribute, or function result or argument. It
 * may include generic parameters that might or might not be bound. See subtypes.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BmmType extends BmmBaseEntity {

    /**
     * 1..1
     * (abstract)
     * type_name (): String
     * Formal string form of the type as per UML.
     * @return
     */
    @NonNull
    public abstract String typeName();

    /**
     * 1..1
     * (abstract)
     * flattened_type_list (): List<String>
     * Completely flattened list of type names, flattening out all generic parameters.
     * @return
     */
    @NonNull
    public abstract List<String> flattenedTypeList();

    /**
     * 1..1
     * type_signature (): String
     * Signature form of the type name, which for generics includes generic parameter constrainer types
     * E.g. Interval<T:Ordered>.
     * Defaults to the value of type_name().
     * @return
     */
    @NonNull
    public String typeSignature(){
        return null;
    }

    /**
     * 1..1
     * (abstract)
     * unitary_type (): BMM_UNITARY_TYPE
     * Type with any container abstracted away.
     * @return
     */
    @NonNull
    public abstract BmmUnitaryType unitaryType();

    /**
     * 1..1
     * (abstract)
     * effective_type (): BMM_EFFECTIVE_TYPE
     * Type with any container abstracted away, and any formal parameter replaced by its effective constraint type.
     * @return
     */
    @NonNull
    public abstract BmmEffectiveType effectiveType();

    /**
     * 1..1
     * (abstract)
     * is_abstract (): Boolean
     * If true, indicates an abstract class in a BMM model, or a type based on an abstract class, i.e. a type
     * that cannot be directly instantiated.
     * @return
     */
    @NonNull
    public abstract Boolean isAbstract();

    /**
     * 1..1
     * (abstract)
     * is_primitive (): Boolean
     * If True, indicates that the entity in a BMM model is considered to relate to a primitive type set,
     * i.e. be a primitive type, or be a definer of one.
     * @return
     */
    @NonNull
    public abstract Boolean isPrimitive();
}
