package nl.rosa.semanticdatabase.referencemodel.model.common.basetypes;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/*
Identifier for archetypes. Ideally these would identify globally unique archetypes.
Lexical form: rm_originator '-' rm_name '-' rm_entity '.' concept_name { '-' specialisation }* '.v' number.
 */
public class ArchetypeId extends ObjectId{
    private String qualifiedRmEntity;
    private String domainConcept;
    private String versionId;
    private String rmOriginator;
    private String rmName;
    private String rmEntity;
    private String conceptName;
    private ArrayList<String> specialisation;

    public ArchetypeId(String value){
        super(value);
        loadValue(value);
    }

    private void loadValue(String value) {
        StringTokenizer tokens = new StringTokenizer(value,
                AXIS_SEPARATOR);
        if (tokens.countTokens() != 3) {
            throw new IllegalArgumentException("bad format, wrong number of \"" +
                    AXIS_SEPARATOR
                    + "\", " + value);
        }
        qualifiedRmEntity = tokens.nextToken();
        domainConcept = tokens.nextToken();
        versionId = tokens.nextToken();

        tokens = new StringTokenizer(qualifiedRmEntity,
                SECTION_SEPARATOR);
        if (tokens.countTokens() != 3) {
            throw new IllegalArgumentException("bad format, wrong number of \"" +
                    SECTION_SEPARATOR
                    + "\" , " + value);
        }
        rmOriginator = tokens.nextToken();
        rmName = tokens.nextToken();
        rmEntity = tokens.nextToken();

        tokens = new StringTokenizer(domainConcept, SECTION_SEPARATOR);
        if (tokens.countTokens() < 1) {
            throw new IllegalArgumentException(
                    "bad format, too few sections for domainConcept, " + value);
        }
        conceptName = tokens.nextToken();
        specialisation = new ArrayList<String>();
        while(tokens.hasMoreTokens()) {
            specialisation.add(tokens.nextToken());
        }
        validateAll();
    }

    private void validateAll() {
        validateName(rmOriginator, "rm_originator");
        validateName(rmName, "rm_name");
        validateName(rmEntity, "rm_entity");
        validateName(conceptName, "concept_name");

        if (specialisation != null) {
            for(String name : specialisation) {
                validateName(name, "specialisation");
            }
        }
        validateVersionID(versionId);
    }
    private static String toValue(String rmOriginator,
                                  String rmName,
                                  String rmEntity,
                                  String conceptName,
                                  String specialisation,
                                  String versionID) {
        return new StringBuffer(toQualifiedRmEntity(rmOriginator,
                rmName, rmEntity))
                .append(AXIS_SEPARATOR)
                .append(toDomainConcept(conceptName, specialisation))
                .append(AXIS_SEPARATOR)
                .append(versionID)
                .toString();
    }

    private static String toDomainConcept(String conceptName,
                                          List<String> specialisation) {
        //return conceptName + ( specialisation == null
        //        ? "" : SECTION_SEPARATOR + specialisation );

        StringBuffer buf = new StringBuffer(conceptName);
        if(specialisation != null && !specialisation.isEmpty()) {
            for(int i = 0, j = specialisation.size(); i < j; i++) {
                buf.append(SECTION_SEPARATOR);
                buf.append(specialisation.get(i));
            }
        }
        return buf.toString();
    }

    private static String toDomainConcept(String conceptName,
                                          String specialisation) {
        return conceptName + ( specialisation == null
                ? "" : SECTION_SEPARATOR + specialisation );
    }

    private static void validateName(String value, String label) {
        if (!NAME_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("wrong format of "
                    + label + ": " + value);
        }
    }

    private static void validateVersionID(String version) {
        if (!VERSION_PATTERN.matcher(version).matches()) {
            throw new IllegalArgumentException(
                    "wrong format of versionID, " + version);
        }
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

    private static String toValue(String rmOriginator, String rmName,
                                  String rmEntity, String conceptName, List<String> specialisation,
                                  String versionID) {
        return new StringBuffer(toQualifiedRmEntity(rmOriginator, rmName,
                rmEntity)).append(AXIS_SEPARATOR).append(
                toDomainConcept(conceptName, specialisation)).append(
                AXIS_SEPARATOR).append(versionID).toString();
    }


    ArchetypeId() {
        super();
    }

    public ArchetypeId(String rmOriginator, String rmName,
                       String rmEntity, String conceptName,
                       String specialisation, String versionId) {
        super(toValue(rmOriginator, rmName, rmEntity, conceptName,
                specialisation, versionId));
        this.qualifiedRmEntity = toQualifiedRmEntity(rmOriginator,
                rmName, rmEntity);
        this.domainConcept = toDomainConcept(conceptName,
                specialisation);
        this.rmOriginator = rmOriginator;
        this.rmName = rmName;
        this.rmEntity = rmEntity;
        this.conceptName = conceptName;
        this.specialisation = new ArrayList<String>();
        if(specialisation != null) {
            this.specialisation.add(specialisation);
        }
        this.versionId = versionId;
        validateAll();
    }


    // Globally qualified reference model entity, e.g. openehr-EHR-OBSERVATION.
    public String qualifiedRmEntity (){
        return qualifiedRmEntity;
    }
    // Name of the concept represented by this archetype, including specialisation, e.g. Biochemistry_result-cholesterol.
    public String domainConcept(){
        return domainConcept;
    }
    // Organisation originating the reference model on which this archetype is based, e.g. openehr, cen, hl7 .
    public String rmOriginator(){
        return rmOriginator;
    }
    // Name of the reference model, e.g. rim, ehr_rm, en13606 .
    public String rmName(){
        return rmName;
    }
    // Name of the ontological level within the reference model to which this archetype is targeted, e.g. for openEHR, folder , composition , section , entry .
    public String rmEntity() {
        return rmEntity;
    }
    // Name of specialisation of concept, if this archetype is a specialisation of another archetype, e.g. cholesterol .
    public List<String> specialisation(){
        return specialisation;
    }
    // Version of this archetype.
    public String versionId(){
        return versionId;
    }

    /* static fields */
    private static final String AXIS_SEPARATOR = ".";
    private static final String SECTION_SEPARATOR = "-";

    private static Pattern NAME_PATTERN =
            Pattern.compile("[a-zA-Z][a-zA-Z0-9()_/%$#&]*");
    private static Pattern VERSION_PATTERN =
            Pattern.compile("[a-zA-Z0-9]+");
}
