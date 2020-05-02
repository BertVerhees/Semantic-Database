package nl.rosa.semanticdatabase.referencemodel.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Default created on 2-5-2020
 */
@Getter
@Setter
public class GenericClass extends Clasz implements Serializable {
    private Map<String, GenericParameter> genericParameters;

    public GenericClass() {
        this.genericParameters = new HashMap<>();
    }

    public GenericClass(String name){
        this();
        this.setName(name);
    }

    /**
     * Returns shallow cloned list of generic parameter definitions; these are defined either directly on
     * this class or by the addition of an ancestor class which is generic.
     *
     * @return
     */
    public List<GenericParameter> getGenericParameters() {
        List<GenericParameter> parameters = new ArrayList<>();
        parameters.addAll(genericParameters.values());
        return parameters;
    }
    /**
     * Returns the internal bmm generic property map for this class.
     *
     * @return
     */
    public Map<String, GenericParameter> getGenericParameterIndex() {
        return genericParameters;
    }


    /**
     * Sets list of generic parameter definitions, keyed by name of generic parameter; these are defined either directly
     * on this class or by the addition of an ancestor class which is generic.
     *
     *
     * @param parameters
     */
    public void setGenericParameters(List<GenericParameter> parameters) {
        this.genericParameters.clear();
        parameters.forEach(param -> {
            this.genericParameters.put(param.getName().toUpperCase(), param);
        });
    }

    /**
     * Adds generic parameter definition to this generic class.
     *
     * @param genericParameter
     */
    public void addGenericParameter(GenericParameter genericParameter) {
        genericParameters.put(genericParameter.getName().toUpperCase(), genericParameter);
    }

    /**
     * Returns the generic parameter with the name provided.
     *
     * @param genericParameterName
     */
    public GenericParameter getGenericParameter(String genericParameterName) {
        return genericParameters.get(genericParameterName.toUpperCase());
    }

    /**
     * Removes the generic parameter from the set of generic parameters defined for this class if
     * the parameter exists in the collection.
     *
     * @param genericParameter
     * @return
     */
    public GenericParameter removeGenericParameter(GenericParameter genericParameter) {
        return genericParameters.remove(genericParameter.getName().toUpperCase());
    }

    /**
     * Removes a generic parameter of that name from the set of generic parameters defined for this class if a parameter
     * entry of that name exists in the collection.
     *
     * @param parameterName
     * @return
     */
    public GenericParameter removeGenericParameter(String parameterName) {
        return genericParameters.remove(parameterName.toUpperCase());
    }

    /**
     * Add suppliers from generic parameters.
     *
     * @return
     */
    public List<String> getSuppliers() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Signature form of the type, which for generics includes generic parameter constrainer types
     * E.g. Interval&lt;T:Ordered&gt;
     *
     * @return
     */
    @Override
    public String getTypeSignature() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Formal string form of the type as per UML.
     *
     * @return
     */
    @Override
    public String getTypeName() {
        List<GenericParameter> params = getGenericParameters();
        String paramString = params.stream().map(i -> i.getName()).collect(Collectors.joining(", "));
        StringBuilder builder = new StringBuilder(getName()).append("<").append(paramString).append(">");
        return builder.toString();
    }

    /**
     *
     * @return
     */
    @Override
    public GenericClass duplicate() {
        GenericClass target = (GenericClass)super.duplicate();
        target.setGenericParameters(this.getGenericParameters());
        return target;
    }
}
