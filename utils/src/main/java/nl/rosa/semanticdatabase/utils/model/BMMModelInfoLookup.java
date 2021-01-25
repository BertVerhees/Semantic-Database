package nl.rosa.semanticdatabase.utils.model;

import com.google.common.reflect.TypeToken;

import javax.annotation.Nullable;
import java.lang.reflect.*;
import java.util.*;


/**
 * Utility that defines the java mapping of type and attribute names of a given reference model.
 * <p>
 * Use it to obtain java classes for RM Type Names, and java fields, getters, setters and nl.rosa.semanticdatabase.bmm.model.types for RM Attribute Names
 * <p>
 * This class is never directly created, but subclasses must be created that setup the correct model.
 * Create a subclass
 * per model you want to use with Archie, for example one for an OpenEHR RM implementation,
 * or the CIMI RM implementation
 * <p>
 * Originally: Created by pieter.bos on 02/02/16.
 */


public abstract class BMMModelInfoLookup implements ModelInfoLookup {


//    private ModelNamingStrategy namingStrategy;

    private String packageName;
    private ClassLoader classLoader;

    private Map<String, IRMTypeInfo> rmTypeNamesToRmTypeInfo = new HashMap<>();
    private Map<Class, IRMTypeInfo> classesToRmTypeInfo = new HashMap<>();

    private boolean inConstructor = true;
    private boolean addAttributesWithoutField = true;

    /**
     * All methods that cannot be called by using reflection. For example getClass();
     */
    @SuppressWarnings("unchecked")
    private Set<String> forbiddenMethods = new HashSet(
            Arrays.asList("getClass", "wait", "notify", "notifyAll", "clone", "finalize")
    );

//    public ReflectionModelInfoLookup(ModelNamingStrategy namingStrategy, Class baseClass) {
//        this(namingStrategy, baseClass, com.nedap.archie.rminfo.ReflectionModelInfoLookup.class.getClassLoader(), true);
//    }

//    public ReflectionModelInfoLookup(ModelNamingStrategy namingStrategy, String packageName, ClassLoader classLoader) {
//        this.packageName = packageName;
//        this.namingStrategy = namingStrategy;
//
//        this.classLoader = classLoader;
//        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
//        Set<String> typeNames = reflections.getAllTypes();
//
//        typeNames.forEach(typeName -> {
//            try {
//                addClass(classLoader.loadClass(typeName));
//            } catch (ClassNotFoundException e) {
//                logger.error("error loading model info lookup", e);
//            }
//        });
//        addSuperAndSubclassInfo();
//        inConstructor = false;
//    }

//    public ReflectionModelInfoLookup(ModelNamingStrategy namingStrategy, Class baseClass, ClassLoader classLoader, boolean addAttributesWithoutField) {
//        this.namingStrategy = namingStrategy;
//        this.addAttributesWithoutField = addAttributesWithoutField;
//
//        this.classLoader = classLoader;
//        addTypes(baseClass);
//        addSuperAndSubclassInfo();
//        inConstructor = false;
//    }

    /**
     * Override to disable reflections scanning
     * //     * @param baseClass
     */
//    protected void addTypes(Class baseClass) {
//        addSubtypesOf(baseClass);
//    }
    private void addSuperAndSubclassInfo() {
        for (IRMTypeInfo typeInfo : rmTypeNamesToRmTypeInfo.values()) {
            Class superclass = typeInfo.getJavaClass().getSuperclass();
            if (!superclass.equals(Object.class)) {
                addDescendantClass(typeInfo, superclass);
            }

            for (Class interfaceClass : typeInfo.getJavaClass().getInterfaces()) {
                addDescendantClass(typeInfo, interfaceClass);
            }
        }

    }

    private void addDescendantClass(IRMTypeInfo typeInfo, Class interfaceClass) {
        IRMTypeInfo superClassTypeInfo = this.getTypeInfo(interfaceClass);
        if (superClassTypeInfo != null) {
            typeInfo.addDirectParentClass(superClassTypeInfo);
            superClassTypeInfo.addDirectDescendantClass(typeInfo);
        }
    }

