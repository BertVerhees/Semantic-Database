package nl.rosa.semanticdatabase.referencemodel.bmm.types;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmValueSpec;


/**
 * Class BmmSimpleType
 * Type reference to a single type i.e. not generic or container type.
 * 
 * (effected) type_name (): String
 * Result is base_class.name.
 * (effected) is_abstract (): Boolean
 * Result is base_class.is_abstract.
 * (effected) flattened_type_list (): List<String>
 * Result is base_class.name .
 * 
 */
@Data
public class BmmSimpleType implements BmmModelType {

  //
  // Fields
  //

  // BmmModelType
  private BmmValueSpec valueConstraint;
  /**
   * Defining class of this type.
   */
  private BmmSimpleClass baseClass;
  
  //
  // Constructors
  //
  public BmmSimpleType () { };

}
