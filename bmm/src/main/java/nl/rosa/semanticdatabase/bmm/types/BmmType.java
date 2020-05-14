package nl.rosa.semanticdatabase.bmm.types;

import nl.rosa.semanticdatabase.bmm.entities.BmmEntity;

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
   * True if type is based only on a primitive class, or a collection thereof.
   * Effected in descendants.
   * @return       String
   */
  String typeName();
  /**
   * Completely flattened list of type names, flattening out all generic parameters.
   * @return       List<String>
   */
  List<String> flattenedTypeList();
  /**
   * Signature form of the type name, which for generics includes generic parameter
   * constrainer nl.rosa.semanticdatabase.bmm.types E.g. Interval<T:Ordered>.
   * Defaults to the value of type_name().
   * @return       String
   */
  String typeSignature();
  /**
   * Type with any container abstracted away.
   * When UnitaryType: Result = self.
   */
  BmmUnitaryType unitaryType();
  /**
   * Type with any container abstracted away, and any formal parameter replaced by
   * its effective constraint type. When BmmEffectiveType Result=self
   */
  BmmEffectiveType effectiveType();
}
