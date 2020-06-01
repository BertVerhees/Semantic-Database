package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import nl.rosa.semanticdatabase.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmValueSpec;
import nl.rosa.semanticdatabase.bmmdata.model.expressions.*;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmmdata.model.routine_implementation.BmmStatementItem;
import nl.rosa.semanticdatabase.bmmdata.model.types.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Default created on 1-6-2020
 */

public class s {
    /**
     * BmmClassEntity
     */
    private Boolean isSynthesisedGeneric;
    // function
    @NotNull
    public BmmSignature signature(){
        return null;
    }
    /**
     * BmmClassScoped
     */
    private Object visibility;
    private BmmClass scope;
    /**
     * BmmInstantiable
     */
    /**
     * BmmProperty
     */
    private Boolean isImRuntime;
    private Boolean isImInfrastructure;
    private Boolean isComposition;
    // functions
    @NotNull
    public MultiplicityInterval existence(){
        return null;
    }
    @NotNull
    public String displayName(){
        return null;
    }
    /**
     * BmmRoutine
     */
    private List<BmmParameter> parameters;
    private List<BmmLocal> locals;
    private List<ElAssertion> preConditions;
    private List<ElAssertion> postConditions;
    private BmmStatementItem body;
    // functions
    public Integer arity(){
        return null;
    }
    /**
     * BmmTyped
     */
    @NotNull
    private BmmType type;
    // functions
    @NotNull
    public Boolean isBoolean(){
        return null;
    }
    /**
     * BmmTypedFeature
     */
    private Boolean isNullable;
    /**
     * BmmVariable
     */
    private BmmRoutine scope;
    /**
     * BmmClass
     */
    private Map<String, BmmModelType> ancestors;
    @NotNull
    private BmmPackage _package;
    private Map<String, BmmProperty> properties;
    @NotNull
    private String sourceSchemaId;
    private List<BmmClass> immediateDescendants;
    @NotNull
    private Boolean isOverride;
    private Map<String, BmmConstant> constants;
    private Map<String, BmmFunction> functions;
    private Map<String, BmmProcedure> procedures;
    private List<ElAssertion> inVariants;
    private Map<String, BmmProcedure> creators;
    private Map<String, BmmProcedure> convertors;
    // Functions
    @NotNull
    public BmmModelType type(){
        return null;
    }
    public List<String> allAncestors(){
        return null;
    }
    public List<String> allDescendants(){
        return null;
    }
    public List<String> suppliers(){
        return null;
    }
    public List<String> suppliersNonPrimitive(){
        return null;
    }
    public List<String> supplierClosure(){
        return null;
    }
    @NotNull
    public String packagePath(){
        return null;
    }
    @NotNull
    public String classPath(){
        return null;
    }
    @NotNull
    public Boolean isAbstract(){
        return null;
    }
    @NotNull
    public Boolean isPrimitive(){
        return null;
    }
    public List<BmmClassScoped> features(){
        return null;
    }
    public List<BmmClassScoped> flatFeatures(){
        return null;
    }
    public List<BmmProperty> flatProperties(){
        return null;
    }
    /**
     * BmmEntity
     */
    // Functions
    @NotNull
    public Boolean isAbstract(){
        return null;
    }
    @NotNull
    public Boolean isPrimitive(){
        return null;
    }
    /**
     * ElAgent
     */
    @NotNull
    private String name;
    private ElTuple closedArgs;
    private List<String> openArgs;
    private BmmRoutine definition;
    // Functions
    @NotNull
    public BmmSignature evalType(){
        return null;
    }
    @NotNull
    public Boolean isCallable(){
        return null;
    }
    /**
     * ElAgentCall
     */
    @NotNull
    private ElAgent agent;
    /**
     * ElExpression
     */
    @NotNull
    public BmmType evalType(){
        return null;
    }
    @NotNull
    public Boolean isBoolean(){
        return null;
    }
    /**
     * ElInstanceRef
     */
    /**
     * ElOperator
     */
    private Boolean precedenceOverridden;
    private String symbol;
    @NotNull
    private BmmFunction definition;
    // Functions
    @NotNull
    public BmmOperator operatorDefinition(){
        return null;
    }
    @NotNull
    public ElFunctionCall equivalentcall;
    /**
     * ElPredicate
     */
    private ElInstanceRef operand;
    // Functions
    public BmmSimpleType evalType(){
        return null;
    }
    /**
     * ElScopedRef
     */
    private ElInstanceRef scope;
    /**
     * ElTerminal
     */
    /**
     * BmmDeclaration
     */
    @NotNull
    private String name;
    private Map<String, Object> documentation;
    @NotNull
    private BmmDeclaration scope;
    private Map<String, Object> extensions;
    // Functions;
    public Boolean isRootScope(){
        return null;
    }
    /**
     * BmmModule
     */
    @NotNull
    private BmmModel scope;
    /**
     * BmmStatement
     */
    /**
     * BmmEffectiveType
     */
    // Functions;
    @NotNull
    public BmmEffectiveType getEffectiveType(){
        return null;
    }
    @NotNull
    public String typeBaseName(){
        return null;
    }
    /**
     *  BmmModelType
    */
    private BmmValueSpec valueConstraint;
    @NotNull
    private BmmClass baseCLass;
    /**
     * BmmType
     */
    // Functions
    @NotNull
    public String typeName(){
        return null;
    }
    @NotNull
    public List<String> flattenedTypeList(){
        return null;
    }
    @NotNull
    public String typeSignature(){
        return null;
    }
    @NotNull
    public BmmUnitaryType unitaryType(){
        return null;
    }
    @NotNull
    public BmmEffectiveType effectiveType(){
        return null;
    }
    /**
     * BmmUnitaryType
     */
    // Functions
    @NotNull
    public BmmUnitaryType unitaryType(){
        return null;
    }
}
