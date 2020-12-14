/*
 * component:   "openEHR Reference Implementation"
 * description: "Class ObjectID"
 * keywords:    "support"
 *
 * author:      "Rong Chen <rong@acode.se>"
 * support:     "Acode HB <support@acode.se>"
 * copyright:   "Copyright (c) 2004 Acode HB, Sweden"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL: http://svn.openehr.org/ref_impl_java/TRUNK/libraries/src/java/org/openehr/rm/support/identification/ObjectVersionID.java $"
 * revision:    "$LastChangedRevision: 2 $"
 * last_change: "$LastChangedDate: 2005-10-12 22:20:08 +0100 (Wed, 12 Oct 2005) $"
 */
package nl.rosa.semanticdatabase.base.identification;


/**
 * Globally unique identifier for one version of a versioned object.
 * <p>
 * The syntax of the value attribute is as follows:
 * <blockquote>objectID::creatingSystemID::versionTreeID</blockquote>
 * </p>
 * <p>Instances of this class are immutable.</p>
 *
 * @author Yin Su Lim
 * @version 1.0
 */

public class ObjectVersionId extends UidBasedId {

    /**
     * Create ObjectVersionID by string value
     *
     * @param value
     * @throws IllegalArgumentException if value is empty
     */
    public ObjectVersionId(String value) {
        super(value);
        loadValue(value);
    }

    public ObjectVersionId(String objectId, String creatingSystemId, String versionTreeId) {
        this(objectId + "::" + creatingSystemId + "::" + versionTreeId);
    }

    public ObjectVersionId(Uid objectID, HierObjectId creatingSystemID,
                           VersionTreeId versionTreeID) {
        this(objectID.toString() + "::" + creatingSystemID.toString() + "::"
                + versionTreeID.toString());
        this.objectId = objectId;
        this.creatingSystemId = creatingSystemId;
        this.versionTreeId = versionTreeId;
    }

    private void loadValue(String value) {
        // Steps for value checking:
        // 1. Check if value contains any :: or starts with ::
        int doubleColons = value.indexOf("::");
        if (doubleColons <= 0) {
            throw new IllegalArgumentException("bad format, missing objectId");
        }
        // 2. Check how many segments in the value
        String[] splits = value.split("::");
        int segments = splits.length;
        if(segments < 3) {
            throw new IllegalArgumentException("bad format, missing creatingSystemId or versionTreeId");
        }
        if(segments > 4) {
            throw new IllegalArgumentException("bad format, too many segments or '::'");
        }
        // 3. Construct objects for each segment
        //the patterns below are for sorting only, the correct syntax
        //checking is handled by the UID sublcasses.
        if (splits[0].matches(UUid.SIMPLE_UUID_PATTERN)) { //pattern for UUID
            objectId = new UUid(value.substring(0, doubleColons));
        } else if (splits[0].matches("(\\d)+(\\.(\\d)+)*")) { //for ISO_OID
            objectId = new IsoOID(value.substring(0, doubleColons));
        } else if (splits[0].matches("(\\w|-)+(\\.(\\w|-)+)*")){ //for InternetID, 
            objectId = new InternetId(value.substring(0, doubleColons));
        } else {
            throw new IllegalArgumentException("wrong format: " + splits[0]);
        }
        if(segments == 4) {
            creatingSystemId = new HierObjectId(splits[1] + "::" + splits[2]);
            versionTreeId = new VersionTreeId(splits[3]);
        } else {
            creatingSystemId = new HierObjectId (splits[1]);
            versionTreeId = new VersionTreeId(splits[2]);
        }
    }

    /**
     * Unique identifier that identifies one version. It is
     * normally the unique identifier of the version container
     * containing the version referred to by this objectVersionID
     * instance.
     *
     * @return objectID
     */
    public Uid objectId() {
        return objectId;
    }

    /**
     * Tree identifier of this version with prespect to other versions
     * in the same version tree, as either 1 or 3 part dot-separated  numbers
     * e.g. "1" , "2.1.4"
     *
     * @return versionTreeID
     */
    public VersionTreeId versionTreeId() {
        return versionTreeId;
    }

    /**
     * Identifier of the system that created the Version
     * corresponding to this ObjectVersionID
     *
     * @return creatingSystemID
     */
    public HierObjectId creatingSystemId() {
        return creatingSystemId;
    }

    @Override
    public Uid root() {
        return objectId();
    }

    @Override
    public String extension() {
        return creatingSystemId.getValue() + "::" + versionTreeId.getValue();
    }

    //POJO start
    ObjectVersionId() {
    }

    public void setValue(String value) {
        loadValue(value);
        super.setValue(value);
    }
    // POJO end

    /* fields */
    private Uid objectId;
    private VersionTreeId versionTreeId;
    private HierObjectId creatingSystemId;
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
 *  The Original Code is ObjectVersionID.java
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