package nl.rosa.semanticdatabase.utils.tree;

import java.util.*;
import java.util.stream.Stream;

/**
 * Default created on 3-7-2020
 */

public class Tree {
    private Object value;
    private List<Tree> children = new LinkedList<>();

    public Tree(Object value, Collection<Tree> children) {
        super();
        this.value = value;
        this.children.addAll(children);
    }

    public Tree(Object value, Tree... children) {
        this(value, Arrays.asList(children));
    }

    public Object getValue() {
        return value;
    }

    public List<Tree> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public Stream<Tree> flattened() {
        return Stream.concat(
                Stream.of(this),
                children.stream().flatMap(Tree::flattened)
        );
    }
}
