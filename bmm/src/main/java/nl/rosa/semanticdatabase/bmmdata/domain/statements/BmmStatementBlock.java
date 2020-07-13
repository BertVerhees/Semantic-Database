package nl.rosa.semanticdatabase.bmmdata.domain.statements;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmParameter;

import javax.persistence.Entity;
import java.util.*;

/**
 * Class BmmStatementBlock
 * A statement 'block' corresponding to the programming language concept of the
 * same name. May be used to establish scope in specific languages.
 */
public class BmmStatementBlock implements BmmStatementItem {
 /**
  * 0..1
  * items: List<BMM_STATEMENT_ITEM>
  * Child blocks of the current block.
  */
  private Set<BmmStatementItem> items;
 public void addItem(@NonNull BmmStatementItem value){
  if(items==null){
   items = new HashSet<>();
  }
  items.add(value);
 }
 public void addItems(Set<BmmStatementItem> items){
  items.forEach(item -> addItem(item));

 }
 public void removeItem(BmmStatementItem item){
  if(items!=null) {
   items.remove(item);
  }
 }
 public void removeItems(Collection<BmmStatementItem> items){
  items.forEach(this::removeItem);
 }
 void setItems(Set<BmmStatementItem> items) {
  this.items = items;
 }
 Set<BmmStatementItem> getItems() {
  return items;
 }
 public Set<BmmStatementItem> items() {
  return Collections.unmodifiableSet(items);
 }

 public void removeItems(Set<BmmStatementItem> items) {
  this.items.removeAll(items);
 }
}
