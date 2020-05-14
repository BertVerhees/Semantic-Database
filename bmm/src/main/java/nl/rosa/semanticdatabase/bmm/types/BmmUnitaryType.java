package nl.rosa.semanticdatabase.bmm.types;


/**
 * Class BmmUnitaryType
 * Parent of meta-nl.rosa.semanticdatabase.bmm.types that may be used as the type of any instantiated object
 * that is not a container object.
 */
public interface BmmUnitaryType extends BmmType {

        /**
         * Result = self.
         * @return
         */
        BmmUnitaryType unitaryType();
}
