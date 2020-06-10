package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class BmmUnitaryType
 * Parent of meta-nl.rosa.semanticdatabase.bmm.model.types that may be used as the type of any instantiated object
 * that is not a container object.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BmmUnitaryType extends BmmType  {
    // Functions

    /**
     * 1..1
     * (effected)
     * unitary_type (): BMM_UNITARY_TYPE
     * Result = self.
     * @return
     */
    public BmmUnitaryType unitaryType() {
        return null;
    }
}
