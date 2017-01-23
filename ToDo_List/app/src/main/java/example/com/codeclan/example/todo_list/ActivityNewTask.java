package example.com.codeclan.example.todo_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Created by user on 23/01/2017.
 */

public class ActivityNewTask extends AppCompatActivity{

    EditText descriptionEditText;
    EditText detailsEditText;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();

        if(item.getItemId() == R.id.action_new_task) {
            intent.setClass(this, ActivityNewTask.class);

            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
