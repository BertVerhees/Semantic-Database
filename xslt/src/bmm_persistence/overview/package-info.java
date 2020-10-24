package bmm_persistence/overview;
/**
 * 
 * 
 * 2. Overview
 * 2.1. Conceptual Approach
 * This specification defines a model that may be used as the basis for a serial format for the Basic Meta-Model (BMM). The formalism described here is an adaptation of pure object serialisation approaches used in mainstream programming languages. Instead of directly materialising a BMM instance graph from serial form, the initial materialised form is a graph of P_BMM_XXX classes, with a subsequent in-memory model-to-model transform step required to produce a materialised BMM model.The P_BMM_* classes perform two functions. Firstly, they are a modified and simplified version of the BMM_* classes that enable for example symbolic referencing via class names, syntactical type names to be used etc, rather than the full explosion of fine-grained objects that would result from a direct serialisation of BMM_* classes. This enables an object model represented internally (to a tool, say) in BMM form, converted to P_BMM form, and then serialised to a .bmm file, to be easily readable and editable by human users.The second is that .bmm files function as schemas that support schema inclusion and therefore re-use, in a similar manner to the XML schema languages. Thus, a single logical BMM model can be expressed as a number of .bmm schema files which are actually P_BMM_* object serialisations of parts of the BMM model. A schema reading component has to resolve the schema inclusions and ultimately BMM_* object instantiations to obtain the in-memory form of the model.We thus talk of the P_BMM_* classes as a 'model of a BMM schema' and the BMM_* classes as a 'model of a BMM model', where the latter is understood as the fully computable in-memory object structure with all name references resolved to object references.The P_BMM format is not the only serial format possible for BMM, and alternatives, e.g. a more syntactic style reminiscent of OMG IDL, are possible.The normal use of P_BMM schemas is as follows:
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
 * 2.2. Concrete Format
 * BMM models are normally expressed as schema text files that support inclusion and re-use. The default file format has historically been openEHR ODIN syntax, and BMM tools to date support this format. However any common format that can express typed object models may be used, including JSON (with type markers), YAML, and XML. The examples shown in this specification are primarily in ODIN, but a tool implementing BMM may choose to serialise in and out of another preferred format.
 * 
 * 
 * 
*/
