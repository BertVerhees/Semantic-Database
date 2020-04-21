package nl.rosa.semanticdatabase.archetypeobjectmodel.adl14;

/**
 * Interface for generating  codes for the synthesized id, value and valueset codes
 */
public interface IdCodeGenerator {

    String generateNextIdCode();
    String generateNextValueCode();
    String generateNextValueSetCode();

    String generateNextSpecializedIdCode(String nodeId);
}
