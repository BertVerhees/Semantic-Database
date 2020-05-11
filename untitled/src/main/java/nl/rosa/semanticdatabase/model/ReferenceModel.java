package nl.rosa.semanticdatabase.referencemodel.model;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class ReferenceModel {
    private URL targetNamespace;
    private URL defaultNamespace;
    private URL schemaLocation;
}
