package nl.rosa.semanticdatabase.bmm.model_structure;

/**
 * 
 * Definition of the root of a BMM model (along with what is inherited from BMM_SCHEMA_CORE).
 * 
*/
public interface BmmModel extends BmmPackageContainer,BmmModelMetadata {

/**
 * 
 * All classes in this model, keyed by type name.
 * 
*/
Hash<string,bmmClass> getClassDefinitions()
setClassDefinitions(var Hash<string,bmmClass>)

/**
 * 
 * List of other models 'used' (i.e.
 * 'imported' by this model).
 * Classes in the current model may refer to classes in a used model by specifying the other class’s scope meta-attribute.
 * 
*/
List<bmmModel> getUsedModels()
setUsedModels(var List<bmmModel>)

}
