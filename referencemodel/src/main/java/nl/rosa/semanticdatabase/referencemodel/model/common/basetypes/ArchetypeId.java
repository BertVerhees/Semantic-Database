package nl.rosa.semanticdatabase.referencemodel.model.common.basetypes;

/*
Identifier for archetypes. Ideally these would identify globally unique archetypes.
Lexical form: rm_originator '-' rm_name '-' rm_entity '.' concept_name { '-' specialisation }* '.v' number.
 */
public class ArchetypeId extends ObjectId{
    // Globally qualified reference model entity, e.g. openehr-EHR-OBSERVATION.
    public String qualifiedRmEntity (){
        return null;
    }
    // Name of the concept represented by this archetype, including specialisation, e.g. Biochemistry_result-cholesterol.
    public String domainConcept(){
        return null;
    }
    // Organisation originating the reference model on which this archetype is based, e.g. openehr, cen, hl7 .
    public String rmOriginator(){
        return null;
    }
    // Name of the reference model, e.g. rim, ehr_rm, en13606 .
    public String rmName(){
        return null;
    }
    // Name of the ontological level within the reference model to which this archetype is targeted, e.g. for openEHR, folder , composition , section , entry .
    public String rmEntity() {
        return null;
    }
    // Name of specialisation of concept, if this archetype is a specialisation of another archetype, e.g. cholesterol .
    public String specialisation(){
        return null;
    }
    // Version of this archetype.
    public String versionId(){
        return null;
    }
}
