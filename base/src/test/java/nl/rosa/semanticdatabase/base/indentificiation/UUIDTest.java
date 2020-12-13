/*
 * UUIDTest.java
 * JUnit based test
 *
 * Created on July 10, 2006, 4:27 PM
 */

package nl.rosa.semanticdatabase.base.indentificiation;

import junit.framework.*;

/**
 *
 * @author yinsulim
 */
public class UUIDTest extends TestCase {
    
    public UUIDTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(UUIDTest.class);
        
        return suite;
    }
    
    public void testConstructorTakeString() {
        assertNotNull(new UUID("128-1-1-12-15"));
    }
}
