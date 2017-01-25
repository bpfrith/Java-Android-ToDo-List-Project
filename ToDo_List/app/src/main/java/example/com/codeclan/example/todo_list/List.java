package example.com.codeclan.example.todo_list;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by user on 21/01/2017.
 */

public class List  {

    ArrayList<Listable> tasks;

    public List(){
        tasks = new ArrayList<>();
    }

    public List(ArrayList<Listable> tasks) {
        this.tasks = tasks;
    }

    public int numberOfTasks() {
        return tasks.size();
    }

    public void addTask(Listable task) {
        tasks.add(task);
    }

    public void removeTask(Listable task) {
        tasks.remove(task);
    }

    public ArrayList<Listable> getTasks(){
        return tasks;
    }

    public void setup(){
        tasks.add(new Task("Hide Chocolate before Bethany gets home from work.", false));
        tasks.add(new Task("Fix bugs.", false));
        tasks.add(new Task("Learn Simpsons made up words.", false));
        tasks.add(new Task("Teach Cohort 9 the Goblin song.", false));
    }
}
