package example.com.codeclan.example.todo_list;

import android.content.Context;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.google.gson.InstanceCreator;

/**
 * Created by user on 22/01/2017.
 */

public class SavedListPreferences {

    //makes "savedList" key
    private static final String PREF_SAVEDLIST = "savedList";

    public static void setSavedList(Context context, List list){

        //Gson converts list into Json
        Gson gson = new Gson();
        String listJSON = gson.toJson(list);

        //Saves Json into Shared Preferences
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_SAVEDLIST, listJSON)
                .apply();
    }

    public static List getSavedList(Context context){
        //Retrieves Json from Shared Preferences
        String listJSON = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_SAVEDLIST, null);
        //Changes Json back into java list
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(List.class, new ListDeserializer());
        Gson gson = gsonBuilder.create();
        List list = gson.fromJson(listJSON, List.class);
        return list;
    }
}
