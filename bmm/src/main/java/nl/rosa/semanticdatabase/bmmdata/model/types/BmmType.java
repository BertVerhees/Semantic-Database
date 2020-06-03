package nl.rosa.semanticdatabase.bmmdata.model.types;

import nl.rosa.semanticdatabase.bmmdata.model.entities.BmmEntity;

import java.util.List;


/**
 * Class BmmType
 * Abstract idea of specifying a type in some context. This is not the same as
 * 'defining' a class. A type specification is essentially a reference of some
 * kind, that defines the type of an attribute, or function result or argument. It
 * may include generic parameters that might or might not be bound. See subtypes.
 */
public interface BmmType extends BmmEntity {

  /**
   * 1..1
   * (abstract)
   * type_name (): String
   * Formal string form of the type as per UML.
   */
  String typeName();
  /**
   * 1..1
   * (abstract)
   * flattened_type_list (): List<String>
   * Completely flattened list of type names, flattening out all generic parameters.
   */
  List<String> flattenedTypeList();
  /**
   * 1..1
   * type_signature (): String
   * Signature form of the type name, which for generics includes generic parameter constrainer types
   * E.g. Interval<T:Ordered>.
   */
  String typeSignature();
  /**
   * 1..1
   * (abstract)
   * unitary_type (): BMM_UNITARY_TYPE
   * Type with any container abstracted away.
   */
  BmmUnitaryType unitaryType();
  /**
   * 1..1
   * (abstract)
   * effective_type (): BMM_EFFECTIVE_TYPE
   * Type with any container abstracted away, and any formal parameter replaced by its effective constraint type.
   */
  BmmEffectiveType effectiveType();
}
