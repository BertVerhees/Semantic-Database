/*
 * component:   "openEHR Reference Implementation"
 * description: "Class ArchetypeIdTest"
 * keywords:    "unit test"
 *
 * author:      "Rong Chen <rong@acode.se>"
 * support:     "Acode HB <support@acode.se>"
 * copyright:   "Copyright (c) 2004 Acode HB, Sweden"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL: http://svn.openehr.org/ref_impl_java/BRANCHES/RM-1.0-update/libraries/src/test/org/openehr/rm/support/identification/ArchetypeIdTest.java $"
 * revision:    "$LastChangedRevision: 2 $"
 * last_change: "$LastChangedDate: 2005-10-12 23:20:08 +0200 (Wed, 12 Oct 2005) $"
 */
/**
 * ArchetypeIdTest
 *
 * @author Rong Chen
 * @version 1.0 
 */
package nl.rosa.semanticdatabase.base.indentificiation;

import nl.rosa.semanticdatabase.base.identification.ArchetypeId;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArchetypeIdTest{

    public void testConstructorTakesStringValue() throws Exception {
        for (int i = 0; i < STRING_VALUE.length; i++) {
            assertArchetypeId(new ArchetypeId(STRING_VALUE[ i ]), i);
        }
    }

    public void testConstructorTakesSections() throws Exception {
        for (int i = 0; i < SECTIONS.length; i++) {

            ArchetypeId aid = new ArchetypeId(new StringBuilder(SECTIONS[ i ][ 0 ])
                    .append(SECTIONS[ i ][ 1 ])
                    .append(SECTIONS[ i ][ 2 ])
                    .append(SECTIONS[ i ][ 3 ])
                    .append(SECTIONS[ i ][ 4 ])
                    .append(SECTIONS[ i ][ 5 ])
                    .toString()
            );

            assertArchetypeId(aid, i);
        }
    }

    public void testConstructorWithInvalidValue() {
        String[] data = {
            // rm entity part
            "openehr-ehr_rm.physical_examination.v2", // too less sections
            "openehr-ehr_rm-section-entry.physical_examination-prenatal.v1", // to many sections
            "openehr.ehr_rm-entry.progress_note-naturopathy.v2", // too many axes

            // domain concept part
            "openehr-ehr_rm-section.physical+examination.v2", // illegal char

            // version part
            "hl7-rim-act.progress_note.", // missing version
            "openehr-ehr_rm-entry.progress_note-naturopathy"  // missing version
        };

        for (int i = 0; i < data.length; i++) {
            try {
                new ArchetypeId(data[ i ]);
                fail("should fail on " + data[ i ]);
            } catch (Exception e) {
                assertTrue(e instanceof IllegalArgumentException);
            }
        }
    }

    public void testEqualsIgnoreVersionID() throws Exception {
        String base1 = "openehr-ehr_rm-section.physical_examination.";
        String base2 = "openehr-ehr_rm-section.simple_medication.";

        // same base
        assertEqualsIgnoreVersion(base1, "v1", base1, "v1", true);
        assertEqualsIgnoreVersion(base1, "v1", base1, "v2", true);
        assertEqualsIgnoreVersion(base1, "v2", base1, "v1", true);

        // different base
        assertEqualsIgnoreVersion(base1, "v1", base2, "v1", false);
        assertEqualsIgnoreVersion(base1, "v1", base2, "v2", false);
        assertEqualsIgnoreVersion(base1, "v2", base2, "v1", false);
    }

    private void assertEqualsIgnoreVersion(String baseOne,
                                           String versionOne,
                                           String baseTwo,
                                           String versionTwo,
                                           boolean expected) {
        assertEquals(expected,
                new ArchetypeId(baseOne + versionOne).equalsIgnoreVersionID(
                        new ArchetypeId(baseTwo + versionTwo)));

    }

    public void testBase() {
        String base = "openehr-ehr_rm-section.physical_examination";
        assertEquals(base, new ArchetypeId(base + ".v1").base());
    }
    
    public void testMultipleSpecialisation() {
    	ArchetypeId aid = null;
    	try {
    		aid = new ArchetypeId("openEHR-EHR-CLUSTER.exam-generic-joint.v1");
    		
    		List<String> list = new ArrayList<String>();
    		list.add("generic");
    		list.add("joint");
    		
    		assertEquals("wrong specialisation", list, aid.specialisation());
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    		fail("failed to create ArchetypeId with multiple specialisation");
    	}
    }
    
    public void testWithConceptInSwedish() {
    	ArchetypeId aid = null;
    	try {
    		// Omvrdnadsanteckning
    		aid = new ArchetypeId(
    				"openEHR-EHR-CLUSTER.Omv\u00E5rdnadsanteckning.v1");
    		
    		fail("expect to fail on Swedish concept name");
    		
    	} catch(Exception e) {
    		
    	}
    }
	
	public void testArchetypeBase() {
    	ArchetypeId aid = null;
    	try {
    		aid = new ArchetypeId("openEHR-EHR-CLUSTER.exam.v1");
    		assertEquals("wrong base", "openEHR-EHR-CLUSTER.exam", aid.base());
			
			aid = new ArchetypeId("openEHR-EHR-CLUSTER.exam-generic.v1");
    		assertEquals("wrong base", "openEHR-EHR-CLUSTER.exam-generic", aid.base());
    		
			aid = new ArchetypeId("openEHR-EHR-CLUSTER.exam-generic-joint.v1");
    		assertEquals("wrong base", "openEHR-EHR-CLUSTER.exam-generic-joint", aid.base());
    		
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    		fail("failed to create ArchetypeId for testing base");
    	}
    }


    // assert content of archetype id
    private void assertArchetypeId(ArchetypeId aid, int i) {
        assertEquals("value", STRING_VALUE[ i ], aid.getValue());
        assertEquals("contextID", null, aid.contextID());
        assertEquals("localID", STRING_VALUE[ i ], aid.localID());

        assertEquals("rmOriginator", SECTIONS[ i ][ 0 ],
                aid.rmOriginator());
        assertEquals("rmName", SECTIONS[ i ][ 1 ], aid.rmName());
        assertEquals("rmEntity", SECTIONS[ i ][ 2 ],
                aid.rmEntity());
        assertEquals("conceptName", SECTIONS[ i ][ 3 ],
                aid.conceptName());
        
        List<String> list = new ArrayList<String>();
        if(SECTIONS[ i ][ 4 ] != null) {
        	list.add(SECTIONS[ i ][ 4 ]);
        }
        assertEquals("specialisation", list, aid.specialisation());

        assertEquals("qualifiedRmEntity", AXES[ i ][ 0 ],
                aid.qualifiedRmEntity());
        assertEquals("domainConcept", AXES[ i ][ 1 ],
                aid.domainConcept());
        assertEquals("versionID", AXES[ i ][ 2 ],
                aid.versionID());
    }

    private static String[] STRING_VALUE = {
        "openehr-ehr_rm-section.physical_examination.v2",
        "openehr-ehr_rm-section.physical_examination-prenatal.v1",
        "hl7-rim-act.progress_note.v1",
        "openehr-ehr_rm-ENTRY.progress_note-naturopathy.draft"
    };

    private static String[][] SECTIONS = {
        {"openehr", "ehr_rm", "section", "physical_examination",
         null, "v2"},
        {"openehr", "ehr_rm", "section", "physical_examination",
         "prenatal", "v1"},
        {"hl7", "rim", "act", "progress_note", null, "v1"},
        {"openehr", "ehr_rm", "ENTRY", "progress_note", "naturopathy", "draft"}
    };

    private static String[][] AXES = {
        {"openehr-ehr_rm-section", "physical_examination", "v2"},
        {"openehr-ehr_rm-section", "physical_examination-prenatal",
         "v1"},
        {"hl7-rim-act", "progress_note", "v1"},
        {"openehr-ehr_rm-ENTRY", "progress_note-naturopathy", "draft"}
    };

    public String base() {
        return new StringBuffer(toQualifiedRmEntity(rmOriginator,
                rmName, rmEntity))
                .append(AXIS_SEPARATOR)
                .append(toDomainConcept(conceptName, specialisation))
                .toString();
    }

}
/*
 *  ***** BEGIN LICENSE BLOCK *****
 *  Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 *  The contents of this file are subject to the Mozilla Public License Version
 *  1.1 (the 'License'); you may not use this file except in compliance with
 *  the License. You may obtain a copy of the License at
 *  http://www.mozilla.org/MPL/
 *
 *  Software distributed under the License is distributed on an 'AS IS' basis,
 *  WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 *  for the specific language governing rights and limitations under the
 *  License.
 *
 *  The Original Code is ArchetypeIdTest.java
 *
 *  The Initial Developer of the Original Code is Rong Chen.
 *  Portions created by the Initial Developer are Copyright (C) 2003-2004
 *  the Initial Developer. All Rights Reserved.
 *
 *  Contributor(s):
 *
 * Software distributed under the License is distributed on an 'AS IS' basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 *  ***** END LICENSE BLOCK *****
 */