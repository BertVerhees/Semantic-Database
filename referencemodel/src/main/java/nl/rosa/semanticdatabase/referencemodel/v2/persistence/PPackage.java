package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public final class PPackage extends PPackageContainer {

    private String documentation;
    private String name;
    private List<String> classes;

    public PPackage() {

    }

    public PPackage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getClasses() {
        if(classes == null) {
            classes = new ArrayList<>();
        }
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }


    /**
     * Adds all classes and packages from the other package, without further checks. Mainly used in the
     * CanonicalPackageGenerator
     * @param other
     */
    public void setClassesAndPackagesFrom(PPackage other) {
        setClasses(new ArrayList<>(other.getClasses()));
        CaseInsensitiveLinkedHashMap<PPackage> packages = new CaseInsensitiveLinkedHashMap<>();
        packages.putAll(other.getPackages());
        //bit tricky because packages is not cloned first. However, cloning it would make the
        //CanonicalPackageGenerator contain errors.
        setPackages(packages);
    }

    public String getDocumentation() {
        return documentation;
    }

    public void doRecursiveClasses(BiConsumer<PPackage, String> action) {
        getClasses().forEach(bmmClass -> {
            action.accept(this, bmmClass);
        });
        getPackages().forEach((key, bmmPackage) -> {
            bmmPackage.doRecursiveClasses(action);
        });
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }
}

