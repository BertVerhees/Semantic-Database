package nl.rosa.semanticdatabase.base.identification;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */


public class HierObjectId extends UidBasedId {

    private Uid root;   // mandatory
    private String extension;

    public HierObjectId() {
    }

    public HierObjectId(String value) {
        super(value);
        loadValue(value);
    }

    public HierObjectId(String root, String extension) {
        this(extension == null ? root : root + "::" + extension);
    }

    private void loadValue(String value) {
        int doubleColons = value.indexOf("::");
        // Check for root segment
        if (doubleColons == 0) {
            throw new IllegalArgumentException("bad format, missing root");
        }
        //the patterns below are for sorting only, the correct syntax
        //checking is handled by the UID sublcasses.
        String rootStr = null;
        if(doubleColons > 0) {
            rootStr = value.substring(0, doubleColons);
        } else {
            rootStr = value;
        }
        if (rootStr.matches(UUid.SIMPLE_UUID_PATTERN)) {
            root = new UUid(rootStr);
        } else if (rootStr.matches("(\\d)+(\\.(\\d)+)*")) { //for ISO_OID
            //System.out.println("in ISO");
            root = new IsoOID(rootStr);
        } else if (rootStr.matches("(\\w)+(\\.(\\w)+)*")){ //for InternetID,
            root = new InternetId(rootStr);
        } else {
            throw new IllegalArgumentException("wrong format");
        }

        if( 0 < doubleColons && doubleColons < (value.length() - 2)) {
            extension = value.substring(doubleColons + 2);
        }
    }
}
