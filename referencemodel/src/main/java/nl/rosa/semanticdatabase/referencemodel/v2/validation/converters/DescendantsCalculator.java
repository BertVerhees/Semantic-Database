package nl.rosa.semanticdatabase.referencemodel.v2.validation.converters;


import nl.rosa.semanticdatabase.referencemodel.core.RMClass;
import nl.rosa.semanticdatabase.referencemodel.core.RMModel;

import java.util.Map;

public class DescendantsCalculator {

    public void calculateDescendants(RMModel model) {

        final Map<String, RMClass> classDefinitions = model.getClassDefinitions();

        for(RMClass bmmClass:classDefinitions.values()) {
            for(RMClass ancestor:bmmClass.getAncestors().values()) {
                ancestor.addImmediateDescendant(bmmClass.getName());
            }
        }
    }
}
