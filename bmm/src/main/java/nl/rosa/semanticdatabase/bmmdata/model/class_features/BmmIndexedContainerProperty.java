package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmIndexedContainerType;


/**
 * Class BmmIndexedContainerProperty
 * Meta-type of for properties of linear container type, such as Hash<Index_type,
 * T> etc.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmIndexedContainerProperty extends BmmContainerProperty {
  /**
   * 1..1
   * (redefined)
   * type: BMM_INDEXED_CONTAINER_TYPE
   * Declared or inferred static type of the entity.
   */
  @NonNull
  private BmmIndexedContainerType type;
  /**
   * 1..1
   * (redefined)
   * display_name (): String
   * Name of this property in form name: ContainerTypeName<IndexTypeName, …​>.
   * @return
   */
  public String displayName(){
    return null;
  }
}
