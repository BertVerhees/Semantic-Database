package nl.rosa.semanticdatabase.bmmdata.domain.statements;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElAgent;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElAgentCall;
import nl.rosa.semanticdatabase.bmmdata.domain.expressions.ElProcedureAgent;

/**
 * Default created on 13-7-2020
 */

public class BmmProcedureCall  implements BmmStatement, ElAgentCall {

    /**
     * 1..1
     * (redefined)
     * agent: EL_PROCEDURE_AGENT
     * The procedure agent being called.
     */
    @NonNull
    @Getter
    @Setter
    private ElProcedureAgent agent;

    @Override
    public void setAgent(ElAgent newVar) {
        this.agent = (ElProcedureAgent) newVar;
    }
}
