package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.expressions;


/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface ElTerminalService
 * Expression terminal entity, representing one of:
 * a reference to a literal value of any type;
 * a reference to an instance of any instantiable type, i.e. variable, property or
 * constant;
 * an agent, i.e. a delayed function call;
 * a function call.
 */
public interface ElTerminalService extends ElExpressionService {
}
