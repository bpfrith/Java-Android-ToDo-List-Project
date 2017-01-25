package example.com.codeclan.example.todo_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user on 23/01/2017.
 */

public class ActivityNewTask extends AppCompatActivity{

    EditText descriptionEditText;
    EditText detailsEditText;

    public void onCreate(Bundle savedInstanceState) {
        //gets layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        //sets variables in layout
        descriptionEditText = (EditText) findViewById(R.id.description_edit_text);
        detailsEditText = (EditText) findViewById(R.id.details_edit_text);
    }

    public void onSaveNewTaskButtonPressed(View button) {
        Intent intent = new Intent();
        intent.setClass(this, ActivityList.class);

        //set variables to what the user enters
        String newDesciption = descriptionEditText.getText().toString();
        String newDetails = detailsEditText.getText().toString();

        //create new task
        Listable newTask = new Task(newDesciption, newDetails, false);


        List list;
        list = SavedListPreferences.getSavedList(this);

        //Adds new task to list
        list.addTask(newTask);
        //save
        SavedListPreferences.setSavedList(this, list);

        //Redirects user to ActivityList with intent
        startActivity(intent);
    }
}
