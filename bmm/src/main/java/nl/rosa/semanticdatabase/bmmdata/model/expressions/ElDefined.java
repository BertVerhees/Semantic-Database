package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class ElDefined
 * A predicate taking one external variable reference argument, that returns true
 * if the reference is resolvable, i.e. the external value is obtainable.
 * 
 * NOTE
 * probably to be removed.
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElDefined extends ElPredicate {
}
