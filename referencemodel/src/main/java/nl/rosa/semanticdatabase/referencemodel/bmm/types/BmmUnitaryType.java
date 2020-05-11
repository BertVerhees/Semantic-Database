package nl.rosa.semanticdatabase.referencemodel.bmm.types;


/**
 * Class BmmUnitaryType
 * Parent of meta-types that may be used as the type of any instantiated object
 * that is not a container object.
 */
public interface BmmUnitaryType extends BmmType {

        BmmUnitaryType unitaryType();
}
