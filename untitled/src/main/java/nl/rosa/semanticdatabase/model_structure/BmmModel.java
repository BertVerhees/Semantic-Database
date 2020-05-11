package nl.rosa.semanticdatabase.referencemodel.model_structure;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.classes.BmmClass;
import nl.rosa.semanticdatabase.referencemodel.model_access.BmmModelMetadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Default created on 5-5-2020
 *
 * Definition of the root of a BMM model (along with what is inherited from BMM_SCHEMA_CORE).
 *
 * Inherit: BMM_PACKAGE_CONTAINER, BMM_MODEL_METADATA
 */
@Getter
@Setter
public class BmmModel extends BmmModelMetadata{
    /**
     * All classes in this model, keyed by type name.
     */
    private Map<String, BmmClass> classDefinitions = new HashMap<>();
    /**
     * List of other models 'used' (i.e. 'imported' by this model).
     * Classes in the current model may refer to classes in a used model by specifying the other class’s scope meta-attribute.
     */
    private List<BmmModel> usedModels = new ArrayList<>();

    private BmmPackageContainer bmmPackageContainer;

    public BmmModel(String rmPublisher, String rmRelease, BmmPackageContainer bmmPackageContainer) {
        super(rmPublisher, rmRelease);
        this.bmmPackageContainer = bmmPackageContainer;
    }

    /**
     * Identifier of this model, lower-case, formed from:
     * rm_publisher '' model_name '' rm_release
     * E.g. 'openehr_ehr_1.0.4'.
     * @return
     */
    public String modelId(){
        return (getRmPublisher() + "_" + bmmPackageContainer.getName() + "_" + getRmRelease()).toLowerCase();
    }
    //TODO
}
