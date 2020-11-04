package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Definition of a generic parameter in a class definition of a generic type.
 * 
*/
public class BmmParameterTypeImpl implements BmmUnitaryType{

    //***** BmmParameterType *****

/* * FIELDS * */

/**
 * 
 * Name of the parameter, e.g.
 * 'T' etc.
 * The name is limited to 1 character and upper-case.
 * 
*/
    private String name;

        />
    
/**
 * 
 * Optional conformance constraint that must be the name of a defined type.
 * 
*/
    private BmmEffectiveType type_constraint;

        />
    
/**
 * 
 * If set, is the corresponding generic parameter definition in an ancestor class.
 * 
*/
    private BmmParameterType inheritance_precursor;

        />
    
    //***** BmmUnitaryType *****

/* * FIELDS * */

    //***** BmmType *****

/* * FIELDS * */

/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}
