package example.com.codeclan.example.todo_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    Button newTaskButton;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        //layout for activity
        super.onCreate(savedInstanceState);

        //sets variables in layout
        setContentView(R.layout.activity_list);

        //listView set to listView in layout
        listView = (ListView) findViewById(R.id.activity_list);
        //listener for listView
        listView.setOnItemClickListener(this);

        loadListFromStorage();

        Log.d(getClass().toString(), "ActivityList onCreate");
    }

    @Override
    //makes sure that list updates when task is deleted
    protected void onResume() {
        super.onResume();
        loadListFromStorage();
    }

    private void loadListFromStorage() {
        List list;

        if(SavedListPreferences.getSavedList(this)!=null) {
            list = SavedListPreferences.getSavedList(this);
            Log.d(getClass().toString(), list.getTasks().toString());
        } else {
            list = new List();
            list.setup();
            SavedListPreferences.setSavedList(this, list);
        }

        ArrayList<Listable> taskArrayList = list.getTasks();
        ArrayList<String> taskDescriptions = new ArrayList<>();

        for(int i = 0; i < taskArrayList.size(); i++) {
            Listable task = taskArrayList.get(i);
            Log.d(getClass().toString(), String.valueOf(task.getComplete()));
            taskDescriptions.add(task.getDescription());
            Log.d(getClass().toString(), task.getDescription());
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.items, R.id.items, taskDescriptions);
        listView.setAdapter(adapter);
    }

    public void onItemClick(AdapterView<?> l, View v, int index, long id) {
        List list;
        list = SavedListPreferences.getSavedList(this);

        //creates an ArrayList from list
        ArrayList<Listable> taskArrayList = list.getTasks();

        Listable task = taskArrayList.get(index);

        //gets variables from task
        String description = task.getDescription();
        String details = task.getDetails();
        boolean complete = task.getComplete();

        Log.d(getClass().toString(), description + details + complete);

        //intent to send user to ActivityTask
        Intent intent = new Intent();
        intent.setClass(this, ActivityTask.class);

        intent.putExtra("taskIndex", index);
        intent.putExtra("description", description);
        intent.putExtra("details", details);
        intent.putExtra("complete", complete);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent();

        if(item.getItemId() == R.id.action_new_task){
            intent.setClass(this, ActivityNewTask.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.action_crash){
            throw new RuntimeException("Crash!");
        }
        return super.onOptionsItemSelected(item);
    }

    public void onAddTaskButtonPressed (View button) {
        Log.d(getClass().toString(), "Add task Log here.");
        Intent intent = getIntent();
        intent.setClass(this, ActivityNewTask.class);
        startActivity(intent);
    }
}
