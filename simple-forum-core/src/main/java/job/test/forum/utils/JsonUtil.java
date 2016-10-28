package job.test.forum.utils;

import com.google.gson.*;

/**
 * Created by zuhai.jiang on 2016/5/6.
 */
public class JsonUtil {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static String toJson(Object obj){
        return gson.toJson(obj);
    }

    public static JsonElement parseJson(String json){
        JsonParser parser = new JsonParser();
        JsonElement ele = parser.parse(json);
        return ele;
    }

    public static <T> T fromJson(String json, Class<T> c){
        return gson.fromJson(json, c);
    }

    public static JsonObject parseJsonObject(String json){
        return (JsonObject) parseJson(json);
    }

    public static JsonArray parseJsonArray(String json){
        return (JsonArray) parseJson(json);
    }


    public static Integer getInt(JsonObject json, String member){
        JsonElement ele = json.get(member);
        if (ele != null && !ele.isJsonNull()) {
            return ele.getAsInt();
        }
        return null;
    }

    public static String getString(JsonObject json, String member){
        JsonElement ele = json.get(member);
        if (ele != null && !ele.isJsonNull()) {
            return ele.getAsString();
        }
        return null;
    }

    public static Boolean getBoolean(JsonObject json, String member){
        JsonElement ele = json.get(member);
        if (ele != null && !ele.isJsonNull()) {
            return ele.getAsBoolean();
        }
        return null;
    }

    public static Double getDouble(JsonObject json, String member){
        JsonElement ele = json.get(member);
        if (ele != null && !ele.isJsonNull()) {
            return ele.getAsDouble();
        }
        return null;
    }

    public static JsonObject getJsonObject(JsonObject json, String member){
        JsonElement ele = json.get(member);
        if (ele != null && !ele.isJsonNull()) {
            return ele.getAsJsonObject();
        }
        return null;
    }

    public static Gson getGson(){
        return gson;
    }
}
