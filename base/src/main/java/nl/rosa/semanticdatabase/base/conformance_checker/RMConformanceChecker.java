package nl.rosa.semanticdatabase.base.conformance_checker;

import java.util.Map;

/**
 * Default created on 27-11-2020
 */

public interface RMConformanceChecker {

    public default Boolean rmConformanceChecker(Map<String,String> map, Boolean b){
        //TODO
        return false;
    }

}
