package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.encapsulated;

import nl.rosa.semanticdatabase.referencemodel.model.internal.datatypes.CodePhrase;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.DvURI;
import org.springframework.lang.Nullable;

public class DvMultimedia extends DvEncapsulated {
    @Nullable
    private String alternateText;
    @Nullable
    private DvURI uri;
    @Nullable
    private byte[] data;
    private CodePhrase mediaType;//TODO: construct default codephrase with mime type already set as terminology id
    @Nullable
    private CodePhrase compressionAlgorithm;
    @Nullable
    private byte[] integrityCheck;

    @Nullable
    private CodePhrase integrityCheckAlgorithm;

    private Integer size;

    @Nullable
    private DvMultimedia thumbnail;


}
