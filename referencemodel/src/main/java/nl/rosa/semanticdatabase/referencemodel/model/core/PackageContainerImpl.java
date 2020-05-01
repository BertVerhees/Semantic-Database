package nl.rosa.semanticdatabase.referencemodel.model.core;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.function.Consumer;

/**
 * Default created on 1-5-2020
 */

@Getter
@Setter
public class PackageContainerImpl {
    public static final String PACKAGE_PATH_DELIMITER = ".";

//    private String name;//TODO Potentially remove. See if this is used in the code.
    /**
     * Child packages; keys all in upper case for guaranteed matching.
     */
    private Map<String, Package> packages;

    /**
     * No-op constructor
     */
    public PackageContainerImpl() {
        super();
        packages = new LinkedHashMap<String, Package>();
    }

    /**
     * Adds a package to this BMM Package Container. Package must have a name.
     *
     * @param _package
     */
    public void addPackage(Package _package) {
        packages.put(_package.getName(), _package);
    }

    /**
     * Returns package with name argument or null if no package matches the query.
     *
     * @param packageName
     * @return
     */
    public Package getPackage(String packageName) {
        return packages.get(packageName);
    }

    /**
     * Returns list of packages contained in this model as a map.
     *
     * @return
     */
    public Map<String, Package> getPackages() {
        return this.packages;
    }

    /**
     * Package at the path `a_path'.
     * @param packagePath
     * @return
     */
    public Package packageAtPath(String packagePath) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Recursively execute `action', which is a procedure taking a BMM_PACKAGE argument, on all members of packages.
     */
    public void doRecursivePackages(Consumer<Package> action) {
        packages.forEach((packageName,_package) -> {
            action.accept(_package);
            _package.doRecursivePackages(action);
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
        if(this instanceof Package) {
            exists = ((Package)this).hasPackagePath(packagePath, 0, packagePath.size());
        } else {
            for (Package _package : packages.values()) {
                exists = _package.hasPackagePath(packagePath, 0, packagePath.size());
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
     * @param testPackage
     * @return
     */
    public boolean hasPackageNameInHierarchy(Package testPackage) {
        boolean found = false;
        if(packages != null) {
            if(packages.containsKey(testPackage.getName())) {
                found = true;
            } else {
                for(Package _package : packages.values()) {
                    found = _package.hasPackageNameInHierarchy(testPackage);
                    if(found) {
                        break;
                    }
                }

            }
        }
        return found;
    }
}
