package example.com.codeclan.example.todo_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by user on 23/01/2017.
 */

public class ActivityNewTask extends AppCompatActivity{

    EditText descriptionEditText;
    EditText detailsEditText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        descriptionEditText = (EditText) findViewById(R.id.description_edit_text);
//        detailsEditText = (EditText) findViewById(R.id.details_edit_text);
    }


    public void onSaveNewTaskButtonPressed(View button) {
        Intent parentIntent = new Intent();
        parentIntent.setClass(this, ActivityList.class);

        String newTaskHeadline = descriptionEditText.getText().toString();
        String newTaskDescription = detailsEditText.getText().toString();

        Listable newTask = new Task(newTaskDescription);

        List list;
        list = SavedListPreferences.getSavedList(this);


        list.addTask(newTask);
        SavedListPreferences.setSavedList(this, list);

        startActivity(parentIntent);
    }
}
