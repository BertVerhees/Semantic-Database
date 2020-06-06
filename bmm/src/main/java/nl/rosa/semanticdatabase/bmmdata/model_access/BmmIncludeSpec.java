package nl.rosa.semanticdatabase.bmmdata.model_access;

import lombok.Data;
import lombok.NonNull;

/**
 * Default created on 6-6-2020
 */
/**
 * Description
 * Schema inclusion structure.
 */
@Data
public class BmmIncludeSpec {
    /**
     * 1..1
     * id: String
     * Full identifier of the included schema, e.g. "openehr_primitive_types_1.0.2".
     */
    @NonNull
    private String bmmId;
}
