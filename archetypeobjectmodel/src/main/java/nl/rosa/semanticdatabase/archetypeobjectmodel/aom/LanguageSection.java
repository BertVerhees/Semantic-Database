package nl.rosa.semanticdatabase.archetypeobjectmodel.aom;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.base.terminology.TerminologyCode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Model of the language section in ADL. In the AOM spec these are fields on the AuthoredResource, but this class is not
 * in the AOM spec and you should not need to use it directly. Use the methods on AuthoredResource instead.
 * It is included for proper ODIN parsing.
 * See AuthoredResource for more information about this design choice.
 */

@Getter
@Setter
public class LanguageSection extends ArchetypeModelObject {

    private TerminologyCode originalLanguage;
    private Map<String, TranslationDetails> translations = new ConcurrentHashMap<>();
}
