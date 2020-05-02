package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

import java.util.Map;
import java.util.function.Consumer;

public class PPackageContainer extends PBase {

    private Map<String, PPackage> packages = new CaseInsensitiveLinkedHashMap<>();

    public Map<String, PPackage> getPackages() {
        if(packages == null) {
            packages = new CaseInsensitiveLinkedHashMap<>();
        }

        return packages;
    }

    public void setPackages(Map<String, PPackage> packages) {
        this.packages = packages;
    }

    /**
     * recursively execute `action' procedure, taking package as argument
     * @param agent
     */
    public void doRecursivePackages(Consumer<PPackage> agent) {
        getPackages().forEach((packageName, packageItem) -> {
            agent.accept(packageItem);
            packageItem.doRecursivePackages(agent);
        });
    }

}
