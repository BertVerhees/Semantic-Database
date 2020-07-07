package nl.rosa.semanticdatabase.bmmdata.services.springdatajpa.model_access;

import nl.rosa.semanticdatabase.bmmdata.domain.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmmdata.services.model_access.BmmModelAccessService;
import nl.rosa.semanticdatabase.utils.json.JSONUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Default created on 6-7-2020
 */

class BmmModelAccessSDJpaServiceTest {

    BmmModel bmmModel;
    BmmModel bmmModel2;
    BmmModel bmmModel3;
    String json;
    BmmModelAccessSDJpaService service;

    @BeforeEach
    void setUp() {
        bmmModel = new BmmModel();
        bmmModel.setName("test");
        bmmModel.setRmPublisher("publisher");
        bmmModel.setRmRelease("1.2.3");

        bmmModel2 = new BmmModel();
        bmmModel2.setName("test2");
        bmmModel2.setRmPublisher("publisher2");
        bmmModel2.setRmRelease("1.2.32");
        bmmModel.addUsedModel(bmmModel2);

        bmmModel3 = new BmmModel();
        bmmModel3.setName("test3");
        bmmModel3.setRmPublisher("publisher3");
        bmmModel3.setRmRelease("1.2.33");
        bmmModel.addUsedModel(bmmModel3);
        json = JSONUtils.toJSON(bmmModel);

        service = new BmmModelAccessSDJpaService();
    }

    @Test
    void testInitialize() {
        service.initialize(json);
        assertEquals(bmmModel.modelId(), service.model.get().modelId());
    }

    @Test
    void unInitializedBmmModel() {
        Exception e = assertThrows(RuntimeException.class, () -> {
            service.bmmModel("aaa");
        });
        assertEquals("BmmModelAccessService is not initialized", e.getMessage());
    }

    @Test
    void initializedBmmModel() {
        service.initialize(json);
        assertFalse(service.bmmModel("aaa").isPresent());
        service.initialize(json);
        assertTrue(service.bmmModel(bmmModel.modelId()).isPresent());
        assertTrue(service.bmmModel(bmmModel3.modelId()).isPresent());
        BmmModel bm3 = service.bmmModel(bmmModel3.modelId()).get();
        assertEquals(bm3.getRmPublisher(), bmmModel3.getRmPublisher());
        BmmModel bm2 = service.bmmModel(bmmModel2.modelId()).get();
        assertEquals(bm2.getRmPublisher(), bmmModel2.getRmPublisher());
        BmmModel bm = service.bmmModel(bmmModel.modelId()).get();
        assertEquals(bm.getRmPublisher(), bmmModel.getRmPublisher());
    }

    @Test
    void hasBmmModel() {
        service.initialize(json);
        assertTrue(service.hasBmmModel(bmmModel.modelId()));
        assertTrue(service.hasBmmModel(bmmModel2.modelId()));
    }
}