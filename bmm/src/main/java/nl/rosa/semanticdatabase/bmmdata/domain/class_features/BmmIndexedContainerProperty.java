package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmIndexedContainerType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Class BmmIndexedContainerProperty
 * Meta-type of for properties of linear container type, such as Hash<Index_type,
 * T> etc.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@DiscriminatorValue("BBE_BD_BCE_BCS_BP_BCP_BICP")
public class BmmIndexedContainerProperty extends BmmContainerProperty {
  /**
   * 1..1
   * (redefined)
   * type: BMM_INDEXED_CONTAINER_TYPE
   * Declared or inferred static type of the entity.
   */
  @NonNull
  @Getter
  @Setter
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
