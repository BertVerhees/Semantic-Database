package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

public abstract class PBaseType extends PType {
    private String valueConstraint;

    public String getValueConstraint() {
        return valueConstraint;
    }

    public void setValueConstraint(String valueConstraint) {
        this.valueConstraint = valueConstraint;
    }
}
