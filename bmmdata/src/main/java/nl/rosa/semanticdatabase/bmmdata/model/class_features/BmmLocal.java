package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmEffectiveType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmUnitaryType;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Class BmmLocal
 */
public class BmmLocal extends BmmBaseEntity implements BmmVariable {
  /**
   * BmmVariable
   *  BmmInstantiable
   *    BmmTypedFeature
   *      BmmTyped
   *        BmmType
   *  BmmClassEntity
   *    BmmDeclaration
   */

  /**
   * BmmDeclaration
   */
  @NotNull private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;

  @Override
  public Boolean isRootScope(){
    return scope.equals(this);
  }
  /**
   * BmmClassEntity
   */
  private Boolean isSynthesisedGeneric;

  /**
   * BmmVariable
   */
  @NotNull private BmmRoutine scope;

  // BmmTypedFeature
  /**
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   * {default = false}   */

  private Boolean isNullable;


  /**
   * BmmEntity
   */
  private Boolean isAbstract;
  private Boolean isPrimitive;
  // BmmTyped
  /**
   * Declared or inferred static type of the entity.
   */
  private BmmType type;


  //
  // Constructors
  //
  public BmmLocal () { };

  /**
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() =
   * 'Boolean').
   * @return       Boolean
   */
  public Boolean isBoolean(){
    //TODO
    return false;
  }


  /**
   * Formal string form of the type as per UML.
   * @return
   */
  @Override
  public String typeName() {
    //TODO
    return null;
  }

  /**
   * Completely flattened list of type names, flattening out all generic parameters.
   * @return
   */
  @Override
  public List<String> flattenedTypeList() {
    //TODO
    return null;
  }

  /**
   * Signature form of the type name, which for generics includes generic parameter constrainer nl.rosa.semanticdatabase.bmm.model.types E.g. Interval<T:Ordered>.
   *
   * Defaults to the value of type_name().
   * @return
   */
  @Override
  public String typeSignature() {
    //TODO
    return null;
  }

  /**
   * Type with any container abstracted away.
   * @return
   */
  @Override
  public BmmUnitaryType unitaryType() {
    //TODO
    return null;
  }

  /**
   * Type with any container abstracted away, and any formal parameter replaced by its effective constraint type.
   * @return
   */
  @Override
  public BmmEffectiveType effectiveType() {
    //TODO
    return null;
  }


  /**
   * Formal signature of this element, in the form:
   *
   * name [arg1_name: T_arg1, …​][:T_value]
   *
   * Specific implementations in descendants.
   * @return
   */
  @Override
  public BmmSignature signature() {
    //TODO
    return null;
  }

  // BmmEntity
  @Override
  public Boolean isAbstract() {
    //TODO
    return false;
  }

  @Override
  public Boolean isPrimitive() {
    //TODO
    return false;
  }

