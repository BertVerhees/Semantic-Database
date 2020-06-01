package nl.rosa.semanticdatabase.bmmdata.model.types;


/**
 * Class BmmEffectiveType
 * Meta-type for a A concrete, unitary type that can be used as an actual parameter
 * type in a generic type declaration.
 */
public interface BmmEffectiveType extends BmmUnitaryType {

  /**
   * 1..1
   * (effected)
   * effective_type (): BMM_EFFECTIVE_TYPE
   * Result = self.
   */
  BmmEffectiveType getEffectiveType();
  /**
   * 1..1
   * (abstract)
   * type_base_name (): String
   * Name of base generator type, i.e. excluding any generic parts if present.
   */
  String typeBaseName();
}
