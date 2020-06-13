package nl.rosa.semanticdatabase.bmmdata.domain.routine_implementation;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.List;

/**
 * Class BmmStatementBlock
 * A statement 'block' corresponding to the programming language concept of the
 * same name. May be used to establish scope in specific languages.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class BmmStatementBlock extends BmmStatementItem {
 /**
  * 0..1
  * items: List<BMM_STATEMENT_ITEM>
  * Child blocks of the current block.
  */
  private List<BmmStatementItem> items;
}
