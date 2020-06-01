package nl.rosa.semanticdatabase.bmmdata.model.routine_implementation;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

/**
 * Class BmmStatementBlock
 * A statement 'block' corresponding to the programming language concept of the
 * same name. May be used to establish scope in specific languages.
 */
@Data
public class BmmStatementBlock extends BmmBaseEntity implements BmmStatementItem {
  /**
   * BmmStatementItem
   */
  /**
   * Child blocks of the current block.
   */
  private BmmStatementItem items;
  
  //
  // Constructors
  //
  public BmmStatementBlock () { };
  
}
