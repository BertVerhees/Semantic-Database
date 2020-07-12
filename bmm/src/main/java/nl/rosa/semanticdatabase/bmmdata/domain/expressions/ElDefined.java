package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Class ElDefined
 * A predicate taking one external variable reference argument, that returns true
 * if the reference is resolvable, i.e. the external value is obtainable.
 * 
 * NOTE
 * probably to be removed.
 * 
 */
public class ElDefined extends ElPredicate {
}
