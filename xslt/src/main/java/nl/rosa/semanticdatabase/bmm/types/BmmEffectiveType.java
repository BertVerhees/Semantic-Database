package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Meta-type for a concrete, unitary type that can be used as an actual parameter type in a generic type declaration.
 * 
*/
public interface BmmEffectiveType extends BmmUnitaryType {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Result = self.
 * 
*/
    BmmEffectiveType  effective_type();

/**
 * 
 * Name of base generator type, i.e.
 * excluding any generic parts if present.
 * 
*/
    BmmEffectiveType  type_base_name();

}