  @Override
  public void setScope(BmmRoutine newVar) {
    this.scope = newVar;
  }
  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar) {
    this.scope = (BmmRoutine) newVar;
  }

  public @NotNull String getName() {
    return this.name;
  }

  public Map<String, Object> getDocumentation() {
    return this.documentation;
  }

  public Map<String, Object> getExtensions() {
    return this.extensions;
  }

  public Boolean getIsSynthesisedGeneric() {
    return this.isSynthesisedGeneric;
  }

  public @NotNull BmmRoutine getScope() {
    return this.scope;
  }

  public Boolean getIsNullable() {
    return this.isNullable;
  }

  public Boolean getIsAbstract() {
    return this.isAbstract;
  }

  public Boolean getIsPrimitive() {
    return this.isPrimitive;
  }

  public BmmType getType() {
    return this.type;
  }

  public void setName(@NotNull String name) {
    this.name = name;
  }

  public void setDocumentation(Map<String, Object> documentation) {
    this.documentation = documentation;
  }

  public void setExtensions(Map<String, Object> extensions) {
    this.extensions = extensions;
  }

  public void setIsSynthesisedGeneric(Boolean isSynthesisedGeneric) {
    this.isSynthesisedGeneric = isSynthesisedGeneric;
  }

  public void setIsNullable(Boolean isNullable) {
    this.isNullable = isNullable;
  }

  public void setIsAbstract(Boolean isAbstract) {
    this.isAbstract = isAbstract;
  }

  public void setIsPrimitive(Boolean isPrimitive) {
    this.isPrimitive = isPrimitive;
  }

  public void setType(BmmType type) {
    this.type = type;
  }

  public Boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof BmmLocal)) return false;
    final BmmLocal other = (BmmLocal) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
    final Object this$documentation = this.getDocumentation();
    final Object other$documentation = other.getDocumentation();
    if (this$documentation == null ? other$documentation != null : !this$documentation.equals(other$documentation))
      return false;
    final Object this$extensions = this.getExtensions();
    final Object other$extensions = other.getExtensions();
    if (this$extensions == null ? other$extensions != null : !this$extensions.equals(other$extensions))
      return false;
    final Object this$isSynthesisedGeneric = this.getIsSynthesisedGeneric();
    final Object other$isSynthesisedGeneric = other.getIsSynthesisedGeneric();
    if (this$isSynthesisedGeneric == null ? other$isSynthesisedGeneric != null : !this$isSynthesisedGeneric.equals(other$isSynthesisedGeneric))
      return false;
    final Object this$scope = this.getScope();
    final Object other$scope = other.getScope();
    if (this$scope == null ? other$scope != null : !this$scope.equals(other$scope)) return false;
    final Object this$isNullable = this.getIsNullable();
    final Object other$isNullable = other.getIsNullable();
    if (this$isNullable == null ? other$isNullable != null : !this$isNullable.equals(other$isNullable))
      return false;
    final Object this$isAbstract = this.getIsAbstract();
    final Object other$isAbstract = other.getIsAbstract();
    if (this$isAbstract == null ? other$isAbstract != null : !this$isAbstract.equals(other$isAbstract))
      return false;
    final Object this$isPrimitive = this.getIsPrimitive();
    final Object other$isPrimitive = other.getIsPrimitive();
    if (this$isPrimitive == null ? other$isPrimitive != null : !this$isPrimitive.equals(other$isPrimitive))
      return false;
    final Object this$type = this.getType();
    final Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
    return true;
  }

  protected Boolean canEqual(final Object other) {
    return other instanceof BmmLocal;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $documentation = this.getDocumentation();
    result = result * PRIME + ($documentation == null ? 43 : $documentation.hashCode());
    final Object $extensions = this.getExtensions();
    result = result * PRIME + ($extensions == null ? 43 : $extensions.hashCode());
    final Object $isSynthesisedGeneric = this.getIsSynthesisedGeneric();
    result = result * PRIME + ($isSynthesisedGeneric == null ? 43 : $isSynthesisedGeneric.hashCode());
    final Object $scope = this.getScope();
    result = result * PRIME + ($scope == null ? 43 : $scope.hashCode());
    final Object $isNullable = this.getIsNullable();
    result = result * PRIME + ($isNullable == null ? 43 : $isNullable.hashCode());
    final Object $isAbstract = this.getIsAbstract();
    result = result * PRIME + ($isAbstract == null ? 43 : $isAbstract.hashCode());
    final Object $isPrimitive = this.getIsPrimitive();
    result = result * PRIME + ($isPrimitive == null ? 43 : $isPrimitive.hashCode());
    final Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    return result;
  }

  public String toString() {
    return "BmmLocal(name=" + this.getName() + ", documentation=" + this.getDocumentation() + ", extensions=" + this.getExtensions() + ", isSynthesisedGeneric=" + this.getIsSynthesisedGeneric() + ", scope=" + this.getScope() + ", isNullable=" + this.getIsNullable() + ", isAbstract=" + this.getIsAbstract() + ", isPrimitive=" + this.getIsPrimitive() + ", type=" + this.getType() + ")";
  }
}
