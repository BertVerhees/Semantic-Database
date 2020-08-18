package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmClass;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Class BmmOperator
 * Definition of a symbolic operator associated with a function
 */
@EqualsAndHashCode(callSuper = true)
@Builder
public class BmmOperator extends Bmm {

  /**
   * 1..1
   * position: BMM_OPERATOR_POSITION
   * Position of operator in syntactic representation.
   */
  @NonNull
  @Getter
  @Setter
  private BmmOperatorPosition position;

  /**
   * 1..1
   * symbols: List<String>
   * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
   */
  @NonNull
  @Setter
  @Getter
  private Set<String> symbols = new HashSet<>();
  public void addSymbol(@NonNull String value){
    symbols.add(value);
  }
  public void addSymbols(Set<String> items){
    items.forEach(item -> addSymbol(item));

  }
  public void removeSymbol(String item){
    symbols.remove(item);
  }
  public void removeSymbols(Collection<String> items){
    items.forEach(this::removeSymbol);
  }
  void setSymbols(Set<String> items) {
    this.symbols = items;
  }
  Set<String> getSymbols() {
    return symbols;
  }
  public Set<String> symbols() {
    return Collections.unmodifiableSet(symbols);
  }

  public void removeSymbols(Set<String> items) {
    this.symbols.removeAll(items);
  }

  /**
   * 1..1
   * name: String
   * Formal name of the operator, e.g. 'minus' etc.
   */
  @NonNull
  @Getter
  @Setter
  private String name;

}
