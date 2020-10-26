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
void setBmmInternalVersion(value String);

/**
 * 
 * Delimiter used to separate schema id from package path in a fully qualified path.
 * 
*/
String = " getSchemaNameDelimiter();
void setSchemaNameDelimiter(value String = ");

/**
 * 
 * Delimiter used to separate package names in a package path.
 * 
*/
String = "." getPackageNameDelimiter();
void setPackageNameDelimiter(value String = ".");

/**
 * 
 * Extension used for BMM files.
 * 
*/
String = ".bmm" getBmmSchemaFileExtension();
void setBmmSchemaFileExtension(value String = ".bmm");

/**
 * 
 * Appears between a name and a type in a declaration or type signature.
 * 
*/
Character = ' getTypeDelimiter();
void setTypeDelimiter(value Character = ');

/**
 * 
 * Left delimiter for generic class and generic type names, as used in List<T>.
 * 
*/
Character = '<' getGenericLeftDelimiter();
void setGenericLeftDelimiter(value Character = '<');

/**
 * 
 * Right delimiter for generic class and generic type names, as used in List<T>.
 * 
*/
Character = '>' getGenericRightDelimiter();
void setGenericRightDelimiter(value Character = '>');

/**
 * 
 * Separator used in Generic types.
 * 
*/
Character = ',' getGenericSeparator();
void setGenericSeparator(value Character = ',');

/**
 * 
 * Delimiter between formal type parameter and constraint type, as used in Sortable<T: Ordered>.
 * 
*/
Character = ' getGenericConstraintDelimiter();
void setGenericConstraintDelimiter(value Character = ');

/**
 * 
 * Left delimiter of a Tuple type and also instance.
 * Example: [Integer, String] - a tuple type; [3, "Quixote"] - a tuple.
 * 
*/
Character = '[' getTupleLeftDelim();
void setTupleLeftDelim(value Character = '[');

/**
 * 
 * Right delimiter of a Tuple type and also instance.
 * 
*/
Character = ']' getTupleRightDelim();
void setTupleRightDelim(value Character = ']');

/**
 * 
 * Separator used in Tuple types and instances.
 * 
*/
Character = ',' getTupleSeparator();
void setTupleSeparator(value Character = ',');

/**
 * 
 * Left delimiter used in serial form of instance constrained enumeration.
 * 
*/
Character = '«' getConstraintLeftDelim();
void setConstraintLeftDelim(value Character = '«');

/**
 * 
 * Right delimiter used in serial form of instance constrained enumeration.
 * 
*/
Character = '»' getConstraintRightDelim();
void setConstraintRightDelim(value Character = '»');

/**
 * 
 * Attribute name of logical attribute 'bmm_version' in .bmm schema file.
 * 
*/
String = "bmmVersion" getMetadataBmmVersion();
void setMetadataBmmVersion(value String = "bmmVersion");

/**
 * 
 * Attribute name of logical attribute 'schema_name' in .bmm schema file.
 * 
*/
String = "schemaName" getMetadataSchemaName();
void setMetadataSchemaName(value String = "schemaName");

/**
 * 
 * Attribute name of logical attribute 'rm_publisher' in .bmm schema file.
 * 
*/
String = "rmPublisher" getMetadataRmPublisher();
void setMetadataRmPublisher(value String = "rmPublisher");

/**
 * 
 * Attribute name of logical attribute 'rm_release' in .bmm schema file.
 * 
*/
String = "rmRelease" getMetadataRmRelease();
void setMetadataRmRelease(value String = "rmRelease");

/**
 * 
 * Attribute name of logical attribute 'schema_revision' in .bmm schema file.
 * 
*/
String = "schemaRevision" getMetadataSchemaRevision();
void setMetadataSchemaRevision(value String = "schemaRevision");

/**
 * 
 * Attribute name of logical attribute 'schema_lifecycle_state' in .bmm schema file.
 * 
*/
String = "schemaLifecycleState" getMetadataSchemaLifecycleState();
void setMetadataSchemaLifecycleState(value String = "schemaLifecycleState");

/**
 * 
 * Attribute name of logical attribute 'schema_description' in .bmm schema file.
 * 
*/
String = "schemaDescription" getMetadataSchemaDescription();
void setMetadataSchemaDescription(value String = "schemaDescription");

/**
 * 
 * Path of schema file.
 * 
*/
String = "schemaPath" getMetadataSchemaPath();
void setMetadataSchemaPath(value String = "schemaPath");

/* * FUNCTION * */

/**
 * 
 * built-in class definition corresponding to the top `Any' class.
 * Any_class (): BMM_SIMPLE_CLASS
 * 
*/
BmmSimpleClass anyClass ();

/**
 * 
 * Built-in type definition corresponding to the top `Any' type.
 * Any_type (): BMM_SIMPLE_TYPE
 * 
*/
BmmSimpleType anyType ();

/**
 * 
 * Create schema id, formed from: a_model_publisher '-' a_schema_name '-' a_model_release e.g.
 * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
 * create_schema_id ( a_model_publisher, a_schema_name, a_model_release: String[1] ): String
 * 
*/
String createSchemaId ( aModelPublisher, aSchemaName, aModelRelease: string[1]);

}
