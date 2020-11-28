package nl.rosa.semanticdatabase.aom_2.constraint_model_package;
/**
 * 
 * 
 * 4.
 * Constraint Model Package
 * 4.1.
 * Overview
 * Figure 14 and Figure 15 illustrate the object model of constraints used in an archetype definition.
 * This model is completely generic, and is designed to express the semantics of constraints on instances of classes which are themselves described in any orthodox object-oriented formalism, such as UML.
 * Accordingly, the major abstractions in this model correspond to major abstractions in object-oriented formalisms, including several variations of the notion of 'object' and the notion of 'attribute'.
 * The notion of 'object' rather than 'class' or 'type' is used because archetypes are about constraints on data (i.e.
 * 'instances', or 'objects') rather than models, which are constructed from 'classes'.
 * In this document, the word 'attribute' refers to any data property of a class, regardless of whether regarded as a 'relationship' (i.e.
 * association, aggregation, or composition) or 'primitive' (i.e.
 * value) attribute in an object model.The definition part of an archetype is an instance of a C_COMPLEX_OBJECT and consists of alternate layers of object and attribute constrainer nodes, each containing the next level of nodes.
 * At the leaves are primitive object constrainer nodes constraining primitive types such as String , Integer etc.
 * There are also nodes that represent internal references to other nodes, constraint reference nodes that refer to a text constraint in the constraint binding part of the archetype terminology, and archetype constraint nodes, which represent constraints on other archetypes allowed to appear at a given point.
 * The full list of concrete node types is as follows:The constraints define which configurations of reference model class instances are considered to conform to the archetype.
 * For example, certain configurations of the classes PARTY , ADDRESS , CLUSTER and ELEMENT might be defined by a Person archetype as allowable structures for 'people with identity, contacts, and addresses'.
 * Because the constraints allow optionality, cardinality and other choices, a given archetype usually corresponds to a set of similar configurations of objects.The type-name nomenclature C_XXX used here is intended to be read as "constraint on objects of type XXXX ", i.e.
 * a C_COMPLEX_OBJECT is a "constraint on a complex object (defined by a complex reference model type)".
 * These type names are used below in the formal model.
 * 
 * 
 * 
 * Figure 14.
 * am.aom2.constraint_model Package
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Figure 15.
 * am.aom2.constraint_model.primitive Package
 * 
 * 
 * 4.2.
 * Semantics
 * The effect of the model is to create archetype definition structures that are a hierarchical alternation of object and attribute constraints.
 * This structure can be seen by inspecting an ADL archetype, or by viewing an archetype in an AOM-based tool such as the openEHR ADL workbench, and is a direct consequence of the object-oriented principle that classes consist of properties, which in turn have types that are classes.
 * (To be completely correct, types do not always correspond to classes in an object model, but it does not make any difference here).
 * The repeated object/attribute hierarchical structure of an archetype provides the basis for using paths to reference any node in an archetype.
 * Archetype paths follow a syntax that is a directly convertible in and out of the W3C Xpath syntax.
 * 
 * 
 * 4.2.1.
 * All Node Types
 * Some properties are defined for all node types, described in the following sections.
 * 4.2.1.1.
 * Path Functions The path feature computes the path to the current node from the root of the archetype, while the has_path function indicates whether a given path can be found in an archetype.
 * 4.2.1.2.
 * Conformance Functions All node types include two functions that formalise the notion of conformance of a specialised archetype to a parent archetype.
 * Both functions take an argument which must be a corresponding node in a parent archetype, not necessarily the immediate parent.
 * A 'corresponding' node is one found at the same or a congruent path.
 * A congruent path is one in which one or more at-codes have been redefined in the specialised archetype.
 * The c_conforms_to function returns True if the node on which it is called is a valid specialisation of the 'other' node.
 * The c_congruent_to function returns True if the node on which it is called is the same as the other node, with the possible exception of a redefined at-code.
 * The latter may happen due to the need to restrict the domain meaning of node to a meaning narrower than that of the same node in the parent.
 * The formal semantics of both functions are given in the class definitions, Section 4.5.
 * 4.2.1.3.
 * Any_allowed The any_allowed function defined on some node types indicates that any value permitted by the reference model for the attribute or type in question is allowed by the archetype; its use permits the logical idea of a completely "open" constraint to be simply expressed, avoiding the need for any further substructure.
 * 4.2.2.
 * Attribute Nodes
 * Constraints on reference model attributes, including computed attributes (represented by functions with no aguments in most programming languages), are represented by instances of C_ATTRIBUTE .
 * The expressible constraints include: is_multiple: a flag that indicates whether the C_ATTRIBUTE is constraining a multiply-valued (i.e.
 * container) RM attribute or a single-valued one; existence: whether the corresponding instance (defined by the rm_attribute_name attribute) must exist; child objects: representing allowable values of the object value(s) of the attribute.
 * In the case of single-valued attributes (such as Person.date_of_birth) the children represent one or more alternative object constraints for the attribute value.
 * For multiply-valued attributes (such as Person.contacts: List<Contact>), a cardinality constraint on the container can be defined.
 * The constraint on child objects is essentially the same except that more than one of the alternatives can co-exist in the data.
 * Figure 16 illustrates the two possibilities.
 * The appearance of both existence and cardinality constraints in C_ATTRIBUTE deserves some explanation, especially as the meanings of these notions are often confused in object-oriented literature.
 * An existence constraint indicates whether an object will be found in a given attribute field, while a cardinality constraint indicates what the valid membership of a container object is.
 * Cardinality is only required for container objects such as List<T> , Set<T> and so on, whereas existence is always possible.
 * If both are used, the meaning is as follows: the existence constraint says whether the container object will be there (at all), while the cardinality constraint says how many items must be in the container, and whether it acts logically as a list, set or bag.
 * Both existence and cardinality are optional in the model, since they are only needed to override the settings from the reference model.
 * Figure 16.
 * C_ATTRIBUTE variants
 * 4.2.3.
 * Object Node Types
 * The following sections apply to all object nodes in an archetype, i.e.
 * instances of any descendant of C_OBJECT.
 * 4.2.3.1.
 * Rm_type_name and Reference Model Type Matching Every object node has an rm_type_name attribute that states the RM type to be matched by that node in the archetype.
 * The value of rm_type_name is understood as a constraint on the dynamic type of data instances of the stated Reference Model type.
 * It is either a class name from the RM, or a generic type constructed from RM class names, as described in the Reference model type matching section of the ADL2 specification.
 * The RM type stated in an archetype object node is understood to be a static type constraint.
 * Accordingly, it will match an instance of any RM subtype of the stated type, as long as the inheritance relationship is stated in the RM definition.
 * This holds both for sub-classes, and subtypes of generic types, in a covariant fashion.
 * The following matching will thus succeed: rm_type_name = "PARTY" matches PERSON, where PERSON inherits from PARTY in the relevant RM; rm_type_name = "Interval<Ordered>" matches a dynamic type of data items of Interval<Quantity>, SimpleInterval<Ordered> and SimpleInterval<Quantity> where Quantity inherits from Ordered and SimpleInterval inherits from Interval in the relevant RM.
 * There are some special rules that apply to primitive type matching that enable 'logical' primitive type names in archetypes to match multiple 'concrete' variants that occur in some reference models and programming type systems.
 * These are described in detail below.
 * 4.2.3.2.
 * Node_id and Paths The node_id attribute in the class C_OBJECT, inherited by all subtypes, is of key importance in the archetype constraint model.
 * It has two functions: it allows archetype object constraint nodes to be individually identified, and in particular, guarantees sibling node unique identification; it provides a code to which a human-understanding terminology definition can be attached, as well as potentially a terminology binding.
 * The existence of node_ids in an archetype allows archetype paths to be created, which refer to each node.
 * Every node in the archetype needs a node_id , but only node_ids for nodes under container attributes must have a terminology definition.
 * For nodes under single-valued attributes, the terminology definition is optional (and typically not supplied), since the meaning is given by the reference model attribute definition.
 * Note that instances of C_PRIMITIVE_OBJECT have a constant node_id (see below) and thus do not require node identifiers to be supplied in syntax or serial forms that are converted to AOM structural form.
 * 4.2.3.3.
 * Sibling Ordering Within a specialised archetype, redefined or added object nodes may be defined under a container attribute.
 * Since specialised archetypes are in differential form, i.e.
 * only redefined or added nodes are expressed, not nodes inherited unchanged, the relative ordering of siblings can’t be stated simply by the ordering of such items within the relevant list within the differential form of the archetype.
 * An explicit ordering indicator is required if indeed order is specific.
 * The C_OBJECT.sibling_order attribute provides this capability.
 * It can only be set on a C_OBJECT descendant within a multiply-valued attribute, i.e.
 * an instance of C_ATTRIBUTE for which the cardinality is ordered.
 * 4.2.3.4.
 * Node Deprecation It is possible to mark an instance of any defined node type as deprecated, meaning that by preference it should not be used, and that there is an alternative solution for recording the same information.
 * Rules or recommendations for how deprecation should be handled are outside the scope of the archetype proper, and should be provided by the governance framework under which the archetype is managed.
 * 4.2.4.
 * Reference Objects
 * Two subtypes of C_OBJECT, namely ARCHETYPE_SLOT and C_COMPLEX_OBJECT_PROXY are used to express constraints in the form of references to other constraints, rather than directly.
 * An ARCHETYPE_SLOT defines a 'slot' specifying other archetypes that can be plugged in at that point, in terms of constraints on archetype identifiers.
 * These are expressed as instances of the ARCHETYPE_ID_CONSTRAINT class, a specialised version of the ELOM EL_CONSTRAINT_EXPRESSION class.
 * The type C_COMPLEX_OBJECT_PROXY represents a reference to another part of the current archetype that expresses exactly the same constraints needed at the point where the proxy appears.
 * 4.2.5.
 * Defined Object Nodes (C_DEFINED_OBJECT)
 * The C_DEFINED_OBJECT subtype corresponds to the category of C_OBJECTs that are defined in an archetype by value, i.e.
 * by inline definition.
 * Four properties characterise C_DEFINED_OBJECTs as follows.
 * 4.2.5.1.
 * Valid_value The valid_value function tests a reference model object for conformance to the archetype.
 * It is designed for recursive implementation in which a call to the function at the top of the archetype definition would cause a cascade of calls down the tree.
 * This function is the key function of an 'archetype-enabled kernel' component that can perform runtime data validation based on an archetype definition.
 * 4.2.5.2.
 * Prototype_value This function is used to generate a reasonable default value of the reference object being constrained by a given node.
 * This allows archetype-based software to build a 'prototype' object from an archetype which can serve as the initial version of the object being constrained, assuming it is being created new by user activity (e.g.
 * via a GUI application).
 * Implementation of this function will usually involve use of reflection libraries or similar.
 * 4.2.5.3.
 * Default_value This attribute allows a user-specified default value to be defined within an archetype.
 * The default_value object must be of the same type as defined by the prototype_value function, pass the valid_value test.
 * Where defined, the prototype_value function would return this value instead of a synthesised value.
 * 4.2.6.
 * Complex Objects (C_COMPLEX_OBJECT)
 * Along with C_ATTRIBUTE, C_COMPLEX_OBJECT is the key structuring type of the constraint_model package, and consists of attributes of type C_ATTRIBUTE, which are constraints on the attributes (i.e.
 * any property, including relationships) of the reference model type.
 * Accordingly, each C_ATTRIBUTE records the name of the constrained attribute (in rm_attr_name) , the existence and cardinality expressed by the constraint (depending on whether the attribute it constrains is a multiple or single relationship), and the constraint on the object to which this C_ATTRIBUTE refers via its children attribute (according to its reference model) in the form of further C_OBJECTs.
 * 4.2.7.
 * Primitive Types (C_PRIMITIVE_OBJECT descendants)
 * Constraints on primitive types are defined by the descendants of C_PRIMITIVE_OBJECT, i.e.
 * C_STRING , C_INTEGER and so on.
 * The primitive constraint types are represented in such a way as to accommodate both 'tuple' constraints and logically unary constraints, using a tuple array (C_PRIMITIVE_TUPLE.members) whose members are each a primitive constraint corresponding to each primitive type in the tuple.
 * Tuple constraints are second order constraints, described below, enabling covarying constraints to be stated.
 * In the unary case, the constraint is the first member of a tuple array.
 * C_PRIMITIVE_OBJECT instances are created with a fixed id-code ADL_CODE_DEFINITIONS.primitive_node_id as the value of node_id (see Section 2.3.3).
 * For this reason, no node identifier needs to be supplied in a syntax or serialised form of an archetype, including ADL.
 * The primitive constraint for each primitive type may itself be complex.
 * Its formal type is the type of the constraint accessor in each C_PRIMITIVE_OBJECT descendant.
 * The use of the constrainer types for each RM type is summarised in the following table.
 * Note in the above that the C_DATE_TIME AOM type is assumed by default to apply to data items of the RM types DateTime and Date_time, including any variations in case.
 * In order to accommodate concrete type variants that are used in common type systems, the following RM type matching should be considered to occur by default: String variants: in addition to matching String, C_STRING should match StringN and String_N instances, to accommodate RM types such as String8, String_32 etc; Integer variants: in addition to matching Integer, C_INTEGER should match IntegerN and Integer_N, to accommodate RM types such as Integer_16, Integer64 etc; Real variants: in addition to matching Real, C_REAL should match RealN and Real_N and Double, to accommodate RM types such as Real_32, Real64 and Double.
 * A way of configuring this on a per-RM basis is described in Section 11.4 below.
 * 4.2.7.1.
 * Assumed_value The assumed_value attribute is useful for archetypes containing any optional constraint.
 * and provides an ability to define a value that can be assumed for a data item for which no data is found at execution time.
 * If populated, it can contain a single at-code that must be in the local value set referred to by the ac-code in the constraint attribute.
 * For example, an archetype for the concept 'blood pressure measurement' might contain an optional protocol section containing a data point for patient position, with choices 'lying', 'sitting' and 'standing'.
 * Since the section is optional, data could be created according to the archetype which does not contain the protocol section.
 * However, a blood pressure cannot be taken without the patient in some position, so clearly there is an implied value for patient position.
 * Amongst clinicians, basic assumptions are nearly always made for such things: in general practice, the position could always safely be assumed to be "sitting" if not otherwise stated; in the hospital setting, "lying" would be the normal assumption.
 * The assumed_value feature of archetypes allows such assumptions to be explicitly stated so that all users/systems know what value to assume when optional items are not included in the data.
 * Note that the notion of assumed values is distinct from that of 'default values'.
 * The latter notion is that of a default 'pre-filled' value that is provided (normally in a local context by a template) for a data item that is to be filled in by the user, but which is typically the same in many cases.
 * Default values are thus simply an efficiency mechanism for users.
 * As a result, default values do appear in data, while assumed values don’t.
 * 4.2.8.
 * Terminology Constraints (C_TERMINOLOGY_CODE)
 * 4.2.8.1.
 * Formal Definition The C_TERMINOLOGY_CODE type entails some complexity and merits further explanation.
 * This is the only constrainer type whose constraint semantics are not self-contained, but located in the archetype terminology and/or in external terminologies.
 * A C_TERMINOLOGY_CODE instance in an archetype is structurally simple: it can only be one of the following constraints: a single ac-code, referring to either a value-set defined in the archetype terminology or bound to an external value set or ref set; in this case, an additional at-code may be included as an assumed value; the at-code must come from the locally defined value set; a single at-code, repesenting a single possible value.
 * Note The second case in theory could be done using an ac-code referring to a value set containing a single value, but there seems little value in this extra verbiage, and little cost in providing the single-member value set short cut.
 * 4.2.8.2.
 * Constraint Strengths Uniquely in the AOM, a Terminology code constraint may not be required, and may instead be considered informal.
 * This is achieved via the attribute constraint_status which indicates either that the constraint is required (i.e.
 * the data item must formally conform to the constraint), or three levels of informal constraint, namely extensible (1) | preferred (2) | example (3).
 * This particular model of constraint 'strength' follows the HL7 FHIR 'binding strengths' model.
 * The convenience function constraint_required() can be used to determine if the constraint is formal, i.e.
 * if constraint_status has the value required (0) or else is not set.
 * The informal constraint feature in C_TERMINOLOGY_CODE is provided to address the common real-world mismatch between local terminology use and more centrally defined archetypes.
 * The enumeration values of 0 - 3 are designed such that the required constraint status (value = 0) is considered the default.
 * Additionally, the constraint_status attribute is optional, and will not be present in archetypes authored with tools not including this feature.
 * Accordingly, the constraint_required() function returns True if constraint_status is Void.
 * This means that in all archetypes containing C_TERMINOLOGY_CODE nodes with no constraint_status, such nodes are considered to express a formally required constraint.
 * For the non-required settings of constraint_status, a data instance value may be a non-matching terminology code, including from another terminology.
 * It might also be a plain text (i.e.
 * not coded), in which case it will not be matched by a C_TERMINOLOGY_CODE archetype node, but an archetype node corresponding to the relevant RM type.
 * In openEHR, this would usually be DV_TEXT.
 * To allow for coded text or text matching therefore, at least 2 sibling archetype nodes are required, with one containing the appropriately configured C_TERMINOLOGY_CODE, and another representing a text-only constraint.
 * 4.2.8.3.
 * Terminology Code Resolution When an archetype is deployed in the form of an operational template, the internally defined value sets, and any bindings are processed in stages in order to obtain the final terminology codes from which the user should choose.
 * The C_TERMINOLOGY_CODE class provides a number of functions to formalise this as follows.
 * value_set_expanded: List<String>: this function converts an ac-code to its corresponding set of at-codes, as defined in the value_sets section of the archetype.
 * value_set_substituted: List<URI>: where bindings exist to he value set at-codes, this function converts each code to its corresponding binding target, i.e.
 * a URI.
 * value_set_resolved: List<TERMINOLOGY_CODE>: this function converts the list of URIs to final terms, including with textual rubrics, i.e.
 * a list of TERMINOLOGY_CODEs.
 * These functions would normally be implemented as 'lambdas' or 'agents', in order to obtain access to the target terminologies.
 * Note Since an archetype might not contain external terminology bindings for all (or even any) of its terminological constraints, a 'resolved' archetype will usually contain at-codes in its cADL definition.
 * These at-codes would be treated as real coded terms in any implementation that was creating data, and as a consequence, archetype at-codes could occur in real data, as described in the the Terminology Integration section of the ADL specification.
 * 4.2.9.
 * Constraints on Enumeration Types
 * Enumeration types in the reference model are assumed to have semantics expected in UML, and mainstream programming languages, i.e.
 * to be a distinct type based on a primitive type, normally Integer or String.
 * Each such type consists of a set of values from the domain of its underlying type, thus, a set of Integer, String or other primitive values.
 * Each of these values is assumed to be named in the manner of a symbolic constant.
 * Although stricly speaking UML doesn’t require an enumerated type to be based on an underlying primitive type, programming languages do, hence the assumption here that values from the domain of such a type are involved.
 * A constraint on an enumerated type therefore consists of an AOM instance of a C_PRIMITIVE descendant, almost always C_INTEGER or C_STRING .
 * The flag is_enumerated_type_constraint defined on C_PRIMITIVE indicates that a given C_PRIMITIVE is a constrainer for an enumerated type.
 * Since C_PRIMITIVEs don’t have type names in ADL, the type name is inferred by any parser or compiler tool that deserialises an archetype from ADL, and stored in the rm_type attribute inherited from C_OBJECT .
 * An example is shown below of a type enumeration.
 * Figure 17.
 * Enumerated Constraint A parser that deserialises from an object dump format such as ODIN, JSON or XML will not need to do this.
 * The form of the constraint itself is simply a series of Integer, String or other primitive values, or an equivalent range or ranges.
 * In the above example, the ADL equivalent of the pk_percent, pk_fraction constraint on a field of type PROPORTION_KIND is in fact just \{2, 3}, and it is visualised by lookup to show the relevant symbolic names.
 * 4.3.
 * Second Order Constraints
 * All of the constraint semantics described above can be considered 'first order' in the sense that they define how specific object/attribute/object hierarchies are defined in the instance possibility space of some part of a reference model.Some constraints however do not fit directly within the object/attribute/object hierarchy scheme, and are considered 'second order constraints' in the archetype formalism.
 * The 'rule' constraints ('invariants' in ADL/AOM 1.4) constitute one such group.
 * These constraints are defined in terms of first order predicate logic statements that can refer to any number of constraint nodes within the main hierarchy.
 * These are described in [rules_package].Another type of second order constraint can be 'attached' to the object/attribute/object hierarchy in order to further limit structural possibilities.
 * Although these constraints could also theoretically be expressed as rules, they are supported by direct additions to the main constraint model since they can be easily and intuitively represented inline in ADL and corresponding AOM structures.
 * 
 * 
 * 
 * 
 * 
 * 
 * 4.3.1.
 * Tuple Constraints
 * Tuple constraints are designed to account for the very common need to constrain the values of more than one RM class attribute together.
 * This effectively treats the attributes in question as a tuple, and the corresponding object constraints are accordingly modelled as tuples as well.
 * A detailed explanation of tuples can be found in the ADL2 specification’s section on second order constraints.
 * Additions to the main constraint model to support tuples are shown below.
 * Figure 18.
 * Tuple Constraint Model In this model, the type C_ATTRIBUTE_TUPLE groups the co-constrained C_ATTRIBUTEs under a C_COMPLEX_OBJECT.
 * Currently the concrete type is limited to being C_PRIMITIVE_OBJECT to reduce complexity, and since it caters for all known examples of tuple constraints.
 * In principle, any C_DEFINED_OBJECT could be allowed, and this may change in the future.
 * The tuple constraint type replaces all domain-specific constraint types defined in ADL/AOM 1.4, including C_DV_QUANTITY and C_DV_ORDINAL.
 * These additions allow standard constraint structures (i.e.
 * C_ATTRIBUTE / C_COMPLEX_OBJECT / C_PRIMITIVE_OBJECT hierarchies) to be 'annotated', while leaving the first order structure intact.
 * The following example shows an archetype instance structure in which a notional ORDINAL type is constrained.
 * The logical requirement is to constrain a ORDINAL to one of three instance possibilities, each of which consists of a pair of values for the attributes value and symbol, of type Integer and TERMINOLOGY_CODE respectively.
 * Each of these three instance constraints should be understood as an alternative for the single valued owning attribute, ELEMENT .value.
 * Tuple constraints achieve the requirement to express the constraints as pairs not just as allowable alternatives at the final leaf level, which would incorrectly allowing any mixing of the Integer and code values.
 * Figure 19.
 * Tuple Constraint Example AOM Instances Figure 20.
 * Tuple Constraint Example Data
 * 4.3.2.
 * Assertions
 * Assertions are used in ARCHETYPE_SLOTs, in order to express the 'included' and 'excluded' archetypes for the slot.
 * In this case, each assertion is an expression that refers to parts of other archetypes, such as its identifier (e.g.
 * 'include archetypes with short_concept_name matching xxxx ').
 * Assertions are modelled here as a generic expression tree of unary prefix and binary infix operators.
 * Examples of archetype slots in ADL syntax are given in the openEHR ADL2 specification.
 * 4.4.
 * AOM Type Substitutions
 * The C_OBJECT types defined in [constraint_model_top] are reproduced below, with concrete types that may actually occur in archetypes shown in dark yellow / non-italic.Within a specialised archetype, nodes that redefine corresponding nodes in the parent are normally of the same C_OBJECT type (we can think of this as a 'meta-type', since the RM type is the 'type' in the information model sense), but in some cases may also be of different C_OBJECT types.The rules for meta-type redefinition are as follows:The 'terminal' C_COMPLEX_OBJECT can be understood as a placeholder node primarily defined for the purpose of stating RM type and meaning (id-code).
 * 
 * 
 * 
 * Figure 21.
 * C_Object Substitutions
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 4.5.
 * Class Definitions
 * 
 * 4.5.1.
 * ARCHETYPE_CONSTRAINT Class
 * 
 * 4.5.2.
 * C_ATTRIBUTE Class
 * 4.5.2.1.
 * Conformance Semantics The following functions formally define the conformance interfaces of any ARCHETYPE_CONSTRAINT node in a specialised archetype to the corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path.
 * c_conforms_to (other: ARCHETYPE_CONSTRAINT; rmcc: FUNCTION<<a_type, other_type: String>, Boolean>): Boolean -- True if this node on its own (ignoring any subparts) expresses the same or narrower -- constraints as `other`.
 * -- Returns False if any of the following is incompatible: -- * cardinality -- * existence require other /= Void rmcc /= Void deferred end c_congruent_to (other: ARCHETYPE_CONSTRAINT): Boolean -- True if this node on its own (ignoring any subparts) expresses no additional -- constraints than `other`.
 * require other /= Void deferred end The following effected functions defined in C_ATTRIBUTE define the conformance of an attribute node in a specialised archetype to the corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path.
 * c_conforms_to (other: C_ATTRIBUTE; rmcc: FUNCTION<<a_type, other_type: String>, Boolean>): Boolean -- True if this node on its own (ignoring any subparts) expresses the same or narrower -- constraints as `other'.
 * -- Returns False if any of the following is incompatible: -- * cardinality -- * existence do Result := existence_conforms_to (other) and ((is_single and other.is_single) or else (is_multiple and cardinality_conforms_to (other))) end c_congruent_to (other: C_ATTRIBUTE): Boolean -- True if this node on its own (ignoring any subparts) expresses no additional -- constraints than `other'.
 * do Result := existence = Void and ((is_single and other.is_single) or (is_multiple and other.is_multiple and cardinality = Void)) end existence_conforms_to (other: C_ATTRIBUTE): Boolean -- True if the existence of this node conforms to other.existence require other /= Void do if existence /= Void and other.existence /= Void then Result := other.existence.contains (existence) else Result := True end end cardinality_conforms_to (other: C_ATTRIBUTE): Boolean -- True if the cardinality of this node conforms to other.cardinality, if it exists require other /= Void do if cardinality /= Void and other.cardinality /= Void then Result := other.cardinality.contains (cardinality) else Result := True end end 4.5.2.2.
 * Validity Rules The validity rules are as follows: VCARM: attribute name reference model validity: an attribute name introducing an attribute constraint block must be defined in the underlying information model as an attribute (stored or computed) of the type which introduces the enclosing object block.
 * VCAEX: archetype attribute reference model existence conformance: the existence of an attribute, if set, must conform, i.e.
 * be the same or narrower, to the existence of the corresponding attribute in the underlying information model.
 * VCAM: archetype attribute reference model multiplicity conformance: the multiplicity, i.e.
 * whether an attribute is multiply- or single-valued, of an attribute must conform to that of the corresponding attribute in the underlying information model.
 * VDIFV: archetype attribute differential path validity: an archetype may only have a differential path if it is specialised..
 * The following validity rule applies to redefinition in a specialised archetype: VDIFP: specialised archetype attribute differential path validity: if an attribute constraint has a differential path, the path must exist in the flat parent, and also be valid with respect to the reference model, i.e.
 * in the sense that it corresponds to a legal potential construction of objects.
 * VSANCE: specialised archetype attribute node existence conformance: the existence of a redefined attribute node in a specialised archetype, if stated, must conform to the existence of the corresponding node in the flat parent archetype, by having an identical range, or a range wholly contained by the latter.
 * VSAM: specialised archetype attribute multiplicity conformance: the multiplicity, i.e.
 * whether an attribute is multiply- or single-valued, of a redefined attribute must conform to that of the corresponding attribute in the parent archetype.
 * The following validity rules apply to single-valued attributes, i.e when C_ATTRIBUTE.is_multiple is False: VACSO: single-valued attribute child object occurrences validity: the occurrences of a child object of a single-valued attribute cannot have an upper limit greater than 1.
 * The following validity rules apply to container attributes, i.e when C_ATTRIBUTE.is_multiple is True: VACMCU: cardinality/occurrences upper bound validity: where a cardinality with a finite upper bound is stated on an attribute, for all immediate child objects for which an occurrences constraint is stated, the occurrences must either have an open upper bound (i.e.
 * n..*) which is interpreted as the maximum value allowed within the cardinality, or else a finite upper bound which is <= the cardinality upper bound.
 * VACMCO: cardinality/occurrences orphans: it must be possible for at least one instance of one optional child object (i.e.
 * an object for which the occurrences lower bound is 0) and one instance of every mandatory child object (i.e.
 * object constraints for which the occurrences lower bound is >= 1) to be included within the cardinality range.
 * VCACA: archetype attribute reference model cardinality conformance: the cardinality of an attribute must conform, i.e.
 * be the same or narrower, to the cardinality of the corresponding attribute in the underlying information model.
 * The following validity warnings apply to container attributes, i.e when C_ATTRIBUTE.is_multiple is True: WACMCL: cardinality/occurrences lower bound validity: where a cardinality with a finite upper bound is stated on an attribute, for all immediate child objects for which an occurrences constraint is stated, the sum of occurrences lower bounds should be lower than the cardinality upper limit.
 * The following validity rule applies to cardinality redefinition in a specialised archetype: VSANCC: specialised archetype attribute node cardinality conformance: the cardinality of a redefined (multiply-valued) attribute node in a specialised archetype, if stated, must conform to the cardinality of the corresponding node in the flat parent archetype by either being identical, or being wholly contained by the latter.
 * 4.5.3.
 * C_OBJECT Class
 * 
 * 4.5.4.
 * SIBLING_ORDER Class
 * 4.5.4.1.
 * Occurrences inferencing rules The notion of 'occurrences' does not exist in an object model that might be used as the reference model on which archetypes are based, because it is a class model.
 * However, archetypes commonly constrain the occurrences of object nodes under a container attribute, indicating how many objects conforming to a specific object constraint node might exist.
 * There are various circumstances where it is useful to know the effective occurrences of an archetype object node.
 * One is in validation, in order to determine validity of occurrences constraints; another is in archetype editor tools.
 * Similarly, in an Operational Template, an occurrences constraint is required on all child object nodes of container attributes.
 * Most such constraints come from the source template(s) and archetypes, but often there will be nodes with no occurrences set.
 * In these cases, the occurrences constraint is inferred from the archetype and the reference model according to the following algorithm, where c_object represents any object node in an archetype.
 * effective_occurrences (rm_prop_mult: FUNCTION <<rm_type_name, rm_property_path: String>, Multiplicity_interval>): Multiplicity_interval -- Compute effective occurrences, where no local occurrences constraint set.
 * If the owning -- `C_ATTRIBUTE._cardinality_` is set, use its upper value, else use RM multiplicity of the -- owning attribute.
 * -- `rm_attr_prop_mult` is a function that knows how to compute effective object multiplicity -- by looking at the owning RM property.
 * -- If local `occurrences` not set, always assume 0 as the lower bound.
 * do if occurrences /= Void then Result := occurrences elseif parent /= Void then if parent.cardinality /= Void then if parent.cardinality.interval.upper_unbounded then create Result.make_open else create Result.make_bounded (0, parent.cardinality.interval.upper) end elseif parent.parent /= Void then Result := rm_prop_mult (parent.parent.rm_type_name, parent.parent.rm_attribute_path) Result.set_lower (0) else create Result.make_open end else create Result.make_open end end In the above, rm_prop_mult is a reference to a function within an RM schema representation, which has the following logic: object_multiplicity (rm_type_name, rm_property_path: String): Multiplicity_interval -- compute the effective object multiplicity of objects at rm_property_path within type rm_type_name -- from the Reference Model require rm_type_name /= Void rm_property_path /= Void do rm_property_def := get_rm_property_def (rm_type_name, rm_property_path) if rm_property_def.is_container then if rm_property_def.cardinality.upper_unbounded then create Result.make_upper_unbounded (0) else create Result.make_bounded (0, rm_property_def.cardinality.upper) end else Result := rm_property_def.existence end end How this is concretely implemented depends on the modelling environment.
 * One possible RM model implementation is described in the openEHR Basic meta-model (BMM) specification.
 * 4.5.4.2.
 * Conformance semantics The following functions, which implement the precursors from ARCHETYPE_CONSTRAINT formally define the conformance of a C_OBJECT node in a specialised archetype to the corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path.
 * Note that the pre-conditions from the precursors are understood as inherited.
 * c_conforms_to (other: C_OBJECT; rmcc: FUNCTION<<a_type, other_type: String>, Boolean>): Boolean -- True if this node on its own (ignoring any subparts) expresses strictly narrower constraints -- as `other'.
 * -- `other' is typically from the flat parent archetype.
 * -- `rmcc' is an agent (lambda) that can test an RM type's conformance to another RM type -- Returns True only when the following is True: -- * rm_type_name is the same or a subtype of rm_type_name of other; -- * occurrences is same (= Void) or a sub-interval -- * node_id is the same, or redefined to a legal code at the level of the owning archetype do Result := node_id_conforms_to (other) and occurrences_conforms_to (other) and (rm_type_name.is_case_insensitive_equal (other.rm_type_name) or else rmcc (rm_type_name, other.rm_type_name)) end c_congruent_to (other: C_OBJECT): Boolean -- True if this node on its own (ignoring any subparts) expresses no constraints in addition -- to `other', other than possible redefinition of the node id, which doesn't matter, since -- this won't get lost in a compressed path.
 * -- Current and `other' are typically from flat archetypes being compared to generate a diff.
 * -- Used to determine if path segments can be compressed.
 * -- Returns True if: -- * rm_type_name is identical -- * occurrences is Void or else identical to other.occurrences -- * sibling_order is Void or else identical to other.sibling_order -- * node_id is identical or else is the only child that overlays the parent node do Result := rm_type_name.is_case_insensitive_equal (other.rm_type_name) and (occurrences = Void or else (other.occurrences /= Void and then occurrences.is_equal (other.occurrences))) and (sibling_order = Void or else (other.sibling_order /= Void and then sibling_order.is_equal (other.sibling_order))) and node_reuse_congruent (other) end occurrences_conforms_to (other: C_OBJECT): Boolean require other /= Void do if occurrences /= Void and other.occurrences /= Void then Result := other.occurrences.contains (occurrences) else Result := True end end node_id_conforms_to (other: C_OBJECT): Boolean require other /= Void do Result := codes_conformant (node_id, other.node_id) end node_reuse_congruent (other: C_OBJECT): Boolean -- True if this node is the sole re-using node of the corresponding node in the flat require other /= Void do Result := node_id_conforms_to (other) and (is_root or else attached parent and then parent.child_reuse_count (other.node_id) = 1) end 4.5.4.3.
 * Validity Rules The validity rules for all C_OBJECTs are as follows: VCORM object constraint type name existence: a type name introducing an object constraint block must be defined in the underlying information model.
 * VCORMT object constraint type validity: a type name introducing an object constraint block must be the same as or conform to the type stated in the underlying information model of its owning attribute.
 * VCOCD object constraint definition validity: an object constraint block consists of one of the following (depending on subtype): an 'any' constraint; a reference; an inline definition of sub-constraints, or nothing, in the case where occurrences is set to {0}.
 * VCOID object node identifier validity: every object node must have a node identifier.
 * VCOSU object node identifier validity: every object node must be unique within the archetype.
 * The following validity rules govern C_OBJECTs in specialised archetypes.
 * VSONT specialised archetype object node meta-type conformance: the meta-type of a redefined object node (i.e.
 * the AOM node type such as C_COMPLEX_OBJECT etc) in a specialised archetype must be the same as that of the corresponding node in the flat parent, with the following exceptions: a C_COMPLEX_OBJECT with no child attributes may be redefined by a node of any AOM type except C_PRIMITIVE_OBJECT; a C_COMPLEX_OBJECT_PROXY, may be redefined by a C_COMPLEX_OBJECT; an ARCHTEYPE_SLOT may be redefined by C_ARCHETYPE_ROOT (i.e.
 * 'slot-filling').
 * See also validity rules VDSSID and VARXID.
 * VSONCT specialised archetype object node reference type conformance: the reference model type of a redefined object node in a specialised archetype must conform to the reference model type in the corresponding node in the flat parent archetype by either being identical, or conforming via an inheritance relationship in the relevant reference model.
 * Deprecated: VSONIR specialised archetype redefined object node identifier condition: the node identifier of an object node in a specialised archetype that is a redefinition of a node in the flat parent must be redefined if any of reference model type, node identifier definition in the terminology, or occurrences of the immediate object constraint is redefined, with the exception of occurrences being redefined to {0}, i.e.
 * exclusion.
 * Deprecated: VSONI specialised archetype redefined object node identifier validity: if an object node in a specialised archetype is a redefinition of a node in the flat parent according to VSONIR, and the parent node carries a node identifier, it must carry a node identifier specalised at the level of the child archetype.
 * Otherwise it must carry the same node identifier (or none) as the corresponding parent node.
 * VSONIN specialised archetype new object node identifier validity: if an object node in a specialised archetype is a new node with respect to the flat parent, and it carries a node identifier, the identifier must be a 'new' node identifier, specalised at the level of the child archetype.
 * VSONIF specialised archetype object node identifier validity in flat siblings: the identification (or not) of an object node in a specialised archetype must be valid with respect to any sibling object nodes in the flattened parent (see VACMI).
 * VSONCO specialised archetype redefine object node occurrences validity: the occurrences of a redefined object node in a specialised archetype, if stated, must conform to the occurrences in the corresponding node in the flat parent archetype by either being identical, or being wholly contained by the latter.
 * VSONPT specialised archetype prohibited object node AOM type validity: the occurrences of a redefined object node in a specialised archetype, may only be prohibited (i.e.
 * {0}) if the matching node in the parent is of the same AOM type.
 * VSONPI specialised archetype prohibited object node AOM node id validity: a redefined object node in a specialised archetype with occurrences matching {0} must have exactly the same node_id as the node in the flat parent being redefined.
 * VSONPO specialised archetype object node prohibited occurrences validity: the occurrences of a new (i.e.
 * having no corresponding node in the parent flat) object node in a specialised archetype, if stated, may not be 'prohibited', i.e.
 * {0}, since prohibition only makes sense for an existing node.
 * VSSM specialised archetype sibling order validity: the sibling order node id-code used in a sibling marker in a specialised archetype must refer to a node found within the same container in the flat parent archetype, or a specialised version of any such node, redefined in the current archetype.
 * 4.5.5.
 * C_DEFINED_OBJECT Class
 * 
 * 4.5.6.
 * C_COMPLEX_OBJECT Class
 * 4.5.6.1.
 * Validity Rules The validity rules for C_COMPLEX_OBJECTs are as follows: VCATU attribute uniqueness: sibling attributes occurring within an object node must be uniquely named with respect to each other, in the same way as for class definitions in an object reference model.
 * 4.5.7.
 * C_ARCHETYPE_ROOT Class
 * 4.5.7.1.
 * Validity Rules The following validity rules apply to C_ARCHETYPE_ROOT objects: VARXNC external reference node identifier validity: if the external reference object is a redefinition of either a slot node, or another external reference node, the node_id of the object must conform to (i.e.
 * be the same or a child of) the node_id of the corresponding parent node.
 * VARXAV external reference node archetype reference validity: if the reference object is a redefinition of another external reference node, the archetype_ref of the object must match a real archetype that has as an ancestor the archetype matched by the archetype reference mentioned in the corresponding parent node.
 * VARXTV external reference type validity: the reference model type of the reference object archetype identifier must be identical, or conform to the type of the slot, if there is one, in the parent archetype, or else to the reference model type of the attribute in the flat parent under which the reference object appears in the child archetype.
 * VARXR external reference refers to resolvable artefact: the archetype reference must refer to an artefact that can be found in the current repository.
 * The following validity rules apply to a C_ARCHETYPE_ROOT that specialises a ARCHETYPE_SLOT in the flat parent archetype: VARXS external reference slot conformance: where an archetype reference redefines an archetype slot in the flat parent, it must conform to the archetype slot node by being of a reference model type from the same reference model as the current archetype.
 * VARXID external reference slot filling id validity: an external reference node defined as a filler for a slot in the parent archetype must have a node id that is a specialisation of that of the slot.
 * 4.5.8.
 * ARCHETYPE_SLOT Class
 * 4.5.8.1.
 * Validity Rules The validity rules for ARCHETYPE_SLOTs are as follows: VDFAI archetype identifier validity in definition.
 * Object archetype identifier mentioned in an archetype slot in the definition section must conform to the published openEHR specification for archetype identifiers.
 * VDSIV archetype slot 'include' constraint validity.
 * The 'include' constraint in an archetype slot must conform to the slot constraint validity rules.
 * VDSEV archetype slot 'exclude' constraint validity.
 * The 'exclude' constraint in an archetype slot must conform to the slot constraint validity rules.
 * The slot constraint validity rules are as follows: if includes not empty and = any then not (excludes empty or /= any) ==> VDSEV Error elseif includes not empty and /= any then not (excludes empty or = any) ==> VDSEV Error elseif excludes not empty and = any then not (includes empty or /= any) ==> VDSIV Error elseif excludes not empty and /= any then not (includes empty or = any) ==> VDSIV Error end The following validity rules apply to ARCHETYPE_SLOTs defined as the specialisation of a slot in the parent archetype: VDSSID slot redefinition child node id: a slot node in a specialised archetype that redefines a slot node in the flat parent must have an identical node id.
 * VDSSM specialised archetype slot definition match validity.
 * The set of archetypes matched from a library of archetypes by a specialised archetype slot definition must be a proper subset of the set matched from the same library by the parent slot definition.
 * VDSSP specialised archetype slot definition parent validity.
 * The flat parent of the specialisation of an archetype slot must be not be closed (is_closed = False).
 * VDSSC specialised archetype slot definition closed validity.
 * In the specialisation of an archetype slot, either the slot can be specified to be closed (is_closed = True) or the slot can be narrowed, but not both.
 * 4.5.9.
 * C_COMPLEX_OBJECT_PROXY Class
 * 4.5.9.1.
 * Validity Rules The following validity rules applies to internal references: VUNT use_node reference model type validity: the reference model type mentioned in an C_COMPLEX_OBJECT_PROXY node must be the same as or a super-type (according to the reference model) of the reference model type of the node referred to.
 * VUNP use_node path validity: the path mentioned in a use_node statement must refer to an object node defined elsewhere in the same archetype or any of its specialisation parent archetypes, that is not itself an internal reference node, and which carries a node identifier if one is needed at the reference point.
 * The following validity rule applies to the redefinition of an internal reference in a specialised archetype: VSUNT use_node specialisation parent validity: a C_COMPLEX_OBJECT_PROXY node may be redefined in a specialised archetype by another C_COMPLEX_OBJECT_PROXY (e.g.
 * in order to redefine occurrences), or by a C_COMPLEX_OBJECT structure that legally redefines the target C_COMPLEX_OBJECT node referred to by the reference.
 * 4.5.10.
 * C_PRIMITIVE_OBJECT Class
 * 4.5.10.1.
 * Validity Rules Validity rules applying to all C_PRIMITIVE_OBJECT types are as follows: VOBAV object node assumed value validity: the value of an assumed value must fall within the value space defined by the constraint to which it is attached.
 * 4.5.10.2.
 * Conformance semantics: C_PRIMITIVE_OBJECT The following functions redefine those of the same names from C_OBJECT, and formally define the conformance of a node of a C_PRIMITIVE_OBJECT descendant type in a specialised archetype to a corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path and of the same AOM type.
 * c_conforms_to (other: C_PRIMITIVE_OBJECT; rmcc: FUNCTION<<a_type, other_type: String>, Boolean>): Boolean -- True if this node on its own (ignoring any subparts) expresses the same or narrower -- constraints -- as `other'.
 * Returns True only when the following is True: -- * occurrences conforms -- * `rm_type_name' is identical to that in `other' -- `rmcc' is an agent (lambda) that can test an RM type's conformance to another RM type do Result := precursor (other, rmcc) and c_value_conforms_to (other) end c_value_conforms_to (other: like Current): Boolean -- True if this node expresses a value constraint that conforms to that of `other' deferred end c_congruent_to (other: C_PRIMITIVE_OBJECT): Boolean -- True if this node on its own (ignoring any subparts) expresses no constraints in -- addition to `other' do Result := constrained_typename.is_case_insensitive_equal (other.constrained_typename) and c_value_congruent_to (other) end c_value_congruent_to (other: C_PRIMITIVE_OBJECT): Boolean -- True if this node's value constraint is the same as that of `other' deferred end constrained_typename: String -- the same as the C_XX clas name with the "C_" removed, but for some types e.g.
 * Date/time types -- it is not true.
 * do Result := generating_type.name Result.remove_head (2) end
 * 4.5.11.
 * C_BOOLEAN Class
 * 4.5.11.1.
 * Conformance semantics: C_BOOLEAN The following functions formally define the conformance of a C_BOOLEAN node in a specialised archetype to a corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path and of the same AOM type.
 * c_value_conforms_to (other: C_BOOLEAN): Boolean -- True if this node is a strict subset of `other' do Result := other.any_allowed or constraint.count < other.constraint.count and for all c in constraint | other.constraint.has (c) end c_value_congruent_to (other: C_BOOLEAN): Boolean -- True if this node's value constraint is the same as that of `other' do Result := constraint.count = other.constraint.count and for all c in constraint | other.constraint.has (c) end
 * 4.5.12.
 * C_STRING Class
 * 4.5.12.1.
 * Conformance semantics: C_STRING The following functions formally define the conformance of a C_STRING node in a specialised archetype to a corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path and of the same AOM type.
 * c_value_conforms_to (other: C_STRING): Boolean -- True if `constraint' is a strict subset of other.constraint do Result := other.any_allowed or constraint.count < other.constraint.count and for all c in constraint | other.constraint.has (c) end c_value_congruent_to (other: C_STRING): Boolean -- True if this node's value constraint is the same as that of `other' do Result := constraint.count = other.constraint.count and then across constraint as str_csr all other.constraint.i_th (str_csr.cursor_index).is_equal (str_csr.item) end end
 * 4.5.13.
 * C_ORDERED Class
 * 4.5.13.1.
 * Conformance semantics: C_ORDERED The following functions implement those of the same names in C_PRIMITIVE_OBJECT and formally define the conformance of a node of a C_ORDERED descendant type in a specialised archetype to a corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path and of the same AOM type.
 * c_value_conforms_to (other: C_ORDERED): Boolean -- True if this node is a strict subset of `other' do Result := other.any_allowed or for all c in constraint | there_exists oc in other.constraint | oc.contains (c) end end c_value_congruent_to (C_ORDERED): Boolean -- True if this node is the same as `other' do Result := constraint.count = other.constraint.count and across constraint as ivl_csr all ivl_csr.item.is_equal (other.constraint.i_th (ivl_csr.cursor_index)) end end
 * 4.5.14.
 * C_INTEGER Class
 * 
 * 4.5.15.
 * C_REAL Class
 * 
 * 4.5.16.
 * C_TEMPORAL Class
 * 4.5.16.1.
 * Conformance semantics: C_TEMPORAL The following functions redefine those of the same names in C_ORDERED and formally define the conformance of a node of a C_TEMPORAL descendant type in a specialised archetype to a corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path and of the same AOM type.
 * c_value_conforms_to (other: C_TEMPORAL): Boolean -- True if this node is a strict subset of `other' do Result := precursor (other) and other.pattern_constraint.is_empty or not pattern_constraint.is_empty and then valid_pattern_constraint_replacement (pattern_constraint, other.pattern_constraint) end c_value_congruent_to (other: C_TEMPORAL): Boolean -- True if this node's value constraint is the same as that of `other' do Result := precursor (other) and pattern_constraint ~ other.pattern_constraint end
 * 4.5.17.
 * C_DATE Class
 * 
 * 4.5.18.
 * C_TIME Class
 * 
 * 4.5.19.
 * C_DATE_TIME Class
 * 
 * 4.5.20.
 * C_DURATION Class
 * 
 * 4.5.21.
 * C_TERMINOLOGY_CODE Class
 * 
 * 4.5.22.
 * CONSTRAINT_STATUS Enumeration
 * 4.5.22.1.
 * Conformance semantics: C_TERMINOLOGY_NODE The following functions implement those of the same names in C_PRIMITIVE_OBJECT and formally define the conformance of a C_TERMINOLOGY_CODE node in a specialised archetype to a corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path and of the same AOM type.
 * c_value_conforms_to (other: C_TERMINOLOGY_CODE): Boolean -- True if this node expresses a value constraint that conforms to that of `other' local this_vset, other_vset: like value_set_expanded do if other.any_allowed then Result := True elseif is_valid_value_set_code (constraint) and is_valid_value_set_code (other.constraint) then -- firstly, check if the other value-set is empty, which means there is no value-set, -- i.e.
 * no constraint, which means that this object's value set automatically conforms.
 * other_vset := other.value_set_expanded if not other_vset.is_empty then this_vset := value_set_expanded Result := codes_conformant (constraint, other.constraint) and then for_all v in this_vset | other_vset.has (v) else Result := True end else Result := codes_conformant (constraint, other.constraint) end end c_value_congruent_to (other: C_TERMINOLOGY_CODE): Boolean -- True if this node's value constraint is the same as that of `other' local this_vset, other_vset: like value_set_expanded do if is_valid_value_set_code (constraint) and is_valid_value_set_code (other.constraint) then this_vset := value_set_expanded other_vset := other.value_set_expanded Result := constraint.is_equal (other.constraint) and then this_vset.count = other_vset.count and then for_all v in this_vset | other_vset.has (v) else Result := constraint.is_equal (other.constraint) end end
 * 4.5.23.
 * C_SECOND_ORDER Class
 * 
 * 4.5.24.
 * C_PRIMITIVE_TUPLE Class
 * 
 * 4.5.25.
 * C_ATTRIBUTE_TUPLE Class
 * 4.5.25.1.
 * Conformance semantics: C_SECOND_ORDER The following functions formally define the conformance interfaces of any C_SECOND_ORDER node in a specialised archetype to the corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path.
 * c_conforms_to (other: C_SECOND_ORDER; rmcc: FUNCTION<<a_type, other_type: String>, Boolean>): Boolean -- True if this node on its own (ignoring any subparts) expresses the same or narrower -- constraints as `other`.
 * -- Returns False if any of the following is incompatible: -- * cardinality -- * existence require other /= Void rmcc /= Void deferred end c_congruent_to (other: C_SECOND_ORDER): Boolean -- True if this node on its own (ignoring any subparts) expresses no additional -- constraints than `other`.
 * require other /= Void deferred end The following functions implement those of the same names from C_SECOND_ORDER, and formally define the conformance interfaces of any C_ATTRIBUTE_TUPLE node in a specialised archetype to the corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path.
 * c_conforms_to (other: C_ATTRIBUTE_TUPLE; rmcc: FUNCTION<<a_type, other_type: String>, Boolean>): BOOLEAN -- True if this node is a subset of, or the same as `other' do Result := for_all t in tuples | there_exists ot in other.tuples | t.c_conforms_to (ot, rmcc) or else tuples.count < other.tuples.count and for_all t in tuples | there_exists ot in other.tuples | t.c_congruent_to (ot) end c_congruent_to (other: C_ATTRIBUTE_TUPLE): BOOLEAN -- True if Current adds no further constraints with respect to `other' do Result := for_all t in tuples | there_exists ot in other.tuples | t.c_congruent_to (ot) end The following functions implement those of the same names from C_SECOND_ORDER, and formally define the conformance interfaces of any C_PRIMITIVE_TUPLE node in a specialised archetype to the corresponding node in a parent archetype, where 'corresponding' means a node found at the same or a congruent path.
 * c_conforms_to (other: C_PRIMITIVE_TUPLE; rmcc: FUNCTION<<a_type, other_type: String>, Boolean>): BOOLEAN -- True if this node is a subset of, or the same as `other' do if count = other.count then Result := across members as cpo_csr all cpo_csr.item.same_type (other.members.i_th (cpo_csr.cursor_index)) and then cpo_csr.item.c_conforms_to (other.members.i_th (cpo_csr.cursor_index), rmcc) end end end c_congruent_to (other: C_PRIMITIVE_TUPLE): BOOLEAN -- True if Current and `other' are semantically the same do if count = other.count then Result := across members as cpo_csr all cpo_csr.item.same_type (other.members.i_th (cpo_csr.cursor_index)) and then cpo_csr.item.c_congruent_to (other.members.i_th (cpo_csr.cursor_index)) end end end
 * 
*/
