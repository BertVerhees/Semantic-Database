package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues;

import java.net.URI;

public class DvURI extends DataValue {
    private URI value; //supposed to be a string, but this is better. Legal to change this with type replacements.


    public DvURI() {
    }

    public DvURI(URI value) {
        this.value = value;
    }

    /**
     * Creates a DVURI from a URI String representation
     *
     * @param uri
     */
    public DvURI(String uri) {
        this.value = URI.create(uri);
    }

}
