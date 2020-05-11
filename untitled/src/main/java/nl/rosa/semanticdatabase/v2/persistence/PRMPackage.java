package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

@Getter
@Setter
public final class PRMPackage extends PRMPackageContainer {

    private String documentation;
    private String name;
    private List<String> classes;

    public PRMPackage() {

    }

    public PRMPackage(String name) {
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
    public void setClassesAndPackagesFrom(PRMPackage other) {
        setClasses(new ArrayList<>(other.getClasses()));
        CaseInsensitiveLinkedHashMap<PRMPackage> packages = new CaseInsensitiveLinkedHashMap<>();
        packages.putAll(other.getPackages());
        //bit tricky because packages is not cloned first. However, cloning it would make the
        //CanonicalPackageGenerator contain errors.
        setPackages(packages);
    }

    public String getDocumentation() {
        return documentation;
    }

    public void doRecursiveClasses(BiConsumer<PRMPackage, String> action) {
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

