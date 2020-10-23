package bmm/classes;
/**
 * 
 * 
 * 6.
 * Classes
 * 6.
 *1.
 * Overview
 * This section describes the semantics of the BMM_CLASS meta-class, its sub-types, constituent parts and relationships.
 * The parts of a class are collectively known as features, and consist of functions, procedures, constants and properties, which appear in feature groups.
 * The following UML illustrates classes and relationships to constituent feature meta-types.
 * Features are described in detail in the following section.
 *Class definitions are the definitional basis of a BMM model, i.
 *e.
 * they are the means of defining the types that are statically used in the model, and the dynamic types generated at runtime.
 * Types are thus derived entities.
 *The top meta-class BMM_CLASS defines two properties inherent in classes defined in a model, and derived in resulting types: is_abstract and is_primitive.
 * The Boolean attribute is_abstract indicates a class that cannot be directly instantiated.
 * The attribute is_primitive indicates that a class is considered to be part of a primitive type set (typically corresponding to primitive types in another type system).
 * Primitive status has no effect on BMM model semantics, and is provided as a convenience for visualisation and type-system mapping.
 *BMM distinguishes between simple and generic class definitions via two descendants of BMM_CLASS, i.
 *e.
 * BMM_SIMPLE_CLASS and BMM_GENERIC_CLASS, with the first providing a concrete form of BMM_CLASS that applies to non-generic classes, and the latter defining the additional semantics of generic classes.
 * The meta-type BMM_ENUMERATION is a specialisation of BMM_SIMPLE_CLASS used to represent enumeration classes in BMM models.
 * The meta-types are further described below.
 *
 * 
 * 
 * 
 * Figure 18.
 * base.
 *bmm.
 *core Package - Classes
 * 
 * 
 * 
 * 
 * 
 * 
 * 6.
 *2.
 * Simple Classes
 * The simplest type of class definition in a model is an instance of the meta-type BMM_SIMPLE_CLASS, and has a 1:1 relationship with its type.
 * Such classes might be specified in the following abstract syntax:
 * 
 * 
 * 
 * class DvQuantity { feature // feature definitions } class Observation { feature // feature definitions }
 * 6.
 *3.
 * Generic Classes
 * The generic class meta-type BMM_GENERIC_CLASS adds generic parameters to BMM_CLASS, enabling formal generic parameters to be represented.
 * Each such parameter is expressed using an instance of BMM_PARAMETER_TYPE which names the parameter and optionally allows a type constraint to be associated with it, in the usual object-oriented fashion.
 * In BMM, formal parameters have single-letter names, such as 'T', 'U' etc, following typical usage in programming languages.
 * A generic class may also be primitive.
 * Generic classes can be defined in a syntax similar to the following.
 *The following example shows a generic class Interval<T:Ordered>, which is a class Interval with one formal parameter T constrained to be of type Ordered or any descendant.
 *
 * 
 * 
 * 
 * // a primitive generic class with an open type parameter primitive class List <T> { feature // feature definitions } // a generic class with a constrained type parameter class DvInterval <T:DvOrdered> { feature // feature definitions } // a primitive generic class two type parameters primitive class HashMap <K:Ordered, V> { feature // feature definitions }
 * 
 * 
 * 
 * Figure 19.
 * BMM class - generic class
 * 6.
 *4.
 * Range-Constrained Classes
 * The value range of any defined type is by default open, meaning that its instances may take any value allowed by the type definition.
 * For primitive types such as String and Integer, this means that any String or Integer value is a valid instance.
 * For composed types, instances are composed of hierarchies of values which are similarly un-constrained with respect to their types.
 *A useful derived form of any concrete type definition (i.
 *e.
 * instance of BMM_EFFECTIVE_TYPE in a model) is one that constrains the legal values of its instances to a particular set of values.
 * The Pascal language provided a well-known precedent, 'sub-range types' that could restrict primitive type value ranges.
 * BMM supports two kinds of range constraint: enumeration and 'value sets'.
 * The additional meta-classes are shown below.
 *
 * 
 * 
 * 
 * 
 * 
 * Figure 20.
 * bmm.
 *core.
 *range_constrained Package - Constrained-range Meta-Types, including Enumeration
 * 6.
 *4.
 *1.
 * Enumerated Types
 * In modern programming languages, the enumerated type is the most common kind of range constraint mechanism.
 * In Java for example, an enumeration is a finite set of labels each associated with singleton value object - either automatically assigned integers, or else programmatically associated instances of any other kind.
 * Enumerated types are supported in BMM via the BMM_ENUMERATION meta-type and descendants.
 * An enumerated type could in theory be based on any BMM defined type, i.
 *e.
 * any simple or generic type, since instances of either could be constrained.
 * BMM makes the simplification that an enumerated type can only be based on a BMM simple type, which means that in the defined model, an enumeration of a closed generic type Gen<T_subst> is achieved by first defining a simple type based on the closed generic type via inheritance, e.
 *g.
 * a type Gen_T_subst that inherits from Gen<T_subst> can be used as the ancestor of a BMM enumeration type.
 * For this reason, the BMM_ENUMERATION meta-type is defined as a descendant of BMM_SIMPLE_CLASS, and may have only one ancestor.
 * The value enumeration is represented via a set of enumeration labels (item_names) and constant values (item_values), the latter of which must be of the type represented in the concrete model by the instance of the ancestor class.
 * Since String and Integer valued enumerations are by far the most common in real models, two descendant classes BMM_ENUMERATION_STRING and BMM_ENUMERATION_INTEGER are provided, which fix the values and types to String and Integer respectively.
 * The following diagram shows the BMM instance structure corresponding to an attribute declaration lifecycle: TaskLifecycle in a class Order.
 * Figure 21.
 * Integer-based Enumeration Type The following shows the same class in an abstract syntax.
 * // an Integer-based enumeration enumeration class TASK_LIFECYCLE { planned = 0; available = 1; cancelled = 2; aborted = 3; abandoned = 4; underway = 5; suspended = 6; resumed = 7; completed = 8; } The following screenshot shows how this enumeration class appears within a BMM model.
 * Figure 22.
 * Enumeration Example The following shows another enumeration class, this time based on the String type.
 * // a String-based enumeration enumeration class ContractStatus { initial = "Initial"; cancelled = "Cancelled"; active = "Active"; completed = "Completed"; } The types String and Integer are assumed to be defined via primitive classes of the same names.
 *
 * 6.
 *4.
 *2.
 * Value-set Types
 * Another form of range constraint that occurs in many models is the use of 'coded terms' that represent codes from e.
 *g.
 * ISO or IANA value sets such as ISO 639 (languages) and IANA media types.
 * These are particularly prevalent in type systems used in the biosciences where object models routinely include attributes of a Coded Term type that refer to terminologies such as SNOMED CT, WHO ICD10 etc.
 * In such models, it is typical to want to define an attribute being not just of a Coded Term type, but also limited to a particular terminology (such as a coded attribute representing 'language'), or even a specific 'value set' from such a terminology.
 * The same kind of constraint may be applied to any kind of model type, for example a type representing Medication may be constrained to be instantiated only as instances defined by a medications database.
 * This kind of constraint is known here as a value set, following the common usage in the biomedical sciences, and is supported in a different way than enumerations.
 * The latter is a common programming concept which always involves a dedicated type representing the enumeration.
 * Since the required value-sets are represented explicitly in the model but in an external database or other resource, the constraint is limited to a reference to the relevant resource, and is applied directly to the use of a type within a feature definition, rather than requiring the definition of a new type.
 * Accordingly, BMM provides the attribute value_constraint: BMM_VALUE_SET_SPEC defined on BMM_MODEL_TYPE.
 * The BMM_VALUE_SET_SPEC meta-type contains two String attributes resource_id and value_set_id which may be used to define a resource (equivalently a namespace) and an identifier of a value set within that resource.
 * BMM does not impose any particular format or resolution algorithm on these identifiers - it is assumed that they can be correctly defined and used within the context of the concrete model usage.
 * Consequently, an attribute within a standard concrete model such as language: CodedTerm could now be expressed notionally as language: CodedTerm <<iso::639-*>> or language: CodedTerm <<iso::languages>>.
 * The construction within the <<>> is parsed into two pieces around the :: separator, which are then used to populate the BMM_VALUE_SET_SPEC for a type.
 * The following diagram shows the meta-model structure corresponding to an attribute declaration language: CodedText whose instances are constrained to be from a value-set iso_639-2 within the resource namespace iso.
 * Figure 23.
 * Value-set Constrained Type The following shows a possible abstract syntax value-set type definition.
 * // a Value-set type class Document { feature property language: CodedText <<"iso::iso_639-2">> [1]; }
 * 6.
 *5.
 * Class Qualifiers
 * The following sub-sections describe qualifiers that may be used on any class definition to achieve a specific status within the model system.
 * BMM qualifiers are designed to map to typical features in programming languages.
 *
 * 
 * 
 * 6.
 *5.
 *1.
 * Abstract Classes
 * Any class definition in a BMM model may be marked as 'abstract', to indicate that it cannot be directly instantiated.
 * This qualifier generally maps to the concept of abstract classes in most OOPLs.
 * It may be specified in an abstract syntax as follows.
 * abstract class ENTRY { feature // feature definitions }
 * 6.
 *5.
 *2.
 * Primitive Type Classes
 * Class definitions within a BMM model may be marked as 'primitive', enabling them to be visualised and queried as a separate group without otherwise changing the semantics of the entity in the BMM meta-type system.
 * This is normally done to distinguish 'built-in' types used by a model from the classes for which the model was created.
 * An abstract syntax definition may look as follows: primitive class Integer { feature // feature definitions } primitive class String { feature // feature definitions } The following shows part of a BMM model in which a number of classes are classified as primitive (shown in light and dark grey).
 * Figure 24.
 * Primitive classes Primitive classes are normal BMM classes, other than being marked primitive for convenience, and do not have different semantics.
 *
 * 6.
 *6.
 * Class Invariants
 * A class defined within a model may include invariants, i.
 *e.
 * assertions relating to its state that hold true before and after all public routine calls.
 * Assertions are instances of the class BMM_ASSERTION, which is a tagged Boolean-valued Expression.
 *The following shows classes with invariants.
 *
 * 
 * 
 * 
 * 
 * 
 * // a class with simple invariants class COMPOSITION { feature // feature definitions invariant Is_archetype_root: is_archetype_root Content_valid: content /= Void implies not content.
 *is_empty } // a class with more complex invariants class VERSIONED_COMPOSITION { feature // feature definitions invariant Archetype_node_id_valid: all_versions.
 *for_all ( agent (v: VERSION) { v.
 *archetype_node_id.
 *is_equal (all_versions.
 *first.
 *archetype_node_id); } ) Persistent_validity: all_versions.
 *for_all ( agent (v: VERSION) { v.
 *is_persistent = all_versions.
 *first.
 *data.
 *is_persistent; } ) }
 * 6.
 *7.
 * Inheritance
 * Inheritance in BMM is a relation between a class and one or more types, rather than classes, as in many class-based formalisms.
 * This is primarily to allow classes to be based on specific generic types, rather than just the 'open' type represented by the underlying classes.
 * Multiple inheritance is permitted, with same-named features from different types being treated as clashes needing resolution.
 * See Section 12.
 *1 for a detailed description.
 *
 * 
 * 
 * 6.
 *8.
 * Model Theoretic Questions
 * The class meta-model as defined here entails certain choices that have consequences, including:
 * 
 * 
 * 
 * 
 * 6.
 *9.
 * Class Definitions
 * 
 * 6.
 *9.
 *1.
 * BMM_CLASS Class
 * 
 * 6.
 *9.
 *2.
 * BMM_SIMPLE_CLASS Class
 * 
 * 6.
 *9.
 *3.
 * BMM_GENERIC_CLASS Class
 * 
 * 6.
 *9.
 *4.
 * BMM_ENUMERATION Class
 * 
 * 6.
 *9.
 *5.
 * BMM_ENUMERATION_STRING Class
 * 
 * 6.
 *9.
 *6.
 * BMM_ENUMERATION_INTEGER Class
 * 
 * 6.
 *9.
 *7.
 * BMM_VALUE_SET_SPEC Class
 * 
 * 
*/
