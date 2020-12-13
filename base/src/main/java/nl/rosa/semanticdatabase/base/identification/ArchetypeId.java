package nl.rosa.semanticdatabase.base.identification;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Identifier for archetypes.
 * Ideally these would identify globally unique archetypes.
 * Lexical form: rm_originator '-' rm_name '-' rm_entity '.' concept_name { '-' specialisation }* '.v' number.
 */
public class ArchetypeId extends ObjectId {

    /* static fields */
    private static final String AXIS_SEPARATOR = ".";
    private static final String SECTION_SEPARATOR = "-";

    private static Pattern NAME_PATTERN =
            Pattern.compile("[a-zA-Z][a-zA-Z0-9()_/%$#&]*");
    private static Pattern VERSION_PATTERN =
            Pattern.compile("[a-zA-Z0-9]+");
    private final static Pattern archetypeIDPattern = Pattern.compile("((?<namespace>.*)::)?(?<publisher>[^.-]*)-(?<package>[^.-]*)-(?<class>[^.-]*)\\.(?<concept>[^.]*)(-(?<specialisation>[^.]*))?(\\.v(?<version>.*))?");


    private String namespace;
    private String qualifiedRmEntity;
    private String domainConcept;
    private String rmOriginator;
    private String rmName;
    private String rmEntity;
    private String specialisation;
    private String versionId;

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/
    private void parseValue(String value) {
        Matcher m = archetypeIDPattern.matcher(value);

        if (!m.matches()) {
            throw new IllegalArgumentException(value + " is not a valid archetype human readable id");
        }
        namespace = m.group("namespace");
        rmOriginator = m.group("publisher");
        rmName = m.group("package");
        rmEntity = m.group("class");
        buildQualifiedRmEntity();

        specialisation = m.group("specialisation");

        domainConcept = m.group("concept");
        versionId = m.group("version");
    }


    public String getFullId() {
        StringBuilder result = new StringBuilder(30);
        if(namespace != null) {
            result.append(namespace);
            result.append("::");
        }
        result.append(rmOriginator);
        result.append("-");
        result.append(rmName);
        result.append("-");
        result.append(rmEntity);
        result.append(".");
        result.append(domainConcept);
        if(specialisation != null) {
            result.append("-");
            result.append(specialisation);
        }
        if (versionId == null) {
            return result.toString();
        } else if (versionId.startsWith("v")) {
            result.append(".");
        } else {
            result.append(".v");
        }
        result.append(versionId);
        return result.toString();
    }

    /**
     * Return localID
     *
     * @return localID
     */
    public String localId() {
        return getValue();
    }

    /**
     * Globally qualified reference model entity, e.g.
     * openehr-EHR-OBSERVATION.
     * cardinality: 1..1
     */
    public String qualifiedRmEntity() {
        return qualifiedRmEntity;
    }

    /**
     * Name of the concept represented by this archetype, including specialisation, e.g.
     * Biochemistry_result-cholesterol.
     * cardinality: 1..1
     */
    public String domainConcept() {
        return domainConcept;
    }

    /**
     * Organisation originating the reference model on which this archetype is based, e.g.
     * openehr, cen, hl7 .
     * cardinality: 1..1
     */
    public String rmOriginator() {
        return rmOriginator;
    }

    /**
     * Name of the reference model, e.g.
     * rim, ehr_rm, en13606 .
     * cardinality: 1..1
     */
    public String rmName() {
        return rmName;
    }

    /**
     * Name of the ontological level within the reference model to which this archetype is targeted, e.g.
     * for openEHR, folder , composition , section , entry .
     * cardinality: 1..1
     */
    public String rmEntity() {
         return rmEntity;
    }

    /**
     * The contextID
     *
     * @return always null
     */
    public Uid contextId() {
        return null;
    }

    /**
     * Name of specialisation of concept, if this archetype is a specialisation of another archetype, e.g.
     * cholesterol .
     * cardinality: 1..1
     */
    public String specialisation() {
        return specialisation;
    }

    /**
     * Version of this archetype.
     * cardinality: 1..1
     */
    public String versionId() {
        return versionId;
    }

    public String base() {
        return new StringBuffer(toQualifiedRmEntity(rmOriginator,
                rmName, rmEntity))
                .append(AXIS_SEPARATOR)
                .append(domainConcept)
                .toString();
    }

    /**
     * Return true if both archetypeId has the same value, and versionID is
     * not included in comparison
     *
     * @return true if equals
     */
    public boolean equalsIgnoreVersionID(ArchetypeId id) {
        return qualifiedRmEntity.equals(id.qualifiedRmEntity)
                && domainConcept.equals(id.domainConcept);
    }
    //***** ArchetypeId *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/
    public ArchetypeId() {
    }

    /**
     * Parse the Archetype id from a string
     *
     * @param value
     */
    public ArchetypeId(String value) {
        parseValue(value);
        setValue(value);
    }

    public void buildQualifiedRmEntity() {
        qualifiedRmEntity = rmOriginator + "-" + rmName + "-" + rmEntity;
    }



    private static String toQualifiedRmEntity(String rmOriginator,
                                              String rmName,
                                              String rmEntity) {
        return new StringBuffer(rmOriginator)
                .append(SECTION_SEPARATOR)
                .append(rmName)
                .append(SECTION_SEPARATOR)
                .append(rmEntity)
                .toString();
    }

    //***** ArchetypeId *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "ArchetypeId {" +
                        '}';
    }

}

/**
 * ***** BEGIN LICENSE BLOCK *****
 * <p>
 * ISC License
 * <p>
 * Copyright (c) 2020, Bert Verhees
 * <p>
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * <p>
 * ***** END LICENSE BLOCK *****
 */
