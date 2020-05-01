package nl.rosa.semanticdatabase.referencemodel.model.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * Default created on 29-4-2020
 */

@Getter
@Setter
public class Model extends PackageContainerImpl implements SchemaCore, PackageContainer, Serializable {

    private Map<String, Clasz> classDefinitions;
    private SchemaCore schemaCore;

    @Override
    public String getSchemaId() {
        return null;
    }
}
