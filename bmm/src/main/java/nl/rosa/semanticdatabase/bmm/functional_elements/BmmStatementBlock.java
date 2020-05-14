package nl.rosa.semanticdatabase.bmm.functional_elements;


import lombok.Data;

/**
 * Class BmmStatementBlock
 * A statement 'block' corresponding to the programming language concept of the
 * same name. May be used to establish scope in specific languages.
 */
@Data
public class BmmStatementBlock implements BmmStatementItem {

  //
  // Fields
  //

  /**
   * Child blocks of the current block.
   */
  private BmmStatementItem items;
  
  //
  // Constructors
  //
  public BmmStatementBlock () { };
  
}
