package example.com.codeclan.example.todo_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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


}
