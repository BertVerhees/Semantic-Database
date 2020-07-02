package nl.rosa.semanticdatabase.utils.json;

import com.google.gson.Gson;

/**
 * Default created on 2-7-2020
 */

public final class JSONUtils {
    private static final Gson gson = new Gson();

    private JSONUtils(){}

    public static boolean isJSONValid(String jsonInString) {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch(com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    public static String toJSON(Object object){
        return gson.toJson(object);
    }

    public static Object fromJSON(String object){
        return gson.fromJson(object, Object.class);
    }
}
