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
import nl.rosa.semanticdatabase.referencemodel.persistence.validation.Definitions;

import java.io.IOException;

/**
 * Class that handles naming of Archie RM and AOM objects for use in Jackson.
 *
 * The AOM class CComplexObject will get the type name "C_COMPLEX_OBJECT"
 * The RM class DvDateTime will get the type name "DV_DATE_TIME"
 */
public class ReferenceModelTypeNaming extends ClassNameIdResolver {

    private final static ImmutableBiMap<String, Class> classNaming = ImmutableBiMap.<String, Class>builder().
        put("P_BASE_TYPE", PBaseType.class).
        put("INCLUDE_SPEC", IncludeSpec.class).
        put("P_CLASS", PClass.class).
        put("P_CONTAINER_PROPERTY", PContainerProperty.class).
        put("P_ENUMERATION", PEnumeration.class).
        put("P_ENUMERATION_STRING", PEnumerationString.class).
        put("P_ENUMERATION_INTEGER", PEnumerationInteger.class).
        put("P_GENERIC_PARAMETER", PGenericParameter.class).
        put("P_GENERIC_PROPERTY", PGenericProperty.class).
        put("P_GENERIC_TYPE", PGenericType.class).
        put("P_OPEN_TYPE", POpenType.class).
        put("P_CONTAINER_TYPE", PContainerType.class).
        put("P_PACKAGE", PPackage.class).
        put("P_PROPERTY", PProperty.class).
        put("P_SCHEMA", PSchema.class).
        put("P_SIMPLE_TYPE", PSimpleType.class).
        put("P_SINGLE_PROPERTY", PSingleProperty.class).
        put("P_SINGLE_PROPERTY_OPEN", PSinglePropertyOpen.class).
        put("P_TYPE", PType.class).
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
        String classKey = Definitions.typeNameToClassKey(typeName);
        Class result =  classNaming.get(classKey);
        if(result != null) {
            TypeFactory typeFactory = (ctxt == null) ? _typeFactory : ctxt.getTypeFactory();
            return typeFactory.constructSpecializedType(_baseType, result);
        }
        return super._typeFromId(typeName, ctxt);
    }
}
