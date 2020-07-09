package nl.rosa.semanticdatabase.utils.map;

import nl.rosa.semanticdatabase.utils.json.JSONUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Default created on 9-7-2020
 */

public class MapUtils {
    public static void addStringObjectItemToMap(Map<String, String> map, String key, Object value){
        if(map==null){
            map = new HashMap<>();
        }
        if(value instanceof String){
            map.put(key, (String) value);
        }else{
            map.put(key, JSONUtils.toJSON(value));
        }
    }
}
