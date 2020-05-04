package nl.rosa.semanticdatabase.referencemodel.v2.validation;

import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class RMRepository {

    private Map<String, PRMSchema> persistentSchemasById = new ConcurrentHashMap<>();

    private Map<String, RMValidationResult> modelsById = new ConcurrentHashMap<>();

    /** models by the archetype closure, eg for openEHR-EHR-OBSERVATION.test.v1.0.0
     * you use openEHR-EHR_1.0.4 for RM model 1.0.4
     */
    private Map<String, RMValidationResult> modelsByClosure = new ConcurrentHashMap<>();

    public RMRepository() {

    }

    public List<PRMSchema> getPersistentSchemas() {
        return new ArrayList<>(persistentSchemasById.values());
    }

    public PRMSchema getPersistentSchema(String schemaId) {
        return persistentSchemasById.get(schemaId.toLowerCase());
    }

    public void addPersistentSchema(PRMSchema schema) {
        this.persistentSchemasById.put(schema.getSchemaId().toLowerCase(), schema);
    }

    public List<RMValidationResult> getModels() {
        return new ArrayList<>(modelsById.values());
    }

    public List<RMValidationResult> getValidModels() {
        return modelsById.values().stream().filter(validationResult -> validationResult.passes()).collect(Collectors.toList());
    }

    public List<RMValidationResult> getInvalidModels() {
        return modelsById.values().stream().filter(validationResult -> !validationResult.passes()).collect(Collectors.toList());
    }

    public RMValidationResult getModel(String schemaId) {
        return modelsById.get(schemaId.toLowerCase());
    }

    public void addModel(RMValidationResult model) {
        this.modelsById.put(model.getSchemaId().toLowerCase(),  model);
    }

    public boolean containsPersistentSchema(String schemaId) {
        return persistentSchemasById.containsKey(schemaId.toLowerCase());
    }

    public void addModelByClosure(String closure,  RMValidationResult model) {
        this.modelsByClosure.put(closure.toLowerCase(), model);

    }

    public RMValidationResult getModelByClosure(String closure) {
        return modelsByClosure.get(closure.toLowerCase());
    }
}
