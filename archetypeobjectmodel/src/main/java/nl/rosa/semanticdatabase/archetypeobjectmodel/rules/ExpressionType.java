package nl.rosa.semanticdatabase.archetypeobjectmodel.rules;

/**
 * TODO: this should contain all primitive nl.rosa.semanticdatabase.bmm.model.types and primitive nl.rosa.semanticdatabase.bmm.model.types should be merged into this
 * Created by pieter.bos on 27/10/15.
 */
public enum ExpressionType {
     BOOLEAN, STRING, INTEGER, REAL;

    public static ExpressionType fromString(String string) {
        switch(string) {
            case "Boolean":
                return BOOLEAN;
            case "String":
                return STRING;
            case "Integer":
                return INTEGER;
            case "Real":
                return REAL;
        }
        return null;
    }

    public String toString() {
        switch(this) {
            case BOOLEAN:
                return "Boolean";
            case STRING:
                return "String";
            case INTEGER:
                return "Integer";
            case REAL:
                return "Real";
        }
        return null;
    }
}
