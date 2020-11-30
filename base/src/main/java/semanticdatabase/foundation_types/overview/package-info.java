package semanticdatabase.foundation_types.overview;
/**
 * 2.
 * Overview
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 2.1.
 * Operators
 * Some operations have symbolic or textual operator equivalents defined, in order to support parsing of textual form of expressions.
 * Two categories of operator are supported via two stereotypes that add a list of Strings to an operation, enabling standard operators, and optionally, symbolic operators to be associated with a function.
 * These are as follows.The main utility of such operators is to enable function signature-matching from parsed expressions.
 * For example, the expression a_date_time - P1Y (subtract a time period of 1 year from a date/time) has the signature <[Iso8601_duration], ?>, equivalent to a function of the form func (dur: Iso8601_duration): ? defined on the type Iso8601_date_time (i.e.
 * the return type is unknown until the function definition can be inferred).
 * The correct function can be found on the latter type by searching for a function with the operator '-' and taking a single Iso8601_duration argument.
 * In this specification, this turns out to be the Iso8601_duration.subtract() operation.The operators provided by this means are not intended to prevent other kinds of operators being associated with functions defined on types in the openEHR specifications, rather they provide a minimal set for common operations.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 2.2.
 * The Any Class
 * Within all object-oriented and most other modern programming and modelling environments exists an ultimate ancestor type to which all others conform.
 * In this specification, we assume the type Any, which defines a bare minimum of operations, and stands for the real Any or Object type found in real technologies.The primary operations specified are those for equality, i.e.:In these specifications, the equal() operation is normally rendered using its operator, i.e.
 * the '=' sign, while is_equal() is always specified as a function call.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 2.3.
 * openEHR Leaf Types
 * The sections below provide formal definitions of all the foundation types used in openEHR.
 * A subset of these can be understood as terminal or leaf types, typically used as terminal value types in other information models.
 * The following diagram provides an aide memoire for the leaf types.
 * <p>
 * <p>
 * <p>
 * Figure 2.
 * Leaf Types
 * 2.4.
 * Class Definitions
 * <p>
 * 2.4.1.
 * Any Class
 */
