package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

/**
 * Class ElTerminal
 * Expression terminal entity, representing one of:
 * a reference to a literal value of any type;
 * a reference to an instance of any instantiable type, i.e. variable, property or
 * constant;
 * an agent, i.e. a delayed function call;
 * a function call.
 */
public abstract class ElTerminal<T extends BmmType> extends ElExpression<T>{

}
