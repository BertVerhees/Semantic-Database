package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

import java.util.Map;
import java.util.function.Consumer;

public class PRMPackageContainer extends PRMBase {

    private Map<String, PRMPackage> packages = new CaseInsensitiveLinkedHashMap<>();

    public Map<String, PRMPackage> getPackages() {
        if(packages == null) {
            packages = new CaseInsensitiveLinkedHashMap<>();
        }

        return packages;
    }

    public void setPackages(Map<String, PRMPackage> packages) {
        this.packages = packages;
    }

    /**
     * recursively execute `action' procedure, taking package as argument
     * @param agent
     */
    public void doRecursivePackages(Consumer<PRMPackage> agent) {
        getPackages().forEach((packageName, packageItem) -> {
            agent.accept(packageItem);
            packageItem.doRecursivePackages(agent);
        });
    }

}
