package nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped;

import nl.rosa.semanticdatabase.referencemodel.model.internal.RMObject;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.datetime.DvDateTime;
import nl.rosa.semanticdatabase.referencemodel.model.internal.generic.PartyIdentified;
import nl.rosa.semanticdatabase.referencemodel.model.internal.generic.PartyProxy;
import org.springframework.lang.Nullable;

/**
 * Audit details for any system in a feeder system chain. Audit details here means the general notion of who/where/when
 * the information item to which the audit is attached was created. None of the attributes is defined as mandatory,
 * however, in different scenarios, various combinations of attributes will usually be mandatory.
 * This can be controlled by specifying feeder audit details in legacy archetypes.
 */
public class FeederAuditDetails extends RMObject {

    /**
     * Identifier of the system which handled the information item. This is the IT system owned by the organisation legally responsible for handling the data,
     * and at which the data were previously created or passed by an earlier system.
     */
    protected String systemId;
    /**
     * Identifier of the particular site/facility within an organisation which handled the item. For computability,
     * this identifier needs to be e.g. a PKI identifier which can be included in the identifier list of the PARTY_IDENTIFIED object.
     */
    @Nullable
    protected PartyIdentified location;
    /**
     * Optional provider(s) who created, committed, forwarded or otherwise handled the item.
     */
    @Nullable
    protected PartyIdentified provider;
    /**
     * Identifiers for subject of the received information item.
     */
    @Nullable
    protected PartyProxy subject;
    /**
     * Time of handling the item. For an originating system, this will be time of creation, for an intermediate feeder system,
     * this will be a time of accession or other time of handling, where available.
     */
    @Nullable
    protected DvDateTime time;
    /**
     * Any identifier used in the system such as "interim" , "final" , or numeric versions if available.
     */
    @Nullable
    protected String versionId;

    public FeederAuditDetails() {
    }

    public FeederAuditDetails(String systemId, @Nullable PartyIdentified provider, @Nullable PartyIdentified location, @Nullable DvDateTime time, @Nullable PartyProxy subject, @Nullable String versionId) {
        this.systemId = systemId;
        this.location = location;
        this.provider = provider;
        this.subject = subject;
        this.time = time;
        this.versionId = versionId;
    }
}