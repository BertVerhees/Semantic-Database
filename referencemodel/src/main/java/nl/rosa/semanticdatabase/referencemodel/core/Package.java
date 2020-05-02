package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Default created on 1-5-2020
 */

@Getter
@Setter
public class Package extends PackageContainerImpl implements Serializable {
    /**
     * Name of this package. This name may be qualified if it is a top-level package.
     *
     */
    private String name;

    /**
     * Classes listed as being in this package.
     */
    private Map<String, Clasz> classes;

    /**
     * Path to root package.
     */
    private String canonicalPath = "";

    /**
     * The parent package that contains this package or null if package it a top-level package.
     */
    private Package parent;

    /**
     * No-arg constructor
     */
    public Package() {
        super();
        classes = new LinkedHashMap<String, Clasz>();
    }

    /**
     * Constructor initializing the package name
     *
     * @param name
     */
    public Package(String name) {
        this();
        this.name = name;
    }


    /**
     * returns classes listed as being in this package as a shallow clone.
     *
     * @return
     */
    public List<Clasz> getClasses() {
        List<Clasz> classList = new ArrayList<>();
        classList.addAll(classes.values());
        return classList;
    }

    /**
     * Adds class to package.
     *
     * @param className
     * @param clasz
     */
    public void addClass(String className, Clasz clasz) {
        this.classes.put(className, clasz);
    }

    /**
     * Adds class to package.
     *
     * @param clasz
     */
    public void addClass(Clasz clasz) {
        this.classes.put(clasz.getName(), clasz);
    }

    /**
     * Obtain the set of top-level classes in this package, either from this package itself or by recursing into the
     * structure until classes are obtained from child packages. Recurse into each child only far enough to find the
     * first level of classes.
     *
     * @return
     */
    public List<Clasz> getRootClasses() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Returns full path of this package back to root package.
     *
     * @return
     */
    public String getPath() {
        return this.canonicalPath;
    }

    /**
     * Sets path from root of model
     *
     * @param path
     */
    public void setPath(String path) {
        this.canonicalPath = path;
    }

    public void appendToPath(String pathComponent) {
        if(this.canonicalPath == null | this.canonicalPath.isEmpty()) {
            this.canonicalPath = pathComponent;
        } else {
            this.canonicalPath = this.canonicalPath + PACKAGE_PATH_DELIMITER + pathComponent;
        }
    }

    public boolean hasPackagePath(List<String> packagePathComponents, int currentIndex, int sizeRemaining) {
        boolean matches = false;
        if(sizeRemaining > 1) {
            if (packagePathComponents.get(currentIndex).equalsIgnoreCase(name)) {
                for(Package _package:getPackages().values()) {
                    matches = _package.hasPackagePath(packagePathComponents, currentIndex + 1, sizeRemaining - 1);
                    if(matches) {
                        break;
                    }
                }
            }
        } else if(sizeRemaining == 1) {
            if(packagePathComponents.get(currentIndex).equalsIgnoreCase(name)) {
                matches = true;
            }
        } else {
            throw new RuntimeException("Invalid size. Recursion exceeded bounds");
        }
        return matches;
    }


    public String toString() {
        return name;
    }
}
