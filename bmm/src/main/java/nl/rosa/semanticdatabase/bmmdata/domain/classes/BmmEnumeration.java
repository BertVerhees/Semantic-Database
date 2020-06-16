package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.literal_values.BmmLiteralValue;

import javax.persistence.*;
import java.util.List;
import java.util.Map;


/**
 * Class BmmEnumeration
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="bmm_enumeration")
public class BmmEnumeration extends BmmSimpleClass {
 /**
  * 0..1
  * item_names: List<String>
  * The list of names of the enumeration. If no values are supplied, the integer values 0, 1, 2, …​ are assumed.
   */
 @ElementCollection(targetClass = String.class)
 @Column(name = "item_names")
 protected List<String> itemNames;
  /**
   * 0..1
   * item_values: List<BMM_LITERAL_VALUE>
   * Optional list of specific values. Must be 1:1 with item_names list.
   */
  @OneToMany
  private List<BmmLiteralValue> itemValues;
  /**
   * 1..1
   * name_map (): Hash<String, String>
   * Map of item_names to item_values (stringified).
   */
  public Map<String,String> nameMap()
  {
    //TODO
    return null;
  }
}
