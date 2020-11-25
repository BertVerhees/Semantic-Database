package nl.rosa.semanticdatabase.base_types.identification_package;
/**
 * 
 * 
 * 5.
 * Identification Package
 * 5.1.
 * Overview
 * The BASE.base_types.identification package describes a model of references and identifiers for information entities and is illustrated below.
 * 
 * 
 * 
 * Figure 4.
 * base.base_types.identification Package
 * 5.2.
 * Requirements
 * Identification of entities both in the real world and in information systems is a non-trivial problem.
 * The needs for identification across systems in a health information environment include the following:The following subsections describe some of the features and challenges of identification.
 * 
 * 
 * 
 * 
 * 
 * 
 * 5.2.1.
 * Identification of Real World Entities (RWEs)
 * Real world entities such as people, car engines, invoices, and appointments can all be assigned identifiers.
 * Although many of these are designed to be unique within a jurisdiction, they are often not, due to data entry errors, bad design (ids that are too small or incorporate some non-unique characteristic of the identified entities), bad process (e.g.
 * non-synchronised id issuing points); identity theft (e.g.
 * via theft of documents of proof or hacking).
 * In general, while some real world identifiers (RWIs) are "nearly unique", none can be guaranteed so.
 * It should also be the case that if two RWE identifiers are equal, they refer to the same RWE, but this is often not the case.
 * For practical purposes, RWIs cannot be regarded as computationally safe for making the inferences described here.
 * 5.2.2.
 * Identification of Informational Entities (IEs)
 * As soon as information systems are used to record facts about RWEs, the situation becomes more complex because of the intangible nature of information.
 * In particular: the same RWE can be represented simultaneously on more than one system ('spatial multiplicity'); the same RWE may be represented by more than one "version" of the same IE in a system ('temporal multiplicity').
 * At first sight, it appears that there can also be purely informational entities, i.e.
 * IEs which do not refer to any RWE, such as books, online-only documents and software.
 * However, as soon as one considers an example it becomes clear that there is always a notional 'definitive' or 'authoritative' (i.e.
 * trusted) version of every such entity.
 * These entities can better be understood as 'virtual RWEs'.
 * Thus it can still be said that multiple IEs may refer to any given RWE.
 * The underlying reason for the multiplicity of IEs is that 'reality' - time and space - in computer systems is not continuous but discrete, and each 'entity' is in fact just a snapshot of certain attribute values of a RWE, at a point in time, in a particular system.
 * If identifiers are assigned to IEs without regard to versions or duplicates, then no assertion can be made about the identified RWE when two IE ids are compared.
 * 5.2.3.
 * Identification of Versions
 * The notion of 'versioning' applies only to informational entities, i.e.
 * distinct instances of content each representing a snapshot of some logical entity.
 * Where such instances are stored and managed in versioned containers within a versioning system of some kind, explicit identification of the versions is required.
 * The requirements are discussed in detail in the Common IM, change_control package.
 * They can be summarised as follows: it must be possible to distinguish two versions of the same logical entity, i.e.
 * know from the identifier if they are the same or different versions of the same thing; it must be possible to distinguish two versions of the same logical entity created in two distinct systems; it must be possible to tell the relationship between the items in a versioned lineage, from the version identifiers.
 * 5.2.4.
 * Referencing of Informational Entities
 * Within a distributed information environment, there is a need for entities not connected by direct references in the same memory space to be able to refer to each other.
 * There are two competing requirements: that the separation of objects in a distributed computing environment not compromise the semantics of the model; that different types of information can be managed relatively independently; for example EHR and demographic information can be managed by different groups in an organisation or community, each with at least some freedom to change implementation and model details.
 * 5.3.
 * Design
 * This package models only informational identifiers, i.e.
 * transparent identifiers understood by openEHR or related computational systems.
 * Real World Entity Identifiers such as driver’s license numbers are modelled using the data type DV_IDENTIFIER.
 * This is not to imply that such identifiers are any less systematic or well-managed than the system identifiers defined here, only that from the point of view of openEHR, they have the same status as other informational attributes such as name, address etc of a Person.A key design decision has been to choose a string representation for all identifiers, with subparts being made available by appropriate functions which perform simple parsing on the string.
 * This ensures that the data representation of identifiers (e.g.
 * in XML) is as small as possible, while not losing object-oriented typing.
 * 
 * 
 * 
 * 
 * 5.3.1.
 * Primitive Identifiers
 * Three kinds of types are defined in this package.
 * The abstract UID type and its subtypes correspond to permanent, computationally reliable, primitive identifiers.
 * Such identifiers are regarded as 'primitive' because they are treated as having no further internal structure, in the sense that part of such an identifier is not in general meaningful.
 * The three subtypes UUID, ISO_OID and INTERNET_ID all have these properties, and are commonly accepted ways of uniquely identifying entities in computer systems.
 * In openEHR (and generally in health informatics) they are usually used as parts of other identifiers.
 * A consequence of the string representation approach used in these classes is that to set an attribute of type UID from a string value, as would be done when reading from a database, deserialising from XML or another text form, a piece of code that inspects the string structure has to be used in order to decide which of the subtypes of UID it is.
 * This is a safe thing to do, since all three subtypes have mutually exclusive string patterns, and can easily be distinguished.
 * 5.3.2.
 * Composite Identifiers
 * The OBJECT_ID type and its hierarchy of subtypes define all of the identifier types used within openEHR systems.
 * Most of these have a multi-part structure, and some are 'meaningful' i.e.
 * human readable.
 * The identifier types can be used to represent identifier values that fall into two groups semantically: those defined by openEHR (which may incorporate generic standard identifiers, such as ISO Oids etc) and those defined by external organisations.
 * The groups are as shown in the following table.
 * Identifiers whose form is defined by the HIER_OBJECT_ID type are used both by openEHR and many other organisations.
 * 5.3.2.1.
 * UID-based Identifiers The abstract type UID_BASED_ID and its two subtypes HIER_OBJECT_ID and OBJECT_VERSION_ID provide respectively, UID-based identifiers for non-versioned and versioned items.
 * The design of the latter subtype is explained in the openEHR Common IM, change_control package.
 * 5.3.2.2.
 * Archetype Identifiers The ARCHETYPE_ID subtype defines a multi-axial identifier for archetypes, meaning that each identifier instance denotes a single archetype within a multi-dimensional space.
 * The space is can be thought of as 3-dimensional, or as a versioned 2-dimensional space, consisting of the following axes: reference model entity, i.e.
 * target of archetype, defined as: name of model issuer; name of model (there may be more than one from the same issuer); name of concept in model, i.e.
 * class name domain concept; version.
 * The three outer sections are delimited by '.' characters, while the parts of the first section are delimited by - characters.
 * As with any multi-axial identifier, the underlying principle of an archetype identifier is that all parts of the identifier must be able to be considered immutable.
 * This means that no variable characteristic of an archetype (e.g.
 * accrediting authority, which might change due to later accreditation by another authority, or may be multiple) can be included in its identifier.
 * The explicit inclusion of version as part of the identifier means that two 'versions' of an archetype are actually two distinct archetypes.
 * (The rules for archetype versions, revisions and other variants are given in the openEHR Archetype Identification specification.) Examples of archetype identifiers include: openEHR-EHR-SECTION.physical_examination.v2 openEHR-EHR-SECTION.physical_examination-prenatal.v1 Hl7-RIM-Act.progress_note.v1 openEHR-EHR-OBSERVATION.progress_note-naturopathy.v2 The grammar of archetype identifiers is given below in Section 5.5.
 * Warning some archetype authoring tools have historically allowed a nonconforming version part within archetype identifiers which included the lifecycle status.
 * This has led to some archetypes having an identifier whose version part is of the form .v1draft or similar.
 * The openEHR Foundation will publish guidelines and a timeline on its website for dealing with this problem.
 * New and existing archetype tools may have to support this exception, depending on where they are to be used, and it is recommended that it at least be supported via a command line switch or option.
 * Where such non-conforming archetypes are re-used within a new environment, the identifier should be corrected.
 * 5.3.2.3.
 * Terminology Identifiers The TERMINOLOGY_ID subtype defines a globally unique single string identifier for terminologies.
 * Terminology identifier values may include a version, either as part of the name, and/or according to the syntax defined in section 4.3.12 below.
 * Examples of terminology identifiers include: "SNOMED-CT" "ICD9(1999)" Currently the best authoritative source for the name part of the identifier (i.e.
 * the part excluding the optional version part in parentheses) is the US National Library of Medicine UMLS identifiers for included terminologies.
 * The scheme defined by the TERMINOLOGY_ID class provides for the situation where major 'versions' of a terminology such as the World Health Organisation’s 'ICD10' and 'ICD10AM' (AM = 'Australian modifications') can accommodate a finer grain of versioning or revisioning, e.g.: "ICD10AM(3rd_ed)" "ICD10AM(4th_ed)" The version part of a terminology identifier is in theory only absolutely necessary for those terminologies which break the rule that the concept being identified with a code loses or changes its meaning over versions of the terminology.
 * This should not be the case for modern terminologies and ontologies, particularly those designed since the publication of Cimino’s 'desiderata' (Cimino, 1997) of which the principle of 'concept permanance' is applicable here - "A concept’s meaning cannot change and it cannot be deleted from the vocabulary".
 * However, there may be older terminologies, or specialised terminologies which may not have obeyed these rules, but which are still used; version ids should always be used for these.
 * At a practical level, versions may be included routinely in some systems to support the potential medico-legal need to prove that a) a given code was in fact defined in the terminology (it may not have existed in an earlier edition) and b) that the meaning assmued in the system was indeed the one assigned to it in the particular version or edition.
 * 5.3.2.4.
 * Equivalence Although there are anomalies in some published terminologies and between some versions or editions of the same terminology, two terminology identifiers that are the same, disregarding the version part, can usually be considered as semantic equivalents in the terminology world.
 * However, depending on which source of strings have been chosen for the name part of the identifier, two different identifiers may also indicate the same terminology, e.g.
 * "ICD10AM_2000" (NLM identifier used in UMLS) and "ICD10AM(2nd_ed)" refer to the same thing.
 * 5.3.2.5.
 * Identifying Versions within openEHR Versioned Containers The OBJECT_VERSION_ID defines the semantics of the scheme used in openEHR for identifying versions within a versioned container, and uses a three-part identifier, consisting of: object_id: the identifier of the version container, in the form of a UID, typically a Guid; creating_system_id: the identifier of the system in which this version was created, of type UID, typically a reverse domain identifier; version_tree_id: the location in the version tree, as a 1- or 3-part numeric identifier, where the latter variant expresses branching; this is modelled using the VERSION_TREE_ID type.
 * The following provides a typical example: 87284370-2D4B-4e3d-A3F3-F303D2F4F34B::uk.nhs.ehr1::2 Under this scheme, multiple versions in the same container all have the same value for object_id, whilst their location in the version tree is given by the combination of the version tree identifier and the identifier of the creating system.
 * The requirements on the third part of the identifier are that it be unique per system, and that it be easy to obtain or generate.
 * It is also helpful if it is a meaningful identifier.
 * The two most practical candidates appear to be GUIDs (which are not meaningful, but are easy to generate) and reverse internet domain identifiers (these are easy to determine if the system has an internet address, and are meaningful and directly processible, however unconnected systems pose a problem).
 * ISO Oids might also be used.
 * All of these identifier types are accommodated via the use of UID.
 * A full explanation of the version identification scheme and its capabilities is given in the Common IM, change_control package.
 * 5.3.2.6.
 * Generic and External Identifiers The GENERIC_ID type provides for identifiers of schemes other than defined concretely in the BASE.base_types.identification package.
 * It has a single method scheme, which may be used to record the identifier type.
 * The names of schemes are not currently controlled.
 * 5.3.2.7.
 * Hierarchical Identifiers The HIER_OBJECT_ID type is defined to support hierarchical identifiers, often based on ISO Oids or other similar machine-readable and -resolvable schemes.
 * 5.3.2.8.
 * Composite Identifiers and Case All composite identifiers should follow two rules with regard to case, namely: to be case-preserving - not change case due to persistence, copying, transfer or other computation processes; to be case-insensitive - two identifiers identical apart from case are considered to be identical, and therefore to identify the same thing.
 * The practical consequences of these rules are as follows: mixed-case identifiers may be used, such as archetype identifiers, mixed-case reverse domain identifiers (the INTERNET_ID type); the original case chosen in the letters of identifiers on creation within an openEHR system should be as published by the relevant issuing organisation (e.g.
 * NLM UMLS terminology names are all upper case); if identifiers are used as part of filenames within computer file systems, care must be taken to create and preserve filenames correctly.
 * For this reason, software usually has to handle filename creation and modification differently on Unix-style operating systems, which are case-sensitive (and therefore case-preserving), and Windows-style operating systems, which are case-insensitive but usually case-preserving.
 * These rules do not apply to any identifier constructed in a language in which case does not exist as a concept.
 * For this reason, for identifiers translated in and out of the Turkish language (and possibly in smaller related languages), care must be taken with the 'I/i' characters.
 * 5.3.2.9.
 * Composite Identifiers and Language In all of the 'meaningful' identifier types above, with the posible exception of GENERIC_ID, the human-readable identifier sections are assumed to use only the basic latin character set, possibly with the addition of other special characters as allowed by the production rules defined below for each identifier.
 * In most cases, the textual parts of these identifiers will be words from the English language, or else they will be recognisable words from other languages, where necessary alliterated into the latin alphabet.
 * Accented and other diacritical letter variants are not allowed.
 * This limitation is made in the interests of practical computability of identifiers, and is in common with class and attribute naming in shared UML models in the standards world, and also with internet domain names and internet URIs.
 * 5.3.3.
 * References
 * All OBJECT_IDs are used as identifier attributes within the thing they identify, in the same way as a database primary key.
 * To refer to an identified object from another object, an instance of the class OBJECT_REF should generally be used, in the same way as a database foreign key.
 * The class OBJECT_REF is provided as a means of distributed referencing, and includes the object namespace (typically 1:1 with some service, such as "terminology") and type.
 * The general principle of object references is to be able to refer to an object available in a particular namespace or service.
 * Usually they are used to refer to objects in other services, such as a demographic entity from within an EHR, but they may be used to refer to local objects as well.
 * The type may be the concrete type of the referred-to object (e.g.
 * "GP") or any proper ancestor (e.g.
 * PARTY).
 * 5.4.
 * Class Descriptions
 * 
 * 5.4.1.
 * UID Class
 * 
 * 5.4.2.
 * ISO_OID Class
 * 
 * 5.4.3.
 * UUID Class
 * 
 * 5.4.4.
 * INTERNET_ID Class
 * 
 * 5.4.5.
 * OBJECT_ID Class
 * 
 * 5.4.6.
 * UID_BASED_ID Class
 * 
 * 5.4.7.
 * HIER_OBJECT_ID Class
 * 
 * 5.4.8.
 * OBJECT_VERSION_ID Class
 * 
 * 5.4.9.
 * VERSION_TREE_ID Class
 * 
 * 5.4.10.
 * ARCHETYPE_ID Class
 * 
 * 5.4.11.
 * TEMPLATE_ID Class
 * 
 * 5.4.12.
 * TERMINOLOGY_ID Class
 * 
 * 5.4.13.
 * GENERIC_ID Class
 * 
 * 5.4.14.
 * OBJECT_REF Class
 * 
 * 5.4.15.
 * PARTY_REF Class
 * 
 * 5.4.16.
 * LOCATABLE_REF Class
 * 
 * 5.5.
 * Syntaxes
 * The identifiers defined above are defined in their string form by the following EBNF grammar rules.
 * 
 * 
 * 
 * (* --------------------------- INTERNET_ID --------------------------- *) (* According to IETF http://tools.ietf.org/html/rfc1034[RFC 1034] and *) (* http://tools.ietf.org/html/rfc1035[RFC 1035], as clarified by *) (* http://tools.ietf.org/html/rfc2181[RFC 2181] (section 11), *) (* and relaxation of https://tools.ietf.org/html/rfc1123[RFC 1123] *) (* The syntax of a domain name follows the grammar below.
 * Slightly *) (* reduced for the purpose here, plus allows underscores.
 * *) internet_id = subdomain ; subdomain = label | subdomain, '.', label ; label = alphanum | alphanum-ext-str, alphanum ; (* --------------------------- UID_BASED_ID --------------------------- *) uid_based_id = root [ '::' extension ] ; root = uid ; extension = ? any string ? ; (* any string *) (* ------------------------- OBJECT_VERSION_ID ----------------------- *) object_version_id = object_id '::' creating_system_id '::' version_tree_id ; object_id = uid ; creating_system_id = uid ; (* ------------------------- VERSION_TREE_ID ------------------------- *) version_tree_id = trunk_version [ '.' branch_number '.' branch_version ] ; trunk_version = number ; branch_number = number ; branch_version = number ; (* ------------------------- UID, OID, GUID -------------------------- *) uid = iso_oid | guid ; iso_oid = number, { '.', number } ; guid = hex-number, '-', hex-number, '-', hex-number, '-', hex-number, '-', hex-number ; (* -------------------------- ARCHETYPE_ID --------------------------- *) archetype_id = qualified_rm_entity '.' domain_concept '.' version_id ; qualified-rm-entity = rm_originator '-' rm_name '-' rm_entity ; rm-originator = alphanum-str ; (* id of org originating the RM on which this archetype is based *) rm-name = alphanum-str ; (* id of the RM on which the archetype is based *) rm-entity = alphanum-str ; (* ontological level in the RM *) domain-concept = concept-name { '-' specialisation } ; concept-name = alphanum-str ; specialisation = alphanum-str ; version-id = 'v', non-zero-digit, [ number ] ; (* numeric version identifier *) (* ------------------------- TERMINOLOGY_ID -------------------------- *) terminology_id = name-str, [ '(', name-str, ')' ] ; (* -------------------------- generic rules -------------------------- *) alphanum = letter | digit ; name-str = letter, { letter | digit | '_' | '-' | '/' | '+' } ; alphanum-str = letter, { letter | digit | '_' } ; alphanum-ext-str = letter, { letter | digit | '_' | '-' } ; letter = 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' | 'K' | 'L' | 'M' | 'N' | 'O' | 'P' | 'Q' | 'R' | 'S' | 'T' | 'U' | 'V' | 'W' | 'X' | 'Y' | 'Z' | 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' | 'k' | 'l' | 'm' | 'n' | 'o' | 'p' | 'q' | 'r' | 's' | 't' | 'u' | 'v' | 'w' | 'x' | 'y' | 'z' ; number = digit, { digit } ; hex-number = hex-digit, { hex-digit } ; digit = '0' | non-zero-digit ; non-zero-digit = '1' | '2' | '3' | '4' | '5' | '6' | '7'| '8' | '9' ; hex-digit = digit | 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'a' | 'b' | 'c' | 'd' | 'e' | 'f' ;
 * 
*/
