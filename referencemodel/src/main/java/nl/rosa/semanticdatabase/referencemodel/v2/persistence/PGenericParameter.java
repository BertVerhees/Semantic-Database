package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

public final class PGenericParameter extends PBase {

    private String documentation;
    private String name;
    private String conformsToType;

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConformsToType() {
        return conformsToType;
    }

    public void setConformsToType(String conformsToType) {
        this.conformsToType = conformsToType;
    }
}

