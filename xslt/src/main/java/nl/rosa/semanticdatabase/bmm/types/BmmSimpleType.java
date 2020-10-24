package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Type reference to a single type i.e.
 * not generic or container type.
 * 
*/
public interface BmmSimpleType extends BmmModelType {

/**
 * 
 * Defining class of this type.
 * 
*/
BmmSimpleClass getBaseClass()
setBaseClass(var BmmSimpleClass)

}
