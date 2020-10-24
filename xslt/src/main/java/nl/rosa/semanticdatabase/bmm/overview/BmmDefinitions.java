package nl.rosa.semanticdatabase.bmm.overview;

/**
 * 
 * Definitions used by all BMM packages.
 * 
*/
public interface BmmDefinitions extends BasicDefinitions {

/**
 * 
 * Current internal version of BMM meta-model, used to determine if a given schema can be processed by a given implementation of the model.
 * 
*/
String getBmmInternalVersion()
setBmmInternalVersion(var String)

/**
 * 
 * Delimiter used to separate schema id from package path in a fully qualified path.
 * 
*/
String = " getSchemaNameDelimiter()
setSchemaNameDelimiter(var String = ")

/**
 * 
 * Delimiter used to separate package names in a package path.
 * 
*/
String = "." getPackageNameDelimiter()
setPackageNameDelimiter(var String = ".")

/**
 * 
 * Extension used for BMM files.
 * 
*/
String = ".bmm" getBmmSchemaFileExtension()
setBmmSchemaFileExtension(var String = ".bmm")

/**
 * 
 * Appears between a name and a type in a declaration or type signature.
 * 
*/
Character = ' getTypeDelimiter()
setTypeDelimiter(var Character = ')

/**
 * 
 * Left delimiter for generic class and generic type names, as used in List<T>.
 * 
*/
Character = '<' getGenericLeftDelimiter()
setGenericLeftDelimiter(var Character = '<')

/**
 * 
 * Right delimiter for generic class and generic type names, as used in List<T>.
 * 
*/
Character = '>' getGenericRightDelimiter()
setGenericRightDelimiter(var Character = '>')

/**
 * 
 * Separator used in Generic types.
 * 
*/
Character = ',' getGenericSeparator()
setGenericSeparator(var Character = ',')

/**
 * 
 * Delimiter between formal type parameter and constraint type, as used in Sortable<T: Ordered>.
 * 
*/
Character = ' getGenericConstraintDelimiter()
setGenericConstraintDelimiter(var Character = ')

/**
 * 
 * Left delimiter of a Tuple type and also instance.
 * Example: [Integer, String] - a tuple type; [3, "Quixote"] - a tuple.
 * 
*/
Character = '[' getTupleLeftDelim()
setTupleLeftDelim(var Character = '[')

/**
 * 
 * Right delimiter of a Tuple type and also instance.
 * 
*/
Character = ']' getTupleRightDelim()
setTupleRightDelim(var Character = ']')

/**
 * 
 * Separator used in Tuple types and instances.
 * 
*/
Character = ',' getTupleSeparator()
setTupleSeparator(var Character = ',')

/**
 * 
 * Left delimiter used in serial form of instance constrained enumeration.
 * 
*/
Character = '«' getConstraintLeftDelim()
setConstraintLeftDelim(var Character = '«')

/**
 * 
 * Right delimiter used in serial form of instance constrained enumeration.
 * 
*/
Character = '»' getConstraintRightDelim()
setConstraintRightDelim(var Character = '»')

/**
 * 
 * Attribute name of logical attribute 'bmm_version' in .bmm schema file.
 * 
*/
String = "bmmVersion" getMetadataBmmVersion()
setMetadataBmmVersion(var String = "bmmVersion")

/**
 * 
 * Attribute name of logical attribute 'schema_name' in .bmm schema file.
 * 
*/
String = "schemaName" getMetadataSchemaName()
setMetadataSchemaName(var String = "schemaName")

/**
 * 
 * Attribute name of logical attribute 'rm_publisher' in .bmm schema file.
 * 
*/
String = "rmPublisher" getMetadataRmPublisher()
setMetadataRmPublisher(var String = "rmPublisher")

/**
 * 
 * Attribute name of logical attribute 'rm_release' in .bmm schema file.
 * 
*/
String = "rmRelease" getMetadataRmRelease()
setMetadataRmRelease(var String = "rmRelease")

/**
 * 
 * Attribute name of logical attribute 'schema_revision' in .bmm schema file.
 * 
*/
String = "schemaRevision" getMetadataSchemaRevision()
setMetadataSchemaRevision(var String = "schemaRevision")

/**
 * 
 * Attribute name of logical attribute 'schema_lifecycle_state' in .bmm schema file.
 * 
*/
String = "schemaLifecycleState" getMetadataSchemaLifecycleState()
setMetadataSchemaLifecycleState(var String = "schemaLifecycleState")

/**
 * 
 * Attribute name of logical attribute 'schema_description' in .bmm schema file.
 * 
*/
String = "schemaDescription" getMetadataSchemaDescription()
setMetadataSchemaDescription(var String = "schemaDescription")

/**
 * 
 * Path of schema file.
 * 
*/
String = "schemaPath" getMetadataSchemaPath()
setMetadataSchemaPath(var String = "schemaPath")

}
