package example.com.codeclan.example.todo_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by user on 22/01/2017.
 */

public class ActivityList extends AppCompatActivity{

    private ListView listView;
    private ArrayList<String> taskDescriptions;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.activity_list);

        List list;

        if(SavedListPreferences.getStoredList(this)!=null){
            list = SavedListPreferences.getStoredList(this);
        }else{
            list = new List();
            SavedListPreferences.getStoredList(this, list);
        }

        ArrayList<Listable> taskArrayList = list.getTasks();
        String[] taskDescriptions = new String[taskArrayList.size()];

        for(int i = 0; i < taskArrayList.size(); i++){
            Task task = taskArrayList.get(i);
            if(task.getComplete()){
                taskDescriptions[i] = task.getDescription() + " - Complete";
            }else{
                taskDescriptions[i] = task.getDescription();
            }
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.items, taskDescriptions);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }
}
