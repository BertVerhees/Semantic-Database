package nl.rosa.semanticdatabase.bmmdata.services.persistence_model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Default created on 31-7-2020
 */

public class PBmmClass implements PBmmModelElement{
    /**
     * 0..1
     * documentation: String
     * Optional documentation of this element.
     * (********  inherits from PBmmModelElement)
     */
    @Getter
    @Setter
    private String documentation;

    /**
     * 1..1
     * name: String
     * Name of the class. Persisted attribute.
     */
    @Getter
    @Setter
    @NonNull
    private String name;

    /**
     * 0..1
     * ancestors: List<String>
     * List of immediate inheritance parents. If there are generic ancestors, use ancestor_defs instead.
     * Persisted attribute.
     */
    private Set<String> ancestors;
    public void addAncestor(@NonNull String value){
        if(ancestors==null){
            ancestors = new HashSet<>();
        }
        ancestors.add(value);
    }
    public void addAncestors(Set<String> ancestors){
        ancestors.forEach(ancestor -> addAncestor(ancestor));

    }
    public void removeAncestor(String ancestor){
        if(ancestors!=null) {
            ancestors.remove(ancestor);
        }
    }
    public void removeAncestors(Collection<String> ancestors){
        ancestors.forEach(this::removeAncestor);
    }
    public void removeAncestors(Set<String> ancestors) {
        this.ancestors.removeAll(ancestors);
    }
    void setAncestors(Set<String> ancestors) {
        this.ancestors = ancestors;
    }
    Set<String> getAncestors() {
        return ancestors;
    }
    public Set<String> ancestors() {
        return Collections.unmodifiableSet(ancestors);
    }
}
