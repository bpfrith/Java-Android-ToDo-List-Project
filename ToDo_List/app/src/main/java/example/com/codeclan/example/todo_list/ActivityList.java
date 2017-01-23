package example.com.codeclan.example.todo_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by user on 22/01/2017.
 */

public class ActivityList extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.activity_list);

        List list;

        if(SavedListPreferences.getSavedList(this)!=null) {
            list = SavedListPreferences.getSavedList(this);
            Log.d(getClass().toString(), list.getTasks().toString());
            }else{
            list = new List();
            list.setup();
            SavedListPreferences.setSavedList(this, list);
        }

        ArrayList<Listable> taskArrayList = list.getTasks();
        ArrayList<String> taskDescriptions = new ArrayList<>();

        for(int i = 0; i < taskArrayList.size(); i++) {
            Listable task = taskArrayList.get(i);
            Log.d(getClass().toString(), String.valueOf(task.getComplete()));
            if (!task.getComplete() && task.getDescription() != null){
                taskDescriptions.add(Listable.getDescription());
                Log.d(getClass().toString(), task.getDescription());
                Log.d(getClass().toString(), taskDescriptions[i]);
            }
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.items, taskDescriptions);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        Log.d(getClass().toString(), "ActivityList onCreate");
    }

//    public void onItemClick(AdapterView<?> l, View v, int index, long id) {
//        List list;
//        list = SavedListPreferences.getSavedList(this);
//
//        ArrayList<Listable> taskArrayList = list.getTasks();
//        Listable task = taskArrayList.get(index);
//
//        String description = task.getDescription();
//        String details = task.getDetails();
//        boolean complete = task.getComplete();
//
//        Log.d(getClass().toString(), description + details + complete);
//
//        Intent intent = new Intent();
//        intent.setClass(this, ActivityTask.class);
//
//        intent.putExtra("taskIndex", index);
//        intent.putExtra("headline", description);
//        intent.putExtra("description", details);
//        intent.putExtra("complete", complete);
//
//        startActivity(intent);
//    }
}
