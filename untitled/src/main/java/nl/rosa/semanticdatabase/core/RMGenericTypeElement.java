package nl.rosa.semanticdatabase.referencemodel.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Default created on 2-5-2020
 */

public class RMGenericTypeElement extends RMTypeTypeElement implements Serializable {
    public RMGenericTypeElement() {
        genericParameters = new ArrayList<>();
    }

    /**
     * Generic parameters of the root_type in this type specifier. The order must match the order of the owning class’s
     * formal generic parameter declarations.
     */
    public List<RMTypeTypeElement> genericParameters;
    /**
     * The base class of this type.
     */
    public RMGenericClass baseClass;


    /**
     * Adds a generic parameter to the generic type definition.
     *
     * @param genericParameter
     */
    public void addGenericParameter(RMTypeTypeElement genericParameter) {
        this.genericParameters.add(genericParameter);
    }

    /**
     * Return the full name of the type including generic parameters, e.g. 'DV_INTERVAL&lt;T&gt;', 'TABLE&lt;List&lt;THING&gt;,String&gt;'.
     *
     * @return
     */
    @Override
    public String getTypeName() {
        StringBuilder builder = new StringBuilder();
        if(baseClass != null) {
            builder.append(baseClass.getName());
            builder.append("<");
            builder.append(genericParameters.stream().map( t -> t.getTypeName()).collect(Collectors.joining(",")));
            builder.append(">");
        } else {
            builder.append("No base class defined for type");
        }
        return builder.toString();
    }

}
