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

    public static boolean isJSONValid(String jsonInString, Class clasz) {
        try {
            gson.fromJson(jsonInString, clasz);
            return true;
        } catch(com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    public static String toJSON(Object object){
        return gson.toJson(object);
    }

    public static Object fromJSON(String object, Class clasz){
        return gson.fromJson(object, clasz);
    }
}
