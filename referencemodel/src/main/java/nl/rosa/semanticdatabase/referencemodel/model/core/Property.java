package nl.rosa.semanticdatabase.referencemodel.model.core;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;

@Getter
@Setter
public class Property<T extends Type> extends ModelElement{
    private String name;
    private Boolean isMandatory;
    /**
     * True if this property is computed rather than stored in objects of this class.
     */
    private Boolean isComputed;
    private T type;
    /**
     * True if this property is marked with info model 'im_runtime' property.
     */
    private Boolean isImRuntime;
    /**
     * True if this property was marked with info model 'im_infrastructure' flag.
     */
    private Boolean isImInfrastructure;

    public Property() {
    }

    public Property(String name, T type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Method returns true if Type argument is a container type.
     *
     * @param type
     * @return
     */
    public static boolean isContainerType(String type) {
        return type.equals(Type.P_CONTAINER_TYPE) || type.equals(Type.CONTAINER_TYPE);
    }

    /**
     * Interval form of 0..1, 1..1 etc, generated from is_mandatory.
     *
     * @return
     */
    public MultiplicityInterval getExistence() {
        MultiplicityInterval interval = null;
        if(isMandatory) {
            interval = MultiplicityInterval.createMandatory();
        } else {
            interval = MultiplicityInterval.createOptional();
        }
        return interval;
    }

    public Property duplicate() {
        Property property = new Property();
        property.setName(this.name);
        property.setIsComputed(this.isComputed);
        property.setIsImInfrastructure(this.isImInfrastructure);
        property.setIsImRuntime(this.isImRuntime);
        property.setIsMandatory(this.isMandatory);
        property.setType(this.type);
        property.setDocumentation(this.getDocumentation());
        return property;
    }
}
