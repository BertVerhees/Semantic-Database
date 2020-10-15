package bmm;

/**
 * 
 * Title: Basic Meta-Model (BMM)
 * 
 * Java generated from OpenEhr-html to Java by XSLT (Bert Verhees)
 * From BMM-document:
 * 
 * 3.1.0:. Add Basic Meta-Model (BMM) spec to LANG component.:openEHR SEC:11 May 2020
 * 
 * Acknowledgements
 * Primary Author
 * Thomas Beale, Ars Semantica; openEHR Foundation Management Board.
 * Contributors
 * Matija Kejžar, Senior Engineer, Better, Slovenia
 * Patrick Langford, NeuronSong LLC, Utah, USA
 * Claude Nanjo MA African Studies, M Public Health, Cognitive Medical Systems Inc., California, USA
 * Harold Solbrig, Mayo Clinic, Rochester, USA
 * Erik Sundvall PhD, Linkoping University, Sweden
 * Bert Verhees, ROSA Software, The Netherlands.
 * Trademarks
 * 'openEHR' is a registered trademark of the openEHR Foundation;
 * 'Java' is a registered trademark of Oracle Corporation;
 * 'C#' is a registered trademark of Microsoft;
 * 'OMG' and 'UML' are registered trademarks of the Object Management Group;
 * 'MagicDraw' is a registered trademark of NoMagic Inc;
 * 'Rational Software Architect' is a registered trademark of IBM Corporation.
 * 
 * 1. Preface
 * 1.1. Purpose
 * This document describes the Basic Meta-Model (BMM), a model of object models. It may be considered as an approximate replacement for the UML XMI. It is human-readable and writable, and supports generic types (open and closed), container types, and multiple inheritance.
 * 1.2. Status
 * This specification is in the TRIAL state. The development version of this document can be found at https://specifications.openehr.org/releases/LANG/latest/bmm.html.Known omissions or questions are indicated in the text with a 'to be determined' paragraph, as follows:TBD: (example To Be Determined paragraph)
 * 1.3. Feedback
 * Feedback may be provided on the openEHR languages specifications forum.Issues may be raised on the specifications Problem Report tracker.To see changes made due to previously reported issues, see the LANG component Change Request tracker.
 * 1.4. Conformance
 * Conformance of a data or software artifact to an openEHR specification is determined by a formal test of that artifact against the relevant openEHR Implementation Technology Specification(s) (ITSs), such as an IDL interface or an XML-schema. Since ITSs are formal derivations from underlying models, ITS conformance indicates model conformance.
 * 1.5. Previous Versions
 * 
 * 1.6. A Note on Language
 * The elements of meta-models are sometimes named confusingly in the literature and within various programming language technologies. In this specification, we use the following terms:
 * 1.7. Tooling
 * The openEHR Archie Library fully implements this specification in Java and may be used to build UI tools for compiling, viewing and editing BMM models.The openEHR ADL Workbench (AWB) fully implements this specification, and provides a convenient way of illustrating BMM semantics. The screenshots used in this specification are all from the ADL Workbench. The tool is written in the Eiffel language, and is available as open source on Github. The BMM libraries can be found in the EOMF Github repository.
 * 
 * 2. Overview
 * 2.1. Introduction
 * One of the key needs in any open computing environment is a computable representation of its own models. This is for a number of purposes, including reasoning about them, performing validation and consistency checking, building software and generating documentation. This is particularly true of openEHR and other archetype-based frameworks, where a further need is to be able to validate archetypes and templates with respect to the reference model, and also to validate runtime instance data against operational templates and the reference model.A number of computable representations of the openEHR published models have been available in the past. Currently models are represented in two computable forms, namely UML and BMM (i.e. the format described in this specification).The primary use of the UML expression is for specification publishing. In this role, UML diagrams and static models are built, and then post-processed to correct signatures of class properties and functions. The post-processing corrects UML’s shortcomings and errors in non-singular relations, generic (template) types, and qualified attributes. The result can be used for publishing documentation with feature signatures that are formally correct and will be understood by developers in most programming languages. It can also be serialised and used computably, e.g. in other visualisation or modelling tools. UML’s own serial format, XMI is thus generally unsuitable for such uses, due to the formal errors, as well as its excessive complexity. XMI is also notoriously non-standard across UML tools.As a result, openEHR introduced the Basic Meta-Model (BMM) in 2009 as a way of representing correct object-oriented semantics of information models for use in tools, along with a serial format by default expressed in the openEHR ODIN syntax.The BMM provides a standalone alternative to UML/XMI which correctly represents all types, including open and closed generic types, inheritance of generic types, and various other problems with UML. As a meta-model it is adapted to the task, i.e. representing entity types that can appear in object models, rather than the over-generalised semantics of the UML meta-model. This reduced scope, and the fact that it contains no diagram semantics enables its serial form to be human-readable.
 * 2.2. Features
 * The Basic Meta-Model supports the representation of object models in the ISO RM/ODP information and computational points of view, i.e. in programming terms:It is designed to enable both human authoring and machine processing, including e.g. extraction of BMM textual schemas from a UML tool or programming language classes. The semantics of the model are heavily influenced by the formal approach to object-orientation described by Bertrand Meyer in Object-oriented Software Construction (Meyer, 1997) and also the Eiffel language, which is significantly better basis for object modelling than the UML 2.x meta-model. The BMM consequently departs from UML in a number of significant ways, and also from the OOSC/Eiffel approach in some aspects (e.g. direct meta-type suport for container types). Its key features are as follows:Functional elements are supported via the inclusion of meta-types representing signatures and tuples, enabling the construction of delayed agent calls, known here as agents, and function applications (i.e. function calls).Note that there is no BMM entity for graphical diagramming semantics. Thus, there is no idea of 'association' distinct from an 'attribute', as per UML, which treats lines between class boxes as formal elements.
 * 2.3. Current State of the Art
 * 
 * 2.4. Computational Model
 * The BMM is specified as a structural model representing an abstract syntax tree (AST), which is the result of either in-memory construction (such as by a model authoring tool) or by parsing of a serialised representation of a BMM model. It does not specify an abstract syntax, and indeed, more than one concrete syntax could be parsed to a BMM instance.
 * 2.5. Uses of the BMM
 * 
 * 2.6. Specification Structure
 * This specification defines a BMM object model, i.e. the in-memory object structure of a BMM. The related BMM Persistence specification defines an object model for a serialised schema form. The latter enables serialisation of a BMM into a concrete syntax such as ODIN, JSON or XML.The BMM packages are as follows:Related packages are:These are illustrated below.
 * 2.7. Class Definitions
 * 
 * 
*/
