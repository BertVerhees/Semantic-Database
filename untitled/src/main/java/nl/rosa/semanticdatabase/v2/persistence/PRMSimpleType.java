package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

import com.google.common.collect.Lists;

import java.util.List;

public final class PRMSimpleType extends PRMBaseType {

    private String type;

    public PRMSimpleType() {

    }

    public PRMSimpleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Formal name of the type for display.
     *
     * @return
     */
    @Override
    public String asTypeString() {
        return type;
    }

    @Override
    public List<String> flattenedTypeList() {
        return Lists.newArrayList(type);
    }

}
