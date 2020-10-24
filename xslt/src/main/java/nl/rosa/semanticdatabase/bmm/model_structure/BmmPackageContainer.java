package nl.rosa.semanticdatabase.bmm.model_structure;

/**
 * 
 * A BMM model component that contains packages and classes.
 * 
*/
public interface BmmPackageContainer extends BmmDeclaration {

/**
 * 
 * Child packages; keys all in upper case for guaranteed matching.
 * 
*/
Hash<string,bmmPackage> getPackages()
setPackages(var Hash<string,bmmPackage>)

/**
 * 
 * Model element within which a referenceable element is known.
 * 
*/
BmmPackageContainer getScope()
setScope(var BmmPackageContainer)

}
