package nl.rosa.semanticdatabase.bmm.overview;

/**
 * 
 * Definitions used by all BMM packages.
 * 
*/
public interface BmmDefinitions extends BasicDefinitions {

/* * ATTRIBUTE * */

/**
 * 
 * Current internal version of BMM meta-model, used to determine if a given schema can be processed by a given implementation of the model.
 * 
*/
    String getBmmInternalVersion();
    void setBmmInternalVersion(String value);

/* * FUNCTION * */

/**
 * 
 * built-in class definition corresponding to the top `Any' class.
 * 
*/
    BmmSimpleClass  Any_class();

/**
 * 
 * Built-in type definition corresponding to the top `Any' type.
 * 
*/
    BmmSimpleType  Any_type();

/**
 * 
 * Create schema id, formed from: a_model_publisher '-' a_schema_name '-' a_model_release e.g.
 * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
 * 
*/
    String  create_schema_id();

}
