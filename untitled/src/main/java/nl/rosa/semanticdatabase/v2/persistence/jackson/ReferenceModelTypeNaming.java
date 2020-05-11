package nl.rosa.semanticdatabase.referencemodel.v2.persistence.jackson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.common.collect.ImmutableBiMap;
import nl.rosa.semanticdatabase.base.Interval;
import nl.rosa.semanticdatabase.base.SemanticDatabaseBase;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.*;
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;

import java.io.IOException;

/**
 * Class that handles naming of Archie RM and AOM objects for use in Jackson.
 *
 * The AOM class CComplexObject will get the type name "C_COMPLEX_OBJECT"
 * The RM class DvDateTime will get the type name "DV_DATE_TIME"
 */
public class ReferenceModelTypeNaming extends ClassNameIdResolver {

    private final static ImmutableBiMap<String, Class> classNaming = ImmutableBiMap.<String, Class>builder().
        put("P_BASE_TYPE", PRMBaseType.class).
        put("INCLUDE_SPEC", RMIncludeSpec.class).
        put("P_CLASS", PRMClass.class).
        put("P_CONTAINER_PROPERTY", PRMContainerProperty.class).
        put("P_ENUMERATION", PRMEnumeration.class).
        put("P_ENUMERATION_STRING", PRMEnumerationString.class).
        put("P_ENUMERATION_INTEGER", PRMEnumerationInteger.class).
        put("P_GENERIC_PARAMETER", PRMGenericParameter.class).
        put("P_GENERIC_PROPERTY", PRMGenericProperty.class).
        put("P_GENERIC_TYPE", PRMGenericType.class).
        put("P_OPEN_TYPE", PRMOpenType.class).
        put("P_CONTAINER_TYPE", PRMContainerType.class).
        put("P_PACKAGE", PRMPackage.class).
        put("P_PROPERTY", PRMProperty.class).
        put("P_SCHEMA", PRMSchema.class).
        put("P_SIMPLE_TYPE", PRMSimpleType.class).
        put("P_SINGLE_PROPERTY", PRMSingleProperty.class).
        put("P_SINGLE_PROPERTY_OPEN", PRMSinglePropertyOpen.class).
        put("P_TYPE", PRMType.class).
        put("INTERVAL", Interval.class).build();

    private final static ImmutableBiMap<Class, String> inverseClassNaming = classNaming.inverse();

    protected ReferenceModelTypeNaming() {
        super(TypeFactory.defaultInstance().constructType(SemanticDatabaseBase.class), TypeFactory.defaultInstance());
    }

    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.NAME;
    }

    @Override
    public String idFromValue(Object value) {
        String result = inverseClassNaming.get(value.getClass());
        if(result != null) {
            return result;
        } else {
            //not sure if we need this. If so, it should implement naming such as ArchieNamingStrategy (requires module restructuring)
            return value.getClass().getSimpleName();
        }


    }

    @Override
    public JavaType typeFromId(DatabindContext context, String id) throws IOException {
        return _typeFromId(id, context);
    }

    @Override
    protected JavaType _typeFromId(String typeName, DatabindContext ctxt) throws IOException {
        String classKey = RMDefinitions.typeNameToClassKey(typeName);
        Class result =  classNaming.get(classKey);
        if(result != null) {
            TypeFactory typeFactory = (ctxt == null) ? _typeFactory : ctxt.getTypeFactory();
            return typeFactory.constructSpecializedType(_baseType, result);
        }
        return super._typeFromId(typeName, ctxt);
    }
}
