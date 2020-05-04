package nl.rosa.semanticdatabase.base.support.identification;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArchetypeIdTest {

    @Test
    public void buildValidArchetypeId() {
        ArchetypeId archetypeId = new ArchetypeId(
                "archie.test.namespace::testRmPublisher-testRmPackage-testRmClass.testConceptId.v1.2.3-rc.42");
        assertEquals("archie.test.namespace",archetypeId.getNamespace());
        assertEquals("testRmPublisher",archetypeId.getRmOriginator());
        assertEquals("testRmPackage",archetypeId.getRmName());
        assertEquals("testRmClass",archetypeId.getRmEntity());
        assertEquals("testConceptId",archetypeId.getDomainConcept());
        assertEquals("1.2.3-rc.42",archetypeId.getVersionId());
        assertEquals("archie.test.namespace::testRmPublisher-testRmPackage-testRmClass.testConceptId.v1.2.3-rc.42",
                archetypeId.getFullId());
        assertEquals("archie.test.namespace::testRmPublisher-testRmPackage-testRmClass.testConceptId.v1",
                archetypeId.getSemanticId());

        archetypeId = new ArchetypeId(
                "archie.test.namespace::testRmPublisher-testRmPackage-testRmClass.testConceptId.v");
        assertEquals("archie.test.namespace",archetypeId.getNamespace());
        assertEquals("testRmPublisher",archetypeId.getRmOriginator());
        assertEquals("testRmPackage",archetypeId.getRmName());
        assertEquals("testRmClass",archetypeId.getRmEntity());
        assertEquals("testConceptId",archetypeId.getDomainConcept());
        assertEquals("",archetypeId.getVersionId());
        assertEquals("archie.test.namespace::testRmPublisher-testRmPackage-testRmClass.testConceptId.v",
                archetypeId.getFullId());
        assertEquals("archie.test.namespace::testRmPublisher-testRmPackage-testRmClass.testConceptId.v",
                archetypeId.getSemanticId());


        archetypeId = new ArchetypeId(
                "archie.test.namespace::testRmPublisher-testRmPackage-testRmClass.testConceptId");
        assertEquals("archie.test.namespace",archetypeId.getNamespace());
        assertEquals("testRmPublisher",archetypeId.getRmOriginator());
        assertEquals("testRmPackage",archetypeId.getRmName());
        assertEquals("testRmClass",archetypeId.getRmEntity());
        assertEquals("testConceptId",archetypeId.getDomainConcept());
        assertNull(archetypeId.getVersionId());
        assertEquals("archie.test.namespace::testRmPublisher-testRmPackage-testRmClass.testConceptId",
                archetypeId.getFullId());
        assertEquals("archie.test.namespace::testRmPublisher-testRmPackage-testRmClass.testConceptId",
                archetypeId.getSemanticId());


        archetypeId = new ArchetypeId(
                "testRmPublisher-testRmPackage-testRmClass.testConceptId");
        assertNull(archetypeId.getNamespace());
        assertEquals("testRmPublisher",archetypeId.getRmOriginator());
        assertEquals("testRmPackage",archetypeId.getRmName());
        assertEquals("testRmClass",archetypeId.getRmEntity());
        assertEquals("testConceptId",archetypeId.getDomainConcept());
        assertNull(archetypeId.getVersionId());
        assertEquals("testRmPublisher-testRmPackage-testRmClass.testConceptId",
                archetypeId.getFullId());
        assertEquals("testRmPublisher-testRmPackage-testRmClass.testConceptId",
                archetypeId.getSemanticId());

    }

    @Test
    public void buildInvalidArchetypeId() {
        List<String> invalidArchetypeIds = new ArrayList<>();
        invalidArchetypeIds.add("archie.test.namespace::testRmPublisher-testRmPackage-testRmClass.v1.2.3-rc.42");
        invalidArchetypeIds.add("archie.test.namespace::testRmPublisher-testRmPackage-testRmClass-someString.testConceptId.v1.2.3");
        invalidArchetypeIds.add("testRmPublisher_testRmPackage_testRmClass-someString.testConceptId.v1.2.3");
        invalidArchetypeIds.add("testRmPublisher-testRmPackage-testRmClass-someString..testConceptId.v1.2.3");
        invalidArchetypeIds.add("testRmPackage-testRmClass.testConceptId.v1.2.3");

        for (String ArchetypeId : invalidArchetypeIds) {
            try {
                new ArchetypeId(ArchetypeId);
                fail("Should not be able to construct ArchetypeHRID from " + ArchetypeId);
            } catch (IllegalArgumentException e) {
                //Nothing to be done here
            }
        }
    }

}

