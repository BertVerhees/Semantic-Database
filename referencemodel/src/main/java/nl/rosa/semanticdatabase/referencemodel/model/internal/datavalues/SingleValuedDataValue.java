package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues;

public interface SingleValuedDataValue<Type> {

    Type getValue();

    void setValue(Type type);


}
