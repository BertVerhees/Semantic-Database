package nl.rosa.semanticdatabase.resource.resource_package;
/**
 * 
 * 
 * 2.
 * Resource Package
 * 2.1.
 * Overview
 * The openEHR BASE component resource package defines the structure and semantics of the general notion of an online resource which has been created by a human author, and consequently for which natural language is a factor.
 * The package is illustrated below.
 * 
 * 
 * 
 * Figure 1.
 * resource Package
 * 2.1.1.
 * Natural Languages and Translation
 * Authored resources contain natural language elements, and are therefore created in some original language, recorded in the orginal_language attribute of the AUTHORED_RESOURCE class.
 * Information about translations is included in the translations attribute, which allows for one or more sets of translation details to be recorded.
 * A resource is translated by doing the following: translating every language-dependent element to the new language; adding a new TRANSLATION_DETAILS instance to translations, containing details about the translator, organisation, quality assurance and so on.
 * any further translations to language-specific elements in a instances of descendent type of AUTHORED_RESOURCE.
 * The languages_available function provides a complete list of languages in the resource.
 * 2.1.2.
 * Meta-data
 * What is normally considered the 'meta-data' of a resource, i.e.
 * its author, date of creation, purpose, and other descriptive items, is described by the RESOURCE_DESCRIPTION and RESOURCE_DESCRIPTION_ITEM classes.
 * The parts of this that are in natural language, and therefore may require translated versions, are represented in instances of the RESOURCE_DESCRIPTION_ITEM class.
 * Thus, if a RESOURCE_DESCRIPTION has more than one RESOURCE_DESCRIPTION_ITEM, each of these should carry exactly the same information in a different natural language.
 * The AUTHORED_RESOURCE.description attribute is optional, allowing for resources with no meta-data at all, e.g.
 * resources in a partial state of construction.
 * The translations attribute may still be required, since there may be other parts of the resource object (specified by a class into which AUTHORED_RESOURCE is inherited) that are language-dependent.
 * 2.1.3.
 * Revision History
 * When the resource is considered to be in a state where changes to it should be controlled, the is_controlled attribute is set to True, and all subsequent changes should have an audit trail recorded.
 * Usually controlled resources would be managed in a versioned repository (e.g.
 * implemented by CVS, Subversion or similar systems), and audit information will be stored somewhere in the repository (e.g.
 * in version control files).
 * The revision_history attribute defined in the AUTHORED_RESOURCE class is intended to act as a documentary copy of the revision history as known inside the repository, for the benefit of users of the resource.
 * Given that resources in different places may well be managed in different kinds of repositories, having a copy of the revision history in a standardised form within the resource enables it to be used interoperably by authoring and other tools.
 * Every change to a resource committed to the relevant repository causes a new addition to the revision_history.
 * 2.2.
 * Class Descriptions
 * 
 * 2.2.1.
 * AUTHORED_RESOURCE Class
 * 
 * 2.2.2.
 * TRANSLATION_DETAILS Class
 * 
 * 2.2.3.
 * RESOURCE_DESCRIPTION Class
 * 
 * 2.2.4.
 * RESOURCE_DESCRIPTION_ITEM Class
 * 
 * 
*/
