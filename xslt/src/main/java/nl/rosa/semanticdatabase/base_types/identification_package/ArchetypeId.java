package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Identifier for archetypes.
 * Ideally these would identify globally unique archetypes.
 * Lexical form: rm_originator '-' rm_name '-' rm_entity '.' concept_name { '-' specialisation }* '.v' number.
 * 
*/
public interface ArchetypeId extends ObjectId {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Globally qualified reference model entity, e.g.
 * openehr-EHR-OBSERVATION.
 * 
*/
    String  qualified_rm_entity();

/**
 * 
 * Name of the concept represented by this archetype, including specialisation, e.g.
 * Biochemistry_result-cholesterol.
 * 
*/
    String  domain_concept();

/**
 * 
 * Organisation originating the reference model on which this archetype is based, e.g.
 * openehr, cen, hl7 .
 * 
*/
    String  rm_originator();

/**
 * 
 * Name of the reference model, e.g.
 * rim, ehr_rm, en13606 .
 * 
*/
    String  rm_name();

/**
 * 
 * Name of the ontological level within the reference model to which this archetype is targeted, e.g.
 * for openEHR, folder , composition , section , entry .
 * 
*/
    String  rm_entity();

/**
 * 
 * Name of specialisation of concept, if this archetype is a specialisation of another archetype, e.g.
 * cholesterol .
 * 
*/
    String  specialisation();

/**
 * 
 * Version of this archetype.
 * 
*/
    String  version_id();

}
