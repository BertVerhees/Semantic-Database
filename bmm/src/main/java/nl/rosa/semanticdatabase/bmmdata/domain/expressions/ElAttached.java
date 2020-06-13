package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Class ElAttached
 * A predicate on any object reference (including function call) that returns True
 * if the reference is attached, i.e. non-Void.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ElAttached extends ElPredicate {

}
