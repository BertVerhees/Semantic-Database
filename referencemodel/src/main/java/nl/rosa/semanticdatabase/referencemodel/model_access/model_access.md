The model_access package provides an interface for the application to load BMM schemas and convert them to BMM model form, and is shown below. In this model, a schema is a concrete serial form of a model or part of a model. One or more schema files are parsed, validated and then converted to create a single BMM_MODEL instance.

The singleton class BMM_MODEL_ACCESS acts as the entry point for client software to obtain access to loaded BMM models. Since the latter start as schema files which are typically nested according to an 'include' hierarchy, they must be parsed, validated and merged to create each 'top-level' model. The schemas are accessed via instances of the BMM_SCHEMA_DESCRIPTOR object, one for each schema file. The load() routine loads a BMM schema file by direct deserialisation.

Each successfully loaded model is thus instantiated as a BMM_MODEL, and referenceable via BMM_MODEL_ACCESS.valid_models, which keys models by model identifiers (BMM_SCHEMA_CORE.identifier). The methods model_for_namespace() and model_for_namespace() are used to access a given model for a namespace to which the model applies.