    /**
     * Add all subtypes of the given class
     * //     * @param baseClass
     */
//    protected void addSubtypesOf(Class baseClass) {
//        Reflections reflections = new Reflections(ClasspathHelper.forClass(baseClass), new SubTypesScanner(false));
//        Set<Class<?>> classes = reflections.getSubTypesOf(baseClass);
//
//        classes.forEach(this::addClass);
//        addClass(baseClass);
//    }

//    protected void addClass(Class clazz) {
//        String rmTypeName = namingStrategy.getTypeName(clazz);
//        IRMTypeInfo typeInfo = new IRMTypeInfo(clazz, rmTypeName);
//        addAttributeInfo(clazz, typeInfo);
//        rmTypeNamesToRmTypeInfo.put(rmTypeName, typeInfo);
//        classesToRmTypeInfo.put(clazz, typeInfo);
//        if(!inConstructor) {
//            //if someone called this after initial creation, we need to update super/subclass info.
//            //could be done more efficiently by only updating for the added class and parents/descendants, but
//            //should not be a problem to do it this way
//            addSuperAndSubclassInfo();
//        }
//    }

//    private void addAttributeInfo(Class clazz, IRMTypeInfo typeInfo) {
//        //TODO: it's possible to constrain some method as well. should we do that here too?
//        TypeToken typeToken = TypeToken.of(clazz);
//
//        Set<Field> allFields = ReflectionUtils.getAllFields(clazz);
//        Map<String, Field> fieldsByName = allFields.stream()
//                .filter( field -> !field.getName().startsWith("$")) //jacoco adds $ fields.. annoying :)
//                .collect(Collectors.toMap((field) -> field.getName(), (field) -> field,
//                        (duplicate1, duplicate2) -> duplicate1));
//        for(Field field: fieldsByName.values()) {
//            addRMAttributeInfo(clazz, typeInfo, typeToken, field);
//        }
//        if(addAttributesWithoutField) {
//            Set<Method> getters = ReflectionUtils.getAllMethods(clazz, (method) -> method.getName().startsWith("get") || method.getName().startsWith("is"));
//            for (Method getMethod : getters) {
//                if(shouldAdd(getMethod)) {
//                    addRMAttributeInfo(clazz, typeInfo, typeToken, getMethod, fieldsByName);
//                }
//            }
//        }
//    }
//    protected boolean shouldAdd(Method method) {
//        if (method == null) {
//            return true;
//        }
//        //do not add private or protected properties, they will result in errors
//        return Modifier.isPublic(method.getModifiers()) && method.getAnnotation(RMPropertyIgnore.class) == null;
//    }

//    protected void addRMAttributeInfo(Class clazz, IRMTypeInfo typeInfo, TypeToken typeToken, Method getMethod, Map<String, Field> fieldsByName) {
//        String javaFieldName = null;
//        if(getMethod.getName().startsWith("is")) {
//            javaFieldName = lowerCaseFirstChar(getMethod.getName().substring(2));
//        } else {
//            javaFieldName = lowerCaseFirstChar(getMethod.getName().substring(3));
//        }
//        Field field = fieldsByName.get(javaFieldName);
//        if(field == null) {
//            field = fieldsByName.get(getMethod.getName());
//        }
//        String javaFieldNameUpperCased = upperCaseFirstChar(javaFieldName);
//        Method setMethod = null, addMethod = null;
//
//        if (getMethod == null) {
//            getMethod = getMethod(clazz, "is" + javaFieldNameUpperCased);
//        }
//        if (getMethod != null) {
//            setMethod = getMethod(clazz, "set" + javaFieldNameUpperCased, getMethod.getReturnType());
//            addMethod = getAddMethod(clazz, typeToken, javaFieldNameUpperCased, getMethod);
//        } else {
//            logger.debug("No get method found for attribute {} on class {}", javaFieldName, clazz.getSimpleName());
//        }
//
//        String attributeName = namingStrategy.getAttributeName(field, getMethod);
//
//        TypeToken fieldType = typeToken.resolveType(getMethod.getGenericReturnType());;
//
//        Class rawFieldType = fieldType.getRawType();
//        Class typeInCollection = getTypeInCollection(fieldType);
//       // if (setMethod != null) {
//            RMAttributeInfo attributeInfo = new RMAttributeInfo(
//                    attributeName,
//                    field,
//                    rawFieldType,
//                    typeInCollection,
//                    this.namingStrategy.getTypeName(typeInCollection),
//                    isNullable(clazz, getMethod, field),
//                    getMethod,
//                    setMethod,
//                    addMethod
//            );
//            if(typeInfo.getAttribute(attributeName) == null) {
//                typeInfo.addAttribute(attributeInfo);
//            }
//        //} else {
//        //    logger.info("property without a set method ignored for field {} on class {}", attributeName, clazz.getSimpleName());
//       // }
//    }

