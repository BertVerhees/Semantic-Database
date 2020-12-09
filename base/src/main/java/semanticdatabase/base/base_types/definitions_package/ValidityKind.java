package semanticdatabase.base.base_types.definitions_package;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * <p>
 * An enumeration of three values that may commonly occur in constraint models.
 * Use as the type of any attribute within this model, which expresses constraint on some attribute in a class in a reference model.
 * For example to indicate validity of Date/Time fields.
 */
public enum ValidityKind {

    /**
     * Constant to indicate mandatory presence of something.
     */
    mandatory,

    /**
     * Constant to indicate optional presence of something.
     */
    optional,

    /**
     * Constant to indicate disallowed presence of something.
     */
    prohibited

}
