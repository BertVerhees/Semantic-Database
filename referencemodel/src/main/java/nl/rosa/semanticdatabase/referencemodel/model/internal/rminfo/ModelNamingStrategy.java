package nl.rosa.semanticdatabase.referencemodel.model.internal.rminfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *  * Naming strategy for models. Default implementation exists for the Archie Reference Model implementation.
 *  *
 *  * Other implementations can be made for other reference model implementations.
 * Created by:
 * User: BV, Date: 21-4-2020, Time: 15:34
 */
public interface ModelNamingStrategy {
        String getAttributeName(Field field, Method method);
        String getTypeName(Class clazz);
}
