package nl.rosa.semanticdatabase.bmmdata.model.types;


/**
 * Class BmmUnitaryType
 * Parent of meta-nl.rosa.semanticdatabase.bmm.model.types that may be used as the type of any instantiated object
 * that is not a container object.
 */
public interface BmmUnitaryType extends BmmType {

        /**
         * 1..1
         * (effected)
         * Result = self.
         * @return
         */
        BmmUnitaryType unitaryType();
}
