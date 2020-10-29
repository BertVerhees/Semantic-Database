package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Meta-type for reference to a non-abstract type as an object.
 * Assumed to be accessible at run-time.
 * Typically represented syntactically as TypeName or {TypeName}.
 * May be used as a value, or as the qualifier for a function or constant access.
 * 
*/
public interface ElTypeRef extends ElInstanceRef {

/* * ATTRIBUTE * */

/**
 * 
 * Type, directly from the name of the reference, e.g.
 * {SOME_TYPE}.
 * 
*/
    ElTypeRef getType();
    void setType(value ElTypeRef);

/* * FUNCTION * */

/**
 * 
 * Return type.
 * eval_type (): BMM_TYPE
 * 
*/
    package nl/rosa/semanticdatabase/bmm;

/**
 * 
 * Title: Basic Meta-Model (BMM)
 * 
 * Java generated from OpenEhr-html to Java by XSLT (Bert Verhees)
 * From BMM-document:
 * 
 * 3.1.0:SPECLANG-2.
 * Add Basic Meta-Model (BMM) spec to LANG component.:openEHR SEC:11 May 2020
bmmpackage bmm/amendment_record;
/**
 * 
 * 
 * Amendment Record
 * 
*/
bmm/amendment_recordpackage bmm/acknowledgements;
/**
 * 
 * 
 * Acknowledgements
 * Primary Author
 * 
 * 
 * 
 * Contributors
 * This specification has benefited from formal and informal input from the openEHR and wider health informatics community.
 * The openEHR Foundation would like to recognise the following people for their contributions.
 * 
 * 
 * 
 * 
 * Trademarks
 * 
 * 
 * 
 * 
*/
bmm/acknowledgementspackage bmm/preface;
/**
 * 
 * 
 * 1.
 * Preface
 * 1.1.
 * Purpose
 * This document describes the Basic Meta-Model (BMM), a model of object models.
 * It may be considered as an approximate replacement for the UML XMI.
 * It is human-readable and writable, and supports generic types (open and closed), container types, and multiple inheritance.
 * 
 * 
 * 1.2.
 * Status
 * This specification is in the TRIAL state.
 * The development version of this document can be found at https://specifications.openehr.org/releases/LANG/latest/bmm.html.Known omissions or questions are indicated in the text with a 'to be determined' paragraph, as follows:TBD: (example To Be Determined paragraph)
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 1.3.
 * Feedback
 * Feedback may be provided on the openEHR languages specifications forum.Issues may be raised on the specifications Problem Report tracker.To see changes made due to previously reported issues, see the LANG component Change Request tracker.
 * 
 * 
 * 
 * 
 * 
 * 
 * 1.4.
 * Conformance
 * Conformance of a data or software artifact to an openEHR specification is determined by a formal test of that artifact against the relevant openEHR Implementation Technology Specification(s) (ITSs), such as an IDL interface or an XML-schema.
 * Since ITSs are formal derivations from underlying models, ITS conformance indicates model conformance.
 * 
 * 
 * 1.5.
 * Previous Versions
 * 
 * 1.5.1.
 * Version 3.0.0
 * This version made major changes to the BMM_TYPE hierarchy and semantics, enabling generic inheritance by generic and non-generic classes to be represented.
 * 1.5.2.
 * Version 3.1.0
 * This version adds meta-classes for computational elements to BMM, including: routines, variables, constants; expressions (including assertions); statements.
 * It makes various adjustments to the existing model attributes and classes.
 * The BMM remains compatible with P_BMM 2.x, i.e.
 * any existing .bmm file can be parsed to create a v 3.1.0 BMM instance.
 * 1.6.
 * A Note on Language
 * The elements of meta-models are sometimes named confusingly in the literature and within various programming language technologies.
 * In this specification, we use the following terms:
 * class
 * generally refers to a class defined in a model expressed in BMM, i.e.
 * an instance of a BMM meta-class;
 * meta-class
 * refers to a class in the BMM itself, such as BMM_CLASS, in order to clearly distinguish it from classes defined in models represented using BMM;
 * feature (of a class)
 * any stored or computed element of a class, including constants, attributes (properties) and routines (methods);
 * property
 * a stored class feature; also known as 'attribute';
 * routine
 * a computed class feature that may be either value-returning (a function) or work-performing (a procedure);
 * function
 * a routine that computes and returns a value; typically causes no side-effects in the object;
 * procedure
 * a routine that performs a computation; typically has side-effects;
 * generic (class or type)
 * a kind of class or type that has parameters of other types; known as 'template' type in some programming languages;
 * type
 * generally refers to a type defined in a model expressed in BMM, i.e.
 * an instance of a BMM meta-type;
 * meta-type
 * refers to a type in the BMM itself, which is either a class (such as BMM_CLASS) or generically derived (meta-)type in the sense of being an instance generator, where the instances will be concrete type definitions in models represented using BMM.
 * 
 * 
 * 
 * 
 * 1.7.
 * Tooling
 * The openEHR Archie Library fully implements this specification in Java and may be used to build UI tools for compiling, viewing and editing BMM models.The openEHR ADL Workbench (AWB) fully implements this specification, and provides a convenient way of illustrating BMM semantics.
 * The screenshots used in this specification are all from the ADL Workbench.
 * The tool is written in the Eiffel language, and is available as open source on Github.
 * The BMM libraries can be found in the EOMF Github repository.
 * 
 * 
 * 
 * 
 * 
*/
bmm/prefacepackage bmm/overview;
/**
 * 
 * 
 * 2.
 * Overview
 * 2.1.
 * Introduction
 * One of the key needs in any open computing environment is a computable representation of its own models.
 * This is for a number of purposes, including reasoning about them, performing validation and consistency checking, building software and generating documentation.
 * This is particularly true of openEHR and other archetype-based frameworks, where a further need is to be able to validate archetypes and templates with respect to the reference model, and also to validate runtime instance data against operational templates and the reference model.A number of computable representations of the openEHR published models have been available in the past.
 * Currently models are represented in two computable forms, namely UML and BMM (i.e.
 * the format described in this specification).The primary use of the UML expression is for specification publishing.
 * In this role, UML diagrams and static models are built, and then post-processed to correct signatures of class properties and functions.
 * The post-processing corrects UML’s shortcomings and errors in non-singular relations, generic (template) types, and qualified attributes.
 * The result can be used for publishing documentation with feature signatures that are formally correct and will be understood by developers in most programming languages.
 * It can also be serialised and used computably, e.g.
 * in other visualisation or modelling tools.
 * UML’s own serial format, XMI is thus generally unsuitable for such uses, due to the formal errors, as well as its excessive complexity.
 * XMI is also notoriously non-standard across UML tools.As a result, openEHR introduced the Basic Meta-Model (BMM) in 2009 as a way of representing correct object-oriented semantics of information models for use in tools, along with a serial format by default expressed in the openEHR ODIN syntax.The BMM provides a standalone alternative to UML/XMI which correctly represents all types, including open and closed generic types, inheritance of generic types, and various other problems with UML.
 * As a meta-model it is adapted to the task, i.e.
 * representing entity types that can appear in object models, rather than the over-generalised semantics of the UML meta-model.
 * This reduced scope, and the fact that it contains no diagram semantics enables its serial form to be human-readable.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 2.2.
 * Features
 * The Basic Meta-Model supports the representation of object models in the ISO RM/ODP information and computational points of view, i.e.
 * in programming terms:It is designed to enable both human authoring and machine processing, including e.g.
 * extraction of BMM textual schemas from a UML tool or programming language classes.
 * The semantics of the model are heavily influenced by the formal approach to object-orientation described by Bertrand Meyer in Object-oriented Software Construction (Meyer, 1997) and also the Eiffel language, which is significantly better basis for object modelling than the UML 2.x meta-model.
 * The BMM consequently departs from UML in a number of significant ways, and also from the OOSC/Eiffel approach in some aspects (e.g.
 * direct meta-type suport for container types).
 * Its key features are as follows:Functional elements are supported via the inclusion of meta-types representing signatures and tuples, enabling the construction of delayed agent calls, known here as agents, and function applications (i.e.
 * function calls).Note that there is no BMM entity for graphical diagramming semantics.
 * Thus, there is no idea of 'association' distinct from an 'attribute', as per UML, which treats lines between class boxes as formal elements.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 2.3.
 * Current State of the Art
 * 
 * 2.3.1.
 * UML
 * One would expect that the IT industry would have fully computable representations of models and diagramming solved, but it is not yet the case.
 * UML 2.x and its associated serialisation format XMI 2.x should in theory mean that complete, interoperable machine expressions of object models would be available in all tools.
 * However the evolution of UML and XMI has not been toward a clear meta-model and language for each of its sub-languages (i.e.
 * static class model, state machine, interaction diagram etc) but rather toward a single universal model of everything in which elements of all of its needs are confusingly buried.
 * The UML 2.x specifications are exceedingly complex: UML 2.1.2 was specified by two documents, 'Superstructure' (738pp) and 'Infrastructure' (224pp); the UML 2.5.1 specification is only slightly smaller at 796 pages (see the OMG UML page for current specifications).
 * The XMI 2.x specification is correspondingly complex, which seems to have so far prevented reliable tool interoperability (recognised as a critical issue by OMG in 2015).
 * Despite the complexity, there are significant limitations in the UML meta-model, including: the composite or association nature of a class property only being known if it is represented as an association, i.e.
 * a line linking two classes on a UML diagram; the notion of type is not adequately formalised; the meta-model of generic types and container properties is problematic and does not map well to object programming languages; the Design By Contract (DbC) concept (i.e.
 * pre-, post-conditions, class invariants), crucial for proper specifications, is in theory supported via the use of OCL 2.0 constraints in class definitions, but OCL suffers from the same underlying semantic weaknesses as UML; there is no direct support for functional entities, i.e.
 * routine calls as objects (aka 'lambdas').
 * Experience with various UML tools (up till 2015) highlighted the following problems: poor support for OCL and design by contract in most tools; variable support for generic (i.e.
 * template) classes; even those tools that properly implement the UML 2.5 specification are still very hard to use for defining generic classes because of problems in the specification that remain unaddressed; problems with qualified attributes, which are used to represent identifier references to objects rather than direct references; variable support for XSD generation across tools, where the results are wildly wrong in some tools; in some tools, it is impossible to define an abstract formal model - the only option is to select a particular programming language profile such as Java or C# and thus get locked into the limitations of those languages (messy type systems, weak inheritance semantics, language-specific notion of types such as Array<T>, List<T>, etc.).
 * Since 2015, the quality of some UML tools has improved, and the XMI generated by some is more reliable.
 * However, XMI generated by different tools is not the same for identical models, and some XMI importers offer numerous switches in order to process the XMI of another tool properly.
 * XMI thus still needs to be processed with care.
 * Nevertheless, a small number of tools, including MagicDraw (currently used for representing openEHR models for the specifications) and Rational Software Architect (RSA), appear to implement UML 2.5 faithfully.
 * This means that despite the limitations of UML 2.5 (as noted above), models expressed in it can be mostly correctly interpreted and corrected by post-processing for purposes such as code generation and specifications publishing.
 * Note Other tools may perform as well or better, and in any case, all tools change over time.
 * No endorsement of a particular tool is intended here.
 * 2.3.2.
 * XML Schema
 * For some, W3C XML schema represents a way of expressing object models, but it is not semantically suitable for this purpose, primarily due to its problematic non-object-oriented inheritance semantics, lack of generic classes, lack of representation of non-data members, and only marginal support for design by contract.
 * It can be and is often used (including in openEHR) as a derivative serialisation representation.
 * 2.4.
 * Computational Model
 * The BMM is specified as a structural model representing an abstract syntax tree (AST), which is the result of either in-memory construction (such as by a model authoring tool) or by parsing of a serialised representation of a BMM model.
 * It does not specify an abstract syntax, and indeed, more than one concrete syntax could be parsed to a BMM instance.
 * 
 * 
 * 
 * 
 * 2.5.
 * Uses of the BMM
 * 
 * 2.5.1.
 * Class Model Representation
 * The BMM from version 3.0.0 on may be used to represent a full class model at an interface level (i.e.
 * without code for methods) including classes, types, and class feature types including property (i.e.
 * attribute), symbolic constant, manifest value, functions, operators, and procedures.
 * 2.5.2.
 * Meta-Model Basis for Expressions Language
 * The BMM provides a system of meta-types that act as the basis for a typed expression language.
 * These include references to static entities in scope (constants, variables, properties), literal values, construction of agents (lambda terms), and function calls (lambda applications).
 * 2.5.3.
 * Information Model Representation
 * Until version 3.0.0, BMM supported only the information point of view, i.e.
 * no computational interface, and in that form, it is often used to express models of data.
 * Tools based on BMM can provide views of an object model expressed in BMM that are particularly useful to information modelling, such as the 'closure' view show below.
 * This is a computed reachability graph of a fully inheritance-flattened class and all properties, including recursive references.
 * Figure 1.
 * BMM class - closure view
 * 2.5.4.
 * Archetype Modelling
 * One of the uses of the BMM in the openEHR ADL Workbench and other similar tools is to provide a computable form of the information model for use with domain-level content models, such as archetypes.
 * The following shows an archetype for which each node has its class shown (in colour), and additionally, the inclusion of non-archetyped attributes from the classes of the archetype nodes.
 * Figure 2.
 * ADL archetype with BMM class properties Newer tools are able to include the computational features.
 * The openEHR project makes extensive use of BMM for representing its models for use in tools.
 * The full set of openEHR models in BMM format may be found in the specfications-ITS-BMM repository on Github.
 * 2.6.
 * Specification Structure
 * This specification defines a BMM object model, i.e.
 * the in-memory object structure of a BMM.
 * The related BMM Persistence specification defines an object model for a serialised schema form.
 * The latter enables serialisation of a BMM into a concrete syntax such as ODIN, JSON or XML.The BMM packages are as follows:Related packages are:These are illustrated below.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 3.
 * Package Overview
 * 2.7.
 * Class Definitions
 * 
 * 2.7.1.
 * BMM_DEFINITIONS Class
 * 
 * 
*/
bmm/overviewfalsefalseBmmDefinitionsBmmDefinitionsBMM_DEFINITIONSDefinitions used by all BMM packages.BasicDefinitionsBASIC_DEFINITIONS1..1Bmm_internal_version: StringCurrent internal version of BMM meta-model, used to determine if a given schema can be processed by a given implementation of the model.1..1Schema_name_delimiter: String = "::"Delimiter used to separate schema id from package path in a fully qualified path.1..1Package_name_delimiter: String = "."Delimiter used to separate package names in a package path.1..1Bmm_schema_file_extension: String = ".bmm"Extension used for BMM files.1..1Type_delimiter: Character = ':'Appears between a name and a type in a declaration or type signature.1..1Generic_left_delimiter: Character = '<'Left delimiter for generic class and generic type names, as used in List<T>.1..1Generic_right_delimiter: Character = '>'Right delimiter for generic class and generic type names, as used in List<T>.1..1Generic_separator: Character = ','Separator used in Generic types.1..1Generic_constraint_delimiter: Character = ':'Delimiter between formal type parameter and constraint type, as used in Sortable<T: Ordered>.1..1Tuple_left_delim: Character = '['Left delimiter of a Tuple type and also instance. Example: [Integer, String] - a tuple type; [3, "Quixote"] - a tuple.1..1Tuple_right_delim: Character = ']'Right delimiter of a Tuple type and also instance.1..1Tuple_separator: Character = ','Separator used in Tuple types and instances.1..1Constraint_left_delim: Character = '«'Left delimiter used in serial form of instance constrained enumeration.1..1Constraint_right_delim: Character = '»'Right delimiter used in serial form of instance constrained enumeration.1..1Metadata_bmm_version: String = "bmm_version"Attribute name of logical attribute 'bmm_version' in .bmm schema file.1..1Metadata_schema_name: String = "schema_name"Attribute name of logical attribute 'schema_name' in .bmm schema file.1..1Metadata_rm_publisher: String = "rm_publisher"Attribute name of logical attribute 'rm_publisher' in .bmm schema file.1..1Metadata_rm_release: String = "rm_release"Attribute name of logical attribute 'rm_release' in .bmm schema file.1..1Metadata_schema_revision: String = "schema_revision"Attribute name of logical attribute 'schema_revision' in .bmm schema file.1..1Metadata_schema_lifecycle_state: String = "schema_lifecycle_state"Attribute name of logical attribute 'schema_lifecycle_state' in .bmm schema file.1..1Metadata_schema_description: String = "schema_description"Attribute name of logical attribute 'schema_description' in .bmm schema file.1..1Metadata_schema_path: String = "schema_path"Path of schema file.1..1Any_class (): BMM_SIMPLE_CLASSbuilt-in class definition corresponding to the top `Any' class.1..1Any_type (): BMM_SIMPLE_TYPEBuilt-in type definition corresponding to the top `Any' type.1..1create_schema_id ( a_model_publisher, a_schema_name, a_model_release: String[1] ): StringCreate schema id, formed from: a_model_publisher '-' a_schema_name '-' a_model_release e.g. openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.package bmm/model_access_package;
/**
 * 
 * 
 * 3.
 * Model Access Package
 * 3.1.
 * Overview
 * The org.openehr.lang.bmm.model_access package provides an interface for the application to load BMM schemas and convert them to BMM model form, and is shown below.
 * In this model, a schema is the serial form of a model or part of a model (i.e.
 * instances of a persistence model like the lang.bmm_persistence model P_XXX classes).
 * One or more schema files are parsed, validated and then converted to create a single BMM_MODEL instance.More than one format for representing serialised BMM models is possible, each having its load, validation and error-reporting logic.
 * The common elements of the load, validate and convert logic are defined by the non format-specific classes in the package, with specific forms of the classes BMM_SCHEMA_DESCRIPTOR and BMM_SCHEMA required for each concrete format.
 * The package above shows the relevant classes for the P_BMM version 2.x format, which is normally saved in .bmm files.
 * Other formats may be saved in files with different extensions.The singleton class BMM_MODEL_ACCESS acts as the entry point for client software to obtain access to loaded BMM models.
 * Since the latter start as schema files which are typically nested according to an 'include' hierarchy, they must be parsed, validated and merged to create each 'top-level' model.
 * The schemas are accessed via instances of the BMM_SCHEMA_DESCRIPTOR object, one for each schema file.
 * The load() routine of this class loads a BMM schema file by direct deserialisation.If the file is structurally correct (say ODIN, JSON etc), an in-memory schema instance will result (e.g.
 * P_BMM_SCHEMA in the case of the P_BMM format), and its validate_created method called.
 * If this succeeds, BMM_SCHEMA_DESCRIPTOR.bmm_schema will be set to this instance, of type BMM_SCHEMA.
 * Subsequently, BMM_SCHEMA.merge() will be called repeatedly, which results in each bmm_schema instance being the merged result of its include children and itself.
 * After merging, BMM_SCHEMA_DESCRIPTOR.validate_merged() will be called, and if successful, a call to create_model() will result in BMM_SCHEMA_DESCRIPTOR.model being populated.Each successfully loaded model is thus instantiated as a BMM_MODEL, and retrievable by calling BMM_MODEL_ACCESS.bmm_model() with a model key, which is a model identifier with full, partial or no version part.
 * In the latter cases, the most recent version model is retrieved for the key.
 * For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.
 * This is convenient for matching models to artefacts (e.g.
 * archetypes) that only mention the model publisher and name, but no version.The following screenshot shows the BMM schema configuration dialog in the openEHR ADL Workbench, including some meta-data, validation status etc, and also the schema nesting structure.
 * A single hierarchy of schemas corresponds to a single instantiated BMM model.The screenshot below shows a number of merged BMM models loaded into the AWB, including some of the packages and classes for the openehr_ehr_extract_1.0.4 model.
 * 
 * 
 * 
 * 
 * 
 * Figure 4.
 * lang.bmm.model_access Package
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 5.
 * BMM schema configuration
 * 
 * 
 * 
 * Figure 6.
 * BMM schemas loaded
 * 3.2.
 * Class Definitions
 * 
 * 3.2.1.
 * BMM_MODEL_ACCESS Class
 * 
 * 3.2.2.
 * BMM_SCHEMA_DESCRIPTOR Class
 * 
 * 3.2.3.
 * BMM_MODEL_METADATA Class
 * 
 * 3.2.4.
 * BMM_SCHEMA Class
 * 
 * 3.2.5.
 * BMM_SCHEMA_STATE Enumeration
 * 
 * 3.2.6.
 * BMM_INCLUDE_SPEC Class
 * 
 * 
*/
bmm/model_access_packagefalsefalseBmmModelAccessBmmModelAccessBMM_MODEL_ACCESSAccess to BMM models that have been loaded and validated from one or more schema sets.0..1schema_directories: List<String>List of directories where all the schemas loaded here are found.0..1all_schemas: Hash<String,BMM_SCHEMA_DESCRIPTOR>All schemas found and loaded from schema_directory. Keyed by schema_id.0..1bmm_models: Hash<String,BMM_MODEL>Top-level (root) models in use, keyed by model_id.0..1matching_bmm_models: Hash<String,BMM_MODEL>Validated models, keyed by model_id() and any shorter forms of id, with some or no versioning information. For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.0..1initialise_with_load_list ( a_schema_dirs: List<String>[1], a_schema_load_list: List<String>[0..1] )Initialise with a specific schema load list, usually a sub-set of schemas that will be found in a specified directories a_schema_dirs.0..1initialise_all ( a_schema_dirs: List<String>[1] )Load all schemas found in a specified directories a_schema_dirs.reload_schemasReload BMM schemas.1..1bmm_model ( a_model_key: String[1] ): BMM_MODELReturn model containing the model key which is a model_id or any shorter form e.g. model id minus the version. If a shorter key is used, the BMM_MODEL with the most recent version will be selected. Uses matching_bmm_models table to find matches if partial version information is supplied in key.1..1has_bmm_model ( a_model_key: String[1] ): BooleanTrue if a model for a model_key is available. A model key is a model_id or any shorter form e.g. model id minus the version. If a shorter key is used, the Result s True if a BMM_MODEL with any version exists.truefalseBmmSchemaDescriptorBmmSchemaDescriptorBMM_SCHEMA_DESCRIPTOR (abstract)Descriptor for a BMM schema. Contains a meta-data table of attributes obtained from a mini-ODIN parse of the schema file.0..1bmm_schema: BMM_SCHEMAPersistent form of model.0..1bmm_model: BMM_MODELComputable form of model.1..1schema_id: StringSchema id, formed by {BMM_DEFINITIONS}.create_schema_id( meta_data.item({BMM_DEFINITIONS}.Metadata_model_publisher), meta_data.item({BMM_DEFINITIONS}.Metadata_schema_name), meta_data.item({BMM_DEFINITIONS}.Metadata_model_release) e.g. openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.1..1meta_data: Hash<String, String>Table of {key, value} of schema meta-data, keys are string values defined by {BMM_DEFINITIONS}.Metadata_* constants.0..1includes: List<String>Identifiers of schemas included by this schema.1..1is_top_level (): BooleanTrue if this is a top-level schema, i.e. not included by some other schema.1..1is_bmm_compatible (): BooleanTrue if the BMM version found in the schema (or assumed, if none) is compatible with that in this software.loadLoad schema into in-memory form, i.e. a P_BMM_SCHEMA instance, if structurally valid. If successful, p_schema will be set.validate_mergedValidate loaded schema and report errors.0..1validate_includes ( all_schemas_list: List<String>[0..1] )Validate includes list for this schema, to see if each mentioned schema exists in all_schemas list.create_modelCreate schema, i.e. the BMM_MODEL from one P_BMM_SCHEMA schema.falsefalseBmmModelMetadataBmmModelMetadataBMM_MODEL_METADATACore properties of BMM_MODEL, may be used in a serial representation as well, such as P_BMM_SCHEMA.1..1rm_publisher: StringPublisher of model expressed in the schema.1..1rm_release: StringRelease of model expressed in the schema as a 3-part numeric, e.g. "3.1.0" .truefalseBmmSchemaBmmSchemaBMM_SCHEMA (abstract)Abstract parent of any persistable form of a BMM model, e.g. P_BMM_SCHEMA.BmmModelMetadataBMM_MODEL_METADATA1..1bmm_version: StringVersion of BMM model, enabling schema evolution reasoning. Persisted attribute.0..1includes: Hash<String,BMM_INCLUDE_SPEC>Inclusion list of any form of BMM model, in the form of a hash of individual include specifications, each of which at least specifies the id of another schema, and may specify a namespace via which types from the included schemas are known in this schema. Persisted attribute.0..1bmm_model: BMM_MODELGenerated by create_bmm_model from persisted elements.1..1state: BMM_SCHEMA_STATECurrent processing state.0..1model_name: StringName of this model, if this schema is a model root point. Not set for sub-schemas that are not considered models on their own.1..1schema_name: StringName of model expressed in schema; a 'schema' usually contains all of the packages of one 'model' of a publisher. A publisher with more than one model can have multiple schemas.1..1schema_revision: StringRevision of schema.1..1schema_lifecycle_state: StringSchema development lifecycle state.1..1schema_author: StringPrimary author of schema.1..1schema_description: StringDescription of schema.0..1schema_contributors: List<String>Contributing authors of schema.0..1 (abstract)validate_created Pre_state: state = State_created Post_state: passed implies state = State_validated_createdDo some basic validation post initial creation check that package structure is regular: only top-level packages can have qualified names no top-level package name can be a direct parent or child of another (child package must be declared under the parent) check that all classes are mentioned in the package structure check that all models refer to valid packages0..1 (abstract)load_finalise Pre_state: state = State_validated_created Post_state: state = State_includes_processed or state = State_includes_pendingFinalisation work: convert packages to canonical form, i.e. full hierarchy with no packages with names like aa.bb.cc set up include processing list0..1 (abstract)merge ( other: BMM_SCHEMA[1] ) Pre_state: state = State_includes_pending Pre_other_valid: includes_to_process.has (included_schema.schema_id)Merge in class and package definitions from other, except where the current schema already has a definition for the given type or package.validateMain validation prior to generation of bmm_model.0..1 (abstract)create_bmm_model Pre_state: state = P_BMM_PACKAGE_STATE.State_includes_processedPopulate bmm_model from schema.1..1read_to_validate (): Boolean Post_state: state = State_includes_processedTrue when validation may be commenced.1..1schema_id (): StringIdentifier of this schema, used for stating inclusions and identifying files. Formed as: {BMM_DEFINITIONS}.create_schema_id ( rm_publisher, schema_name, rm_release) E.g. "openehr_rm_ehr_1.0.4".falsetrueBmmSchemaStateBmmSchemaStateBMM_SCHEMA_STATEEnumeration of processing states of a BMM_SCHEMA used by creation and validation routines in BMM_SCHEMA.State_createdInitial state directly after instantiation of schema.State_validated_createdInitial validation pass after instantiation.State_includes_pendingState of schema processing if there are still included schemas to process.State_includes_processedState when all included schemas have been processed.falsefalseBmmIncludeSpecBmmIncludeSpecBMM_INCLUDE_SPECSchema inclusion structure.1..1id: StringFull identifier of the included schema, e.g. "openehr_primitive_types_1.0.2".package bmm/model_structure;
/**
 * 
 * 
 * 4.
 * Model Structure
 * 4.1.
 * Overview
 * The core package defines the main BMM meta-model, within which the model sub-package defines the top-level structure of a model which is an instance of the BMM.
 * The UML for this package is shown below.
 * 
 * 
 * 
 * Figure 7.
 * base.bmm.core.model Package - Model structure
 * 4.2.
 * Naming Convention
 * In a BMM model, names typically appear in the common case-sensitive form used by the model users, and may therefore follow one of a number of common conventions, including 'camel case', 'snake-case' and so on.
 * When used computationally within an instantiated BMM model, it is assumed that case-insensitive matching is used.
 * This means that the class name "Hashable" refers to the same class as "HASHABLE".
 * Note however that underscores are not removed during matching, so that the classes "HashMap" and "HASH_MAP" are understood as different classes.
 * 
 * 
 * 
 * 
 * 4.3.
 * Model Semantics
 * In BMM, a model is understood as a set of package and module definitions that are developed and maintained as a unit, by some organisation, and usually having an associated hierarchical namespace.
 * The abstract BMM_MODULE class is the ancestor for any kind of module, which is understood as a container for features of various kinds, including the usual properties, routines, and so on.
 * A BMM model is structured in the same general way as a UML model, i.e.
 * with a hierarchical package containment structure and a set of module definitions, where a commonly used type of module is the class.
 * The following illustrates the structure of a typical 'class' or 'object' model.The BMM_MODEL class defines the single instance of each distinct BMM model that may exist within a collection of models, such as shown in the model_access package above.
 * It provides an interface that enables any class definition to be retrieved, as well as various accessor functions to interrogate the model.
 * A BMM Model has a name (the inherited name attribute) that is used to identify the model as a whole within a system using multiple models.
 * It contains a number of other meta-data attributes describing authorship etc, and otherwise contains a list of package and class definitions.
 * 
 * 
 * 
 * Figure 8.
 * BMM model structure
 * 
 * 
 * 4.3.1.
 * Packages
 * In BMM, packages have the same role as in UML - as non-semantic organisational logical containers of classes, usually corresponding to file system folders in software implementations.
 * They provide an organisational convenience, and in an instantiated BMM model, contain references to class definitions.
 * A model validity checker ensures that every class is contained within exactly one package.
 * Package paths are only used in BMM to specify package structures in the serialised form in an efficient way, i.e.
 * by using paths to avoid defining a hierarchy in which only lower packages contain classes.
 * They are not used as namespaces as in UML.
 * Consequently, all classes in a BMM model should be uniquely named.
 * 4.3.2.
 * Use of other Models
 * A model may use another model.
 * This is the same kind of relationship denoted by the 'import' keyword in many programming languages.
 * In BMM, the use of other models is declared once only, in the using model, rather than on a per-class level as in some languages (e.g.
 * Java).
 * The use of another model makes its contents available for use in declarations (e.g.
 * inheritance) and expressions within the using model.
 * This is achieved by populating the BMM_CLASS.scope attribute with a reference to the used model.
 * In a serial form, a typical syntax such as other_model_name::Class would be used.
 * 4.3.3.
 * Documentation
 * A documentation attribute is inherited from BMM_DECLARATION into BMM_CLASS, BMM_PROPERTY, BMM_MODEL and BMM_PACKAGE (the latter two via BMM_PACKAGE_CONTAINER), enabling packages, classes and properties to be individually documented using a keyed table (i.e.
 * Hash) of values.
 * It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.
 * 4.3.4.
 * Other Meta-data
 * The BMM_DECLARATION meta-class also defines the attribute extensions of type Hash<String, Any>, to enable representation of meta-data of any type on any model node.
 * This provides a means of extending BMM.
 * 4.4.
 * The Any Class and Type
 * While a BMM model defines a model in terms of class declarations, it must always have a top class named Any from which all others inherit.
 * Similar to the root class in a typical OOPL type systems (sometimes called 'Object'), the Any class defines semantics true for all objects such as equality (i.e.
 * semantics for an '=' operator) and copying.A BMM model may define its own Any class, but if it does not, the BMM_MODEL instance representing the model will produce a standard 'Any' class via the any_class_definition() method.
 * This will create the following structure, including a default package structure, and an Any type.The Any type defined by the model’s Any class, or else the default one above, will be used as the inheritance parent for every class in the model that doesn’t have any other inheritance parent.
 * As a result, the inheritance graph will always have the Any type as its top node.
 * 
 * 
 * 
 * 
 * 
 * Figure 9.
 * Default Any class
 * 
 * 
 * 4.5.
 * Class Definitions
 * 
 * 4.5.1.
 * BMM_DECLARATION Class
 * 
 * 4.5.2.
 * BMM_PACKAGE_CONTAINER Class
 * 
 * 4.5.3.
 * BMM_PACKAGE Class
 * 
 * 4.5.4.
 * BMM_MODEL Class
 * 
 * 4.5.5.
 * BMM_MODULE Class
 * 
 * 
*/
bmm/model_structuretruefalseBmmDeclarationBmmDeclarationBMM_DECLARATION (abstract)Meta-type of BMM declared model elements. A declaration is a an element of a model specified by an author within a model definition within a context, which defines the scope of the element. Thus, a class definition and its property and routine definitions are model elements, but Types are not, since they are derived from model elements.1..1name: StringName of this model element.0..1documentation: Hash<String, Any>Optional documentation of this element, as a keyed list. It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.1..1scope: BMM_DECLARATIONModel element within which an element is declared.0..1extensions: Hash<String, Any>Optional meta-data of this element, as a keyed list. May be used to extend the meta-model.1..1is_root_scope (): Boolean Post_result: Result = (scope = self)True if this declaration entity is the root of the declaration hierarchy.truefalseBmmPackageContainerBmmPackageContainerBMM_PACKAGE_CONTAINER (abstract)A BMM model component that contains packages and classes.BmmDeclarationBMM_DECLARATION0..1packages: Hash<String,BMM_PACKAGE>Child packages; keys all in upper case for guaranteed matching.1..1 (redefined)scope: BMM_PACKAGE_CONTAINERModel element within which a referenceable element is known.0..1package_at_path ( a_path: String[1] ): BMM_PACKAGEPackage at the path a_path.0..1do_recursive_packages ( action: EL_PROCEDURE_AGENT[1] )Recursively execute action, which is a procedure taking a BMM_PACKAGE argument, on all members of packages.1..1has_package_path ( a_path: String[1] ): BooleanTrue if there is a package at the path a_path; paths are delimited with delimiter {BMM_DEFINITIONS}_Package_name_delimiter_.falsefalseBmmPackageBmmPackageBMM_PACKAGEAbstraction of a package as a tree structure whose nodes can contain other packages and classes. The name may be qualified if it is a top-level package.BmmPackageContainerBMM_PACKAGE_CONTAINER0..1classes: List<BMM_CLASS>Classes listed as being in this package.0..1root_classes (): List<BMM_CLASS>Obtain the set of top-level classes in this package, either from this package itself or by recursing into the structure until classes are obtained from child packages. Recurse into each child only far enough to find the first level of classes.1..1path (): StringFull path of this package back to root package.falsefalseBmmModelBmmModelBMM_MODELDefinition of the root of a BMM model (along with what is inherited from BMM_SCHEMA_CORE).BmmPackageContainerBMM_PACKAGE_CONTAINERBmmModelMetadataBMM_MODEL_METADATA0..1class_definitions: Hash<String,BMM_CLASS>All classes in this model, keyed by type name.0..1used_models: List<BMM_MODEL>List of other models 'used' (i.e. 'imported' by this model). Classes in the current model may refer to classes in a used model by specifying the other class’s scope meta-attribute.1..1model_id (): StringIdentifier of this model, lower-case, formed from: <rm_publisher>_<model_name>_<rm_release> E.g. "openehr_ehr_1.0.4".1..1class_definition ( a_name: String[1] ): BMM_CLASSRetrieve the class definition corresponding to a_type_name (which may contain a generic part).1..1type_definition (): BMM_CLASSRetrieve the class definition corresponding to a_type_name. If it contains a generic part, this will be removed if it is a fully open generic name, otherwise it will remain intact, i.e. if it is an effective generic name that identifies a BMM_GENERIC_CLASS_EFFECTIVE.1..1has_class_definition ( a_class_name: String[1] ): BooleanTrue if a_class_name has a class definition in the model.1..1has_type_definition ( a_type_name: String[1] ): BooleanTrue if a_type_name is already concretely known in the system, including if it is generic, which may be open, partially open or closed.1..1enumeration_definition ( a_name: String[1] ): BMM_ENUMERATIONRetrieve the enumeration definition corresponding to a_type_name.0..1primitive_types (): List<String>List of keys in class_definitions of items marked as primitive types.0..1enumeration_types (): List<String>List of keys in class_definitions of items that are enumeration types.1..1property_definition (): BMM_PROPERTYRetrieve the property definition for a_prop_name in flattened class corresponding to a_type_name.1..1ms_conformant_property_type ( a_bmm_type_name: String[1], a_bmm_property_name: String[1], a_ms_property_name: String[1] ): BooleanTrue if a_ms_property_type is a valid 'MS' dynamic type for a_property in BMM type a_bmm_type_name. 'MS' conformance means 'model-semantic' conformance, which abstracts away container types like List<>, Set<> etc and compares the dynamic type with the relation target type in the UML sense, i.e. regardless of whether there is single or multiple containment.1..1property_definition_at_path (): BMM_PROPERTYRetrieve the property definition for a_property_path in flattened class corresponding to a_type_name.1..1class_definition_at_path ( a_type_name: String[1], a_prop_path: String[1] ): BMM_CLASSRetrieve the class definition for the class that owns the terminal attribute in a_prop_path in flattened class corresponding to a_type_name.0..1all_ancestor_classes ( a_class: String[1] ): List<String>Return all ancestor types of a_class_name up to root class (usually Any, Object or something similar). Does not include current class. Returns empty list if none.1..1is_descendant_of ( a_class_name: String[1], a_parent_class_name: String[1] ): BooleanTrue if a_class_name is a descendant in the model of a_parent_class_name.1..1type_conforms_to ( a_desc_type: String[1], an_anc_type: String[1] ): BooleanCheck conformance of a_desc_type to an_anc_type; the types may be generic, and may contain open generic parameters like 'T' etc. These are replaced with their appropriate constrainer types, or Any during the conformance testing process. Conformance is found if: [base class test] types are non-generic, and either type names are identical, or else a_desc_type has an_anc_type in its ancestors; both types are generic and pass base class test; number of generic params matches, and each generic parameter type, after 'open parameter' substitution, recursively passes; type_name_conforms_to test descendant type is generic and ancestor type is not, and they pass base classes test.1..1subtypes ( a_type: String[1] ): List<String>Generate type substitutions for the supplied type, which may be simple, generic (closed, open or partially open), or a container type. In the generic and container cases, the result is the permutation of the base class type and type substitutions of all generic parameters. Parameters a_type Name of a type.1..1any_class_definition (): BMM_SIMPLE_CLASSBMM_SIMPLE_CLASS instance for the Any class. This may be defined in the BMM schema, but if not, use BMM_DEFINITIONS.any_class.1..1any_type_definition (): BMM_SIMPLE_TYPEBMM_SIMPLE_TYPE instance for the Any type.1..1boolean_type_definition (): BMM_SIMPLE_TYPEBMM_SIMPLE_TYPE instance for the Boolean type.truefalseBmmModuleBmmModuleBMM_MODULE (abstract)Meta-type defining a generalised module concept. Descendants define actual structure and contents.BmmDeclarationBMM_DECLARATION1..1 (redefined)scope: BMM_MODELModel within which module is defined.package bmm/types;
/**
 * 
 * 
 * 5.
 * Types
 * 5.1.
 * Overview
 * One of the foundational distinctions in the BMM is between class and type, in common with the type systems of the modern forms of most object-oriented languages, but in contrast to the UML meta-model.
 * This division is reflected in the two top-level meta-classes BMM_CLASS and BMM_TYPE, and their respective descendants, as shown in the following UML diagram.Classes are definitional entities, while types are understood in BMM as the formal generators of instances (where non-abstract), as the basis of static typing in a formal model, and dynamic conformance, i.e.
 * at execution time, when polymorphic attachment is possible.
 * Most types are specified via the definitions of classes and their constituent parts.
 * Types are used for the following purposes in a BMM model:A simple example of typing of properties is shown in the instance diagram below.Most types are based on one or more defining class(es), which provide the formal definition for the type.
 * The exceptions are formal generic parameters (e.g.
 * the T in List<T>) and the special types for tuples and routine signatures, which are treated as built-in.
 * The BMM meta-type BMM_TYPE and its descendants define the kinds of types available in a BMM model.
 * The design of the types part of the BMM is based on a taxonomy that makes various distinctions convenient to a formalism intended for modelling rather than pure programming.
 * This leads in particular to the top-level distinction between unitary and container meta-types.
 * The taxonomy is illustrated below, including differentiae.BMM_TYPE includes features common to all meta-types:Below BMM_TYPE are the abstract meta-type BMM_UNITARY_TYPE and the concrete meta-type BMM_CONTAINER_TYPE and its specialisation BMM_INDEXED_CONTAINER_TYPE.
 * BMM_UNITARY_TYPE is a meta-type for types whose instances are unitary i.e.
 * singular, while the container meta-types correspond to collections of instances.
 * The latter are further described below.
 * This distinction is made to enable BMM to directly represent the notion of collections in the type system rather than treating them in the same way as any other type, which would force modellers (i.e.
 * authors of actual BMM models) to state concrete containment types such as ArrayedList<Packet>, where ArrayedList would have to be defined in the model as well as Packet.Unitary meta-types are further distinguished as formal generic parameters (BMM_PARAMETER TYPE) and effective types, i.e.
 * concrete unitary types.
 * The former meta-type is used to represent replaceable formal generic parameters (typically 'T', 'U' within types such as List<T> etc) within generic type declarations.Effective types have as their meta-type BMM_EFFECTIVE_TYPE.
 * Its subtypes are BMM_MODEL_TYPE, a meta-type for types defined by classes in the model (thus characterised by the property base_class: BMM_CLASS), BMM_TUPLE_TYPE, a meta-type for tuples (a list of objects of varying types), and BMM_SIGNATURE, a meta-type representing signatures of routines and typed model elements (properties, variables etc).BMM_MODEL_TYPE divides into BMM_SIMPLE_TYPE and BMM_GENERIC_TYPE, corresponding to the standard notions of types familiar in modern programming languages.
 * The class definitions of instances (i.e.
 * BMM model class definitions) of these meta-types are available via the property base_class, of meta-type BMM_CLASS for a BMM simple type, and BMM_GENERIC_CLASS for BMM generic type.These various concrete meta-types are described in more detail below.
 * 
 * 
 * 
 * Figure 10.
 * base.bmm.core.entity Package - Types
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 11.
 * BMM Typing
 * 
 * 
 * 
 * Figure 12.
 * BMM meta-type taxonomy
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 5.2.
 * Simple Type
 * A simple type is a type based only on a simple class, which is a class with no formal generic parameters.
 * An instance of a simple type is fully described by the class on which it is based, with the only difference being the usual object-oriented possibility of polymorphic attachments of sub-objects whose dynamic types conform to their static type counterparts in the original simple type.
 * Thus, for example, a class Organisation may have a property manager of static type Employee.
 * An instance of the simple type Organisation might have its manager property attached to an instance of Manager, which is legal as long as Manager conforms to Employee, which it will do if Manager is defined as a subtype of Employee.
 * 
 * 
 * 5.2.1.
 * Conformance
 * Conformance of Simple types follows the inheritance hierarchy via which they are defined, according to the rules: meta-rule: A Simple type can only conform to a Model type, i.e.
 * either another Simple type or a Generic type; concrete rule: A Simple type A conforms to Simple type B iff for base_class of A, all_ancestors() contains B.
 * 5.3.
 * Generic Type
 * A generic type is a type based on a generic class, which has one or more formal type parameters that are substituted by actual types in its declaration.
 * For example, the generic type Interval<Quantity> can be used in a model that contains the generic class Interval<T:Ordered> and Quantity.
 * The general case is that the generic parameter substitution type (BMM_GENERIC_TYPE.generic_parameters) for any formal parameter (BMM_GENERIC_CLASS.generic_parameters) is of meta-type BMM_UNITARY_TYPE.A typical programmatic usage of such a type, and its instantiated BMM model structure is shown below.The parameters of a generic type may be:Consequently, a generic type may be:The first case is detected via the function is_closed defined on BMM_GENERIC_TYPE, while the function is_partially_closed distinguishes the latter two cases.The following shows the BMM instance structure of a generic type that is open.Since the meta-type of BMM_GENERIC_TYPE.generic_parameters in the BMM is BMM_UNITARY_TYPE, constructions such as MyGenericType<List<OtherType>> are prevented, due to the concrete parameter type List<OtherType> being an instance of BMM_CONTAINER_TYPE rather than of BMM_UNITARY_TYPE.
 * Such constructions are nearly always wrong, and not needed in a model expressed in BMM, because containment can be expressed where the formal generic parameter is used, not where the concrete parameter is declared.
 * The following diagram shows the BMM concrete model structure created for a generic type whose formal parameter type is used in this way, i.e.
 * within a container type.
 * 
 * 
 * 
 * 
 * 
 * Figure 13.
 * Generic type - closed simple
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 14.
 * Generic type - open
 * 
 * 
 * 
 * Figure 15.
 * Generic type - closed container
 * 5.3.1.
 * Conformance
 * Conformance of Generic types is according to the rules: meta-rule: A Generic type can only conform to another Generic type; concrete rules: A Generic type Ga<Tai, …​> conforms to Generic type Gb<Tbi, …​> iff: for base_class of Ga, all_ancestors() contains Gb; and the number of generic parameters is equal; for each Tai, either Tbi is an open formal parameter, and Tai conforms to any generic constraint type, or; Tai conforms to Tbi.
 * 5.4.
 * Tuple Meta-type
 * The meta-type BMM_TUPLE_TYPE enables the type of a tuple i.e.
 * an array of objects each of which may be of any type, to be stated in terms of other types.
 * This is mostly used to state the type of a set of arguments in the BMM_SIGNATURE class, but standalone tuple types may also be used in a model, providing roughly the effect of an anonymous class (or a struct in C/C++).The notional type Tuple defined by BMM_TUPLE_TYPE is treadted as a BMM built-in, and is therefore not stated in any BMM model.
 * 
 * 
 * 5.4.1.
 * Conformance
 * Conformance of Tuple types is according to the rules: meta-rule: A Tuple type can only conform to another Tuple type; concrete rules: A Tuple type Tuple[Tai, …​] conforms to Tuple type Tuple[Tbi, …​] iff: for each Tai, Tai conforms to Tbi.
 * 5.5.
 * Signature Meta-type
 * Within any typed formalism, any entity declared as having a type also has a signature.
 * In BMM, this is is the case for any kind of feature of a class, including constants, properties, and routines.
 * The signature of a feature is a formal construct capturing the type structure of the feature.
 * The simplest type of signature is that of properties and constants, which may be expressed formally in a typical abstract syntax as follows:This indicates that both have a return type, being the type of the value they are attached to at execution time.The general form of routine signatures is as follows:In the above, the construction [Type, …​] represents a type-tuple.Typical examples of function signatures are as follows:Typical procedure signatures include the following:In order to support functional semantics such as function-as-object, the notion of signature must exist as a first order type.
 * Since signatures have a special structure and usage, they have their own meta-type in BMM, BMM_SIGNATURE.
 * Instances of this meta-type represent any kind of signature, and consist of argument_types, whose meta-type is BMM_TUPLE_TYPE (See [Tuple Type]), and result_type, representing the result type.The following signatures state the types 'any function' and 'any procedure':As for the Tuple meta-type, the notional Signature meta-type is a BMM built-in, and is not itself defined in any BMM model.
 * 
 * 
 * 
 * T_result
 * 
 * 
 * 
 * 
 * 
 * <[T_arg1, T_arg2, ...], T_result> -- Function type <[T_arg1, T_arg2, ...]> -- Procedure type
 * 
 * 
 * 
 * 
 * 
 * <[], Date> -- a 0-order function like current_date <[Real, Real], Real> -- a 2nd-order function like '*' for the domain R <[Integer, Integer], Integer> -- a 2nd-order function like 'add' for the domain I
 * 
 * 
 * 
 * <[]> -- a 0-order (argumentless) procedure <[Real]> -- a 1st-order procedure for the domain R <[String, Integer]> -- a procedure taking a String and an Integer argument
 * 
 * 
 * 
 * 
 * 
 * Function -- any function Procedure -- any procedure
 * 
 * 
 * 5.5.1.
 * Conformance
 * Conformance of Signature types is as follows: meta-rule: A Signature type can only conform to another Signature type; concrete rules: all specific Function signatures conform to the signature Function); all specific Procedure signatures conform to the signature Procedure; the conformance of specific Function or Procedure signatures to another Function or Procedure signature is such that: the number of argument types accord and; the type conformance of each corresponding argument and result type (for functions) follows the rules for conformance given by the meta-types of those types.
 * 5.6.
 * Container Meta-types
 * In object-oriented type theory, 'container' types are generic types whose outer class happens to have the semantics of a container object, such as a list, set etc.
 * Container types such as List<T>, Set<T> and Hash<K,V> are used ubiquitously in object models.
 * In the BMM, containers and non-container generic types are distinguished via the meta-classes BMM_CONTAINER_TYPE and BMM_GENERIC_TYPE respectively.
 * This allows the BMM to treat container types in a special way.
 * A BMM_CONTAINER_TYPE can be thought of as a 1:N counterpart to a BMM_UNITARY_TYPE, such as the type List<Paragraph> with respect to Paragraph.
 * BMM_GENERIC_TYPE is thus used for objects considered to be singular, but whose types are a product of the base class and one or more parameter types, e.g.
 * Interval<Quantity>.The explicit provision of BMM_CONTAINER_TYPE enables BMM models to mention logical linear container types such as List<T> and Set<T>, on the assumption of their standard semantics in computer science , without worrying about providing concrete types which may be numerous and also variable across programming languages, e.g.
 * ArrayedList<T>, LinkedSet<T>, ArrayedStack<T> and so on.List and Set semantics are achieved via the BMM_CONTAINER_TYPE attributes is_ordered and is_unique, used in the standard combinations i.e.:The following diagram shows how the container type List<Paragraph>, declared as the type of an attribute paragraphs in a class Document, is represented in a BMM model.The semantics of indexed containers, commonly known under the type names Hash<K,V>, HashMap<K,V>, HashTable<K,V>, Dictionary<K,V> and so on, are represented by the meta-type BMM_INDEXED_CONTAINER_TYPE, which inherits from BMM_CONTAINER_TYPE, and adds the property index_type.
 * The latter type represents the key type, which must be such that hash values can be generated, and may be any type, but practically speaking, is almost always a String, Integer, or a Date/Time type.The following diagram shows how the container type Hash<String, Person> is represented in a BMM model.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 16.
 * Container Type
 * 
 * 
 * 
 * 
 * 
 * Figure 17.
 * Indexed Container Type
 * 5.6.1.
 * Conformance
 * Conformance of Container types is according to the rules: meta-rule: A Container type can only conform to another Container type; concrete rules: A Container type Ca<Va> conforms to Container type Cb<Vb> conforms to iff: for base_class of Ca, all_ancestors() contains Cb; and Va conforms to Vb.
 * An indexed Container type Ca<Ka, Va> conforms to indexed Container type Gb<Kb, Vb> iff: for base_class of Ca, all_ancestors() contains Cb; Kb conforms to Kb and Va conforms to Vb.
 * 5.7.
 * Type Conformance
 * An algorithm to determine conformance of two type-names (e.g.
 * to implement BMM_MODEL.type_conforms_to()) is as follows:
 * 
 * 
 * 
 * Boolean type_conforms_to (String a_type, anc_type) { BMM_TYPE_NAME a_type_name, anc_type_name; if attached create_type_name_from_string (a_a_type) as a_type_name and attached create_type_name_from_string (anc_type) as anc_type_name { base_class = a_type_name.name; anc_base_class = anc_type_name.name; if (base_class.is_case_insensitive_equal (anc_base_class) or else class_definition (base_class).has_ancestor_class (anc_base_class)) { BMM_CLASS bmm_def_class = class_definition (base_class); // ---- Tuple types // ---- Signature types ---- // ---- Generic types // handle case where formal generic names appear in type name if (valid_generic_type_name (a_type) and bmm_def_class instanceOf (BMM_GENERIC_CLASS) { // in the case of both being generic, we need to compare generics // to start with, the number of generics must match BMM_CLASS anc_bmm_def_class = class_definition (anc_base_class); if (valid_generic_type_name (anc_type) and anc_bmm_def_class instanceOf (BMM_GENERIC_CLASS)) { ArrayedList<String> a_type_gen_params = a_type_name.generic_parameters_type_list; ArrayedList<String> anc_type_gen_params = anc_type_name.generic_parameters_type_list; if (a_type_gen_params.count = anc_type_gen_params.count) { Iterator<String> this_gen_parms_it = a_type_gen_params.iterator(); Iterator<String> other_gen_parms_it = anc_type_gen_params.iterator(); Boolean result = True; String a_type_gen_type, anc_type_gen_type; while (this_gen_parms_it.hasNext() && other_gen_parms_it.hasNext() || !result) { // first we convert any open generic parameters to their conformance types // We assume type names of 1 letter are open parameters String this_gen_parm = this_gen_parms_it.next(); String other_gen_parm = other_gen_parms_it.next(); if (formal_generic_parameter_name (this_gen_parm)) a_type_gen_type = this_bmm_gen_class.generic_parameter_conformance_type (this_gen_parm); else a_type_gen_type = this_gen_parm; if (formal_generic_parameter_name (other_gen_parm)) anc_type_gen_type = other_bmm_gen_class.generic_parameter_conformance_type (other_gen_parm); else anc_type_gen_type = other_gen_parm; -- now do the test result = type_conforms_to (a_type_gen_type, anc_type_gen_type); } return result; } } // Conforms - case where anc type is not provided in generic form, but desc is // e.g.
 * Interval<Integer> conforms to Interval else return True; } // in the following case, the descendant type is not generic, // so the ancestor type cannot be either, for conformance else return not valid_generic_type_name (anc_type); } } }
 * 5.8.
 * Model Theoretic Questions
 * The above model produces a number of outcomes that are not necessarily immediately obvious or expected, including:
 * 
 * 
 * 
 * 
 * 5.9.
 * Class Definitions
 * 
 * 5.9.1.
 * BMM_TYPE Class
 * 
 * 5.9.2.
 * BMM_UNITARY_TYPE Class
 * 
 * 5.9.3.
 * BMM_EFFECTIVE_TYPE Class
 * 
 * 5.9.4.
 * BMM_PARAMETER_TYPE Class
 * 
 * 5.9.5.
 * BMM_MODEL_TYPE Class
 * 
 * 5.9.6.
 * BMM_SIMPLE_TYPE Class
 * 
 * 5.9.7.
 * BMM_GENERIC_TYPE Class
 * 
 * 5.9.8.
 * BMM_TUPLE_TYPE Class
 * 
 * 5.9.9.
 * BMM_SIGNATURE Class
 * 
 * 5.9.10.
 * BMM_CONTAINER_TYPE Class
 * 
 * 5.9.11.
 * BMM_INDEXED_CONTAINER_TYPE Class
 * 
 * 
*/
bmm/typestruefalseBmmTypeBmmTypeBMM_TYPE (abstract)Abstract idea of specifying a type in some context. This is not the same as 'defining' a class. A type specification is essentially a reference of some kind, that defines the type of an attribute, or function result or argument. It may include generic parameters that might or might not be bound. See subtypes.1..1 (abstract)type_name (): StringFormal string form of the type as per UML.1..1type_signature (): StringSignature form of the type name, which for generics includes generic parameter constrainer types E.g. Interval<T:Ordered>. Defaults to the value of type_name().1..1 (abstract)is_abstract (): BooleanIf true, indicates an abstract class in a BMM model, or a type based on an abstract class, i.e. a type that cannot be directly instantiated.1..1 (abstract)is_primitive (): BooleanIf True, indicates that the entity in a BMM model is considered to relate to a primitive type set, i.e. be a primitive type, or be a definer of one.1..1 (abstract)unitary_type (): BMM_UNITARY_TYPEType with any container abstracted away; may be a formal generic type.1..1 (abstract)effective_type (): BMM_EFFECTIVE_TYPEType with any container abstracted away, and any formal parameter replaced by its effective constraint type.1..1 (abstract)flattened_type_list (): List<String>Completely flattened list of type names, flattening out all generic parameters.truefalseBmmUnitaryTypeBmmUnitaryTypeBMM_UNITARY_TYPE (abstract)Parent of meta-types that may be used as the type of any instantiated object that is not a container object.BmmTypeBMM_TYPE1..1 (effected)unitary_type (): BMM_UNITARY_TYPEResult = self.truefalseBmmEffectiveTypeBmmEffectiveTypeBMM_EFFECTIVE_TYPE (abstract)Meta-type for a concrete, unitary type that can be used as an actual parameter type in a generic type declaration.BmmUnitaryTypeBMM_UNITARY_TYPE1..1 (effected)effective_type (): BMM_EFFECTIVE_TYPEResult = self.1..1 (abstract)type_base_name (): StringName of base generator type, i.e. excluding any generic parts if present.falsefalseBmmParameterTypeBmmParameterTypeBMM_PARAMETER_TYPEDefinition of a generic parameter in a class definition of a generic type.BmmUnitaryTypeBMM_UNITARY_TYPE1..1name: StringName of the parameter, e.g. 'T' etc. The name is limited to 1 character and upper-case.0..1type_constraint: BMM_EFFECTIVE_TYPEOptional conformance constraint that must be the name of a defined type.0..1inheritance_precursor: BMM_PARAMETER_TYPEIf set, is the corresponding generic parameter definition in an ancestor class.1..1flattened_conforms_to_type (): BMM_EFFECTIVE_TYPEResult is either conforms_to_type or inheritance_precursor.flattened_conforms_to_type.1..1 (redefined)type_signature (): StringSignature form of the open type, including constrainer type if there is one, e.g. T:Ordered.1..1 (effected)is_primitive (): BooleanResult = False - generic parameters are understood by definition to be non-primitive.1..1 (effected)is_abstract (): BooleanResult = False - generic parameters are understood by definition to be non-abstract.1..1 (effected)type_name (): StringReturn name.1..1 (effected)flattened_type_list (): List<String>Result is either flattened_conforms_to_type.flattened_type_list or the Any type.1..1 (effected)effective_type (): BMM_EFFECTIVE_TYPEGenerate ultimate conformance type, which is either flattened_conforms_to_type or if not set, 'Any'.truefalseBmmModelTypeBmmModelTypeBMM_MODEL_TYPE (abstract)A type that is defined by a class (or classes) in the model.BmmEffectiveTypeBMM_EFFECTIVE_TYPE0..1value_constraint: BMM_VALUE_SET_SPEC1..1base_class: BMM_CLASSBase class of this type.1..1 (effected)type_base_name (): StringResult = base_class.name.1..1 (effected)is_primitive (): BooleanResult = base_class.is_primitive.falsefalseBmmSimpleTypeBmmSimpleTypeBMM_SIMPLE_TYPEType reference to a single type i.e. not generic or container type.BmmModelTypeBMM_MODEL_TYPE1..1 (redefined)base_class: BMM_SIMPLE_CLASSDefining class of this type.1..1 (effected)type_name (): StringResult is base_class.name.1..1 (effected)is_abstract (): BooleanResult is base_class.is_abstract.1..1 (effected)flattened_type_list (): List<String>Result is base_class.name .1..1effective_base_class (): BMM_SIMPLE_CLASSMain design class for this type, from which properties etc can be extracted.falsefalseBmmGenericTypeBmmGenericTypeBMM_GENERIC_TYPEMeta-type based on a non-container generic class, e.g. Packet<Header>.BmmModelTypeBMM_MODEL_TYPE1..1generic_parameters: List<BMM_UNITARY_TYPE>Generic parameters of the root_type in this type specifier. The order must match the order of the owning class’s formal generic parameter declarations, and the types may be defined types or formal parameter types.1..1 (redefined)base_class: BMM_GENERIC_CLASSDefining generic class of this type.1..1 (effected)type_name (): StringReturn the full name of the type including generic parameters, e.g. DV_INTERVAL<T>, TABLE<List<THING>,String>.1..1 (redefined)type_signature (): StringSignature form of the type, which for generics includes generic parameter constrainer types E.g. Interval<T:Ordered>.1..1 (effected)is_abstract (): BooleanTrue if base_class.is_abstract or if any (non-open) parameter type is abstract.1..1 (effected)flattened_type_list (): List<String>Result is base_class.name followed by names of all generic parameter type names, which may be open or closed.1..1is_partially_closed (): BooleanReturns True if there is any substituted generic parameter.1..1effective_base_class (): BMM_GENERIC_CLASSEffective underlying class for this type, abstracting away any container type.1..1is_open (): BooleanTrue if all generic parameters from ancestor generic types have been substituted in this type.falsefalseBmmTupleTypeBmmTupleTypeBMM_TUPLE_TYPESpecial type representing the type of a tuple, i.e. an array of any number of other types. This includes both container and unitary types, since tuple instances represent concrete objects. Note that both open and closed generic parameters are allowed, as with any generic type, but open generic parameters are only valid within the scope of a generic class.BmmEffectiveTypeBMM_EFFECTIVE_TYPE1..1base_name: String = "Tuple"Base name (built-in).1..1item_types: Hash<String,BMM_TYPE>List of types of the items of the tuple, keyed by purpose in the tuple.1..1 (effected)type_base_name (): String Post_result: Result.is_equal (base_name())Return base_name.1..1 (effected)is_primitive (): BooleanResult = True.1..1 (effected)is_abstract (): BooleanResult = False.1..1 (effected)type_name (): String Post_result: Result.is_equal (base_name())Return base_name.1..1 (effected)flattened_type_list (): List<String>Return the logical set (i.e. unique types) from the merge of flattened_type_list() called on each member of item_types.falsefalseBmmSignatureBmmSignatureBMM_SIGNATURENon-entity meta-type that expresses the type structure of any referenceable element of a model. Consists of potential arguments and result, with constraints in descendants determining the exact form.BmmEffectiveTypeBMM_EFFECTIVE_TYPE1..1base_name: String = "Signature"Base name (built-in).0..1argument_types: BMM_TUPLE_TYPEType of arguments in the signature, if any; represented as a type-tuple (list of arbitrary types).0..1result_type: BMM_TYPEResult type of signature, if any.1..1 (effected)type_base_name (): String Post_result: Result.is_equal (base_name())Return base_name.1..1 (effected)is_abstract (): BooleanResult = False.1..1 (effected)is_primitive (): BooleanResult = True.1..1 (effected)type_name (): String Post_result: Result.is_equal (base_name())Return base_name1..1 (effected)flattened_type_list (): List<String>Return the logical set (i.e. unique items) consisting of argument_types.flattened_type_list() and result_type.flattened_type_list().falsefalseBmmContainerTypeBmmContainerTypeBMM_CONTAINER_TYPEMeta-type that specifies linear containers with a generic parameter corresponding to the type of contained item, and whose container type is a generic type such as List<T>, Set<T> etc.BmmTypeBMM_TYPE1..1container_class: BMM_GENERIC_CLASSThe type of the container. This converts to the root_type in BMM_GENERIC_TYPE.1..1item_type: BMM_UNITARY_TYPEThe container item type.0..1is_ordered: Boolean {default = true}True indicates that order of the items in the container attribute is considered significant and must be preserved, e.g. across sessions, serialisation, deserialisation etc. Otherwise known as 'list' semantics.0..1is_unique: Boolean {default = false}True indicates that only unique instances of items in the container are allowed. Otherwise known as 'set' semantics.1..1 (effected)type_name (): StringReturn full type name, e.g. List<ELEMENT>.1..1 (effected)is_abstract (): Boolean Post_is_abstract: Result = container_type.is_abstractTrue if the container class is abstract.1..1 (effected)flattened_type_list (): List<String> Post_result: Result = item_type.flattened_type_listFlattened list of type names of item_type, i.e. item_type.flattened_type_list().1..1 (effected)unitary_type (): BMM_UNITARY_TYPEReturn item_type.1..1 (effected)is_primitive (): Boolean Post_result: Result = item_type.is_primitiveTrue if item_type is primitive.1..1 (effected)effective_type (): BMM_EFFECTIVE_TYPEReturn item_type.effective_type().falsefalseBmmIndexedContainerTypeBmmIndexedContainerTypeBMM_INDEXED_CONTAINER_TYPEMeta-type of linear container type that indexes the contained items in the manner of a standard Hash table, map or dictionary.BmmContainerTypeBMM_CONTAINER_TYPE1..1index_type: BMM_SIMPLE_TYPEType of the element index, typically String or Integer, but may be a numeric type or indeed any type from which a hash value can be derived.1..1 (effected)type_name (): StringReturn full type name, e.g. HashMap<String, ELEMENT>.package bmm/classes;
/**
 * 
 * 
 * 6.
 * Classes
 * 6.1.
 * Overview
 * This section describes the semantics of the BMM_CLASS meta-class, its sub-types, constituent parts and relationships.
 * The parts of a class are collectively known as features, and consist of functions, procedures, constants and properties, which appear in feature groups.
 * The following UML illustrates classes and relationships to constituent feature meta-types.
 * Features are described in detail in the following section.Class definitions are the definitional basis of a BMM model, i.e.
 * they are the means of defining the types that are statically used in the model, and the dynamic types generated at runtime.
 * Types are thus derived entities.The top meta-class BMM_CLASS defines two properties inherent in classes defined in a model, and derived in resulting types: is_abstract and is_primitive.
 * The Boolean attribute is_abstract indicates a class that cannot be directly instantiated.
 * The attribute is_primitive indicates that a class is considered to be part of a primitive type set (typically corresponding to primitive types in another type system).
 * Primitive status has no effect on BMM model semantics, and is provided as a convenience for visualisation and type-system mapping.BMM distinguishes between simple and generic class definitions via two descendants of BMM_CLASS, i.e.
 * BMM_SIMPLE_CLASS and BMM_GENERIC_CLASS, with the first providing a concrete form of BMM_CLASS that applies to non-generic classes, and the latter defining the additional semantics of generic classes.
 * The meta-type BMM_ENUMERATION is a specialisation of BMM_SIMPLE_CLASS used to represent enumeration classes in BMM models.
 * The meta-types are further described below.
 * 
 * 
 * 
 * Figure 18.
 * base.bmm.core Package - Classes
 * 
 * 
 * 
 * 
 * 
 * 
 * 6.2.
 * Simple Classes
 * The simplest type of class definition in a model is an instance of the meta-type BMM_SIMPLE_CLASS, and has a 1:1 relationship with its type.
 * Such classes might be specified in the following abstract syntax:
 * 
 * 
 * 
 * class DvQuantity { feature // feature definitions } class Observation { feature // feature definitions }
 * 6.3.
 * Generic Classes
 * The generic class meta-type BMM_GENERIC_CLASS adds generic parameters to BMM_CLASS, enabling formal generic parameters to be represented.
 * Each such parameter is expressed using an instance of BMM_PARAMETER_TYPE which names the parameter and optionally allows a type constraint to be associated with it, in the usual object-oriented fashion.
 * In BMM, formal parameters have single-letter names, such as 'T', 'U' etc, following typical usage in programming languages.
 * A generic class may also be primitive.
 * Generic classes can be defined in a syntax similar to the following.The following example shows a generic class Interval<T:Ordered>, which is a class Interval with one formal parameter T constrained to be of type Ordered or any descendant.
 * 
 * 
 * 
 * // a primitive generic class with an open type parameter primitive class List <T> { feature // feature definitions } // a generic class with a constrained type parameter class DvInterval <T:DvOrdered> { feature // feature definitions } // a primitive generic class two type parameters primitive class HashMap <K:Ordered, V> { feature // feature definitions }
 * 
 * 
 * 
 * Figure 19.
 * BMM class - generic class
 * 6.4.
 * Range-Constrained Classes
 * The value range of any defined type is by default open, meaning that its instances may take any value allowed by the type definition.
 * For primitive types such as String and Integer, this means that any String or Integer value is a valid instance.
 * For composed types, instances are composed of hierarchies of values which are similarly un-constrained with respect to their types.A useful derived form of any concrete type definition (i.e.
 * instance of BMM_EFFECTIVE_TYPE in a model) is one that constrains the legal values of its instances to a particular set of values.
 * The Pascal language provided a well-known precedent, 'sub-range types' that could restrict primitive type value ranges.
 * BMM supports two kinds of range constraint: enumeration and 'value sets'.
 * The additional meta-classes are shown below.
 * 
 * 
 * 
 * 
 * 
 * Figure 20.
 * bmm.core.range_constrained Package - Constrained-range Meta-Types, including Enumeration
 * 6.4.1.
 * Enumerated Types
 * In modern programming languages, the enumerated type is the most common kind of range constraint mechanism.
 * In Java for example, an enumeration is a finite set of labels each associated with singleton value object - either automatically assigned integers, or else programmatically associated instances of any other kind.
 * Enumerated types are supported in BMM via the BMM_ENUMERATION meta-type and descendants.
 * An enumerated type could in theory be based on any BMM defined type, i.e.
 * any simple or generic type, since instances of either could be constrained.
 * BMM makes the simplification that an enumerated type can only be based on a BMM simple type, which means that in the defined model, an enumeration of a closed generic type Gen<T_subst> is achieved by first defining a simple type based on the closed generic type via inheritance, e.g.
 * a type Gen_T_subst that inherits from Gen<T_subst> can be used as the ancestor of a BMM enumeration type.
 * For this reason, the BMM_ENUMERATION meta-type is defined as a descendant of BMM_SIMPLE_CLASS, and may have only one ancestor.
 * The value enumeration is represented via a set of enumeration labels (item_names) and constant values (item_values), the latter of which must be of the type represented in the concrete model by the instance of the ancestor class.
 * Since String and Integer valued enumerations are by far the most common in real models, two descendant classes BMM_ENUMERATION_STRING and BMM_ENUMERATION_INTEGER are provided, which fix the values and types to String and Integer respectively.
 * The following diagram shows the BMM instance structure corresponding to an attribute declaration lifecycle: TaskLifecycle in a class Order.
 * Figure 21.
 * Integer-based Enumeration Type The following shows the same class in an abstract syntax.
 * // an Integer-based enumeration enumeration class TASK_LIFECYCLE { planned = 0; available = 1; cancelled = 2; aborted = 3; abandoned = 4; underway = 5; suspended = 6; resumed = 7; completed = 8; } The following screenshot shows how this enumeration class appears within a BMM model.
 * Figure 22.
 * Enumeration Example The following shows another enumeration class, this time based on the String type.
 * // a String-based enumeration enumeration class ContractStatus { initial = "Initial"; cancelled = "Cancelled"; active = "Active"; completed = "Completed"; } The types String and Integer are assumed to be defined via primitive classes of the same names.
 * 6.4.2.
 * Value-set Types
 * Another form of range constraint that occurs in many models is the use of 'coded terms' that represent codes from e.g.
 * ISO or IANA value sets such as ISO 639 (languages) and IANA media types.
 * These are particularly prevalent in type systems used in the biosciences where object models routinely include attributes of a Coded Term type that refer to terminologies such as SNOMED CT, WHO ICD10 etc.
 * In such models, it is typical to want to define an attribute being not just of a Coded Term type, but also limited to a particular terminology (such as a coded attribute representing 'language'), or even a specific 'value set' from such a terminology.
 * The same kind of constraint may be applied to any kind of model type, for example a type representing Medication may be constrained to be instantiated only as instances defined by a medications database.
 * This kind of constraint is known here as a value set, following the common usage in the biomedical sciences, and is supported in a different way than enumerations.
 * The latter is a common programming concept which always involves a dedicated type representing the enumeration.
 * Since the required value-sets are represented explicitly in the model but in an external database or other resource, the constraint is limited to a reference to the relevant resource, and is applied directly to the use of a type within a feature definition, rather than requiring the definition of a new type.
 * Accordingly, BMM provides the attribute value_constraint: BMM_VALUE_SET_SPEC defined on BMM_MODEL_TYPE.
 * The BMM_VALUE_SET_SPEC meta-type contains two String attributes resource_id and value_set_id which may be used to define a resource (equivalently a namespace) and an identifier of a value set within that resource.
 * BMM does not impose any particular format or resolution algorithm on these identifiers - it is assumed that they can be correctly defined and used within the context of the concrete model usage.
 * Consequently, an attribute within a standard concrete model such as language: CodedTerm could now be expressed notionally as language: CodedTerm <<iso::639-*>> or language: CodedTerm <<iso::languages>>.
 * The construction within the <<>> is parsed into two pieces around the :: separator, which are then used to populate the BMM_VALUE_SET_SPEC for a type.
 * The following diagram shows the meta-model structure corresponding to an attribute declaration language: CodedText whose instances are constrained to be from a value-set iso_639-2 within the resource namespace iso.
 * Figure 23.
 * Value-set Constrained Type The following shows a possible abstract syntax value-set type definition.
 * // a Value-set type class Document { feature property language: CodedText <<"iso::iso_639-2">> [1]; }
 * 6.5.
 * Class Qualifiers
 * The following sub-sections describe qualifiers that may be used on any class definition to achieve a specific status within the model system.
 * BMM qualifiers are designed to map to typical features in programming languages.
 * 
 * 
 * 6.5.1.
 * Abstract Classes
 * Any class definition in a BMM model may be marked as 'abstract', to indicate that it cannot be directly instantiated.
 * This qualifier generally maps to the concept of abstract classes in most OOPLs.
 * It may be specified in an abstract syntax as follows.
 * abstract class ENTRY { feature // feature definitions }
 * 6.5.2.
 * Primitive Type Classes
 * Class definitions within a BMM model may be marked as 'primitive', enabling them to be visualised and queried as a separate group without otherwise changing the semantics of the entity in the BMM meta-type system.
 * This is normally done to distinguish 'built-in' types used by a model from the classes for which the model was created.
 * An abstract syntax definition may look as follows: primitive class Integer { feature // feature definitions } primitive class String { feature // feature definitions } The following shows part of a BMM model in which a number of classes are classified as primitive (shown in light and dark grey).
 * Figure 24.
 * Primitive classes Primitive classes are normal BMM classes, other than being marked primitive for convenience, and do not have different semantics.
 * 6.6.
 * Class Invariants
 * A class defined within a model may include invariants, i.e.
 * assertions relating to its state that hold true before and after all public routine calls.
 * Assertions are instances of the class BMM_ASSERTION, which is a tagged Boolean-valued Expression.The following shows classes with invariants.
 * 
 * 
 * 
 * 
 * 
 * // a class with simple invariants class COMPOSITION { feature // feature definitions invariant Is_archetype_root: is_archetype_root Content_valid: content /= Void implies not content.is_empty } // a class with more complex invariants class VERSIONED_COMPOSITION { feature // feature definitions invariant Archetype_node_id_valid: all_versions.for_all ( agent (v: VERSION) { v.archetype_node_id.is_equal (all_versions.first.archetype_node_id); } ) Persistent_validity: all_versions.for_all ( agent (v: VERSION) { v.is_persistent = all_versions.first.data.is_persistent; } ) }
 * 6.7.
 * Inheritance
 * Inheritance in BMM is a relation between a class and one or more types, rather than classes, as in many class-based formalisms.
 * This is primarily to allow classes to be based on specific generic types, rather than just the 'open' type represented by the underlying classes.
 * Multiple inheritance is permitted, with same-named features from different types being treated as clashes needing resolution.
 * See Section 12.1 for a detailed description.
 * 
 * 
 * 6.8.
 * Model Theoretic Questions
 * The class meta-model as defined here entails certain choices that have consequences, including:
 * 
 * 
 * 
 * 
 * 6.9.
 * Class Definitions
 * 
 * 6.9.1.
 * BMM_CLASS Class
 * 
 * 6.9.2.
 * BMM_SIMPLE_CLASS Class
 * 
 * 6.9.3.
 * BMM_GENERIC_CLASS Class
 * 
 * 6.9.4.
 * BMM_ENUMERATION Class
 * 
 * 6.9.5.
 * BMM_ENUMERATION_STRING Class
 * 
 * 6.9.6.
 * BMM_ENUMERATION_INTEGER Class
 * 
 * 6.9.7.
 * BMM_VALUE_SET_SPEC Class
 * 
 * 
*/
bmm/classestruefalseBmmClassBmmClassBMM_CLASS (abstract)Meta-type corresponding a class definition in an object model. Inheritance is specified by the ancestors attribute, which contains a list of types rather than classes. Inheritance is thus understood in BMM as a stated relationship between classes. The equivalent relationship between types is conformance. Note unlike UML, the name is just the root name, even if the class is generic. Use type_name() to obtain the qualified type name.BmmModuleBMM_MODULE0..1ancestors: Hash<String,BMM_MODEL_TYPE>List of immediate inheritance parents.1..1package: BMM_PACKAGEPackage this class belongs to.0..1properties: Hash<String,BMM_PROPERTY>List of attributes defined in this class.1..1source_schema_id: StringReference to original source schema defining this class. Useful for UI tools to determine which original schema file to open for a given class for manual editing.0..1immediate_descendants: List<BMM_CLASS>List of computed references to base classes of immediate inheritance descendants, derived when members of ancestors are attached at creation time.1..1is_override: BooleanTrue if this definition overrides a class of the same name in an included schema.0..1constants: Hash<String,BMM_CONSTANT>List of constants defined in this class.0..1functions: Hash<String,BMM_FUNCTION>List of functions defined in this class.0..1procedures: Hash<String,BMM_PROCEDURE>List of procedures defined in this class.0..1is_primitive: Boolean {default = false}True if this class represents a type considered to be primitive in the type system, i.e. any typically built-in or standard library type such as String, Date, Hash<K,V> etc.0..1is_abstract: Boolean {default = false}True if this class is marked as abstract, i.e. direct instances cannot be created from its direct type.0..1invariants: List<BMM_ASSERTION>0..1creators: Hash<String,BMM_PROCEDURE>Subset of procedures that may be used to initialise a new instance of an object, and whose execution will guarantee that class invariants are satisfied.0..1converters: Hash<String,BMM_PROCEDURE>Subset of creators that create a new instance from a single argument of another type.0..1feature_groups: List<BMM_FEATURE_GROUP>List of feature groups in this class.1..1 (abstract)type (): BMM_MODEL_TYPEGenerate a type object that represents the type for which this class is the definer.0..1all_ancestors (): List<String>List of all inheritance parent class names, recursively.0..1all_descendants (): List<String>Compute all descendants by following immediate_descendants.0..1suppliers (): List<String>List of names of immediate supplier classes, including concrete generic parameters, concrete descendants of abstract statically defined types, and inherited suppliers. (Where generics are unconstrained, no class name is added, since logically it would be Any and this can always be assumed anyway). This list includes primitive types.0..1suppliers_non_primitive (): List<String>Same as suppliers minus primitive types, as defined in input schema.0..1supplier_closure (): List<String>List of names of all classes in full supplier closure, including concrete generic parameters; (where generics are unconstrained, no class name is added, since logically it would be Any and this can always be assumed anyway). This list includes primitive types.1..1package_path (): StringFully qualified package name, of form: package.package.1..1class_path (): StringFully qualified class name, of form: package.package.CLASS with package path in lower-case and class in original case.1..1is_primitive (): BooleanTrue if this class is designated a primitive type within the overall type system of the schema. Set from schema.1..1is_abstract (): BooleanTrue if this class is abstract in its model. Value provided from an underlying data property set at creation or construction time.0..1features (): List<BMM_CLASS_FEATURE>List of all feature definitions introduced in this class.0..1flat_features (): List<BMM_CLASS_FEATURE>Consolidated list of all feature definitions from this class and all inheritance ancestors.0..1flat_properties (): List<BMM_PROPERTY>List of all properties due to current and ancestor classes, keyed by property name.falsefalseBmmSimpleClassBmmSimpleClassBMM_SIMPLE_CLASSDefinition of a simple class, i.e. a class that has no generic parameters and is 1:1 with the type it generates.BmmClassBMM_CLASS1..1 (effected)type (): BMM_SIMPLE_TYPEGenerate a type object that represents the type of this class. Can only be an instance of BMM_SIMPLE_TYPE or a descendant.falsefalseBmmGenericClassBmmGenericClassBMM_GENERIC_CLASSDefinition of a generic class in an object model.BmmClassBMM_CLASS1..1generic_parameters: Hash<String,BMM_PARAMETER_TYPE>List of formal generic parameters, keyed by name. These are defined either directly on this class or by the inclusion of an ancestor class which is generic.0..1 (redefined)suppliers (): List<String>Add suppliers from generic parameters.1..1 (effected)type (): BMM_GENERIC_TYPEGenerate a fully open BMM_GENERIC_TYPE instance that corresponds to this class definition1..1generic_parameter_conformance_type ( a_name: String[1] ): StringFor a generic class, type to which generic parameter a_name conforms e.g. if this class is Interval <T:Comparable> then the Result will be the single type Comparable. For an unconstrained type T, the Result will be Any.falsefalseBmmEnumerationBmmEnumerationBMM_ENUMERATIONDefinition of an enumeration class, understood as a class whose value range is constrained extensionally, i.e. by an explicit enumeration of named singleton instances. Only one inheritance ancestor is allowed in order to provide the base type to which the range constraint is applied. The common notion of a set of literals with no explicit defined values is represented as the degenerate subtype BMM_ENUMERATION_INTEGER, whose values are 0, 1, …​BmmSimpleClassBMM_SIMPLE_CLASS0..1item_names: List<String>The list of names of the enumeration. If no values are supplied, the integer values 0, 1, 2, …​ are assumed.0..1item_values: List<BMM_PRIMITIVE_VALUE>Optional list of specific values. Must be 1:1 with item_names list.1..1name_map (): Hash<String, String>Map of item_names to item_values (stringified).falsefalseBmmEnumerationStringBmmEnumerationStringBMM_ENUMERATION_STRINGString-based enumeration meta-type.BmmEnumerationBMM_ENUMERATION0..1 (redefined)item_values: List<BMM_STRING_VALUE>Optional list of specific values. Must be 1:1 with item_names list.falsefalseBmmEnumerationIntegerBmmEnumerationIntegerBMM_ENUMERATION_INTEGERInteger-based enumeration meta-type.BmmEnumerationBMM_ENUMERATION0..1 (redefined)item_values: List<BMM_INTEGER_VALUE>Optional list of specific values. Must be 1:1 with item_names list.falsefalseBmmValueSetSpecBmmValueSetSpecBMM_VALUE_SET_SPECDefinition of a range-constrained class whose value range is defined by reference to a 'value set' within an external resource, e.g. a reference data service.1..1resource_id: StringIdentifier of a resource (typically available as a service) that contains legal values of a specific type. This is typically a URI but need not be.1..1value_set_id: StringIdentifier of a value set within the resource identified by resource_id, which specifies the set of legal values of a type. This might be a URI, but need not be.package bmm/class_features;
/**
 * 
 * 
 * 7.
 * Class Features
 * 7.1.
 * Overview
 * Within the definition of each class in a BMM model are found the declarations of its features, consisting of routines, properties and constants.
 * The overall meta-model of features, as well as the elements that occur within them, namely parameters and local variables is shown below, and described in this section.The taxonomy of meta-types that classify the concrete meta-types representing features is somewhat complicated in an object-oriented approach by the presence of procedures, which are declared features (sometimes called commands or modifiers) that change internal object state, rather than returning a value as is the case with all other kinds of features.
 * The consequence is that the cleanest approach to definition of meta-attributes is the use of two taxonomies, one corresponding to feature declarations (including procedures) and one to do with typed value-returning entities, which excludes procedures.
 * 
 * 
 * 
 * 
 * 7.1.1.
 * Feature Groups
 * Features are arranged within a class in feature groups, each represented by an instance of the meta-type BMM_FEATURE_GROUP.
 * By default there is at least one feature group called "feature".
 * Feature groups may be given any name, and are usually used to group features on the basis of things like: meta-type, e.g.
 * a group called "rules" limited to publicly visible functions only; logical feature type, e.g.
 * commands, queries, factory methods etc.
 * The primary purpose of feature groups is to represent specific meta-data that naturally applies to more than one feature in general, and is thus convenient to represent on a logical container rather than repeat individually.
 * Feature group meta-data is recorded in the properties attribute.
 * A feature group may also set default visibility for all features in the group.
 * 7.1.2.
 * Feature Visibility
 * Selective visibility of features to external clients is expressed in the attributes BMM_FEATURE_GROUP.visibility with potential overrides achieved using BMM_CLASS_FEATURE.visibility, i.e.
 * at an individual feature level.
 * Visibility is defined using sub-types of the abstract meta-class BMM_VISIBILITY.
 * TBD: define visibility meta-model; probably need to support C/Java approach and type-based.
 * 7.1.3.
 * Feature Declarations
 * Features are understood in BMM as entities referenceable within a module or lower context.
 * The 'module' in BMM is the class.
 * Class features consist of the formal sub-parts of a class, namely: routines: procedures and functions; properties: mutable static definitions, described in detail in previous sections; constants: immutable static definitions.
 * Variables are also understood as a kind of class feature, whose scoping entity is further restricted to a containing routine.
 * The taxonomy of feature declarations is shown below.
 * Figure 25.
 * Feature taxonomy This taxonomy is concerned with model elements that can be lexically declared within some scope.
 * Those elements defined within a class scope have a type signature, i.e.
 * a formal 'shape' in terms of types.
 * This applies even to procedures, which are formal entities despite having no return type.
 * 7.1.4.
 * Typed Entities
 * For entities with a type, i.e.
 * which can potentially produce a value, the following taxonomy of typing applies.
 * Figure 26.
 * Typed taxonomy This taxonomy is concerned with typedness, valuedness, and mutability, which is the notion that a typed value-producing entity may be Void (null) at execution time.
 * Features, which are declarations in context can be mutable, but value objects (e.g.
 * literal values, delayed routine calls) cannot.
 * 7.1.5.
 * Class Model
 * The class model that results from the above considerations is shown below.
 * Figure 27.
 * base.bmm.core.feature package - Features 7.1.5.1.
 * A Note on Multiple Inheritance In the above model, multiple inheritance is used in order to express the design intention of the model.
 * In many modern languages, multiple inheritance of classes containing attributes is not possible.
 * Accordingly, to aid implementation in these languages, the diagram distinguishes the two inheritance hierarchies as follows: the 'true' inheritance hierarchy under the class BMM_TYPED (shown in green), corresponding to the type taxonomy illustrated in Figure 26 above; a second hierarchy used to obtain structural elements, under BMM_DECLARAION (shown in blue), corresponding to the feature taxonomy illustrated in Figure 25 above.
 * The BMM_TYPED hierarchy is the one requiring type substitutability, and is thus implemented using class inheritance (e.g.
 * extends in Java), while the other should be implemented by inheritance of interfaces.
 * This can be achieved as follows: define the BMM classes BMM_ROUTINE, BMM_CLASS_FEATURE, BMM_CLASS_ENTITY, BMM_DECLARATION etc as interfaces, with the attributes (such as BMM_ROUTINE.parameters) declared as methods and declare the inheritance as interface inheritance (e.g.
 * implements in Java); define a parallel class hierarchy BMM_ROUTINE_IMPL, etc whose design follows the UML model above (i.e.
 * defines real attributes) and which are declared as the types of private data elements in the main classes (e.g.
 * BMM_FUNCTION, in order to obtain the attributes logically defined by BMM_ROUTINE in the UML); implement the methods inherited from the interface hierarchy via a declaration via the appropriate dispatch code referencing the relevant private data member.
 * The above approach should result in the same semantics as defined by the model shown above.
 * 7.1.6.
 * Differential and Flat Form
 * In modelling or programming terms, the features defined on a particular class within a model constitute the features it introduces with respect to its inheritance parent(s).
 * We can think of this list of features as the differential set.
 * A 'top-level' class with no declared inheritance ancestor is considered to inherit by default from the Any class, and its feature set is relationally differential to the top class.
 * In contrast, the effective set of features for an instance at runtime is the result of evaluating these lists of features down the inheritance hierarchy to obtain the flat set of features.
 * The features properties and flat_properties defined on BMM_CLASS provide access to these two lists for any class.
 * 7.1.7.
 * Signatures
 * All class-scoped features have formal signatures (described in Section 5.5), realised as BMM_CLASS_ENTITY.signature.
 * This includes procedures, even though they have no return type.
 * The two types of routines, i.e.
 * functions and procedures, include zero or more formal parameters in their signatures, with functions also having a return type.
 * The standard taxonomy of feature signature types is illustrated below, with each form being controlled by invariants stated in the relevant containing meta-classes (e.g.
 * BMM_FUNCTION, representing a function definition has an invariant requiring signature.result /= Void).
 * Figure 28.
 * Signature taxonomy
 * 7.1.8.
 * Synthesis due to Generic Parameter Substitution
 * Due to the possibility of generating concrete types via substitution of concrete generic parameters for formal parameters of generic classes, new concrete types of features may routinely result anywhere in a fully computed in-memory BMM model.
 * BMM allows such features to be synthesised with their resulting concrete types rather than their 'source-defined' open parameter types, and provides the Boolean flag is_synthesised_generic on the class BMM_CLASS_ENTITY to mark any such synthesised feature.
 * An example of the use of this is described below in Section 12.1.2.
 * 7.2.
 * Constants
 * Constant features in a class are represented by the BMM meta-type BMM_CONSTANT, which is:At runtime a constant has a value, which may be of any type, including complex types, and which is set using its generator expression (i.e.
 * an instance of the meta-type EL_INSTANCE_REF).
 * In the common degenerate case, generator consists simply of a literal value, but may also be a function call or other expression valid in the context of the scoping class.
 * This latter capability is the means by which computed constants are supported.The following abstract syntax illustrates how constants may be defined in a BMM model.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * class BASIC_DEFINITIONS { feature // // simple constants // constant CR: Character = '\015'; constant LF: Character = '\012'; // // constant of complex type // TODO: correct JSON (maybe YAML?) or other syntax // constant SafeSpeed: Interval<Quantity> = |0.0 km/h ..
 * 60.0 km/h|; // // constant generated by a one-time expression evaluation // constant ProxyVar<Quantity> = {ProxyVar<Quantity>}(arg1, arg2); }
 * 7.3.
 * Properties
 * Class properties are defined via the meta-class BMM_PROPERTY, and its subtypes which distinguish unitary properties (single-valued attributes in a class) from container properties (multiply-valued attributes).The BMM_PROPERTY meta-type defines semantics common to all properties, including is_composition, which indicates whether the property reference instantiates a part-of relationship or an association.
 * 
 * 
 * 
 * 
 * 7.3.1.
 * Unitary versus Container Properties
 * Single-valued properties in a BMM model are instances of the type BMM_UNITARY_PROPERTY, and have as their type the meta-type UNITARY_TYPE.
 * Container properties are instances of the meta-type BMM_CONTAINER_PROPERTY, which adds the attribute cardinality, enabling the possible number of container elements to be constrained (this corresponds to the multiplicities used at the end of UML associations).
 * The meta-type BMM_INDEXED_CONTAINER_PROPERTY adds the attribute index_type, enabling representation of indexed concrete container types such as Hash<K,V> etc.
 * A typical example of properties of class is shown below, in which the flattened property view of a class OBSERVATION includes the inherited properties other_participations and links properties exemplifying the container property meta-type: Figure 29.
 * BMM class - properties view The following illustrates how various kinds of properties may appear in a BMM model.
 * The first two properties are associations, used to represent references to shared objects (including singletons), while the remainder are normal compositional sub-parts, i.e.
 * owned sub-instances that will cease to exist when the parent object is destroyed.
 * All of the properties are single-valued, other than other_participations, which is defined as a container property with cardinality [*] (i.e.
 * 0..*) and 'set' semantics.
 * abstract class ENTRY extend CARE_ENTRY { feature -- Locale association property language: CODE_PHRASE <<"iso::iso_639-2">> [0..1]; association property encoding: CODE_PHRASE <<"iana::character-sets">> [0..1]; feature -- Access composition property protocol: ITEM_STRUCTURE[1]; composition property guideline_id: OBJECT_REF[0..1]; composition property subject: PARTY_PROXY[0..1]; composition property other_participations: PARTICIPATION[*]{set}; }
 * 7.3.2.
 * Semantic level
 * TBD: this BMM feature requires review Properties also include two other Boolean meta-data items, is_im_runtime and is_im_infrastructure, which can be used to classify property values in a model according to 'semantic level', which roughly corresponds to the continuum from domain-specific to infrastructure.
 * These may be individually set, or both may be False.
 * The three meaningful value settings are as follows: both False: the value of the property is considered to be design-time constrainable; is IM runtime: True if the property value is only knowable at runtime, as is typically the case for identifiers, dates etc; is infrastructure: True if the property is not a user- or business-oriented property, but something required by software design, e.g instance identifier, meta-data etc.
 * The above screenshot also includes properties have different settings of the is_im_runtime and is_im_infrastructure meta-data flags: property names in black are neither; those in grey are IM runtime (guideline_id, workflow_id), and those in light grey are infrastructure properties (language, encoding, uid, etc).
 * 7.4.
 * Functions and Procedures
 * Functions and procedures are kinds of routine, which are computational features of a class.
 * The classes BMM_FUNCTION, BMM_PROCEDURE and BMM_ROUTINE respectively provide the meta-model for definitions of the two types of routine.The formal parameter definitions of both kinds of routines are represented by an ordered list of instances of the meta-class BMM_PARAMETER, which is defined as a kind of variable.
 * A formal parameter may optionally have the read/write direction defined, which indicates whether the variable contains an input value, should only be written to, or both, i.e.
 * read then written to.
 * The is_nullable meta-attribute inherited from BMM_TYPED_FEATURE indicates whether each parameter is mandatory or not.An additional feature of the meta-model for functions is the notion of operator, which supports the representation of a function call in a formal expression as an operator symbol with one or two operands, in the typical form found in programming languages and first order logics.
 * The BMM approach considers an operator as an optional addition to any function of arity 1 or 2 that may reasonably be represented in an abstract syntax using operator syntax.
 * Operators thus support the use of expressions like weight > 90 to mean weight.gt (90), where weight is of type Real, and the function gt(other: Real) is defined.Any routine may have pre- and/or post-conditions defined for it, represented in BMM by BMM_ASSERTIONs populating the pre_conditions and post_conditions attributes of BMM_ROUINE.
 * An Assertion is a tagged Boolean Expression.The following abstract syntax illustrates the various elements of function definitions.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * abstract class DV_AMOUNT inherit DV_QUANTIFIED { feature -- Arithmetic Operations function equal (other: DV_AMOUNT[1]): Boolean[1] alias {infix '='}; function less_than (other: DV_AMOUNT[1]): Boolean[1] alias {infix '<'}; feature -- Arithmetic Operations function add (other: DV_AMOUNT[1]): DV_AMOUNT[1] alias {infix '+'}; function subtract (other: DV_AMOUNT[1]): DV_AMOUNT[1] alias {infix '-'}; function multiply (val: Real[1]): DV_AMOUNT[1] alias {infix '*'}; function divide (val: Real[1]): DV_AMOUNT[1] alias {infix '/', infix '÷'}; }
 * 7.4.1.
 * Pre- and Post-conditions
 * All BMM routine definitions may include pre- and/or post-conditions, with the semantics of Djikstra’s weakest pre-condition logic (Dijkstra (1976)), Object-Z (Smith (2000)) and the Eiffel language (Meyer (1997)).
 * The essential semantics are as follows: pre-conditions specify truth conditions on public object state and/or parameters that must hold for the routine to execute correctly; if a pre-condition is not met at the moment of routine call, the client (caller) is at fault; post-conditions specify truth conditions on public object state and/or result (in the case of functions) that will hold at the end of routine execution; if a post-condition is not met at the moment of routine completion, the routine is at fault, i.e.
 * contains bugs.
 * The use of pre- and post-conditions is also known as design by contract (DbC), a term introduced by Meyer, and is widely used in general IT, particularly in specification languages such as OMG Interface Definition Language (IDL).
 * The following shows how a routine contract may be specified in an abstract syntax.
 * class I_EHR_SERVICE { feature -- Creation create_ehr_with_id ( an_ehr_id: UUID[1]; an_ehr_status: EHR_STATUS[0..1] ): UUID[1] pre_condition No_duplicate: not has_ehr (an_ehr_id) post_condition Has_ehr: has_ehr (Result) }
 * 7.4.2.
 * Creators and Converters
 * In common with may OOPLs, BMM classes may specify creators, i.e.
 * instance-creating procedures, known as 'constructors' in some OOPLs.
 * These are just a subset of all procedures known in BMM_CLASS.procedures that when executed will satisfy the class invariants.
 * A further subset of the creators are single-argument converters which can initialise a new instance from an instance of another type.
 * Converter routines are typically used to support type conversion in expressions, e.g.
 * String to Date etc.
 * These two subsets are formally defined as the creators and converters reference lists of procedures on BMM_CLASS, as shown in the following UML view.
 * Figure 30.
 * Class creators and converters Creators and converters might be distinguished among other procedures in an abstract syntax as follows.
 * class Date inherit Temporal convert create_from_string { feature -- Creators procedure create_from_string (a_date_str: String[1]) procedure create (a_day, a_month, a_year: Integer[1]) feature -- Modification procedure set_day (a_day: Integer[1]) }
 * 7.4.3.
 * Routine Body
 * BMM supports the definition of statements, i.e.
 * implementation within a ROUTINE as well as 'external' routines, which are represented by an instance of the meta-class BMM_ROUTINE_EXTERNAL.
 * These classes are shown in the following UML view.
 * Figure 31.
 * Routine body The meta-model of statements is described in detail in Section 11.
 * 7.5.
 * Variables
 * At the finest level of detail of a model definition are what are typically thought of as variables within a routine scope.
 * These may be either local variables (variables declared locally within a routine) and parameter variables (declared in the arguments part of a routine declaration).
 * Local variables and parameters have the meta-types BMM_LOCAL and BMM_PARAMETER respectively.
 * The special pre-defined variable Result is automatically available within any function, and is represented by the meta-model type BMM_RESULT.
 * 
 * 
 * 7.6.
 * Model Theoretic Questions
 * The features meta-model as defined here entails certain choices that have consequences.
 * The primary choice that affects this part of the meta-model is not to treat Void as a type, with the result a procedure is not a typed entity, meaning its signature has no result part.
 * This makes procedures an anomaly within an otherwise typed system of entities, and complicates the inheritance structure of the BMM meta-model.
 * The alternative would have been to treat procedures as Void-returning entities, and thus of type Void (a pseudo-type), as per languages such as C++ and Java, or an equivalent, such as the Unit pseudo-type of Kotlin.
 * The major disadvantage of the latter is that it makes procedure definitions (BMM_PROCEDURE instances within a BMM model) look like typed entities, and as a result, procedure calls look like value-returning entities that could be used within expressions (i.e.
 * no different than function calls).Ultimately this difficulty arises from the decision to include procedures at all within the formal framework, when from a purely functional perspective they would not exist.
 * Avoiding procedures means going down a pure functional route, which, although providing a cleaner model of pure computation, inevitably entails various artificial and non-intuitive means of making a computational entity do something.
 * BMM has taken the route of objects as black boxes having queries (functions, properties) and commands (procedures), with well-behaved models relying on the principle of command-query separation (CQS), i.e.
 * side-effect free functions.
 * CQS is not enforced by BMM, but its use would make a formal model expressed in BMM more tractable to proof-based tools.
 * 
 * 
 * 
 * 
 * 7.7.
 * Class Definitions
 * 
 * 7.7.1.
 * BMM_TYPED Class
 * 
 * 7.7.2.
 * BMM_FEATURE_GROUP Class
 * 
 * 7.7.3.
 * BMM_VISIBILITY Class
 * 
 * 7.7.4.
 * BMM_CLASS_ENTITY Class
 * 
 * 7.7.5.
 * BMM_CLASS_FEATURE Class
 * 
 * 7.7.6.
 * BMM_TYPED_FEATURE Class
 * 
 * 7.7.7.
 * BMM_INSTANTIABLE Class
 * 
 * 7.7.8.
 * BMM_CONSTANT Class
 * 
 * 7.7.9.
 * BMM_PROPERTY Class
 * 
 * 7.7.10.
 * BMM_UNITARY_PROPERTY Class
 * 
 * 7.7.11.
 * BMM_CONTAINER_PROPERTY Class
 * 
 * 7.7.12.
 * BMM_INDEXED_CONTAINER_PROPERTY Class
 * 
 * 7.7.13.
 * BMM_ROUTINE Class
 * 
 * 7.7.14.
 * BMM_FUNCTION Class
 * 
 * 7.7.15.
 * BMM_OPERATOR Class
 * 
 * 7.7.16.
 * BMM_OPERATOR_POSITION Enumeration
 * 
 * 7.7.17.
 * BMM_PROCEDURE Class
 * 
 * 7.7.18.
 * BMM_VARIABLE Class
 * 
 * 7.7.19.
 * BMM_LOCAL Class
 * 
 * 7.7.20.
 * BMM_PARAMETER Class
 * 
 * 7.7.21.
 * BMM_RESULT Class
 * 
 * 7.7.22.
 * BMM_PARAMETER_DIRECTION Enumeration
 * 
 * 7.7.23.
 * BMM_ROUTINE_BODY Class
 * 
 * 7.7.24.
 * BMM_ROUTINE_EXTERNAL Class
 * 
 * 
*/
bmm/class_featurestruefalseBmmTypedBmmTypedBMM_TYPED (abstract)Any entity that has a declared or inferred static type, and that can therefore be generate a value.1..1type: BMM_TYPEDeclared or inferred static type of the entity.1..1is_boolean (): Boolean Post_result: Result = type().equal( {BMM_MODEL}.boolean_type_definition())True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = 'Boolean').falsefalseBmmFeatureGroupBmmFeatureGroupBMM_FEATURE_GROUPA logical group of features, with a name and set of properties that applies to the group.1..1name: String {default = "feature"}Name of this feature group; defaults to 'feature'.1..1properties: Hash<String, String>Set of properties of this group, represented as name/value pairs. These are understood to apply logically to all of the features contained within the group.0..1features: List<BMM_CLASS_FEATURE>Set of features in this group.0..1visibility: BMM_VISIBILITYOptional visibility to apply to all features in this group.truefalseBmmVisibilityBmmVisibilityBMM_VISIBILITY (abstract)Abstract parent of visibility representation. TODO: define schemes; probably need to support C++/Java scheme as well as better type-based schemes.truefalseBmmClassEntityBmmClassEntityBMM_CLASS_ENTITY (abstract)Any entity declared within a class.BmmDeclarationBMM_DECLARATION0..1is_synthesised_generic: Boolean {default = false}True if this feature was synthesised due to generic substitution in an inherited type, or further constraining of a formal generic parameter.1..1 (abstract)signature (): BMM_SIGNATUREFormal signature of this element, in the form: name [arg1_name: T_arg1, …​][:T_value] Specific implementations in descendants.truefalseBmmClassFeatureBmmClassFeatureBMM_CLASS_FEATURE (abstract)A class entity having a signature and a class as its scope.BmmClassEntityBMM_CLASS_ENTITY0..1visibility: BMM_VISIBILITYVisibility of this item to client entities.0..1feature_extensions: List<BMM_FEATURE_EXTENSION>Extensions to feature-level meta-types.1..1group: BMM_FEATURE_GROUPGroup containing this feature.1..1 (redefined)scope: BMM_CLASSClass within which a referenceable element is known.truefalseBmmTypedFeatureBmmTypedFeatureBMM_TYPED_FEATURE (abstract)A typed entity that is a feature within a context, and which may therefore be Void, i.e. 'nullable'.BmmTypedBMM_TYPED0..1is_nullable: Boolean {default = false}True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..truefalseBmmInstantiableBmmInstantiableBMM_INSTANTIABLE (abstract)Meta-type representing instantiable features, i.e. features that are created as value objects.BmmTypedFeatureBMM_TYPED_FEATUREfalsefalseBmmConstantBmmConstantBMM_CONSTANTAn immutable, static value-returning element scoped to a class. The value is the result of the evaluation of the generator, which may be as simple as a literal value, or may be any expression, including a function call.BmmInstantiableBMM_INSTANTIABLEBmmClassFeatureBMM_CLASS_FEATURE1..1generator: EL_INSTANCE_REFGenerator expression for the constant value. In the degenerate case, this is just a literal value, but may also be any other expression valid in the context.truefalseBmmPropertyBmmPropertyBMM_PROPERTY (abstract)Meta-type of a property definition within a class definition of an object model. The is_composition attribute indicates whether the property has sub-part or an association semantics with respect to the owning class.BmmInstantiableBMM_INSTANTIABLEBmmClassFeatureBMM_CLASS_FEATURE0..1is_im_runtime: Boolean {default = false}True if this property is marked with info model im_runtime property.0..1is_im_infrastructure: Boolean {default = false}True if this property was marked with info model im_infrastructure flag.0..1is_composition: Boolean {default = false}True if this property instance is a compositional sub-part of the owning class instance. Equivalent to 'composition' in UML associations (but missing from UML properties without associations) and also 'cascade-delete' semantics in ER schemas.1..1existence (): Multiplicity_intervalInterval form of 0..1, 1..1 etc, derived from is_nullable.1..1display_name (): StringName of this property to display in UI.falsefalseBmmUnitaryPropertyBmmUnitaryPropertyBMM_UNITARY_PROPERTYMeta-type of for properties of unitary type.BmmPropertyBMM_PROPERTY1..1 (redefined)type: BMM_UNITARY_TYPEDeclared or inferred static type of the entity.falsefalseBmmContainerPropertyBmmContainerPropertyBMM_CONTAINER_PROPERTYMeta-type of for properties of linear container type, such as List<T> etc.BmmPropertyBMM_PROPERTY0..1cardinality: Multiplicity_intervalCardinality of this container.1..1 (redefined)type: BMM_CONTAINER_TYPEDeclared or inferred static type of the entity.1..1 (redefined)display_name (): StringName of this property in form name: ContainerTypeName<>.falsefalseBmmIndexedContainerPropertyBmmIndexedContainerPropertyBMM_INDEXED_CONTAINER_PROPERTYMeta-type of for properties of linear container type, such as Hash<Index_type, T> etc.BmmContainerPropertyBMM_CONTAINER_PROPERTY1..1 (redefined)type: BMM_INDEXED_CONTAINER_TYPEDeclared or inferred static type of the entity.1..1 (redefined)display_name (): StringName of this property in form name: ContainerTypeName<IndexTypeName, …​>.truefalseBmmRoutineBmmRoutineBMM_ROUTINE (abstract)A feature defining a routine, scoped to a class.BmmClassFeatureBMM_CLASS_FEATURE0..1parameters: List<BMM_PARAMETER>Formal parameters of the routine.0..1locals: List<BMM_LOCAL>Local variables of the routine.0..1pre_conditions: List<BMM_ASSERTION>0..1post_conditions: List<BMM_ASSERTION>0..1body: BMM_ROUTINE_BODYBody of a routine, i.e. executable program.1..1arity (): IntegerReturn number of arguments of this routine.1..1 (effected)signature ()Formal signature of this element, in the form '[arg1_name: T_arg1, …​]:T_value'.falsefalseBmmFunctionBmmFunctionBMM_FUNCTIONA formal element with signature of the form: name ({arg:TArg}*):TResult. A function is a computed (rather than data) element, generally assumed to be non-state-changing.BmmTypedFeatureBMM_TYPED_FEATUREBmmRoutineBMM_ROUTINE0..1operator_definition: BMM_OPERATOROptional details enabling a function to be represented as an operator in a syntactic representation.1..1result: BMM_RESULTAutomatically created Result variable, usable in body and post-condition.falsefalseBmmOperatorBmmOperatorBMM_OPERATORDefinition of a symbolic operator associated with a function.1..1position: BMM_OPERATOR_POSITIONPosition of operator in syntactic representation.1..1symbols: List<String>Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.1..1name: StringFormal name of the operator, e.g. 'minus' etc.falsetrueBmmOperatorPositionBmmOperatorPositionBMM_OPERATOR_POSITIONEnumeration of possible position of operator in a syntactic representation for operators associated with 1- and 2- degree functions.prefixPrefix operator position: operator comes before operand.infixInfix operator position: operator comes between left and right operands.falsefalseBmmProcedureBmmProcedureBMM_PROCEDUREA formal element with signature of the form: name ({arg:TArg}*). A procedure is a computed (rather than data) element, generally assumed to be state-changing.BmmRoutineBMM_ROUTINEtruefalseBmmVariableBmmVariableBMM_VARIABLE (abstract)A mutable entity whose scope is a routine.BmmInstantiableBMM_INSTANTIABLEBmmClassEntityBMM_CLASS_ENTITY1..1 (redefined)scope: BMM_ROUTINERoutine within which variable is defined.1..1 (effected)signature ()Formal signature of this element, in the form 'name [arg1_name: T_arg1, …​][:T_value]'.falsefalseBmmLocalBmmLocalBMM_LOCALA routine local variable.BmmVariableBMM_VARIABLEfalsefalseBmmParameterBmmParameterBMM_PARAMETERA routine parameter variable.BmmVariableBMM_VARIABLE0..1direction: BMM_PARAMETER_DIRECTIONOptional read/write direction of the parameter. If none-supplied, the parameter is treated as in, i.e. readable.falsefalseBmmResultBmmResultBMM_RESULTAutomatically declared variable representing result instance of a Function call.BmmVariableBMM_VARIABLE1..1 (redefined)name: String {default = "Result"}Name of this model element.falsetrueBmmParameterDirectionBmmParameterDirectionBMM_PARAMETER_DIRECTIONEnumeration of parameter read/write direction values.inParameter is an input parameter, and treated as readonly by the receiving routine.outParameter is an output parameter, and treated as a reference to an entity writeable by the receiving routine.in_outParameter is an input and output parameter, and treated as a reference to an entity readable and writeable by the receiving routine.truefalseBmmRoutineBodyBmmRoutineBodyBMM_ROUTINE_BODY (abstract)Abstract ancestor of routine body meta-types.falsefalseBmmRoutineExternalBmmRoutineExternalBMM_ROUTINE_EXTERNALExternal routine placeholder, containing sufficient meta-data to enable a routine in an external library to be called.BmmRoutineBodyBMM_ROUTINE_BODY1..1meta_data: Hash<String, String>External call general meta-data, including target routine name, type mapping etc.0..1argument_mapping: Hash<String, String>Optional argument-mapping meta-data.package bmm/literal_values;
/**
 * 
 * 
 * 8.
 * Literal Values
 * 8.1.
 * Overview
 * With a typical formal model, there is a need for formal representation of literal values.
 * This is needed to support constant declarations, 'default values' (a UML concept), enumeration literals and literal routine calls (see next section).
 * In BMM, all such values have as their meta-type the type BMM_LITERAL_VALUE or a descendant.
 * The type hierarchy mostly mimicks the hierarchy of the BMM_TYPE hierarchy, allowing for literal values of any of the meta-types in that part of the model.
 * The UML model of these types is shown below.
 * 
 * 
 * 
 * Figure 32.
 * base.bmm.core.literal_value package - Literal Values
 * 8.2.
 * General Model
 * When a BMM model is instantiated in its in-memory form, e.g.
 * in a BMM modelling tool, any literal values in the model such as constant values (e.g.
 * Real Pi = 3.1415926), default values (e.g.
 * Person.name: String = "(unknown)") etc are instances of 'two types':The value of any such instance is represented by the value_literal field within its BMM_LITERAL_VALUE.
 * This is assumed to carry a serialised form of the value expressed in a syntax known to the model processing environment within which the BMM model is being used.
 * This may be a programming language syntax, JSON, or any other serialisable format, and is specified by BMM_LITERAL_VALUE.syntax.
 * 
 * 
 * 
 * 
 * 
 * 
 * 8.3.
 * Container Literals
 * Literals representing Lists or Sets of values of objects of other types have as their BMM meta-type BMM_CONTAINER_VALUE.
 * For example, if the serialised value ["Feyerabend", "Lakatos", "Popper"] (which happens to be a JSON Array of Strings) were parsed as a List<String> instance, its meta-type would be a BMM_CONTAINER_VALUE instance whose value_literal was the same string, assuming JSON were used as the syntax, and whose type will be BMM_CONTAINER_TYPE.
 * Similarly a syntax that supported literal Sets using braces, e.g.
 * {"Feyerabend", "Lakatos", "Popper"} may be parsed to a Set<String> instance, with the same meta-type as for the List.In a similar way, a Hash table (aka 'map', 'dictionary' etc) structure has as its meta-type BMM_INDEXED_CONTAINER_VALUE.
 * 
 * 
 * 
 * 
 * 8.4.
 * Literal Tuples
 * Literal tuples may be expressed in BMM, but are not instances of BMM_LITERAL_VALUE; instead they are instances (at the meta level) of EL_TUPLE, an expression-related meta-type.
 * This is a consequence of the fact that Tuple is considered a BMM built-in type rather than a model-provided type, and also that a Tuple instance may contain items of any meta-type, not just literal values.
 * Tuple instances are used in BMM expressions and described in Section 9.2.
 * 
 * 
 * 8.5.
 * Type Extensions
 * If it were desired to create a full set of 'native' types for BMM, in the way supplied for UML in the UML Standard Profile, specific descendants would be added to the meta-type classes BMM_SIMPLE_TYPE and BMM_GENERIC_TYPE, as well as BMM_LITERAL_VALUE, which would allow such instances to be directly representable in the internal BMM type system.
 * This would still need to be ultimately mapped to the types actually available in any language in which BMM is implemented.
 * 
 * 
 * 8.6.
 * Class Definitions
 * 
 * 8.6.1.
 * BMM_LITERAL_VALUE Class
 * 
 * 8.6.2.
 * BMM_CONTAINER_VALUE Class
 * 
 * 8.6.3.
 * BMM_INDEXED_CONTAINER_VALUE Class
 * 
 * 8.6.4.
 * BMM_UNITARY_VALUE Class
 * 
 * 8.6.5.
 * BMM_PRIMITIVE_VALUE Class
 * 
 * 8.6.6.
 * BMM_STRING_VALUE Class
 * 
 * 8.6.7.
 * BMM_INTEGER_VALUE Class
 * 
 * 8.6.8.
 * BMM_BOOLEAN_VALUE Class
 * 
 * 8.6.9.
 * BMM_INTERVAL_VALUE Class
 * 
 * 
*/
bmm/literal_valuestruefalseBmmLiteralValueBmmLiteralValueBMM_LITERAL_VALUE (abstract)Meta-type for literal instance values declared in a model. Instance values may be inline values of primitive types in the usual fashion or complex objects in syntax form, e.g. JSON.BmmTypedBMM_TYPED1..1value_literal: StringA serial representation of the value.0..1value: AnyA native representation of the value, possibly derived by deserialising value_literal.0..1syntax: StringOptional specification of formalism of the value_literal attribute for complex values. Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community. If not set, json is assumed.falsefalseBmmContainerValueBmmContainerValueBMM_CONTAINER_VALUEMeta-type for literals whose concrete type is a linear container type, i.e. array, list or set.BmmLiteralValueBMM_LITERAL_VALUE1..1 (redefined)type: BMM_CONTAINER_TYPEDeclared or inferred static type of the entity.falsefalseBmmIndexedContainerValueBmmIndexedContainerValueBMM_INDEXED_CONTAINER_VALUEMeta-type for literals whose concrete type is an indexed container, i.e. Hash table, Map etc.BmmContainerValueBMM_CONTAINER_VALUE1..1 (redefined)type: BMM_INDEXED_CONTAINER_TYPEDeclared or inferred static type of the entity.truefalseBmmUnitaryValueBmmUnitaryValueBMM_UNITARY_VALUE (abstract)Meta-type for literals whose concrete type is a unitary type in the BMM sense.BmmLiteralValueBMM_LITERAL_VALUE1..1 (redefined)type: BMM_UNITARY_TYPEDeclared or inferred static type of the entity.falsefalseBmmPrimitiveValueBmmPrimitiveValueBMM_PRIMITIVE_VALUEMeta-type for literals whose concrete type is a primitive type.BmmUnitaryValueBMM_UNITARY_VALUE1..1 (redefined)type: BMM_SIMPLE_TYPEDeclared or inferred static type of the entity.falsefalseBmmStringValueBmmStringValueBMM_STRING_VALUEMeta-type for a literal String value, for which type is fixed to the BMM_TYPE representing String and value is of type String.BmmPrimitiveValueBMM_PRIMITIVE_VALUE1..1 (redefined)value: StringNative String value.falsefalseBmmIntegerValueBmmIntegerValueBMM_INTEGER_VALUEMeta-type for a literal Integer value, for which type is fixed to the BMM_TYPE representing Integer and value is of type Integer.BmmPrimitiveValueBMM_PRIMITIVE_VALUE1..1 (redefined)value: IntegerNative Integer value.falsefalseBmmBooleanValueBmmBooleanValueBMM_BOOLEAN_VALUEMeta-type for a literal Boolean value, for which type is fixed to the BMM_TYPE representing Boolean and value is of type Boolean.BmmPrimitiveValueBMM_PRIMITIVE_VALUE1..1 (redefined)value: BooleanNative Boolean value.falsefalseBmmIntervalValueBmmIntervalValueBMM_INTERVAL_VALUEMeta-type for literal intervals of type Interval<Ordered>.BmmLiteralValueBMM_LITERAL_VALUEpackage bmm/expressions;
/**
 * 
 * 
 * 9.
 * Expressions
 * 9.1.
 * Overview
 * Expressions in BMM are used to specify class invariants, routine pre- and post-conditions, and may be used more generally in other contexts requiring expressions.
 * They are defined by a set of classes prefixed by 'EL', indicating 'expression language'.
 * The BMM expression meta-model is based on the following taxonomy of expression entities:The meta-types defined in this part of the BMM model may be understood as the types of entities in an abstract syntax tree (AST) generated from expression parsing.
 * Conversely, one or more expression syntaxes may be parsed into a tree based on the model described here.
 * Note however, that whatever the variation in surface syntax, all such syntaxes parsed this way ultimately have the semantics defined by the BMM EL meta-model described here.
 * This is true even for expressions written in a syntax whose published semantics are in fact different, e.g.
 * a well-known programming language.The key abstract meta-types shown in the taxonomy are Simple (EL_SIMPLE), Complex (EL_COMPLEX) and under Simple, Terminal (EL_TERMINAL) and Predicate (EL_PREDICATE).
 * The first split between Simple and Complex distinguishes 'simple' expressions that are either Terminals or classical operator trees of Terminals, from 'complex' constructs, such as those used to represent multi-way decision structures.
 * The split between Terminal and Predicate distinguishes 'real' expression entities (the former), and meta-level predicates having a Terminal expression as a target.
 * The Predicate meta-type is the parent of 'existence' and also path-based meta-expressions targetting instance entities (such as defined by Xpath etc).The UML model of the BMM expression package, consisting of mostly direct equivalents of the taxonomy classes above, is shown below.Most EL classes are descendants of the class EL_EXPRESSION, which is characterised by the feature eval_type().
 * This is the BMM meta-type of the result type of the expression entity when used in an expression; for literals, this is the inferred type; for object references (including function calls), this is the same as the declared type, and for agents it is the meta-type BMM_SIGNATURE.
 * 
 * 
 * 
 * Figure 33.
 * Expression Taxonomy
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 34.
 * bmm.expression Package
 * 
 * 
 * 9.2.
 * Terminal Entities
 * The underlying semantic concept of expressions in BMM, as for any language, is of a construct that refers to instantiated model entities and which generates values when evaluated at execution time.
 * The notion of a reference is fundamentally different from a definition, which is the concern of the rest of the meta-model, in that it operates at the instance level rather than at the type level.
 * The primitive elements of a BMM expression may take the form of any of the following:Generally speaking, the latter two categories - function calls and delayed routine calls - will involve literal values and instance references where call arguments are stated.
 * Consequently, the value generated by an expression is founded upon literal values and instance references.
 * To be valid, any model-based reference must have a scoping object, which is one of:The notion of scoping object is supported via the attribute scope defined in EL_SCOPED_REF.In addition, one other category of primitive expression element is supported:The model described in this section supports these primitive elements via descendants of the EL_TERMINAL meta-type.
 * For ease of comprehension, the following UML diagram provides an annotated view of these meta-types.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 35.
 * bmm.expression Package - Type hierarchy
 * 9.2.1.
 * Literals
 * A literal value may appear in an expression as a separate entity within an operator expression, as well as a functional call or agent parameter.
 * The literal values that may be used are either instances of the openEHR Foundation Types in ODIN format, or a complex object instance in structured serial format, specified by BMM_SERIAL_FORMALISM if not a primitive type.
 * 9.2.2.
 * Tuples
 * Although rarely useful in class definitions, a Tuple of any degree may be formed from any combination of other EL expressions and used on its own as an expression terminal element.
 * The main use for this construct is to express a literal tuple, i.e.
 * one whose constituents consist only of proper literal values.
 * For more general uses of BMM Expressions, tuple instances are the basis of representing ad hoc query results which have a formal type such as List<[Ta, Tb, Tc]>, where [Ta, Tb, Tc] represents a tuple of three types.
 * 9.2.3.
 * Feature References
 * In BMM, a feature reference is any symbolic reference to a class feature or variable that resolves to an object at evaluation time.
 * This includes all referenceable entities within classes except procedures, which have no return value.
 * Concretely, a feature reference takes the form of one of: a property name, e.g.
 * name; a constant name, e.g.
 * pi; a variable or parameter name, e.g.
 * a_name, call_name; a function call.
 * Function calls are described in detail in the following section.
 * 9.2.4.
 * Self Reference
 * A special meta-type, EL_SELF_REF is provided for references to the current scoping object for any expressions in which it appears.
 * An instance of this meta-class corresponds to references such as 'this' or 'self' found in object-oriented programming languages.
 * 9.2.5.
 * Type Reference
 * A special meta-type, EL_TYPE_REF is provided to refer to a type as an object.
 * This is exclusively used as a convenient way (common in many programming languages) of accessing class features that do not depend on instance properties (i.e.
 * 'constant', 'enum', and 'static' members in C-based languages) without having to explicitly create an instance.
 * As an expression, a type reference will normally only appear as a qualifier of a feature reference, using syntax such as {TypeName}.feature, or with arguments, {TypeName}.function (args…​).
 * A class feature is defined as one that is: a constant; an enumeration literal; a function that does not reference any class property or make any call that does, in its body, pre_conditions or post_conditions.
 * The last category typically includes 'external' functions that are wrappers for calls to the operating system or other external resource that maintains its own state independently.
 * Since a type reference can be made without instantiation, it may be made to an abstract class as well as a concrete one.
 * This facilitates the use of so-called 'utility' classes containing groups of useful functions e.g.
 * for handling specific kinds of strings.
 * Examples of type references as qualifiers of class features include the following: {Env}.current_time to access the class function current_time defined on the class (or interface) Env; {Colours}.red, to access an enumeration literal; {Version_utils}.version_higher ("1.5.40", "11.5.4").
 * A type reference may also be used on its own, such as in the following type test, which is the EL equivalent of programming language operators like type_of().
 * admission_dates.type = {Interval<Iso8601_date_time>}.
 * 9.2.6.
 * Agents
 * An agent is the BMM term for a delayed routine call, and has the meta-type EL_AGENT, which in turn has as its formal evaluation type (eval_type) is the meta-type BMM_SIGNATURE.
 * It usually appears as a standalone expression, or else a parameter within another agent or function call.
 * Agents are described in detail in the following section.
 * 9.2.7.
 * Predicates
 * Predicates in BMM are Boolean-returning terminal expressions taking one feature reference operand, and are represented by the meta-type EL_PREDICATE.
 * Predicates conceptually apply to data instance structures and may be understood as queries on data.
 * Any number of specific predicates might be added as extensions via inheritance.
 * In particular, Xpath-style predicates could be supported by addition of meta-types descending from EL_PREDICATE.
 * The following predicates are pre-defined.
 * 9.2.7.1.
 * Attached (x) The attached predicate is used to test for an instance reference (including a function call result) being Void.
 * It may be used in expressions such as the following class invariant.
 * class SmartRef { property url: Url; property value: Base64String; invariant Validity: attached(url) or attached(value) } 9.2.7.2.
 * Defined (x) The defined predicate is used to test whether an instance that is mapped to an external data access method exists in the data context (regardless of its value there).
 * TBD: this might be replaced by another approach.
 * 9.3.
 * Constrained Expressions
 * In some cases there is a need to define a constrained form of an existing expression meta-type, such that the constraint can be conveniently asserted in other contexts.
 * The meta-class EL_CONSTRAINED is provided for this purpose.
 * It has an attribute base_expression referring to the underlying expression meta-type to be constrained.
 * Any descendant of EL_CONSTRAINED may then be defined in order to add specific type or other constraints.
 * One commonly used meta-type, EL_BOOLEAN_EXPRESSION, is defined, which constrains the base expression to being one whose evaluation type (eval_type) is Boolean.
 * 
 * 
 * 9.4.
 * Operator Expressions
 * BMM contains meta-types representing operators, but assumes that all operators are surface aliases for functions defined on some class.
 * For this reason, an occurrence of an operator within an expression, represented an instance of a descendant of EL_OPERATOR, contains the attribute definition to refer to the corresponding function definition.
 * This has to be inferred from the types of its operands.
 * Consequently, 'operator expressions' as commonly understood are simply function calls (often nested) in BMM.
 * The following example illustrates the general meta-model of expressions, using a typical use of expression, the class invariant.The expression balance + overdraft_limit > 0 makes use of two operators + and `>, which are really functions defined on the type Decimal, as follows.A parser processing this expression would produce the result shown below, assuming that the BMM model containing these classes had already been instantiated.Below, we consider a number of examples illustrating expressions containing the various kinds of terminal reference, based on the following assumed declarations.The first example is a comparison of a property value to a value, where the >= operator maps to the function Real.greater_than_or_equal()The following shows the comparison of a property value with a constant, where the >= operator maps to the function Real.greater_than_or_equal()The following is a logical condition, where the = operator maps to a function such as Terminology_code.equal(); and maps to Boolean.and(); and >= maps to Real.greater_than_or_equal().The following is the same logical condition, but with the use of object scope specified with 'dot notation', here 'patient.'.The following shows a function call whose argument is an expression.The following shows the use of an inline agent as an argument to the function List.for_all().
 * 
 * 
 * 
 * class Account { feature balance: Decimal overdraft_limit: Decimal invariant balance + overdraft_limit > 0 }
 * 
 * 
 * 
 * class Decimal { feature greater_than (other: Decimal): Boolean alias '>' addition: (other: Decimal): Decimal alias '+' }
 * 
 * 
 * 
 * Figure 36.
 * Instantiated Operator Expression
 * 
 * 
 * 
 * feature -- Definitions Fast_resting_heart_rate: Real = 100; Atrial_fibrillation_heart_rate: Real = 120; Erratic: Terminology_code = { "terminology_id": "snomed_ct", "code_string": "286761003" } Blood_pressure_units: String = "mm[Hg]"; feature -- Accessors heart_rate: Real; heart_rhythm: Terminology_code; bp_samples: List<Quantity>; patient: Patient;
 * 
 * 
 * 
 * heart_rate >= 80
 * 
 * 
 * 
 * heart_rate >= Fast_resting_heart_rate
 * 
 * 
 * 
 * heart_rhythm = Erratic and heart_rate >= Atrial_fibrillation_heart_rate
 * 
 * 
 * 
 * patient.heart_rhythm = Erratic and patient.heart_rate >= Atrial_fibrillation_heart_rate
 * 
 * 
 * 
 * date_of_birth.earlier ({Env}.current_date - P10Y)
 * 
 * 
 * 
 * bp_samples.for_all ( agent (a_quantity: Quantity) { a_quantity.units.is_equal (Blood_pressure_units); } );
 * 9.5.
 * Decision Tables
 * The BMM expression package contains the meta-class EL_DECISION_TABLE that defines an abstract decision table construct, consisting of an ordered set of items, each of type EL_DECISION_BRANCH, and having a result of any expression type (including another decision table).
 * Two concrete subtypes of each of these abstract meta-types are used to represent two common kinds of decision table:The else branch will be used to provide the result expression in the case that all other branches fail, guaranteeing a result.EL_DECISION_TABLE and its descendants are also kind of expression, enabling them to be used as value-returning entities in certain other expression contexts, including inside other decision tables.The following UML illustrates.The logic of a EL_CONDITION_CHAIN is the same as an if/then/elseif/else chain in procedural programming, except that instead of assignment statements on each branch, pure result expressions are used.
 * This enables a more sophisticated syntactic rendering, resembling a table, such as the following:The above is a function that computes the molecular subtype of breast cancer using a decision table whose branches are based on a number of input variables that appear in expressions down the left-hand side and which returns a Terminology_code instance (the notation [identifier] is represents a literal Terminology_code instance).An example of EL_CASE_TABLE is shown below.
 * Here, two case tables are used, with each generating a numeric result based on the values of the platelets and gfr variables respectively.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 37.
 * bmm.expression Decision Table
 * 
 * 
 * 
 * molecular_subtype: Terminology_term Result := [[ ========================================================= er_positive and her2_negative and not ki67.in_range ([high]): [luminal_A], --------------------------------------------------------- er_positive and her2_negative and ki67.in_range ([high]): [luminal_B_HER2_negative], --------------------------------------------------------- er_positive and her2_positive: [luminal_B_HER2_positive], --------------------------------------------------------- er_negative and pr_negative and her2_positive and ki67.in_range ([high]): [HER2], --------------------------------------------------------- er_negative and pr_negative and her2_negative and ki67.in_range ([high]): [triple_negative], --------------------------------------------------------- *: [none] ========================================================= ]]
 * 
 * 
 * 
 * 
 * 
 * cyclophosphamide_dose: Quantity Result := cyclophosphamide_dose_per_m2 * BSA.bsa_m2 * case platelets.range in [[ =================== [normal]: 1, [low]: 0.75 =================== ]] * case gfr.range in [[ =================== [normal]: 1, [low]: 0.75, [very_low]: 0.5 =================== ]]
 * 9.6.
 * Usage in BMM Models
 * Expressions as used in BMM models to express class invariants and routine pre- and post-conditions are always in the form of an BMM_ASSERTION, i.e.
 * a tagged Boolean-returning EL_EXPRESSION.
 * 
 * 
 * 9.6.1.
 * Simple Assertions
 * Simple assertions may be formed from common operators and operands, including the usual logical arithmetic and comparison operators, as well as any operators relating to specific data types.
 * Normally the top-level operator in the Expression graph is a logical or relational operator.
 * Since all operators are mapped to functions defined on types, there are no 'floating' or 'built-in' operators as such.
 * 9.6.2.
 * Existential and Universal Quantifier Invariants
 * A common kind of expression used in class invariants operates over collections and uses the existential and universal quantifier operators, i.e.
 * ∃ and ∀, from predicate logic.
 * A typical expression to use within a class invariant is shown below in an abstract syntax.
 * class PersonName { property items: String[1..*]; invariant ∀ nameItem: items | not nameItem.isEmpty() } A different syntax might express it as follows.
 * invariant for nameItem in items all not nameItem.isEmpty() end A similar invariant, this time using ∃, is shown below.
 * invariant for nameItem in items ∃ not nameItem.isEmpty() Regardless of the surface syntax, expressions such as the above map to functions such as for_all and there_exists defined on relevant linear container types.
 * These functions have the following signatures in which the 'test' expression appears as a Function agent type.
 * class Container<T> { for_all (test: Function<[T], Boolean>): Boolean; -- True if for every v in container, test (v) is True there_exists (test: Function<[T], Boolean>): Boolean; -- True if there is any v in container for which test (v) is True }
 * 9.7.
 * Class Definitions
 * 
 * 9.7.1.
 * EL_EXPRESSION Class
 * 
 * 9.7.2.
 * EL_BOOLEAN_EXPRESSION Class
 * 
 * 9.7.3.
 * EL_OPERATOR Class
 * 
 * 9.7.4.
 * EL_UNARY_OPERATOR Class
 * 
 * 9.7.5.
 * EL_BINARY_OPERATOR Class
 * 
 * 9.7.6.
 * EL_SIMPLE Class
 * 
 * 9.7.7.
 * EL_TERMINAL Class
 * 
 * 9.7.8.
 * EL_PREDICATE Class
 * 
 * 9.7.9.
 * EL_DEFINED Class
 * 
 * 9.7.10.
 * EL_ATTACHED Class
 * 
 * 9.7.11.
 * EL_INSTANCE_REF Class
 * 
 * 9.7.12.
 * EL_SELF_REF Class
 * 
 * 9.7.13.
 * EL_TYPE_REF Class
 * 
 * 9.7.14.
 * EL_LITERAL Class
 * 
 * 9.7.15.
 * EL_SCOPED_REF Class
 * 
 * 9.7.16.
 * EL_INSTANTIABLE_REF Class
 * 
 * 9.7.17.
 * EL_AGENT_CALL Class
 * 
 * 9.7.18.
 * EL_FUNCTION_CALL Class
 * 
 * 9.7.19.
 * EL_AGENT Class
 * 
 * 9.7.20.
 * EL_FUNCTION_AGENT Class
 * 
 * 9.7.21.
 * EL_PROCEDURE_AGENT Class
 * 
 * 9.7.22.
 * EL_TUPLE Class
 * 
 * 9.7.23.
 * EL_TUPLE_ITEM Class
 * 
 * 9.7.24.
 * EL_DECISION_TABLE Class
 * 
 * 9.7.25.
 * EL_DECISION_BRANCH Class
 * 
 * 9.7.26.
 * EL_CONDITION_CHAIN Class
 * 
 * 9.7.27.
 * EL_CONDITIONAL_EXPRESSION Class
 * 
 * 9.7.28.
 * EL_CASE_TABLE Class
 * 
 * 9.7.29.
 * EL_CASE Class
 * 
 * 
*/
bmm/expressionstruefalseElExpressionElExpressionEL_EXPRESSION (abstract)Abstract parent of all typed expression meta-types.1..1 (abstract)eval_type (): BMM_TYPEMeta-type of expression entity used in type-checking and evaluation. Effected in descendants.1..1is_boolean (): Boolean Post_result: Result = eval_type().equal( {BMM_MODEL}.boolean_type_definition())True if eval_type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = Boolean).falsefalseElBooleanExpressionElBooleanExpressionEL_BOOLEAN_EXPRESSIONBoolean-returning expression.ElConstrainedEL_CONSTRAINEDtruefalseElOperatorElOperatorEL_OPERATOR (abstract)Abstract parent of operator types.ElSimpleEL_SIMPLE0..1precedence_overridden: BooleanTrue if the natural precedence of operators is overridden in the expression represented by this node of the expression tree. If True, parentheses should be introduced around the totality of the syntax expression corresponding to this operator node and its operands.0..1symbol: StringThe symbol actually used in the expression, or intended to be used for serialisation. Must be a member of OPERATOR_DEF.symbols.1..1definition: BMM_FUNCTIONFunction equivalent to this operator, inferred by matching operator against functions defined in interface of principal operand.1..1operator_definition (): BMM_OPERATOROperator definition derived from definition.operator_definition().1..1equivalent_call (): EL_FUNCTION_CALLFunction call equivalent to this operator.falsefalseElUnaryOperatorElUnaryOperatorEL_UNARY_OPERATORUnary operator expression node.ElOperatorEL_OPERATOR1..1operand: EL_SIMPLEOperand node.falsefalseElBinaryOperatorElBinaryOperatorEL_BINARY_OPERATORBinary operator expression node.ElOperatorEL_OPERATOR1..1left_operand: EL_SIMPLELeft operand node.1..1right_operand: EL_TERMINALRight operand node.truefalseElSimpleElSimpleEL_SIMPLE (abstract)Simple expression type that may be used in other simple expressions.ElExpressionEL_EXPRESSIONtruefalseElTerminalElTerminalEL_TERMINAL (abstract)Expression terminal entity, representing one of: a reference to a literal value of any type; a reference to an instance of any instantiable type, i.e. variable, property or constant; an agent, i.e. a delayed function call; a function call.ElSimpleEL_SIMPLEtruefalseElPredicateElPredicateEL_PREDICATE (abstract)Parent type of predicate of any object reference.ElTerminalEL_TERMINAL1..1operand: EL_INSTANCE_REFThe target instance of this predicate.1..1 (effected)eval_type (): BMM_SIMPLE_TYPEReturn {BMM_MODEL}.boolean_type_definition().falsefalseElDefinedElDefinedEL_DEFINEDA predicate taking one external variable reference argument, that returns true if the reference is resolvable, i.e. the external value is obtainable. Note probably to be removed.ElPredicateEL_PREDICATEfalsefalseElAttachedElAttachedEL_ATTACHEDA predicate on any object reference (including function call) that returns True if the reference is attached, i.e. non-Void.ElPredicateEL_PREDICATEtruefalseElInstanceRefElInstanceRefEL_INSTANCE_REF (abstract)A reference to an instance of any kind.ElTerminalEL_TERMINALfalsefalseElSelfRefElSelfRefEL_SELF_REFSpecial meta-type used to represent a reference that may appear in any routine, pre- or post-condition, or invariant, and resolves to the current object within which feature references are scoped; corresponds to 'self', 'this' or 'Current' in various programming languages.ElInstanceRefEL_INSTANCE_REF1..1type: BMM_TYPEType of the current scoping instance, inferred from expression context.1..1 (effected)eval_type (): BMM_TYPEReturn type.falsefalseElTypeRefElTypeRefEL_TYPE_REFMeta-type for reference to a non-abstract type as an object. Assumed to be accessible at run-time. Typically represented syntactically as TypeName or {TypeName}. May be used as a value, or as the qualifier for a function or constant access.ElInstanceRefEL_INSTANCE_REF1..1type: BMM_TYPEType, directly from the name of the reference, e.g. {SOME_TYPE}.1..1 (effected)eval_type (): BMM_TYPEReturn type.falsefalseElLiteralElLiteralEL_LITERALLiteral value of any type known in the model, including primitive types. Defined via a BMM_LITERAL_VALUE.ElInstanceRefEL_INSTANCE_REF1..1value: BMM_LITERAL_VALUEThe reference item from which the value of this node can be computed.1..1 (effected)eval_type (): BMM_TYPEReturn value.type.truefalseElScopedRefElScopedRefEL_SCOPED_REF (abstract)A reference that is scoped by a containing entity and requires a context qualifier if it is not the currently scoping entity.ElInstanceRefEL_INSTANCE_REF0..1scope: EL_INSTANCE_REFReference to an owning object for this terminal element, if it is not the current scope.falsefalseElInstantiableRef<t>ElInstantiableRefEL_INSTANTIABLE_REF<T>Terminal item corresponding to a reference to a directly instantiable entity, i.e. a variable, constant, or property.ElScopedRefEL_SCOPED_REF0..1definition: TDefinition of the constant, property or variable, inferred by inspection of the current scoping instance.1..1 (effected)eval_type (): BMM_TYPEType definition (i.e. BMM meta-type definition object) of the constant, property or variable, inferred by inspection of the current scoping instance. Return definition.type.truefalseElAgentCallElAgentCallEL_AGENT_CALL (abstract)A call made to a 'closed' agent, i.e. one with no remaining open arguments.1..1agent: EL_AGENTThe agent being called.falsefalseElFunctionCallElFunctionCallEL_FUNCTION_CALLA call made on a closed function agent, returning a result. Equivalent to an 'application' of a function in Lambda calculus.ElScopedRefEL_SCOPED_REFElAgentCallEL_AGENT_CALL1..1 (redefined)agent: EL_FUNCTION_AGENTThe function agent being called.1..1 (effected)eval_type (): BMM_TYPEReturn agent.definition.type.truefalseElAgentElAgentEL_AGENT (abstract)A delayed routine call, whose arguments may be open, partially closed or closed. Instances may include closed delayed calls like calculate_age (dob="1987-09-13", today="2019-06-03") but also partially open calls such as format_structure (struct=?, style=3), where struct is an open argument. Evaluation type (i.e. type of runtime evaluated form) is BMM_SIGNATURE.ElScopedRefEL_SCOPED_REF1..1name: StringName of the routine being called.0..1closed_args: EL_TUPLEClosed arguments of a routine call as a tuple of objects.0..1open_args: List<String>Optional list of names of open arguments of the call. If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.0..1definition: BMM_ROUTINEReference to definition of a routine for which this is an agent, if one exists.1..1 (effected)eval_type (): BMM_SIGNATURE Post_result: Result = definition.signatureEval type is the signature corresponding to the (remaining) open arguments and return type, if any.1..1is_callable (): Boolean Post_result_validity: Result = open_arguments = VoidTrue if there are no open arguments.falsefalseElFunctionAgentElFunctionAgentEL_FUNCTION_AGENTAn agent whose signature is of a function, i.e. has a result type.ElAgentEL_AGENT0..1 (redefined)definition: BMM_FUNCTIONReference to definition of a routine for which this is a direct call instance, if one exists.falsefalseElProcedureAgentElProcedureAgentEL_PROCEDURE_AGENTAn agent whose signature is of a procedure, i.e. has no result type.ElAgentEL_AGENT0..1 (redefined)definition: BMM_PROCEDUREReference to definition of routine for which this is a call instance.falsefalseElTupleElTupleEL_TUPLEDefines an array of optionally named items each of any type.ElInstanceRefEL_INSTANCE_REF0..1items: List<EL_TUPLE_ITEM>Items in the tuple, potentially with names. Typical use is to represent an argument list to routine call.1..1type: BMM_TUPLE_TYPEStatic type inferred from literal value.1..1 (effected)eval_type (): BMM_TYPEReturn type.falsefalseElTupleItemElTupleItemEL_TUPLE_ITEMA single tuple item, with an optional name.0..1item: EL_EXPRESSIONReference to value entity. If Void, this indicates that the item in this position is Void, e.g. within a routine call parameter list.0..1name: StringOptional name of tuple item.truefalseElDecisionTableElDecisionTableEL_DECISION_TABLE (abstract)Complex expression structure representing a logical decision table.ElExpressionEL_EXPRESSION1..1else: EL_EXPRESSIONResult expression of the chain if no member of items succeeds in evaluation.1..1items: List<EL_DECISION_BRANCH>Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.truefalseElDecisionBranchElDecisionBranchEL_DECISION_BRANCH (abstract)1..1result: EL_EXPRESSIONResult expression of conditional, if its condition evaluates to True.falsefalseElConditionChainElConditionChainEL_CONDITION_CHAINCompound expression consisting of a chain of condition-gated expressions, and an ungated else member that as a whole, represents an if/then/elseif/else chains. Evaluated by iterating through items and for each one, evaluating its condition, which if True, causes the evaluation result of the chain to be that item’s result evaluation result. If no member of items has a True-returning condition, the evaluation result is the result of evaluating the else expression.ElDecisionTableEL_DECISION_TABLE1..1 (redefined)items: List<EL_CONDITIONAL_EXPRESSION>Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.falsefalseElConditionalExpressionElConditionalExpressionEL_CONDITIONAL_EXPRESSIONConditional structure used in condition chain expressions. Evaluated by evaluating its condition, which is a Boolean-returning expression, and if this returns True, the result is the evaluation result of expression.ElDecisionBranchEL_DECISION_BRANCH1..1condition: EL_SIMPLEGate expression that acts as the condition under which the target expression is returned.falsefalseElCaseTableElCaseTableEL_CASE_TABLECompound expression consisting of a list of value-range / expression pairs, and an else member that as a whole, represents a case statement flavour of decision table. Evaluated by iterating through items and for each one, comparing input to the item value_range. If the input is in the range, the evaluation result of the table is that item’s result evaluation result. If no member of items has a True-returning condition, the evaluation result is the result of evaluating the else expression.ElDecisionTableEL_DECISION_TABLE1..1input: EL_SIMPLEInput value that is compared against each items[i].value_range to determine the overall result.1..1 (redefined)items: List<EL_CASE>Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.falsefalseElCaseElCaseEL_CASEElDecisionBranchEL_DECISION_BRANCH1..1value_constraint: C_OBJECTpackage bmm/functional_elements;
/**
 * 
 * 
 * 10.
 * Functional Elements
 * 10.1.
 * Overview
 * BMM provides support for representing functional entities, often known as lambdas.
 * The two key functional entities are known in the calculus as a lambda term and an application.
 * The first is more commonly understood by programmers as a delayed routine call, here denoted by the term agent.
 * The latter is what programmers understand as a 'call', i.e.
 * an application of a lambda term.An agent is formed by reference to a function or procedure in an expression context, potentially with provision of some or all arguments.
 * This creates an entity whose type is an instance of the meta-type BMM_SIGNATURE.
 * There are three variations as follows:A call is thus an invocation of a closed agent.
 * The evaluation type of a function call is the result type of the original function definition, thus its meta-type is just BMM_TYPE.
 * A procedure call has no evaluation type.Both calls and agents are special kinds of references to their original routines, and both can appear within an expression context, including as arguments passed to routine invocations.
 * The following UML view of the bmm.expression package illustrates these details.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 38.
 * bmm.expression package - Functional Elements
 * 10.2.
 * Agents
 * In the model the three classes EL_AGENT, EL_FUNCTION_AGENT, and EL_PROCEDURE_AGENT (centre) define respectively, Agent and its Function and Procedure forms.
 * An Agent is understood as one kind of terminal expression element (EL_TERMINAL), since it is concretely a reference that generates a value, in this case, to a routine that generates a delayed call object.
 * It potentially has closed_args, in the form of an EL_TUPLE which is a meta-type for tuple instances, which instantiate an instance BMM_TUPLE_TYPE (such as [String, Integer]).
 * The items of the tuple are each in the form of an EL_TUPLE_ITEM consisting of the argument name (optional) and an item, which is an EL_EXPRESSION, having an eval_type of BMM_TYPE.
 * By this means, the actual arguments to a routine call may be any expression, including operators, and (as shown), terminal expressions.
 * This includes other agent expressions, and also function calls (but not procedure calls, since they are not value-generating entities).An example of a delayed function call in syntax form is nodeCount (struct=?, depth=3) (the exact syntax will vary according to programming language).
 * Here, the struct argument is left open, while the depth argument is closed with the supplied value 3.
 * This expression generates an agent whose signature is [StructType]:Integer (assuming the concrete type of the struct argument is StructType).
 * This capability is known as function currying and is the basis for enabling delayed routine calls to have their arguments progressively filled before final execution, each time generating a new agent with a reduced signature.
 * 
 * 
 * 
 * 
 * 10.3.
 * Calls
 * On the left of the UML diagram is the meta-class EL_FUNCTION_CALL, which represents a call to a function Agent, and which is also an EL_TERMINAL.
 * For such a call to be possible, all arguments must be supplied (which may be none, in the case of a parameterless function).An example of a Function Call is calculateAge ('1982-03-22', '2019-06-01'), which calculates a person’s age from his date of birth and a given date.
 * In normal programming languages, any of the parameters may be any referenceable value-returning entity, i.e.
 * any in-scope variable, other function call, or a valid operator expression, e.g.
 * calculateAge ('1982-03-22', today()), where today() is a function returning the date of today.Such calls are direct equivalents for expressions using basic mathematical operators and functions, on the usual basis that any operator (such as 'plus', i.e.
 * +) is formally defined as a function such as add (arg1, arg2: Numeric): Numeric.The instance structure for a typical expression such as the Body Mass Index (BMI), i.e.
 * weight / height^2, is shown below.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 39.
 * Function call example - Body Mass index (BMI)
 * 
*/
bmm/functional_elementspackage bmm/statements;
/**
 * 
 * 
 * 11.
 * Statements
 * 11.1.
 * Overview
 * BMM provides meta-model elements for defining the body of a routine, consisting of statements.
 * This facility is not needed for achieving the original purpose of BMM, i.e.
 * a computable in-memory representation of a model at the interface level (classes, types and signatures), rather it provides a basis for representing program logic, such as function definitions.BMM statements are formalised using the classes BMM_STATEMENT_ITEM, BMM_STATEMENT_BLOCK and BMM_STATEMENT and various recognisable descendant types, as shown in the UML view below.The use of the three-class hierarchy pattern allows a Routine body to be a simple statement or a block, containing statements and/or more blocks.
 * The class BMM_STATEMENT is abstract, allowing specific statement meta-models to be developed whose 'statement' meta-types inherit from this class.
 * A number of common types are included by default, and are described below.This facility is primarily provided to support the definition of higher-level languages by embedding them in the outer BMM meta-model.
 * 
 * 
 * 
 * 
 * 
 * Figure 40.
 * Features for routine definition
 * 
 * 
 * 
 * 
 * 11.2.
 * Assignment
 * A BMM assignment is the same concept as found in most frame-based programming languages, and provides a meta-model to represent a writable target (variable or property) being assigned to from a source, which is any expression of the same evaluation type.
 * Type checking is thus based on a comparison of definition.type of the target and eval_type() of the source.The following example shows a simple assignment in the definition of the function position.The BMM meta-model for this statement is shown below.
 * 
 * 
 * 
 * 
 * 
 * class Simple_bank_account { feature // Definitions overdraft_limit: Decimal = 250; feature // State balance: Decimal; feature // Interface position: Decimal { Result := balance + overdraft_limit } invariant Solvent: position >= 0.0 }
 * 
 * 
 * 
 * Figure 41.
 * Assignment to function Result
 * 11.3.
 * Procedure Call
 * A procedure call is represented in BMM by the meta-type BMM_PROCEDURE_CALL, which refers to an instance of EL_PROCEDURE_AGENT, the same way that a function call is represented in terms of an EL_FUNCTION_AGENT.
 * In the following example, the procedure put() is called from the deposit() and withdraw() functions in the class Account_access.The BMM meta-model for the call is shown below.
 * 
 * 
 * 
 * class Simple_bank_account { feature // Modification put (val: Decimal) precondition valid_amount: val + overdraft_limit >= 0.0 { balance := balance + val } } class Account_access { feature // Command deposit (v: Decimal; ac: Simple_bank_account) pre_condition valid_amount: v > 0.0 { ac.put (v); } withdraw (v: Decimal; ac: Simple_bank_account) pre_condition valid_amount: ac.overdraft_limit - v >= 0.0 { ac.put (-v); } }
 * 
 * 
 * 
 * Figure 42.
 * Procedure call
 * 11.4.
 * Action Tables
 * The BMM statement package includes the meta-classes BMM_ACTION_TABLE and BMM_CONDITIONAL_ACTION, which together provide a way of representing a decision table whose outputs are statements (rather than values, as in the case of the related Expression meta-classes EL_DECISION_TABLE and EL_CONDITIONAL_EXPRESSION).
 * An action table corresponds closely to the standard constructs 'if/then/elseif' and the case statement.The following example shows a typical instance of the BMM Action table meta-type, within a procedure that generates appropriate alerts or alarms based on patient vital signs.
 * 
 * 
 * 
 * 
 * 
 * check_vital_signs if systolic_pressure.in_range ([critical_high]) raise_alarm ([emergency]) elseif systolic_pressure.in_range ([high]) and oxygen_sat.in_range([low]) call_staff
 * 11.5.
 * Assertions
 * The BMM statement model includes a statement meta-type to represent the notion of an assertion as a statement, typically expressed in syntax such as assert (<boolean expression>).
 * This kind of statement is understood as an executable instruction to check that the condition is true, and if not, to generate an exception of the appropriate type, assuming exceptions are available.
 * 
 * 
 * 11.6.
 * Class Definitions
 * 
 * 11.6.1.
 * BMM_STATEMENT_ITEM Class
 * 
 * 11.6.2.
 * BMM_STATEMENT_BLOCK Class
 * 
 * 11.6.3.
 * BMM_STATEMENT Class
 * 
 * 11.6.4.
 * BMM_PROCEDURE_CALL Class
 * 
 * 11.6.5.
 * BMM_ASSIGNMENT Class
 * 
 * 11.6.6.
 * BMM_ASSERTION Class
 * 
 * 11.6.7.
 * BMM_ACTION_TABLE Class
 * 
 * 11.6.8.
 * BMM_CONDITIONAL_ACTION Class
 * 
 * 
*/
bmm/statementstruefalseBmmStatementItemBmmStatementItemBMM_STATEMENT_ITEM (abstract)Abstract parent of statement types representing a locally defined routine body.BmmRoutineBodyBMM_ROUTINE_BODYfalsefalseBmmStatementBlockBmmStatementBlockBMM_STATEMENT_BLOCKA statement 'block' corresponding to the programming language concept of the same name. May be used to establish scope in specific languages.BmmStatementItemBMM_STATEMENT_ITEM0..1items: List<BMM_STATEMENT_ITEM>Child blocks of the current block.truefalseBmmStatementBmmStatementBMM_STATEMENT (abstract)Abstract parent of 'statement' types that may be defined to implement BMM Routines.BmmStatementItemBMM_STATEMENT_ITEMfalsefalseBmmProcedureCallBmmProcedureCallBMM_PROCEDURE_CALLA call made on a closed procedure agent.ElAgentCallEL_AGENT_CALLBmmStatementBMM_STATEMENT1..1 (redefined)agent: EL_PROCEDURE_AGENTThe procedure agent being called.falsefalseBmmAssignmentBmmAssignmentBMM_ASSIGNMENTStatement type representing an assignment from a value-generating source to a writable entity, i.e. a variable reference or property.BmmStatementBMM_STATEMENT1..1target: EL_INSTANTIABLE_REFThe target variable on the notional left-hand side of this assignment.1..1source: EL_EXPRESSIONSource right hand side) of the assignment.falsefalseBmmAssertionBmmAssertionBMM_ASSERTIONA statement that asserts the truth of its expression. If not, generates an exception (depending on run-time settings). May be rendered in syntax as assert condition or similar.BmmStatementBMM_STATEMENT1..1expression: EL_BOOLEAN_EXPRESSION0..1tag: StringOptional tag, typically used to designate design intention of the assertion, e.g. "Inv_all_members_valid".falsefalseBmmActionTableBmmActionTableBMM_ACTION_TABLEMulti-branch conditional statement structureBmmStatementBMM_STATEMENT1..1items: List<BMM_CONDITIONAL_ACTION>Decision branches.falsefalseBmmConditionalActionBmmConditionalActionBMM_CONDITIONAL_ACTIONConditional, or 'gated' statement, consisting of a Boolean-returning condition and the target statement.1..1condition: EL_BOOLEAN_EXPRESSIONThe gate condition for the target statement.1..1statement: BMM_STATEMENT_ITEMTarget statement.package bmm/model_semantics_2;
/**
 * 
 * 
 * 12.
 * Model Semantics
 * 
 * 
 * 12.1.
 * Inheritance
 * 
 * 12.1.1.
 * Simple Inheritance
 * The BMM supports single and multiple inheritance, although it does not distinguish between different types of inheritance relation as some programming languages do.
 * Inheritance is formally defined to be between a class definition (an instance of BMM_CLASS) and a defined type, i.e.
 * a BMM_SIMPLE_TYPE or BMM_GENERIC_TYPE.
 * This is because the inheritance parents of a class may be any of: a simple class; a generic class; a class type, i.e.
 * the effective class definition corresponding to an effective generic type, which has one or more formal parameters substituted.
 * The general case for all three is represented by the corresponding type, i.e., a simple type or generic type.
 * The evaluation of inheritance relations defined in a BMM model results in an acyclic graph such that ancestors and descendants can be visualised for any class.
 * The following screen shot shows the ancestors view of a class OBSERVATION.
 * Figure 43.
 * BMM class - ancestors view The next screenshot shows the descendants view of one of the ancestor classes of the same class.
 * Figure 44.
 * BMM class - descendants view
 * 12.1.2.
 * Generic Inheritance
 * Inheritance between generic classes works in the same way as for simple classes, with the additional semantics of formal parameter inheritance, which are as follows: each unsubstituted formal parameter of the parent type must have a same-named counterpart in the formal parameters of the inheriting class; the formal parameters of the inheriting class may further constrain any of the ancestor type’s formal parameters.
 * The following example shows the class DV_INTERVAL<T:DV_ORDERED> inheriting from Interval<T:Ordered>.
 * Here the number of open generic parameters remains unchanged, while the type constraint Ordered is covariantly narrowed to DV_ORDERED, which inherits from the Ordered type.
 * Figure 45.
 * Generic inheritance, constraint-narrowing The resulting types of lower and upper are now T:DV_ORDERED rather than T:Ordered from the parent.
 * In the fully computed model shown above, these two properties are synthesised within DV_INTERVAL<T> with their new concrete types.
 * Their BMM meta-type objects (type BMM_UNITARY_PROPERTY) will both have the meta-attribute is_synthesised_generic set to True and are marked with an asterisk within the property view to indicate this.
 * A simple class may also inherit from a closed generic type, with the parameters of the latter fixed to specific type(s), as shown in the following example.
 * Figure 46.
 * Generic inheritance, closed In this case, The resulting type of event is TIMER_EVENT rather than T:EVENT from the parent.
 * As in the previous example, this property has been synthesised new within TIMER_WAIT, with the meta-attribute is_synthesised_generic set True and is marked accordingly within the tool.
 * The general case is that any number of formal generic parameters may be substituted or left open down the inheritance lineage, as shown by the variant descendants of the class GENERIC_PARENT<T:SUPPLIER, U:SUPPLIER> in the following example.
 * Figure 47.
 * Generic inheritance, mixed open and closed Generic substitution may be with other open, closed or partly-closed generic types.
 * The following example illustrates the inheritance by X_VERSIONED_COMPOSITION of X_VERSIONED_COMPOSITION<ORIGINAL_VERSION<COMPOSITION>>.
 * Figure 48.
 * Generic inheritance, open parameter
 * 12.1.3.
 * Multiple Inheritance
 * Multiple inheritance is typically used in the definition of classes that have a Liskov substitution inheritance relation as well as a re-use inheritance relation.
 * The following shows a class DV_INTERVAL<T> multiply inheriting from Interval<T> and DATA_VALUE, where the latter is considered the substitutable type, and the former an interface re-use.
 * Figure 49.
 * Multiple inheritance
 * 12.1.4.
 * Inheritance and Invariants, Pre-conditions and Post-conditions
 * TBD
 * 
*/
bmm/model_semantics_2package bmm/bmm_extensions;
/**
 * 
 * 
 * 13.
 * BMM Extensions
 * 13.1.
 * Overview
 * 
 * 13.2.
 * General Extensions
 * 
 * 13.3.
 * Feature Extensions
 * 
 * 
*/
bmm/bmm_extensionspackage bmm/references;
/**
 * 
 * 
 * References
 * 
 * 
 * 
 * 
 * 
 * 
 * 
*/
bmm/referencespackage nl/rosa/semanticdatabase/bmm_persistence;

