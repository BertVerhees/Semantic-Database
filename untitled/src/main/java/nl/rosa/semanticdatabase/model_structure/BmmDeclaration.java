package nl.rosa.semanticdatabase.referencemodel.model_structure;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Default created on 5-5-2020
 * Meta-type of BMM declared model elements.
 * A declaration is a an element of a model specified by an author within a model definition within a context,
 * which defines the scope of the element. Thus, a class definition and its property and routine definitions are model elements,
 * but Types are not, since they are derived from model elements.
 */
@Getter
@Setter
@Builder(access = AccessLevel.PACKAGE)
public class BmmDeclaration {
    /**
     * Name of this model element.
     */
    protected String name;

    //TODO
}
