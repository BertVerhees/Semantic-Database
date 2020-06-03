package nl.rosa.semanticdatabase.bmmdata.model.entities;

/**
 * Class BmmEntity
 */
public interface BmmEntity {
  /**
   * 1..1
   * is_abstract (): Boolean
   * If true, indicates an abstract class in a BMM model, or a type based on an abstract class,
   * i.e. a type that cannot be directly instantiated.
   */
  Boolean isAbstract();

    /**
   * 1..1
   * is_primitive (): Boolean
   * If True, indicates that the entity in a BMM model is considered to relate to a primitive type set,
   * i.e. be a primitive type, or be a definer of one.
   */
  Boolean isPrimitive();

}
