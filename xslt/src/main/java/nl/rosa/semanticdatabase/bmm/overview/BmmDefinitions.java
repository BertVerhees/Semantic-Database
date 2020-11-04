package nl.rosa.semanticdatabase.bmm.overview;

/**
 * 
 * Definitions used by all BMM packages.
 * 
*/
public interface BmmDefinitions extends BasicDefinitions {

/* * ATTRIBUTE * */

/**
 * 
 * Current internal version of BMM meta-model, used to determine if a given schema can be processed by a given implementation of the model.
 * 
*/
    String getBmmInternalVersion();
    void setBmmInternalVersion(String value);

/* * FUNCTION * */

/**
 * 
 * built-in class definition corresponding to the top `Any' class.
 * 
*/
    BmmSimpleClass  Any_class();

/**
 * 
 * Built-in type definition corresponding to the top `Any' type.
 * 
*/
    BmmSimpleType  Any_type();

/**
 * 
 * Create schema id, formed from: a_model_publisher '-' a_schema_name '-' a_model_release e.g.
 * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
 * 
*/
    String  create_schema_id();

/* * CONSTANTS * */

/**
 * 
 * Delimiter used to separate schema id from package path in a fully qualified path.
 * 
*/
    String schemaNameDelimiter = "::";

/**
 * 
 * Delimiter used to separate package names in a package path.
 * 
*/
    String packageNameDelimiter = ".";

/**
 * 
 * Extension used for BMM files.
 * 
*/
    String bmmSchemaFileExtension = ".bmm";

/**
 * 
 * Appears between a name and a type in a declaration or type signature.
 * 
*/
    Character typeDelimiter = ':';

/**
 * 
 * Left delimiter for generic class and generic type names, as used in List<T>.
 * 
*/
    Character genericLeftDelimiter = '<';

/**
 * 
 * Right delimiter for generic class and generic type names, as used in List<T>.
 * 
*/
    Character genericRightDelimiter = '>';

/**
 * 
 * Separator used in Generic types.
 * 
*/
    Character genericSeparator = ',';

/**
 * 
 * Delimiter between formal type parameter and constraint type, as used in Sortable<T: Ordered>.
 * 
*/
    Character genericConstraintDelimiter = ':';

/**
 * 
 * Left delimiter of a Tuple type and also instance.
 * Example: [Integer, String] - a tuple type; [3, "Quixote"] - a tuple.
 * 
*/
    Character tupleLeftDelim = '[';

/**
 * 
 * Right delimiter of a Tuple type and also instance.
 * 
*/
    Character tupleRightDelim = ']';

/**
 * 
 * Separator used in Tuple types and instances.
 * 
*/
    Character tupleSeparator = ',';

/**
 * 
 * Left delimiter used in serial form of instance constrained enumeration.
 * 
*/
    Character constraintLeftDelim = '«';

/**
 * 
 * Right delimiter used in serial form of instance constrained enumeration.
 * 
*/
    Character constraintRightDelim = '»';

/**
 * 
 * Attribute name of logical attribute 'bmm_version' in .bmm schema file.
 * 
*/
    String metadataBmmVersion = "bmm_version";

/**
 * 
 * Attribute name of logical attribute 'schema_name' in .bmm schema file.
 * 
*/
    String metadataSchemaName = "schema_name";

/**
 * 
 * Attribute name of logical attribute 'rm_publisher' in .bmm schema file.
 * 
*/
    String metadataRmPublisher = "rm_publisher";

/**
 * 
 * Attribute name of logical attribute 'rm_release' in .bmm schema file.
 * 
*/
    String metadataRmRelease = "rm_release";

/**
 * 
 * Attribute name of logical attribute 'schema_revision' in .bmm schema file.
 * 
*/
    String metadataSchemaRevision = "schema_revision";

/**
 * 
 * Attribute name of logical attribute 'schema_lifecycle_state' in .bmm schema file.
 * 
*/
    String metadataSchemaLifecycleState = "schema_lifecycle_state";

/**
 * 
 * Attribute name of logical attribute 'schema_description' in .bmm schema file.
 * 
*/
    String metadataSchemaDescription = "schema_description";

/**
 * 
 * Path of schema file.
 * 
*/
    String metadataSchemaPath = "schema_path";

}
