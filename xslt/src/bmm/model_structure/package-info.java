package bmm/model_structure;
/**
 * 
 * 
 * 4. Model Structure
 * 4.1. Overview
 * The core package defines the main BMM meta-model, within which the model sub-package defines the top-level structure of a model which is an instance of the BMM. The UML for this package is shown below.
 * 
 * 
 * 
 * Figure 7. base.bmm.core.model Package - Model structure
 * 4.2. Naming Convention
 * In a BMM model, names typically appear in the common case-sensitive form used by the model users, and may therefore follow one of a number of common conventions, including 'camel case', 'snake-case' and so on. When used computationally within an instantiated BMM model, it is assumed that case-insensitive matching is used. This means that the class name "Hashable" refers to the same class as "HASHABLE". Note however that underscores are not removed during matching, so that the classes "HashMap" and "HASH_MAP" are understood as different classes.
 * 
 * 
 * 
 * 
 * 4.3. Model Semantics
 * In BMM, a model is understood as a set of package and module definitions that are developed and maintained as a unit, by some organisation, and usually having an associated hierarchical namespace. The abstract BMM_MODULE class is the ancestor for any kind of module, which is understood as a container for features of various kinds, including the usual properties, routines, and so on. A BMM model is structured in the same general way as a UML model, i.e. with a hierarchical package containment structure and a set of module definitions, where a commonly used type of module is the class. The following illustrates the structure of a typical 'class' or 'object' model.The BMM_MODEL class defines the single instance of each distinct BMM model that may exist within a collection of models, such as shown in the model_access package above. It provides an interface that enables any class definition to be retrieved, as well as various accessor functions to interrogate the model. A BMM Model has a name (the inherited name attribute) that is used to identify the model as a whole within a system using multiple models. It contains a number of other meta-data attributes describing authorship etc, and otherwise contains a list of package and class definitions.
 * 
 * 
 * 
 * Figure 8. BMM model structure
 * 
 * 
 * 4.3.1. Packages
 * In BMM, packages have the same role as in UML - as non-semantic organisational logical containers of classes, usually corresponding to file system folders in software implementations. They provide an organisational convenience, and in an instantiated BMM model, contain references to class definitions. A model validity checker ensures that every class is contained within exactly one package. Package paths are only used in BMM to specify package structures in the serialised form in an efficient way, i.e. by using paths to avoid defining a hierarchy in which only lower packages contain classes. They are not used as namespaces as in UML. Consequently, all classes in a BMM model should be uniquely named.
 * 4.3.2. Use of other Models
 * A model may use another model. This is the same kind of relationship denoted by the 'import' keyword in many programming languages. In BMM, the use of other models is declared once only, in the using model, rather than on a per-class level as in some languages (e.g. Java). The use of another model makes its contents available for use in declarations (e.g. inheritance) and expressions within the using model. This is achieved by populating the BMM_CLASS.scope attribute with a reference to the used model. In a serial form, a typical syntax such as other_model_name::Class would be used.
 * 4.3.3. Documentation
 * A documentation attribute is inherited from BMM_DECLARATION into BMM_CLASS, BMM_PROPERTY, BMM_MODEL and BMM_PACKAGE (the latter two via BMM_PACKAGE_CONTAINER), enabling packages, classes and properties to be individually documented using a keyed table (i.e. Hash) of values. It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.
 * 4.3.4. Other Meta-data
 * The BMM_DECLARATION meta-class also defines the attribute extensions of type Hash<String, Any>, to enable representation of meta-data of any type on any model node. This provides a means of extending BMM.
 * 4.4. The Any Class and Type
 * While a BMM model defines a model in terms of class declarations, it must always have a top class named Any from which all others inherit. Similar to the root class in a typical OOPL type systems (sometimes called 'Object'), the Any class defines semantics true for all objects such as equality (i.e. semantics for an '=' operator) and copying.A BMM model may define its own Any class, but if it does not, the BMM_MODEL instance representing the model will produce a standard 'Any' class via the any_class_definition() method. This will create the following structure, including a default package structure, and an Any type.The Any type defined by the model’s Any class, or else the default one above, will be used as the inheritance parent for every class in the model that doesn’t have any other inheritance parent. As a result, the inheritance graph will always have the Any type as its top node.
 * 
 * 
 * 
 * 
 * 
 * Figure 9. Default Any class
 * 
 * 
 * 4.5. Class Definitions
 * 
 * 4.5.1. BMM_DECLARATION Class
 * 
 * 4.5.2. BMM_PACKAGE_CONTAINER Class
 * 
 * 4.5.3. BMM_PACKAGE Class
 * 
 * 4.5.4. BMM_MODEL Class
 * 
 * 4.5.5. BMM_MODULE Class
 * 
 * 
*/
