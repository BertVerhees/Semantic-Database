/*
 * component:   "openEHR Reference Implementation"
 * description: "Class DvStateTest"
 * keywords:    "unit test"
 *
 * author:      "Rong Chen <rong@acode.se>"
 * support:     "Acode HB <support@acode.se>"
 * copyright:   "Copyright (c) 2004 Acode HB, Sweden"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL: http://svn.openehr.org/ref_impl_java/BRANCHES/RM-1.0-update/libraries/src/test/org/openehr/rm/datatypes/basic/DvStateTest.java $"
 * revision:    "$LastChangedRevision: 50 $"
 * last_change: "$LastChangedDate: 2006-08-10 13:21:46 +0200 (Thu, 10 Aug 2006) $"
 */
/**
 * DvStateTest
 *
 * @author Rong Chen
 * @version 1.0 
 */
package nl.rosa.semanticdatabase.base.datavalues;


import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.text.DvCodedText;
import nl.rosa.semanticdatabase.base.identification.TerminologyId;
import nl.rosa.semanticdatabase.base.terminology.TestCodeSetAccess;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DvStateTest {

    @Test
    public void testEquals() throws Exception {
        DvCodedText codeOne = new DvCodedText("some text",
                TestCodeSetAccess.ENGLISH, TestCodeSetAccess.LATIN_1,
                new CodePhrase(new TerminologyId("test terms"), "00001"));
        DvState stateOne = new DvState(codeOne, false);

        DvCodedText codeTwo = new DvCodedText("some text",
                TestCodeSetAccess.ENGLISH, TestCodeSetAccess.LATIN_1,
                new CodePhrase(new TerminologyId("test terms"), "00001"));
        DvState stateTwo = new DvState(codeTwo, false);

        assertAll(
                () -> assertTrue(stateOne.equals(stateTwo)),
                () -> assertTrue(stateTwo.equals(stateOne))
        );

        DvState stateThree = new DvState(codeTwo, true);
        assertAll(
                () -> assertFalse(stateOne.equals(stateThree)),
                () -> assertFalse(stateThree.equals(stateOne)),
                () -> assertFalse(stateTwo.equals(stateThree)),
                () -> assertFalse(stateThree.equals(stateTwo))
        );
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
 *  The Original Code is DvStateTest.java
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