package example.com.codeclan.example.todo_list;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by user on 24/01/2017.
 */

public class ListDeserializer implements JsonDeserializer<List> {

    @Override
    public List deserialize(JsonElement json, Type type,
                            JsonDeserializationContext context) throws JsonParseException {
        JsonObject jobject = (JsonObject) json;
        JsonArray tasksJson = jobject.get("tasks").getAsJsonArray();

        List list = new List();
        for (JsonElement taskJson : tasksJson) {
            String description = taskJson.getAsJsonObject().get("description").getAsString();
            Task task = new Task(description);
            list.addTask(task);
        }

        return list;
    }
}
