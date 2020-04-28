package nl.rosa.semanticdatabase.archetypeobjectmodel.adl.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.rosa.semanticdatabase.base.terminology.TerminologyCode;

public class ResourceDescriptionMixin {

    @JsonSerialize(converter = TermCodeAsStringConverter.class)
    private TerminologyCode lifecycleState;
}
