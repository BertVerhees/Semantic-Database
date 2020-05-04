package nl.rosa.semanticdatabase.referencemodel.v2.validation.converters;

import nl.rosa.semanticdatabase.referencemodel.core.RMClass;
import nl.rosa.semanticdatabase.referencemodel.core.RMModel;
import nl.rosa.semanticdatabase.referencemodel.core.RMPackage;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMClass;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMPackage;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;
import nl.rosa.semanticdatabase.referencemodel.v2.validation.RMValidationResult;

import java.util.ArrayList;

public class RMModelCreator {

    private RMClassCreator RMClassCreator = new RMClassCreator();

    public RMModel create(RMValidationResult validationResult) {
        PRMSchema schema = validationResult.getSchemaWithMergedIncludes();
        RMModel model = new RMModel();
        model.setRmPublisher(schema.getRmPublisher());
        model.setRmRelease(schema.getRmRelease());
        model.setModelName(schema.getModelName());
        model.setSchemaName(schema.getSchemaName());
        model.setSchemaRevision(schema.getSchemaRevision());
        model.setSchemaAuthor(schema.getSchemaAuthor());
        model.setSchemaDescription(schema.getSchemaDescription());
        model.setSchemaLifecycleState(schema.getSchemaLifecycleState());
        //cannot set the documentation - the supported P_BMM version has no documentation in the P_BMM_SCHEMA
        model.setSchemaContributors(schema.getSchemaContributors() == null ? new ArrayList() : new ArrayList<>(schema.getSchemaContributors()));



        //Add packages first
        for(PRMPackage pRMPackage:validationResult.getCanonicalPackages().values()) {
            RMPackage rmPackage = createBmmPackageDefinition(pRMPackage, null, null);

            model.addPackage(rmPackage);

            pRMPackage.doRecursiveClasses((p, s) -> {
                PRMClass persistedRMClass = schema.findClassOrPrimitiveDefinition(s);
                if (persistedRMClass != null) {
                    RMClass bmmClass = RMClassCreator.createRMClass(persistedRMClass);

                    if (bmmClass != null && rmPackage != null) {
                        if (schema.getPrimitiveTypes().get(bmmClass.getName()) != null) {
                            bmmClass.setPrimitiveType(true);
                        }
                        if (persistedRMClass.isOverride() != null && persistedRMClass.isOverride()) {
                            bmmClass.setOverride(true);
                        }
                        model.addClassDefinition(bmmClass, rmPackage);
                    }
                }
            });
        }

        model.setArchetypeParentClass(schema.getArchetypeParentClass());
        model.setArchetypeDataValueParentClass(schema.getArchetypeDataValueParentClass());
        model.setArchetypeVisualizeDescendantsOf(schema.getArchetypeVisualizeDescendantsOf());
        model.setArchetypeRmClosurePackages(schema.getArchetypeRmClosurePackages() == null ? new ArrayList<>() : new ArrayList<>(schema.getArchetypeRmClosurePackages()));


        // The basics have been created. Now populate the classes with properties
        ProcessClassesInOrder processClassesInOrder = new ProcessClassesInOrder();
        processClassesInOrder.doAllClassesInOrder(schema, rmClass -> {
            RMClassCreator.populateRMClass(rmClass, model);
        }, new ArrayList<>(schema.getPrimitiveTypes().values()));
        processClassesInOrder.doAllClassesInOrder(schema, rmClass -> {
            RMClassCreator.populateRMClass(rmClass, model);
        }, new ArrayList<>(schema.getClassDefinitions().values()));

        return model;
    }



    private RMPackage createBmmPackageDefinition(PRMPackage p, PRMPackage parent, RMPackage parentPackageDefinition) {
        RMPackage rmPackageDefinition = new RMPackage(p.getName());
        rmPackageDefinition.setDocumentation(p.getDocumentation());
        if(parent != null) {
            rmPackageDefinition.appendToPath(parent.getName());
            rmPackageDefinition.setParent(parentPackageDefinition);
        }
        rmPackageDefinition.appendToPath(p.getName());
        p.getPackages().values().forEach(childPackage -> {
            RMPackage bmmChildPackageDefinition = createBmmPackageDefinition(childPackage, p, rmPackageDefinition);
            rmPackageDefinition.addPackage(bmmChildPackageDefinition);
        });
        return rmPackageDefinition;
    }
}
