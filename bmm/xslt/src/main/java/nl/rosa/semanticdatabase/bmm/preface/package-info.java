package bmm/preface;
/**
 * 
 * 
 * 1.
 * Preface
 * 1.1.
 * Purpose
 * This document describes the Basic Meta-Model (BMM), a model of object models.
 * It may be considered as an approximate replacement for the UML XMI.
 * It is human-readable and writable, and supports generic types (open and closed), container types, and multiple inheritance.
 * 
 * 
 * 1.2.
 * Status
 * This specification is in the TRIAL state.
 * The development version of this document can be found at https://specifications.openehr.org/releases/LANG/latest/bmm.html.Known omissions or questions are indicated in the text with a 'to be determined' paragraph, as follows:TBD: (example To Be Determined paragraph)
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 1.3.
 * Feedback
 * Feedback may be provided on the openEHR languages specifications forum.Issues may be raised on the specifications Problem Report tracker.To see changes made due to previously reported issues, see the LANG component Change Request tracker.
 * 
 * 
 * 
 * 
 * 
 * 
 * 1.4.
 * Conformance
 * Conformance of a data or software artifact to an openEHR specification is determined by a formal test of that artifact against the relevant openEHR Implementation Technology Specification(s) (ITSs), such as an IDL interface or an XML-schema.
 * Since ITSs are formal derivations from underlying models, ITS conformance indicates model conformance.
 * 
 * 
 * 1.5.
 * Previous Versions
 * 
 * 1.5.1.
 * Version 3.0.0
 * This version made major changes to the BMM_TYPE hierarchy and semantics, enabling generic inheritance by generic and non-generic classes to be represented.
 * 1.5.2.
 * Version 3.1.0
 * This version adds meta-classes for computational elements to BMM, including: routines, variables, constants; expressions (including assertions); statements.
 * It makes various adjustments to the existing model attributes and classes.
 * The BMM remains compatible with P_BMM 2.x, i.e.
 * any existing .bmm file can be parsed to create a v 3.1.0 BMM instance.
 * 1.6.
 * A Note on Language
 * The elements of meta-models are sometimes named confusingly in the literature and within various programming language technologies.
 * In this specification, we use the following terms:
 * class
 * generally refers to a class defined in a model expressed in BMM, i.e.
 * an instance of a BMM meta-class;
 * meta-class
 * refers to a class in the BMM itself, such as BMM_CLASS, in order to clearly distinguish it from classes defined in models represented using BMM;
 * feature (of a class)
 * any stored or computed element of a class, including constants, attributes (properties) and routines (methods);
 * property
 * a stored class feature; also known as 'attribute';
 * routine
 * a computed class feature that may be either value-returning (a function) or work-performing (a procedure);
 * function
 * a routine that computes and returns a value; typically causes no side-effects in the object;
 * procedure
 * a routine that performs a computation; typically has side-effects;
 * generic (class or type)
 * a kind of class or type that has parameters of other types; known as 'template' type in some programming languages;
 * type
 * generally refers to a type defined in a model expressed in BMM, i.e.
 * an instance of a BMM meta-type;
 * meta-type
 * refers to a type in the BMM itself, which is either a class (such as BMM_CLASS) or generically derived (meta-)type in the sense of being an instance generator, where the instances will be concrete type definitions in models represented using BMM.
 * 
 * 
 * 
 * 
 * 1.7.
 * Tooling
 * The openEHR Archie Library fully implements this specification in Java and may be used to build UI tools for compiling, viewing and editing BMM models.The openEHR ADL Workbench (AWB) fully implements this specification, and provides a convenient way of illustrating BMM semantics.
 * The screenshots used in this specification are all from the ADL Workbench.
 * The tool is written in the Eiffel language, and is available as open source on Github.
 * The BMM libraries can be found in the EOMF Github repository.
 * 
 * 
 * 
 * 
 * 
*/
