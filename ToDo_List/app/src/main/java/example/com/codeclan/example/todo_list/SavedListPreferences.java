package example.com.codeclan.example.todo_list;

import android.content.Context;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.InstanceCreator;

/**
 * Created by user on 22/01/2017.
 */

public class SavedListPreferences {

    private static final String PREF_SAVEDLIST = "savedList";

    public static void setStoredList(Context context, List list){

        Gson gson = new Gson();
        String listJSON = gson.toJson(list);

        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_SAVEDLIST, listJSON)
                .apply();
    }

    public static List getStoredList(Context context){
        String listJSON = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_SAVEDLIST, null);
        Gson gson = new Gson();
        List list = gson.fromJson(listJSON, List.class);
        return list;
    }
}
