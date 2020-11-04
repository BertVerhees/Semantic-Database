package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Identifier for terminologies such as accessed via a terminology query service.
 * In this class, the value attribute identifies the Terminology in the terminology service, e.g.
 * SNOMED-CT .
 * A terminology is assumed to be in a particular language, which must be explicitly specified.
 * The value if the id attribute is the precise terminology id identifier, including actual release (i.e.
 * actual version), local modifications etc; e.g.
 * ICPC2.
 * Lexical form: name [ '(' version ')' ].
 * 
*/
public interface TerminologyId extends ObjectId {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Return the terminology id (which includes the version in some cases).
 * Distinct names correspond to distinct (i.e.
 * non-compatible) terminologies.
 * Thus the names ICD10AM and ICD10 refer to distinct terminologies.
 * 
*/
    String  name();

/**
 * 
 * Version of this terminology, if versioning supported, else the empty string.
 * 
*/
    String  version_id();

/* * CONSTANTS * */

}
