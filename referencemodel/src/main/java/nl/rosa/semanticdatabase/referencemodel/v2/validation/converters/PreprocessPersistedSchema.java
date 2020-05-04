package nl.rosa.semanticdatabase.referencemodel.v2.validation.converters;

import nl.rosa.semanticdatabase.referencemodel.v2.persistence.*;

import java.util.Map;

public class PreprocessPersistedSchema {
    //convert all maps to case insensitive variants
    public void preprocess(PRMSchema schema) {
        {
            Map<String, PRMClass> classDefinitions = schema.getClassDefinitions();
            CaseInsensitiveLinkedHashMap<PRMClass> newClassDefinitions = new CaseInsensitiveLinkedHashMap<>();
            newClassDefinitions.putAll(classDefinitions);
            schema.setClassDefinitions(newClassDefinitions);
            for(PRMClass clazz:classDefinitions.values()) {
                clazz.setSourceSchemaId(schema.getSchemaId());
            }
        }

        {
            Map<String, PRMClass> primitiveTypes = schema.getPrimitiveTypes();
            CaseInsensitiveLinkedHashMap<PRMClass> newPrimitiveTypes = new CaseInsensitiveLinkedHashMap<>();
            newPrimitiveTypes.putAll(primitiveTypes);
            schema.setPrimitiveTypes(newPrimitiveTypes);
            for(PRMClass clazz:primitiveTypes.values()) {
                clazz.setSourceSchemaId(schema.getSchemaId());
            }
        }
        {
            convertPackages(schema);

        }



    }

    private void convertPackages(PRMPackageContainer schema) {
        Map<String, PRMPackage> packages = schema.getPackages();
        CaseInsensitiveLinkedHashMap<PRMPackage> newpackages = new CaseInsensitiveLinkedHashMap<>();
        newpackages.putAll(packages);
        for(PRMPackage bmmPackage:newpackages.values()) {
            convertPackages(bmmPackage);
        }
        schema.setPackages(newpackages);
    }
}
