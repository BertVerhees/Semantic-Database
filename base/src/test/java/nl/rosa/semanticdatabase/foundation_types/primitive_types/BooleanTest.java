package nl.rosa.semanticdatabase.foundation_types.primitive_types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Default created on 28-11-2020
 */

class BooleanTest {

    @Test
    void conjunction() {
    }

    @Test
    void semistrictConjunction() {
    }

    @Test
    void disjunction() {
    }

    @Test
    void semistrictDisjunction() {
    }

    @Test
    void exclusiveDisjunction() {
    }

    @Test
    void implication() {
    }

    @Test
    void negation() {
    }

    @Test
    void isEqual() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
        Boolean b = new Boolean(true);
        java.lang.String out = b.toString();
        assertEquals("True", out);
    }
}