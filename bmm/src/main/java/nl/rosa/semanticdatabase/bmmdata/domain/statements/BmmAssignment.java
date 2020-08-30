package nl.rosa.semanticdatabase.bmmdata.domain.statements;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElExpression;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElInstantiableRef;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

/**
 * Default created on 13-7-2020
 * Statement type representing an assignment from a value-generating source to a writable entity,
 * i.e. a variable reference or property.
 * Inherit
 * BMM_STATEMENT
 */

public class BmmAssignment implements BmmStatement{
    /**
     * 1..1
     * target: EL_INSTANTIABLE_REF
     * The target variable on the notional left-hand side of this assignment.
     */
    @NonNull
    @Getter
    @Setter
    private ElInstantiableRef target;
    /**
     * 1..1
     * source: EL_EXPRESSION
     * Source right hand side) of the assignment.
     */
    @NonNull
    @Getter
    @Setter
    private ElExpression<BmmType> source;
}
