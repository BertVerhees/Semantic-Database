package nl.rosa.semanticdatabase.referencemodel.model.internal.archetyped;

import java.util.List;

public class Pathable {
    /** Parent of this node in a compositional hierarchy.
     */
    protected Pathable parent;

    /** The item at a path (relative to this item); only valid for unique paths, i.e. paths that resolve to a single item.
    */
     public Object itemAtPath(String aPath){
        return null;
    }

    /** List of items corresponding to a non-unique path.
    */
     public List<Object> itemsAtPath(String aPath){
        return null;
    }

    /** True if the path exists in the data with respect to the current item.
    */
     public boolean pathExists(String aPath){
        return false;
    }

    /** True if the path corresponds to a single item in the data.
    */
     public boolean pathUnique(String aPath){
        return false;
    }

    /** The path to an item relative to the root of this archetyped structure.
    */
     public String pathOfItem(Pathable pathable){
        return null;
    }
}
