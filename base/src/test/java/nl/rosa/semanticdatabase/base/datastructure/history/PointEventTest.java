/*
 * component:   "openEHR Reference Implementation"
 * description: "Class PointEventTest"
 * keywords:    "unit test"
 *
 * author:      "Yin Su Lim <y.lim@chime.ucl.ac.uk>"
 * support:     "CHIME, UCL"
 * copyright:   "Copyright (c) 2006 UCL, UK"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL: http://svn.openehr.org/ref_impl_java/BRANCHES/RM-1.0-update/libraries/src/test/org/openehr/rm/datastructure/history/PointEventTest.java $"
 * revision:    "$LastChangedRevision: 50 $"
 * last_change: "$LastChangedDate: 2006-08-10 12:21:46 +0100 (Thu, 10 Aug 2006) $"
 */

/**
 * PointEventTest
 *
 * @author Yin Su Lim
 * @version 1.0 
 */
package nl.rosa.semanticdatabase.base.datastructure.history;

import nl.rosa.semanticdatabase.base.datastructure.DataStructureTestBase;
import nl.rosa.semanticdatabase.base.datastructures.Element;
import nl.rosa.semanticdatabase.base.datastructures.History;
import nl.rosa.semanticdatabase.base.datastructures.ItemSingle;

import nl.rosa.semanticdatabase.base.datastructures.PointEvent;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDateTime;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointEventTest extends DataStructureTestBase {

	@AfterEach
	protected void tearDown() throws Exception {
		element = null;
		pointEvent = null;
	}

	/**
	 * The fixture set up called before every test method.
	 */
	@BeforeEach
	protected void setUp() throws Exception {
		element = element("element name", "value");
		item = new ItemSingle(null, "at0001", text("point event item"), null,
				null, null, null, element);
		pointEvent = new PointEvent<ItemSingle>(null, "at0002",
				text("point event"), null, null, null, null, new DvDateTime(
						TIME), item, null);
		ItemSingle summary = new ItemSingle(null, "at0001",
				text("summary item"), null, null, null, null, element(
						"summary element", "summary content"));
		h = new History<ItemSingle>(null, "at0002", text("history"), null,
				null, null, null, new DvDateTime("2004-12-06T13:00:00"), null,
				DvDuration.getInstance("PT30m"),
				DvDuration.getInstance("PT3h"), summary);
	}

	@Test
	public void testPointEvent() {
		pointEvent = new PointEvent<ItemSingle>(null, "at0002",
				text("point event"), null, null, null, h, new DvDateTime(TIME),
				item, null);
		assertEquals(DvDuration.getInstance("PT10m"), pointEvent.offset());
		assertEquals(h, pointEvent.getParent());
	}

	@Test
	public void testCreatePointEventWithConvenientConstructor() {
		String nodeId = "at0002";
		DvText name = new DvText("point event");
		DvDateTime time = new DvDateTime(TIME);
		ItemSingle data = item;
		pointEvent = new PointEvent<ItemSingle>(nodeId, name, time, data);

		assertEquals(nodeId, pointEvent.getArchetypeNodeId());
		assertEquals(name, pointEvent.getName());
		assertEquals(time, pointEvent.getTime());
		assertEquals(data, pointEvent.getData());
	}

	private History<ItemSingle> h;
	private static final String TIME = "2004-12-06T13:10:00";
	private PointEvent<ItemSingle> pointEvent;
	private ItemSingle item;
	private Element element;
}

/*
 * ***** BEGIN LICENSE BLOCK ***** Version: MPL 1.1/GPL 2.0/LGPL 2.1
 * 
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the 'License'); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * 
 * Software distributed under the License is distributed on an 'AS IS' basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * The Original Code is PointEventTest.java
 * 
 * The Initial Developer of the Original Code is Rong Chen. Portions created by
 * the Initial Developer are Copyright (C) 2003-2004 the Initial Developer. All
 * Rights Reserved.
 * 
 * Contributor(s):
 * 
 * Software distributed under the License is distributed on an 'AS IS' basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * ***** END LICENSE BLOCK *****
 */