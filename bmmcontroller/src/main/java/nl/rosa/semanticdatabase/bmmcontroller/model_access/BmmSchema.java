package nl.rosa.semanticdatabase.bmmcontroller.model_access;

import lombok.Data;
import nl.rosa.semanticdatabase.bmm.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.meta.BmmModelMetadata;
import nl.rosa.semanticdatabase.bmm.model.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmm.model.model_structure.BmmPackageContainer;

import java.util.List;


/**
 * Class BmmSchema
 */
@Data
abstract public class BmmSchema extends BmmPackageContainer {

  //
  // Fields
  //

  private String bmmVersion;
  private BmmClass primitiveTypes;  //JSON
  private BmmClass classDefinitions;  //JSON
  private BmmIncludeSpec includes;  //JSON
  private BmmModel bmmSchema;
  private BmmSchemaState state;
  private String modelName;
  private String schemaName;
  private String schemaRevision;
  private String schemaLifecycleState;
  private String schemaAuthor;
  private String schemaDescription;
  private List<String> schemaContributors;
  private BmmModelMetadata bmmModelMetadata;
  
  //
  // Constructors
  //
  public BmmSchema () { };
  

  /**
   * Do some basic validation post initial creation
   *
   * check that package structure is regular:
   *
   * only top-level packages can have qualified names
   *
   * no top-level package name can be a direct parent or child of another (child package must be declared under the parent)
   *
   * check that all classes are mentioned in the package structure
   *
   * check that all models refer to valid packages
   *
   * Pre_state: state = State_created
   * Post_state: passed implies state = State_validated_created
   */
  abstract public void validateCreated();


  /**
   * Finalisation work:
   *
   * convert packages to canonical form, i.e. full hierarchy with no packages with names like aa.bb.cc
   *
   * set up include processing list
   *
   * Pre_state: state = State_validated_created
   * Post_state: state = State_includes_processed or state = State_includes_pending
   */
  abstract public void loadFinalise();


  /**
   * Merge in class and package definitions from other, except where the current schema already has
   * a definition for the given type or package.
   *
   * Pre_state: state = State_includes_pending
   * Pre_other_valid: includes_to_process.has (included_schema.schema_id)
   * @param        other
   */
  abstract public void merge(BmmSchema other);


  /**
   * Main validation prior to generation of bmm_model.
   */
  public void validate()
  {
  }


  /**
   * Populate bmm_model from schema.
   * Pre_state: state = P_BMM_PACKAGE_STATE.State_includes_processed
   */
  abstract public void createBmmModel();


  /**
   * True when validation may be commenced.
   * Post_state: state = State_includes_processed
   * @return       boolean
   */
  public boolean readToValidate()
  {
    //TODO
    return false;
  }


  /**
   * Identifier of this schema, used for stating inclusions and identifying files. Formed as:
   *
   * rm_publisher '' _schema_name '' _rm_release
   *
   * E.g. 'openehr_rm_ehr_1.0.4'.
   * @return       String
   */
  public String schemaId()
  {
    //TODO
    return null;
  }


}
