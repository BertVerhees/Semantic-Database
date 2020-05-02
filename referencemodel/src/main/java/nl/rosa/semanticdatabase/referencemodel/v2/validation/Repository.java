package nl.rosa.semanticdatabase.referencemodel.v2.validation;

import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Repository {

    private Map<String, PSchema> persistentSchemasById = new ConcurrentHashMap<>();

    private Map<String, ValidationResult> modelsById = new ConcurrentHashMap<>();

    /** models by the archetype closure, eg for openEHR-EHR-OBSERVATION.test.v1.0.0
     * you use openEHR-EHR_1.0.4 for RM model 1.0.4
     */
    private Map<String, ValidationResult> modelsByClosure = new ConcurrentHashMap<>();

    public Repository() {

    }

    public List<PSchema> getPersistentSchemas() {
        return new ArrayList<>(persistentSchemasById.values());
    }

    public PSchema getPersistentSchema(String schemaId) {
        return persistentSchemasById.get(schemaId.toLowerCase());
    }

    public void addPersistentSchema(PSchema schema) {
        this.persistentSchemasById.put(schema.getSchemaId().toLowerCase(), schema);
    }

    public List<ValidationResult> getModels() {
        return new ArrayList<>(modelsById.values());
    }

    public List<ValidationResult> getValidModels() {
        return modelsById.values().stream().filter(validationResult -> validationResult.passes()).collect(Collectors.toList());
    }

    public List<ValidationResult> getInvalidModels() {
        return modelsById.values().stream().filter(validationResult -> !validationResult.passes()).collect(Collectors.toList());
    }

    public ValidationResult getModel(String schemaId) {
        return modelsById.get(schemaId.toLowerCase());
    }

    public void addModel(ValidationResult model) {
        this.modelsById.put(model.getSchemaId().toLowerCase(),  model);
    }

    public boolean containsPersistentSchema(String schemaId) {
        return persistentSchemasById.containsKey(schemaId.toLowerCase());
    }

    public void addModelByClosure(String closure,  ValidationResult model) {
        this.modelsByClosure.put(closure.toLowerCase(), model);

    }

    public ValidationResult getModelByClosure(String closure) {
        return modelsByClosure.get(closure.toLowerCase());
    }
}
