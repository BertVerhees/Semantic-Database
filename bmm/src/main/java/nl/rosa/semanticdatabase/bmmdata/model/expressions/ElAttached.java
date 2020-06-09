package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class ElAttached
 * A predicate on any object reference (including function call) that returns True
 * if the reference is attached, i.e. non-Void.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElAttached extends ElPredicate {

}
