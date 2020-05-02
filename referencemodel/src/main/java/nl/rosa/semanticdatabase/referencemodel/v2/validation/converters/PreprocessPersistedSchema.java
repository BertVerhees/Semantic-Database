package nl.rosa.semanticdatabase.referencemodel.v2.validation.converters;

import nl.rosa.semanticdatabase.referencemodel.v2.persistence.*;

import java.util.Map;

public class PreprocessPersistedSchema {
    //convert all maps to case insensitive variants
    public void preprocess(PSchema schema) {
        {
            Map<String, PClass> classDefinitions = schema.getClassDefinitions();
            CaseInsensitiveLinkedHashMap<PClass> newClassDefinitions = new CaseInsensitiveLinkedHashMap<>();
            newClassDefinitions.putAll(classDefinitions);
            schema.setClassDefinitions(newClassDefinitions);
            for(PClass clazz:classDefinitions.values()) {
                clazz.setSourceSchemaId(schema.getSchemaId());
            }
        }

        {
            Map<String, PClass> primitiveTypes = schema.getPrimitiveTypes();
            CaseInsensitiveLinkedHashMap<PClass> newPrimitiveTypes = new CaseInsensitiveLinkedHashMap<>();
            newPrimitiveTypes.putAll(primitiveTypes);
            schema.setPrimitiveTypes(newPrimitiveTypes);
            for(PClass clazz:primitiveTypes.values()) {
                clazz.setSourceSchemaId(schema.getSchemaId());
            }
        }
        {
            convertPackages(schema);

        }



    }

    private void convertPackages(PPackageContainer schema) {
        Map<String, PPackage> packages = schema.getPackages();
        CaseInsensitiveLinkedHashMap<PPackage> newpackages = new CaseInsensitiveLinkedHashMap<>();
        newpackages.putAll(packages);
        for(PPackage bmmPackage:newpackages.values()) {
            convertPackages(bmmPackage);
        }
        schema.setPackages(newpackages);
    }
}
