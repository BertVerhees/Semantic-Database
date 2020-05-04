package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

/**
 * Default created on 1-5-2020
 */

@Getter
@Setter
public class RMPackageContainerImpl extends RMModelElement implements RMPackageContainer, Serializable {
    public static final String PACKAGE_PATH_DELIMITER = ".";

//    private String name;//TODO Potentially remove. See if this is used in the code.
    /**
     * Child packages; keys all in upper case for guaranteed matching.
     */
    private Map<String, RMPackage> packages;

    /**
     * No-op constructor
     */
    public RMPackageContainerImpl() {
        super();
        packages = new LinkedHashMap<String, RMPackage>();
    }

    /**
     * Adds a package to this BMM Package Container. Package must have a name.
     *
     * @param _RM_package
     */
    public void addPackage(RMPackage _RM_package) {
        packages.put(_RM_package.getName().toUpperCase(), _RM_package);
    }

    /**
     * Returns package with name argument or null if no package matches the query.
     *
     * @param packageName
     * @return
     */
    public RMPackage getPackage(String packageName) {
        return packages.get(packageName.toUpperCase());
    }

    /**
     * Returns list of packages contained in this model as a map.
     *
     * @return
     */
    public Map<String, RMPackage> getPackages() {
        return this.packages;
    }

    /**
     * Package at the path `a_path'.
     * @param packagePath
     * @return
     */
    public RMPackage packageAtPath(String packagePath) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Recursively execute `action', which is a procedure taking a BMM_PACKAGE argument, on all members of packages.
     */
    public void doRecursivePackages(Consumer<RMPackage> action) {
        packages.forEach((packageName, _RM_package) -> {
            action.accept(_RM_package);
            _RM_package.doRecursivePackages(action);
        });
    }

    /**
     * True if there is a package at the path `a_path'; paths are delimited with Package_name_delimiter.
     *
     * @param packagePathString
     * @return
     */
    public boolean hasPackagePath(String packagePathString) {
        String[] components = packagePathString.split("\\" + PACKAGE_PATH_DELIMITER);
        List<String> packagePath = new ArrayList<>();
        packagePath.addAll(Arrays.asList(components));
        boolean exists = false;
        if(this instanceof RMPackage) {
            exists = ((RMPackage)this).hasPackagePath(packagePath, 0, packagePath.size());
        } else {
            for (RMPackage _RM_package : packages.values()) {
                exists = _RM_package.hasPackagePath(packagePath, 0, packagePath.size());
                if (exists) {
                    break;
                }
            }
        }
        return exists;
    }

    /**
     * Method looks for the first instance of a package of the same name
     * as the argument package in the container's package hierarchy.
     *
     * @param testRMPackage
     * @return
     */
    public boolean hasPackageNameInHierarchy(RMPackage testRMPackage) {
        boolean found = false;
        if(packages != null) {
            if(packages.containsKey(testRMPackage.getName())) {
                found = true;
            } else {
                for(RMPackage _RM_package : packages.values()) {
                    found = _RM_package.hasPackageNameInHierarchy(testRMPackage);
                    if(found) {
                        break;
                    }
                }

            }
        }
        return found;
    }
}
