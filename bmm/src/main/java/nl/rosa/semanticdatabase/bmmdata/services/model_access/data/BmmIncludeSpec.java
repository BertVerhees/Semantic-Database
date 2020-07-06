package nl.rosa.semanticdatabase.bmmdata.services.model_access.data;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Default created on 6-6-2020
 */
/**
 * Description
 * Schema inclusion structure.
 */
@Getter
@Setter
@Builder
public class BmmIncludeSpec {
    /**
     * 1..1
     * id: String
     * Full identifier of the included schema, e.g. "openehr_primitive_types_1.0.2".
     */
    @NonNull
    private String bmmId;
}
