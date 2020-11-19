package nl.rosa.semanticdatabase.foundation_types.primitive_types/primitive_types;
/**
 * 
 * 
 * 3.
 * Primitive Types
 * 3.1.
 * Overview
 * This section describes primitive types assumed by all openEHR models.
 * These are types supported directly by most programing languages, and usually visible via either a class interface and/or a built-in raw value type.
 * The following table lists the primitive types assumed by openEHR.The figure below illustrates these types.
 * Simple inheritance relationships are shown which facilitate the type descriptions below.
 * Actual inheritance from or subsitutability for an Any class is not assumed, and is shown only for convenience (e.g.
 * to indicate that the '=' operator is available on any type).
 * The type Ordered_numeric is on the other hand is used to indicate assumed substitutability of numeric types, and is intended to be mapped to an equivalent type in a real type system (e.g.
 * in Java, java.lang.Number).
 * Data-oriented implementation type systems such as XML-schema do not have such operations.
 * 
 * 
 * 
 * 
 * 
 * Figure 3.
 * base.foundation_types.primitive_types Package
 * 3.2.
 * Unicode
 * It is assumed in the openEHR specifications that Unicode is supported by the type String.
 * Unicode is needed for all Asian, Arabic and other script languages, for both data values (particularly plain text and coded text) and for many predefined string attributes of the classes in the openEHR Reference Model.
 * It encompasses all existing character sets.
 * In openEHR, UTF-8 encoding is assumed.
 * 
 * 
 * 3.3.
 * Class Definitions
 * 
 * 3.3.1.
 * Boolean Class
 * 
 * 3.3.2.
 * Ordered Class
 * 
 * 3.3.3.
 * Character Class
 * 
 * 3.3.4.
 * Octet Class
 * 
 * 3.3.5.
 * String Class
 * 
 * 3.3.6.
 * Uri Class
 * 
 * 3.3.7.
 * Numeric Class
 * 
 * 3.3.8.
 * Ordered_Numeric Class
 * 
 * 3.3.9.
 * Integer Class
 * 
 * 3.3.10.
 * Integer64 Class
 * 
 * 3.3.11.
 * Real Class
 * 
 * 3.3.12.
 * Double Class
 * 
 * 
*/
