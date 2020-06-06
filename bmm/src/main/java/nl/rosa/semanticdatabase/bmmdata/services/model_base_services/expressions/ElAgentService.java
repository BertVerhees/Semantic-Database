package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.expressions;

import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;


/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface ElAgentService
 * A delayed routine call, whose arguments may be open, partially closed or closed.
 * Instances may include closed delayed calls like calculate_age (dob="1987-09-13",
 * today="2019-06-03") but also partially open calls such as format_structure
 * (struct=?, style=3), where struct is an open argument.
 * Evaluation type (i.e. type of runtime evaluated form) is BMM_SIGNATURE.
 */
public interface ElAgentService extends ElScopedRefService {
  /**
   * Eval type is the signature corresponding to the (remaining) open arguments and
   * return type, if any.
   * Post_result: Result = definition.signature
   */
  BmmSignature evalType();
  /**
   * True if there are no open arguments.
   * Post_result_validity: Result = open_arguments = Void
   * @return       Boolean
   */
  Boolean isCallable();
}
