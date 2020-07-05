package nl.rosa.semanticdatabase.bmmdata.services.model_access.data;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Default created on 6-6-2020
 */
/**
 * Description
 * Schema inclusion structure.
 */
@Component
public class BmmIncludeSpec extends BmmBaseEntity {
    /**
     * 1..1
     * id: String
     * Full identifier of the included schema, e.g. "openehr_primitive_types_1.0.2".
     */
    @NonNull
    @Getter
    @Setter
    private String bmmId;
    //=============  counterparts =========================================================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_bmm_schema_id")
    @Getter
    private BmmSchema bmmSchema;

    public BmmIncludeSpec setBmmClass(BmmSchema bmmSchema) {
        this.bmmSchema = bmmSchema;
        return this;
    }
}