    protected boolean isNullable(Class clazz, Method getMethod, Field field) {
        return (field != null && field.getAnnotation(Nullable.class) != null) || getMethod.getAnnotation(Nullable.class) != null;
    }


//    private void addRMAttributeInfo(Class clazz, IRMTypeInfo typeInfo, TypeToken typeToken, Field field) {
//        String javaFieldName = field.getName();
//        String javaFieldNameUpperCased = upperCaseFirstChar(javaFieldName);
//        Method getMethod = getMethod(clazz, "get" + javaFieldNameUpperCased);
//        Method setMethod = null, addMethod = null;
//        if (getMethod == null) {
//            getMethod = getMethod(clazz, "is" + javaFieldNameUpperCased);
//        }
//        if (getMethod != null) {
//            setMethod = getMethod(clazz, "set" + javaFieldNameUpperCased, getMethod.getReturnType());
//            addMethod = getAddMethod(clazz, typeToken, javaFieldNameUpperCased, getMethod);
//        } else {
//            logger.debug("No get method found for field {} on class {}", field.getName(), clazz.getSimpleName());
//        }
//
//        if(javaFieldName.startsWith("is")) {
//            //special case
//            String fieldNameWithoutPrefix = javaFieldName.substring(2);
//            String withoutPrefixUpperCased = upperCaseFirstChar(fieldNameWithoutPrefix);
//            if (getMethod == null) {
//                getMethod = getMethod(clazz, "is" + withoutPrefixUpperCased);
//            }
//            if (getMethod != null) {
//                if(setMethod == null) {
//                    setMethod = getMethod(clazz, "set" + withoutPrefixUpperCased, getMethod.getReturnType());
//                }
//                if(addMethod == null) {
//                    addMethod = getAddMethod(clazz, typeToken, withoutPrefixUpperCased, getMethod);
//                }
//            } else {
//                logger.debug("No get method found for attribute {} on class {}", javaFieldName, clazz.getSimpleName());
//            }
//
//        }
//        String attributeName = namingStrategy.getAttributeName(field, getMethod);
//
//        TypeToken fieldType = null;
//        if (getMethod != null) {
//            fieldType = typeToken.resolveType(getMethod.getGenericReturnType());
//        } else {
//            fieldType = typeToken.resolveType(field.getGenericType());
//        }
//
//        Class rawFieldType = fieldType.getRawType();
//        Class typeInCollection = getTypeInCollection(fieldType);
//        if (setMethod != null && (shouldAdd(setMethod) && shouldAdd(getMethod))) {
//            RMAttributeInfo attributeInfo = new RMAttributeInfo(
//                    attributeName,
//                    field,
//                    rawFieldType,
//                    typeInCollection,
//                    namingStrategy.getTypeName(typeInCollection),
//                    isNullable(clazz, getMethod, field),
//                    getMethod,
//                    setMethod,
//                    addMethod
//            );
//            typeInfo.addAttribute(attributeInfo);
//        } else {
//            logger.debug("property without a set method ignored for field {} on class {}", field.getName(), clazz.getSimpleName());
//        }
//    }

    private Class getTypeInCollection(TypeToken fieldType) {
        Class rawFieldType = fieldType.getRawType();
        if (Collection.class.isAssignableFrom(rawFieldType)) {
            Type[] actualTypeArguments = ((ParameterizedType) fieldType.getType()).getActualTypeArguments();
            if (actualTypeArguments.length == 1) {
                //the java reflection api is kind of tricky with nl.rosa.semanticdatabase.bmm.model.types. This works for the archie RM, but may cause problems for other RMs. The fix is implementing more ways
                if (actualTypeArguments[0] instanceof Class) {
                    return (Class) actualTypeArguments[0];
                } else if (actualTypeArguments[0] instanceof ParameterizedType) {
                    ParameterizedType parameterizedTypeInCollection = (ParameterizedType) actualTypeArguments[0];
                    return (Class) parameterizedTypeInCollection.getRawType();
                } else if (actualTypeArguments[0] instanceof TypeVariable) {
                    return (Class) ((TypeVariable) actualTypeArguments[0]).getBounds()[0];
                }
            }
        } else if (rawFieldType.isArray()) {
            return rawFieldType.getComponentType();
        }
        return rawFieldType;
    }

//    private Method getAddMethod(Class clazz, TypeToken typeToken, String javaFieldNameUpperCased, Method getMethod) {
//        Method addMethod = null;
//        if (Collection.class.isAssignableFrom(getMethod.getReturnType())) {
//            Type[] typeArguments = ((ParameterizedType) getMethod.getGenericReturnType()).getActualTypeArguments();
//            if (typeArguments.length == 1) {
//                TypeToken singularParameter = typeToken.resolveType(typeArguments[0]);
//                //TODO: does this work or should we use the typeArguments[0].getSomething?
//                String addMethodName = "add" + toSingular(javaFieldNameUpperCased);
//                addMethod = getMethod(clazz, addMethodName, singularParameter.getRawType());
//                if (addMethod == null) {
//                    //Due to generics, this does not always work
//                    Set<Method> allAddMethods = ReflectionUtils.getAllMethods(clazz, ReflectionUtils.withName(addMethodName));
//                    if (allAddMethods.size() == 1) {
//                        addMethod = allAddMethods.iterator().next();
//                    } else {
//                        logger.debug("strange number of add methods for field {} on class {}", javaFieldNameUpperCased, clazz.getSimpleName());
//                    }
//                }
//            }
//        }
//        return addMethod;
//    }

