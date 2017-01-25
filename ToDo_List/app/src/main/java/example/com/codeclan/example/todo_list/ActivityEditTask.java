package example.com.codeclan.example.todo_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.button;
import static example.com.codeclan.example.todo_list.R.id.save_button;

/**
 * Created by user on 25/01/2017.
 */

public class ActivityEditTask extends AppCompatActivity{
    EditText descriptionEditText;
    EditText detailsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        descriptionEditText = (EditText)findViewById(R.id.description_edit_text);
        detailsEditText = (EditText)findViewById(R.id.details_edit_text);
    }

    @Override
    protected void onEditTaskButtonPressed(Context context){
        Log.d(getClass().toString(), "deleteButton Log here.");

        //retrieves intent and extras from previous activity
        Intent oldIntent = getIntent();
        Bundle extras = oldIntent.getExtras();

        //assigns task index from extras to variable
        final int taskIndex = extras.getInt("taskIndex");
        final List oldList;

        //set variable to saved list
        oldList = SavedListPreferences.getSavedList(this);
        ArrayList<Listable> tasks = oldList.getTasks();
//        deleteButton = (Button) findViewById(R.id.action_delete);

        // finds action selected
        Listable task = tasks.get(taskIndex);
        Log.d(getClass().toString(), "" + task.getDescription());

        //call remove on task
        oldList.removeTask(task);

        //save
        SavedListPreferences.setSavedList(this, oldList);

        //back to main
//        finish();

        Intent newIntent = new Intent();
        newIntent.setClass(this, ActivityList.class);

        String newDesciption = descriptionEditText.getText().toString();
        String newDetails = detailsEditText.getText().toString();

        Listable newTask = new Task(newDesciption, newDetails, false);

        List newList;
        newList = SavedListPreferences.getSavedList(this);

        newList.addTask(newTask);
        SavedListPreferences.setSavedList(this, newList);

        startActivity(newIntent);

        finish();
    }
}
