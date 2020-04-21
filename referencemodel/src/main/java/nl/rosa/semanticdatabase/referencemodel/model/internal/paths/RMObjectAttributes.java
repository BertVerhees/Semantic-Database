package nl.rosa.semanticdatabase.referencemodel.model.internal.paths;

import nl.rosa.semanticdatabase.referencemodel.model.internal.rminfo.ModelInfoLookup;
import nl.rosa.semanticdatabase.referencemodel.model.internal.rminfo.RMAttributeInfo;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by:
 * User: BV, Date: 21-4-2020, Time: 15:43
 */
public class RMObjectAttributes {
    /**
     * Get the value of an attribute of a RM object.
     *
     * @param object        RM object.
     * @param attributeName The name of the attribute.
     * @return The value of the attribute.
     * @throws IllegalArgumentException When no attribute exists with the given attribute name.
     */
    public static Object getAttributeValueFromRMObject(Object object, String attributeName, ModelInfoLookup modelInfoLookup) {
        Object result;

        RMAttributeInfo attributeInfo = modelInfoLookup.getAttributeInfo(object.getClass(), attributeName);

        if (attributeInfo == null) {
            throw new IllegalArgumentException("Attribute does not exist in RM object");
        }

        try {
            result = attributeInfo.getGetMethod().invoke(object);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
