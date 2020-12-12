package nl.rosa.semanticdatabase.base.utils_rminfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Default created on 12-12-2020
 */

public interface IRMAttributeInfo {

    String getTypeNameInCollection();

    boolean isMultipleValued();

    boolean isNullable();

    Method getGetMethod();

    Field getField();
}
