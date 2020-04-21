package nl.rosa.semanticdatabase.referencemodel.model.internal.rminfo;

/**
 * Representation of an ID of a reference model package, with a publisher and a package. For example OpenEHR-EHR, or CIMI-CORE
 * Created by:
 * User: BV, Date: 21-4-2020, Time: 15:36
 */
public class RMPackageId {
    private String publisher;
    private String aPackage;//package is reserved word in java

    public RMPackageId(String publisher, String aPackage) {
        this.publisher = publisher;
        this.aPackage = aPackage;
    }
}
