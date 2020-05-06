package nl.rosa.semanticdatabase.referencemodel.model_structure;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Default created on 5-5-2020
 * A BMM model component that contains packages and classes.
 * Inherit: BmmDeclaration
 */
@Getter
@Setter
public class BmmPackageContainer extends BmmDeclaration{
    //TODO
    @Builder
    public BmmPackageContainer(String name){
        super(name);
    }
}
