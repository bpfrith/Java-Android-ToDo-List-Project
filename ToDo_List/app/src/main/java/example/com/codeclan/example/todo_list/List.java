package example.com.codeclan.example.todo_list;

import java.util.ArrayList;

/**
 * Created by user on 21/01/2017.
 */

public class List{

    ArrayList<Listable> tasks;

    public List(){
        tasks = new ArrayList<>();
    }

    public int numberOfTasks() {
        return tasks.size();
    }
}
