package nl.rosa.semanticdatabase.archetypeobjectmodel.rules;


import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.CPrimitiveObject;

public class Constraint<T extends CPrimitiveObject> extends Leaf {

    private T item;

    public Constraint() {

    }

    public Constraint(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
