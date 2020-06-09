package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

import java.util.List;

/**
 * Class BmmUnitaryType
 * Parent of meta-nl.rosa.semanticdatabase.bmm.model.types that may be used as the type of any instantiated object
 * that is not a container object.
 */
public abstract class BmmUnitaryType extends BmmBaseEntity implements BmmType {
    /**
     * BmmType
     */
    /**
     * BmmType
     */
    // Functions
    @NonNull
    public String typeName(){
        return null;
    }
    @NonNull
    public List<String> flattenedTypeList(){
        return null;
    }
    @NonNull
    public String typeSignature(){
        return null;
    }
    @NonNull
    public BmmUnitaryType unitaryType(){
        return null;
    }
    @NonNull
    public BmmEffectiveType effectiveType(){
        return null;
    }
    @NonNull
    public Boolean isAbstract(){
        return null;
    }
    @NonNull
    public Boolean isPrimitive(){
        return null;
    }
    //==================================================================================
}