    private String toSingular(String javaFieldNameUpperCased) {
        if (javaFieldNameUpperCased.endsWith("s")) {
            return javaFieldNameUpperCased.substring(0, javaFieldNameUpperCased.length() - 1);
        }
        //TODO: a way to override plural names to go back to singular names. Use a library?
        return javaFieldNameUpperCased;
    }

    private Method getMethod(Class clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getMethod(name, parameterTypes);
        } catch (NoSuchMethodException ex) {
            return null;
        }
    }

    private String upperCaseFirstChar(String name) {
        return new StringBuilder(name).replace(0, 1,
                Character.toString(Character.toUpperCase(name.charAt(0)))
        ).toString();
    }

    private String lowerCaseFirstChar(String name) {
        return new StringBuilder(name).replace(0, 1,
                Character.toString(Character.toLowerCase(name.charAt(0)))
        ).toString();
    }

    @Override
    public Class getClass(String rmTypeName) {
        String strippedRmTypeName = getTypeWithoutGenericType(rmTypeName);
        IRMTypeInfo IRMTypeInfo = rmTypeNamesToRmTypeInfo.get(strippedRmTypeName);
        return IRMTypeInfo == null ? null : IRMTypeInfo.getJavaClass();
    }

    @Override
    public Class getClassToBeCreated(String rmTypename) {
        return getClass(rmTypename);
    }

    @Override
    public Map<String, Class> getRmTypeNameToClassMap() {
        HashMap<String, Class> result = new HashMap<>();
        for (String rmTypeName : rmTypeNamesToRmTypeInfo.keySet()) {
            result.put(rmTypeName, rmTypeNamesToRmTypeInfo.get(rmTypeName).getJavaClass());
        }
        return result;
    }

    @Override
    public IRMTypeInfo getTypeInfo(Class clazz) {
        return this.classesToRmTypeInfo.get(clazz);
    }

    @Override
    public Field getField(Class clazz, String attributeName) {
        IRMTypeInfo typeInfo = classesToRmTypeInfo.get(clazz);
        IRMAttributeInfo attributeInfo = typeInfo == null ? null : typeInfo.getAttribute(attributeName);
        return attributeInfo == null ? null : attributeInfo.getField();
    }

    @Override
    public IRMTypeInfo getTypeInfo(String rmTypeName) {
        String strippedRmTypeName = getTypeWithoutGenericType(rmTypeName);
        return this.rmTypeNamesToRmTypeInfo.get(strippedRmTypeName);
    }

    private String getTypeWithoutGenericType(String rmTypeName) {
        if (rmTypeName.indexOf('<') > 0) {
            //strip generic nl.rosa.semanticdatabase.bmm.model.types, cannot handle them yet
            rmTypeName = rmTypeName.substring(0, rmTypeName.indexOf('<'));
        }
        return rmTypeName;
    }

    @Override
    public IRMAttributeInfo getAttributeInfo(Class clazz, String attributeName) {
        IRMTypeInfo typeInfo = this.classesToRmTypeInfo.get(clazz);
        return typeInfo == null ? null : typeInfo.getAttribute(attributeName);
    }

    @Override
    public IRMAttributeInfo getAttributeInfo(String rmTypeName, String attributeName) {
        String strippedRmTypeName = getTypeWithoutGenericType(rmTypeName);
        IRMTypeInfo typeInfo = this.rmTypeNamesToRmTypeInfo.get(strippedRmTypeName);
        return typeInfo == null ? null : typeInfo.getAttribute(attributeName);
    }

    @Override
    public List<IRMTypeInfo> getAllTypes() {
        return new ArrayList<>(classesToRmTypeInfo.values());
    }

//    @Override
//    public ModelNamingStrategy getNamingStrategy() {
//        return namingStrategy;
//    }

    /**
     * Convert the given reference model object to the object required for the archetype constraint.
     * <p>
     * for example, a CTerminologyCode can be used to check a CodePhrase or a DvCodedText. This cannot be directly checked and must be converted first.
     *
     * @param object //     * @param cPrimitiveObject
     * @return
     */
//    @Override
//    public Object convertToConstraintObject(Object object, CPrimitiveObject cPrimitiveObject) {
//        return object;
//    }
    @Override
    public Object convertConstrainedPrimitiveToRMObject(Object object) {
        //TODO: this should take an AttributeInfo as param, so to be able to pick the right object
        return object;
    }
}
