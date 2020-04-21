package nl.rosa.semanticdatabase.referencemodel.model.internal.rminfo;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by:
 * User: BV, Date: 21-4-2020, Time: 15:28
 */
public class RMInfoLookup implements ModelInfoLookup{

    private static RMInfoLookup instance;

    public static RMInfoLookup getInstance() {
        if(instance == null) {
            instance = new RMInfoLookup();
        }
        return instance;
    }

    @Override
    public Class getClass(String rmTypename) {
        return null;
    }

    @Override
    public Class getClassToBeCreated(String rmTypename) {
        return null;
    }

    @Override
    public Map<String, Class> getRmTypeNameToClassMap() {
        return null;
    }

    @Override
    public RMTypeInfo getTypeInfo(Class clazz) {
        return null;
    }

    @Override
    public Field getField(Class clazz, String attributeName) {
        return null;
    }

    @Override
    public RMTypeInfo getTypeInfo(String rmTypeName) {
        return null;
    }

    @Override
    public RMAttributeInfo getAttributeInfo(Class clazz, String attributeName) {
        return null;
    }

    @Override
    public RMAttributeInfo getAttributeInfo(String rmTypeName, String attributeName) {
        return null;
    }

    @Override
    public List<RMTypeInfo> getAllTypes() {
        return null;
    }

    @Override
    public ModelNamingStrategy getNamingStrategy() {
        return null;
    }

    @Override
    public Object convertToConstraintObject(Object object, CPrimitiveObject cPrimitiveObject) {
        return null;
    }

    @Override
    public Object convertConstrainedPrimitiveToRMObject(Object object) {
        return null;
    }

    @Override
    public void processCreatedObject(Object createdObject, CObject constraint) {

    }

    @Override
    public String getArchetypeNodeIdFromRMObject(Object rmObject) {
        return null;
    }

    @Override
    public String getNameFromRMObject(Object rmObject) {
        return null;
    }

    @Override
    public Object clone(Object rmObject) {
        return null;
    }

    @Override
    public Map<String, Object> pathHasBeenUpdated(Object rmObject, Archetype archetype, String pathOfParent, Object parent) {
        return null;
    }

    @Override
    public boolean validatePrimitiveType(String rmTypeName, String rmAttributeName, CPrimitiveObject cObject) {
        return false;
    }

    @Override
    public Collection<RMPackageId> getId() {
        return null;
    }
}
