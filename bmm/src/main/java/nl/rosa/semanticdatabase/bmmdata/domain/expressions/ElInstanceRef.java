package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class ElInstanceRef
 * A reference to an instance of any kind.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ElInstanceRef extends ElTerminal {
}
