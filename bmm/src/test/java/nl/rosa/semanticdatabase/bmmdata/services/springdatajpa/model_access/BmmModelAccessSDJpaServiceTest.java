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
        json = JSONUtils.toJSON(bmmModel);

        service = new BmmModelAccessSDJpaService();
    }

    @Test
    void testInitialize() {
        service.initialize(json);
        assertEquals(bmmModel, service.model);
    }

    @Test
    void bmmModel() {
        service.initialize(json);
        assertEquals(bmmModel2, service.model.modelId());
    }

    @Test
    void hasBmmModel() {
    }
}