package nl.rosa.semanticdatabase.referencemodel.model.internal.rminfo;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Created by:
 * User: BV, Date: 21-4-2020, Time: 15:32
 */
@Getter
@Setter
public class RMAttributeInfo {
    private final String name;
    private final Field field;
    private final Class type;
    private final Class typeInCollection;
    private final String typeNameInCollection;
    private final boolean isMultipleValued;
    private final Method getMethod;
    private final Method setMethod;
    private final Method addMethod;
    private final boolean nullable;
    private final boolean computed;

    public RMAttributeInfo(String name, Field field, Class type, Class typeInCollection, String typeNameInCollection, boolean nullable, Method getMethod, Method setMethod, Method addMethod) {
        this.name = name;
        this.field = field;
        this.type = type;
        this.nullable = nullable;
        this.getMethod = getMethod;
        this.setMethod = setMethod;
        this.addMethod = addMethod;
        this.computed = this.setMethod == null && this.addMethod == null;
        this.isMultipleValued = (type instanceof Class && Collection.class.isAssignableFrom(type)) || type.isArray();

        this.typeInCollection = typeInCollection;
        this.typeNameInCollection = typeNameInCollection;
    }
}
