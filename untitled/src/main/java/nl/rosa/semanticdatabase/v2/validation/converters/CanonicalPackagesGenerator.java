package nl.rosa.semanticdatabase.referencemodel.v2.validation.converters;

import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMPackage;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;

import java.util.Map;
import java.util.TreeMap;

public class CanonicalPackagesGenerator {

    public Map<String, PRMPackage> generateCanonicalPackages(PRMSchema schema) {
        Map<String, PRMPackage> canonicalPackages = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        PRMPackage childPackage = null;
        String childPackageKey = null;
        Map<String, PRMPackage> packageContainer = null;
        //top-level package canonicalisation: the result is that in each P_BMM_SCHEMA, the
        //attribute `canonical_packages' contains the mergeable structure
        for (PRMPackage topPackage : schema.getPackages().values()) {
            //Iterate over qualified name, inserting new packages for each of these names.
            //E.g. 'rm.composition.content' causes three new packages 'rm', 'composition'
            // and 'content' to be created and linked, with the 'rm' one being put in
            // `canonical_packages'
            if (topPackage.getName().indexOf(RMDefinitions.PACKAGE_NAME_DELIMITER) >= 0) {
                packageContainer = canonicalPackages;
                String[] packagePathComponents = topPackage.getName().split("\\.");
                for (int index = 0; index < packagePathComponents.length; index++) {
                    childPackageKey = packagePathComponents[index].toUpperCase();
                    if (packageContainer.containsKey(childPackageKey)) {
                        childPackage = packageContainer.get(childPackageKey);
                    } else {
                        childPackage = new PRMPackage(packagePathComponents[index]);
                        packageContainer.put(childPackageKey, childPackage);
                    }
                    packageContainer = childPackage.getPackages();
                }
                //make this package with `packages' and `classes' references to those parts of `other_pkg'
                //but keeping its own name.
                childPackage.setClassesAndPackagesFrom(topPackage);
            } else {
                //just create a reference in the canonical packages; note that this precludes
                //the situation where top-level packages like 'rm' and 'rm.composition.content'
                //co-exist - this would be bad structure
                canonicalPackages.put(topPackage.getName().toUpperCase(), topPackage);
            }
        }

        return canonicalPackages;
    }
}
