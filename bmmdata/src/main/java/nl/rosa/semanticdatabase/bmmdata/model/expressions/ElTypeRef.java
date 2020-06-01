package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;


/**
 * Class ElTypeRef
 * Meta-type for reference to a non-abstract type as an object. Assumed to be
 * accessible at run-time. Typically represented syntactically as TypeName or
 * {TypeName}.
 * May be used as a value, or as the qualifier for a function or constant access.
 */
@Data
public class ElTypeRef extends BmmBaseEntity implements ElInstanceRef {
  /**
   *    ElInstanceRef
   *      ElTerminal
   *        ElExpression
   */
  /**
   * ElInstanceRef
   */
  /**
   * ElTerminal
   */
  /**
   * ElExpression
   */
  @NotNull
  public BmmType evalType(){
    return null;
  }
  @NotNull
  public Boolean isBoolean(){
    return null;
  }
//======================================================================================

  //
  // Fields
  //

  private BmmType type;
  
  //
  // Constructors
  //
  public ElTypeRef () { };
  
  //
  // Methods
  //


  @Override
  public BmmType evalType() {
    return null;
  }

  @Override
  public Boolean isBoolean() {
    return false;
  }
}
