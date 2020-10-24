package bmm/expressions;
/**
 * 
 * 
 * 9. Expressions
 * 9.1. Overview
 * Expressions in BMM are used to specify class invariants, routine pre- and post-conditions, and may be used more generally in other contexts requiring expressions. They are defined by a set of classes prefixed by 'EL', indicating 'expression language'. The BMM expression meta-model is based on the following taxonomy of expression entities:The meta-types defined in this part of the BMM model may be understood as the types of entities in an abstract syntax tree (AST) generated from expression parsing. Conversely, one or more expression syntaxes may be parsed into a tree based on the model described here. Note however, that whatever the variation in surface syntax, all such syntaxes parsed this way ultimately have the semantics defined by the BMM EL meta-model described here. This is true even for expressions written in a syntax whose published semantics are in fact different, e.g. a well-known programming language.The key abstract meta-types shown in the taxonomy are Simple (EL_SIMPLE), Complex (EL_COMPLEX) and under Simple, Terminal (EL_TERMINAL) and Predicate (EL_PREDICATE). The first split between Simple and Complex distinguishes 'simple' expressions that are either Terminals or classical operator trees of Terminals, from 'complex' constructs, such as those used to represent multi-way decision structures. The split between Terminal and Predicate distinguishes 'real' expression entities (the former), and meta-level predicates having a Terminal expression as a target. The Predicate meta-type is the parent of 'existence' and also path-based meta-expressions targetting instance entities (such as defined by Xpath etc).The UML model of the BMM expression package, consisting of mostly direct equivalents of the taxonomy classes above, is shown below.Most EL classes are descendants of the class EL_EXPRESSION, which is characterised by the feature eval_type(). This is the BMM meta-type of the result type of the expression entity when used in an expression; for literals, this is the inferred type; for object references (including function calls), this is the same as the declared type, and for agents it is the meta-type BMM_SIGNATURE.
 * 
 * 
 * 
 * Figure 33. Expression Taxonomy
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 34. bmm.expression Package
 * 
 * 
 * 9.2. Terminal Entities
 * The underlying semantic concept of expressions in BMM, as for any language, is of a construct that refers to instantiated model entities and which generates values when evaluated at execution time. The notion of a reference is fundamentally different from a definition, which is the concern of the rest of the meta-model, in that it operates at the instance level rather than at the type level. The primitive elements of a BMM expression may take the form of any of the following:Generally speaking, the latter two categories - function calls and delayed routine calls - will involve literal values and instance references where call arguments are stated. Consequently, the value generated by an expression is founded upon literal values and instance references. To be valid, any model-based reference must have a scoping object, which is one of:The notion of scoping object is supported via the attribute scope defined in EL_SCOPED_REF.In addition, one other category of primitive expression element is supported:The model described in this section supports these primitive elements via descendants of the EL_TERMINAL meta-type. For ease of comprehension, the following UML diagram provides an annotated view of these meta-types.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 35. bmm.expression Package - Type hierarchy
 * 9.2.1. Literals
 * A literal value may appear in an expression as a separate entity within an operator expression, as well as a functional call or agent parameter. The literal values that may be used are either instances of the openEHR Foundation Types in ODIN format, or a complex object instance in structured serial format, specified by BMM_SERIAL_FORMALISM if not a primitive type.
 * 9.2.2. Tuples
 * Although rarely useful in class definitions, a Tuple of any degree may be formed from any combination of other EL expressions and used on its own as an expression terminal element. The main use for this construct is to express a literal tuple, i.e. one whose constituents consist only of proper literal values. For more general uses of BMM Expressions, tuple instances are the basis of representing ad hoc query results which have a formal type such as List<[Ta, Tb, Tc]>, where [Ta, Tb, Tc] represents a tuple of three types.
 * 9.2.3. Feature References
 * In BMM, a feature reference is any symbolic reference to a class feature or variable that resolves to an object at evaluation time. This includes all referenceable entities within classes except procedures, which have no return value. Concretely, a feature reference takes the form of one of: a property name, e.g. name; a constant name, e.g. pi; a variable or parameter name, e.g. a_name, call_name; a function call. Function calls are described in detail in the following section.
 * 9.2.4. Self Reference
 * A special meta-type, EL_SELF_REF is provided for references to the current scoping object for any expressions in which it appears. An instance of this meta-class corresponds to references such as 'this' or 'self' found in object-oriented programming languages.
 * 9.2.5. Type Reference
 * A special meta-type, EL_TYPE_REF is provided to refer to a type as an object. This is exclusively used as a convenient way (common in many programming languages) of accessing class features that do not depend on instance properties (i.e. 'constant', 'enum', and 'static' members in C-based languages) without having to explicitly create an instance. As an expression, a type reference will normally only appear as a qualifier of a feature reference, using syntax such as {TypeName}.feature, or with arguments, {TypeName}.function (args…​). A class feature is defined as one that is: a constant; an enumeration literal; a function that does not reference any class property or make any call that does, in its body, pre_conditions or post_conditions. The last category typically includes 'external' functions that are wrappers for calls to the operating system or other external resource that maintains its own state independently. Since a type reference can be made without instantiation, it may be made to an abstract class as well as a concrete one. This facilitates the use of so-called 'utility' classes containing groups of useful functions e.g. for handling specific kinds of strings. Examples of type references as qualifiers of class features include the following: {Env}.current_time to access the class function current_time defined on the class (or interface) Env; {Colours}.red, to access an enumeration literal; {Version_utils}.version_higher ("1.5.40", "11.5.4"). A type reference may also be used on its own, such as in the following type test, which is the EL equivalent of programming language operators like type_of(). admission_dates.type = {Interval<Iso8601_date_time>}.
 * 9.2.6. Agents
 * An agent is the BMM term for a delayed routine call, and has the meta-type EL_AGENT, which in turn has as its formal evaluation type (eval_type) is the meta-type BMM_SIGNATURE. It usually appears as a standalone expression, or else a parameter within another agent or function call. Agents are described in detail in the following section.
 * 9.2.7. Predicates
 * Predicates in BMM are Boolean-returning terminal expressions taking one feature reference operand, and are represented by the meta-type EL_PREDICATE. Predicates conceptually apply to data instance structures and may be understood as queries on data. Any number of specific predicates might be added as extensions via inheritance. In particular, Xpath-style predicates could be supported by addition of meta-types descending from EL_PREDICATE. The following predicates are pre-defined. 9.2.7.1. Attached (x) The attached predicate is used to test for an instance reference (including a function call result) being Void. It may be used in expressions such as the following class invariant. class SmartRef { property url: Url; property value: Base64String; invariant Validity: attached(url) or attached(value) } 9.2.7.2. Defined (x) The defined predicate is used to test whether an instance that is mapped to an external data access method exists in the data context (regardless of its value there). TBD: this might be replaced by another approach.
 * 9.3. Constrained Expressions
 * In some cases there is a need to define a constrained form of an existing expression meta-type, such that the constraint can be conveniently asserted in other contexts. The meta-class EL_CONSTRAINED is provided for this purpose. It has an attribute base_expression referring to the underlying expression meta-type to be constrained. Any descendant of EL_CONSTRAINED may then be defined in order to add specific type or other constraints. One commonly used meta-type, EL_BOOLEAN_EXPRESSION, is defined, which constrains the base expression to being one whose evaluation type (eval_type) is Boolean.
 * 
 * 
 * 9.4. Operator Expressions
 * BMM contains meta-types representing operators, but assumes that all operators are surface aliases for functions defined on some class. For this reason, an occurrence of an operator within an expression, represented an instance of a descendant of EL_OPERATOR, contains the attribute definition to refer to the corresponding function definition. This has to be inferred from the types of its operands. Consequently, 'operator expressions' as commonly understood are simply function calls (often nested) in BMM. The following example illustrates the general meta-model of expressions, using a typical use of expression, the class invariant.The expression balance + overdraft_limit > 0 makes use of two operators + and `>, which are really functions defined on the type Decimal, as follows.A parser processing this expression would produce the result shown below, assuming that the BMM model containing these classes had already been instantiated.Below, we consider a number of examples illustrating expressions containing the various kinds of terminal reference, based on the following assumed declarations.The first example is a comparison of a property value to a value, where the >= operator maps to the function Real.greater_than_or_equal()The following shows the comparison of a property value with a constant, where the >= operator maps to the function Real.greater_than_or_equal()The following is a logical condition, where the = operator maps to a function such as Terminology_code.equal(); and maps to Boolean.and(); and >= maps to Real.greater_than_or_equal().The following is the same logical condition, but with the use of object scope specified with 'dot notation', here 'patient.'.The following shows a function call whose argument is an expression.The following shows the use of an inline agent as an argument to the function List.for_all().
 * 
 * 
 * 
 * class Account { feature balance: Decimal overdraft_limit: Decimal invariant balance + overdraft_limit > 0 }
 * 
 * 
 * 
 * class Decimal { feature greater_than (other: Decimal): Boolean alias '>' addition: (other: Decimal): Decimal alias '+' }
 * 
 * 
 * 
 * Figure 36. Instantiated Operator Expression
 * 
 * 
 * 
 * feature -- Definitions Fast_resting_heart_rate: Real = 100; Atrial_fibrillation_heart_rate: Real = 120; Erratic: Terminology_code = { "terminology_id": "snomed_ct", "code_string": "286761003" } Blood_pressure_units: String = "mm[Hg]"; feature -- Accessors heart_rate: Real; heart_rhythm: Terminology_code; bp_samples: List<Quantity>; patient: Patient;
 * 
 * 
 * 
 * heart_rate >= 80
 * 
 * 
 * 
 * heart_rate >= Fast_resting_heart_rate
 * 
 * 
 * 
 * heart_rhythm = Erratic and heart_rate >= Atrial_fibrillation_heart_rate
 * 
 * 
 * 
 * patient.heart_rhythm = Erratic and patient.heart_rate >= Atrial_fibrillation_heart_rate
 * 
 * 
 * 
 * date_of_birth.earlier ({Env}.current_date - P10Y)
 * 
 * 
 * 
 * bp_samples.for_all ( agent (a_quantity: Quantity) { a_quantity.units.is_equal (Blood_pressure_units); } );
 * 9.5. Decision Tables
 * The BMM expression package contains the meta-class EL_DECISION_TABLE that defines an abstract decision table construct, consisting of an ordered set of items, each of type EL_DECISION_BRANCH, and having a result of any expression type (including another decision table). Two concrete subtypes of each of these abstract meta-types are used to represent two common kinds of decision table:The else branch will be used to provide the result expression in the case that all other branches fail, guaranteeing a result.EL_DECISION_TABLE and its descendants are also kind of expression, enabling them to be used as value-returning entities in certain other expression contexts, including inside other decision tables.The following UML illustrates.The logic of a EL_CONDITION_CHAIN is the same as an if/then/elseif/else chain in procedural programming, except that instead of assignment statements on each branch, pure result expressions are used. This enables a more sophisticated syntactic rendering, resembling a table, such as the following:The above is a function that computes the molecular subtype of breast cancer using a decision table whose branches are based on a number of input variables that appear in expressions down the left-hand side and which returns a Terminology_code instance (the notation [identifier] is represents a literal Terminology_code instance).An example of EL_CASE_TABLE is shown below. Here, two case tables are used, with each generating a numeric result based on the values of the platelets and gfr variables respectively.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 37. bmm.expression Decision Table
 * 
 * 
 * 
 * molecular_subtype: Terminology_term Result := [[ ========================================================= er_positive and her2_negative and not ki67.in_range ([high]): [luminal_A], --------------------------------------------------------- er_positive and her2_negative and ki67.in_range ([high]): [luminal_B_HER2_negative], --------------------------------------------------------- er_positive and her2_positive: [luminal_B_HER2_positive], --------------------------------------------------------- er_negative and pr_negative and her2_positive and ki67.in_range ([high]): [HER2], --------------------------------------------------------- er_negative and pr_negative and her2_negative and ki67.in_range ([high]): [triple_negative], --------------------------------------------------------- *: [none] ========================================================= ]]
 * 
 * 
 * 
 * 
 * 
 * cyclophosphamide_dose: Quantity Result := cyclophosphamide_dose_per_m2 * BSA.bsa_m2 * case platelets.range in [[ =================== [normal]: 1, [low]: 0.75 =================== ]] * case gfr.range in [[ =================== [normal]: 1, [low]: 0.75, [very_low]: 0.5 =================== ]]
 * 9.6. Usage in BMM Models
 * Expressions as used in BMM models to express class invariants and routine pre- and post-conditions are always in the form of an BMM_ASSERTION, i.e. a tagged Boolean-returning EL_EXPRESSION.
 * 
 * 
 * 9.6.1. Simple Assertions
 * Simple assertions may be formed from common operators and operands, including the usual logical arithmetic and comparison operators, as well as any operators relating to specific data types. Normally the top-level operator in the Expression graph is a logical or relational operator. Since all operators are mapped to functions defined on types, there are no 'floating' or 'built-in' operators as such.
 * 9.6.2. Existential and Universal Quantifier Invariants
 * A common kind of expression used in class invariants operates over collections and uses the existential and universal quantifier operators, i.e. ∃ and ∀, from predicate logic. A typical expression to use within a class invariant is shown below in an abstract syntax. class PersonName { property items: String[1..*]; invariant ∀ nameItem: items | not nameItem.isEmpty() } A different syntax might express it as follows. invariant for nameItem in items all not nameItem.isEmpty() end A similar invariant, this time using ∃, is shown below. invariant for nameItem in items ∃ not nameItem.isEmpty() Regardless of the surface syntax, expressions such as the above map to functions such as for_all and there_exists defined on relevant linear container types. These functions have the following signatures in which the 'test' expression appears as a Function agent type. class Container<T> { for_all (test: Function<[T], Boolean>): Boolean; -- True if for every v in container, test (v) is True there_exists (test: Function<[T], Boolean>): Boolean; -- True if there is any v in container for which test (v) is True }
 * 9.7. Class Definitions
 * 
 * 9.7.1. EL_EXPRESSION Class
 * 
 * 9.7.2. EL_BOOLEAN_EXPRESSION Class
 * 
 * 9.7.3. EL_OPERATOR Class
 * 
 * 9.7.4. EL_UNARY_OPERATOR Class
 * 
 * 9.7.5. EL_BINARY_OPERATOR Class
 * 
 * 9.7.6. EL_SIMPLE Class
 * 
 * 9.7.7. EL_TERMINAL Class
 * 
 * 9.7.8. EL_PREDICATE Class
 * 
 * 9.7.9. EL_DEFINED Class
 * 
 * 9.7.10. EL_ATTACHED Class
 * 
 * 9.7.11. EL_INSTANCE_REF Class
 * 
 * 9.7.12. EL_SELF_REF Class
 * 
 * 9.7.13. EL_TYPE_REF Class
 * 
 * 9.7.14. EL_LITERAL Class
 * 
 * 9.7.15. EL_SCOPED_REF Class
 * 
 * 9.7.16. EL_INSTANTIABLE_REF Class
 * 
 * 9.7.17. EL_AGENT_CALL Class
 * 
 * 9.7.18. EL_FUNCTION_CALL Class
 * 
 * 9.7.19. EL_AGENT Class
 * 
 * 9.7.20. EL_FUNCTION_AGENT Class
 * 
 * 9.7.21. EL_PROCEDURE_AGENT Class
 * 
 * 9.7.22. EL_TUPLE Class
 * 
 * 9.7.23. EL_TUPLE_ITEM Class
 * 
 * 9.7.24. EL_DECISION_TABLE Class
 * 
 * 9.7.25. EL_DECISION_BRANCH Class
 * 
 * 9.7.26. EL_CONDITION_CHAIN Class
 * 
 * 9.7.27. EL_CONDITIONAL_EXPRESSION Class
 * 
 * 9.7.28. EL_CASE_TABLE Class
 * 
 * 9.7.29. EL_CASE Class
 * 
 * 
*/
