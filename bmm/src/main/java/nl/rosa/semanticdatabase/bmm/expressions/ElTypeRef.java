package nl.rosa.semanticdatabase.bmm.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.bmm.types.BmmType;


/**
 * Class ElTypeRef
 * Meta-type for reference to a non-abstract type as an object. Assumed to be
 * accessible at run-time. Typically represented syntactically as TypeName or
 * {TypeName}.
 * May be used as a value, or as the qualifier for a function or constant access.
 */
@Data
public class ElTypeRef implements ElInstanceRef {

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
  public boolean isBoolean() {
    return false;
  }
}
