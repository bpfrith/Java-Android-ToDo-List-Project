package example.com.codeclan.example.todo_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 22/01/2017.
 */

public class ActivityTask extends AppCompatActivity{

    private TextView descriptionTextView;
    private TextView detailsTextView;
    private TextView completeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String description = extras.getString("Description");
        String details = extras.getString("Details");
        boolean complete = extras.getBoolean("Complete");

        descriptionTextView = (TextView) findViewById(R.id.description_text_view);
        detailsTextView = (TextView) findViewById(R.id.details_text_view);
        completeTextView = (TextView) findViewById(R.id.complete_text_view);

        descriptionTextView.setText("Description");
        detailsTextView.setText("Details");

        if (complete) {
            completeTextView.setText("Complete");
        } else {
            completeTextView.setText("Incomplete");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_taskmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_toggle_complete){
            List list;
            list = SavedListPreferences.getStoredList(this);
            ArrayList<Task> taskArrayList = List.getTasks();

            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            int taskIndex = extras.getInt("taskIndex");

            Task task = taskArrayList.get(taskIndex);
            task.cycleComplete();
            SavedListPreferences.setStoredList(this, List);
        }
        return super.onOptionsItemSelected(item);
        }
}
