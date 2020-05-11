package nl.rosa.semanticdatabase.referencemodel.bmm.model_structure;


import lombok.Data;

/**
 * Class BmmPackageContainer
 */
@Data
public class BmmPackageContainer implements BmmDeclaration {

  //
  // Fields
  //

  private BmmPackage packages;
  private BmmPackageContainer scope;
  
  //
  // Constructors
  //
  public BmmPackageContainer () { };
  
  //
  // Methods
  //


}
