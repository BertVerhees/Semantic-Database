package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmTupleType;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * Class ElTuple
 * Defines an array of optionally named items each of any type.
 */
public class ElTuple extends ElInstanceRef {
  /**
   * 0..1
   * items: List<EL_TUPLE_ITEM>
   * Items in the tuple, potentially with names. Typical use is to represent an argument list to routine call.
   */
  private Set<ElTupleItem> items;
  public void addItem(@NonNull ElTupleItem value){
    if(items==null){
      items = new HashSet<>();
    }
    items.add(value);
  }
  public void addItems(Set<ElTupleItem> items){
    items.forEach(item -> addItem(item));

  }
  public void removeItem(ElTupleItem item){
    if(items!=null) {
      items.remove(item);
    }
  }
  public void removeItems(Collection<ElTupleItem> items){
    items.forEach(this::removeItem);
  }
  public void removeItems(Set<ElTupleItem> items) {
    this.items.removeAll(items);
  }
  void setItems(Set<ElTupleItem> items) {
    this.items = items;
  }
  Set<ElTupleItem> getItems() {
    return items;
  }
  public Set<ElTupleItem> items() {
    return Collections.unmodifiableSet(items);
  }
  /**
   * 1..1
   * type: BMM_TUPLE_TYPE
   * Static type inferred from literal value.
   */
  @Getter
  @Setter
  @NonNull
  private BmmTupleType type;

  /**
   * 1..1
   * (effected)
   * eval_type (): BMM_TYPE
   * Return type.
   * @return
   */
  @Override
  @NonNull
  public BmmType evalType() {
    return null;
  }
}
