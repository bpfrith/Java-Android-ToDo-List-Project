package example.com.codeclan.example.todo_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

import static android.R.attr.button;

/**
 * Created by user on 22/01/2017.
 */

public class ActivityTask extends AppCompatActivity {

    private TextView descriptionTextView;
    private TextView detailsTextView;
    private TextView completeTextView;
    Button completeButton;
    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //gets layout
        setContentView(R.layout.activity_task);

        //gets intent and extras from previous activity
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        //sets variables
        String description = extras.getString("description");
        String details = extras.getString("details");
        boolean complete = extras.getBoolean("complete");

        //sets variables in layout
        descriptionTextView = (TextView) findViewById(R.id.description_text_view);
        detailsTextView = (TextView) findViewById(R.id.details_text_view);
        completeTextView = (TextView) findViewById(R.id.complete_text_view);

        descriptionTextView.setText(description);
        detailsTextView.setText(details);

        if (complete) {
            completeTextView.setText("Complete");
        } else {
            completeTextView.setText("Incomplete");
        }

        completeButton = (Button) findViewById(R.id.action_cycle_complete);
        deleteButton = (Button) findViewById(R.id.action_delete);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_task_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            return true;
        }
        //gets previous intent and extras
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        //sets variables from extras
        final int taskIndex = extras.getInt("taskIndex");
        final List list;

        //get a list from saved list
        list = SavedListPreferences.getSavedList(this);
        ArrayList<Listable> tasks = list.getTasks();

        //gets correct task
        if (item.getItemId() == R.id.action_cycle_complete) {
            Listable task = tasks.get(taskIndex);

            //toggle complete and updates
            task.cycleComplete();
            boolean complete = task.getComplete();
            String completeText = complete ? "Complete" : "Incomplete";
            completeTextView.setText(completeText);

            //saves
            SavedListPreferences.setSavedList(this, list);
        }else if(item.getItemId() == R.id.action_delete){

            Listable task = tasks.get(taskIndex);

            list.removeTask(task);

            SavedListPreferences.setSavedList(this, list);

            finish();

        }else if (item.getItemId() == R.id.action_crash) {
            throw new RuntimeException("Crash!");
        }
        return super.onOptionsItemSelected(item);
    }

    public void onCompleteButtonPressed(View button) {
        Log.d(getClass().toString(), "completeButton Log here.");

        //retrieves intent and extras from previous activity
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        //assigns task index from extras to variable
        final int taskIndex = extras.getInt("taskIndex");
        final List list;

        //set variable to saved list
        list = SavedListPreferences.getSavedList(this);
        ArrayList<Listable> tasks = list.getTasks();

        //finds action selected
        completeButton = (Button) findViewById(R.id.action_cycle_complete);
        Listable task = list.getTasks().get(taskIndex);
        Log.d(getClass().toString(), "" + task.getComplete());

        //calls cycle complete on task
        task.cycleComplete();
        boolean complete = task.getComplete();
        Log.d(getClass().toString(), "" + complete);

        //Updates text without refreshing activity
        String completeText = task.getComplete() ? "Complete" : "Incomplete";
        completeTextView.setText(completeText);
        //saves
        list.setTasks(tasks);
        SavedListPreferences.setSavedList(this, list);
    }


    public void onDeleteButtonPressed(View button) {
        Log.d(getClass().toString(), "deleteButton Log here.");

        //retrieves intent and extras from previous activity
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        //assigns task index from extras to variable
        final int taskIndex = extras.getInt("taskIndex");
        final List list;

        //set variable to saved list
        list = SavedListPreferences.getSavedList(this);
        ArrayList<Listable> tasks = list.getTasks();
        deleteButton = (Button) findViewById(R.id.action_delete);

        // finds action selected
        Listable task = tasks.get(taskIndex);
        Log.d(getClass().toString(), "" + task.getDescription());

        //call remove on task
        list.removeTask(task);

        //save
        SavedListPreferences.setSavedList(this, list);

        //back to main
        finish();
    }

//    public void onEditTaskButtonPressed (View button) {
//        Log.d(getClass().toString(), "Add edit task Log here.");
//        Intent intent = getIntent();
//        intent.setClass(this, ActivityEditTask.class);
//        startActivity(intent);
//    }

    @Override
    public void onResume(){
        super.onResume();
    }
}
