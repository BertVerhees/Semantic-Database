package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;

/**
 * Default created on 5-8-2020
 * Persistent form of BMM_TYPE.
 */
public abstract class PBmmType {
    /**
     * 0..1
     * bmm_type: BMM_TYPE
     * Result of create_bmm_type() call.
     */
    @Getter
    @Setter
    private BmmType bmmType;

    /**
     * 0..1
     * (abstract)
     * create_bmm_type ( * a_schema: BMM_MODEL[1], * a_class_def: BMM_CLASS[1] * )
     * Create appropriate BMM_XXX object; effected in descendants.
     * @param aSchema
     * @param aClass
     */
    public abstract void createBmmType(BmmModel aSchema, BmmClass aClass);

    /**
     * 1..1
     * (abstract)
     * as_type_string (): String
     * Formal name of the type for display.
     * @return
     */
    @NonNull
    public abstract String asTypeString();

}