/**
 * 
 * Title: BMM Persistence Model and Syntax
 * 
 * Java generated from OpenEhr-html to Java by XSLT (Bert Verhees)
 * From BMM-document:
 * 
 * 2.3.0:SPECLANG-2.
 * Add Basic Meta-Model (BMM) spec to BASE component.:openEHR SEC:04 Sep 2019
bmm_persistencepackage bmm_persistence/amendment_record;
/**
 * 
 * 
 * Amendment Record
 * 
*/
bmm_persistence/amendment_recordpackage bmm_persistence/acknowledgements;
/**
 * 
 * 
 * Acknowledgements
 * Primary Author
 * 
 * 
 * 
 * Contributors
 * This specification has benefited from formal and informal input from the openEHR and wider health informatics community.
 * The openEHR Foundation would like to recognise the following people for their contributions.
 * 
 * 
 * 
 * 
 * Trademarks
 * 
 * 
 * 
 * 
*/
bmm_persistence/acknowledgementspackage bmm_persistence/preface;
/**
 * 
 * 
 * 1.
 * Preface
 * 1.1.
 * Purpose
 * This document describes a persistence model for the Basic Meta-Model (BMM) known as P_BMM, that may be used as a basis for serialisation of BMM models.
 * It may be considered as an approximate replacement for the UML XMI for data-only models.
 * It is human-readable and writable, and supports generic types (open and closed), container types, and multiple inheritance.
 * 
 * 
 * 1.2.
 * Status
 * This specification is in the STABLE state.
 * The development version of this document can be found at https://specifications.openehr.org/releases/LANG/latest/bmm_persistence.html.Known omissions or questions are indicated in the text with a 'to be determined' paragraph, as follows:TBD: (example To Be Determined paragraph)
 * 
 * 
 * 
 * 
 * 
 * 
 * 1.3.
 * Feedback
 * Feedback may be provided on the openEHR languages specifications forum.Issues may be raised on the specifications Problem Report tracker.To see changes made due to previously reported issues, see the LANG component Change Request tracker.
 * 
 * 
 * 
 * 
 * 
 * 
 * 1.4.
 * Conformance
 * Conformance of a data or software artifact to an openEHR specification is determined by a formal test of that artifact against the relevant openEHR Implementation Technology Specification(s) (ITSs), such as an IDL interface or an XML-schema.
 * Since ITSs are formal derivations from underlying models, ITS conformance indicates model conformance.
 * 
 * 
 * 1.5.
 * Tooling
 * The openEHR ADL Workbench (AWB) fully implements this specification, and provide a convenient way of illustrating BMM semantics.
 * The screenshots used in this specification are all from the ADL Workbench.
 * The tool is written in the Eiffel language, and is available as open source on Github.
 * The BMM libraries can be found in the EOMF Github repository.A modelling tool known as Archie implements BMM in Java, and can be found in the openEHR Github area.
 * 
 * 
 * 
 * 
 * 
*/
bmm_persistence/prefacepackage bmm_persistence/overview;
/**
 * 
 * 
 * 2.
 * Overview
 * 2.1.
 * Conceptual Approach
 * This specification defines a model that may be used as the basis for a serial format for the Basic Meta-Model (BMM).
 * The formalism described here is an adaptation of pure object serialisation approaches used in mainstream programming languages.
 * Instead of directly materialising a BMM instance graph from serial form, the initial materialised form is a graph of P_BMM_XXX classes, with a subsequent in-memory model-to-model transform step required to produce a materialised BMM model.The P_BMM_* classes perform two functions.
 * Firstly, they are a modified and simplified version of the BMM_* classes that enable for example symbolic referencing via class names, syntactical type names to be used etc, rather than the full explosion of fine-grained objects that would result from a direct serialisation of BMM_* classes.
 * This enables an object model represented internally (to a tool, say) in BMM form, converted to P_BMM form, and then serialised to a .bmm file, to be easily readable and editable by human users.The second is that .bmm files function as schemas that support schema inclusion and therefore re-use, in a similar manner to the XML schema languages.
 * Thus, a single logical BMM model can be expressed as a number of .bmm schema files which are actually P_BMM_* object serialisations of parts of the BMM model.
 * A schema reading component has to resolve the schema inclusions and ultimately BMM_* object instantiations to obtain the in-memory form of the model.We thus talk of the P_BMM_* classes as a 'model of a BMM schema' and the BMM_* classes as a 'model of a BMM model', where the latter is understood as the fully computable in-memory object structure with all name references resolved to object references.The P_BMM format is not the only serial format possible for BMM, and alternatives, e.g.
 * a more syntactic style reminiscent of OMG IDL, are possible.The normal use of P_BMM schemas is as follows:
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 2.2.
 * Concrete Format
 * BMM models are normally expressed as schema text files that support inclusion and re-use.
 * The default file format has historically been openEHR ODIN syntax, and BMM tools to date support this format.
 * However any common format that can express typed object models may be used, including JSON (with type markers), YAML, and XML.
 * The examples shown in this specification are primarily in ODIN, but a tool implementing BMM may choose to serialise in and out of another preferred format.
 * 
 * 
 * 
*/
bmm_persistence/overviewpackage bmm_persistence/persistence_package;
/**
 * 
 * 
 * 3.
 * Persistence Package
 * 3.1.
 * Overview
 * The org.openehr.lang.bmm_persistence package, shown below, defines a simplified form of the main BMM model suitable for persisting and human authoring.
 * The openEHR BMM schemas are authored in the P_BMM form of the BMM, using the openEHR ODIN syntax.The general approach taken in this model is that attributes named bmm_xxx and of type BMM_XXX are derived from the persisted attributes of the P_BMM_XXX classes of this model.
 * In other words, they are in-memory only references to reconstructed instances of BMM_XXX types.
 * 
 * 
 * 
 * Figure 1.
 * lang.bmm_persistence Package
 * 
 * 
 * 3.2.
 * Class Definitions
 * 
 * 3.2.1.
 * P_BMM_MODEL_ELEMENT Class
 * 
 * 3.2.2.
 * P_BMM_PACKAGE_CONTAINER Class
 * 
 * 3.2.3.
 * P_BMM_SCHEMA Class
 * 
 * 3.2.4.
 * P_BMM_PACKAGE Class
 * 
 * 3.2.5.
 * P_BMM_TYPE Class
 * 
 * 3.2.6.
 * P_BMM_CLASS Class
 * 
 * 3.2.7.
 * P_BMM_GENERIC_PARAMETER Class
 * 
 * 3.2.8.
 * P_BMM_PROPERTY Class
 * 
 * 3.2.9.
 * P_BMM_BASE_TYPE Class
 * 
 * 3.2.10.
 * P_BMM_SIMPLE_TYPE Class
 * 
 * 3.2.11.
 * P_BMM_OPEN_TYPE Class
 * 
 * 3.2.12.
 * P_BMM_GENERIC_TYPE Class
 * 
 * 3.2.13.
 * P_BMM_CONTAINER_TYPE Class
 * 
 * 3.2.14.
 * P_BMM_INDEXED_CONTAINER_TYPE Class
 * 
 * 3.2.15.
 * P_BMM_SINGLE_PROPERTY Class
 * 
 * 3.2.16.
 * P_BMM_SINGLE_PROPERTY_OPEN Class
 * 
 * 3.2.17.
 * P_BMM_GENERIC_PROPERTY Class
 * 
 * 3.2.18.
 * P_BMM_CONTAINER_PROPERTY Class
 * 
 * 3.2.19.
 * P_BMM_INDEXED_CONTAINER_PROPERTY Class
 * 
 * 3.2.20.
 * P_BMM_ENUMERATION Class
 * 
 * 3.2.21.
 * P_BMM_ENUMERATION_STRING Class
 * 
 * 3.2.22.
 * P_BMM_ENUMERATION_INTEGER Class
 * 
 * 
*/
bmm_persistence/persistence_packagetruefalsePBmmModelElementPBmmModelElementP_BMM_MODEL_ELEMENT (abstract)Persistent form of BMM_MODEL_ELEMENT.0..1documentation: StringOptional documentation of this element.falsefalsePBmmPackageContainerPBmmPackageContainerP_BMM_PACKAGE_CONTAINERPersisted form of a model component that contains packages.1..1packages: Hash<String, P_BMM_PACKAGE>Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.falsefalsePBmmSchemaPBmmSchemaP_BMM_SCHEMAPersisted form of BMM_SCHEMA.PBmmPackageContainerP_BMM_PACKAGE_CONTAINERBmmSchemaBMM_SCHEMA0..1primitive_types: List<P_BMM_CLASS>Primitive type definitions. Persisted attribute.0..1class_definitions: List<P_BMM_CLASS>Class definitions. Persisted attribute.0..1 (effected)validate_created Pre_state: state = State_created Post_state: passed implies state = State_validated_createdImplementation of validate_created()0..1 (effected)load_finalise Pre_state: state = State_validated_created Post_state: state = State_includes_processed or state = State_includes_pendingImplementation of load_finalise()0..1 (effected)merge ( other: P_BMM_SCHEMA[1] ) Pre_state: state = State_includes_pending Pre_other_valid: includes_to_process.has (included_schema.schema_id)Implementation of merge()validateImplementation of validate()0..1 (effected)create_bmm_model Pre_state: state = P_BMM_PACKAGE_STATE.State_includes_processedImplementation of create_bmm_model()1..1canonical_packages (): P_BMM_PACKAGEPackage structure in which all top-level qualified package names like xx.yy.zz have been expanded out to a hierarchy of BMM_PACKAGE objects.falsefalsePBmmPackagePBmmPackageP_BMM_PACKAGEPersisted form of a package as a tree structure whose nodes can contain more packages and/or classes.PBmmPackageContainerP_BMM_PACKAGE_CONTAINERPBmmModelElementP_BMM_MODEL_ELEMENT1..1name: StringName of the package from schema; this name may be qualified if it is a top-level package within the schema, or unqualified. Persistent attribute.0..1classes: List<String>List of classes in this package. Persistent attribute.0..1bmm_package_definition: BMM_PACKAGEBMM_PACKAGE created by create_bmm_package_definition.0..1merge ( other: P_BMM_PACKAGE[1] )Merge packages and classes from other (from an included P_BMM_SCHEMA) into this package.create_bmm_package_definitionGenerate a BMM_PACKAGE_DEFINITION object and write it to bmm_package_definition.truefalsePBmmTypePBmmTypeP_BMM_TYPE (abstract)Persistent form of BMM_TYPE.0..1bmm_type: BMM_TYPEResult of create_bmm_type() call.0..1 (abstract)create_bmm_type ( a_schema: BMM_MODEL[1], a_class_def: BMM_CLASS[1] )Create appropriate BMM_XXX object; effected in descendants.1..1 (abstract)as_type_string (): StringFormal name of the type for display.falsefalsePBmmClassPBmmClassP_BMM_CLASSDefinition of persistent form of BMM_CLASS for serialisation to ODIN, JSON, XML etc.PBmmModelElementP_BMM_MODEL_ELEMENT1..1name: StringName of the class. Persisted attribute.0..1ancestors: List<String>List of immediate inheritance parents. If there are generic ancestors, use ancestor_defs instead. Persisted attribute.0..1properties: Hash<String,P_BMM_PROPERTY>List of attributes defined in this class. Persistent attribute.0..1is_abstract: BooleanTrue if this is an abstract type. Persisted attribute.0..1is_override: BooleanTrue if this class definition overrides one found in an included schema.0..1generic_parameter_defs: Hash<String,P_BMM_GENERIC_PARAMETER>List of generic parameter definitions. Persisted attribute.1..1source_schema_id: StringReference to original source schema defining this class. Set during BMM_SCHEMA materialise. Useful for GUI tools to enable user to edit the schema file containing a given class (i.e. taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).0..1bmm_class: BMM_CLASSBMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.1..1uid: IntegerUnique id generated for later comparison during merging, in order to detect if two classes are the same. Assigned in post-load processing.0..1ancestor_defs: List<P_BMM_GENERIC_TYPE>List of structured inheritance ancestors, used only in the case of generic inheritance. Persisted attribute.1..1is_generic (): Boolean Post: Result := generic_parameter_defs /= VoidTrue if this class is a generic class.create_bmm_classCreate bmm_class_definition.0..1populate_bmm_class ( a_bmm_schema: BMM_MODEL[1] )Add remaining model elements from Current to bmm_class_definition.falsefalsePBmmGenericParameterPBmmGenericParameterP_BMM_GENERIC_PARAMETERPersistent form of BMM_GENERIC_PARAMETER.PBmmModelElementP_BMM_MODEL_ELEMENT1..1name: StringName of the parameter, e.g. 'T' etc. Persisted attribute. Name is limited to 1 character, upper case.0..1conforms_to_type: StringOptional conformance constraint - the name of a type to which a concrete substitution of this generic parameter must conform. Persisted attribute.0..1bmm_generic_parameter: BMM_PARAMETER_TYPEBMM_GENERIC_PARAMETER created by create_bmm_generic_parameter.0..1create_bmm_generic_parameter ( a_bmm_schema: BMM_MODEL[1] )Create bmm_generic_parameter.truefalsePBmmPropertyPBmmPropertyP_BMM_PROPERTY (abstract)Persistent form of BMM_PROPERTY.PBmmModelElementP_BMM_MODEL_ELEMENT1..1name: StringName of this property within its class. Persisted attribute.0..1is_mandatory: BooleanTrue if this property is mandatory in its class. Persisted attribute.0..1is_computed: BooleanTrue if this property is computed rather than stored in objects of this class. Persisted Attribute.0..1is_im_infrastructure: BooleanTrue if this property is info model 'infrastructure' rather than 'data'. Persisted attribute.0..1is_im_runtime: BooleanTrue if this property is info model 'runtime' settable property. Persisted attribute.0..1type_def: P_BMM_TYPEType definition of this property, if not a simple String type reference. Persisted attribute.0..1bmm_property: BMM_PROPERTYBMM_PROPERTY created by create_bmm_property_definition.0..1create_bmm_property ( a_bmm_schema: BMM_MODEL[1], a_class_def: BMM_CLASS[1] )Create bmm_property_definition from P_BMM_XX parts.truefalsePBmmBaseTypePBmmBaseTypeP_BMM_BASE_TYPE (abstract)Persistent form of BMM_PROPER_TYPE.PBmmTypeP_BMM_TYPE0..1value_constraint: StringfalsefalsePBmmSimpleTypePBmmSimpleTypeP_BMM_SIMPLE_TYPEPersistent form of BMM_SIMPLE_TYPE.PBmmBaseTypeP_BMM_BASE_TYPE1..1type: StringName of type - must be a simple class name.0..1 (redefined)bmm_type: BMM_SIMPLE_TYPEResult of create_bmm_type() call.falsefalsePBmmOpenTypePBmmOpenTypeP_BMM_OPEN_TYPEPersistent form of BMM_PARAMETER_TYPE.PBmmBaseTypeP_BMM_BASE_TYPE1..1type: StringSimple type parameter as a single letter like 'T', 'G' etc.0..1 (redefined)bmm_type: @@Result of create_bmm_type() call.falsefalsePBmmGenericTypePBmmGenericTypeP_BMM_GENERIC_TYPEPersistent form of BMM_GENERIC_TYPE.PBmmBaseTypeP_BMM_BASE_TYPE1..1root_type: StringRoot type of this generic type, e.g. Interval in Interval<Integer>.1..1generic_parameter_defs: List<P_BMM_TYPE>Generic parameters of the root_type in this type specifier if non-simple types. The order must match the order of the owning class’s formal generic parameter declarations. Persistent attribute.0..1generic_parameters: List<String>Generic parameters of the root_type in this type specifier, if simple types. The order must match the order of the owning class’s formal generic parameter declarations. Persistent attribute.0..1 (redefined)bmm_type: BMM_GENERIC_TYPEResult of create_bmm_type() call.0..1generic_parameter_refs (): List<P_BMM_TYPE>Generic parameters of the root_type in this type specifier. The order must match the order of the owning class’s formal generic parameter declarationsfalsefalsePBmmContainerTypePBmmContainerTypeP_BMM_CONTAINER_TYPEPersistent form of BMM_CONTAINER_TYPE.PBmmTypeP_BMM_TYPE1..1container_type: StringThe type of the container. This converts to the root_type in BMM_GENERIC_TYPE. Persisted attribute.0..1type_def: P_BMM_BASE_TYPEType definition of type, if not a simple String type reference. Persisted attribute.0..1type: StringThe target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE. Persisted attribute.0..1 (redefined)bmm_type: BMM_CONTAINER_TYPEResult of create_bmm_type() call.1..1type_ref (): P_BMM_BASE_TYPEThe target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE. Persisted attribute.falsefalsePBmmIndexedContainerTypePBmmIndexedContainerTypeP_BMM_INDEXED_CONTAINER_TYPEPBmmContainerTypeP_BMM_CONTAINER_TYPE1..1index_type: String0..1 (redefined)bmm_type: BMM_INDEXED_CONTAINER_TYPEResult of create_bmm_type() call.falsefalsePBmmSinglePropertyPBmmSinglePropertyP_BMM_SINGLE_PROPERTYPersistent form of BMM_SINGLE_PROPERTY.PBmmPropertyP_BMM_PROPERTY0..1type: StringIf the type is a simple type, then this attribute will hold the type name. If the type is a container or generic, then type_ref will hold the type definition. The resulting type is generated in type_def.0..1type_ref: P_BMM_SIMPLE_TYPEType definition of this property computed from type for later use in bmm_property.0..1 (redefined)bmm_property: BMM_UNITARY_PROPERTYBMM_PROPERTY created by create_bmm_property_definition.1..1type_def (): P_BMM_SIMPLE_TYPEGenerate type_ref from type and save.falsefalsePBmmSinglePropertyOpenPBmmSinglePropertyOpenP_BMM_SINGLE_PROPERTY_OPENPersistent form of a BMM_SINGLE_PROPERTY_OPEN.PBmmPropertyP_BMM_PROPERTY0..1type_ref: P_BMM_OPEN_TYPEType definition of this property computed from type for later use in bmm_property.0..1type: StringType definition of this property, if a simple String type reference. Really we should use type_def to be regular in the schema, but that makes the schema more wordy and less clear. So we use this persisted String value, and compute the type_def on the fly. Persisted attribute.0..1 (redefined)bmm_property: BMM_UNITARY_PROPERTYBMM_PROPERTY created by create_bmm_property_definition.1..1type_def (): P_BMM_OPEN_TYPEGenerate type_ref from type and save.falsefalsePBmmGenericPropertyPBmmGenericPropertyP_BMM_GENERIC_PROPERTYPersistent form of BMM_GENERIC_PROPERTY.PBmmPropertyP_BMM_PROPERTY0..1 (redefined)type_def: P_BMM_GENERIC_TYPEType definition of this property, if not a simple String type reference. Persistent attribute.0..1 (redefined)bmm_property: BMM_UNITARY_PROPERTYBMM_PROPERTY created by create_bmm_property_definition.falsefalsePBmmContainerPropertyPBmmContainerPropertyP_BMM_CONTAINER_PROPERTYPersistent form of BMM_CONTAINER_PROPERTY.PBmmPropertyP_BMM_PROPERTY0..1cardinality: Interval<Integer>Cardinality of this property in its class. Persistent attribute.0..1 (redefined)type_def: P_BMM_CONTAINER_TYPEType definition of this property, if not a simple String type reference. Persistent attribute.0..1 (redefined)bmm_property: BMM_CONTAINER_PROPERTYBMM_PROPERTY created by create_bmm_property.0..1 (redefined)create_bmm_property ( a_bmm_schema: BMM_MODEL[1], a_class_def: BMM_CLASS[1] )Create bmm_property_definition.falsefalsePBmmIndexedContainerPropertyPBmmIndexedContainerPropertyP_BMM_INDEXED_CONTAINER_PROPERTYPBmmContainerPropertyP_BMM_CONTAINER_PROPERTY0..1 (redefined)type_def: P_BMM_INDEXED_CONTAINER_TYPEType definition of this property, if not a simple String type reference. Persistent attribute.0..1 (redefined)bmm_property: BMM_INDEXED_CONTAINER_PROPERTYBMM_PROPERTY created by create_bmm_property.falsefalsePBmmEnumerationPBmmEnumerationP_BMM_ENUMERATIONPersistent form of BMM_ENUMERATION attributes.PBmmClassP_BMM_CLASS0..1item_names: List<String>0..1item_values: List<Any>0..1 (redefined)bmm_class: BMM_ENUMERATIONBMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.falsefalsePBmmEnumerationStringPBmmEnumerationStringP_BMM_ENUMERATION_STRINGPersistent form of BMM_ENUMERATION_STRING.PBmmEnumerationP_BMM_ENUMERATION0..1 (redefined)bmm_class: BMM_ENUMERATION_STRINGBMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.falsefalsePBmmEnumerationIntegerPBmmEnumerationIntegerP_BMM_ENUMERATION_INTEGERPersistent form of an instance of BMM_ENUMERATION_INTEGER.PBmmEnumerationP_BMM_ENUMERATION0..1 (redefined)bmm_class: BMM_ENUMERATION_INTEGERBMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.package bmm_persistence/bmm_persistence_syntax;
/**
 * 
 * 
 * 4.
 * BMM Persistence Syntax
 * 4.1.
 * Overview
 * A BMM schema is normally written in the ODIN syntax, although any other serialisation supporting typed object models may be used, including JSON (with type markers), YAML, XML etc.
 * The ODIN form is described here.
 * The structures are direct ODIN serialisations of the P_BMM_XXX classes in the persistence package.
 * 
 * 
 * 4.2.
 * Header Items
 * The following shows the header items of a BMM schema, which correspond to the 'persistent' attributes of the class P_BMM_SCHEMA.
 * 
 * 
 * 
 * ------------------------------------------------------ -- P_BMM version on which these schemas are based.
 * ------------------------------------------------------ bmm_version = <"2.3"> ------------------------------------------------------ -- schema identification -- (schema_id computed as <rm_publisher>_<schema_name>_<rm_release>) ------------------------------------------------------ rm_publisher = <"openehr"> schema_name = <"adltest"> rm_release = <"1.0.2"> model_name = <"TEST_PKG"> ------------------------------------------------------ -- schema documentation ------------------------------------------------------ schema_revision = <"1.0.36"> schema_lifecycle_state = <"stable"> schema_description = <"openEHR schema to support test archetypes">
 * 4.3.
 * Inclusions
 * 
 * 
 * includes = < ["1"] = < id = <"openehr_basic_types_1.0.2"> > >
 * 4.4.
 * Package Definition
 * The packages definition should be self-explanatory: just name the classes and packages in a recursive fashion.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * packages = < ["org.openehr.test_pkg"] = < name = <"org.openehr.test_pkg"> classes = <"WHOLE", "SOME_TYPE", "BOOK", "CHAPTER", "ENTRY", "CAR", "CAR_BODY"> > >
 * 4.5.
 * Class Definitions
 * 
 * 4.5.1.
 * Classes for Primitive Types
 * Definitions for primitive types in a BMM schema are just normal class definitions within a primitive_types block.
 * Types that are included here are usually types corresonding to primitives in target programming languages, XML schema or other downstream technologies.
 * These types can be be detected as primitive types by tools, but otherwise are processed in the same way as types defined in the main class_definitions group.
 * Note unlike UML, all container types such as List<T>, Hash<V,K> etc are exlicit in a BMM schema, and consequently, such types are normally defined (including with generic parameters) in a BMM schema.
 * primitive_types = < ["Any"] = < name = <"Any"> is_abstract = <True> > ["Ordered"] = < name = <"Ordered"> is_abstract = <True> ancestors = <"Any"> > >
 * 4.5.2.
 * Non-primitive Classes
 * The main group of class definitions in a schema occurs within the class_definitions block.
 * Each definition is a keyed ODIN object block correspnding to a serialised P_BMM_CLASS object, where the key is the class name.
 * Since name is a BMM meta-model attribute, the class definition always contains its ODIN key.
 * The possible class-level meta-properties: name - class name - any capitalisation can be used, usually one of CamelCase or so-called UPPER_SNAKE_CASE; ancestors - states classes from which this class inherits, as an ODIN String list; is_abstract - indicates that the class cannot be instantiated directly; properties - ODIN block containing definitions consisting of P_BMM_PROPERTY descendants, keyed by property name.
 * 4.5.3.
 * Simple Classes
 * Simple classes are those whose type is the same as the class, as opposed to generic classes and enumerated types (see below).
 * class_definitions = < ["ITEM"] = < name = <"ITEM"> ancestors = <"Any"> is_abstract = <True> properties = < -- properties here > > -- more classes here > 4.5.3.1.
 * Class properties Class properties from the original model are expressed using ODIN object blocks keyed by property name.
 * Since there are multiple possible descendants of P_BMM_PROPERTY, ODIN type markers must be used to indicate which subtypes is used in each case.
 * The possible BMM meta-properties of all property types are as follows: name - String name of the property in its owning class in the model - use camelCase or snake_case as appropriate; is_mandatory - Boolean flag indicating whether the property is mandatory within its class.
 * The following shows the class ELEMENT with two properties null_flavour and value of BMM meta-type P_BMM_SINGLE_PROPERTY, i.e.
 * corresponding to a single-valued attribute from the original model.
 * ["ELEMENT"] = < name = <"ELEMENT"> ancestors = <"ITEM"> properties = < ["null_flavour"] = (P_BMM_SINGLE_PROPERTY) < name = <"null_flavour"> type = <"DV_CODED_TEXT"> is_mandatory = <True> > ["value"] = (P_BMM_SINGLE_PROPERTY) < name = <"value"> type = <"DATA_VALUE"> > > > 4.5.3.2.
 * Container Properties The following is a P_BMM_CONTAINER_PROPERTY definition for the model property items: List<ITEM> in the ELEMENT class.
 * The type is expressed in the type_def part which indicates the type of the container, which must be defined elsewhere in the schema, typically in the primitive types.
 * The optional cardinality meta-property indicates cardinality of the container, and is expressed as a ODIN range.
 * The default is |0..*|.
 * ["ELEMENT"] = < name = <"ELEMENT"> ancestors = <"ITEM"> properties = < ["items"] = (P_BMM_CONTAINER_PROPERTY) < name = <"items"> type_def = < container_type = <"List"> type = <"ITEM"> > cardinality = <|>=1|> is_mandatory = <True> > > > Indexed containers such as Hash<K,V>, Dictionary<K,V> etc are also suuported via the P_BMM_INDEXED_CONTAINER_PROPERTY, the use of which is shown here: ["CALLBACK_WAIT"] = < name = <"CALLBACK_WAIT"> ancestors = <"..."> properties = < ["custom_actions"] = (P_BMM_INDEXED_CONTAINER_PROPERTY) < name = <"custom_actions"> type_def = < container_type = <"Hash"> index_type = <"String"> type = <"EVENT_ACTION"> > cardinality = <|>=0|> > > > The above represents a property custom_actions: Hash <String, EVENT_ACTION> in the class CALLBACK_WAIT.
 * The meta-element index_type is used to state the key type.
 * 4.5.4.
 * Generic Classes
 * Generic classes are those that have one or more substitutable generic type parameters.
 * Such classes are therefore type generators, since actual types are formed by substitution of concrete types (typically simple classes) for the formal type parameters.
 * The following example shows a generic class Interval with generic_parameter_defs of T which is constrained to conform to the type Ordered.
 * This structure defineds the type Interval<T→Ordered>, with the same meaning as UML and programming languages supporting generic (templated) types.
 * Generic classes will normally contain one or more properties whose formal type is the generic type parameter, i.e.
 * the T in this example, as is the case below where the model properties lower and upper are both declared to be of type T.
 * This declaration necessitates the use of the BMM meta-type P_BMM_SINGLE_PROPERTY_OPEN.
 * ["Interval"] = < name = <"Interval"> ancestors = <"Any"> generic_parameter_defs = < ["T"] = < name = <"T"> conforms_to_type = <"Ordered"> > > properties = < ["lower"] = (P_BMM_SINGLE_PROPERTY_OPEN) < name = <"lower"> type = <"T"> > ["upper"] = (P_BMM_SINGLE_PROPERTY_OPEN) < name = <"upper"> type = <"T"> > > > Given the presence of generic classes in a BMM schema, derived generic types can be used as the type of properties in other classes, for which the BMM meta-type P_BMM_GENERIC_PROPERTY is used.
 * The folowing example shows first a generic class DV_INTERVAL defined in a similar way to Interval above, and then a class SOME_TYPE containing the property qty_interval_attr whose model type is DV_INTERVAL<DV_QUANTITY>.
 * In the latter type declaration, the DV_INTERVAL is the root_type and DV_INTERVAL the generic_parameter.
 * ["DV_INTERVAL"] = < name = <"DV_INTERVAL"> ancestors = <"Interval", "DATA_VALUE"> generic_parameter_defs = < ["T"] = < name = <"T"> conforms_to_type = <"DV_ORDERED"> > > > ["SOME_TYPE"] = < name = <"SOME_TYPE"> ancestors = <"Any", ...> properties = < ["qty_interval_attr"] = (P_BMM_GENERIC_PROPERTY) < name = <"qty_interval_attr"> type_def = < root_type = <"DV_INTERVAL"> generic_parameters = <"DV_QUANTITY"> > > > > Type declarations can also be nested types, for example and container followed by a generic type.
 * In the following the careProvider attribute is declared to be of model type List<Reference<Party>>.
 * Any level of type nesting is allowed.
 * ["Patient"] = < name = <"Patient"> ancestors = <"Any"> properties = < ["careProvider"] = (P_BMM_CONTAINER_PROPERTY) < name = <"careProvider"> type_def = < container_type = <"List"> type_def = (P_BMM_GENERIC_TYPE) < root_type = <"Reference"> generic_parameters = <"Party"> > > cardinality = <|>=0|> > > > The following property definition is based on the class REFERENCE_RANGE, and in this case, has a generic parameter type that is another generic type: DV_INTERVAL<DV_QUANTITY>.
 * To express this, we use generic_parameter_defs instead of just generic_parameters to specify a type structure, rather than just a string type name.
 * Note that generic_parameter_defs is a logical list in general, since there can always be more than one generic parameter, i.e.
 * 'T', 'U' etc, even though it is most commonly just one.
 * Accordingly, the usual ODIN keyed hash structure is used with each member being keyed by a generic parameter name, below ["T"].
 * ["REFERENCE_RANGE"] = < name = <"REFERENCE_RANGE"> ancestors = <"Any"> generic_parameter_defs = < ["T"] = < name = <"T"> conforms_to_type = <"DV_ORDERED"> > > properties = < ["range"] = (P_BMM_SINGLE_PROPERTY) < name = <"range"> type = <"DV_INTERVAL"> is_mandatory = <True> > > > ["RANGE_OF_INTERVAL_OF_QUANTITY"] = < name = <"RANGE_OF_INTERVAL_OF_QUANTITY"> ancestors = <"Any", ...> properties = < ["range"] = (P_BMM_GENERIC_PROPERTY) < name = <"range"> type_def = < root_type = <"REFERENCE_RANGE"> generic_parameter_defs = < ["T"] = (P_BMM_GENERIC_TYPE) < root_type = <"DV_INTERVAL"> generic_parameters = <"DV_QUANTITY"> > > > > > The following example just does the same as the one above, but shows an (unrealistic) but legal case of multiple, mixed, nested generic parameters corresponding to the model property definition range: REFERENCE_RANGE<DV_INTERVAL<DV_QUANTITY>, Integer, List<DV_QUANTITY>, List<DV_INTERVAL<DV_QUANTITY>>>.
 * The rules for expressing types is clearly illustrated: use 'type' for simple string type refs; use type_def for structure types; within P_BMM_GENERIC_TYPE, use generic_parameters for a list of string types; use generic_parameter_defs for a list of complex type references.
 * ["CRAZY_TYPE"] = < name = <"CRAZY_TYPE"> ancestors = <"Any"> properties = < ["range"] = (P_BMM_GENERIC_PROPERTY) < name = <"range"> type_def = < root_type = <"REFERENCE_RANGE"> generic_parameter_defs = < ["T"] = (P_BMM_GENERIC_TYPE) < root_type = <"DV_INTERVAL"> generic_parameters = <"DV_QUANTITY"> > ["U"] = (P_BMM_SIMPLE_TYPE) < type = <"Integer"> > ["V"] = (P_BMM_CONTAINER_TYPE) < type = <"DV_QUANTITY"> container_type = <"List"> > ["W"] = (P_BMM_CONTAINER_TYPE) < type_def = (P_BMM_GENERIC_TYPE) < root_type = <"DV_INTERVAL"> generic_parameters = <"DV_QUANTITY"> > container_type = <"List"> > > > > > >
 * 4.5.5.
 * Enumerated Types
 * In a BMM schema, enumerated types are treated as constrained forms of standard types with open ranges, currently only Integer and String.
 * They are accordingly represented using class definitions of the meta-types P_BMM_ENUMERATION_INTEGER and P_BMM_ENUMERATION_STRING respectively.
 * In either case, just names (items_names meta-property) or both names and values (item_values meta-property) can be specified.
 * The following example shows two variants of am enumerated type based on the Integer primitive type.
 * ["PROPORTION_KIND"] = (P_BMM_ENUMERATION_INTEGER) < name = <"PROPORTION_KIND"> ancestors = <"Integer"> item_names = <"pk_ratio", "pk_unitary", "pk_percent", "pk_fraction", "pk_integer_fraction"> > ["PROPORTION_KIND_2"] = (P_BMM_ENUMERATION_INTEGER) < name = <"PROPORTION_KIND_2"> ancestors = <"Integer"> item_names = <"pk_ratio", "pk_unitary", "pk_percent", "pk_fraction", "pk_integer_fraction"> item_values = <0, 1001, 1002, 1003> > The following example shows two similar examples based on String.
 * ["MAGNITUDE_STATUS"] = (P_BMM_ENUMERATION_STRING) < name = <"MAGNITUDE_STATUS"> ancestors = <"String", ...> item_names = <"le", "ge", "eq", "approx_eq"> item_values = <"<=", ">=", "=", "~"> > ["NAME_PART"] = (P_BMM_ENUMERATION_STRING) < name = <"NAME_PART"> ancestors = <"String", ...> item_names = <"FIRST", "MIDDLE", "LAST"> >
 * 4.5.6.
 * Value-set Constraints
 * Value-sets are related to enumerated types, but rather than specifying the possible instance values for a type in an explicit enumeration type, a standard type can be marked as having values that conform to an external value set, such as a terminology.
 * The following shows an attribute declared to be of a simple type CODE_PHRASE in the normal way.
 * ["encoding"] = (P_BMM_SINGLE_PROPERTY) < name = <"encoding"> type = <"CODE_PHRASE"> > With a value-set constraint added, it now looks as follows: ["encoding"] = (P_BMM_SINGLE_PROPERTY) < name = <"encoding"> type_ref = < type = <"CODE_PHRASE"> value_constraint = <"openEHR::languages"> > > The use of the value_constraint attribute forces the use of the type_ref structural form of the type definition within a P_BMM_SINGLE_PROPERTY instance, rather than the simple String form above.
 * Within a container type, the structure is slightly different, owing to another level of instance nesting.
 * The following exmaple shows a container class declaration in original form and then with a value constraint.
 * -- original form ["language"] = (P_BMM_CONTAINER_PROPERTY) < name = <"language"> type_def = < container_type = <"List"> type = <"Coding"> > > -- with value constraint ["language"] = (P_BMM_CONTAINER_PROPERTY) < name = <"language"> type_def = < container_type = <"List"> type_def = (P_BMM_SIMPLE_TYPE) < type = <"Coding"> value_constraint = <"hl7::Languages"> > > >
 * 4.6.
 * Inheritance
 * In the case of inheritance from simple classes, the ancestors list of Strings may be used to simply name the types (which are the same as class names), as seen in the above examples.
 * In the case of generic inheritance, the ancestors are generic types, which may be open, partially closed or fully closed.
 * The following example shows a class model containing generic inheritance in UML (using the closest approximation available in UML), followed by the equivalent P_BMM schema.
 * In the latter, a structured ancestor_defs section is used instead of the ancestors String list, in the same way as for the P_BMM_GENERIC_PROPERTY examples above.
 * 
 * 
 * 
 * Figure 2.
 * Generic inheritance eaxmple model
 * 
 * ["GENERIC_PARENT"] = < name = <"GENERIC_PARENT"> generic_parameter_defs = < ["T"] = < name = <"T"> conforms_to_type = <"SUPPLIER"> > ["U"] = < name = <"U"> conforms_to_type = <"SUPPLIER"> > > properties = < ["property_a"] = (P_BMM_SINGLE_PROPERTY_OPEN) < name = <"property_a"> type = <"T"> > ["property_b"] = (P_BMM_SINGLE_PROPERTY_OPEN) < name = <"property_b"> type = <"U"> > > > ["SUPPLIER"] = < name = <"SUPPLIER"> is_abstract = <True> properties = < ["abstract_prop"] = (P_BMM_SINGLE_PROPERTY) < name = <"abstract_prop"> type = <"String"> > > > ["SUPPLIER_A"] = < name = <"SUPPLIER_A"> ancestors = <"SUPPLIER"> properties = < ["magnitude"] = (P_BMM_SINGLE_PROPERTY) < name = <"magnitude"> type = <"Double"> is_mandatory = <True> > ["units"] = (P_BMM_SINGLE_PROPERTY) < name = <"units"> type = <"String"> is_mandatory = <True> > > > ["SUPPLIER_B"] = < name = <"SUPPLIER_B"> ancestors = <"SUPPLIER"> properties = < ["property"] = (P_BMM_SINGLE_PROPERTY) < name = <"property"> type = <"CODE_PHRASE"> is_mandatory = <True> > ["precision"] = (P_BMM_SINGLE_PROPERTY) < name = <"precision"> type = <"Integer"> > > > ["GENERIC_CHILD_OPEN_T"] = < name = <"GENERIC_CHILD_OPEN_T"> ancestor_defs = < ["GENERIC_PARENT<T,SUPPLIER_B>"] = (P_BMM_GENERIC_TYPE) < root_type = <"GENERIC_PARENT"> generic_parameters = <"T", "SUPPLIER_B"> > > generic_parameter_defs = < ["T"] = < name = <"T"> conforms_to_type = <"SUPPLIER"> > > properties = < ["gen_child_open_t_prop"] = (P_BMM_SINGLE_PROPERTY) < name = <"gen_child_open_t_prop"> type = <"String"> > > > ["GENERIC_CHILD_OPEN_U"] = < name = <"GENERIC_CHILD_OPEN_U"> ancestor_defs = < ["GENERIC_PARENT<SUPPLIER_A,U>"] = (P_BMM_GENERIC_TYPE) < root_type = <"GENERIC_PARENT"> generic_parameters = <"SUPPLIER_A", "U"> > > generic_parameter_defs = < ["U"] = < name = <"U"> conforms_to_type = <"SUPPLIER"> > > properties = < ["gen_child_open_u_prop"] = (P_BMM_SINGLE_PROPERTY) < name = <"gen_child_open_u_prop"> type = <"String"> > > > ["GENERIC_CHILD_CLOSED"] = < name = <"GENERIC_CHILD_CLOSED"> ancestor_defs = < ["GENERIC_PARENT<SUPPLIER_A,SUPPLIER_B>"] = (P_BMM_GENERIC_TYPE) < root_type = <"GENERIC_PARENT"> generic_parameters = <"SUPPLIER_A", "SUPPLIER_B"> > > properties = < ["gen_child_closed_prop"] = (P_BMM_SINGLE_PROPERTY) < name = <"gen_child_closed_prop"> type = <"String"> > > > >
 * 
*/
bmm_persistence/bmm_persistence_syntaxElTypeRef evalType ();

}
