/*
 * UUIDTest.java
 * JUnit based test
 *
 * Created on July 10, 2006, 4:27 PM
 */

package nl.rosa.semanticdatabase.base.identification;


import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @author yinsulim
 */
public class UUIDTest {
    
    public void testConstructorTakeString() {
        assertNotNull(new UUid("128-1-1-12-15"));
    }
}
