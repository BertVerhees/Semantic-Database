package nl.rosa.semanticdatabase.referencemodel.model_access;

import nl.rosa.semanticdatabase.referencemodel.model.BmmModel;
import nl.rosa.semanticdatabase.referencemodel.model.BmmPackageContainer;
import org.junit.Test;

/**
 * Default created on 5-5-2020
 */

public class BmmModelAccessTest {

    @Test
    public void hasBmmModel(){
        BmmModelAccess bmmModelAccess = new BmmModelAccess();
        BmmModel p1b1 = new BmmModel("p1","1.0.1", BmmPackageContainer.builder().name("name").build());
        BmmModel p1b2 = new BmmModel("p1","1.0.2", BmmPackageContainer.builder().name("name").build());
        BmmModel p1b3 = new BmmModel("p1","1.0.3", BmmPackageContainer.builder().name("name").build());
        BmmModel p2b1 = new BmmModel("p2","1.0.1", BmmPackageContainer.builder().name("name").build());
        BmmModel p2b2 = new BmmModel("p2","1.0.2", BmmPackageContainer.builder().name("name").build());
        BmmModel p2b3 = new BmmModel("p2","1.0.3", BmmPackageContainer.builder().name("name").build());
    }
}
