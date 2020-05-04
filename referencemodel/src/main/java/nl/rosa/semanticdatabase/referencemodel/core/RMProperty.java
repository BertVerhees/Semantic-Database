package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;

@Getter
@Setter
public class RMProperty<T extends RMType> extends RMModelElement {

    public static final String P_BMM_GENERIC_PROPERTY = "P_GENERIC_PROPERTY";
    public static final String P_BMM_CONTAINER_PROPERTY = "P_CONTAINER_PROPERTY";

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

    public RMProperty() {
    }

    public RMProperty(String name, T type) {
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
        return type.equals(RMType.P_RM_CONTAINER_TYPE) || type.equals(RMType.RM_CONTAINER_TYPE);
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

    public RMProperty duplicate() {
        RMProperty RMProperty = new RMProperty();
        RMProperty.setName(this.name);
        RMProperty.setIsComputed(this.isComputed);
        RMProperty.setIsImInfrastructure(this.isImInfrastructure);
        RMProperty.setIsImRuntime(this.isImRuntime);
        RMProperty.setIsMandatory(this.isMandatory);
        RMProperty.setType(this.type);
        RMProperty.setDocumentation(this.getDocumentation());
        return RMProperty;
    }
}
