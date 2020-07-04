/**
 * Default created on 4-7-2020
 *
 * In BMM, a model is understood as a set of package and module definitions that are
 * developed and maintained as a unit, by some organisation, and usually having an
 * associated hierarchical namespace. The abstract BMM_MODULE class is the ancestor
 * for any kind of module, which is understood as a container for features of various
 * kinds, including the usual properties, routines, and so on.
 * A BMM model is structured in the same general way as a UML model, i.e. with a
 * hierarchical package containment structure and a set of module definitions,
 * where a commonly used type of module is the class.
 *
 * The BMM_MODEL class defines the single instance of each distinct BMM model that may
 * exist within a collection of models, such as shown in the model_access package above.
 * It provides an interface that enables any class definition to be retrieved, as well as
 * various accessor functions to interrogate the model. A BMM Model has a name
 * (the inherited name attribute) that is used to identify the model as a whole within a
 * system using multiple models. It contains a number of other meta-data attributes
 * describing authorship etc, and otherwise contains a list of package and class definitions.
 *
 * In BMM, packages have the same role as in UML - as non-semantic organisational logical
 * containers of classes, usually corresponding to file system folders in software
 * implementations. They provide an organisational convenience, and in an instantiated
 * BMM model, contain references to class definitions. A model validity checker ensures
 * that every class is contained within exactly one package.
 *
 * A model may use another model. This is the same kind of relationship denoted by the
 * 'import' keyword in many programming languages. In BMM, the use of other models is
 * declared once only, in the using model, rather than on a per-class level as in some
 * languages (e.g. Java). The use of another model makes its contents available for use
 * in declarations (e.g. inheritance) and expressions within the using model.
 * This is achieved by populating the BMM_CLASS.scope attribute with a reference to
 * the used model. In a serial form, a typical syntax such as other_model_name::Class
 * would be used.
 */

package nl.rosa.semanticdatabase.bmmdata.domain.model_structure;