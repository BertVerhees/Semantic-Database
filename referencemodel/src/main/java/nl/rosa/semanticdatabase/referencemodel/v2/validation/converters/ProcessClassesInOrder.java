package nl.rosa.semanticdatabase.referencemodel.v2.validation.converters;

import nl.rosa.semanticdatabase.referencemodel.persistence.validation.RMDefinitions;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMClass;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMGenericParameter;
import nl.rosa.semanticdatabase.referencemodel.v2.persistence.PRMSchema;

import java.util.*;
import java.util.function.Consumer;

public class ProcessClassesInOrder {

    /**
     * Do some action to all primitive type and class objects
     * process in breadth first order of inheritance tree
     *
     * @param action
     * @param classesToProcess
     */
    public void doAllClassesInOrder(PRMSchema schema, Consumer<PRMClass> action, List<PRMClass> classesToProcess) {
        int attempts = schema.getClassDefinitions().size() * 10;
        int tries = 0;
        List<String> visitedClasses = new ArrayList<>();
        Queue<PRMClass> queue = new LinkedList<>();
        //Initial queue population
        for (PRMClass bmmClass : classesToProcess) {
            processClass(schema, action, visitedClasses, queue, bmmClass);
        }
        //Go through the queue and remove nodes whose ancestors have already been processed
        while (!queue.isEmpty() && tries < attempts) {
            PRMClass element = queue.remove();
            if (element == null) {

            } else {
                processClass(schema, action, visitedClasses, queue, element);
            }
            tries++;
        }
    }

    private void processClass(PRMSchema schema, Consumer<PRMClass> action, List<String> visitedClasses, Queue<PRMClass> queue, PRMClass bmmClass) {
        if (!visitedClasses.contains(bmmClass.getName().toUpperCase())) {
            boolean allAncestorsAndDependenciesVisited = true;
            for (String ancestor : bmmClass.getAncestorTypeNames()) {
                String ancestorClassName = RMDefinitions.typeNameToClassKey(ancestor);
                if (!visitedClasses.contains(ancestorClassName.toUpperCase())) {
                    allAncestorsAndDependenciesVisited = false;
                    PRMClass ancestorDef = schema.findClassOrPrimitiveDefinition(ancestorClassName);
                    queue.add(ancestorDef);
                }

            }
            if (bmmClass.isGeneric()) {
                Map<String, PRMGenericParameter> parameters = bmmClass.getGenericParameterDefs();
                for (PRMGenericParameter parameter : parameters.values()) {
                    String conformsTo = parameter.getConformsToType();
                    if (conformsTo != null && !visitedClasses.contains(conformsTo.toUpperCase())) {
                        allAncestorsAndDependenciesVisited = false;
                        PRMClass dependency = schema.findClassOrPrimitiveDefinition(conformsTo);
                        queue.add(dependency);
                    }
                }
            }
            if (!allAncestorsAndDependenciesVisited) {
                queue.add(bmmClass);
            } else {
                action.accept(bmmClass);
                visitedClasses.add(bmmClass.getName().toUpperCase());
            }
        }
    }
}
