package nl.rosa.semanticdatabase.referencemodel.bmm.types;


/**
 * Class BmmEffectiveType
 * Meta-type for a A concrete, unitary type that can be used as an actual parameter
 * type in a generic type declaration.
 */
public interface BmmEffectiveType extends BmmUnitaryType {

  /**
   * Name of base generator type, i.e. excluding any generic parts if present.
   *
   * @return       String
   */
  public String typeBaseName();
}
