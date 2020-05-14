package nl.rosa.semanticdatabase.bmm.classes;


/**
 * Class BmmValueSpec
 * Definition of a range-constrained class whose value range is defined by
 * reference to a 'value set' within an external resource, e.g. a reference data
 * service.
 */
public class BmmValueSpec {

  //
  // Fields
  //

  /**
   * Identifier of a resource (typically available as a service) that contains legal values of a specific type. This is typically a URI but need not be.
   */
  private String resourceId;
  /**
   * Identifier of a value set within the resource identified by resource_id, which specifies the set of legal values of a type. This might be a URI, but need not be.
   */
  private String valuesetId;
  
  //
  // Constructors
  //
  public BmmValueSpec () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of resourceId
   * Identifier of a resource (typically available as a service) that contains legal
   * values of a specific type. This is typically a URI but need not be.
   * @param newVar the new value of resourceId
   */
  public void setResourceId (String newVar) {
    resourceId = newVar;
  }

  /**
   * Get the value of resourceId
   * Identifier of a resource (typically available as a service) that contains legal
   * values of a specific type. This is typically a URI but need not be.
   * @return the value of resourceId
   */
  public String getResourceId () {
    return resourceId;
  }

  /**
   * Set the value of valuesetId
   * Identifier of a value set within the resource identified by resource_id, which
   * specifies the set of legal values of a type. This might be a URI, but need not
   * be.
   * @param newVar the new value of valuesetId
   */
  public void setValuesetId (String newVar) {
    valuesetId = newVar;
  }

  /**
   * Get the value of valuesetId
   * Identifier of a value set within the resource identified by resource_id, which
   * specifies the set of legal values of a type. This might be a URI, but need not
   * be.
   * @return the value of valuesetId
   */
  public String getValuesetId () {
    return valuesetId;
  }

  //
  // Other methods
  //

}
