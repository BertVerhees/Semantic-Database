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
public class RMPackage extends RMPackageContainerImpl implements Serializable {
    /**
     * Name of this package. This name may be qualified if it is a top-level package.
     *
     */
    private String name;

    /**
     * Classes listed as being in this package.
     */
    private Map<String, RMClass> classes;

    /**
     * Path to root package.
     */
    private String canonicalPath = "";

    /**
     * The parent package that contains this package or null if package it a top-level package.
     */
    private RMPackage parent;

    /**
     * No-arg constructor
     */
    public RMPackage() {
        super();
        classes = new LinkedHashMap<String, RMClass>();
    }

    /**
     * Constructor initializing the package name
     *
     * @param name
     */
    public RMPackage(String name) {
        this();
        this.name = name;
    }


    /**
     * returns classes listed as being in this package as a shallow clone.
     *
     * @return
     */
    public List<RMClass> getClasses() {
        List<RMClass> classList = new ArrayList<>();
        classList.addAll(classes.values());
        return classList;
    }

    /**
     * Adds class to package.
     *
     * @param className
     * @param RMClass
     */
    public void addClass(String className, RMClass RMClass) {
        this.classes.put(className, RMClass);
    }

    /**
     * Adds class to package.
     *
     * @param RMClass
     */
    public void addClass(RMClass RMClass) {
        this.classes.put(RMClass.getName(), RMClass);
    }

    /**
     * Obtain the set of top-level classes in this package, either from this package itself or by recursing into the
     * structure until classes are obtained from child packages. Recurse into each child only far enough to find the
     * first level of classes.
     *
     * @return
     */
    public List<RMClass> getRootClasses() {
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
                for(RMPackage _RM_package :getPackages().values()) {
                    matches = _RM_package.hasPackagePath(packagePathComponents, currentIndex + 1, sizeRemaining - 1);
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
